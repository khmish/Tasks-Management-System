
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

    private Connector connector;
    private PreparedStatement ps;
    // the construct is providing connection to DB
    public UserTable() {
        //user ,pass, url
        connector = new Connector("", "", "");
        if (connector.connectTo()) {
            System.out.println("connected!");
        }

    }

    public boolean Insert(Users user) {
        
        try {//an example of update DB-------change the update statement to delete of insert
            ps = connector.conn.prepareStatement("UPDATE Messages SET description = ?, author = ? WHERE id = ? AND seq_num = ?");
            // set the preparedstatement parameters--- the following para is just an example NOT real DB
            ps.setString(1, "description");
            ps.setString(2, "author");
            ps.setInt(3, 0);
            ps.setInt(4, 0);

            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Delete(Users user) {
        try {//an example of update DB-------change the update statement to delete of insert
            ps = connector.conn.prepareStatement("UPDATE Messages SET description = ?, author = ? WHERE id = ? AND seq_num = ?");
            // set the preparedstatement parameters--- the following para is just an example NOT real DB
            ps.setString(1, "description");
            ps.setString(2, "author");
            ps.setInt(3, 0);
            ps.setInt(4, 0);

            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean Update(Users user) {
        try {//an example of update DB-------change the update statement to delete of insert
            ps = connector.conn.prepareStatement("UPDATE Messages SET description = ?, author = ? WHERE id = ? AND seq_num = ?");
            // set the preparedstatement parameters--- the following para is just an example NOT real DB
            ps.setString(1, "description");
            ps.setString(2, "author");
            ps.setInt(3, 0);
            ps.setInt(4, 0);

            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean UpdatePass(Users user) {
        return false;
    }

    public ArrayList Search(String criteria) {
        return null;
    }

    public Users getUser(Users user) {
        return null;
    }

    public ArrayList getAllUser() {
        return null;
    }

}
