
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
            ps = database.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getUnitCode());
            

            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(User user) {
        try {//an example of update DB-------change the update statement to delete of insert
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(User user) {
        try {//an example of update DB-------change the update statement to delete of insert
            
            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateName(String username, String name) {
        return false;
    }
    
    public boolean updatePass(String username, String newPassword) {
        return false;
    }

    public ArrayList search(String criteria) {
        return null;
    }

    public User getUser(String username) {
        return null;
    }

    public ArrayList getAllUser() {
        return null;
    }
    
    public boolean isRegistered(String username)
    {
        
        return false;
    }

}
