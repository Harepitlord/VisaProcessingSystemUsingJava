package Admin;

import ClientRunner.ClientSocket;
import Database.Admin;
import Database.VisaApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ListForm {

    // Data Members
    private final ClientSocket socket;
    private final ArrayList<VisaApplication> applications;
    private final Admin admin;
    private JFrame frame;
    private JPanel nav,content;
    private JLabel title;
    private JButton home,logout;
    JLabel jb_txt_Tit=new JLabel("Visa processing Management");
    private ArrayList<JPanel> panels;
    private final int gridHorizontal;
    Font f=new Font("Times New Roman",Font.BOLD,25);

    public ListForm() {
        socket = null;
        applications = new ArrayList<>();
        gridHorizontal = 0;
        admin = null;
        this.prepareInterface();
    }

    public ListForm(ClientSocket socket,Admin admin,ArrayList<VisaApplication> applications) {
        this.socket = socket;
        this.admin = admin;
        this.applications = applications;
        if(applications == null)
            this.gridHorizontal = 0;
        else
            this.gridHorizontal = applications.size();
        this.prepareInterface();
    }

    private void prepareInterface() {

        this.prepareFrames();
        this.preparePanels();
        this.prepareLabels();
        this.preparebuttons();
        this.prepareActionListeners();
        if(this.gridHorizontal >0)
            this.prepareApplications();
        this.prepareMouseListeners();
        this.addElements();
        this.frame.setVisible(true);

    }

    private void prepareActionListeners() {
        this.home.addActionListener(e->{
            new Home(socket,admin);
            this.frame.dispose();
        });

        this.logout.addActionListener(e->{
            new Home(socket);
            this.frame.dispose();
        });
    }

    private void prepareMouseListeners() {
        this.home.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                home.setForeground(new Color(86, 170, 227));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setForeground(Color.black);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });

        this.logout.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setForeground(new Color(86, 170, 227));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setForeground(Color.black);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
    }

    private void preparebuttons() {
        this.home = new JButton("Home");
        this.home.setFont(f);
        this.home.setBackground(Color.white);
        this.home.setForeground(Color.BLACK);
        this.home.setBorder(null);
        this.home.setBounds(800,230,150,50);

        this.logout = new JButton("Logout");
        this.logout.setFont(f);
        this.logout.setBackground(Color.white);
        this.logout.setForeground(Color.BLACK);
        this.logout.setBorder(null);
        this.logout.setBounds(1000,230,150,50);
    }

    private void prepareFrames() {
        this.frame = new JFrame("Visa Processing");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout(null);
        this.frame.setBackground(Color.decode("#AED6F1"));
        this.frame.setResizable(true);
        Dimension d = frame.getToolkit().getScreenSize();
        this.frame.setSize(d);
    }

    private void preparePanels() {
        this.nav = new JPanel();
        this.nav.setBounds(0,0,1920,300);
        this.nav.setBackground(Color.decode("#FFFFFF"));
        this.nav.setLayout(null);
        this.nav.setBorder(new EmptyBorder(new Insets(10,10,10,10)));

        this.content = new JPanel();
        this.content.setBorder(new EmptyBorder(new Insets(10,10,10,10)));
        if(this.gridHorizontal>0)
            this.content.setLayout(new GridLayout(this.applications.size(),1,10,10));
        else
            this.content.setLayout(null);
        this.content.setBackground(Color.decode("#AED6F1"));
        this.content.setAutoscrolls(true);
        this.content.setBounds(0,300,1920,700);
    }

    private void prepareLabels() {
        this.title = new JLabel();
        ImageIcon i = new ImageIcon("src\\Resources\\home2.jpg");
        this.title.setIcon(i);
        this.title.setBounds(250,0,1384,200);

        jb_txt_Tit.setFont(new Font(Font.DIALOG,  Font.BOLD, 35));
        jb_txt_Tit.setForeground(Color.RED);
        jb_txt_Tit.setBounds(720,170,500,50);

        if(gridHorizontal ==0) {
            JLabel info = new JLabel("No Visa Application pending");
            info.setFont(f);
            info.setBounds(800,300,400,100);
            this.content.add(info);
        }
    }

    private void prepareApplications() {
        panels = new ArrayList<>();
        for(VisaApplication v : applications) {
            JPanel temp = new JPanel();
            JLabel visaID = new JLabel(v.getVisaApplicationId());
            JLabel Name = new JLabel(v.getApplyer().getName());
            JLabel Country = new JLabel(v.getCountry());
            JLabel visa = new JLabel(v.getVisaType());
            temp.setLayout(new GridLayout(2,2,2,2));
            temp.add(visaID);
            temp.add(Name);
            temp.add(Country);
            temp.add(visa);

            panels.add(temp);
        }

    }


    private void addElements() {
        this.nav.add(title);
        this.nav.add(jb_txt_Tit);
        this.nav.add(home);
        this.nav.add(logout);

        if(gridHorizontal >0)
            for(JPanel j : panels)
                this.content.add(j);


        this.frame.add(content);
        this.frame.add(nav);
    }

    public static void main(String[] args) {
        new ListForm();
    }
}
