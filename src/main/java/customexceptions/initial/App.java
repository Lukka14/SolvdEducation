package customexceptions.initial;

import customexceptions.extra.HumanAge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

//Create 5 custom exceptions.
//Handle exceptions in 2 ways.
//Use try-catch with resources.
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        try(HumanAge humanAge=new HumanAge(1,3,4,"bc")){
            System.out.println(humanAge);
        }

        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter first integer value: ");
        int a=scanner.nextInt();
        System.out.print("Enter second integer value: ");
        int b=scanner.nextInt();
        try {
            System.out.print(a +"/"+ b +"="+ a / b*1.0);
        }
        catch (ArithmeticException e) {
            System.out.println(e);
            System.out.print("Enter second integer value: ");
            b = scanner.nextInt();
            System.out.print(a +"/"+ b +"="+ a / b*1.0);
        }
    }
}
