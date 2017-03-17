package myproject.chat;

import java.io.*;
import java.net.Socket;

/**
 * @author tianliangxia
 *         Date:17-3-17
 *         Time:下午6:09
 */
public class Client {
    //socket client
    //multi-thread to send and show the message
    //send PrintWriter new thread
    //receiver bufferedReader -- InputStreamReader -- socket  main thread

    final String CLIENT_NAME = "client";
    final String SERVER_NAME = "Server";
    Socket socket = null;
    BufferedReader bufferedReader = null;
    PrintWriter printWriter = null;

    public static void main(String[] arg){
        Client client = new Client();

        try {
            client.socket = new Socket("127.0.0.1",5000);
            client.bufferedReader = new BufferedReader(new InputStreamReader(client.socket.getInputStream()));
            client.printWriter = new PrintWriter(client.socket.getOutputStream());

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    String line = null;
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        while ((line = br.readLine()) != null && !line.equals("quit")){
                            client.printWriter.println(line);
                            client.printWriter.flush();
                        }
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }

                }
            });
            t.start();

            String message = null;
            while ((message = client.bufferedReader.readLine())!= null){
                System.out.println(client.SERVER_NAME + ":" + message);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
