package util;

import java.util.Scanner;

public class StandardErrorCalc implements IUtil{
    Scanner scanner;

    public StandardErrorCalc(){
        scanner = new Scanner(System.in);
    }

    public void run() {

        System.out.println("Population: ");
        double population = scanner.nextDouble();
        System.out.println("Proportion/Mean: ");
        double val = scanner.nextDouble();
        double prop;
        if(val<1){
            prop = val;
        }
        else prop = val/population;


        //sqrt(p(1-p)/n)
        double output = standardError(population, prop);
        //central limit theory determinator
        boolean clt = ((population * prop > 10) && (population * (1 - prop) > 10));
        System.out.println("SE: " + output + " CLT: " + clt);

    }

    public String getName() {
        return "Standard Error Calculator";
    }

    public static double standardError(double population, double prop){
        return Math.sqrt((prop * (1 - prop) / population));
    }
}
