package server;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws Exception  {

        int clientCounter=0;
        try{
            ServerSocket server=new ServerSocket(1234);
            System.out.println("Conexiunea a fost realizata cu succes!");
            while(true){
                clientCounter++;
                Socket client=server.accept();

                System.out.println("Clientul "+Integer.toString(clientCounter)+" s-a conectat!");

                ThreadClass sct=new ThreadClass(client,clientCounter);
                sct.start();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

