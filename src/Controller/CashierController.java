
package Controller;
import Model.CashierModel;
import View.CreateAccount1;
import View.Placeorder1;
import View.SearchproductC;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CashierController extends Abstracttotal {
    
    public double getTotal(int qty,int unitprice) {
        double result = qty * unitprice;
        return result;
    
   }

    SearchproductC SearchC;
    Placeorder1 order;
     CreateAccount1 C1;
     
     public CashierController (SearchproductC SearchC) {
        this.SearchC= SearchC;
    }
    public  CashierController (Placeorder1 order){
        this.order= order;
    }
              
     public CashierController (CreateAccount1 C1){
          this.C1 = C1;
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
    
      public void Searchproduct(DefaultTableModel table,String getProduct,String query){
         try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(SUrl, SUser, SPass);

        pstmt = con.prepareStatement(query);
        pstmt.setString(1, getProduct);
     
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int n = rsmd.getColumnCount();
        table.setRowCount(0);

        while (rs.next()) {
            Vector v = new Vector();
            for (int i = 1; i <= n; i++) {
                v.add(rs.getString("Product_Name"));
                v.add(rs.getString("Model_Name"));
                    v.add(rs.getString("Quantity"));
                v.add(rs.getString("Unit_Price"));
            
             
            }
            table.addRow(v);
        }

        } catch (Exception e) {
       JOptionPane.showMessageDialog(null,e);
        }}
      
 
}   