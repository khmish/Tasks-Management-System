/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Main {
    Main(){
                
    }
    
    
    public static void main(String args[]) {    
        /*
                Connector db = new Connector();
        if (db.hasConnection())
            System.out.println("SUCESS");
        else
            System.out.println("FAIL");
                */
        TasksTable tt = new TasksTable();
        //tt.insert();
        Database db = new Database();
        System.out.println(db.hasConnection());
    }
}
