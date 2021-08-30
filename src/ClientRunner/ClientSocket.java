package ClientRunner;

import Server.DataObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// This class handles the server client networking at client side
public class ClientSocket {

    // Data Members
    private final String url;
    private final int port;
    private ObjectOutputStream oos;
    private ObjectInputStream oin;

    public ClientSocket(String url,int port) {
        this.url = url;
        this.port = port;
    }

    private void SocketCreation() {
        try {
            Socket socket = new Socket(url, port);
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.oin = new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception ex) {
            System.out.println("Error in connecting to server ....");
        }
    }

    public boolean sendObject(DataObject dot) {
        try {
            this.SocketCreation();
            this.oos.writeObject(dot);
            this.oos.flush();
            return true;
        }
        catch (Exception ex) {
            System.out.println("Client to Server : send error :" +ex);
            return false;
        }
    }

    public DataObject receiveObject() {
        try {
//            this.SocketCreation();
            return (DataObject) this.oin.readObject();
        }
        catch (Exception ex) {
            System.out.println("Client to Server : receive error : "+ex);
            return null;
        }
    }
}
