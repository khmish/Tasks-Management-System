
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Tool {
    Tool(){
    }
    
    public String getMAC_Address() {
        String MAC_address = null;
        InetAddress ip;
	try {

            ip = InetAddress.getLocalHost();
            //System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            //System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            //System.out.println(sb.toString());
            MAC_address =  sb.toString();

	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (SocketException e){
		e.printStackTrace();
	}
        
        return MAC_address;
    } 
    
    public void CenterForm(JFrame form){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation(dim.width/2-form.getSize().width/2, dim.height/2-form.getSize().height/2);
    }
    public void CenterForm(JDialog form){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation(dim.width/2-form.getSize().width/2, dim.height/2-form.getSize().height/2);
    }
    
    
    public String reverseDate(String dateToReverse){
        char[] date = dateToReverse.toCharArray();
        String day = date[8] + date[9] + "";
        String month = date[5] + date[6] + "";
        String year = date[0] + date[1] + date[2] + date[3] + "";
        
        return day + "-" + month + "-" + year;
    }
    
    public long daysLeftForSubscription(String strDate){
        try {
            long daysLeft = 0;
            Date today_date = new Date();
            today_date.setTime(0);
            //today_date=new SimpleDateFormat("dd-MM-yyyy").parse(today_date.toString());
            Date expiration_date=new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
            
            long diff = today_date.getTime() - expiration_date.getTime();
            System.out.println (today_date);
            System.out.println (expiration_date);
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            
            return daysLeft;
        } catch (ParseException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
