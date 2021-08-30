package Client;

import Admin.AdminHome;
import ClientRunner.ClientSocket;
import Database.VisaApplication;
import Database.VisaApplyer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StatusForm{

    // Data Members
    private final ClientSocket socket;
    private final VisaApplyer applyer;
    private final VisaApplication application;
    private JFrame frame;
    private JPanel panel1,panel2,panel3,panel4,panel5;
    private JLabel home,ID,name,status,country,indiamission,passporttype,visatype,arrested,exiled, TextId,textname,textstatus,textcountry,textindiamission,textpassporttype,textvisatype,textarrested,textexiled;
    private JButton home1,logout;

    public StatusForm(ClientSocket socket,VisaApplyer applyer,VisaApplication application){
        this.socket = socket;
        this.applyer = applyer;
        this.application = application;
        this.Interface();

    }

    private void Interface() {
        this.frameFunc();
        this.panelFunc();
        this.labelFunc();
        this.eventHandling();
        this.addActionListeners();
        this.addElement();
        this.frame.setVisible(true);
    }


    private void frameFunc() {
        this.frame =new JFrame("Status");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setResizable(true);
    }

    private void panelFunc() {
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.panel4 = new JPanel();
        this.panel5 = new JPanel();

        this.panel1.setLayout(null);
        this.panel1.setBackground(Color.decode("#FFFFFF"));

        this.panel2.setBackground(Color.white);
        this.panel2.setBounds(250,150,900,50);
        this.panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.panel3.setBackground(Color.white);
        this.panel3.setBounds(1200,150,100,50);
        this.panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

        this.panel4.setBackground(Color.decode("#AFD6F1"));
        this.panel4.setLayout(null);
        this.panel4.setBounds(5, 200, 1350, 500);

        this.panel5.setBackground(Color.decode("#FFFFFF"));
        this.panel5.setLayout(new GridLayout(10,1,10,5));
        this.panel5.setBounds(450,50,500,410);
        this.panel5.setBorder(new EmptyBorder(new Insets(10,10,20,20)));
        this.panel5.setPreferredSize(new Dimension());
    }

    private void labelFunc() {
        ImageIcon top=new ImageIcon("src\\Resources\\home2.jpg");
        this.home=new JLabel();
        this.home.setIcon(top);
        this.home.setBounds(0, 0, 1384, 120);

        this.home1=new JButton("Home");
        this.home1.setBackground(Color.white);
        this.home1.setBorder(null);
        this.home1.setFont(new Font(null,Font.PLAIN,20));

        this.logout=new JButton("Logout");
        this.logout.setBackground(Color.white);
        this.logout.setBorder(null);
        this.logout.setFont(new Font(null,Font.PLAIN,20));

        this.ID=new JLabel("Appication ID: ");
        this.name = new JLabel("Name: ");
        this.status = new JLabel("Status :");
        this.country=new JLabel("Country: ");
        this.indiamission =new JLabel("India Mission: ");
        this.passporttype = new JLabel("Passport Type: ");
        this.visatype = new JLabel("Visa Type: ");
        this.arrested = new JLabel("Arrested: ");
        this.exiled = new JLabel("Exiled: ");
        this.TextId = new JLabel(this.application.getVisaApplicationId());
        this.textname = new JLabel(this.application.getApplyer().getName());
        this.textstatus = new JLabel(this.application.getstatus());
        this.textcountry = new JLabel(this.application.getCountry());
        this.textindiamission = new JLabel(this.application.getIndianMission());
        this.textpassporttype = new JLabel(this.application.getPasswordType());
        this.textvisatype = new JLabel(this.application.getVisaType());
        this.textarrested = new JLabel(this.application.getArrested()==1 ?"True":"False");
        this.textexiled = new JLabel(this.application.getExiled()==1 ? "True":"False");
    }

    private void addActionListeners() {
        this.home1.addActionListener(e->{
            new Home(socket,applyer);
            this.frame.dispose();
        });

        this.logout.addActionListener(e->{
            new Home(socket);
            this.frame.dispose();
        });
    }

    private void addElement() {

        this.panel5.add(ID);
        this.panel5.add(TextId);
        this.panel5.add(name);
        this.panel5.add(textname);
        this.panel5.add(status);
        this.panel5.add(textstatus);
        this.panel5.add(country);
        this.panel5.add(textcountry);
        this.panel5.add(indiamission);
        this.panel5.add(textindiamission);
        this.panel5.add(passporttype);
        this.panel5.add(textpassporttype);
        this.panel5.add(visatype);
        this.panel5.add(textvisatype);
        this.panel5.add(arrested);
        this.panel5.add(textarrested);
        this.panel5.add(exiled);
        this.panel5.add(textexiled);

        this.panel2.add(home1);
        this.panel3.add(logout);
        this.panel4.add(panel5);

        this.panel1.add(home);
        this.panel1.add(panel2);
        this.panel1.add(panel3);
        this.panel1.add(panel4);
        this.frame.add(panel1);
    }

    private void eventHandling() {
        this.logout.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setForeground(Color.white);
                logout.setBackground(Color.decode("#AED6F1"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setForeground(Color.black);
                logout.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new AdminHome(socket);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
    }

}
