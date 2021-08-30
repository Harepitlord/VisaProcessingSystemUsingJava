package Client;

import ClientRunner.ClientSocket;
import Database.VisaApplyer;
import Server.DataObject;
import org.jdatepicker.impl.SqlDateModel;
import Additional.Validation;
import Additional.DateClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import java.awt.event.ActionEvent;
import java.util.Properties;

class RegistrationForm extends JFrame implements ActionListener {

    // Data Members
    private final ClientSocket socket;
    JLabel topImage;
    JLabel nameLabel,fathernameLabel,mothernameLabel,dobLabel,genderLabel,addressLabel,countryLabel,emailidLabel,phoneLabel,passwordLabel,conpasswordLabel,aadhaarNumberLabel,passportNumberLabel,passportLabel;
    JTextField name,fathername,mothername,address,emailid,phone,aadhaarNumber,passportNumber;
    JLabel errName,errFatherName,errMotherName,errAddress,errEmailid,errPhone,errPassword,errConpassword,errAadhar,errPassport,title;
    JCheckBox passwordMask,conpasswordMask;
    JPasswordField password,conpassword;
    JRadioButton male,female,others;
    ButtonGroup gender;
    JFileChooser fileChooserAadaar,fileChooserPassport;
    JButton passportButton,aadhaarButton,home,register;
    JComboBox<String> country;
    SqlDateModel dob;
    String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine"};
    Font f=new Font("Times New Roman",Font.BOLD,25);
    boolean passIsVisible=true,conpassIsVisible=true;
    public RegistrationForm(ClientSocket socket){
        this.socket = socket;
        setDefaultJframe();
        ImageIcon topImageIcon=new ImageIcon("india.jpg");
        topImage=new JLabel();
        topImage.setIcon(topImageIcon);
        topImage.setBounds(100,7,1500,170);
        //title
        title=new JLabel("REGISTRATION FORM");
        title.setFont(new Font("Algeria",Font.BOLD,35));
        title.setForeground(Color.WHITE);
        title.setBounds(820,50,400,40);
        add(title);
        //name
        nameLabel=new JLabel("Name ");
        nameLabel.setBounds(150,150,100,30);
        nameLabel.setFont(f);
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        name=new JTextField();
        name.setFont(f);
        name.setBounds(500,150,300,30);
        add(name);
        //invalid
        errName=new JLabel("Invalid Name");
        errName.setBounds(500,130,100,20);
        errName.setForeground(Color.red);
        errName.setVisible(false);
        add(errName);
        //fathername
        fathernameLabel=new JLabel("Father's Name ");
        fathernameLabel.setBounds(150,215,200,30);
        fathernameLabel.setFont(f);
        fathernameLabel.setForeground(Color.WHITE);
        add(fathernameLabel);

        fathername=new JTextField();
        fathername.setBounds(500,215,300,30);
        fathername.setFont(f);
        add(fathername);
        //invalid
        errFatherName=new JLabel("Invalid Name");
        errFatherName.setBounds(500,195,100,20);
        errFatherName.setForeground(Color.red);
        errFatherName.setVisible(false);
        add(errFatherName);
        //mothername
        mothernameLabel=new JLabel("Mother's Name ");
        mothernameLabel.setBounds(150,265,300,30);
        mothernameLabel.setFont(f);
        mothernameLabel.setForeground(Color.WHITE);
        add(mothernameLabel);

        mothername=new JTextField();
        mothername.setBounds(500,265,300,30);
        mothername.setFont(f);
        add(mothername);
        //invalid
        errMotherName=new JLabel("Invalid Name");
        errMotherName.setBounds(500,245,100,20);
        errMotherName.setForeground(Color.red);
        errMotherName.setVisible(false);
        add(errMotherName);
        //dob
        dobLabel=new JLabel("Dob");
        dobLabel.setBounds(150,315,300,30);
        dobLabel.setFont(f);
        dobLabel.setForeground(Color.WHITE);
        add(dobLabel);

        dob=new SqlDateModel();
        Properties p=new Properties();
        p.put("text.today","today");
        p.put("text.month","month");
        p.put("text.year","year");
        JDatePanelImpl jdp=new JDatePanelImpl(dob,p);
        JDatePickerImpl jdp1=new JDatePickerImpl(jdp,new DateClass());
        jdp1.setBounds(500,315,300,30);
        add(jdp1);
        //gender
        genderLabel=new JLabel("Gender");
        genderLabel.setBounds(150,365,150,30);
        genderLabel.setFont(f);
        genderLabel.setForeground(Color.WHITE);
        add(genderLabel);
        //male
        male=new JRadioButton("Male");
        male.setBounds(500,365,100,30);
        male.setOpaque(false);
        male.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(male);
        //female
        female=new JRadioButton("Female");
        female.setBounds(600,365,120,30);
        female.setFont(new Font("Times New Roman", Font.BOLD, 20));
        female.setOpaque(false);
        add(female);
        //other
        others=new JRadioButton("Other");
        others.setBounds(700,365,100,30);
        others.setFont(new Font("Times New Roman", Font.BOLD, 20));
        others.setOpaque(false);
        gender=new ButtonGroup();
        add(others);

        gender.add(male);
        gender.add(female);
        gender.add(others);
        //address
        addressLabel=new JLabel("Address");
        addressLabel.setBounds(150,415,150,30);
        addressLabel.setFont(f);
        addressLabel.setForeground(Color.WHITE);
        add(addressLabel);

        address =new JTextField();
        address.setBounds(500,415,300,60);
        address.setFont(f);
        add(address);
        //invalid
        errAddress=new JLabel("Invalid Address");
        errAddress.setBounds(500,395,100,20);
        errAddress.setForeground(Color.red);
        errAddress.setVisible(false);
        add(errAddress);
        //country
        countryLabel=new JLabel("Country");
        countryLabel.setBounds(150,485,150,30);
        countryLabel.setFont(f);
        countryLabel.setForeground(Color.WHITE);
        add(countryLabel);

        country=new JComboBox<>(countries);
        country.setBounds(500,485,300,30);
        country.setFont(f);
        add(country);
        //emailid
        emailidLabel=new JLabel("Email-id");
        emailidLabel.setBounds(150,535,150,30);
        emailidLabel.setFont(f);
        emailidLabel.setForeground(Color.WHITE);
        add(emailidLabel);

        emailid=new JTextField();
        emailid.setBounds(500,535,300,30);
        emailid.setFont(f);
        add(emailid);
        //invalid
        errEmailid=new JLabel("Invalid Email");
        errEmailid.setBounds(500,515,100,20);
        errEmailid.setForeground(Color.red);
        errEmailid.setVisible(false);
        add(errEmailid);
        //phone
        phoneLabel=new JLabel("Phone No");
        phoneLabel.setBounds(150,585,150,30);
        phoneLabel.setFont(f);
        phoneLabel.setForeground(Color.WHITE);
        add(phoneLabel);

        phone=new JTextField();
        phone.setBounds(500,585,300,30);
        phone.setFont(f);
        add(phone);
        //invalid
        errPhone=new JLabel("Invalid PhoneNo");
        errPhone.setBounds(500,565,100,20);
        errPhone.setForeground(Color.red);
        errPhone.setVisible(false);
        add(errPhone);
        //password
        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(150,635,150,30);
        passwordLabel.setFont(f);
        passwordLabel.setForeground(Color.WHITE);
        add(passwordLabel);

        password=new JPasswordField();
        password.setBounds(500,635,300,30);
        password.setFont(f);
        add(password);
        //invalid
        errPassword=new JLabel("Invalid Password");
        errPassword.setBounds(500,615,100,20);
        errPassword.setForeground(Color.red);
        errPassword.setVisible(false);
        add(errPassword);
        //mask
        passwordMask=new JCheckBox("Show Password");
        passwordMask.setBounds(500,665 ,150,20);
        passwordMask.setOpaque(false);
        passwordMask.setForeground(Color.WHITE);
        passwordMask.addActionListener(this);
        add(passwordMask);
        //conpassword
        conpasswordLabel=new JLabel("Confirm Password");
        conpasswordLabel.setBounds(150,685,250,30);
        conpasswordLabel.setFont(f);
        conpasswordLabel.setForeground(Color.WHITE);
        add(conpasswordLabel);

        conpassword=new JPasswordField();
        conpassword.setBounds(500,685,300,30);
        conpassword.setFont(f);
        add(conpassword);
        //invalid
        errConpassword=new JLabel("Invalid Password");
        errConpassword.setBounds(650,675,100,20);
        errConpassword.setForeground(Color.red);
        errConpassword.setVisible(false);
        add(errConpassword);
        //mask
        conpasswordMask=new JCheckBox("Show password ");
        conpasswordMask.setBounds(500,715,150,20);
        conpasswordMask.setForeground(Color.WHITE);
        conpasswordMask.setOpaque(false);
        conpasswordMask.addActionListener(this);
        add(conpasswordMask);
        //aadhaar
        aadhaarNumberLabel=new JLabel("Aadhar Number");
        aadhaarNumberLabel.setBounds(150,755,150,30);
        aadhaarNumberLabel.setFont(f);
        aadhaarNumberLabel.setForeground(Color.WHITE);
        add(aadhaarNumberLabel);

        aadhaarNumber=new JTextField("1234 5698 7458");
        aadhaarNumber.setBounds(500,755,300,30);
        aadhaarNumber.setFont(f);
        add(aadhaarNumber);
        //invalid
        errAadhar=new JLabel("Invalid Aadhar no");
        errAadhar.setBounds(500,735,100,20);
        errAadhar.setForeground(Color.red);
        errAadhar.setVisible(false);
        add(errAadhar);
        //passport
        passportNumberLabel=new JLabel("Passport Number");
        passportNumberLabel.setBounds(150,805 ,300,30);
        passportNumberLabel.setFont(f);
        passportNumberLabel.setForeground(Color.WHITE);
        add(passportNumberLabel);

        passportNumber=new JTextField();
        passportNumber.setBounds(500,805,300,30);
        passportNumber.setFont(f);
        add(passportNumber);
        //invalid
        errPassport=new JLabel("Invalid Passport no");
        errPassport.setBounds(500,785,150,20);
        errPassport.setForeground(Color.red);
        errPassport.setVisible(false);
        add(errPassport);
        //passport
        passportButton=new JButton("Upload passport");
        passportButton.setBounds(150,850,150,30);
        passportButton.setFont(new Font("Times New Romen",Font.BOLD,15));
        passportButton.addActionListener(this);
        add(passportButton);
        //aadhaar

        aadhaarButton=new JButton("Upload Aadhaar");
        aadhaarButton.setBounds(550,847,150,30);
        aadhaarButton.setFont(new Font("Times New Romen",Font.BOLD,15));
        aadhaarButton.addActionListener(this);
        add(aadhaarButton);
        //home
        home=new JButton("Home");
        home.setBounds(150,920,100,30);
        home.setFont(f);
        add(home);
        //password
        register=new JButton("Register");
        register.setBounds(610,920,150,30);
        register.setFont(f);
        register.addActionListener(this);
        add(register);

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Upload Aadhaar":
                fileChooserAadaar = new JFileChooser();
                fileChooserAadaar.showOpenDialog(null);
                System.out.println(fileChooserAadaar.getSelectedFile());
                break;
            case "Upload passport":
                fileChooserPassport = new JFileChooser();
                fileChooserPassport.showOpenDialog(null);
                System.out.println(fileChooserPassport.getSelectedFile());
                break;
            case "Home":
                break;
            case "Register":
            {
                int temp=0;
                errName.setVisible(false);
                errFatherName.setVisible(false);
                errMotherName.setVisible(false);
                errEmailid.setVisible(false);
                errPassword.setVisible(false);
                errConpassword.setVisible(false);
                errPhone.setVisible(false);
                errAddress.setVisible(false);
                errAadhar.setVisible(false);
                errPassport.setVisible(false);
                if(!Validation.checkName(name.getText())){
                    errName.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkName(fathername.getText())){
                    errFatherName.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkName(mothername.getText())){
                    errMotherName.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkMail(emailid.getText())){
                    errEmailid.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkPhone(phone.getText())){
                    errPhone.setVisible(true);
                    temp=1;
                }
                if((!password.getText().equals(conpassword.getText())) || !(Validation.checkPassword(password.getText()))) {
                    errPassword.setVisible(true);
                    errPassword.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkName(name.getText())){
                    errName.setVisible(true);
                    temp=1;
                }
                if(address.getText().length()<=5){
                    errAddress.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkAadhar(aadhaarNumber.getText())){
                    errAadhar.setVisible(true);
                    temp=1;
                }
                if(!Validation.checkPassport(passportNumber.getText())){
                    errPassport.setVisible(true);
                    temp=1;
                }
                if(temp==0){
                    JOptionPane.showMessageDialog(null,"Signuped Successfully","signup",JOptionPane.INFORMATION_MESSAGE);
                    VisaApplyer v = new VisaApplyer(this.emailid.getText(),this.password.getText());
                    v.setName(this.name.getText());
                    v.setFatherName(this.fathername.getText());
                    v.setMotherName(this.mothername.getText());
                    v.setCountry((String)this.country.getSelectedItem());
                    v.setGender(this.gender.getSelection().getActionCommand());
                    v.setDOB(this.dob.getValue());
                    v.setAddress(this.address.getText());
                    v.setAadhar(this.aadhaarNumber.getText());
                    v.setPassportNumber(this.passportNumber.getText());
                    v.setPhoneNumber(this.phone.getText());
                    DataObject d = new DataObject(v);
                    d.setOperation('I');
                    if(!socket.sendObject(d))
                        JOptionPane.showMessageDialog(this,"Server Error");
                    else {
                        new Home(socket,socket.receiveObject().getApplyer());
                        this.dispose();
                    }

                }
                break;
            }
            case "Show Password":
            {
                if(passIsVisible){
                    password.setEchoChar('\0');
                    passIsVisible=false;
                }
                else{
                    password.setEchoChar('#');
                    passIsVisible=true;
                }
                break;
            }
            case "Show password ":
            {
                if(conpassIsVisible){
                    conpassword.setEchoChar('\0');
                    conpassIsVisible=false;
                }
                else{
                    conpassword.setEchoChar('#');
                    conpassIsVisible=true;
                }
                break;
            }
        }
    }
    public void setDefaultJframe(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        Image i=Toolkit.getDefaultToolkit().getImage("src\\Resources\\a4.png");
        setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(i,0, 0,this);
            }
        });
        setLayout(null);

    }
}