/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khmish
 */
public class Authorities {
    
    private String unitCode;
    
    private String assignorUserName;

    private String assigneeUserName;

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
