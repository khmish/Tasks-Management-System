import javax.swing.JOptionPane;

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
        Login log = new LoginsTable().getLog();
        //System.out.println(log.getUnitCode());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //if no login was found, open login form
                if (log == null)
                    new Form_Login().setVisible(true);
                
                
                //if log found
                else{
                    //get unit and user
                    User user = new UsersTable().getUser(log.getUser());
                    Unit unit = new UnitsTable().getUnit(log.getUnitCode());
                    
                    //calclate remaining days using unit expiration date stored 
                    //this calculates days from today to unit expiration date
                    int days_remaining = new Tool().calculateDaysRemainingToDate(unit.getExpirationDate());
                    
                    //if no remaining days, display a message
                    if (days_remaining <= 0)
                        JOptionPane.showMessageDialog(null, "Service is not avilable at this time!\n Please contact your system Administration for more information.");
                    
                    
                    //if remaining days>0, launch the app (Tasks Page)
                    else{
                        new Form_Tasks(user).setVisible(true);
                        
                        //This part is for admin users in the unit
                        if(days_remaining <= 7 && user.isAdmin()){
                            String expiration_date = new UnitsTable().getExpirationDate(user.getUnitCode());
                            JOptionPane.showMessageDialog(null, "Alert!\nYour subscription is about to expire.\nExpiration Date: " 
                                + expiration_date + "\n\n*** This Message Displays for you as an ADMIN Account ***");
                        }
                    }
                        
                }
            }
        });
                
    }
}
