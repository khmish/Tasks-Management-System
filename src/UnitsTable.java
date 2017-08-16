
import java.sql.Date;
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

    Database database = new Database();
    PreparedStatement ps;
    ResultSet rs;
    Unit unit = null;

    UnitsTable() {
    }

    public Unit getUnit(String unit_code) {

        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Units WHERE unit_code=?");
            ps.setString(1, unit_code);
            rs = ps.executeQuery();
            
            if (rs.next())
                unit = new Unit(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4), 
                        rs.getString(5), rs.getInt(6), rs.getString(7));
            ps.close();
            database.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unit;
    }
    
    public boolean setOpenAuthorities(String unit_code, boolean isOpen){

        try {
            database.connect();
            if (isOpen) {
                ps = database.prepareStatement("UPDATE Units set isOpenAuthorities=1 WHERE unit_code=?");
            } else {
                ps = database.prepareStatement("UPDATE Units set isOpenAuthorities=0 WHERE unit_code=?");
            }
            ps.setString(1, unit_code);
            ps.execute();
            ps.close();
            database.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean isOpenAuthorties(String unit_code) {

        int status = 0;

        try {
            database.connect();
            
            ps = database.prepareStatement("SELECT isOpenAuthorities FROM Units WHERE unit_code=?");
            ps.setString(1, unit_code);
            rs = ps.executeQuery();

            if (rs.next()) {
                status = rs.getInt(1);
            }
            ps.close();database.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (status == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean insert(Unit unit){
        
        
        try {
            database.connect();
            ps = database.prepareStatement("INSERT INTO Units VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, unit.getUnitCode());//get new id
            ps.setString(2, unit.getName());
            ps.setString(3, unit.getContactInfo());
            ps.setInt(4, unit.getOpenAuthorties());
            ps.setString(5, unit.getExpirationDate());//---------------ISSUES with date representation PLZ chang it to Varchar____________________
            ps.setInt(6, unit.getSubsecription());
            ps.setString(7, unit.getNote());
            
            int rows=ps.executeUpdate();
            dbMessages(rows,"added");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isSubscribedUnit(String unit_code){
        Database database = new Database();
        PreparedStatement ps;
        ResultSet rs;
        int subscription = 0;

        try {
            database.connect();
            ps = database.prepareStatement("SELECT subscription FROM Units WHERE unit_code=?");
            
            ps.setString(1, unit_code);
            rs = ps.executeQuery();
            
            if (rs.next())
                subscription = rs.getInt(1);
            
            ps.close();
            database.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (subscription == 1)
            return true;
        else
            return false;
    }

    
    public boolean update(Unit unit){
            
        try {
            database.connect();
            ps = database.prepareStatement("UPDATE Units SET name=?,contact_info=? ,isOpenAuthorities=?, note=? WHERE unit_code=?");
            
            ps.setString(1, unit.getName());
            ps.setString(2, unit.getContactInfo());
            ps.setInt(3, unit.getOpenAuthorties());
            ps.setString(4, unit.getNote());
            ps.setString(5, unit.getUnitCode());
            int rows=ps.executeUpdate();
            dbMessages(rows,"updated");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean delete(Unit unit)
    {
        try {
            database.connect();
            ps = database.prepareStatement("DELETE FROM Units WHERE unit_code =?");
            ps.setString(1, unit.getUnitCode());
            int rows=ps.executeUpdate();
            dbMessages(rows,"deleted");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UnitsTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void dbMessages(int rows,String type)
    {
        if (rows>0) {
            System.out.println(rows+" rows have been "+type+"!" );
        } else {
            System.out.println(" NO CHANGES! ");
        }
    }
}
