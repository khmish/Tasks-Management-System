/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Unit {
    private String unit_code;
    private String name;
    private String contact_info;
    private int isOpenAuthorties;
    private String expiration_date;
    private int subsecription;
    private String note;
    
    Unit(String unit_code, String name, String contact_info, int isOpenAuth, String expiration_date, int subsecription, String note){
        this.unit_code = unit_code;
        this.name = name;
        this.contact_info = contact_info;
        this.isOpenAuthorties = isOpenAuth;
        this.expiration_date = expiration_date;
        this.subsecription = subsecription;
        this.note = note;
    }
    
    public String getUnitCode(){
        return this.unit_code;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getContactInfo(){
        return this.contact_info;
    }
    
    public int getOpenAuthorties(){
        return this.isOpenAuthorties;
    }
    
    public String getExpirationDate(){
        return this.expiration_date;
    }
    
    public int getSubsecription(){
        return this.subsecription;
    }
    
    public boolean isSubsecribed(){
        return this.subsecription == 1? true: false;
    }
    
    public String getNote(){
        return this.note;
    }
    
}
