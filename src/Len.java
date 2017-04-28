import java.util.Scanner;

//Quick Util to find a length of a string got tired of counting :)
public class Len {
    Scanner scanner;
    public Len(){
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Len len = new Len();
        while(true){
            System.out.println("String: ");
            String length = len.scanner.nextLine();
            System.out.println(length + " | Length: " + length.length());

        }
    }
}
