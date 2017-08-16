
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
public class UnitsTable {

    
    UnitsTable(){
    }
    
    public Unit getUnit(String unit_code){
        Database database = new Database();
        PreparedStatement ps;
        ResultSet rs;
        Unit unit = null;
    
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Units WHERE unit_code=?");
            
            ps.setString(1, unit_code);
            rs = ps.executeQuery();
            
            if (rs.next())
                unit = new Unit(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5));
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return unit;
    }
    
    public void setOpenAuthorities(String unit_code, boolean isOpen){
        Database database = new Database();
        PreparedStatement ps;
    
        try {
            database.connect();
            if (isOpen)
                ps = database.prepareStatement("UDATE Units set isOpenAuthorities=1 WHERE unit_code=?");
            else
                ps = database.prepareStatement("UDATE Units set isOpenAuthorities=0 WHERE unit_code=?");
            
            ps.setString(1, unit_code);
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isOpenAuthorties(String unit_code){
        Database database = new Database();
        PreparedStatement ps;
        ResultSet rs;
        int status = 0;
    
        try {
            database.connect();
            ps = database.prepareStatement("SELECT isOpenAuthorities FROM Units WHERE unit_code=?");
            
            ps.setString(1, unit_code);
            rs = ps.executeQuery();
            
            if (rs.next())
                status = rs.getInt(1);
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (status == 1)
            return true;
        else
            return false;
    }
    
    
    
}
