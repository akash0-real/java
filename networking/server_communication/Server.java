import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8080);
            Socket one = socket.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(one.getInputStream()));
            PrintWriter output = new PrintWriter(one.getOutputStream());

            String cleint = input.readLine();
            System.out.println(cleint);
            System.out.println("msg recieved!!");

            input.close();
            output.close();
            one.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
