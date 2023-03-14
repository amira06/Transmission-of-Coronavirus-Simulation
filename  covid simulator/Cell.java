import javax.swing.*;
import java.awt.*;

public class Cell{

    public static final Color WALL_COLOR = Color.BLACK;
    public static final Color EMPTY_COLOR = Color.GRAY;
    public static final Color INFECTED_COLOR = Color.RED;
    public static final Color DO_YOUR_THING_COLOR = Color.YELLOW;
    
    JButton button;
    private boolean occupied;
    private boolean isWallCell;
    private final int row;
    private final int col;
    private Citizen currentCitizen;

    public Cell(int rr, int cc, boolean wallCell)
    {
        row = rr;
        col = cc;
        occupied = false;
        isWallCell = wallCell;
        button = new JButton();
        button.setPreferredSize(new Dimension(Campus.CELL_SIZE,Campus.CELL_SIZE));
        button.setMargin(new Insets(0,0,0,0));
        if(isWallCell == true)
        {
            button.setBackground(WALL_COLOR);
        }
        else
        {
            button.setBackground(EMPTY_COLOR);
        }
        currentCitizen = null;
    }
    public JButton getButton() {
        return button;
    }
    public void setText(String text)
    {
        button.setText(text);
    }
    public boolean getAvailability(){
        return !occupied;
    }

    public boolean isWallCell() {
        return isWallCell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public void addCitizen(Citizen citizen)
    {
        currentCitizen= citizen;
        occupied = true;
        if(citizen.isWearingMask())
        {
            button.setText("Y");

        }
        else
        {
            button.setText("N");
        }
        if(citizen.getInfectionStatus() == Citizen.INFECTED)
        {
            button.setBackground(INFECTED_COLOR);
        }
        else if(citizen.getInfectionStatus() == Citizen.RECOVERED)
        {
            button.setBackground(citizen.getRecoveredColor());
        }
        else
        {
            button.setBackground(citizen.getHealthyColor());
        }
    }

    public void removeCitizen()
    {
        currentCitizen= null;
        occupied = false;
        button.setBackground(EMPTY_COLOR);
        button.setText("");
    }

    public Citizen getCitizen()
    {
        return currentCitizen;
    }

    public void brieflyYellow()
    {
        Color oldColor = button.getBackground();
        button.setBackground(DO_YOUR_THING_COLOR);
        Tester.pause(Tester.sleepTime);
        button.setBackground(oldColor);
    }
}
