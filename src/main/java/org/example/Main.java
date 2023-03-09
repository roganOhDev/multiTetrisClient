package org.example;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static final String SERVER_ADDRESS = "localhost";
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        TetrisClient client = new TetrisClient();
        client.startListening();
        // Use client.sendMessage() to send messages to the server
    }
}