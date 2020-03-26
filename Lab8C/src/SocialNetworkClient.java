import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocialNetworkClient {
    private Socket socket;
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    private SocialNetworkClient(){
        try {
            this.socket= new Socket(SERVER_ADDRESS, PORT);
        }catch (IOException e){
            System.out.println("IOEXCEPTION socket");
        }
    }
    public void stopSocket(){
        try{
            this.socket.close();
        }catch (IOException e){
            System.out.println("Close Socket IO Excetion");
        }
    }
    public static void main(String[] args) throws IOException {
        SocialNetworkClient client = new SocialNetworkClient();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                client.stopSocket();
                break;
            } else {
                client.sendRequestToServer(request);
            }
        }
    }

    private void sendRequestToServer(String request) {
        try (
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            out.println(request);
            String response = in.readLine();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e){
            System.out.println("IO Excetion ce");
        }
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}