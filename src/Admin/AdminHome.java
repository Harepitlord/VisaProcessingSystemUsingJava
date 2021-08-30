package Admin;

import ClientRunner.ClientSocket;
import Database.Admin;
import Server.DataObject;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class AdminHome {

    private final ClientSocket socket;
    private JFrame frame;
    private JPanel panel1,panel2,panel3;
    private JLabel head,email,pass;
    private JTextField email1;
    private JPasswordField passno;
    private JButton login,home1,forget;
    private JLabel home;

    public AdminHome(ClientSocket socket){
        this.socket = socket;
        this.Interface();
    }
    private void Interface() {

        this.frameFunc();
        this.panelFunc();
        this.labelFunc();
        this.textFunc();
        this.buttonFunc();
        this.addElement();
        this.frame.setVisible(true);
    }


    private void frameFunc() {
        this.frame=new JFrame("Home");
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setBackground(Color.decode("#AED6F1"));
        this.frame.setResizable(true);
    }

    private void panelFunc() {
        this.panel1=new JPanel();
        this.panel2=new JPanel();
        this.panel3=new JPanel();

        this.panel2.setBackground(Color.decode("#AED6F1"));
        this.panel2.setLayout(null);

        this.panel3.setBackground(Color.white);
        this.panel3.setBounds(470, 250, 480, 350);
        this.panel3.setLayout(null);
        this.panel1.setBackground(Color.decode("#FFFFFF"));
        this.panel1.setBounds(0,0,1900,200);
        this.panel1.setLayout(null);
    }

    private void labelFunc() {
        ImageIcon top=new ImageIcon("src\\Resources\\home2.jpg");
        this.home=new JLabel();
        this.home.setIcon(top);
        this.home.setBounds(0, 30, 1384, 120);

        this.head =new JLabel("LOGIN");
        this.head.setForeground(Color.decode("#56AAE3"));
        this.head.setBounds(190, 0, 150, 53);
        this.email=new JLabel("Email-ID");
        this.email.setBounds(80, 60, 150, 30);
        this.pass = new JLabel("Password: ");
        this.pass.setBounds(80, 150, 150, 30);

    }

    private void textFunc() {
        this.email1=new JTextField();
        this.email1.setBounds(80, 100, 300, 40);
        this.passno=new JPasswordField();
        this.passno.setBounds(80,190,300,40);
    }

    private void buttonFunc() {
        this.login=new JButton("Login");
        this.login.setBounds(280, 300, 100, 40);
        this.login.setForeground(Color.white);
        this.login.setBackground(Color.decode("#56aae3"));
        this.login.addActionListener(e->{
            String uEmail = this.email1.getText();
            String uPass = this.passno.getText();
            Admin a = new Admin(uEmail,uPass);
            DataObject d = new DataObject(a);
            d.setOperation('A');
            if(socket.sendObject(d))
                d = socket.receiveObject();
            else {
                System.out.println("error in data");
            }
            if(d.getAdmin() == null)
                JOptionPane.showMessageDialog(this.frame,d.getMessage());
            else {
                new Home(socket, d.getAdmin());
                this.frame.dispose();
            }
        });

        this.home1=new JButton("Register");
        this.home1.setBounds(85, 300, 100, 40);
        this.home1.addActionListener(e-> {
            new Registration(socket);
            frame.dispose();
        });
        this.home1.setForeground(Color.white);
        this.home1.setBackground(Color.decode("#56aae3"));

        this.forget=new JButton("Forget Password?");
        this.forget.setBounds(250, 240, 150, 40);
        this.forget.setBackground(null);
        this.forget.setBorder(null);
        this.forget.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                forget.setForeground(new Color(86, 170, 227));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forget.setForeground(Color.black);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new ForgetPassword(socket);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });
        this.forget.addActionListener(e-> {
            new ForgetPassword(socket);
            this.frame.dispose();

        });
    }

    private void addElement() {
        this.panel3.add(head);
        this.panel3.add(email);
        this.panel3.add(email1);
        this.panel3.add(pass);
        this.panel3.add(passno);
        this.panel3.add(forget);
        this.panel3.add(login);
        this.panel3.add(home1);
        this.panel2.add(panel3);
        this.panel1.add(home);
        this.panel2.add(panel1);
        this.frame.add(panel2);
    }
}

