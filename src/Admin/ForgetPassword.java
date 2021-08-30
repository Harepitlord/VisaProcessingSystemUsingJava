package Admin;

import ClientRunner.ClientSocket;
import Database.Admin;
import Server.DataObject;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
public class ForgetPassword implements ActionListener {
    //private Registration r;
    private ClientSocket socket;
    private JFrame frame;
    private JPanel panel1,panel2,panel3;
    private JLabel email,pass,confirm;
    private JTextField email1;
    private JPasswordField passno,conpass;
    private JButton update;
    private JLabel home;

    public ForgetPassword(ClientSocket socket){
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
        this.panel3.setBounds(420, 250, 600, 350);
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

        this.email=new JLabel("Email-ID");
        this.email.setBounds(150, 20, 150, 30);

        this.pass = new JLabel("Password: ");
        this.pass.setBounds(150, 100, 150, 30);

        this.confirm = new JLabel("Confirm Password: ");
        this.confirm.setBounds(150, 180, 150, 30);

    }

    private void textFunc() {
        this.email1=new JTextField();
        this.email1.setBounds(150, 60, 300, 40);
        this.passno=new JPasswordField();
        this.passno.setBounds(150,140,300,40);
        this.conpass=new JPasswordField();
        this.conpass.setBounds(150,220,300,40);
    }

    private void buttonFunc() {
        this.update=new JButton("Update");
        this.update.setBounds(240, 280, 100, 40);
        this.update.addActionListener(this);
    }

    private void addElement() {
        this.panel3.add(email);
        this.panel3.add(email1);
        this.panel3.add(pass);
        this.panel3.add(passno);
        this.panel3.add(confirm);
        this.panel3.add(conpass);
        this.panel3.add(update);
        this.panel2.add(panel3);
        this.panel1.add(home);
        this.panel2.add(panel1);
        this.frame.add(panel2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String email = this.email1.getText();
        String pass = this.passno.getText();
        DataObject d = new DataObject(new Admin(email,pass));
        d.setOperation('B');
        if(socket.sendObject(d))
            d = socket.receiveObject();
        else
            JOptionPane.showMessageDialog(frame, "Server error","Updated",JOptionPane.INFORMATION_MESSAGE);
        System.out.println(d.getMessage());
        JOptionPane.showMessageDialog(frame, "Password has been changed successfully. U can go back to Login page","Updated",JOptionPane.INFORMATION_MESSAGE);
        new Home(socket,d.getAdmin());
        this.frame.dispose();

    }
}