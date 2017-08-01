/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khmish
 */
public class Users {

    private String userName;
    private String firstName;
    private String lastName;
    private String unitId;

    
    public Users(String userName,String firstName,String lastName,String unitId) {
        
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.unitId=unitId;
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
    public String getLastName() {
        return lastName;
    }
    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getFirstName() {
        return firstName;
    }
    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    

}
