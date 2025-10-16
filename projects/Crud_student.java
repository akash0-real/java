package projects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Crud_student {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            course_info info1 = new course_info();
            System.out.println("This is student portal!!");
            System.out.println("Admin or student");
            System.out.print("Enter the username: ");
            String admin = scanner.nextLine();
            System.out.print("Enter the password: ");
            String pass = scanner.nextLine();
            boolean isRun = true;
            while(isRun){
                if(admin.toLowerCase().equals("admin") && pass.toLowerCase().equals("admin")){
                    Admin one = new Admin();
                    one.loadFile();
                    info1.load();

                    System.out.print("1 for students/2 for courses: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch(choice){
                        case 1 -> {
                            System.out.println("1. add");
                            System.out.println("2. remove");
                            System.out.println("3. search via id: ");
                            System.out.println("4. view");
                            System.out.println("5. exit");
                            System.out.print("Enter: ");
                            int enter = scanner.nextInt();
                            scanner.nextLine();
                            switch(enter){
                                case 1 -> {
                                    one.input(scanner);
                                    one.saveFile();
                                }
                                case 2 ->{
                                    one.remove(scanner);
                                    one.saveFile();
                                }
                                case 3 -> {
                                    one.search(scanner);
                                    one.saveFile();
                                }
                                case 4 -> {
                                    one.view();
                                }
                                case 5 -> {
                                    System.out.println("Bye...");
                                    isRun = false;
                                }
                                default -> {
                                    System.out.println("Enter a valid value!!");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("1. for add!!");
                            System.out.println("2. for view!!");
                            System.out.println("3. for search!!");
                            System.out.println("4. for delete!!");
                            System.out.println("5. for exit!!");

                            System.out.print("Enter: ");
                            int input = scanner.nextInt();
                            scanner.nextLine();
                            switch(input){
                                case 1 -> {
                                    info1.course_input(scanner);
                                    info1.save();
                                }
                                case 2 -> {
                                    info1.course_view();
                                }
                                case 3 -> {
                                    info1.course_search(scanner);
                                    info1.save();
                                }
                                case 4 -> {
                                    info1.remove(scanner);
                                    info1.save();
                                }
                                case 5 -> {
                                    System.out.println("Bye...");
                                    isRun = false;
                                }
                                default -> {
                                    System.out.println("Enter a valid input!!");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Enter a valid input!!!");
                        }
                    }
                }
                else if(admin.toLowerCase().equals("student") && pass.toLowerCase().equals("student123")){
                    StudentInfo info = new StudentInfo();
                    info.loadFile();
                    System.out.println("1. for view details: ");
                    System.out.println("2. to find Students: ");
                    System.out.println("3. for exit");
                    System.out.print("enter: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch(choice){
                        case 1 -> {
                            info.search(scanner);
                        }
                        case 2 -> {
                            info.find(scanner);
                        }
                        case 3 -> {
                            System.out.println("exiting...");
                            isRun = false;
                        }
                    }
                }



            }
        }catch(InputMismatchException e ){
            System.out.println("Enter valid input!!");
        }
    }
}

// class student to enter student!!
class Student implements Serializable{
    private static final long serialVersionUID = 1;
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

//creeating a class to store course enrollment details!!

class Course implements Serializable{
    private static final long serialVersionUID = 1;
    private final String course_name;
    private final String lecturer_name;
    private final int course_id;
    Course(String course_name,String lecture_name,int course_id){
        this.course_name = course_name;
        this.lecturer_name = lecture_name;
        this.course_id = course_id;
    }

    //getters for better encapulsation!!
    public String getCourse_name(){
        return course_name;
    }
    public String getLecturer_name(){
        return lecturer_name;
    }

    public int getCourse_id(){
        return course_id;
    }
    //setter if we need in future!!

    public int setCourse_id(int course_id){
        return course_id;
    }


}

// class admin to add and update!!
class Admin{

    ArrayList<Student> student = new ArrayList<>();
    private static int student_counter = 0;
    public String path = "projects//details.txt";//getting the path for our file 


    //Entering the values inside arraylist using user input!!
    void input(Scanner scanner){
        System.out.print("Enter how many student do you want to enter: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<choice;i++){
            student_counter++;
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
            System.out.println(one.getStudent_id() + " " + one.getName() + " " + one.getYear() + "year " + one.getRoll() + " ");
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

        boolean removed = student.removeIf(s->s.getStudent_id() == delete);
        if(removed){
            System.out.println("removed succesfully!");
        }
        else{
            System.out.println("couldnt remove the student!!");
        }
    }

    //To search student using id!!
    void search(Scanner scanner){
        if(student.isEmpty()){
            System.out.println("No students found!!");
            return;
        }

        System.out.println("Enter the id of student: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean run = false;
        for(Student s: student){
            if(s.getStudent_id() == id){
                System.out.println("The name of the student: " + s.getName() + ". year: " + s.getYear() + ". Roll no " + s.getRoll());
                run = true;
            }
        }

        if(!run){
            System.out.println("couldnt find the Id");
        }
    }

    //To save details in file!!

    void saveFile(){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))){
            os.writeObject(student);
        } catch(IOException e ){
            System.out.println("Something went wrong!!");
        }
    }

    //To load the file in the program!!
    void loadFile(){
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(path))){
            student = (ArrayList<Student>) os.readObject();
        }catch(Exception e){
            student = new ArrayList<>();
        }
    }

}


class StudentInfo extends Admin{
    @Override
    void search(Scanner scanner){
        System.out.println("Enter your Id to see details: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean run = false;
        for(Student s: student){
            if(s.getStudent_id()==id){
                System.out.println("name: " + s.getName() + ". year: " + s.getYear() + ". roll_no: " + s.getRoll());
                run = true;
            }
        }
        if(!run){
            System.out.println("couldnt find the ID!!");
        }
    }
    void find(Scanner scanner){
        System.out.println("Enter studentId to find students: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean run = false;
        for(Student s: student){
            if(s.getStudent_id()==id){
                System.out.println("name: " + s.getName() + ". year: " + s.getYear() + ". roll_no: " + s.getRoll());
                run = true;
            }
        }
        if(!run){
            System.out.println("coudnt find the id!!");
        }
    } 
}


class course_info{
    HashMap<String, Course> course = new HashMap<>();
    private static int course_id = 0;
    public String path = "projects//course.txt";

    //Entering the courses inside the hashmap!!
    void course_input(Scanner scanner){
        System.out.println("Enter how many courses do you want to enter: ");
        int course_choice = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<course_choice;i++){
            course_id++;
            System.out.println("Enter the name of the course: ");
            String name = scanner.nextLine();
            System.out.println("Enter the faculty name taking that subject: ");
            String faculty = scanner.nextLine();
            System.out.println("Enter the course code: ");
            String course_code = scanner.nextLine();

            course.put(course_code, new Course(name, faculty, course_id));
        }
    }

    //To view all the courses inside the hashmap!!
    void course_view(){
        if(course.isEmpty()){
            System.out.println("no courses available!!");
            return;
        }

        for(String key: course.keySet()){
            Course c = course.get(key);
            System.out.println(c.getCourse_name() + " " + c.getLecturer_name() + " " + c.getCourse_id());
        }


    }

    //To search one course inside hashmap via course code!!
    void course_search(Scanner scanner){
        System.out.println("Enter the course code: ");
        String course_choice = scanner.nextLine();

        if(course.isEmpty()){
            System.out.println("No courses availble");
            return;
        }

        if(course.containsKey(course_choice)){
            Course c = course.get(course_choice);
            System.out.println(c.getCourse_name() + " " + c.getLecturer_name() + " " + ". Id: " + c.getCourse_id());
        }
    }

    //To remove course from map via course code!!
    void remove(Scanner scanner){  
        System.out.println("Enter the course code: ");
        String course_name = scanner.nextLine();

        if(course.isEmpty()){
            System.out.println("No courses are there no remove!!");
            return;
        }

        boolean run = false;
        if(course.containsKey(course_name)){
            course.remove(course_name);
            run = true;
            System.out.println("Removed succesfully!!");
        }

        if(!run){
            System.out.println("Coudnt remove the course!!");
        }
    }

    //To save the details of courses inside map!!
    void save(){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))){
            os.writeObject(course);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //To load the details of courses!!
    
    void load(){
        try(ObjectInputStream ip = new ObjectInputStream(new FileInputStream(path))){
            course = (HashMap<String,Course>) ip.readObject();
        }catch(IOException | ClassNotFoundException e ){
            System.out.println("Something went wrong!!");
            course = new HashMap<>();
        }
        
    }



}