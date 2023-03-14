import java.awt.Color;
import java.util.ArrayList;

/**
 * the purpose of this class is to create citizens that do not stay protected and go around to effect others, they do not follow the rules when they are not being monitored by the Maskauthorithy.      
 */


public class SuperSpreader extends Citizen 
{
    public static final Color SUPERSPREADER_HEALTHY_COLOR = new Color(0,0,255); // blue
    
    /**
     * @param myName
     * @param masked
     * @param startingInfectionStatus
     * @param newCampus
     * @param startRow
     * @param startColumn 
     * Constructor similr to citizen class
     */
    public SuperSpreader(String myName, boolean masked, int startingInfectionStatus, Campus newCampus, int startRow, int startColumn) {
        super(myName, masked, startingInfectionStatus, newCampus, startRow, startColumn);
    }

    @Override
    public void doYourThing()
    {
        super.doYourThing();
        ArrayList<Citizen> superSpreaderNeighbors = this.getListOfNeighbors();
        for(Citizen cc : superSpreaderNeighbors)
        {
            if(!(cc instanceof MaskAuthority) && isWearingMask() == true)
            {
                changeMaskStatus(false);
            }
        }
    }
    

    @Override
    public Color getHealthyColor()
    {
        return SUPERSPREADER_HEALTHY_COLOR;
    }
}