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
    private String note;
    
    Unit(String unit_code, String name, String contact_info, String note){
        this.unit_code = unit_code;
        this.name = name;
        this.contact_info = contact_info;
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
    
    public String getNote(){
        return this.note;
    }
    
}