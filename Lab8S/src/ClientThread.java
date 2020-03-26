import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    //private final GameServer server;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while(true){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //client -> server stream
            String request;
            request = in.readLine();
            String response = execute(request);
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //server -> client stream
            out.println(response);
            out.flush();}
        } catch (IOException e) {
            System.out.println("alta eroare");
        } finally {
            try {
                socket.close(); //... usse try-catch-finally to handle the exceptions!
            } catch (IOException e) {
                System.out.println("IOException finally run ClientTHREAD");
            }
        }
    }


    private String execute(String request) {
        System.out.println("Mesaj primit de la client: " + request);
        return "Mesajul a fost primit: " + request;
    }
}