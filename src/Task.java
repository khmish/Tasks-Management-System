
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
    private long task_id;
    private String created_date;
    private String assignor;
    private String assignee;
    private String subject;
    private String details;
    private String due_date;
    int status;
    String unit_code;
    
    
    private String assignorName; 
    private String assigneeName;
    
    Task(){
        
    }
    Task(long task_id, String created_date, String assignor, String assignee, String subject, String details, String due_date, int status, String unit_code){
        this.task_id = task_id;
        this.created_date = created_date;
        this.assignor = assignor;
        this.assignee =assignee;
        this.subject = subject;
        this.details = details;
        this.due_date = due_date;
        this.status = status;
        this.unit_code = unit_code;
    }
    
    public void setTaskID(long task_id){
        this.task_id = task_id;
    }
    public long getTaskID(){
        return this.task_id;
    }
    
    public void setCreatedDate(String created_date){
        this.created_date = created_date;
    }
    public String getCreatedDate(){
        return this.created_date;
    }
    
    public void setAssignor(String assignor){
        this.assignor = assignor;
    }
    public String getAssignor(){
        return this.assignor;
    }
    
    public void setAssignee(String assignee){
        this.assignee = assignee;
    }
    public String getAssignee(){
        return this.assignee;
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
    
     public void setDueDate(String due_date){
        this.due_date = due_date;
    }
    public String getDueDate(){
        return this.due_date;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    
    public void setUnitCode(String unit_code){
        this.unit_code = unit_code;
    }
    public String getUnitCode(){
        return this.unit_code;
    }
    
    public void setAssignorName(String name){
        this.assignorName = name;
    }
    public String getAssignorName(){
        return this.assignorName;
    }
    
    public void setAssigneeName(String name){
        this.assigneeName = name;
    }
    public String getAssigneeName(){
        return this.assigneeName;
    }
}
