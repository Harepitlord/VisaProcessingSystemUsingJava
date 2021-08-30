package Database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Admin implements Serializable {

    // Data Members
    private String AdminId;
    private String email;
    private String password;
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
    // This constructor is a basic one
    public Admin() {
        this.setAll();
    }

    public Admin(String email,String password) {
        this.setAll();
        this.email = email;
        this.password = password;
        this.AdminId = null;
    }
    public Admin(HashMap<String,String> map,Date date) {
        this.setAll();
        this.AdminId = null;
        this.email = map.get("Email");
        this.password = map.get("Password");
        this.Name = map.get("Name");
        this.FatherName = map.get("FatherName");
        this.MotherName = map.get("MotherName");
        this.Country = map.get("Country");
        this.DOB = date;
        this.Gender = map.get("Gender");
        this.Address = map.get("Address");
        this.PhoneNumber = map.get("PhoneNumber");
        this.Aadhar = map.get("Aadhar");
    }

    // This constructor gets the data from database in ResultSet
    public Admin(ResultSet set) {
        this.setAll();
        try {
            AdminId = set.getString("AdminID");
            email = set.getString("Email");
            password = set.getString("Password");
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
        catch(Exception ex) {
            System.out.println("Admin Creation from Dataset: "+ex);
        }
    }

    private void setAll() {
        this.AdminId = null;
        this.email = null;
        this.password = null;
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
    public String getAdminId() {
        return AdminId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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
    // This function will give the sql command to create the table
    public static int createTable(Connection conn) {

        try {
            String sql = "CREATE TABLE IF NOT EXISTS Admin (" +
                    "AdminID INTEGER  AUTO_INCREMENT PRIMARY KEY," +
                    "Email VARCHAR(40) NOT NULL UNIQUE," +
                    "Password VARCHAR(20) NOT NULL," +
                    "Name VARCHAR(30) NOT NULL," +
                    "FatherName VARCHAR(30) NOT NULL," +
                    "MotherName VARCHAR(30) NOT NULL," +
                    "Country VARCHAR(30) NOT NULL," +
                    "DOB DATE NOT NULL," +
                    "Gender VARCHAR(15) NOT NULL," +
                    "Address BLOB NOT NULL," +
                    "PhoneNumber VARCHAR(10) NOT NULL," +
                    "Aadhar VARCHAR(12) NOT NULL );";
            PreparedStatement p =conn.prepareStatement(sql);
            return p.executeUpdate();

        }
        catch (Exception ex) {
            System.out.println("Error in Creating Admin Table: "+ex);
            return 0;
        }
    }

    // This function will give the insert SQL command based on the object's data.
    public int InsertAdmin(Connection conn) {
        try {
            String sql = "INSERT INTO Admin( Email,Password,Name, FatherName,MotherName,Country,DOB," +
                    "Gender,Address,PhoneNumber,Aadhar ) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, email);
            p.setString(2, password);
            p.setString(3, Name);
            ;
            p.setString(4, FatherName);
            p.setString(5, MotherName);
            p.setString(6, Country);
            p.setDate(7, DOB);
            p.setString(8, Gender);
            p.setString(9, Address);
            p.setString(10, PhoneNumber);
            p.setString(11, Aadhar);
            return p.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println("Error in Preparing Admin Insert: "+ex);
            return 0;
        }
    }

    // This function will give the update SQL Query based on the object's data
    public String getUpdateQuery() {
        return String.format("UPDATE Admin SET Email = '%s', Password='%s', Name = '%s',FatherName = '%s'," +
                        "MotherName = '%s', Country = '%s',DOB = '%s',Gender = '%s',Address = '%s',PhoneNumber = '%s' Aadhar = '%s' WHERE AdminID = '%s';",
                this.email,this.password,this.Name, this.FatherName, this.MotherName, this.Country, this.DOB, this.Gender, this.Address,
                this.PhoneNumber, this.Aadhar,this.AdminId);
    }

    // This function will give the delete SQL query based on the object's data
    public String getDeleteQuery() {
        return String.format("DELETE FROM Admin WHERE AdminID = '%s'",this.AdminId);
    }

    // This function will give the SQL query to get the userid  based on the Object's data.

    public static ResultSet findUserId(Connection conn,String email) {
        try {
            PreparedStatement p = conn.prepareStatement("SELECT ( AdminID ) FROM Admin WHERE Email = ?;");
            p.setString(1,email);
            return p.executeQuery();
        }
        catch (Exception ex) {
            System.out.println("Error in find Admin ID : "+ex);
            return null;
        }
    }

    public static ResultSet findAdmin(Connection conn,String admin) {
        try {
            PreparedStatement p = conn.prepareStatement("SELECT * FROM Admin WHERE AdminID = ?;");

            p.setString(1,admin);

            return p.executeQuery();
        }
        catch (Exception ex) {
            System.out.println("Error in finding AdminID");
        }
    }

    public String AdminLogin() {
        return String.format("SELECT * FROM Admin WHERE Email = '%s' AND Password = '%s';",this.email,this.password);
    }

}
