
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    private Database database = new Database();
    private ResultSet rs;   //for SELECT, using excuteQuery()
    private PreparedStatement ps; ////for SELECT, using excute()

    public UsersTable() {
        //if (database.connect()) {
        //    System.out.println("connected!");
        //}

    }
    public void dbMessages(int rows,String type)
    {
        if (rows>0) {
            System.out.println(rows+" rows have been "+type+"!" );
        } else {
            System.out.println(" NO CHANGES! ");
        }
    }
    public boolean insert(User user) {
        boolean result = false;
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getAdmin());
            ps.setString(5, user.getUnitCode());
            
            int rows =ps.executeUpdate();
            dbMessages(rows,"added");
            ps.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return result;
    }

        public boolean update(User user) {
        boolean result = false;
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("UPDATE Users set name=?, password=?, isAdmin=?, unit_code=? WHERE username=?");
            ps.setString(5, user.getUsername());
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getAdmin());
            ps.setString(4, user.getUnitCode());
            

            int rows =ps.executeUpdate();
            dbMessages(rows,"updated");
            ps.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return result;
    }
        
    public boolean delete(String username) {
        boolean result = false;
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("DELETE FROM Users WHERE username=?");
            ps.setString(1, username);
            int rows =ps.executeUpdate();
            dbMessages(rows,"deleted");
            ps.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return result;
    }

    public boolean updateName(String username, String name) {
        boolean result = false;
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("UPDATE Users set name=? WHERE username=?");
            ps.setString(1, name);
            ps.setString(2, username);
            int rows =ps.executeUpdate();
            dbMessages(rows,"updated");
            ps.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return result;
    }
    
    public boolean updatePassword(String username, String newPass) {
        boolean result = false;
        try {//an example of update DB-------change the update statement to delete of insert
            database.connect();
            ps = database.prepareStatement("UPDATE Users set password=? WHERE username=?");
            ps.setString(1, newPass);
            ps.setString(2, username);
           int rows =ps.executeUpdate();
            dbMessages(rows,"updated");
            ps.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return result;
    }

    public boolean login(String username, String pass) {
        boolean login = false;
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Users WHERE username=? AND password=?");
            
            ps.setString(1, username);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            
            if (rs.next()){
                login = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return login;
    }
    
    
    public ArrayList search(String criteria, String unit_code) {
        criteria = "%" + criteria + "%";
        
        ArrayList array = new ArrayList();
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Users WHERE (username LIKE ? OR name LIKE ?) AND unit_code=?");
            
            ps.setString(1, criteria);
            ps.setString(2, criteria);
            ps.setString(3, unit_code);
            
            rs = ps.executeQuery();
            
            
            while (rs.next()){
                //JOptionPane.showMessageDialog(null, "Found");
                User user = new User();
                
                user.setUsername(rs.getString(1));
                user.setPassword("");
                user.setName(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                user.setUnitCode(rs.getString(5));
                array.add(user);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return array;
    }

    public ArrayList getAllUser(String unit_code) {
        ArrayList array = new ArrayList();
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Users WHERE unit_code=?");
            
            ps.setString(1, unit_code);
            
            rs = ps.executeQuery();
            
            
            while (rs.next()){
                User user = new User();
                
                user.setUsername(rs.getString(1));
                user.setPassword("");
                user.setName(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                user.setUnitCode(rs.getString(5));
                array.add(user);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return array;
    }

    
    public User getUser(String username) {
        User user = null;
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Users WHERE username=?");
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            
            if (rs.next()){
                user = new User();
                user.setUsername(rs.getString(1));
                user.setPassword("");
                user.setName(rs.getString(3));
                user.setAdmin(rs.getInt(4));
                user.setUnitCode(rs.getString(5));
            }
            ps.close();
            database.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return user;
    }
    
    public String getName(String username) {
        String name = null;
        try {
            database.connect();
            ps = database.prepareStatement("SELECT name FROM Users WHERE username=?");
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            
            if (rs.next()){
                name = rs.getString(1);
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return name;
    }
    
    
    public boolean isRegistered(String username) {
        boolean result = false;
        try {
            database.connect();
            ps = database.prepareStatement("SELECT username FROM Users WHERE username=?");
            
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            
            if (rs.next()){
                result = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        return result;
    }

}

