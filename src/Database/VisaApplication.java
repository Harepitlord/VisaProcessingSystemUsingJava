package Database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VisaApplication implements Serializable {

    // Data Members
    private String VisaApplicationId;
    private VisaApplyer applyer;
    private Admin admin;
    private int status;
    private String country;
    private String indianMission;
    private String passwordType;
    private String visaType;
    private String proof;
    private int arrested;
    private int exiled;

    /*
    Status Reference
    0 = > Not yet verified
    1 = > Verified
    -1 = > Rejected
    2 = > Deleted
      */


    public VisaApplication() {
        this.setNull();
    }

    public VisaApplication(VisaApplyer applyer,Admin admin,int status,String country,String indianMission,String passwordType,
                           String visaType,String proof,int arrested,int exiled) {
        this.applyer = applyer;
        this.admin = admin;
        this.status = status;
        this.country = country;
        this.indianMission = indianMission;
        this.passwordType = passwordType;
        this.visaType = visaType;
        this.proof = proof;
        this.arrested = arrested;
        this.exiled = exiled;
    }

    public VisaApplication(ResultSet set,VisaApplyer applyer,Admin admin) {
        try {
            this.VisaApplicationId = set.getString("ApplicationID");
            this.applyer = applyer;
            this.admin = admin;
            this.status = Integer.parseInt(set.getString("Status"));
            this.country = set.getString("Country");
            this.indianMission = set.getString("IndianMission");
            this.passwordType = set.getString("PasswordType");
            this.visaType = set.getString("VisaTypes");
            this.proof = set.getString("Proof");
            this.arrested = Integer.parseInt(set.getString("Arrested"));
            this.exiled = Integer.parseInt(set.getString("Exiled"));
        }
        catch (Exception ex) {
            System.out.println("VisaApplication from Database: " + ex);
        }
    }

    private void setNull() {
        VisaApplicationId = null;
        applyer = null;
        admin = null;
        country = null;
        indianMission = null;
        passwordType = null;
        visaType = null;
        proof = null;
        arrested = 0;
        exiled = 0;
    }

    // Getters


    public String getVisaApplicationId() {
        return VisaApplicationId;
    }

    public VisaApplyer getApplyer() {
        return applyer;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String getCountry() {
        return country;
    }

    public String getIndianMission() {
        return indianMission;
    }

    public String getPasswordType() {
        return passwordType;
    }

    public String getVisaType() {
        return visaType;
    }

    public String getProof() {
        return proof;
    }

    public int getStatus() {
        return status;
    }

    public String getstatus() {
        switch (this.status) {
            case 0: {
                return "Not Verified";
            }
            case 1: {
                return "Verified";
            }
            case -1: {
                return "Rejected";
            }
            case 2: {
                return "Deleted";
            }
            default:
                return "Invalid";
        }
    }

    public int getArrested() {
        return arrested;
    }

    public int getExiled() {
        return exiled;
    }

    public void setVisaApplicationId(String visaApplicationId) {
        VisaApplicationId = visaApplicationId;
    }

    public void setApplyer(VisaApplyer applyer) {
        this.applyer = applyer;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPasswordType(String passwordType) {
        this.passwordType = passwordType;
    }

    public void setIndianMission(String indianMission) {
        this.indianMission = indianMission;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public void setArrested(int arrested) {
        this.arrested = arrested;
    }

    public void setExiled(int exiled) {
        this.exiled = exiled;
    }

    // SQL Functions
    public static int createTable(Connection conn) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS VisaApplication (" +
                    "ApplicationID INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "ApplyerID INTEGER NOT NULL," +
                    "AdminID INTEGER NOT NULL," +
                    "Status INTEGER NOT NULL," +
                    "Country VARCHAR(30) NOT NULL," +
                    "IndianMission VARCHAR(30) NOT NULL," +
                    "PasswordType VARCHAR(20) NOT NULL," +
                    "VisaType VARCHAR(20) NOT NULL," +
                    "Proof VARCHAR(20) NOT NULL," +
                    "Arrested int NOT NULL," +
                    "Exiled int NOT NULL," +
                    "FOREIGN KEY (ApplyerID) REFERENCES applyer(ApplyerID)," +
                    "Foreign Key (AdminID) references admin(AdminID));";

            return conn.prepareStatement(sql).executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("Error in creating visa application : " +ex);
            return 0;
        }
    }

    public int InsertApplication(Connection conn) {
        try {
            String sql = "INSERT INTO VisaApplication( ApplyerID,AdminID,Status,Country,IndianMission," +
                    "PasswordType,VisaType,Arrested,Exiled ) VALUES( ?,?,?,?,?,?,?,?,? );";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1,applyer.getApplyeID());
            p.setString(2,admin.getAdminId());
            p.setInt(3,status);
            p.setString(4,country);
            p.setString(5,this.indianMission);
            p.setString(6,passwordType);
            p.setString(7,visaType);
            p.setInt(8,arrested);
            p.setInt(9,exiled);

            return p.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println("error in inserting application: "+ex);
            return 0;
        }
    }

    public String getDeleteQuery() {
        return String.format("DELETE FROM VisaApplication WHERE ApplicationID = '%s'",this.VisaApplicationId);
    }

    public String getUpdateQuery() {
        return String.format("UPDATE VisaApplication SET ApplyerID = '%s',AdminID = '%s',Status = '%s',Country = '%s',IndianMission = '%s'," +
                "PasswordType = '%s',VisaType = '%s',Proof = '%s',Arrested = '%s',Exiled = '%s' WHERE ApplicationID = '%s';",
                this.applyer.getApplyeID(),this.admin.getAdminId(),this.status,this.country,this.indianMission,this.passwordType,
                this.visaType,this.proof,this.arrested,this.exiled,this.VisaApplicationId);
    }

    public static String findVisaApplication(String id) {
        return String.format("SELECT ( ApplicationID ) FROM VisaApplication WHERE ApplyerID = '%s';",id);
    }

    public String getValidationQuery() {
        return String.format("UPDATE VisaApplication SET Status = '%s' WHERE ApplicationID = '%s';",this.status,this.VisaApplicationId);
    }

    public static String getAllApplyers() {
        return String.format("SELECT * FROM VisaApplication WHERE Status = '%s';",0);
    }

}
