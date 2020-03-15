import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Clients {
    public static void main(String[] args) throws IOException, InterruptedException {


        //TCP
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        //String sendMessage = inFromUser.readLine();
        //InetAddress address = InetAddress.getByName("localhost");
        //Socket server = new Socket(address,9090);
        //DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
        //outToServer.writeUTF(sendMessage);
        Thread t1 = new Thread(new client1());
        Thread t2 = new Thread(new client2());
        Thread t3 = new Thread(new client3());
        t1.start();
        t2.start();
        t3.start();

    }
}
class client1 implements Runnable{

    public void run() {
        try{
            //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            //String sendMessage = inFromUser.readLine();
            String sendMessage = "Client 1";
        InetAddress address = InetAddress.getByName("localhost");
        Socket server = new Socket(address,9090);
        DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
        outToServer.writeUTF(sendMessage);}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class client2 implements Runnable {
    public void run() {
        try {
            //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            //String sendMessage = inFromUser.readLine();
            String sendMessage = "Client 2";
            InetAddress address = InetAddress.getByName("localhost");
            Socket server = new Socket(address, 9090);
            DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
            outToServer.writeUTF(sendMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class client3 implements Runnable {
    public void run() {
        try {
            String sendMessage = "Client 3";
            InetAddress address = InetAddress.getByName("localhost");
            Socket server = new Socket(address, 9090);
            DataOutputStream outToServer = new DataOutputStream(server.getOutputStream());
            outToServer.writeUTF(sendMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
