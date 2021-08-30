package Database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.HashMap;

public class VisaApplyer implements Serializable {

    // Data Members
    private String ApplyerID;
    private String Email;
    private String Password;
    private String PassportNumber;
    private String Name;
    private String FatherName;
    private String MotherName;
    private String Country;
    private Date DOB;
    private String Gender;
    private String Address;
    private String PhoneNumber;
    private String Aadhar;

    // Constructors
    public VisaApplyer(String email,String pass) {
        this.setAll();
        this.Email = email;
        this.Password = pass;
    }
    public VisaApplyer(HashMap<String,String> map,Date date) {
        this.setAll();
        this.Email = map.get("Email");
        this.Password = map.get("Password");
        this.PassportNumber = map.get("PasswordNumber");
        this.Name = map.get("Name");
        this.FatherName = map.get("FatherName");
        this.MotherName = map.get("MotherName");
        this.Country = map.get("Country");
        this.DOB = date;
        this.Gender = map.get("Gender");
        this.Address = map.get("Address");
        this.PhoneNumber = map.get("PhoneNumber");
        this.PassportNumber = map.get("PassportNumber");
        this.Aadhar = map.get("Aadhar");
    }

    public VisaApplyer(ResultSet set) {
        this.setAll();
        try {
            this.ApplyerID = set.getString("ApplyerID");
            this.Email = set.getString("Email");
            this.Password = set.getString("Password");
            this.PassportNumber = set.getString("PassportNumber");
            this.Name = set.getString("Name");
            this.FatherName = set.getString("FatherName");
            this.MotherName = set.getString("MotherName");
            this.Country = set.getString("Country");
            this.DOB = set.getDate("DOB");
            this.Gender = set.getString("Gender");
            this.Address = set.getString("Address");
            this.PhoneNumber = set.getString("PhoneNumber");
            this.Aadhar = set.getString("Aadhar");
        }
        catch (Exception ex) {
            System.out.println("VisaApplyer Database: "+ex);
        }
    }

    private void setAll() {
        this.ApplyerID = null;
        this.Email = null;
        this.Password = null;
        this.Name = null;
        this.FatherName = null;
        this.MotherName = null;
        this.Country = null;
        this.DOB = null;
        this.Gender = null;
        this.Address = null;
        this.PhoneNumber = null;
        this.Aadhar = null;
    }

    // Getters
    public String getApplyeID() {
        return ApplyerID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public String getName() {
        return this.Name;
    }

    public String getFatherName() {
        return this.FatherName;
    }

    public String getMotherName() {
        return this.MotherName;
    }

    public String getCountry() {
        return this.Country;
    }

    public Date getDOB() {
        return this.DOB;
    }

    public String getGender() {
        return this.Gender;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    public String getAadhar() {
        return this.Aadhar;
    }

    // Setters
    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setFatherName(String fatherName) {
        this.FatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.MotherName = motherName;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public void setAadhar(String aadhar) {
        this.Aadhar = aadhar;
    }


    // Utility Functions
    // This function will generate SQL query for the VisaApplyer
    public static int createTable(Connection conn) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Applyer (" +
                    "ApplyerID INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "Email VARCHAR(30) NOT NULL UNIQUE," +
                    "Password VARCHAR(20) NOT NULL," +
                    "PassportNumber VARCHAR(20) NOT NULL UNIQUE," +
                    "Name VARCHAR(30) NOT NULL," +
                    "FatherName VARCHAR(30) NOT NULL," +
                    "MotherName VARCHAR(30) NOT NULL," +
                    "Country VARCHAR(30) NOT NULL," +
                    "DOB DATE NOT NULL," +
                    "Gender VARCHAR(15) NOT NULL," +
                    "Address BLOB NOT NULL," +
                    "PhoneNumber VARCHAR(10) NOT NULL," +
                    "Aadhar VARCHAR(12) NOT NULL );";

            return conn.prepareStatement(sql).executeUpdate();
        }
        catch (Exception ex) {
            System.out.println("Error in creating Visa applyer table: "+ex);
            return 0;
        }
    }

    // This function will generate SQL query for the insertion of a new applyer
    public int InsertApplyer(Connection conn) {
        try {
            String sql = "INSERT INTO Applyer( Email,Password,PassportNumber,Name, FatherName," +
                    "MotherName,Country,DOB,Gender,Address,PhoneNumber,Aadhar ) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

            return conn.prepareStatement(sql).executeUpdate();
        }
        catch (Exception x) {
            System.out.println("Error in inserting Applyer: "+x);
            return 0;
        }
    }

    // This function will generate SQL query for the update of a applyer
    public String getUpdateQuery() {
        return String.format("UPDATE Applyer SET Email = '%s',Password = '%s',PassportNumber = '%s',Name = '%s'," +
                "FatherName = '%s',MotherName = '%s', Country = '%s',DOB = '%s',Gender = '%s',Address = '%s'," +
                "PhoneNumber = '%s' Aadhar = '%s' WHERE ApplyerID = '%s';",
                this.Email,this.Password,this.PassportNumber,this.Name, this.FatherName, this.MotherName, this.Country, this.DOB, this.Gender, this.Address,
                this.PhoneNumber, this.Aadhar,this.ApplyerID);
    }

    // This function will generate SQL query for the deletion of a applyer
    public String getDeleteQuery() {
        return String.format("DELETE FROM Applyer WHERE ApplyerID = '%s';",this.ApplyerID);
    }

    // This function will generate SQL query for the querying ApplyerID of the given Applyer
    public String findApplyerID() {
        return String.format("SELECT ( ApplyerID ) FROM Appyler WHERE Email='%s';",this.Email);
    }

    public static String findApplyerID(String email) {
        return String.format("SELECT ( ApplyerID ) FROM Appyler WHERE Email='%s';",email);
    }

    public static String findApplyer(String applyerID) {
        return String.format("SELECT * FROM Appyler WHERE ApplyerID='%s';",applyerID);
    }

    public String ApplyerLogin() {
        return String.format("SELECT * FROM Applyer WHERE Email = '%s' AND Password = '%s';",this.Email,this.Password);
    }
}
