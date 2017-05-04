package util;

import java.util.Scanner;

//Quick Util to find a length of a string got tired of counting :)
public class Len implements IUtil{
    Scanner scanner;
    public Len(){
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("String: ");
        String length = scanner.nextLine();
        System.out.println(length + " | Length: " + length.length());
    }

    public String getName() {
        return "String Length Display";
    }
}
