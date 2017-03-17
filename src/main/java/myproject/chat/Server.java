package myproject.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianliangxia
 *         Date:17-3-17
 *         Time:下午6:30
 */
public class Server {
    final String CLINET_NAME = "client";
    final String SERVER_NAME = "server";

    ServerSocket serverSocket = null;
    List<PrintWriter> clients = new ArrayList<>();

    public void tellEveryOne(String message){
        for(PrintWriter pr : clients){
            pr.println(message);
            pr.flush();
        }
    }

    class Task implements Runnable{
        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        public Task(Socket socket){
            this.socket = socket;
            try{
                bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                printWriter = new PrintWriter(this.socket.getOutputStream());
                clients.add(printWriter);
            }catch (IOException ioe){
                ioe.printStackTrace();
            }

        }
        @Override
        public void run() {
            //get the input stream
            //push stream to every client
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null){
                    tellEveryOne(line);
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }

    public void go(){
        try{
            serverSocket = new ServerSocket(5000);
            while (true){
                Socket socket = serverSocket.accept();
                Thread t = new Thread(new Task(socket));
                t.start();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }


    public static void main(String[] arg){
        new Server().go();
    }
}
