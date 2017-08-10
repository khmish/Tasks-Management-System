
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
    Database database = new Database();
    ResultSet rs;   //for SELECT queries
    PreparedStatement ps;
    
    public boolean login(Login log){
        try {
            database.connect();
            ps = database.prepareStatement("INSERT INTO logins VALUES(?,?,?)");
            ps.setString(1, log.getMacAddress());
            ps.setString(2, log.getUser());
            ps.setString(3, log.getUnitCode());

            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean logout(){
        String mac_address = new Tool().getMAC_Address();
        try {
            database.connect();
            ps = database.prepareStatement("Delete FROM logins WHERE mac_address=?");

            ps.setString(1, mac_address);

            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean logAllSessionOut(String username){
        String mac_address = new Tool().getMAC_Address();
        try {
            database.connect();
            ps = database.prepareStatement("Delete FROM logins WHERE user=? AND mac_address<>?");

            ps.setString(1, username);
            ps.setString(1, mac_address);
            
            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isLoggedIn(){
        String mac_address = new Tool().getMAC_Address();
        boolean isLoggedIn = false;   
        try {
            database.connect();
            ps = database.prepareStatement("SELECT mac_address FROM logins WHERE mac_address=?");
            ps.setString(1, mac_address);
            rs = ps.executeQuery();
            if (rs.next())
                isLoggedIn = true;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isLoggedIn;
    }
    
    
    public Login getLog(){
        String mac_address = new Tool().getMAC_Address();
        Login log = null;   
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM logins WHERE mac_address=?");
            ps.setString(1, mac_address);
            rs = ps.executeQuery();
            if (rs.next())
                log = new Login(rs.getString(1), rs.getString(2), rs.getString(3));
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
    
    public int getNumberOfDevicesRegistered(String username){
        int count = 0;   
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM logins WHERE user=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next())
                count++;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println(count);
        }
        return count;
    }
}
