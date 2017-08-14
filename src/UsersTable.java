
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khmish
 */
public class UsersTable {

    Database database = new Database();
    ResultSet rs;   //for SELECT, using excuteQuery()
    PreparedStatement ps; ////for SELECT, using excute()
    // the construct is providing connection to DB
    public UsersTable() {
        //user ,pass, url
        
        if (database.connect()) {
            System.out.println("connected!");
        }

    }

    public boolean insert(User user) {
        
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getAdmin());
            ps.setString(4, user.getUnitCode());
            

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

        public boolean update(User user) {
        
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("UPDATE users set name=?, password=?, isAdmin=?, unit_code=? WHERE username=?");
            ps.setString(5, user.getUsername());
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAdmin());
            ps.setString(4, user.getUnitCode());
            

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public boolean delete(String username) {
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("DELETE FROM users WHERE username=?");
            ps.setString(1, username);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateName(String username, String name) {
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("UPDATE users set name=? WHERE username=?");
            ps.setString(1, name);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updatePassword(String username, String newPass) {
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("UPDATE users set name=? WHERE username=?");
            ps.setString(1, newPass);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean login(String username, String pass) {
        boolean login = false;
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            
            ps.setString(1, username);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            
            while (rs.next()){
                login = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
    
    
    public ArrayList search(String criteria, String unit_code) {
        ArrayList array = new ArrayList();
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM users WHERE username LIKE %?% OR name LIKE %?%"
                    + "AND unit_id=?");
            
            ps.setString(1, criteria);
            ps.setString(2, criteria);
            ps.setString(3, unit_code);
            
            rs = ps.executeQuery();
            
            
            while (rs.next()){
                User user = new User();
                
                user.setUsername(rs.getString(1));
                user.setPassword("");
                user.setName(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                user.setUnitCode(rs.getString(5));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public ArrayList getAllUser(String unit_code) {
        ArrayList array = new ArrayList();
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM users WHERE unit_code=?");
            
            ps.setString(1, unit_code);
            
            rs = ps.executeQuery();
            
            
            while (rs.next()){
                User user = new User();
                
                user.setUsername(rs.getString(1));
                user.setPassword("");
                user.setName(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                user.setUnitCode(rs.getString(5));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
        public User getUser(String username) {
        User user = new User();
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM users WHERE username=?");
            
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            
            if (rs.next()){
                user.setUsername(rs.getString(1));
                user.setPassword("");
                user.setName(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                user.setUnitCode(rs.getString(5));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
        
    public boolean isRegistered(String username) {
        try {
            database.connect();
            ps = database.prepareStatement("SELECT username FROM users WHERE username=?");
            
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            
            if (rs.next()){
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
