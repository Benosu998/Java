import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocialNetworkServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;


    public static void main(String[] args) {
        SocialNetworkServer server = new SocialNetworkServer();
        server.init();
        server.waitForClients(); //... handle the exceptions!
    }

    private void init() {
        this.running = true;
        try {
            this.serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("IO Exception ha");
            this.running = false;
        }

    }

    private void waitForClients() {
        try {
            while (this.running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            try {
                serverSocket.close();
            }catch (IOException e){
                System.out.println("IOEXCETION serverSocket close");
            }
        }
    }
    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
}