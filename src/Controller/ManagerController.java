
package Controller;
import Model.ManagerModel;
import View.Addproduct;
import View.CreateAccount1;
import View.Placeorder1;
import View.SearchproductC;
import View.SearchproductM;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManagerController extends Abstracttotal {
    
      
 public double getTotal(int qty,int unitprice) {
        double result = qty * unitprice;
        return result;
    }   

    CreateAccount1 C1;
    Addproduct add;
    SearchproductM Search;
   Placeorder1 order;
   
    public ManagerController(Addproduct add) {
        this.add = add;
    }
     public ManagerController(SearchproductM Search) {
        this.Search = Search;
    }
     public ManagerController(CreateAccount1 C1){
          this.C1 = C1;
     }
         public ManagerController(Placeorder1 order){
        this.order= order;
        }
       Connection con=null;
            PreparedStatement pstmt=null;
           
            String SUrl="jdbc:MySQL://localhost:3306/stock_management_system";
            String SUser="root";
            String SPass="";
            
             String Product_id,Modelname1,Product1,Colour1,Storage1,Quantity1,unitprice1,Price1;
    public void view(String query,  DefaultTableModel table){
        try {
            
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(SUrl, SUser, SPass);
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(query);
    table.setRowCount(0);
 
    while (rs.next()) {
         String Product_id= String.valueOf(rs.getString("Product_ID"));                                                          
         Modelname1=rs.getString("Product_Name");
         Product1=rs.getString("Model_Name");
         Colour1=rs.getString("Colour");
         Storage1=rs.getString("Storage");
         String Quantity1=rs.getString("Quantity");
        unitprice1=rs.getString("Unit_Price");
        String Price1=rs.getString("Total_Price");
        String tbData[] = {Product_id,Modelname1,Product1,Colour1,Storage1,Quantity1,unitprice1,Price1};
        table.addRow(tbData);
    }
    
      }catch(Exception NumberFormateException){
                
                 JOptionPane.showMessageDialog(null,"ERROR");
            }
    }
    public String generateCashierID() {
    String query = "SELECT MAX(CAST(SUBSTRING(C_ID, 2) AS SIGNED)) AS Maxid FROM cashier";
    try {
         Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(SUrl, SUser, SPass);
    PreparedStatement st=con.prepareStatement(query);
       ResultSet rs=st.executeQuery();
       
       if(rs.next()){
           int maxid=rs.getInt("Maxid");
           maxid++;
           return "C_ID"+String.format("%03d",maxid);
       }
                
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
    } 
    return null;
    }

 
 
 public String generateID() {
    String query = "SELECT MAX(CAST(SUBSTRING(U_ID, 4) AS SIGNED)) AS Maxid FROM user";

    try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
         PreparedStatement st = con.prepareStatement(query);
         ResultSet rs = st.executeQuery()) {

        if (rs.next()) {
            int maxid = rs.getInt("Maxid");
            maxid++;
            String newId = "U" + String.format("%03d", maxid);

            // Check if the generated ID already exists
            while (productIdExists(newId, con)) {
                maxid++;
                newId = "U" + String.format("%03d", maxid);
            }

            return newId;
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
    }
    return null;
}

private boolean productIdExists(String newId, Connection con) throws SQLException {
    String checkQuery = "SELECT COUNT(*) AS count FROM user WHERE U_ID = ?";
    try (PreparedStatement checkStatement = con.prepareStatement(checkQuery)) {
        checkStatement.setString(1, newId);
        ResultSet resultSet = checkStatement.executeQuery();
        return resultSet.next() && resultSet.getInt("count") > 0;
    }
}

public boolean isValidPassword(String password) {
    return password.length() >= 8 && password.matches(".*\\d.*");
}

public boolean isValidEmail(String email) {
    return email.toLowerCase().endsWith("@gmail.com");
}
}
    



   
    

