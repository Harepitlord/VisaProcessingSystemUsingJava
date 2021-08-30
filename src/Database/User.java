package Database;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;

public class User implements Serializable {

    // Data members
    private String UserId;
    private String Name;
    private String FatherName;
    private String MotherName;
    private String Country;
    private Date DOB;
    private String Gender;
    private String Address;
    private String PhoneNumber;
    private String Aadhar;



    public User(String n, String fn, String mn, String c, Date d, String g, String a, String p, String aa) {
        this.Name = n;
        this.FatherName = fn;
        this.MotherName = mn;
        this.Country = c;
        this.DOB = d;
        this.Gender = g;
        this.Address = a;
        this.PhoneNumber = p;
        this.Aadhar = aa;
    }

    public User(ResultSet set) {
        try {
            this.UserId = set.getString("UserId");
            this.Name = set.getString("Name");
            this.FatherName = set.getString("FatherName");
            this.MotherName = set.getString("MotherName");
            this.Country = set.getString("Country");
            this.DOB = set.getDate("DOB");
            this.Gender = set.getString("Gender");
            this.Address = set.getString("Address");
            this.PhoneNumber = set.getString("PhoneNumber");
            this.Aadhar = set.getString("Aadhar");
        } catch (Exception ex) {
            System.out.println("Error in creating User Object from SQL Data set: " + ex);
        }
    }

    // Getter Functions
    public String getUserId() {
        return this.UserId;
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

    // Setter Functions

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
    public static String createTable() {
        return "CREATE TABLE `User` IF NOT EXISTS (" + "UserID INTEGER PRIMARY KEY AUTOINCREMENT," + "Name VARCHAR(30) NOT NULL,"
                + "FatherName VARCHAR(30) NOT NULL," + "MotherName VARCHAR(30) NOT NULL,"
                + "Country VARCHAR(30) NOT NULL," + "DOB DATE NOT NULL," + "Gender VARCHAR(15) NOT NULL,"
                + "Address BLOB NOT NULL," + "PhoneNumber VARCHAR(10) NOT NULL," + "Aadhar VARCHAR(12) NOT NULL );";
    }

    // This function will give the insert SQL command based on the object's data.
    public String getInsertQuery() {
        return String.format(
                "INSERT INTO `User`( `Name`, `FatherName`,`MotherName`,`Country`,`DOB`,`Gender`,`Address`,`PhoneNumber`,"
                        + "`Aadhar` ) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                this.Name, this.FatherName, this.MotherName, this.Country, this.DOB, this.Gender, this.Address,
                this.PhoneNumber, this.Aadhar);
    }

    public String getUpdateQuery() {
        return String.format(
                "UPDATE `User` SET `Name` = '%s',`FatherName` = '%s',`MotherName` = '%s', `Country` = '%s',`DOB` = '%s', " +
                        "`Gender` = '%s',`Address` = '%s',`PhoneNumber` = '%s' `Aadhar` = '%s' WHERE `UserID` = '%s'",
                this.Name, this.FatherName, this.MotherName, this.Country, this.DOB, this.Gender, this.Address,
                this.PhoneNumber, this.Aadhar, this.UserId);
    }

    // This function will give the update SQL Query based on the object's data
    public String getUpdateQuery(String userId) {
        return String.format(
                "UPDATE `User` SET `Name` = '%s',`FatherName` = '%s',`MotherName` = '%s', `Country` = '%s',`DOB` = '%s', " +
                        "`Gender` = '%s',`Address` = '%s',`PhoneNumber` = '%s' `Aadhar` = '%s' WHERE `UserID` = '%s'",
                this.Name, this.FatherName, this.MotherName, this.Country, this.DOB, this.Gender, this.Address,
                this.PhoneNumber, this.Aadhar, userId);
    }

    // This function will give the delete SQL query based on the object's data
    public String getDeleteQuery() {
        return String.format("DELETE FROM `User` WHERE `UserID` = '%s'",this.UserId);
    }

    // This function will give the SQL query to get the userid  based on the Object's data.
    public String findUserId() {
        return String.format("SELECT (`UserID`) FROM `User` WHERE `Aadhar` = '%s'",this.Aadhar);
    }

    public static String findUserId(String aadhar) {
        return String.format("SELECT (`UserID`) FROM `User` WHERE `Aadhar` = '%s'",aadhar);
    }

    public static String findUser(String userId) {
        return String.format("SELECT (*) FROM `User` WHERE `UserId` = '%s'",userId);
    }
}
