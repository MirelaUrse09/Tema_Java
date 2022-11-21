package server;
import humans_pack.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class ThreadClass extends Thread {
    Socket socket;
    static List<People> list = new ArrayList<>();
    int clientCount;

    public ThreadClass(Socket socket, int clientCount) {
        // this.list=
        this.socket = socket;
        this.clientCount = clientCount;
    }
    private static String[] getTokensArray(String strData, String strDelimiters) {

        String[] strTokenArray = null;

        try {

            if (strData == null || strDelimiters == null)
                return strTokenArray;

            StringTokenizer st = new StringTokenizer(strData, strDelimiters);
            strTokenArray = new String[st.countTokens()];

            int count = 0;
            while (st.hasMoreTokens()) {
                strTokenArray[count++] = st.nextToken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strTokenArray;

    }

    @Override
    public void run() {
        try {
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientMessage = "", serverMessage = "";

            while(!clientMessage.equals("bye")){

                clientMessage = socketIn.readLine();
                String[] tokenArray = getTokensArray(clientMessage, " ");
                //Student Dorobantu Gabriel ATM 22 4
                People client = new Student("Student", "Test","ATM", 20, 3);
                if (tokenArray != null) {
                    if (tokenArray[0].equals("Student"))
                        client = new Student(tokenArray[1], tokenArray[2], tokenArray[3], Integer.parseInt(tokenArray[4]), Integer.parseInt(tokenArray[5]));
                    else if (tokenArray[0].equals("Profesor"))
                        client = new Profesor(tokenArray[1], tokenArray[2], tokenArray[3], Integer.parseInt(tokenArray[4]), tokenArray[5]);

                }
                if (!list.contains(client))
                    list.add(client);

                Collections.sort(list);
                System.out.println(list.toString());
            }
            socketIn.close();
            socketOut.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}