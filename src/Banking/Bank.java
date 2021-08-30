package Banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class Bank {
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "Bootcamp", "bootcamp");
        }
        catch (Exception e){
            System.out.println("error in creating the database Connection: "+e);
        }

        return con;
    }

    public static String getBalance( String[] detail){
        //String query="select balance from bankDetails where cardno='"+detail[0]+"'and cvv='"+detail[1]+"'and pin='"+detail[2]+"'";
        String query="select * from bankDetails where cardno='"+"9587678975412537"+"'";
        Connection con=getConnection();
        System.out.println(query);
        String bal=null;
        try {
            Statement st = con.createStatement();

            ResultSet rs=st.executeQuery(query);
            rs.next();
            bal=rs.getString("balance");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return bal;
    }
    public static void withDraw(String[] detail){
        String query="update bankDetails "+" set balance='"+detail[1]+"'"+" where cardno='"+detail[0]+"'";
        Connection con=getConnection();
        System.out.println(query);
        String bal=null;
        try {
            Statement st = con.createStatement();

            st.executeQuery(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        String[] det ={"5241678975862147","951","7534"};
        String[] deta ={"5241678975862147","777"};
        //System.out.println(Bank.getBalance(det));
        Bank.withDraw(deta);
    }
}
