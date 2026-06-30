import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    // Server Port
    private static final int PORT = 5555;

    // Store all connected clients
    public static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Java MultiThreaded Chat Server");
        System.out.println("=================================");

        try {

            ServerSocket serverSocket = new ServerSocket(PORT);

            System.out.println("Server Started...");
            System.out.println("Waiting for clients...");
            System.out.println("Listening on Port : " + PORT);

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("\nNew Client Connected : "
                        + socket.getInetAddress());

                ClientHandler clientHandler =
                        new ClientHandler(socket);

                clients.add(clientHandler);

                Thread thread = new Thread(clientHandler);

                thread.start();
            }

        } catch (IOException e) {

            System.out.println("Server Error");

            e.printStackTrace();
        }
    }

    // ======================================
    // Broadcast message to every client
    // ======================================
    public static void broadcast(String message,
                                 ClientHandler sender) {

        for (ClientHandler client : clients) {

            if (client != sender) {

                client.sendMessage(message);
            }
        }
    }

    // ======================================
    // Remove disconnected client
    // ======================================
    public static void removeClient(ClientHandler client) {

        clients.remove(client);

        System.out.println("Client Disconnected");
    }
}