package lambda_fn;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter num1: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter num2: ");
            int num2 = scanner.nextInt();

            Cal add = (a,b) -> System.out.println("add: " + (a+b));
            Cal sub = (a,b) -> System.out.println("subtract: " + (a-b));
            Cal multi = (a,b) -> System.out.println("multiplication: " + (a*b));
            Cal divide = (a,b) -> System.out.println("division: " + (a/b));
            Cal modulus = (a,b) -> System.out.println("modulus: " + (a%b));

            add.Calculator(num1, num2);
            sub.Calculator(num1, num2);
            multi.Calculator(num1, num2);
            divide.Calculator(num1, num2);
            modulus.Calculator(num1, num2);
        }catch(InputMismatchException e){
            System.out.println("Enter an integer!!!");
        }catch(ArithmeticException e){
            System.out.println("Cant be divided by zero!!");
        }

    }
}

@FunctionalInterface
interface Cal{

    void Calculator(int a,int b);

}
