package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// This Class handles the database requests made by the client application through the server
public class Database {

    // Data Members
    private Connection conn;
    public int fail = 0;

    // Constructors
    public Database() {
        this.prepareDatabase("localhost","4832","Bootcamp","bootcamp");
    }

    public Database(String url,String port,String userName,String pass) {
        this.prepareDatabase(url,port,userName,pass);
    }

    // This Function will prepare database connection with given constraints
    private void prepareDatabase(String url,String port,String userName,String pass) {
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection(String.format("jdbc:oracle:thin:@%s:%s:XE",url,port),userName,pass);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(String.format("jdbc:mysql://%s/bootcamp",url),userName,pass);
//            conn.setAutoCommit(true);
            this.createTables();
        }
        catch(Exception ex) {
            System.out.println("Database linkage error: "+ex);
            fail = 1;
        }
    }

    // This function will create the tables if it does not exist
    private void createTables() {
        try {
            // Admin table
            if(Admin.createTable(conn)>0)
                System.out.println("Admin table created");

            // VisaApplyer Table
            if(VisaApplyer.createTable(conn)>0)
                System.out.println("Visa Applyer created");

            // VisaApplication Table
            if(VisaApplication.createTable(conn)>0)
                System.out.println("Visa Application created");
        }
        catch(Exception ex) {
            System.out.println("Database error while preparing tables: " +ex);
        }
    }

    // This function returns the admin data for given adminID
    public Admin getAdmin(String adminID) {
        if(adminID == null)
            return null;
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(Admin.findAdmin(adminID));

            if(set.next())
                return new Admin(set);
            return null;
        }
        catch (Exception ex) {
            System.out.println("Retrieval of Admin :  "+ex);
            return null;
        }
    }

    // This function returns the Visa Applyer data for the given ApplyID
    public VisaApplyer getVisaApplyer(String applyID) {
        if(applyID == null)
            return null;
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(VisaApplyer.findApplyer(applyID));

            if(set.next())
                return new VisaApplyer(set);
            return null;
        }
        catch (Exception ex) {
            System.out.println("Retrieval of Visa Applyer : " +ex);
            return null;
        }
    }

    public VisaApplication getVisaApplication(String applicationID) {
        if(applicationID == null)
            return null;
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(VisaApplication.findVisaApplication(applicationID));
            if (set.next())
                return new VisaApplication(set,this.getVisaApplyer(set.getString("ApplyerID")),this.getAdmin(set.getString("AdminID")));
            return null;
        }
        catch (Exception ex) {
            System.out.println("Retrieval of Visa Application : "+ex);
            return null;
        }
    }

    // This function will return the admin object if the given credentials are correct
    public Admin checkAdminLogin(Admin a) {
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(a.AdminLogin());

            if(set.next())
                return new Admin(set);
            return null;
        }
        catch(Exception ex) {
            System.out.println("Admin Login: "+ex);
            return null;
        }
    }

    // This function will return the Visa Applyer object if the given credentials are correct
    public VisaApplyer checkApplyerLogin(VisaApplyer v) {
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(v.ApplyerLogin());
            if(set.next())
                return new VisaApplyer(set);
            return null;
        }
        catch (Exception ex) {
            System.out.println("VisaApplyer Login: "+ex);
            return null;
        }
    }

    // This function will update the database with new admin's data and returns the admin object with adminID
    public Admin newAdmin(Admin a) {
        try {
            Statement st = conn.createStatement();

            if(a.InsertAdmin(conn) < 1) {
                System.out.println("insertion failed");
                return null;
            }

            ResultSet set = Admin.findUserId(conn,a.getEmail());
            if(set != null) {
                if (set.next()) {
                    set = Admin.findAdmin(conn,set.getString("AdminID"));

                    if (set.next())
                        return new Admin(set);
                }
            }
            return null;
        }
        catch(Exception ex) {
            System.out.println("Admin Registration: "+ex);
            return null;
        }
    }

    // This function will update the database with new Visa Applyer's data and return the Visa Applyer object with applyerID
    public VisaApplyer newApplyer(VisaApplyer v) {
        try {
            Statement st = conn.createStatement();

            if(v.InsertApplyer(conn)<1) {
                System.out.println("Data not insert");
                return null;
            }

            ResultSet set = st.executeQuery(v.findApplyerID());

            if(set.next()) {
                set = st.executeQuery(VisaApplyer.findApplyer(set.getString("ApplyerID")));

                if (set.next())
                    return new VisaApplyer(set);
            }
            return null;
        }
        catch(Exception ex) {
            System.out.println("Applyer Resgistration: "+ex);
            return null;
        }
    }

    public VisaApplication newApplication(VisaApplication application) {
        try {
                if(application.InsertApplication(conn) < 1) {
                    System.out.println("Data not insert");
                    return null;
                }
        }
        catch(Exception ex) {
            System.out.println("Error in New Application into Database: "+ex);
            return false;
        }
    }

    public ArrayList<VisaApplication> getAllApplication() {
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(VisaApplication.getAllApplyers());

            ArrayList<VisaApplication> v = new ArrayList<>();
            while(set.next()) {
                VisaApplication va = new VisaApplication(set,this.getVisaApplyer(set.getString("ApplyerID")),this.getAdmin(set.getString("AdminID")));
                v.add(va);
            }
            if(v.size()>1)
                return v;
            return null;
        }
        catch(Exception ex) {
            System.out.println("Error in getting all Applyers: "+ex);
            return null;
        }
    }

    public boolean validateApplication(VisaApplication visaApplication) {
        try{
            Statement st = conn.createStatement();

            return st.executeUpdate(visaApplication.getValidationQuery()) > 0;
        }catch (Exception ex) {
            System.out.println("Error in validating the Visa Application: "+ex);
        }
        return false;
    }

    public boolean updateApplyer(VisaApplyer applyer) {
        try {
            Statement st = conn.createStatement();

            return st.executeUpdate(applyer.getUpdateQuery()) > 0;
        }
        catch(Exception ex) {
            System.out.println("Error in Updatiing VisaApplyer: "+ex);
            return false;
        }
    }

    public VisaApplication getStatus(VisaApplyer applyer) {
        try {
            Statement st = conn.createStatement();

            ResultSet set = st.executeQuery(VisaApplication.findVisaApplication(applyer.getApplyeID()));

            if(set.next())
                return new VisaApplication(set,applyer,this.getAdmin(set.getString("AdminID")));

            return null;
        }
        catch (Exception ex) {
            System.out.println("Getting status of the visa application: "+ex);
            return null;
        }
    }

    public boolean deleteApplication(VisaApplication application) {
        try {
            Statement st = conn.createStatement();

            return st.executeUpdate(application.getDeleteQuery())>0;

        }
        catch (Exception ex) {
            System.out.println("Deletion of Application : "+ex);
            return false;
        }
    }

    // This function closes the database connection
    public void close() {
        try {
            this.conn.commit();
            this.conn.close();
        }
        catch(Exception ex) {
            System.out.println("Closing the database link "+ex);
        }
    }
}
