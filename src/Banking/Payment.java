package Banking;


import javax.swing.*;
import java.awt.*;


public class Payment extends JFrame {

    //Image Icons
    ImageIcon icon2 = new ImageIcon("src\\Resources\\emblem.jpg");
    //JPanels
    JPanel homePanel=new JPanel();
    //Labels for the Homepage
    JLabel lb_img_tit = new JLabel(icon2);
    JLabel lb_txt = new JLabel("Government Of India");
    JLabel jb_txt_Tit=new JLabel("Visa processing Management");
    JLabel head_one=new JLabel("Payment");
    //user login
    JLabel cardnolabel,cvvlabel,pinlabel;
    JTextField cardnofield;
    JPasswordField cvvfield,pinfield;
    JButton uforgotpass,paynow;
    //Font Style
    Font fnt_head  = new Font(Font.DIALOG,  Font.PLAIN, 20);
    Font fnt_txt_Tit  = new Font(Font.DIALOG,  Font.BOLD, 35);
    Font fnt_txt  = new Font(Font.DIALOG,  Font.BOLD, 30);
    Font fnt_text  = new Font("Times New Roman",Font.BOLD,19);
    public Payment() {


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
        head_one.setBackground(Color.WHITE);
        head_one.setForeground(Color.BLACK);

        ADDHOME(homePanel);
        add(homePanel);
        setLayout(null);
        setBounds(0, 3, 1922, 1044);
        setVisible(true);
        setTitle("VISA");

        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setDefaultCloseOperation(3);

        cardnolabel = new JLabel("Card Number");
        cardnolabel.setBounds(770,100,200,30);
        cardnolabel.setFont(fnt_head);
        homePanel.add(cardnolabel);

        cardnofield = new JTextField();
        cardnofield.setBounds(770,140,380,50);
        cardnofield.setFont(fnt_head);
        homePanel.add(cardnofield);

        cvvlabel= new JLabel("CVV");
        cvvlabel.setBounds(770,200,200,30);
        cvvlabel.setFont(fnt_head);
        homePanel.add(cvvlabel);

        cvvfield = new JPasswordField();
        cvvfield.setBounds(770,240,150,50);
        cvvfield.setFont(fnt_head);
        cvvfield.setVisible(true);
        homePanel.add(cvvfield);

        pinlabel= new JLabel("PIN");
        pinlabel.setBounds(1000,200,200,30);
        pinlabel.setFont(fnt_head);
        homePanel.add(pinlabel);

        pinfield = new JPasswordField();
        pinfield.setBounds(1000,240,150,50);
        pinfield.setFont(fnt_head);
        pinfield.setVisible(true);
        homePanel.add(pinfield);

        paynow = new JButton("Pay Now");
        paynow.setBounds(920,360,120,50);
        paynow.setFont(fnt_text);
        homePanel.add(paynow);
    }
    void ADDHOME(JPanel homePanel){
        homePanel.setLayout(null);
        homePanel.setBounds(20,330,1877,660);
        homePanel.setBackground(Color.decode("#AED6F1"));
        homePanel.setVisible(true);
    }
    public static void main(String[] h){
        new Payment();
    }
}


