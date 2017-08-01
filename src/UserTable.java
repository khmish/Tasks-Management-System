
import java.util.ArrayList;

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

    private Connector conn;
    
    // the construct is providing connection to DB
    public UserTable() {
                            //user ,pass, url
        conn= new Connector(""  , ""    , "");
        if(conn.connectTo()){
            System.out.println("connected!");
        }
        
    }
    
    
    public boolean Insert(Users user)
    {
        return false;
    }
    public boolean Delete(Users user)
    {
        return false;
    }
    public boolean Update(Users user)
    {
        return false;
    }
    public boolean UpdatePass(Users user)
    {
        return false;
    }
    public ArrayList Search(String criteria)
    {
        return null;
    }
    public Users getUser(Users user)
    {
        return null;
    }
    public ArrayList getAllUser()
    {
        return null;
    }
    
}
