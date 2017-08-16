
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;


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
    
    //these two methods displays form in the center of the screen
    //they are called in the constructor of all forms excactlly this way:
    // CenterForm(this);
    public void CenterForm(JFrame form){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation(dim.width/2-form.getSize().width/2, dim.height/2-form.getSize().height/2);
    }
    public void CenterForm(JDialog form){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation(dim.width/2-form.getSize().width/2, dim.height/2-form.getSize().height/2);
    }
    
    
    //mysql date comes in format yyyy-mm-dd. 
    //This method makes it dd-mm-yyyy
    public String reverseDate(String date){
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);

        return day + "-" + month + "-" + year;
    }
    
    public int calculateDaysRemainingToDate(String strDate){
        int daysLeft = 0;
        try {
            //Today's Date
            Date today_date = new Date();
            //Expiration Date
            Date expiration_date= new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            
            //Difference (Calculates in milli-seconds)
            long diff = today_date.getTime() - expiration_date.getTime();
            //Converts from milli-seconds to days
            daysLeft = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            
        } catch (ParseException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daysLeft;
    }
}
