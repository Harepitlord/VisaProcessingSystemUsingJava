package Admin;

import ClientRunner.ClientSocket;
import Database.Admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home {

    // Data Members
    private JFrame frame;
    private Admin admin;
    private JPanel panel1,panel2,panel3,content_home,homepanel;
    private JLabel home;
    private JButton home1,logout,validate,view;
    private final ClientSocket socket;

    public Home(ClientSocket client){
        this.socket = client;
        this.Interface();
    }

    public Home(ClientSocket socket,Admin admin) {
        this.socket = socket;
        this.admin = admin;
        this.Interface();
    }

    private void Interface() {
        this.frameFunc();
        this.panelFunc();
        this.labelFunc();
        this.eventHandling();
        this.addActionListeners();
        this.addFunc();
        this.frame.setVisible(true);
    }

    private void frameFunc() {
        this.frame =new JFrame("Home");
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setSize(this.frame.getToolkit().getScreenSize());

    }

    private void panelFunc() {
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.content_home = new JPanel();

        this.panel1.setLayout(null);
        this.panel1.setBackground(Color.decode("#FFFFFF"));

        this.panel2.setBackground(Color.white);
        this.panel2.setBounds(300,150,900,50);
        this.panel2.setLayout(new FlowLayout(FlowLayout.LEFT,150,10));

        this.panel3.setBackground(Color.white);
        this.panel3.setBounds(1200,150,100,50);
        this.panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

        content_home.setBackground(Color.decode("#AED6F1"));
        content_home.setBounds(5, 225, 1350, 470);
    }

    private void labelFunc() {
        ImageIcon top=new ImageIcon("src\\Resources\\home2.jpg");
        this.home=new JLabel();
        this.home.setIcon(top);
        this.home.setBounds(0, 0, 1384, 120);

        this.validate=new JButton("Validate");
        this.validate.setBackground(Color.white);
        this.validate.setBorder(null);
        this.validate.setFont(new Font(null,Font.PLAIN,20));

        this.view=new JButton("View");
        this.view.setBackground(Color.white);
        this.view.setBorder(null);
        this.view.setFont(new Font(null,Font.PLAIN,20));

        this.logout=new JButton("Logout");
        this.logout.setBackground(Color.white);
        this.logout.setBorder(null);
        this.logout.setFont(new Font(null,Font.PLAIN,20));

        this.home1=new JButton("Home");
        this.home1.setBackground(Color.white);
        this.home1.setBorder(null);
        this.home1.setFont(new Font(null,Font.PLAIN,20));
    }



    private void eventHandling() {
        this.home1.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                home1.setForeground(Color.white);
                home1.setBackground(Color.decode("#AED6F1"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                home1.setForeground(Color.black);
                home1.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                content_home.setVisible(true);
                //content_home.setBackground(Color.decode("#AED6F1"));
                //content_home.setBounds(5, 225, 1350, 470);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        this.validate.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                validate.setForeground(Color.white);
                validate.setBackground(Color.decode("#AED6F1"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                validate.setForeground(Color.black);
                validate.setBackground(Color.white);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                content_home.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

        });

        this.view.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                view.setForeground(Color.white);
                view.setBackground(Color.decode("#AED6F1"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                view.setForeground(Color.black);
                view.setBackground(Color.white);
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
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    private void addFunc() {
        this.panel2.add(home1);
        this.panel2.add(validate);
        this.panel2.add(view);
        if(admin != null)
            this.panel3.add(logout);
        this.panel1.add(home);
        this.panel1.add(panel2);
        this.panel1.add(panel3);
        this.panel1.add(content_home);
        this.frame.add(panel1);
    }

    private void addActionListeners() {
        this.logout.addActionListener(e->{
            new AdminHome(socket);
            this.frame.dispose();
        });

        this.validate.addActionListener(e->{
            new ValidateForm(socket,admin);
            this.frame.dispose();
        });
    }


}
