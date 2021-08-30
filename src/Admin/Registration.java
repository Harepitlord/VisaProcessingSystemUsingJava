package Admin;

import Additional.DateClass;
import ClientRunner.ClientSocket;
import Database.Admin;
import Server.DataObject;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;
import javax.swing.*;
import javax.swing.border.*;
import Additional.Validation;

public class Registration implements ActionListener{

    // Data Members
    private final ClientSocket socket;
    private JFrame frame;
    private JPanel panel,panel1,panel2;
    private JLabel name,Ename,fathername,Efname,mothername,Emname,gender,Eadd,phoneno,Eph,Eaadhar,aadharno,Epassno,passportno,dob,address,email,Eemail,password,Epass,confirm,Econpass,topImage,top;
    private JTextField name1,fname,mname,add1,ph,aadhar1,pass_no,emailid;
    private JRadioButton g1,g2,g3;
    private JPasswordField pass,con_pass;
    private JDatePickerImpl datePicker;
    private final JPanel gender1= new JPanel(new GridLayout(1,3));
    JFileChooser file = new JFileChooser();
    private JButton register,login,home;

    public Registration(ClientSocket socket) {
        this.socket = socket;
        this.Interface();
    }

    private void Interface() {
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        this.datePicker = new JDatePickerImpl(datePanel,new DateClass());


        this.frameFunc();
        this.panelFunc();
        this.labelFunc();
        this.textFunc();
        this.passwordFunc();
        this.buttonFunc();
        this.errorFunc();
        this.addPanel();
        this.frame.setVisible(true);
    }


    private void frameFunc() {
        this.frame=new JFrame("Registration");
        this.frame.setSize(750,750);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setBackground(Color.decode("#AED6F1"));
        this.frame.setResizable(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void panelFunc() {

        this.panel=new JPanel();
        this.panel1=new JPanel();
        this.panel2=new JPanel();

        this.panel1.setBackground(Color.decode("#AED6F1"));
        this.panel1.setLayout(null);

        this.panel2.setBackground(Color.white);
        this.panel2.setBounds(180,150,1012,500);
        this.panel2.setLayout(null);

        this.panel.setBackground(Color.white);
        this.panel.setLayout(new GridLayout(15,1,5,5));
        this.panel.setBounds(250,50,500,450);
        this.panel.setBorder(new EmptyBorder(new Insets(10,10,10,20)));
        this.panel.setPreferredSize(new Dimension());
    }

    private void labelFunc() {
        this.name = new JLabel("<html><font> Name:</font><font color=red>*</font><html>");
        this.fathername = new JLabel("<html><font> Father's name: </font><font color=red>*</font><html>");
        this.mothername =new JLabel("<html><font> Mother's name:</font><font color=red>*</font><html> ");
        this.dob=new JLabel("<html><font> Date Of Birth: </font><font color=red>*</font><html> ");
        this.g1=new JRadioButton("male",false);
        this.g2=new JRadioButton("Female",false);
        this.g3=new JRadioButton("Others",false);
        this.gender=new JLabel("<html><font> Gender: </font><font color=red>*</font><html>");
        this.address=new JLabel("<html><font> Address:  </font><font color=red>*</font><html>");
        this.phoneno=new JLabel("<html><font> Phone Number:</font><font color=red>*</font><html> ");
        this.email=new JLabel("<html><font> Email-Id: </font><font color=red>*</font><html>");
        this.password=new JLabel("<html><font> Password:  </font><font color=red>*</font><html>");
        this.confirm=new JLabel("<html><font>Confirm Password:  </font><font color=red>*</font><html>");
        this.aadharno=new JLabel("<html><font>Aadhar Number: </font><font color=red>*</font><html> ");
    }

    private void textFunc() {
        ImageIcon topImageIcon=new ImageIcon("src\\Resources\\india2.png");
        this.topImage=new JLabel();
        this.topImage.setIcon(topImageIcon);
        this.topImage.setBounds(180,7,1013,170);


        ImageIcon top1=new ImageIcon("src\\Resources\\ind.jpg");
        this.top=new JLabel();
        this.top.setIcon(top1);
        this.top.setBounds(0,2,988,27);

        ImageIcon top2=new ImageIcon("src\\Resources\\1.jpg");
        this.home=new JButton("");
        this.home.setIcon(top2);
        this.home.setBounds(988,4,25,23);
        this.home.addActionListener(this);
        this.home.setBorder(null);

        this.name1=new JTextField();
        this.fname=new JTextField();
        this.mname=new JTextField();
        ButtonGroup b=new ButtonGroup();
        b.add(g1);b.add(g2);b.add(g3);
        this.add1=new JTextField();
        this.ph=new JTextField("",10);
        this.emailid=new JTextField();
        this.aadhar1=new JTextField();

    }


    private void passwordFunc() {
        this.pass=new JPasswordField();
        this.con_pass =new JPasswordField();
    }


    private void buttonFunc() {
        this.register=new JButton("Register");
        this.register.addActionListener(this);
        this.login=new JButton("Login");
        this.login.addActionListener(this);

    }


    private void addPanel() {
        this.panel1.add(topImage);
        this.panel2.add(top);
        this.panel2.add(home);
        this.panel.add(this.name);
        this.panel.add(this.name1);
        this.panel.add(this.fathername);
        this.panel.add(this.fname);
        this.panel.add(this.mothername);
        this.panel.add(this.mname);
        this.panel.add(this.dob);
        this.panel.add(this.datePicker);
        this.panel.add(this.gender);
        gender1.add(this.g1);
        gender1.add(this.g2);
        gender1.add(this.g3);
        this.gender1.setBackground(Color.white);
        this.panel.add(gender1);
        this.panel.add(this.address);
        this.panel.add(this.add1);
        this.panel.add(this.phoneno);
        this.panel.add(this.ph);
        this.panel.add(this.email);
        this.panel.add(this.emailid);
        this.panel.add(this.password);
        this.panel.add(this.pass);
        this.panel.add(this.confirm);
        this.panel.add(this.con_pass);
        this.panel.add(this.aadharno);
        this.panel.add(this.aadhar1);
        this.panel.add(this.register);
        this.panel.add(this.login);
        JScrollBar sb2  = new JScrollBar(JScrollBar.HORIZONTAL);
        this.frame.add(sb2);
        this.panel2.add(this.panel);
        this.panel1.add(this.panel2);
        this.frame.add(this.panel1);
    }

    private void errorFunc() {
        // TODO Auto-generated method stub
        this.Ename = new JLabel(" *Invalid name");
        this.Ename.setBounds(730, 65, 90, 10);
        this.Ename.setForeground(Color.red);
        this.Ename.setVisible(false);
        this.panel2.add(Ename);

        this.Efname = new JLabel(" *Invalid name");
        this.Efname.setBounds(730, 95, 90, 10);
        this.Efname.setForeground(Color.red);
        this.Efname.setVisible(false);
        this.panel2.add(Efname);

        this.Emname = new JLabel(" *Invalid name");
        this.Emname.setBounds(730, 125, 90, 10);
        this.Emname.setForeground(Color.red);
        this.Emname.setVisible(false);
        this.panel2.add(Emname);

        this.Eadd = new JLabel(" *Invalid Address");
        this.Eadd.setBounds(730, 215, 120, 10);
        this.Eadd.setForeground(Color.red);
        this.Eadd.setVisible(false);
        this.panel2.add(Eadd);

        this.Eph = new JLabel(" *Invalid Phone number");
        this.Eph.setBounds(730, 240, 150, 10);
        this.Eph.setForeground(Color.red);
        this.Eph.setVisible(false);
        this.panel2.add(Eph);

        this.Eemail = new JLabel(" *Invalid Email");
        this.Eemail.setBounds(730, 270, 90, 10);
        this.Eemail.setForeground(Color.red);
        this.Eemail.setVisible(false);
        this.panel2.add(Eemail);

        this.Epass = new JLabel(" *Invalid Password");
        this.Epass.setBounds(730, 300, 120, 10);
        this.Epass.setForeground(Color.red);
        this.Epass.setVisible(false);
        this.panel2.add(Epass);

        this.Econpass = new JLabel(" *Mismatch Password");
        this.Econpass.setBounds(730, 330, 150, 10);
        this.Econpass.setForeground(Color.red);
        this.Econpass.setVisible(false);
        this.panel2.add(Econpass);

        this.Eaadhar = new JLabel(" *Invalid Aadhar number");
        this.Eaadhar.setBounds(730, 360, 180, 10);
        this.Eaadhar.setForeground(Color.red);
        this.Eaadhar.setVisible(false);
        this.panel2.add(Eaadhar);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Register":
            {
                int temp=0;
                Ename.setVisible(false);
                Efname.setVisible(false);
                Emname.setVisible(false);
                Eadd.setVisible(false);
                Eph.setVisible(false);
                Eemail.setVisible(false);
                Epass.setVisible(false);
                Econpass.setVisible(false);
                Eaadhar.setVisible(false);
                String gender="male";
                if(g1.isSelected()){
                    gender="Male";
                }
                else if(g2.isSelected()) {
                    gender="Female";
                }
                else {
                    gender="Others";
                }
                if(!Validation.checkName(name1.getText())){
                    Ename.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkName(fname.getText())){
                    Efname.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkName(mname.getText())){
                    Emname.setVisible(true);
                    temp=1;
                }
                if(add1.getText().length()<=5){
                    Eadd.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkPhone(ph.getText())){
                    Eph.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkMail(emailid.getText())){
                    Eemail.setVisible(true);
                    temp=1;
                }

                if((!(Validation.checkPassword(pass.getText())))) {
                    Epass.setVisible(true);
                    temp=1;
                }
                if(!pass.getText().equals(con_pass.getText())) {
                    Econpass.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkAadhar(aadhar1.getText())){
                    Eaadhar.setVisible(true);
                    temp=1;
                }

                if(temp==0){

                    Admin m=new Admin();
                    m.setName(name1.getText());
                    m.setFatherName(fname.getText());
                    m.setMotherName(mname.getText());
                    m.setAddress(add1.getText());
                    m.setGender(gender);
                    m.setDOB((Date) this.datePicker.getModel().getValue());
                    m.setEmail(emailid.getText());
                    m.setPhoneNumber(ph.getText());
                    m.setPassword(pass.getText());
                    m.setAadhar(aadhar1.getText());
                    DataObject d = new DataObject(m);
                    d.setOperation('E');
                    if(socket.sendObject(d))
                        d = socket.receiveObject();
                    else
                        JOptionPane.showMessageDialog(frame,"Data Sending failed","signup",JOptionPane.INFORMATION_MESSAGE);
                    if(d != null) {
                        JOptionPane.showMessageDialog(frame, "Sign up Successfully", "signup", JOptionPane.INFORMATION_MESSAGE);
                        new Home(socket,d.getAdmin());
                        this.frame.dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Please check the Credentials","signup",JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }

            case "Login": {
                new Home(socket);
                break;
            }

            case "": {
                new AdminHome(socket);
                break;
            }
        }


    }
}

