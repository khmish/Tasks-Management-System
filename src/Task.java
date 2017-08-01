
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Task {
    private int task_id;
    private Date date_created;
    private String assigned_by;
    private String assigned_to;
    private String subject;
    private String details;
    private Date due_date;
    int status;
    String unit_code;
    
    Task(int task_id, Date date_created, String assigned_by, String assigned_to, String subject, String details, Date due_date, int status, String unit_code){
        this.task_id = task_id;
        this.date_created = date_created;
        this.assigned_by = assigned_by;
        this.assigned_to =assigned_to;
        this.subject = subject;
        this.details = details;
        this.due_date = due_date;
        this.status = status;
        this.unit_code = unit_code;
    }
    
    public void setTask_id(int task_id){
        this.task_id = task_id;
    }
    public int getTask_id(){
        return this.task_id;
    }
    
    public void setDate_created(Date date_created){
        this.date_created = date_created;
    }
    public Date getDate_created(){
        return this.date_created;
    }
    
    public void setAssigned_by(String assigned_by){
        this.assigned_by = assigned_by;
    }
    public String getAssigned_by(){
        return this.assigned_by;
    }
    
    public void setAssigned_to(String assigned_to){
        this.assigned_to = assigned_to;
    }
    public String getAssigned_to(){
        return this.assigned_by;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getSubject(){
        return this.subject;
    }
    
    public void setDetails(String details){
        this.details = details;
    }
    public String getDetails(){
        return this.details;
    }
    
     public void setDue_date(Date due_date){
        this.due_date = due_date;
    }
    public Date getDue_date(){
        return this.due_date;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    
    public void setUnit_code(String unit_code){
        this.unit_code = unit_code;
    }
    public String getUnitCode(){
        return this.unit_code;
    }
    
}
