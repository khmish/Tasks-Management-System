
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class LoginsTable {
    private Database database = new Database();
    private ResultSet rs;   //for SELECT queries
    private PreparedStatement ps;
    
    public boolean login(Login log){
        try {
            database.connect();
            ps = database.prepareStatement("INSERT INTO Logins VALUES(?,?,?)");
            ps.setString(1, log.getMacAddress());
            ps.setString(2, log.getUser());
            ps.setString(3, log.getUnitCode());

            ps.execute();
            ps.close();
            database.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean logout(){
        String mac_address = new Tool().getMAC_Address();
        try {
            database.connect();
            ps = database.prepareStatement("Delete FROM Logins WHERE mac_address=?");

            ps.setString(1, mac_address);

            ps.execute();
            ps.close();
            database.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean logAllSessionOut(String username){
        String mac_address = new Tool().getMAC_Address();
        try {
            database.connect();
            ps = database.prepareStatement("Delete FROM Logins WHERE username=? AND mac_address<>?");

            ps.setString(1, username);
            ps.setString(2, mac_address);
            
            ps.execute();
            ps.close();
            database.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Login getLog(){
        String mac_address = new Tool().getMAC_Address();
        Login log = null;   
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Logins WHERE mac_address=?");
            ps.setString(1, mac_address);
            rs = ps.executeQuery();
            if (rs.next())
                log = new Login(rs.getString(1), rs.getString(2), rs.getString(3));
            ps.close();
            database.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
    public int getNumberOfDevicesRegistered(String username){
        int count = 0;   
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Logins WHERE username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next())
                count++;
            ps.close();
            database.close();
                        
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(count);
        }
        return count;
    }
}
