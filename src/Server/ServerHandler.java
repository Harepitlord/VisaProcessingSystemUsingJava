package Server;

import Database.Database;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerHandler {

    // Data members
    private ServerSocket serverSocket;
    private Database dbase;

    // Constructor
    public ServerHandler(int port) {
        try {
           this.serverSocket = new ServerSocket(port);
           this.dbase = new Database();
        }
        catch(IOException ex) {
            System.out.println("Server is closing due to IOException " + ex);
        }
    }

    public void runServer() {
        while(true) {
            try {
                if(dbase.fail == 1) {
                    this.stopServer();
                    return;
                }
                new Server(this.serverSocket.accept(), this.dbase).start();
            }
            catch (Exception ex) {
                System.out.println("Error in Server Running " + ex);
                this.stopServer();
            }
        }
    }

    public void stopServer() {
        try {
            this.serverSocket.close();
            this.dbase.close();
        }
        catch (Exception ex2) {
            System.out.println("Error in Server closing " + ex2);
        }
    }

}
