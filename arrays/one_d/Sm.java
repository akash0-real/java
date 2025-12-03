package arrays.one_d;
import java.util.Scanner;
public class Sm{
    public static void main(String[] args) {
       try( Scanner scanner = new Scanner(System.in)){
        Odd one = new Odd(scanner);
        one.show();
       }
    }
}

class Choice{
    int[] arr1;
    int choice;
    Choice(Scanner scanner){
        System.out.print("enter the no. elements you want in an array: ");
        this.choice = scanner.nextInt();
        arr1 = new int[choice];
    }
}

class input extends one {
    input(Scanner scanner){
        super(scanner); 
        for(int i=0;i<choice;i++){
            System.out.print("enter the values in the array: ");
            arr1[i] = scanner.nextInt();
        }
        
    }
    
}

class Even extends fi {
    int sum = 0;
    Even(Scanner scanner) {
        super(scanner);
        for(int i=0;i<choice;i++){
            if(arr1[i]%2 == 0){
                sum +=1;
                
            }
        }
        System.out.println("total number of even numbers are: " + sum);   
    }
    

}
class Odd extends Even{
    int now = 0;
    Odd(Scanner scanner){
        super(scanner);
    }
    void show(){
        for(int i=0;i<choice;i++){
            if(arr1[i]%2 != 0){
                now +=1;
                
            }
        }
        System.out.println("total number of odd numbers are: " + now);
    }
    

}
