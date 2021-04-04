package Java2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connect");

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
                    System.out.println("Client disconnect!");
                    out.println("/end");
                    break;
                }

                System.out.println("Client: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
