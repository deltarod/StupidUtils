package util;

import java.util.Scanner;

public class DifferenceOfProp implements IUtil{
    Scanner scn;
    public DifferenceOfProp(){
        scn = new Scanner(System.in);
    }


    @Override
    public void run() {
        System.out.println("H Null: ");
        double hn = scn.nextDouble();
        System.out.println("Proportion/total: ");
        double val = scn.nextDouble();
        System.out.println("Population: ");
        double pop = scn.nextDouble();

        double prop;
        if(val<1){
            prop = val;
        }
        else prop = val/pop;

        double se = StandardErrorCalc.standardError(pop,hn);
        double z = (prop - hn)/se;
        System.out.println("Z val: " + z);


    }

    @Override
    public String getName() {
        return "Difference of proportions";
    }

}
