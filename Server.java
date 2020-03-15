import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Handler;



public class Server {

        public static void main(String[] args) throws IOException {
            ServerSocket server = new ServerSocket(9090);

            while (true)
            {
                Socket client =null;
                System.out.println("Waiting...");

                try {
                    client = server.accept();
                    System.out.println("Connected" + client.getInetAddress());
                    ClientHandler t = new ClientHandler(client);
                    Thread.sleep(20);
                    Thread t1 = new Thread(t);
                    t1.start();



                }
                catch(IOException | InterruptedException e){
                    e.printStackTrace();
            }


            }
        }

}
class ClientHandler implements Runnable {
    Socket current;

    public ClientHandler(Socket client) {
        current = client;
    }

    public void run() {
        DataInputStream inFromServer = null;
        try {
            inFromServer = new DataInputStream(current.getInputStream());
            String text = inFromServer.readUTF();
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



