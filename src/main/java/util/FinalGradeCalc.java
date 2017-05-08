package util;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FinalGradeCalc implements IUtil{
    private Scanner scn;
    private DecimalFormat fmt;

    public FinalGradeCalc(){
        scn = new Scanner(System.in);
        fmt = new DecimalFormat("###.##");
    }

    @Override
    public void run() {
        //get current grade
        System.out.println("Current Grade: ");
        double currentGrade = ifNotPercent(scn.nextDouble());
        //get final percentage
        System.out.println("Final %");
        double finalPerc = ifNotPercent(scn.nextDouble());

        //get wanted grade in class
        ifContinue(currentGrade, finalPerc);

    }

    private void ifContinue (double currentGrade, double finalPerc){
        System.out.println("Wanted Final Grade %: ");
        double wantedGrade = ifNotPercent(scn.nextDouble());
        double scoreNeeded = calculate(wantedGrade, currentGrade, finalPerc);
        printOut(currentGrade, wantedGrade, scoreNeeded);

        System.out.println("Continue with same class? (Y/N): ");
        //consume the \n
        scn.nextLine();
        String continueVal = scn.nextLine();
        if(continueVal.equalsIgnoreCase("y")){
            ifContinue(currentGrade, finalPerc);
        }
    }

    //calculates grade needed on final
    private double calculate(double wantedGrade, double currentGrade, double finalPerc){
        double currentGradePerc = 1 - finalPerc;
        //currentGrade(currentGradeWorth%) + finalGrade(finalWorth%) = grade
        return (wantedGrade - currentGrade*currentGradePerc)/finalPerc;
    }
    //prints out info
    private void printOut(double currentGrade, double wantedGrade, double scoreNeeded){
        System.out.println("Current Grade: " + letterGrade(currentGrade*100) + " " + fmt.format(currentGrade*100) + "%");
        System.out.println("Wanted Grade: " + letterGrade(wantedGrade*100) + " " + fmt.format(wantedGrade*100) + "%");
        System.out.println("Needed Final Grade: " + letterGrade(scoreNeeded*100) + " " + fmt.format(scoreNeeded*100) + "%");
    }
    //checks if value is more than 1
    private double ifNotPercent(double number){
        if(number > 1){
            return number/100;
        }
        else return number;
    }

    //converts double to letter grade
    private String letterGrade(double grade){
        if(grade > 100){
            return "Impossible";
        }
        else if(grade >= 90 && grade < 100){
            return "A";
        }
        else if(grade >= 80 && grade < 90){
            return "B";
        }
        else if(grade >= 70 && grade < 80){
            return "C";
        }
        else if(grade >= 60 && grade < 70){
            return "D";
        }
        else return "F";
    }

    @Override
    public String getName() {
        return "Final Grade Calculator";
    }
}
