import java.util.Scanner;

/**
 * Created by Tristan on 5/2/2017.
 */
public class StandardErrorCalc {
    Scanner scanner;

    StandardErrorCalc(){
        scanner = new Scanner(System.in);
    }
    void calc(){
        System.out.println("Population: ");
        double population = scanner.nextDouble();
        System.out.println("Proportion/Mean: ");
        double prop = scanner.nextDouble();

        double output = Math.sqrt((prop * (1 - prop) / population));

        boolean clt = ((population * prop > 10) && (population * (1 - prop) > 10));
        System.out.println("SE: " + output + " CLT: " + clt);


    }



    public static void main(String[] args) {
        StandardErrorCalc calc = new StandardErrorCalc();
        while (true){
            calc.calc();
        }
    }
}
