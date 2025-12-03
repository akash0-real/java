package arrays.one_d;
import java.util.Scanner;
public class Linear{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        search one = new search(scanner);
        one.show();
        scanner.close();
    }
}

class Arry{
    int[] arr1;
    int choice;
    Arry(Scanner scanner){
        System.out.print("enter the no of elements you want in an array: ");
        this.choice = scanner.nextInt();
        this.arr1 = new int[choice];
    }
}

class fi extends one {
    fi(Scanner scanner){
        super(scanner);
        for(int i=0;i<arr1.length;i++){
            System.out.print("enter the elements in array: ");
            arr1[i] = scanner.nextInt();
        }
    }
}

class search extends fi {
    int number;
    search(Scanner scanner){
        super(scanner);
        System.out.print("enter the number you want to enter: ");
        this.number = scanner.nextInt();
    }
    void show(){
         boolean isRun = false;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] == number){
                System.out.println("the index of the element is: " + i);
                isRun = true;
                break;
            }
        }
        if(!isRun){
            System.out.println("element not found!");
        }
    }
}
