
import java.awt.Color;
import java.util.Random;

/**
 * the Rule abider, the people on campus that stay protected from being effected by keeping thier masks on and keeping thier distance.
 * 
 */

public class RuleAbider extends Citizen 
{
    public static final Color RULEABIDER_HEALTHY_COLOR = new Color(0,240,0);     

    public RuleAbider(String myName, boolean masked, int startingInfectionStatus, Campus newCampus, int startRow, int startColumn) {
        super(myName, masked, startingInfectionStatus, newCampus, startRow, startColumn);
    }
    
    @Override
    public void move()
    {
        if(getInfectionStatus() != INFECTED)
        {
            super.move();
        }
        else
        {
            Random moveChance = new Random();
            int chanceToMove = moveChance.nextInt(3);
            if(chanceToMove < 1)
            {
                super.doYourThing();
            }
            else
            {
                super.move();
            }
        }
    }
    

    @Override
    public Color getHealthyColor()
    {
        return RULEABIDER_HEALTHY_COLOR;
    }
}
