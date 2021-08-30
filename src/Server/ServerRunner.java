package Server;

import java.util.Scanner;

public class ServerRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Port : ");
        ServerHandler s = new ServerHandler(sc.nextInt());
        s.runServer();
    }
}
