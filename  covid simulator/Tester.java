import java.util.ArrayList;
import java.util.Random;
import java.awt.color.*;
import java.awt.*;

/**
 * this purpose of tester class is to set up the campus and the enviorment for the citizens 
 * @author Amira
 */

public class Tester {

public static final int sleepTime = 1; 
public static final int TOTAL_TIME = 200;
public static final int NUMBER_OF_TRIALS = 100; 

    public static void main(String[] args)
    {
        boolean[][] map ={
            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {true ,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,true ,false,false,false,false,false,true ,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,true ,true ,true ,true ,true ,true ,true ,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,true ,true ,true ,true ,true ,true ,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false,false,true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}
        };
    
        ArrayList<Double> initialRuleAbiderCounters = new ArrayList<>();
        ArrayList<Double> initialSuperSpreaderCounters = new ArrayList<>();
        ArrayList<Double> initialMaskAuthorityCounters = new ArrayList<>();
        ArrayList<Double> finalRuleAbiderCounters = new ArrayList<>();
        ArrayList<Double> finalSuperSpreaderCounters = new ArrayList<>();
        ArrayList<Double> finalMaskAuthorityCounters = new ArrayList<>();
        ArrayList<Double> susceptibleCounters = new ArrayList<>();
        ArrayList<Double> infectedCounters = new ArrayList<>();
        ArrayList<Double> recoveredCounters = new ArrayList<>();
        ArrayList<Double> deceasedCounters = new ArrayList<>();

        for(int trialNumber = 1; trialNumber <= NUMBER_OF_TRIALS; trialNumber++)
        {
                System.out.println("Trial Number " + trialNumber);
                Campus campus = new Campus(map);
                campus.initializeCampus();
                campus.showCampus();
                ArrayList<Citizen> population = new ArrayList<Citizen>();
                Random citizenSelector = new Random();
                boolean masked = true;
                boolean unmasked = false;

                for(int ii = 0; ii < Campus.NUMBER_OF_ROWS; ii += 3)
                {
                   for(int jj = 0; jj < Campus.NUMBER_OF_COLUMNS; jj += 2)
                   {
                       if(map[ii][jj] == false)
                       {

                        int newCitizen = citizenSelector.nextInt(100);
                        if(newCitizen > 90) 
                      
                        if(newCitizen > 55)
                        {
                            population.add(new SuperSpreader("SuperSpreader", unmasked, Citizen.SUSCEPTIBLE, campus, ii, jj));
                        }
                        else
                        {
                            population.add(new RuleAbider("RuleAbider", masked, Citizen.SUSCEPTIBLE, campus, ii, jj));
                        }
                    }
                }
            }
            population.add(new SuperSpreader("", masked, Citizen.INFECTED, campus, 1,1));

            double initialRuleAbiderCounter = 0;
            double initialSuperSpreaderCounter = 0;
            double initialMaskAuthorityCounter = 0;
            for(Citizen cc : population)
            {
                if(cc instanceof RuleAbider)
                {
                    initialRuleAbiderCounter++;
                }
                if(cc instanceof SuperSpreader)
                {
                    initialSuperSpreaderCounter++;
                }
                if(cc instanceof MaskAuthority)
                {
                    initialMaskAuthorityCounter++;
                }
            }

            //add amounts to the array list to calculate averages later
            initialRuleAbiderCounters.add(initialRuleAbiderCounter);
            initialSuperSpreaderCounters.add(initialSuperSpreaderCounter);
            initialMaskAuthorityCounters.add(initialMaskAuthorityCounter);

            double finalSusceptibleCounter = 0;
            double finalInfectedCounter = 0;
            double finalDeceasedCounter = 0;
            double finalRecoveredCounter = 0;
            for(int time = 0; time <= TOTAL_TIME; time++)
            {
                int susceptibleCounter = 0;
                int infectedCounter = 0;
                int deceasedCounter = 0;
                int recoveredCounter = 0;
                if(time % 5 == 0)
                {
                    for(Citizen cc : population)
                    {
                        if(cc.getInfectionStatus() == Citizen.SUSCEPTIBLE)
                        {
                            susceptibleCounter++;
                        }
                        if(cc.getInfectionStatus() == Citizen.INFECTED)
                        {
                            infectedCounter++;
                        }
                        if(cc.getInfectionStatus() == Citizen.DECEASED)
                        {
                            deceasedCounter++;
                        }
                        if(cc.getInfectionStatus() == Citizen.RECOVERED)
                        {
                            recoveredCounter++;
                        }
                    }
                  
                    System.out.println("At time " + time + ", there are " + susceptibleCounter + " susceptible, " + infectedCounter + " infected, " +
                    deceasedCounter + " deceased, and " + recoveredCounter + " recovered indiviudals");
                    if(time == TOTAL_TIME)
                    {
                        finalSusceptibleCounter = susceptibleCounter;
                        finalInfectedCounter = infectedCounter;
                        finalDeceasedCounter = deceasedCounter;
                        finalRecoveredCounter = recoveredCounter;
                    }
                }
                for(Citizen cc : population)
                {
                    cc.move();
                }
            }

            susceptibleCounters.add(finalSusceptibleCounter);
            infectedCounters.add(finalInfectedCounter);
            recoveredCounters.add(finalRecoveredCounter);
            deceasedCounters.add(finalDeceasedCounter);

//this will count the remaining amount of each subclass on the campus
            double finalRuleAbiderCounter = 0;
            double finalSuperSpreaderCounter = 0;
            double finalMaskAuthorityCounter = 0;
            for(Citizen cc : population)
            {
                if(cc instanceof RuleAbider && cc.getInfectionStatus() != cc.DECEASED)
                {
                    finalRuleAbiderCounter++;
                }
                if(cc instanceof SuperSpreader && cc.getInfectionStatus() != cc.DECEASED)
                {
                    finalSuperSpreaderCounter++;
                }
                if(cc instanceof MaskAuthority && cc.getInfectionStatus() != cc.DECEASED)
                {
                    finalMaskAuthorityCounter++;
                }
            }

            finalRuleAbiderCounters.add(finalRuleAbiderCounter);
            finalSuperSpreaderCounters.add(finalSuperSpreaderCounter);
            finalMaskAuthorityCounters.add(finalMaskAuthorityCounter);

            System.out.println("-------------------------------------------------------------------------------");
            double overallInfectionPercentage = 100* ((population.size() - finalSusceptibleCounter) / population.size());
            System.out.print("At the end of trial " + trialNumber + " with a population size of " + population.size() +", ");
            System.out.printf("%.3f", overallInfectionPercentage);
            System.out.print("% of the population was infected at some point:\n");
            System.out.printf("%.3f",100*(finalDeceasedCounter/population.size()));
            System.out.print("% of the population is deceased, ");
            System.out.printf("%.3f",100*(finalInfectedCounter/population.size()));
            System.out.print("% of the population is currently infected, ");
            System.out.printf("%.3f",100*(finalRecoveredCounter/population.size()));
            System.out.print("% of the population recovered, \nand ");
            System.out.printf("%.3f", 100*(finalSusceptibleCounter/population.size()));
            System.out.print("% of the population was never infected.\n");
            System.out.println(finalRuleAbiderCounter + " of " + initialRuleAbiderCounter + " RuleAbiders, " + finalSuperSpreaderCounter
            + " of " + initialSuperSpreaderCounter + " SuperSpreaders, and " + finalMaskAuthorityCounter + " of " + initialMaskAuthorityCounter + " MaskAuthorities survived.");
            System.out.println("-------------------------------------------------------------------------------");
        }
        
// using averages of the array lists to print out final overall summary 
        double populationSize = initialRuleAbiderCounters.get(0) + initialSuperSpreaderCounters.get(0) + initialMaskAuthorityCounters.get(0);

        double overallInfectionPercentage = 100 * ((populationSize - getAverage(susceptibleCounters)) / populationSize);
        System.out.print("After " + NUMBER_OF_TRIALS + " trials with a population size of "); 
        System.out.printf("%.0f", populationSize);
        System.out.print(", on average ");
        System.out.printf("%.3f", overallInfectionPercentage);
        System.out.print("% of the population was infected at some point:\n");
        System.out.printf("%.3f",100 *(getAverage(deceasedCounters)/populationSize));
        System.out.print("% of the population is deceased, ");
        System.out.printf("%.3f",100 *(getAverage(infectedCounters)/populationSize));
        System.out.print("% of the population is currently infected, ");
        System.out.printf("%.3f",100 *(getAverage(recoveredCounters)/populationSize));
        System.out.print("% of the population recovered, \nand ");
        System.out.printf("%.3f", 100 *(getAverage(susceptibleCounters)/populationSize));
        System.out.print("% of the population was never infected.\n");
        System.out.println(getAverage(finalRuleAbiderCounters) + " of " + getAverage(initialRuleAbiderCounters) + " RuleAbiders, " + getAverage(finalSuperSpreaderCounters)
        + " of " + getAverage(initialSuperSpreaderCounters) + " SuperSpreaders, and " + getAverage(finalMaskAuthorityCounters) + " of "
        + getAverage(initialMaskAuthorityCounters) + " MaskAuthorities survived.");
    }
    
/**
 * This method slows down the execution of the program for pauseTime milliseconds.
 */
    public static void pause(int pauseTime)
    {
        try
              {
                    Thread.sleep(pauseTime);
              }
              catch(InterruptedException ex)
              {
               Thread.currentThread().interrupt();
              }
    }
    

    public static double getAverage(ArrayList<Double> arrayList)
    {
        double average = 0;
        for(int ii = 0; ii < NUMBER_OF_TRIALS; ii++)
        {
            average += arrayList.get(ii);
            if(ii == NUMBER_OF_TRIALS - 1 && NUMBER_OF_TRIALS != 0)
            {
                average /= NUMBER_OF_TRIALS;
            }
        }
        return average;
    }
}
