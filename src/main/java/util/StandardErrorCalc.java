package util;

import java.util.Scanner;



public class StandardErrorCalc implements IUtil{
    Scanner scanner;

    StandardErrorCalc(){
        scanner = new Scanner(System.in);
    }


    public void run() {
        System.out.println("Population: ");
        double population = scanner.nextDouble();
        System.out.println("Proportion/Mean: ");
        double prop = scanner.nextDouble();

        //sqrt(p(1-p)/n)
        double output = Math.sqrt((prop * (1 - prop) / population));
        //central limit theory determinor
        boolean clt = ((population * prop > 10) && (population * (1 - prop) > 10));
        System.out.println("SE: " + output + " CLT: " + clt);
    }

    public String getName() {
        return "Standard Error Calculator";
    }
}
