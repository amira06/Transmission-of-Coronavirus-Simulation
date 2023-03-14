import java.awt.Color;
import java.util.ArrayList;

/**
 * this is the nurse class that extend the citizen which sets up how people interact with each other. this nurse class is for the user the user-controlled person, it can heal thoese people that are infected.
 */

 public class Nurse extends Citizen
{
 public static final Color NURSE_HEALTHY_COLOR = new Color(255,0,255);

 
    public Nurse(String myName, boolean masked, int startingInfectionStatus, Campus newCampus, int startRow, int startColumn )
    {
        super( myName,  masked,  startingInfectionStatus,  newCampus,  startRow,  startColumn );
    }

    public void move(int dx, int dy)
    {
        System.out.println("well done!");
        int row = currentCell.getRow();
        int col = currentCell.getCol();

        int newRow = row + dy;
        int newCol = col + dx;

        if(newRow >= 0 && newRow < Campus.NUMBER_OF_ROWS && newCol >= 0 && newCol < Campus.NUMBER_OF_COLUMNS)
        {
            Cell potentialCell = campus.getCell(newRow, newCol);
            if(potentialCell.getAvailability() && !potentialCell.isWallCell())
            {

            Cell oldCell = currentCell;
            Cell newCell = potentialCell;
            setCell(newCell);
            oldCell.removeCitizen();
            newCell.addCitizen(this);

            doYourThing();
            }
        }
        
   }

    @Override
    public Color getHealthyColor() {
        return NURSE_HEALTHY_COLOR;
    }

    @Override
    public void doYourThing()
    {
        infectionStatus = Citizen.RECOVERED;
        ArrayList<Citizen> neighbors = this.getListOfNeighbors();

            if(neighbors.size() > 0)
            {
                for(Citizen nn : neighbors)
                {
                    if(nn.getInfectionStatus() == Citizen.INFECTED)
                    {
                        nn.changeInfectionStatus(Citizen.RECOVERED);
                    }
                }
            }

    }

 }
