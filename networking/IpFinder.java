import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IpFInder {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a website to see IP: ");
            String ip = scanner.nextLine();
            InetAddress address =  InetAddress.getByName(ip);
            System.out.println("ip: " + address);
        }catch (UnknownHostException e){
            System.out.println("Host doesnt exist!!");
        }catch (InputMismatchException e){
            System.out.println("Wrong input!!");
        }
    }
}
