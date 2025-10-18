package lambda_fn;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        try(Scanner scanner= new Scanner(System.in)){
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();

            Name name = (a,b) -> {
                System.out.println("Full name: " + a.toLowerCase()+ " " + b.toLowerCase());
            };
            name.fullName(firstName, lastName);
            
            Name reverse = (a,b) -> {
                String first = "";
                String second = "";
                for(int i = a.length()-1; i>=0;i--){
                    first += a.charAt(i);
                }
                System.out.println("Reverse of first name: " + first);

                for(int i = b.length()-1; i>=0 ;i--){
                    second += b.charAt(i);
                }
                System.out.println("Reverse of second name: " + second);

            };

            reverse.fullName(firstName, lastName);

            
        }catch(InputMismatchException e){
            System.out.println("Enter a String!!");
        }
    }
}

@FunctionalInterface
interface Name{
    void fullName(String a, String b);

}
