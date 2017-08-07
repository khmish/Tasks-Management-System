
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
        database.connect();
    }
    
    public boolean insert(Authority auth){
        
        
        try {
            database.connect();
            ps = database.prepareStatement("INSERT INTO authorites VALUES(?,?,?,?)");
            ps.setString(1, "");
            ps.setString(2, auth.getAssignorUserName());
            ps.setString(3, auth.getAssigneeUserName());
            ps.setString(3, auth.getUnitCode());

            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Authority auth){
            
        try {
            database.connect();
            ps = database.prepareStatement("DELETE FROM authorites WHERE assignor=? AND assignee=?");
            ps.setString(1, auth.getAssignorUserName());
            ps.setString(2, auth.getAssigneeUserName());

            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public ArrayList getAuthorities(String assignor){
            
        try {
            database.connect();
            ps = database.prepareStatement("SELECT assignee FROM authorties WHERE assignor=?");
            
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
            database.connect();
            ps = database.prepareStatement("SELECT authority_id FROM authorties WHERE authority_id=MAX(authority_id)");
            rs = ps.executeQuery();
            if (rs.next())
                id = rs.getLong(1);
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
