
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AuthoritiesTable {
    Database database = new Database();
    ResultSet rs;   //for SELECT queries
    PreparedStatement ps;
    
    AuthoritiesTable(){
    }
    
    public boolean insert(Authority auth){
        
        try {
            //
            database.connect();
            long authority_id = getNewID();
            ps = database.prepareStatement("INSERT INTO authorities VALUES(?,?,?,?)");
            ps.setLong(1, authority_id);
            ps.setString(2, auth.getAssignorUserName());
            ps.setString(3, auth.getAssigneeUserName());
            ps.setString(4, auth.getUnitCode());

            ps.execute();
            ps.close();
            database.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Authority auth){
            
        try {
            database.connect();
            ps = database.prepareStatement("DELETE FROM authorities WHERE assignor=? AND assignee=?");
            ps.setString(1, auth.getAssignorUserName());
            ps.setString(2, auth.getAssigneeUserName());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public ArrayList getAssignees(String assignor){
            
        try {
            database.connect();
            ps = database.prepareStatement("SELECT assignee FROM authorities WHERE assignor=?");
            ps.setString(1, assignor);
            
            rs = ps.executeQuery();
            ArrayList assignees = new ArrayList();
            
            while (rs.next()){
                assignees.add(rs.getString(1));
            }
            ps.close();
            return assignees;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public long getNewID(){
        long id = -1;   
        try {
            ps = database.prepareStatement("SELECT MAX(authority_id) FROM authorities");
            rs = ps.executeQuery();
            if (rs.next())
                id = rs.getInt(1) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
