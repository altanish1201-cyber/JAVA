import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server started on port " + PORT + ". Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg;
            while ((clientMsg = in.readLine()) != null) {
                System.out.println("Client: " + clientMsg);
                if (clientMsg.equalsIgnoreCase("bye")) {
                    break;
                }
                System.out.print("Server: ");
                String reply = keyboard.readLine();
                out.println(reply);
                if (reply.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            System.out.println("Chat ended.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class ChatClient {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Connected to Chat Server. Type 'bye' to exit.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Client: ");
                String msg = keyboard.readLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) {
                    break;
                }
                String reply = in.readLine();
                if (reply == null) {
                    break;
                }
                System.out.println("Server: " + reply);
                if (reply.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            System.out.println("Chat ended.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
