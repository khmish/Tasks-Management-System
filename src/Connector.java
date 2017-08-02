


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
public class Connector {

    private String URL = "jdbc:mysql://108.167.137.228/imakkico_tms_db";//example
    private String USER = "imakkico_tms";
    private String PASS = "TMS20tms17";
    public Connection conn;

    public Connector(String user,String Pass,String url) 
    {
        this.USER=user;
        this.PASS=Pass;
        this.URL=url;
    }

    public boolean connectTo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL, USER, PASS);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean close() {
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean isConnected()
    {
        try {
            if(conn.isClosed())
            {
                return false;
            }
            else
            {
                return connectTo();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           return false;
    }

}