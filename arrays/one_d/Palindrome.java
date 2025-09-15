package arrays.one_d;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
        Check one = new Check(scanner);
        one.va(scanner);
        one.Pal();
    }
        
    }
}

class Arr {

    int choice;
    int[] arr1;

    Arr(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        this.choice = scanner.nextInt();
        this.arr1 = new int[choice];
    }
}

class Input extends Arr {

    Input(Scanner scanner) {
        super(scanner);
    }

    void va(Scanner scanner) {
        for (int i = 0; i < choice; i++) {
            System.out.print("Enter the values in array: ");
            arr1[i] = scanner.nextInt();
        }
    }
}

class Check extends Input {

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
