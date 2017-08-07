/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Login {
    private String mac_address;
    private String user;
    private String unit_code;
    
    Login(String mac_address, String username, String unit_code){
        this.mac_address = mac_address;
        this.user = username;
        this.unit_code = unit_code;
    }
    
    public String getMacAddress(){
        return this.mac_address;
    }
    public String getUser(){
        return this.user;
    }
    public String getUnitCode(){
        return this.unit_code;
    }
}
