package ClientRunner;

import Database.Admin;
import Admin.AdminHome;

import javax.swing.*;
import java.awt.*;

public class ClientRunner {

    // Data members
    private JFrame frame;
    private JButton admin,applyer;
    private JPanel extPanel,intPanel;
    private Dimension d;
    private final ClientSocket client;

    public ClientRunner() {

        this.prepareInterface();

        this.client = new ClientSocket("localhost",6201);
    }

    private void prepareInterface() {

        this.prepareFrames();

        this.preparePanels();

        this.prepareButtons();

        this.prepareButtonReactions();

        this.addElements();

        this.frame.setVisible(true);
    }

    private void prepareFrames() {
        this.frame = new JFrame("Visa Appplication");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.d = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setSize(d.width,d.height);
        this.frame.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    private void preparePanels() {
        this.extPanel =  new JPanel();
        this.intPanel = new JPanel();

        this.extPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.extPanel.setSize((int)(this.d.width*0.85),(int)(this.d.height*0.85));

        this.intPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.intPanel.setSize((int)(this.d.width*0.65),(int)(this.d.height*0.65));
    }

    private void prepareButtons() {
        this.admin = new JButton("Admin");
        this.applyer = new JButton("Appyler");

        this.admin.setBackground(Color.CYAN);
        this.admin.setForeground(Color.white);

        this.applyer.setForeground(Color.white);
        this.applyer.setBackground(Color.CYAN);
    }

    private void prepareButtonReactions() {
        this.admin.addActionListener(e->{
            new AdminHome(this.client);
            this.frame.dispose();
        });

        this.applyer.addActionListener(e->{
            new Client.Home(this.client);
            this.frame.dispose();
        });
    }

    private void addElements() {

        this.intPanel.add(this.admin);
        this.intPanel.add(this.applyer);

        this.extPanel.add(this.intPanel);

        this.frame.add(this.extPanel);
    }

    public static void main(String[] args) {
        new ClientRunner();
    }
}
