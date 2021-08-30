package Client;

import Additional.Validation;
import ClientRunner.ClientSocket;
import Database.VisaApplyer;
import Server.DataObject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class LoginForm extends JFrame {

    // Data Members
    private ClientSocket socket;
    //Image Icons
    ImageIcon icon2 = new ImageIcon("src\\Resources\\emblem.jpg");
    //JPanels
    JPanel homePanel=new JPanel();
    //Labels for the Homepage
    JLabel lb_img_tit = new JLabel(icon2);
    JLabel lb_txt = new JLabel("Government Of India");
    JLabel jb_txt_Tit=new JLabel("Visa processing Management");
    JLabel head_one=new JLabel("User Login");
    //user login
    JLabel Email,upasswordlabel;
    JTextField EmailField;
    JPasswordField upasswordfield;
    JButton uforgotpass,uhome,ulogin;
    JCheckBox ushowpass;




    //Font Style
    Font fnt_head  = new Font(Font.DIALOG,  Font.PLAIN, 20);
    Font fnt_txt  = new Font(Font.DIALOG,  Font.BOLD, 30);
    Font fnt_text  = new Font("Times New Roman",Font.BOLD,19);
    Font fnt_text_Inst  = new Font("Baskerville Old Face",Font.BOLD,21);
    Font fnt_txt_Tit  = new Font(Font.DIALOG,  Font.BOLD, 35);
    Font InstHead=new Font("Baskerville Old Face",Font.BOLD,35);
    Font InstSubHead=new Font("Conv_ROCKB",Font.BOLD,23);





    public LoginForm(ClientSocket socket) {

        this.socket = socket;

        //Alignments
        lb_img_tit.setBounds(910, 0, 100, 150);
        add(lb_img_tit);
        lb_txt.setBounds(820, 140, 450, 50);
        lb_txt.setFont(fnt_txt);
        jb_txt_Tit.setFont(fnt_txt_Tit);
        jb_txt_Tit.setForeground(Color.RED);
        jb_txt_Tit.setBounds(720,170,500,50);
        head_one.setBounds(920,250,150,50);
        head_one.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        add(head_one);


        add(jb_txt_Tit);
        add(lb_img_tit);
        add(lb_txt);
        head_one.setOpaque(true);

        //Event Handling

        head_one.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_one.setBackground(Color.decode("#AED6F1"));
                head_one.setForeground(Color.WHITE);

            }
        });

        head_one.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ADDHOME(homePanel);
                Email.setVisible(true);
                EmailField.setVisible(true);
                upasswordlabel.setVisible(true);
                upasswordfield.setVisible(true);
                ushowpass.setVisible(true);
                uforgotpass.setVisible(true);
                uhome.setVisible(true);
                ulogin.setVisible(true);
            }
        });



        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_one.setBackground(Color.WHITE);
                head_one.setForeground(Color.BLACK);


            }
        });


        ADDHOME(homePanel);
        add(homePanel);
        setLayout(null);
        setBounds(0, 3, 1922, 1044);
        setVisible(true);
        setTitle("VISA");

        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setDefaultCloseOperation(3);

        Email = new JLabel("Passport Number");
        Email.setBounds(770,100,200,30);
        Email.setFont(fnt_head);
        homePanel.add(Email);

        EmailField = new JTextField();
        EmailField.setBounds(770,140,380,50);
        EmailField.setFont(fnt_head);
        homePanel.add(EmailField);

        upasswordlabel= new JLabel("Password");
        upasswordlabel.setBounds(770,200,200,30);
        upasswordlabel.setFont(fnt_head);
        homePanel.add(upasswordlabel);

        upasswordfield = new JPasswordField();
        upasswordfield.setBounds(770,240,380,50);
        upasswordfield.setFont(fnt_head);
        upasswordfield.setVisible(true);
        homePanel.add(upasswordfield);

        ushowpass = new JCheckBox("Show Password");
        ushowpass.setBounds(770,295,175,30);
        ushowpass.setFont(new Font("Times New Roman",Font.BOLD,19));
        ushowpass.setOpaque(false);
        ushowpass.setContentAreaFilled(false);
        ushowpass.setFocusPainted(false);
        ushowpass.setBorder(null);
        homePanel.add(ushowpass);
        ushowpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ushowpass.isSelected()){
                    upasswordfield.setEchoChar((char)0);
                }
                else{
                    upasswordfield.setEchoChar('*');
                }
            }
        });

        uforgotpass = new JButton("Forgot Password ?");
        uforgotpass.setBounds(950,295,220,30);
        uforgotpass.setFont(new Font("Times New Roman",Font.BOLD,19));
        uforgotpass.setOpaque(false);
        uforgotpass.setContentAreaFilled(false);
        uforgotpass.setFocusPainted(false);
        uforgotpass.setBorder(null);
        homePanel.add(uforgotpass);

        uhome = new JButton("Home");
        uhome.setBounds(770,360,90,50);
        uhome.setFont(fnt_text);
        homePanel.add(uhome);

        ulogin = new JButton("Login");
        ulogin.setBounds(1050,360,90,50);
        ulogin.setFont(fnt_text);
        homePanel.add(ulogin);

        ulogin.addActionListener(e->{
            String email = null,pass=null;
            if( Validation.checkMail(EmailField.getText()))
                email = EmailField.getText();
            if(Validation.checkPassword(upasswordfield.getText()))
                pass = new String(upasswordfield.getPassword());

            VisaApplyer applyer = new VisaApplyer(email,pass);
            if(!socket.sendObject(new DataObject(applyer)))
                JOptionPane.showMessageDialog(this,"Server Error");
            else {
                applyer = socket.receiveObject().getApplyer();
                new Home(socket,applyer);
                dispose();
            }

        });
    }
    void ADDHOME(JPanel homePanel){
        homePanel.setLayout(null);
        homePanel.setBounds(20,330,1877,660);
        homePanel.setBackground(Color.decode("#AED6F1"));
        homePanel.setVisible(true);
    }
}
