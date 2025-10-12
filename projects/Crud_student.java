package projects;

import java.util.ArrayList;
import java.util.Scanner;
public class Crud_student {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

        }
    }
}

// class student to enter student!!
class Student{
    private final String name;
    private final int year;
    private final int roll_no;
    private int student_id;
    //inisialing values inside constructor!!
    Student(String name,int year,int roll_no,int student_id){
        this.student_id = student_id;
        this.name = name;
        this.year = year;
        this.roll_no = roll_no;   
    }
    //getter to access the values!!
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getRoll(){
        return roll_no;
    }
    public int getStudent_id(){
        return student_id;
    }

    //setters because student id gonna be automatic!!
    public void setStudent_id(int student_id){
        this.student_id = student_id;
    }
    

}
// class admin to add and update!!
class Admin{

    private ArrayList<Student> student = new ArrayList<>();
    private static int student_counter = 0;
    private static final String path = "projects//details.txt";//getting the path for our file 

    //Entering the values inside arraylist using user input!!
    void input(Scanner scanner){
        student_counter++;
        System.out.print("Enter how many student do you want to enter: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<choice;i++){
            System.out.print("Enter the name of the student: ");
            String name = scanner.nextLine();
            System.out.print("Enter the year of the student: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the rollno of the student: ");
            int roll_no = scanner.nextInt();
            scanner.nextLine();

            student.add(new Student(name, year, roll_no, student_counter));
        }
        System.out.println("Student added succesfully!");
    }

    //To view the list of all students!!
    void view(){
        if(student.isEmpty()){
            System.out.println("No students entered!!");
            return;
        }
        for(Student one:student){
            System.out.println(one);
        }
    }

    //to remove the user using Id of student!!
    void remove(Scanner scanner){
        if(student.isEmpty()){
            System.out.println("No students entered!!");
            return;
        }

        System.out.println("Enter the id of student you want to delete: ");
        int delete = scanner.nextInt();
        scanner.nextLine();
    }


}
