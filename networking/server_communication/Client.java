import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // 1. Connect to server running on same machine, port 5000
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server!");

            // 2. Get input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // 3. Send message to server
            output.println("Hello Server!");

            // 4. Receive reply from server
            String response = input.readLine();
            System.out.println("Server says: " + response);

            // 5. Close connections
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
