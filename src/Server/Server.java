package Server;

import Additional.EmailHandler;
import Database.*;

import java.io.*;
import java.net.Socket;
import java.util.Random;

// Class server handles the data sent from the client
public class Server extends Thread{
    private final Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream oin;
    private final Database dbase;

    public Server(Socket socket,Database dbase) {
        this.socket = socket;
        this.prepareServer();
        this.dbase = dbase;
    }

    private void prepareServer() {
        try {
            this.oos = new ObjectOutputStream(this.socket.getOutputStream());
            this.oin = new ObjectInputStream(this.socket.getInputStream());
        }
        catch (IOException ex) {
            System.out.println("PrepareServer: "+ex);
        }
    }

    public void run() {
        try {
            DataObject dot = (DataObject) this.oin.readObject();
            System.out.println("DataObject received");
            this.doOperation(dot);
        }
        catch(IOException | ClassNotFoundException ex) {
            System.out.println("Server Closing due to .... "+ex);
        }
    }

    private void doOperation(DataObject dot) {
        DataObject send;
        switch(dot.getOperation()) {
            case 'A': {
                Admin a = this.dbase.checkAdminLogin(dot.getAdmin());
                if (a == null)
                    send = new DataObject("Invalid Login Credentials");
                else
                    send = new DataObject(a);
                break;
            }
            case 'B': {
                send = new DataObject(this.PasswordReset(dot.getAdmin().getEmail()));
                break;
            }
            case 'C': {
                send = new DataObject(dot.getAdmin(),this.dbase.getAllApplication());
                break;
            }
            case 'D': {
                if(this.dbase.validateApplication(dot.getVisaApplication()))
                    send = new DataObject("Validation Successful");
                else
                    send = new DataObject("Validation Failed");
                break;
            }
            case 'E': {
                Admin a = this.dbase.newAdmin(dot.getAdmin());
                if(a != null)
                    send = new DataObject(a,"Register Successful");
                else
                    send = new DataObject("Register unsuccessful");
                break;
            }
            case 'H': {
                VisaApplyer v = this.dbase.checkApplyerLogin(dot.getApplyer());
                if (v != null)
                    send = new DataObject("Invalid Login Credentials");
                else
                    send = new DataObject(v);
                break;
            }
            case 'I': {
                VisaApplyer v = this.dbase.newApplyer(dot.getApplyer());
                if(v != null)
                    send = new DataObject(v,"Registration Successful");
                else
                    send = new DataObject("Registration Failed");
                break;
            }
            case 'J': {
                if(this.dbase.newApplication(dot.getVisaApplication()))
                    send = new DataObject("Application submitted");
                else
                    send = new DataObject("Application submitting Failed");
                break;
            }
            case 'K': {
                if(this.dbase.updateApplyer(dot.getApplyer()))
                    send = new DataObject("Data updated");
                else
                    send = new DataObject("Data updating failed");
                break;
            }
            case 'L': {
                send = new DataObject(this.dbase.getStatus(dot.getApplyer()));
                break;
            }
            case 'M': {
                send = new DataObject(this.PasswordReset(dot.getApplyer().getEmail()));
                break;
            }
            case 'N': {
                if(this.dbase.deleteApplication(dot.getVisaApplication()))
                    send = new DataObject("Application Deleted");
                else
                    send = new DataObject("Application Deletion Failed");
                break;
            }
            default:
                send = new DataObject("Invalid Data");
        }
        try {
            this.oos.writeObject(send);
        }
        catch(Exception ex) {
            System.out.println("Server processing error: "+ex);
        }
    }

    private String generateOTP() {
        Random r = new Random();
        StringBuilder otp = new StringBuilder();
        while(otp.length()<6) {
            otp.append(r.nextInt());
        }
        return otp.toString();
    }

    private String PasswordReset(String email) {
        String otp = generateOTP();
        EmailHandler e = new EmailHandler(email,"Password Rest Request","Hi, The OTP for the " +
                "password reset: \n "+otp+"\n If this request not made by you then contact the Administrator");
        e.sendMessage();
        return otp;
    }
}
