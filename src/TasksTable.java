
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author khmish
 */
public class TasksTable {
    Database database = new Database();
    ResultSet rs;   //for SELECT queries
    PreparedStatement ps;
    
    
    TasksTable(){
        /*try {
            if (database.isConnected()) {
                System.out.println("DB is connected!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TasksTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    }
    public boolean insert(Task task){
        
        int rows = 0;
        try {
            //database.connect();
            ps = database.prepareStatement("INSERT INTO Tasks VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setLong(1, task.getTaskID());//get new id
            ps.setString(2, task.getCreatedDate());
            ps.setString(3, task.getAssignor());
            ps.setString(4, task.getAssignee());
            ps.setString(5, task.getSubject());
            ps.setString(6, task.getDetails());
            ps.setString(7, task.getDueDate());
            ps.setInt(8, task.getStatus());
            ps.setString(9, task.getUnitCode());
            ps.setString(10, task.getAssignorName());
            ps.setString(11, task.getAssigneeName());
            
            rows = ps.executeUpdate();
            dbMessages(rows,"inserted");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        if(rows == 1) return true;
        else return false;
    }
    
    
    public boolean update(Task task){
            int rows = 0;
        try {
            database.connect();
            ps = database.prepareStatement("UPDATE Tasks SET created_date=?, assignor=?, assignee=?, subject=?,"
                    + "details=?, due_date=?, status=?, unit_code=?, assignor_name=?, assignee_name=? WHERE task_id=?");

            ps.setString(1, task.getCreatedDate());
            ps.setString(2, task.getAssignor());
            ps.setString(3, task.getAssignee());
            ps.setString(4, task.getSubject());
            ps.setString(5, task.getDetails());
            ps.setString(6, task.getDueDate());
            ps.setInt(7, task.getStatus());
            ps.setString(8, task.getUnitCode());
            ps.setLong(9, task.getTaskID());
            ps.setString(10, task.getAssignorName());
            ps.setString(11, task.getAssigneeName());

            rows=ps.executeUpdate();
            dbMessages(rows,"updated");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        if(rows == 1) return true;
        else return false;
    }
    
    public boolean updateStatus(long task_id, int status){
          int rows = 0;  
        try {
            database.connect();
            ps = database.prepareStatement("UPDATE Tasks SET status=? WHERE task_id=?");

            ps.setInt(1, status);
            ps.setLong(2, task_id);

            rows=ps.executeUpdate();
            dbMessages(rows,"updated");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        if(rows == 1) return true;
        else return false;
    }
    
    public boolean delete(long task_id){
        int rows = 0;
        try {
            database.connect();
            ps = database.prepareStatement("DELETE FROM Tasks WHERE task_id=?");
            ps.setLong(1, task_id);

            rows=ps.executeUpdate();
            dbMessages(rows,"deleted");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        if(rows == 1) return true;
        else return false;
    }
     
    public boolean deleteUserTasks(String username){
        int rows = 0;
        try {
            database.connect();
            ps = database.prepareStatement("DELETE FROM Tasks WHERE assignor=? OR assignee=?");
            ps.setString(1, username);
            ps.setString(2, username);

            ps.executeUpdate();
            dbMessages(rows,"deleted");//SHOW MESSAGE IF THERE IS RECORED HAS BEEN UPDATED
            rows = 1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.close();
        if(rows == 1) return true;
        else return false;
    }
    
    public ArrayList Search(String unit_code, String criteria){
            
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Tasks WHERE "
                    + "(assignor LIKE ? OR assignee LIKE ? OR subject LIKE ? OR details LIKE ?)"
                    + "AND unit_code=?");
            
            ps.setString(1, criteria);
            ps.setString(2, criteria);
            ps.setString(3, criteria);
            ps.setString(4, criteria);
            ps.setString(5, unit_code);
            
            rs = ps.executeQuery();
            ArrayList tasks = new ArrayList();
            
            while (rs.next()){
                Task task = new Task();
                
                task.setTaskID(rs.getLong(1));
                task.setCreatedDate(rs.getString(2));
                task.setAssignor(rs.getString(3));
                task.setAssignee(rs.getString(4));
                task.setSubject(rs.getString(5));
                task.setDetails(rs.getString(6));
                task.setDueDate(rs.getString(7));
                task.setStatus(rs.getInt(8));
                task.setUnitCode(rs.getString(9));
                task.setAssignorName(rs.getString(10));
                task.setAssigneeName(rs.getString(11));
                
                tasks.add(task);
            }
            ps.close();
            return tasks;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList getReceivedTasks(String assignee){
            
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Tasks WHERE assignee=?");
            ps.setString(1, assignee);
            rs = ps.executeQuery();
            ArrayList tasks = new ArrayList();
            
            while (rs.next()){
                Task task = new Task();
                
                task.setTaskID(rs.getLong(1));
                task.setCreatedDate(rs.getString(2));
                task.setAssignor(rs.getString(3));
                task.setAssignee(rs.getString(4));
                task.setSubject(rs.getString(5));
                task.setDetails(rs.getString(6));
                task.setDueDate(rs.getString(7));
                task.setStatus(rs.getInt(8));
                task.setUnitCode(rs.getString(9));
                task.setAssignorName(rs.getString(10));
                task.setAssigneeName(rs.getString(11));
                tasks.add(task);
            }
            
            ps.close();
            //database.close();
            return tasks;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList getSentTasks(String assignor){
            
        try {
            //database.connect();
            ps = database.prepareStatement("SELECT * FROM Tasks WHERE assignor=?");
            ps.setString(1, assignor);
            rs = ps.executeQuery();
            ArrayList tasks = new ArrayList();
            
            while (rs.next()){
                Task task = new Task();
                
                task.setTaskID(rs.getLong(1));
                task.setCreatedDate(rs.getString(2));
                task.setAssignor(rs.getString(3));
                task.setAssignee(rs.getString(4));
                task.setSubject(rs.getString(5));
                task.setDetails(rs.getString(6));
                task.setDueDate(rs.getString(7));
                task.setStatus(rs.getInt(8));
                task.setUnitCode(rs.getString(9));
                task.setAssignorName(rs.getString(10));
                task.setAssigneeName(rs.getString(11));
                tasks.add(task);
            }
            
            ps.close();
            //database.close();
            
            return tasks;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList getClosedTasks(String assignor){
            
        try {
            ps = database.prepareStatement("SELECT * FROM Tasks WHERE assignor=? AND status<>0");
            ps.setString(1, assignor);
            rs = ps.executeQuery();
            ArrayList tasks = new ArrayList();
            
            while (rs.next()){
                Task task = new Task();
                
                task.setTaskID(rs.getLong(1));
                task.setCreatedDate(rs.getString(2));
                task.setAssignor(rs.getString(3));
                task.setAssignee(rs.getString(4));
                task.setSubject(rs.getString(5));
                task.setDetails(rs.getString(6));
                task.setDueDate(rs.getString(7));
                task.setStatus(rs.getInt(8));
                task.setUnitCode(rs.getString(9));
                task.setAssignorName(rs.getString(10));
                task.setAssigneeName(rs.getString(11));
                tasks.add(task);
            }
            ps.close();
            return tasks;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList getUserTasks(String username){
            
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Tasks WHERE assignor=? OR assignee=? ORDER BY task_id");
            ps.setString(1, username);
            ps.setString(2, username);
            rs = ps.executeQuery();
            ArrayList tasks = new ArrayList();
            
            while (rs.next()){
                Task task = new Task();
                
                task.setTaskID(rs.getLong(1));
                task.setCreatedDate(rs.getString(2));
                task.setAssignor(rs.getString(3));
                task.setAssignee(rs.getString(4));
                task.setSubject(rs.getString(5));
                task.setDetails(rs.getString(6));
                task.setDueDate(rs.getString(7));
                task.setStatus(rs.getInt(8));
                task.setUnitCode(rs.getString(9));
                task.setAssignorName(rs.getString(10));
                task.setAssigneeName(rs.getString(11));
                tasks.add(task);
            }
            ps.close();
            return tasks;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public Task getTask(long task_id){
            
        try {
            database.connect();
            ps = database.prepareStatement("SELECT * FROM Tasks WHERE task_id=?");
            
            ps.setLong(1, task_id);
            rs = ps.executeQuery();
            Task task = new Task();
            
            if (rs.next()){
                
                task.setTaskID(rs.getInt(1));
                task.setCreatedDate(rs.getString(2));
                task.setAssignor(rs.getString(3));
                task.setAssignee(rs.getString(4));
                task.setSubject(rs.getString(5));
                task.setDetails(rs.getString(6));
                task.setDueDate(rs.getString(7));
                task.setStatus(rs.getInt(8));
                task.setUnitCode(rs.getString(9));
                task.setAssignorName(rs.getString(10));
                task.setAssigneeName(rs.getString(11));
            }
            ps.close();
            return task;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public long getNewID(){
        long id = 0;   
        try {
            database.connect();
            ps = database.prepareStatement("SELECT MAX(task_id) FROM Tasks");
            rs = ps.executeQuery();
            if (rs.next())
                id = rs.getLong(1);
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id+1;
    }
    
    //shows messages from db and how many records have changed
    public void dbMessages(int rows,String type)
    {
        if (rows>0) {
            System.out.println(rows+" rows have been "+type+"!" );
        } else {
            System.out.println(" NO CHANGES! ");
        }
    }
}
