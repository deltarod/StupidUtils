package util;

import java.util.Scanner;

public class ConfidenceIntervalCalc implements IUtil{
    Scanner scn;
    DoubleLinkedList list;


    public ConfidenceIntervalCalc(){
        scn = new Scanner(System.in);
        list = new DoubleLinkedList();
        //90% ci
        list.put(90, 1.645);
        //95% ci
        list.put(95, 1.96);
        //99%
        list.put(99, 2.575);

    }

    public void run() {
        System.out.println("Value: ");
        double val = scn.nextDouble();
        System.out.println("Population: ");
        double pop = scn.nextDouble();
        System.out.println("Z Score/Common confidence interval: ");
        double z = scn.nextDouble();
        //for common confidence %
        if(z > 80){
            z = list.get(z);
        }
        //for proportion plugged into value
        double prop;
        if(val < 1){
            prop = val;
        }
        else {
            prop = val / pop;
        }
        //calculate standard error
        double se = StandardErrorCalc.standardError(pop, prop);
        //margin of error
        double error = se * z;
        //upper and lower bounds of confidence interval
        double upper = prop + error;
        double lower = prop - error;

        System.out.println("Confidence Interval: (" + lower + ", " + upper + ")");
        System.out.println("Margin of error: " + error);
    }

    public String getName() {
        return "Confidence Interval Calculator";
    }
}
