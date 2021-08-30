package Client;

import Additional.DateClass;
import ClientRunner.ClientSocket;
import Database.Country;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Properties;

public class VisaApplyForm extends JFrame implements ActionListener {

    // Data Members
    private ClientSocket socket;
    JPanel panel;
    JLabel applyCountryLabel,indianMissionLabel,dateOfArrivalLabel,passportTypeLabel,visaTypeLabel,questionLabel1,questionLabel2,proofLabel;
    JComboBox<String> applyCountry;
    JComboBox<String> indianMission;
    JComboBox<String> passportType;
    JComboBox<String> visaType;
    JDatePanelImpl jdp;
    JDatePickerImpl jdp1;
    JRadioButton qyes1,qno1,qyes2,qno2;
    ButtonGroup question1,question2;
    SqlDateModel doa;
    JButton proof,continue1;
    JLabel image,heading;
    Font f=new Font("Times New Roman",Font.BOLD,25);
   // String countries[]={"Select","Australia","Canada","Dubai","Germany","Japan","United Kingdom","United States of America","Sweden","Switzerland","Thai Land"};
    String[] passports ={"Select","Regular passport","Special Passport","Diplomatic Passport","Service Passport"};
    String[] visas ={"Select","eTourist Visa","Education Visa","Business Visa"};
    public VisaApplyForm(ClientSocket socket) {
        this.socket = socket;
        setDefaultJframe();
        panel = new JPanel();
        setDefaultPanel(panel);
        indianMission=new JComboBox<>();
        indianMission.addItem("Select country");
        // image
        image=new JLabel();
        ImageIcon i=new ImageIcon("visaapplication.jpeg");
        image.setIcon(i);
        image.setBounds(329,2,1500,200);
        add(image);
        //heading
        heading=new JLabel("VISA APPLICATION");
        heading.setBounds(850,170,300,30);
        heading.setFont(f);
        add(heading);
        // apply country label
        applyCountryLabel = new JLabel("<html>Country you are<br>applying from</html>");
        applyCountryLabel.setBounds(500, 70, 200, 50);
        applyCountryLabel.setFont(f);
        panel.add(applyCountryLabel);

        //apply country
        applyCountry = new JComboBox<>(Country.getCountries());
        applyCountry.setBounds(760, 75, 300, 30);
        applyCountry.setFont(f);
        applyCountry.addActionListener(e -> {
            System.out.println("action");
            indianMission.removeAllItems();
            String[] con = Country.getMission((String)applyCountry.getSelectedItem());
            indianMission.addItem("Select Indian Mission");
            for(String ss:con){
                indianMission.addItem(ss);
            }
        });
        panel.add(applyCountry);
        //indian mission office label
        indianMissionLabel = new JLabel("Indian Mission");
        indianMissionLabel.setBounds(500, 140, 200, 30);
        indianMissionLabel.setFont(f);
        panel.add(indianMissionLabel);

        //indian mission

        indianMission.setBounds(760, 150, 300, 30);
        indianMission.setFont(f);
        panel.add(indianMission);

        //indian mission office label
        dateOfArrivalLabel = new JLabel("Date Of Arrival");
        dateOfArrivalLabel.setBounds(500, 180, 200, 30);
        dateOfArrivalLabel.setFont(f);
        panel.add(dateOfArrivalLabel);

        doa = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "today");
        p.put("text.month", "month");
        p.put("text.year", "year");
        jdp = new JDatePanelImpl(doa, p);
        jdp1 = new JDatePickerImpl(jdp, new DateClass());
        jdp1.setBounds(760, 190, 300, 30);
        jdp1.setFont(f);
        panel.add(jdp1);

        //passport type label
        passportTypeLabel = new JLabel("Passport Type");
        passportTypeLabel.setFont(f);
        passportTypeLabel.setBounds(500, 230, 200, 30);
        panel.add(passportTypeLabel);

        passportType = new JComboBox<>(passports);
        passportType.setFont(f);
        passportType.setBounds(760,240,300,30);
        panel.add(passportType);
        add(panel);
        //Vis type label
        visaTypeLabel = new JLabel("Visa Type");
        visaTypeLabel.setFont(f);
        visaTypeLabel.setBounds(500, 290, 200, 30);
        panel.add(visaTypeLabel);

        visaType = new JComboBox<>(visas);
        visaType.setFont(f);
        visaType.setBounds(760,290,300,30);
        panel.add(visaType);
        //proof
        proofLabel=new JLabel("Copy of proof");
        proofLabel.setFont(f);
        proofLabel.setBounds(500,340,200,30);
        panel.add(proofLabel);

        proof=new JButton("Choose File");
        proof.setBounds(780,340,200,30);
        proof.setFont(new Font("arial",Font.BOLD,20));
        proof.addActionListener(this);
        panel.add(proof);

       //question1
        questionLabel1=new JLabel("<html>Have you ever been arrested / prosecuted / convicted<br> by count of law of any country ?</html>");
        questionLabel1.setFont(f);
        questionLabel1.setBounds(400, 380, 400, 100);
        panel.add(questionLabel1);
        //yes
        qyes1=new JRadioButton("Yes");
        qyes1.setFont(f);
        qyes1.setBounds(800,380,100,40);
        qyes1.setOpaque(false);
        panel.add(qyes1);
        //yes
        qno1=new JRadioButton("No");
        qno1.setFont(f);
        qno1.setBounds(900,380,100,40);
        qno1.setOpaque(false);
        panel.add(qno1);
        question1=new ButtonGroup();
        question1.add(qyes1);
        question1.add(qno1);
        //question2
        questionLabel2=new JLabel("<html>Have you ever been refused entry/deported <br> by any country ?</html>");
        questionLabel2.setFont(f);
        questionLabel2.setBounds(400, 490, 400, 100);
        panel.add(questionLabel2);
        //yes
        qyes2=new JRadioButton("Yes");
        qyes2.setFont(f);
        qyes2.setBounds(800,490,100,40);
        qyes2.setOpaque(false);
        panel.add(qyes2);
        //yes
        qno2=new JRadioButton("No");
        qno2.setFont(f);
        qno2.setBounds(900,490,100,40);
        qno2.setOpaque(false);
        panel.add(qno2);
        question2=new ButtonGroup();
        question2.add(qyes2);
        question2.add(qno2);
        //continue button
        continue1=new JButton("Continue");
        continue1.setFont(f);
        continue1.setBounds(620,607,200,30);
        continue1.setBackground(Color.green);
        panel.add(continue1);
        add(panel);
    }
    public void setDefaultJframe(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#92bcf7"));
    }
    public void setDefaultPanel(JPanel panel){
        panel.setBounds(225,200,1500,700);
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

    }
    public void actionPerformed(ActionEvent e){
        if(Objects.equals(e.getActionCommand(), "Choose File")){
            System.out.println("hi");
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(null);
            proof.setText(fileChooser.getName(fileChooser.getSelectedFile()));
        }

    }
}
