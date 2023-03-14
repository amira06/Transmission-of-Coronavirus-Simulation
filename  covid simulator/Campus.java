import javax.swing.*;
import java.awt.*;

/**
 * The purpose of campus class is create the campus for this project
 */
 
public class Campus {
    private Cell[][] cells;
    private JPanel panel;
    boolean[][] wallLocations;

    public static final  int  NUMBER_OF_ROWS = 20;
    public static final  int  NUMBER_OF_COLUMNS = 40;
    public static final  int  CELL_SIZE= 30;


    public Campus(boolean[][] start)
    {
        wallLocations = start;
    }
    
    public void initializeCampus(){

        panel = new JPanel(new GridLayout(NUMBER_OF_ROWS,NUMBER_OF_COLUMNS));
        cells = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for(int ii = 0; ii< NUMBER_OF_ROWS; ii++){
            for(int jj = 0; jj<NUMBER_OF_COLUMNS; jj++){
                
                cells[ii][jj] = new Cell(ii,jj,wallLocations[ii][jj]);
                panel.add(cells[ii][jj].getButton());
            }
        }
    }


    public void showCampus(){
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public Cell getCell(int row, int col)
    {
        return cells[row][col];
    }

    public void addCitizen(Citizen citizen, int row, int col)
    {
        Cell cc = cells[row][col];
        cc.addCitizen(citizen);
        citizen.setCell(cc);
    }

}