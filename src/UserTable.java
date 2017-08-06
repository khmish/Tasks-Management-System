
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
public class UserTable {

    Database database = new Database();
    ResultSet rs;   //for SELECT, using excuteQuery()
    PreparedStatement ps; ////for SELECT, using excute()
    // the construct is providing connection to DB
    public UserTable() {
        //user ,pass, url
        
        if (database.connect()) {
            System.out.println("connected!");
        }

    }

    public boolean Insert(User user) {
        
        try {//an example of update DB-------change the update statement to delete of insert
           database.connect();
            ps = database.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getUnitCode());
            

            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Delete(User user) {
        try {//an example of update DB-------change the update statement to delete of insert
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Update(User user) {
        try {//an example of update DB-------change the update statement to delete of insert
            
            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean UpdatePass(User user) {
        return false;
    }

    public ArrayList Search(String criteria) {
        return null;
    }

    public User getUser(User user) {
        return null;
    }

    public ArrayList getAllUser() {
        return null;
    }

}
