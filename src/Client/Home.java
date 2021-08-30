package Client;

import ClientRunner.ClientSocket;
import Database.VisaApplyer;
import Server.DataObject;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

public class Home extends JFrame{

    ClientSocket socket;
    VisaApplyer applyer;

    //Image Icons
    Image icon1 = Toolkit.getDefaultToolkit().getImage("src\\Resources\\Title.jpg");
    ImageIcon icon2 = new ImageIcon("src\\Resources\\emblem.jpg");
    ImageIcon Log_Img = new ImageIcon("src\\Resources\\Login.jpg");
    ImageIcon Reg_Img = new ImageIcon("src\\Resources\\Register.jpg");
    ImageIcon Sta_Img = new ImageIcon("src\\Resources\\Status.jpg");
    ImageIcon Viw_Img = new ImageIcon("src\\Resources\\View.jpg");

    //JPanels
    JPanel homePanel=new JPanel();
    JPanel Instructions=new JPanel();
    JPanel Category=new JPanel();
    JPanel Provision =new JPanel();
    JPanel Protime =new JPanel();
    JPanel ProFees=new JPanel();


    //Labels for the Homepage
    JLabel lb_img_tit = new JLabel(icon2);
    JLabel lb_txt = new JLabel("Government Of India");
    JLabel jb_txt_Tit=new JLabel("Visa processing Management");
    JLabel head_one=new JLabel("   Home  ");
    JLabel head_two=new JLabel("   Instructions  ");
    JLabel head_three=new JLabel("   Visa Categories  ");
    JLabel head_four=new JLabel("   Visa Provisions  ");
    JLabel head_five=new JLabel("   Visa Provision Time  ");
    JLabel head_six=new JLabel("   Visa Fees  ");
    JLabel Inst=new JLabel();
    JLabel one=new JLabel("  1");
    JLabel oneTxt=new JLabel("Apply Online");
    JLabel oneTxtInst=new JLabel("Fill and Submit Visa Application Form Securely.");
    JLabel two=new JLabel("  2");
    JLabel twoTxt=new JLabel("Submit Documents");
    JLabel twoTxtInst=new JLabel("Submit your application with required ");
    JLabel twoTxtInstlo=new JLabel("documents at Indian Visa Application Center or at");
    JLabel twoTxtInstlt=new JLabel("Indian Mission.");
    JLabel three=new JLabel("  3");
    JLabel threeTxt=new JLabel("Receive Passport, visa");
    JLabel threeTxtInst=new JLabel("Collect your passport/visa from");
    JLabel threeTxtInstlo=new JLabel("Indian Mission/Visa Application Center");
    JLabel threeTxtInstlt=new JLabel("or by post.");
    JLabel LBtn_Ins_one=new JLabel("REGULAR/PAPER VISA");
    JLabel LBtn_Ins_two;
    JLabel Reg_Ins_one=new JLabel("COMPLETE REGISTRATION FORM");
    JLabel Reg_Ins_two=new JLabel("REGULAR/PAPER VISA");
    JLabel Sta_Ins_one=new JLabel("CHECK YOUR VISA STATUS");
    JLabel viw_Ins_one=new JLabel("VIEW REGISTRED");
    JLabel viw_Ins_two=new JLabel("APPLICATION FORM");


    //Buttons for Homepage
    JButton Login_Btn=new JButton(Log_Img);
    JButton Reg_Btn=new JButton(Reg_Img);
    JButton Sta_Btn=new JButton(Sta_Img);
    JButton viw_Btn=new JButton(Viw_Img);


    //Labels for Instruction page
    JLabel inst=new JLabel("Instructions:-");
    JLabel undln=new JLabel();
    JLabel Inhead=new JLabel("A. Online Application Form:-");
    JLabel InPtOne=new JLabel(" ●   This application form is meant for Indians who are applying for visa for other countries.");
    JLabel InPtTwo=new JLabel(" ●   Each online application form is meant for one person only. Separate application has to be filed for each applicant.");
    JLabel Inptthr=new JLabel(" ●  Furnish information exactly in the manner asked for in the forms, especially the names, address and date of birth.");
    JLabel InPtfr=new JLabel(" ●  Applicants are required to verify the application details before submitting the online application. They have an option to save the online application form, in case it is not to be submitted.");
    JLabel InPtFiv=new JLabel(" ●  Once the online application form is submitted by the applicant, then further modifications are not allowed. Hence applicants are requested to check and validate the details before submitting");
    JLabel InPtFivOn=new JLabel("    the online application form.");
    JLabel InPtSX=new JLabel(" ●  Applicants are requested to keep the Application Id (generated automatically after the submission of online form) for further communications.");
    JLabel InPic=new JLabel("B. Appointment Scheduling:-");
    JLabel InPicone=new JLabel(" ●  Applicant can schedule the appointment as per his/ her convenience with the concerned Indian Mission.");
    JLabel InPitwo=new JLabel(" ●  Each applicant to schedule a separate appointment with the Indian Mission");
    JLabel Apoint=new JLabel("C. Process for filling up online application form:-");
    JLabel ApOne=new JLabel(" ●  Applicant fills the application on-line as per the forms standardized by the Ministry.");
    JLabel ApTwo=new JLabel(" ●  After filling the form and submitting it, the system shall automatically generate a Application Id. Applicants are requested to keep this Application Id for further communications with the");
    JLabel ApTwoOne=new JLabel("   concerned Indian Mission.");
    JLabel Apthr=new JLabel(" ●  System will automatically ask the Applicant for the following confirmation: Select 'Yes' if the applicant want to seek appointment and make payment online or 'No' if the applicant just want to");
    JLabel ApthreOne=new JLabel("   print the submitted application form.");


    //Labels for Visa Category
    JLabel catHed=new JLabel("Visa Categories:-");
    JLabel TrstVisa=new JLabel("     Tourist Visa");
    JLabel Stdvisa=new JLabel("     Student Visa");
    JLabel BussVisa=new JLabel("     Business Visa");
    JLabel EmytVisa=new JLabel("     Employment Visa");
    JLabel lnterVisa=new JLabel("     Long Term Visa");


    //Labels For Visa Provisions
    JLabel Prohead=new JLabel("Visa Provision:-");


    //Labels for Provision time
    JLabel ProHead =new JLabel("Visa Processing Time:-");
    JTextArea ProTimeTxt=new JTextArea("●  Upon receipt of the Visa Application through Indian Visa Application Center or directly, the Indian Mission/ Post requires a minimum of three working days to process the case and issue a visa \n" +
            "\n  depending upon the nationality and excluding special cases.");


    //Labels For Provision Fees
    JLabel ProFeeHead=new JLabel("Visa Fees:-");
    JTextArea ProFeeTxt=new JTextArea("●  The fee depends upon the type of applied for and it's duration of visa. Visa fee is divided into various types depending\n" +
            "\n  upon the case viz; basic fee, special fee, processing fee by out-sourcing agency.During the online registration process, at\n" +
            "\n  the end of the process the basic fee shall be displayed. However, this fee shall be indicative only and final fee shall be \n" +
            "\n  charged while submitting the application at the respective counters Fee once received are non refundable even if the visa \n" +
            "\n  application is withdrawn, the visa is not granted, or if visa issued is of shorter duration of period than applied for or \n" +
            "\n  otherwise issued or returned at a time or on terms and conditions that may vary from those sought by the applicant. For further\n" +
            "\n  information on this, please check with local embassy office or Indian Visa Application center office or websites for information\n" +
            "\n  on applicable fee and payment methods.");


    //Font Style
    Font fnt_head  = new Font(Font.DIALOG,  Font.PLAIN, 20);
    Font fnt_txt  = new Font(Font.DIALOG,  Font.BOLD, 30);
    Font fnt_text  = new Font("Times New Roman",Font.BOLD,19);
    Font Tabel_text  = new Font("Times New Roman",Font.BOLD,22);
    Font fnt_text_Inst  = new Font("Baskerville Old Face",Font.BOLD,21);
    Font fnt_txt_Tit  = new Font(Font.DIALOG,  Font.BOLD, 35);
    Font InstHead=new Font("Baskerville Old Face",Font.BOLD,35);
    Font InstSubHead=new Font("Bookman Old Style",Font.BOLD,23);


    //ScrollBar
    JScrollPane scroll=new JScrollPane(Instructions,22,31);


    public Home(ClientSocket socket) {
        prepareInterface();
        this.socket = socket;
        LBtn_Ins_two=new JLabel("LOGIN");
    }

    public Home(ClientSocket socket, VisaApplyer applyer) {
        prepareInterface();
        this.socket = socket;
        this.applyer = applyer;
        LBtn_Ins_two=new JLabel("LOGOUT");
    }

    private void prepareInterface() {
        //Alignments
        lb_img_tit.setBounds(910, 0, 100, 150);
        add(lb_img_tit);
        lb_txt.setBounds(820, 140, 450, 50);
        lb_txt.setFont(fnt_txt);
        jb_txt_Tit.setFont(fnt_txt_Tit);
        jb_txt_Tit.setForeground(Color.RED);
        jb_txt_Tit.setBounds(720,170,500,50);
        head_one.setBounds(440,250,90,50);
        head_one.setFont(fnt_head);
        head_one.setOpaque(true);
        head_two.setBounds(550,250,130,50);
        head_two.setFont(fnt_head);
        head_two.setOpaque(true);
        head_three.setBounds(740,250,170,50);
        head_three.setFont(fnt_head);
        head_three.setOpaque(true);
        head_four.setBounds(950,250,170,50);
        head_four.setFont(fnt_head);
        head_four.setOpaque(true);
        head_five.setBounds(1160,250,210,50);
        head_five.setFont(fnt_head);
        head_five.setOpaque(true);
        head_six.setBounds(1410,250,130,50);
        head_six.setFont(fnt_head);
        head_six.setOpaque(true);

        //Adding to frame
        add(head_one);
        add(head_two);
        add(head_three);
        add(head_four);
        add(head_five);
        add(head_six);
        add(jb_txt_Tit);
        add(lb_img_tit);
        add(lb_txt);

        // ActionListeners
        Login_Btn.addActionListener(e->{
            if(applyer == null)
                new LoginForm(socket);
            else
                new Home(socket);
            dispose();
        });

        Reg_Btn.addActionListener(e->{
            if(applyer == null) {
                new RegistrationForm(socket);
                dispose();
            }
        });

        Sta_Btn.addActionListener(e->{
            if(applyer != null) {
                DataObject d = new DataObject(applyer);
                d.setOperation('L');
                socket.sendObject(d);
                new StatusForm(socket, applyer,socket.receiveObject().getVisaApplication());
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this,"Please Login");
            }

        });

        viw_Btn.addActionListener(e->{
            if(applyer != null) {
                new UpdateForm(socket, applyer);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this,"Please Login");
            }
        });


        //Event Handling
        TrstVisa.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                TrstVisa.setBackground(Color.BLUE);
                TrstVisa.setForeground(Color.WHITE);
            }
        });
        Stdvisa.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Stdvisa.setBackground(Color.BLUE);
                Stdvisa.setForeground(Color.WHITE);
            }
        });
        BussVisa.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                BussVisa.setBackground(Color.BLUE);
                BussVisa.setForeground(Color.WHITE);
            }
        });
        EmytVisa.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                EmytVisa.setBackground(Color.BLUE);

                EmytVisa.setForeground(Color.WHITE);
            }
        });
        lnterVisa.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                lnterVisa.setBackground(Color.BLUE);
                lnterVisa.setForeground(Color.WHITE);
            }
        });

        Login_Btn.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Login_Btn.setBorderPainted(true);
            }
        });
        Reg_Btn.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Reg_Btn.setBorderPainted(true);
            }
        });
        Sta_Btn.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Sta_Btn.setBorderPainted(true);
            }
        });
        viw_Btn.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                viw_Btn.setBorderPainted(true);
            }
        });
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
            }
        });
        head_two.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_two.setBackground(Color.decode("#AED6F1"));
                head_two.setForeground(Color.WHITE);
            }
        });
        head_two.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                instructions(Instructions);
            }
        });
        head_three.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_three.setBackground(Color.decode("#AED6F1"));
                head_three.setForeground(Color.WHITE);
            }
        });
        head_three.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                visaCategory(Category);
            }
        });
        head_four.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_four.setBackground(Color.decode("#AED6F1"));
                head_four.setForeground(Color.WHITE);
            }
        });
        head_four.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                provision(Provision);
            }
        });
        head_five.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_five.setBackground(Color.decode("#AED6F1"));
                head_five.setForeground(Color.WHITE);
            }
        });
        head_five.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProTime(Protime);
            }
        });
        head_six.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                head_six.setBackground(Color.decode("#AED6F1"));
                head_six.setForeground(Color.WHITE);
            }
        });
        head_six.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProFee(ProFees);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                //Home Pannel Colour change
                head_one.setBackground(Color.WHITE);
                head_one.setForeground(Color.BLACK);
                head_two.setForeground(Color.BLACK);
                head_two.setBackground(Color.WHITE);
                head_three.setForeground(Color.BLACK);
                head_three.setBackground(Color.WHITE);
                head_four.setForeground(Color.BLACK);
                head_four.setBackground(Color.WHITE);
                head_five.setForeground(Color.BLACK);
                head_five.setBackground(Color.WHITE);
                head_six.setForeground(Color.BLACK);
                head_six.setBackground(Color.WHITE);

                //Category Colour change
                TrstVisa.setBackground(Color.WHITE);
                TrstVisa.setForeground(Color.black);
                Stdvisa.setBackground(Color.WHITE);
                Stdvisa.setForeground(Color.black);
                BussVisa.setBackground(Color.WHITE);
                BussVisa.setForeground(Color.black);
                EmytVisa.setBackground(Color.WHITE);
                EmytVisa.setForeground(Color.black);
                lnterVisa.setBackground(Color.WHITE);
                lnterVisa.setForeground(Color.black);

                //Button Border Disappear
                Login_Btn.setBorderPainted(false);
                Login_Btn.setFocusPainted(false);
                Reg_Btn.setBorderPainted(false);
                Reg_Btn.setFocusPainted(false);
                Sta_Btn.setBorderPainted(false);
                Sta_Btn.setFocusPainted(false);
                viw_Btn.setBorderPainted(false);
                viw_Btn.setFocusPainted(false);


            }
        });

        add(Provision);
        add(scroll);
        add(Category);
        add(Protime);
        add(ProFees);
        ADDHOME(homePanel);
        add(homePanel);
        setLayout(null);
        setBounds(0, 3, 1922, 1044);
        setVisible(true);
        setTitle("VISA");
        setIconImage(icon1);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setDefaultCloseOperation(3);
    }
    void ADDHOME(JPanel homePanel){
        homePanel.setLayout(null);
        //Alingment
        homePanel.setBounds(20,330,1877,660);
        Inst.setBounds(70,50,800,50);
        one.setBounds(370,180,60,35);
        oneTxt.setBounds(340,220,139,50);
        oneTxtInst.setBounds(210,255,430,50);
        two.setBounds(950,180,60,35);
        twoTxt.setBounds(890,220,190,50);
        twoTxtInst.setBounds(825,255,370,50);
        twoTxtInstlo.setBounds(775,275,480,50);
        twoTxtInstlt.setBounds(910,295,300,50);
        three.setBounds(1500,180,60,35);
        threeTxt.setBounds(1430,220,230,50);
        threeTxtInst.setBounds(1400,255,370,50);
        threeTxtInstlo.setBounds(1365,275,480,50);
        threeTxtInstlt.setBounds(1480,295,300,50);
        Login_Btn.setBounds(230,400,65,81);
        LBtn_Ins_one.setBounds(160,480,250,50);
        LBtn_Ins_two.setBounds(226,500,200,50);
        Reg_Btn.setBounds(700,400,65,73);
        Reg_Ins_one.setBounds(550,480,500,50);
        Reg_Ins_two.setBounds(600,500,250,50);
        Sta_Btn.setBounds(1170,400,80,81);
        Sta_Ins_one.setBounds(1070,480,500,50);
        viw_Btn.setBounds(1640,400,68,67);
        viw_Ins_one.setBounds(1590,480,500,50);
        viw_Ins_two.setBounds(1577,500,250,50);


        //Colour
        homePanel.setBackground(Color.decode("#AED6F1"));
        Inst.setForeground( Color.WHITE);
        one.setBackground(Color.BLUE);
        one.setForeground(Color.WHITE);
        two.setBackground(Color.BLUE);
        two.setForeground(Color.WHITE);
        three.setBackground(Color.BLUE);
        three.setForeground(Color.WHITE);


        //Font
        one.setFont(fnt_txt_Tit);
        Inst.setFont(fnt_txt);
        oneTxt.setFont(fnt_text_Inst);
        oneTxtInst.setFont(fnt_text);
        two.setFont(fnt_txt_Tit);
        twoTxt.setFont(fnt_text_Inst);
        twoTxtInst.setFont(fnt_text);
        twoTxtInstlo.setFont(fnt_text);
        twoTxtInstlt.setFont(fnt_text);
        three.setFont(fnt_txt_Tit);
        threeTxt.setFont(fnt_text_Inst);
        threeTxtInst.setFont(fnt_text);
        threeTxtInstlo.setFont(fnt_text);
        threeTxtInstlt.setFont(fnt_text);
        LBtn_Ins_one.setFont(fnt_text);
        LBtn_Ins_two.setFont(fnt_text);
        Reg_Ins_one.setFont(fnt_text);
        Reg_Ins_two.setFont(fnt_text);
        Sta_Ins_one.setFont(fnt_text);
        viw_Ins_one.setFont(fnt_text);
        viw_Ins_two.setFont(fnt_text);


        //SetText
        Inst.setText("THREE STEP REGULAR VISA APPLICATION PROCESS");


        //Pannel visible
        Category.setVisible(false);
        scroll.setVisible(false);
        Provision.setVisible(false);
        Protime.setVisible(false);
        ProFees.setVisible(false);
        homePanel.setVisible(true);



        //SetOpaque
        one.setOpaque(true);
        two.setOpaque(true);
        three.setOpaque(true);


        //HomePannelAdd
        homePanel.add(oneTxt);
        homePanel.add(one);
        homePanel.add(Inst);
        homePanel.add(oneTxtInst);
        homePanel.add(two);
        homePanel.add(twoTxt);
        homePanel.add(twoTxtInst);
        homePanel.add(twoTxtInstlo);
        homePanel.add(twoTxtInstlt);
        homePanel.add(three);
        homePanel.add(threeTxt);
        homePanel.add(threeTxtInst);
        homePanel.add(threeTxtInstlo);
        homePanel.add(threeTxtInstlt);
        homePanel.add(Login_Btn);
        homePanel.add(LBtn_Ins_one);
        homePanel.add(LBtn_Ins_two);
        homePanel.add(Reg_Btn);
        homePanel.add(Reg_Ins_one);
        homePanel.add(Reg_Ins_two);
        homePanel.add(Sta_Btn);
        homePanel.add(Sta_Ins_one);
        homePanel.add(viw_Btn);
        homePanel.add(viw_Ins_one);
        homePanel.add(viw_Ins_two);
    }


    void instructions(JPanel Instructions){

        //ScrollBar color changer
        ScrollBarUI yourUI = new BasicScrollBarUI() {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
        };
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUI(yourUI);


        //setVisible
        Category.setVisible(false);
        homePanel.setVisible(false);
        Provision.setVisible(false);
        Protime.setVisible(false);
        ProFees.setVisible(false);
        scroll.setVisible(true);


        //Alignments
        Instructions.setPreferredSize(new Dimension(1942, 1064));
        scroll.setBounds(20,330,1877,660);
        inst.setBounds(45,80,300,50);
        undln.setBounds(45,125,148,4);
        Inhead.setBounds(45,155,500,50);
        InPtOne.setBounds(80,200,1000,50);
        InPtTwo.setBounds(80,250,1000,50);
        Inptthr.setBounds(80,300,1000,50);
        InPtfr.setBounds(80,350,1700,50);
        InPtFiv.setBounds(80,400,1700,50);
        InPtFivOn.setBounds(85,450,1000,50);
        InPtSX.setBounds(80,500,1700,50);
        InPic.setBounds(45,550,500,50);
        InPicone.setBounds(80,600,1000,50);
        InPitwo.setBounds(80,650,700,50);
        Apoint.setBounds(45,700,800,50);
        ApOne.setBounds(80,750,1000,50);
        ApTwo.setBounds(80,800,1700,50);
        ApTwoOne.setBounds(89,850,500,50);
        Apthr.setBounds(80,900,1700,50);
        ApthreOne.setBounds(89,950,500,50);


        //SetOpaque
        undln.setOpaque(true);


        //Fonts
        inst.setFont(InstHead);
        Inhead.setFont(InstSubHead);
        InPtOne.setFont(fnt_text);
        InPtTwo.setFont(fnt_text);
        Inptthr.setFont(fnt_text);
        InPtfr.setFont(fnt_text);
        InPtFiv.setFont(fnt_text);
        InPtFivOn.setFont(fnt_text);
        InPtSX.setFont(fnt_text);
        InPic.setFont(InstSubHead);
        InPicone.setFont(fnt_text);
        InPitwo.setFont(fnt_text);
        Apoint.setFont(InstSubHead);
        ApOne.setFont(fnt_text);
        ApTwo.setFont(fnt_text);
        ApTwoOne.setFont(fnt_text);
        Apthr.setFont(fnt_text);
        ApthreOne.setFont(fnt_text);


        //Background Colours
        Instructions.setBackground(Color.decode("#AED6F1"));
        undln.setBackground(Color.BLACK);

        //ForeGround Colours
        inst.setForeground(Color.BLACK);


        //Adding to pannel
        Instructions.add(inst);
        Instructions.add(undln);
        Instructions.add(Inhead);
        Instructions.add(InPtOne);
        Instructions.add(InPtTwo);
        Instructions.add(Inptthr);
        Instructions.add(InPtfr);
        Instructions.add(InPtFiv);
        Instructions.add(InPtFivOn);
        Instructions.add(InPtSX);
        Instructions.add(InPic);
        Instructions.add(InPicone);
        Instructions.add(InPitwo);
        Instructions.add(Apoint);
        Instructions.add(ApOne);
        Instructions.add(ApTwo);
        Instructions.add(ApTwoOne);
        Instructions.add(ApthreOne);
        Instructions.add(Apthr);


        //Layout
        Instructions.setLayout(null);

    }


    void visaCategory(JPanel Category){


        //Set Visible
        homePanel.setVisible(false);
        scroll.setVisible(false);
        Provision.setVisible(false);
        Protime.setVisible(false);
        ProFees.setVisible(false);
        Category.setVisible(true);

        //Adjustment
        Category.setBounds(20,330,1877,660);
        catHed.setBounds(45,80,300,50);
        undln.setBounds(45,125,178,4);
        TrstVisa.setBounds(140,180,1210,50);
        Stdvisa.setBounds(140,280,1210,50);
        BussVisa.setBounds(140,380,1210,50);
        EmytVisa.setBounds(140,480,1210,50);
        lnterVisa.setBounds(140,580,1210,50);


        //SetFont
        catHed.setFont(InstHead);
        TrstVisa.setFont(InstSubHead);
        Stdvisa.setFont(InstSubHead);
        BussVisa.setFont(InstSubHead);
        EmytVisa.setFont(InstSubHead);
        lnterVisa.setFont(InstSubHead);


        //Adding to Pannel
        Category.add(catHed);
        Category.add(undln);
        Category.add(TrstVisa);
        Category.add(Stdvisa);
        Category.add(BussVisa);
        Category.add(EmytVisa);
        Category.add(lnterVisa);


        //Set Opaque
        undln.setOpaque(true);
        TrstVisa.setOpaque(true);
        Stdvisa.setOpaque(true);
        BussVisa.setOpaque(true);
        EmytVisa.setOpaque(true);
        lnterVisa.setOpaque(true);


        //SetBackGround
        Category.setBackground(Color.decode("#AED6F1"));
        undln.setBackground(Color.BLACK);
        catHed.setBackground(Color.BLACK);

        catHed.setForeground(Color.BLACK);



        //Layout
        Category.setLayout(null);

    }


    void provision(JPanel Provision){

        //setVisible
        homePanel.setVisible(false);
        scroll.setVisible(false);
        Category.setVisible(false);
        Protime.setVisible(false);
        ProFees.setVisible(false);
        Provision.setVisible(true);

        //Data For Table
        String coloum[]={ "Type of Visa","Period for which granted","Entry Single,Multiple,Double","Documents need for Application"};
        String Data[][]={ {"                              Tourist","                              5 Years","                            Multiple","                                ---"},
                {"                             Student","                 Period of course/ 5 years","                            Multiple","   Proof of admission in Indian Institution"},
                {"                            Business","                              5 years","                            Mulltiple","  Documents of bonafide for Companyletter"},
                {"                           Employment","               1 year/ period of contract","                            Multiple","Proof of employment appointment document"},
                {"                        Long Teerm Visa","                              5 years","                            Muttiple","                  Proof of Country Origin"}
        };


        //Tabel and ScrollPane
        JTable ProTable=new JTable(Data,coloum);
        JScrollPane sp=new JScrollPane(ProTable);


        //Adjustment
        Provision.setBounds(20,330,1877,660);
        Prohead.setBounds(45,80,300,50);
        undln.setBounds(45,125,178,4);
        sp.setBounds(85,200,1700,385);



        //SetFont
        Prohead.setFont(InstHead);
        ProTable.setFont(fnt_text_Inst);
        ProTable.getTableHeader().setFont(InstSubHead);


        //SetOpaque
        Provision.setOpaque(true);
        undln.setOpaque(true);
        ProTable.setOpaque(true);

        //SetBackGround
        Provision.setBackground(Color.decode("#AED6F1"));
        undln.setBackground(Color.BLACK);
        ProTable.setBackground(Color.decode("#F0F6F7"));
        ProTable.getTableHeader().setBackground(Color.decode("#D8DEE0"));

        //SetTable Edit False
        DefaultTableModel editble=new DefaultTableModel(Data,coloum){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        ProTable.setModel(editble);

        //Row Height
        ProTable.setRowHeight(70);



        //Adding To Pannel
        Provision.add(Prohead);
        Provision.add(undln);
        Provision.add(sp, BorderLayout. CENTER);


        //Layout
        Provision.setLayout(null);

    }


    void ProTime(JPanel Protime){

        //Pannel visible
        Category.setVisible(false);
        scroll.setVisible(false);
        Provision.setVisible(false);
        homePanel.setVisible(false);
        ProFees.setVisible(false);
        Protime.setVisible(true);

        //Adjustment
        Protime.setBounds(20,330,1877,660);
        ProHead.setBounds(45,80,400,50);
        undln.setBounds(45,125,160,4);
        ProTimeTxt.setBounds(200,250,1500,100);

        //SetOpaque
        undln.setOpaque(true);

        //setEditable
        ProTimeTxt.setEditable(false);

        //Baclground colour
        ProHead.setForeground(Color.BLACK);
        Protime.setBackground(Color.decode("#AED6F1"));
        undln.setBackground(Color.BLACK);
        ProTimeTxt.setBackground(Color.decode("#AED6F1"));

        //SetFont
        ProHead.setFont(InstHead);
        ProTimeTxt.setFont(InstSubHead);

        //Adding Pannels
        Protime.add(ProHead);
        Protime.add(undln);
        Protime.add(ProTimeTxt);


        //SetLayoutNull
        Protime.setLayout(null);

    }

    void ProFee(JPanel ProFees){

        //Pannel visible
        Category.setVisible(false);
        scroll.setVisible(false);
        Provision.setVisible(false);
        homePanel.setVisible(false);
        Protime.setVisible(false);
        ProFees.setVisible(true);


        //Adjustment
        ProFees.setBounds(20,330,1877,660);
        ProFeeHead.setBounds(45,80,400,50);
        undln.setBounds(45,125,160,4);
        ProFeeTxt.setBounds(150,190,2500,500);

        //SetOpaque
        undln.setOpaque(true);

        //Editable
        ProFeeTxt.setEditable(false);

        //Baclground colour
        ProFeeHead.setForeground(Color.BLACK);
        ProFees.setBackground(Color.decode("#AED6F1"));
        undln.setBackground(Color.BLACK);
        ProFeeTxt.setBackground(Color.decode("#AED6F1"));

        //SetFont
        ProFeeHead.setFont(InstHead);
        ProFeeTxt.setFont(InstSubHead);

        //Adding Pannels
        ProFees.add(ProFeeHead);
        ProFees.add(undln);
        ProFees.add(ProFeeTxt);


        //SetLayoutNull
        ProFees.setLayout(null);

    }
}

