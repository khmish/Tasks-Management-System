
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public String getFormattedDate(Date date){
        int day = date.getDate();
        int month = date.getMonth()+1;
        int year = date.getYear()+1900;

        return twoDigits(day) + "-" + twoDigits(month) + "-" + year;
    }
    
    private String twoDigits(int value){
        return value<10 ? ("0" + value) : ("" + value);
    }
    
    public int calculateDaysRemainingToDate(String strDate){
        int daysLeft = 0;
        try {
            //Today's Date
            Date today_date = new Date();
            //Expiration Date
            Date expiration_date= new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
            
            //Difference (Calculates in milli-seconds)
            long diff = expiration_date.getTime() - today_date.getTime();
            //Converts from milli-seconds to days
            daysLeft = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            
        } catch (ParseException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return daysLeft;
    }
    /*
    public ArrayList setOtherNames(ArrayList users, ArrayList tasks, int assignType){
        for (int i=0; i<tasks.size(); i++){
            Task t = (Task) tasks.get(i);
            for (int j=0; j<users.size(); j++){
                User u = (User) users.get(j);
                if (assignType == 1 && u.getUsername().equals(t.getAssignor())){
                    t.setTheOtherName(u.getName());
                    tasks.remove(i);
                    tasks.add(i, t);
                }
                else if (assignType == 2 && u.getUsername().equals(t.getAssignee())){
                    t.setTheOtherName(u.getName());
                    tasks.remove(i);
                    tasks.add(i, t);
                }  
            }
        }
        return tasks;
    }
    */
    
    ArrayList receivedTasks;
    ArrayList sentTasks;
    ArrayList closedTasks;
    public void filterTasks(String username, ArrayList tasks){
        receivedTasks = new ArrayList();
        sentTasks = new ArrayList();
        closedTasks = new ArrayList();
        
        ArrayList array = new ArrayList();
        for (int i=0; i<tasks.size(); i++){
            Task t = (Task) tasks.get(i);
            if(t.getAssignee().equals(username)){
                receivedTasks.add(tasks.get(i));
                tasks.remove(i);
            }
            else if(t.getAssignee().equals(username) && t.getStatus() > 0){
                closedTasks.add(tasks.get(i));
            }
        }
        sentTasks=tasks;
    }
    public ArrayList getSentTasks(String username, ArrayList tasks){
        
        ArrayList array = new ArrayList();
        for (int i=0; i<tasks.size(); i++){
            Task t = (Task) tasks.get(i);
            if(t.getAssignor().equals(username)){
                array.add(tasks.get(i));
                tasks.remove(i);
            }
        }
        return array;
    }
    public ArrayList getClosedTasks(String username, ArrayList tasks){
        
        ArrayList array = new ArrayList();
        for (int i=0; i<tasks.size(); i++){
            Task t = (Task) tasks.get(i);
            if(t.getAssignor().equals(username) && t.getStatus() > 0){
                array.add(tasks.get(i));
                tasks.remove(i);
            }
        }
        return array;
    }
    
}
