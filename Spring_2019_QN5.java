import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Spring_2019_QN5 {
    public static void main(String[] args) {
        int portNumber = 12345;
        Thread serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                    System.out.println("Server is waiting for client connection on port " + portNumber);
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                        String clientMessage;
                        while ((clientMessage = in.readLine()) != null) {
                            System.out.println("Received from client: " + clientMessage);
                            out.println("Server received: " + clientMessage);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        try (Socket socket = new Socket("localhost", portNumber);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected to server: " + socket.getInetAddress());
            String userInputString;
            while ((userInputString = userInput.readLine()) != null) {
                out.println(userInputString);
                String serverResponse = in.readLine();
                System.out.println("Server response: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverThread.start();
    }
}
