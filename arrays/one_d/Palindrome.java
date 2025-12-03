package arrays.one_d;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
        Check one = new Check(scanner);
        Input1 two = new Input1(scanner);
        two.va(scanner);
        one.Pal();
    }
        
    }
}

class one {

    int choice;
    int[] arr1;

    one(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        this.choice = scanner.nextInt();
        this.arr1 = new int[choice];
    }
}

class Input1 extends one {

    Input1(Scanner scanner) {
        super(scanner);
    }

    void va(Scanner scanner) {
        for (int i = 0; i < choice; i++) {
            System.out.print("Enter the values in array: ");
            arr1[i] = scanner.nextInt();
        }
    }
}

class Check extends fi {

    boolean run = true;

    Check(Scanner scanner) {
        super(scanner);
    }

    void Pal() {
        for (int i = 0; i < choice; i++) {
            for (int j = choice - 1 - i; j >= choice-1-i; j++) {
                if (arr1[i] != arr1[j]) {
                    run = false;
                    break;
                }

            }
        }
        if (!run) {
            System.out.println("the array is not palindrome!");
        } else {
            System.out.println("it is palindrome!");
        }
    }
}
