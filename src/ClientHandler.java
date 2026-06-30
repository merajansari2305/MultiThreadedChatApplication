import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String clientName;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

            // First message from client = username
            clientName = reader.readLine();

            System.out.println(clientName + " joined the chat.");

            ChatServer.broadcast(
                    ">>> " + clientName + " joined the chat.",
                    this);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = reader.readLine()) != null) {

                System.out.println(clientName + ": " + message);

                ChatServer.broadcast(
                        clientName + ": " + message,
                        this);
            }

        } catch (IOException e) {

            System.out.println(clientName + " disconnected.");

        } finally {

            closeConnection();
        }
    }

    // Send message to this client
    public void sendMessage(String message) {

        writer.println(message);
    }

    // Close client connection
    private void closeConnection() {

        try {

            ChatServer.removeClient(this);

            ChatServer.broadcast(
                    ">>> " + clientName + " left the chat.",
                    this);

            if (reader != null)
                reader.close();

            if (writer != null)
                writer.close();

            if (socket != null)
                socket.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
