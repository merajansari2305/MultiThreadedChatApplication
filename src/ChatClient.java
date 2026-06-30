import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private static final String SERVER = "localhost";
    private static final int PORT = 5555;

    public static void main(String[] args) {

        try {

            Socket socket = new Socket(SERVER, PORT);

            System.out.println("Connected to Chat Server!");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            PrintWriter writer =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            // Enter username
            System.out.print("Enter Your Name: ");
            String name = scanner.nextLine();

            writer.println(name);

            // Thread for receiving messages
            Thread receiveThread = new Thread(() -> {

                String message;

                try {

                    while ((message = reader.readLine()) != null) {

                        System.out.println(message);

                    }

                } catch (IOException e) {

                    System.out.println("Disconnected from server.");

                }

            });

            receiveThread.start();

            // Send messages
            while (true) {

                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {

                    break;

                }

                writer.println(message);

            }

            scanner.close();
            reader.close();
            writer.close();
            socket.close();

            System.out.println("Connection Closed.");

        } catch (IOException e) {

            System.out.println("Unable to connect to the server.");

            e.printStackTrace();
        }
    }
}
