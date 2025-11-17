import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IpFInder {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a website to see IP: ");
            String ip = scanner.nextLine();// getting the ip adress by the user!!
            InetAddress address =  InetAddress.getByName(ip);//getting the ip address by name!!
            System.out.println("ip: " + address);
        }catch (UnknownHostException e){// to throw the error 
            System.out.println("Host doesnt exist!!");
        }catch (InputMismatchException e){
            System.out.println("Wrong input!!");
        }
    }
}
