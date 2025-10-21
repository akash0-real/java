package OOP.recordClass;

import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter a number to check if its prime: ");
            int num = scanner.nextInt();

            Prime prime = new Prime(num);
        }
    }
}

record Prime(int number){
    public Prime{
        boolean one = true;
        if(number <= 1){
            System.out.println("it is not prime!");
        }

        if(number ==2){
            one = true;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i == 0){
                one = false;
                break;
            }
        }
        if(!one){
            System.out.println("The number " + number + " is not prime number!!");
        }
        if(one){
            System.out.println("it is prime!!");
        }
    }
}