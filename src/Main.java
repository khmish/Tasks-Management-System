
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
        //Authority auth = new Authority("Ali", "Khal", "AA");
        //boolean r = new AuthoritiesTable().delete(auth);
        //System.out.println(r);
        //ArrayList array = new AuthoritiesTable().getAssignees("s.almakki");
        //System.out.println(array);
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
        TasksTable tasksTable= new TasksTable();
        Task task= new Task(tasksTable.getNewID()   ,"2010-01-01","assignedBy", "assignedTo", "subject", "details", "2010-02-01", 1, "1");
        tasksTable.insert(task);
        task= new Task(task.getTaskID()   ,"2009-01-01","assignedBy", "assignedTo", "subject", "details", "2010-02-01", 1, "1");
        tasksTable.update(task);
        tasksTable.delete(1);
        
    }
}
