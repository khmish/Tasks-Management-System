/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khmish
 */
public class Authority {
    
    private String unitCode;
    
    private String assignorUserName;

    private String assigneeUserName;

    Authority(String assignor, String assignee, String unit_code){
        this.unitCode = unit_code;
        this.assignorUserName = assignor;
        this.assigneeUserName =  assignee;
    }
    public String getAssigneeUserName() {
        return assigneeUserName;
    }

    public void setAssigneeUserName(String assigneeUserName) {
        this.assigneeUserName = assigneeUserName;
    }

    public String getAssignorUserName() {
        return assignorUserName;
    }

    public void setAssignorUserName(String assignorUserName) {
        this.assignorUserName = assignorUserName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

}
