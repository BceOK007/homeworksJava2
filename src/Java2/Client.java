package Java2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;

    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Connect to server: " + socket.getRemoteSocketAddress());

            Scanner in = new Scanner(socket.getInputStream());//сканер считывания из сети
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //тправка по сети
            Scanner inConsole = new Scanner(System.in); //сканер считывания с консоли

            //поток работы с конлосью
            Thread thread = new Thread(()->{
                while (true){
                    out.println(inConsole.nextLine());
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true) {
                String str = in.nextLine();

                if (str.equals("/end")) {
                    System.out.println("Server is lost!");
                    out.println("/end");
                    break;
                }

                System.out.println("Server: " + str);
            }

        } catch (IOException e) {
            System.out.println("server is not running...");
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
