package Controller;

import View.Addproduct;
import View.Placeorder1;
import View.SearchproductC;
import View.SearchproductM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ProductController  {
    SearchproductM Search;
    SearchproductC Search1;
    Addproduct add;
    Placeorder1 order;
    
      public ProductController(SearchproductM Search) {
        this.Search = Search;
    }
       public ProductController(SearchproductC Search1) {
        this.Search1 = Search1;
    }
         public ProductController(Addproduct add) {
        this.add= add;
    }
          public ProductController(Placeorder1 order){
        this.order= order;
    }
            
       Connection con=null;
       PreparedStatement pstmt=null;
       
            String SUrl="jdbc:MySQL://localhost:3306/stock_management_system";
            String SUser="root";
            String SPass="";
             String Product_id,Modelname1,Product1,Colour1,Storage1,Quantity1,unitprice1,Price1;

                      
      public void Searchproduct(DefaultTableModel table,String getProduct,String Model,String query){
         try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(SUrl, SUser, SPass);

        pstmt = con.prepareStatement(query);
        pstmt.setString(1, getProduct);

        if (!Model.isEmpty()) {
            pstmt.setString(2, Model);
        }

                
                      ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int n = rsmd.getColumnCount();
        table.setRowCount(0);

        while (rs.next()) {
            Vector v = new Vector();
            for (int i = 1; i <= n; i++) {
                v.add(rs.getString("Product_ID"));
                v.add(rs.getString("Product_Name"));
                v.add(rs.getString("Model_Name"));
                v.add(rs.getString("Colour"));
                v.add(rs.getString("Storage"));
                v.add(rs.getString("Unit_Price"));
                v.add(rs.getString("Quantity"));
                v.add(rs.getString("Total_Price"));
            }
            table.addRow(v);
        }

        } catch (Exception e) {
       JOptionPane.showMessageDialog(null,e);
        }}
      

public String generateProductID() {
    String query = "SELECT MAX(CAST(SUBSTRING(Product_ID, 4) AS SIGNED)) AS Maxid FROM product_details";

    try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
         PreparedStatement st = con.prepareStatement(query);
         ResultSet rs = st.executeQuery()) {

        if (rs.next()) {
            int maxid = rs.getInt("Maxid");
            maxid++;
            String newProductId = "P_ID" + String.format("%03d", maxid);

            // Check if the generated ID already exists
            while (productIdExists(newProductId, con)) {
                maxid++;
                newProductId = "P_ID" + String.format("%03d", maxid);
            }

            return newProductId;
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
    }
    return null;
}

private boolean productIdExists(String productId, Connection con) throws SQLException {
    String checkQuery = "SELECT COUNT(*) AS count FROM product_details WHERE Product_ID = ?";
    try (PreparedStatement checkStatement = con.prepareStatement(checkQuery)) {
        checkStatement.setString(1, productId);
        ResultSet resultSet = checkStatement.executeQuery();
        return resultSet.next() && resultSet.getInt("count") > 0;
    }
}


private void updatequantity(String product,String Model){
    try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(SUrl, SUser, SPass);
        
        String query="select SELECT quantity FROM customer WHERE Order_product = ? AND Order_model = ?";
          pstmt = con.prepareStatement(query);
          
          pstmt.setString(1, product);
    }catch(Exception e){
         e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
    }
}

private void printtable( DefaultTableModel table){
    
   int rowcount=table.getRowCount();
   int colcount=table.getColumnCount();
   
   for(int row=0; row<rowcount; row++){
        
   }
}
public void updatetotal(String unitPrice,String Modelname){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(SUrl, SUser, SPass);
        
        String query="UPDATE product_details SET Total_Price=Unit_Price*? WHERE Model_Name = ?";
          pstmt = con.prepareStatement(query);
          pstmt.setString(1, unitPrice);
          pstmt.setString(2, Modelname);
          
          pstmt.executeUpdate();
    }catch(Exception e){
         e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
    }
}
 
}

