import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;

/**
 * The purpose of Citizen is to set up how people the people on campus interact with each other, the people that are infected, the people thet recovered and the people that are deseased.
 * 
 */


public class Citizen {

    private String name;
    public final int ID;
    protected Cell currentCell;
    private boolean isWearingMask;
    protected int infectionStatus;
    protected Campus campus;
    private int infectedTurnCounter; 
    private int infectionDuration = 50; 
    public static final int SUSCEPTIBLE = 0;
    public static final int INFECTED = 1;
    public static final int RECOVERED = 3;
    public static final int DECEASED = 6; 

    public static final double MASKED_TRANSMISSION_PROBABILITY = 0.10;
    public static final double UNMASKED_TRANSMISSION_PROBABILITY = 0.80;
    public static final double MASKED_PROTECTION_FACTOR = 0.50;
   
    public static final Color CITIZEN_HEALTHY_COLOR = new Color(0,102,0);
    public static final Color CITIZEN_RECOVERED_COLOR = new Color(255,102,2); 

    private static int idCount = 1; 

    private static final int[][] possibleMoves = {
        {-1,0},
        {-1,1},
        {-1,-1},
        {1,-1},
        {1,0},
        {1,1},
        {0,1},
        {0,-1}  
    };

    public static final Random randomNumberGenerator = new Random();

    public Citizen(String myName, boolean masked, int startingInfectionStatus, Campus newCampus, int startRow, int startColumn )
    {
        name = myName;
        currentCell = null;
        isWearingMask = masked;
        infectionStatus = startingInfectionStatus;
        campus = newCampus;
        campus.addCitizen(this,startRow,startColumn);
        infectedTurnCounter = 0;
        ID = idCount;
        idCount ++;

    }

    public void move()
    {
        if(getInfectionStatus() != DECEASED)
        {
            ArrayList<Cell> availableCells = new ArrayList<Cell>();
            availableCells.add(currentCell);
            int row = currentCell.getRow();
            int col = currentCell.getCol();

            for(int[] possibleMove : possibleMoves)
            {
                int newRow = row + possibleMove[0];
                int newCol = col + possibleMove[1];

                if(newRow >= 0 && newRow < Campus.NUMBER_OF_ROWS && newCol >= 0 && newCol < Campus.NUMBER_OF_COLUMNS)
                {
                    Cell potentialCell = campus.getCell(newRow, newCol);
                    if(potentialCell.getAvailability() && !potentialCell.isWallCell())
                    {
                        availableCells.add(potentialCell);
                    }
                }
            }

            int nn = availableCells.size();
            int randomIndex = randomNumberGenerator.nextInt(nn);
            Cell oldCell = currentCell;
            Cell newCell = availableCells.get(randomIndex);
            setCell(newCell);
            oldCell.removeCitizen();
            newCell.addCitizen(this);
            doYourThing();

            Tester.pause(Tester.sleepTime);
        }
    }

    public void doYourThing()
    {
        if(infectionStatus == INFECTED)
        {
            infectedTurnCounter++;
            if(infectedTurnCounter < infectionDuration)
            {
                ArrayList<Citizen> neighbors = this.getListOfNeighbors();
                Random deathChance = new Random();
                if(neighbors.size() > 0)
                {
                    this.getCell().brieflyYellow();
                    cough();
                }
                if(infectedTurnCounter >= infectionDuration*0.8 && deathChance.nextInt(100) < 5)
                {
                infectionStatus = DECEASED;
                currentCell.removeCitizen();
                }
            }
            else
            {
                changeInfectionStatus(RECOVERED);
            }
        }
    }

    public void cough()
    {
        ArrayList<Citizen> neighbors = getListOfNeighbors();
        for(Citizen cc : neighbors)
        {
            this.coughAt(cc);
            cc.react();
        }
    }

     public void react()
     {
        
     }


    public void coughAt(Citizen potentialVictim)
    {
        if(this.infectionStatus == Citizen.INFECTED && potentialVictim.getInfectionStatus() == Citizen.SUSCEPTIBLE)
        {
            double threshold;
            if(this.isWearingMask)
            {
                threshold = MASKED_TRANSMISSION_PROBABILITY;
            }
            else
            {
                threshold = UNMASKED_TRANSMISSION_PROBABILITY;
            }
            if(potentialVictim.isWearingMask)
            {
                threshold *= MASKED_PROTECTION_FACTOR;
            }

            double rand = randomNumberGenerator.nextDouble();

            if(rand < threshold)
            {
                potentialVictim.changeInfectionStatus(Citizen.INFECTED);
            }
        }
    }

    public ArrayList<Citizen> getListOfNeighbors()
    {
        ArrayList<Citizen> neighbors = new ArrayList<Citizen>();
        int row = currentCell.getRow();
        int col = currentCell.getCol();

        for(int[] possibleMove : possibleMoves)
        {
            int newRow = row + possibleMove[0];
            int newCol = col + possibleMove[1];

            if(newRow >= 0 && newRow < Campus.NUMBER_OF_ROWS && newCol >= 0 && newCol < Campus.NUMBER_OF_COLUMNS)
            {
                Cell potentialCell = campus.getCell(newRow, newCol);
                if(!potentialCell.getAvailability() && !potentialCell.isWallCell())
                {
                    neighbors.add(potentialCell.getCitizen());
                }
            }
            
        }

        return neighbors;
    }

    public Color getHealthyColor()
    {
        return CITIZEN_HEALTHY_COLOR;
    }
    
    public Color getRecoveredColor()
    {
        return CITIZEN_RECOVERED_COLOR;
    }
    
    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public Cell getCell()
    {
        return currentCell;
    }

    public boolean isWearingMask()
    {
        return isWearingMask;
    }

    public int getInfectionStatus()
    {
        return infectionStatus;
    }

    public void setCell(Cell newCell)
    {
        currentCell = newCell;
    }
    public void changeMaskStatus(boolean masked)
    {
        isWearingMask = masked;
    }
    
    public void changeInfectionStatus(int newStatus)
    {
        infectionStatus = newStatus;
    }

    /**
     * Sets the color of the button
     * @param cell TODO
     * @param newColor TODO
     * 
     */
    
    public void setColor(Cell cell, Color newColor)
    {
        cell.button.setBackground(newColor);
    }
}
