


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
 * @author Hassan
 */
public class Database {

    private String URL = "jdbc:mysql://108.167.137.228:3306/imakkico_tms_db";
    private String USER = "imakkico_tms";
    private String PASS = "TMS20tms17";
    public Connection conn;

    public Database(String user,String Pass,String url) 
    {
        this.USER=user;
        this.PASS=Pass;
        this.URL=url;
    }
    
    public Database() 
    {
        
    }

    public boolean connect() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL, USER, PASS);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean close() {
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean isConnected() throws SQLException
    {
        return !conn.isClosed();
    }
    
    public boolean hasConnection(){
        if (connect()){
            close();
            return true;
        }
        return false;
            
    }
    
    public ResultSet executeQuery(String query){
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public PreparedStatement prepareStatement(String query){
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            return ps;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}