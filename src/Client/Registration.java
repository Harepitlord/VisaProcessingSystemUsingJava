package Client;

import Additional.DateClass;
import Additional.Validation;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class Registration {
    private JFrame frame;
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
    JDatePickerImpl datePicker;
    SqlDateModel dob;
    String[] countries;
    Font f;
    boolean passIsVisible,conpassIsVisible;

    public Registration() {

        countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
                "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria",
                "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
                "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil",
                "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia",
                "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile",
                "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
                "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)",
                "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor",
                "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
                "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan",
                "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia",
                "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala",
                "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)",
                "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq",
                "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
                "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan",
                "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
                "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of",
                "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique",
                "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of",
                "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal",
                "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria",
                "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama",
                "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico",
                "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
                "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia",
                "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia",
                "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain",
                "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands",
                "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan",
                "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia",
                "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
                "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu",
                "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands",
                "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine"};
        passIsVisible = true;
        conpassIsVisible =true;
        f = new Font("Times New Roman",Font.BOLD,25);
        this.prepareInterface();
    }

    private void prepareInterface() {
        this.prepareFrames();
        this.prepareLabels();
        this.prepareTextFields();
        this.prepareCheckBox();
        this.prepareComboBox();
        this.prepareRadioButtons();
        this.prepareButtons();
        this.preparePasswordField();
        this.prepareActionListeners();
        this.addElements();
        this.frame.setVisible(true);
    }

    private void prepareLabels() {
        title=new JLabel("REGISTRATION FORM");
        title.setFont(new Font("Algeria",Font.BOLD,35));
        title.setForeground(Color.WHITE);

        nameLabel=new JLabel("Name ");
        nameLabel.setFont(f);
        nameLabel.setForeground(Color.WHITE);

        errName=new JLabel("Invalid Name");
        errName.setForeground(Color.red);
        errName.setVisible(false);

        fathernameLabel=new JLabel("Father's Name ");
        fathernameLabel.setFont(f);
        fathernameLabel.setForeground(Color.WHITE);

        errFatherName=new JLabel("Invalid Name");
        errFatherName.setForeground(Color.red);
        errFatherName.setVisible(false);

        mothernameLabel=new JLabel("Mother's Name ");
        mothernameLabel.setFont(f);
        mothernameLabel.setForeground(Color.WHITE);

        errMotherName=new JLabel("Invalid Name");
        errMotherName.setForeground(Color.red);
        errMotherName.setVisible(false);

        dobLabel=new JLabel("Dob");
        dobLabel.setFont(f);
        dobLabel.setForeground(Color.WHITE);

        dob=new SqlDateModel();
        Properties p=new Properties();
        p.put("text.today","today");
        p.put("text.month","month");
        p.put("text.year","year");
        JDatePanelImpl jdp=new JDatePanelImpl(dob,p);
        datePicker=new JDatePickerImpl(jdp,new DateClass());

        genderLabel=new JLabel("Gender");
        genderLabel.setFont(f);
        genderLabel.setForeground(Color.WHITE);

        addressLabel=new JLabel("Address");
        addressLabel.setFont(f);
        addressLabel.setForeground(Color.WHITE);

        errAddress=new JLabel("Invalid Address");
        errAddress.setForeground(Color.red);
        errAddress.setVisible(false);

        countryLabel=new JLabel("Country");
        countryLabel.setFont(f);
        countryLabel.setForeground(Color.WHITE);

        emailidLabel=new JLabel("Email-id");
        emailidLabel.setFont(f);
        emailidLabel.setForeground(Color.WHITE);

        errEmailid=new JLabel("Invalid Email");

        errEmailid.setForeground(Color.red);
        errEmailid.setVisible(false);

        phoneLabel=new JLabel("Phone No");
        phoneLabel.setFont(f);
        phoneLabel.setForeground(Color.WHITE);

        errPhone=new JLabel("Invalid PhoneNo");
        errPhone.setForeground(Color.red);
        errPhone.setVisible(false);

        passwordLabel=new JLabel("Password");
        passwordLabel.setFont(f);
        passwordLabel.setForeground(Color.WHITE);

        errPassword=new JLabel("Invalid Password");
        errPassword.setForeground(Color.red);
        errPassword.setVisible(false);

        conpasswordLabel=new JLabel("Confirm Password");
        conpasswordLabel.setFont(f);
        conpasswordLabel.setForeground(Color.WHITE);

        errConpassword=new JLabel("Invalid Password");
        errConpassword.setForeground(Color.red);
        errConpassword.setVisible(false);

        aadhaarNumberLabel=new JLabel("Aadhar Number");
        aadhaarNumberLabel.setFont(f);
        aadhaarNumberLabel.setForeground(Color.WHITE);

        errAadhar=new JLabel("Invalid Aadhar no");
        errAadhar.setForeground(Color.red);
        errAadhar.setVisible(false);

        passportNumberLabel=new JLabel("Passport Number");
        passportNumberLabel.setFont(f);
        passportNumberLabel.setForeground(Color.WHITE);

        errPassport=new JLabel("Invalid Passport no");
        errPassport.setForeground(Color.red);
        errPassport.setVisible(false);
    }

    private void prepareTextFields() {

        name=new JTextField();
        name.setFont(f);

        fathername=new JTextField();
        fathername.setFont(f);

        mothername=new JTextField();
        mothername.setFont(f);

        address =new JTextField();
        address.setFont(f);

        emailid=new JTextField();
        emailid.setFont(f);

        phone=new JTextField();
        phone.setFont(f);

        aadhaarNumber=new JTextField("1234 5698 7458");
        aadhaarNumber.setFont(f);

        passportNumber=new JTextField();
        passportNumber.setFont(f);


    }

    private void prepareRadioButtons() {

        male=new JRadioButton("Male");
        male.setOpaque(false);
        male.setFont(new Font("Times New Roman", Font.BOLD, 20));

        female=new JRadioButton("Female");
        female.setFont(new Font("Times New Roman", Font.BOLD, 20));
        female.setOpaque(false);

        others=new JRadioButton("Other");
        others.setFont(new Font("Times New Roman", Font.BOLD, 20));
        others.setOpaque(false);
        gender=new ButtonGroup();

        gender.add(male);
        gender.add(female);
        gender.add(others);
    }

    private void prepareComboBox() {

        country=new JComboBox<>(countries);
        country.setFont(f);
    }

    private void preparePasswordField() {
        password=new JPasswordField();
        password.setFont(f);

        conpassword = new JPasswordField();
        conpassword.setFont(f);
    }

    private void prepareButtons() {

        passportButton=new JButton("Upload passport");
        passportButton.setFont(new Font("Times New Romen",Font.BOLD,15));

        aadhaarButton=new JButton("Upload Aadhaar");
        aadhaarButton.setFont(new Font("Times New Romen",Font.BOLD,15));

        home=new JButton("Home");
        home.setFont(f);

        register=new JButton("Register");
        register.setFont(f);
    }

    private void prepareCheckBox() {
        passwordMask=new JCheckBox("Show Password");
        passwordMask.setOpaque(false);
        passwordMask.setForeground(Color.WHITE);

        conpasswordMask=new JCheckBox("Show password ");
        conpasswordMask.setForeground(Color.WHITE);
        conpasswordMask.setOpaque(false);
    }

    private void prepareActionListeners() {
        aadhaarButton.addActionListener(e->{
            fileChooserAadaar = new JFileChooser();
            fileChooserAadaar.showOpenDialog(null);
            System.out.println(fileChooserAadaar.getSelectedFile());
            aadhaarButton.setText(fileChooserAadaar.getSelectedFile().getName());
        });

        passportButton.addActionListener(e->{
            fileChooserPassport = new JFileChooser();
            fileChooserPassport.showOpenDialog(null);
            System.out.println(fileChooserPassport.getSelectedFile().getName());
            passportButton.setText(fileChooserPassport.getSelectedFile().getName());
        });

        register.addActionListener(e->{
            this.signup();
        });

        passwordMask.addActionListener(e-> {
            if(passIsVisible) {
                password.setEchoChar('\0');
                passIsVisible = false;
            }
            else {
                password.setEchoChar('*');
                passIsVisible = true;
            }
        });

        conpasswordMask.addActionListener(e->{
            if(conpassIsVisible) {
                conpassword.setEchoChar('\0');
                conpassIsVisible = false;
            }
            else {
                conpassword.setEchoChar('*');
                conpassIsVisible = true;
            }
        });

    }

    private void addElements() {
        title.setBounds(820,50,400,40);
        nameLabel.setBounds(150,150,100,30);
        name.setBounds(500,150,300,30);
        errName.setBounds(500,130,100,20);
        fathernameLabel.setBounds(150,215,200,30);
        fathername.setBounds(500,215,300,30);
        errFatherName.setBounds(500,195,100,20);
        mothernameLabel.setBounds(150,265,300,30);
        mothername.setBounds(500,265,300,30);
        errMotherName.setBounds(500,245,100,20);
        dobLabel.setBounds(150,315,300,30);
        datePicker.setBounds(500,315,300,30);
        genderLabel.setBounds(150,365,150,30);
        male.setBounds(500,365,100,30);
        female.setBounds(600,365,120,30);
        others.setBounds(700,365,100,30);
        addressLabel.setBounds(150,415,150,30);
        address.setBounds(500,415,300,60);
        errAddress.setBounds(500,395,100,20);
        countryLabel.setBounds(150,485,150,30);
        country.setBounds(500,485,300,30);
        emailidLabel.setBounds(150,535,150,30);
        emailid.setBounds(500,535,300,30);
        errEmailid.setBounds(500,515,100,20);
        phoneLabel.setBounds(150,585,150,30);
        phone.setBounds(500,585,300,30);
        errPhone.setBounds(500,565,100,20);
        passwordLabel.setBounds(150,635,150,30);
        password.setBounds(500,635,300,30);
        errPassword.setBounds(500,615,100,20);
        passwordMask.setBounds(500,665 ,150,20);
        conpasswordLabel.setBounds(150,685,250,30);
        conpassword.setBounds(500,685,300,30);
        errConpassword.setBounds(650,675,100,20);
        conpasswordMask.setBounds(500,715,150,20);
        aadhaarNumberLabel.setBounds(150,755,150,30);
        aadhaarNumber.setBounds(500,755,300,30);
        errAadhar.setBounds(500,735,100,20);
        passportNumberLabel.setBounds(150,805 ,300,30);
        passportNumber.setBounds(500,805,300,30);
        errPassport.setBounds(500,785,150,20);
        passportButton.setBounds(150,850,150,30);
        aadhaarButton.setBounds(550,847,150,30);
        home.setBounds(150,920,100,30);
        register.setBounds(610,920,150,30);

        frame.add(title);
        frame.add(nameLabel);
        frame.add(name);
        frame.add(errName);
        frame.add(fathernameLabel);
        frame.add(fathername);
        frame.add(errFatherName);
        frame.add(mothernameLabel);
        frame.add(mothername);
        frame.add(errMotherName);
        frame.add(dobLabel);
        frame.add(datePicker);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);
        frame.add(others);
        frame.add(addressLabel);
        frame.add(address);
        frame.add(errAddress);
        frame.add(countryLabel);
        frame.add(country);
        frame.add(emailidLabel);
        frame.add(emailid);
        frame.add(errEmailid);
        frame.add(phoneLabel);
        frame.add(phone);
        frame.add(errPhone);
        frame.add(passwordLabel);
        frame.add(password);
        frame.add(errPassword);
        frame.add(passwordMask);
        frame.add(conpasswordLabel);
        frame.add(conpassword);
        frame.add(conpasswordMask);
        frame.add(errConpassword);
        frame.add(aadhaarNumberLabel);
        frame.add(aadhaarNumber);
        frame.add(errAadhar);
        frame.add(passportNumberLabel);
        frame.add(passportNumber);
        frame.add(errPassport);
        frame.add(passportButton);
        frame.add(aadhaarButton);
        frame.add(home);
        frame.add(register);

    }

    private void prepareFrames() {
        this.frame = new JFrame("Registration Form");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.frame.setSize(1600,900);
//        this.frame.getContentPane().setBackground(Color.decode("#5ee7ff"));
//        this.frame.getContentPane().setBackground(Color.decode("#05d1ff"));
        this.frame.getContentPane().setBackground(Color.decode("#57f4ff"));
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Image i=Toolkit.getDefaultToolkit().getImage("src/Resources/RegistrationForm.jpeg");
        this.frame.setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(i,0, 0,this);
            }
        });
    }

    private void signup() {
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
            // User data collection
        }
    }

    public static void main(String[] args) {
        new Registration();
    }
}
