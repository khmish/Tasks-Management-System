
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
        //testing TasksTable-------------------------------------------------------------------------------------------
        /*TasksTable tasksTable= new TasksTable();
        Task task= new Task(tasksTable.getNewID()   ,"2010-01-01","assignedBy", "assignedTo", "subject", "details", "2010-02-01", 1, "1");
        tasksTable.insert(task);
        task= new Task(task.getTaskID()   ,"2009-01-01","assignedBy", "assignedTo", "subject", "details", "2010-02-01", 1, "1");
        tasksTable.update(task);
        //tasksTable.delete(1);
        ArrayList<Task> arrayList=tasksTable.Search("1", "assignedTo");
        ///System.out.println(arrayList);/
        
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getAssignee()+" "+arrayList.get(i).getAssignor()+" "+arrayList.get(i).getCreatedDate());
            
        }*/
        //testing UserTable---------------------------------------------------------------------------------------------
        UsersTable usersTable= new UsersTable();
        User user = new User("hk_2006", "123123","Ali",0,"1");
        //usersTable.insert(user);
        //usersTable.delete(user.getUsername());
        //usersTable.updatePassword(user.getUsername(),"000");
        //System.out.println(usersTable.login(user.getUsername(),"100"));
        //System.out.println(usersTable.isRegistered(user.getUsername()));
        //ArrayList<User> arrayList=usersTable.getAllUser(user.getUnitCode());
        /*for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getName());
            
        }*/
        
    }
}
