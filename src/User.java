/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khmish
 */
public class User {

    private String userName;
    private String name;
    private String password;
    private int isAdmin;
    private String unitId;

    public User(String userName, String pass, String name, int isAdmin, String unitId) {

        this.userName = userName;
        this.password = pass;
        this.name = name;
        this.isAdmin = isAdmin;
        this.unitId = unitId;
    }

    
    public void setAdmin(boolean isAdmin){
        if(isAdmin)
            this.isAdmin = 1;
        else
            this.isAdmin = 0;
    }
    public boolean isAdmin(){
        if (this.isAdmin == 1) return true; 
        else return false;
    }
    
    /**
     * Get the value of unitId
     *
     * @return the value of unitId
     */
    public String getUnitCode() {
        return unitId;
    }

    /**
     * Set the value of unitId
     *
     * @param unitId new value of unitId
     */
    public void setUnitCode(String unitId) {
        this.unitId = unitId;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Set the value of firstName
     *
     * @param password new value of firstName
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
