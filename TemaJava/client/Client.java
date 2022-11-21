package client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args){

        try {
            Socket socket = new Socket("localhost", 1234);
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer, fromUser;
            while (true) {

                String nume;
                String prenume;
                String universitate;
                String varsta;

                System.out.println("Nume: "); nume=stdIn.readLine();
                System.out.println("Prenume: "); prenume=stdIn.readLine();
                System.out.println("Varsta: "); varsta=stdIn.readLine();
                System.out.println("Universitate: "); universitate=stdIn.readLine();

                System.out.println("Are you a Student or a Profesor?");
                fromUser=stdIn.readLine();

                if(fromUser.equals("Student")) {System.out.println("An_universitar: ");
                    fromUser="Student "+nume+" "+prenume+" "+universitate+" "+varsta+" "+stdIn.readLine();

                }else if (fromUser.equals("Profesor")){ System.out.println("Materie: ");
                    fromUser="Profesor "+nume+" "+prenume+" "+universitate+" "+varsta+" "+stdIn.readLine();

                }else if (fromUser.equals("bye"))
                    break;

                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    socketOut.println(fromUser);
                }
            }
            socketIn.close();
            socketOut.close();
            socket.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
