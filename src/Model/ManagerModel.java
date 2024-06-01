
package Model;
import View.CreateAccount1;
import Controller.ManagerController;
public class ManagerModel {
    private String Firstname;
    private String Lastname;
    private String password;
    private int Phone;
    public String getFName(){
        return Firstname;
                
    }
    
    public String getLName(){
        return Lastname;
                
    }
    
    public String getPassword(){
        return password;
                
    }
    public int getPhone(){
        return Phone;
                
    }
    
}
