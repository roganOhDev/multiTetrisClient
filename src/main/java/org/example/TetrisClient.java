package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TetrisClient {
    public static final String SERVER_ADDRESS = "localhost";
    public static final int SERVER_PORT = 8080;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public TetrisClient() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error Connecting to Server: " + e.getMessage());
        }
    }

    public void sendMessage(final String message) {
        try {
            output.writeUTF(message);
            output.flush();
        } catch (IOException e) {
            System.out.println("Error Sending Message: " + e.getMessage());
        }
    }

    public void startListening() {
        final var listnerThread = new Thread(() -> {
            try {
                while (true) {
                    final var message = input.readUTF();
                }
            } catch (IOException e) {
                System.out.println("Error Reciving Message: " + e.getMessage());
            }
        });

        listnerThread.start();
    }
}
