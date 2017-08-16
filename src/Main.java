
import java.util.ArrayList;

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

    public static void main(String args[]) {  
        
        ///////////////////////////TESTING AREA//////////////////////////////

        //Saleh's Area
        new Tool().daysLeftForSubscription("15-08-2017");
        
        //Hassan's Area
   
        
        
        ///////////////////////////TESTING AREA//////////////////////////////
        
        
        
        
        
        
        
        
        
        //ORGINAL MAIN FUNCTION CODE
        /*
        Login log = new LoginsTable().getLog();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (log == null)
                    new Form_Login().setVisible(true);
                else{
                    User user = new UsersTable().getUser(log.getUser());
                    new Form_Tasks(user).setVisible(true);
                }
            }
        });
                */
    }
}
