/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CashierController;
import Controller.ManagerController;
import Controller.ProductController;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author Kidurshalini
 */
public class Placeorder1 extends javax.swing.JInternalFrame {

    ProductController Product;
    ManagerController manager;
    CashierController Cashier;
    Connection con = null;
    PreparedStatement pstmt = null;

    String SUrl = "jdbc:MySQL://localhost:3306/stock_management_system";
    String SUser = "root";
    String SPass = "";

    String cus_name, cus_address, cus_email, payment, total;
    int cus_phone;
    double gettotal;

    /**
     * Creates new form PlaceOrder1
     */
    public Placeorder1() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        ui.setEastPane(null);
        ui.setSouthPane(null);
        ui.setWestPane(null);
        Product = new ProductController(this);
        Cashier = new CashierController(this);
        manager = new ManagerController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        unitprice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Model = new javax.swing.JTextField();
        findtotal = new javax.swing.JButton();
        Clearorder = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        placeorder = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CusFname = new javax.swing.JTextField();
        cusP_no = new javax.swing.JTextField();
        cusE_id = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        orderqty = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Totalprice = new javax.swing.JTextField();
        SProduct = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        product = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoice = new javax.swing.JTextArea();
        Print = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchtbl = new javax.swing.JTable();
        Ordersearch1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        viewtbl = new javax.swing.JTable();
        viewCus = new javax.swing.JButton();
        CADelete = new javax.swing.JButton();
        addtable = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        searchtbl1 = new javax.swing.JTable();
        Clear = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Model name:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 153));
        jLabel18.setText("Product details");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 14, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Unit Price:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        unitprice.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        unitprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        unitprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitpriceActionPerformed(evt);
            }
        });
        jPanel1.add(unitprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 180, 22));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Product Name:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        Model.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Model.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelActionPerformed(evt);
            }
        });
        jPanel1.add(Model, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 180, 22));

        findtotal.setBackground(new java.awt.Color(255, 255, 255));
        findtotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        findtotal.setForeground(new java.awt.Color(0, 0, 102));
        findtotal.setText("Find");
        findtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findtotalActionPerformed(evt);
            }
        });
        jPanel1.add(findtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 60, -1));

        Clearorder.setBackground(new java.awt.Color(255, 204, 204));
        Clearorder.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Clearorder.setForeground(new java.awt.Color(255, 51, 51));
        Clearorder.setText("CLEAR");
        Clearorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearorderActionPerformed(evt);
            }
        });
        jPanel1.add(Clearorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 640, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setText("Product Name:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        placeorder.setBackground(new java.awt.Color(255, 255, 255));
        placeorder.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        placeorder.setForeground(new java.awt.Color(0, 0, 102));
        placeorder.setText("PLACE ORDER");
        placeorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeorderActionPerformed(evt);
            }
        });
        jPanel1.add(placeorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 130, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 153));
        jLabel20.setText("Customer details");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 14, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Address:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 107, -1, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setText("Full name:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 65, 131, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setText("Phone number:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 167, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setText("Email id:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 195, -1, -1));

        CusFname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        CusFname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CusFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusFnameActionPerformed(evt);
            }
        });
        jPanel1.add(CusFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 67, 175, 22));

        cusP_no.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cusP_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cusP_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusP_noActionPerformed(evt);
            }
        });
        jPanel1.add(cusP_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 164, 175, 22));

        cusE_id.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cusE_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cusE_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusE_idActionPerformed(evt);
            }
        });
        jPanel1.add(cusE_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 191, 174, 22));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setText("Payment method:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 232, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("Quantity:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        orderqty.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        orderqty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        orderqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderqtyActionPerformed(evt);
            }
        });
        jPanel1.add(orderqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 180, 22));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        jLabel29.setText("Total Price:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 230, -1, -1));

        Totalprice.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Totalprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Totalprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalpriceActionPerformed(evt);
            }
        });
        jPanel1.add(Totalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 234, 180, 22));

        SProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mac ", "I-phone", "Airpods", "I-Watchs" }));
        SProduct.setBorder(null);
        jPanel1.add(SProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 79, 20));

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jCheckBox1.setText("Cash");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 228, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jCheckBox2.setText("Card");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 228, -1, -1));

        product.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mac ", "I-phone", "Airpods", "I-Watchs" }));
        product.setBorder(null);
        jPanel1.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, 22));

        Address.setColumns(20);
        Address.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Address.setRows(5);
        Address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(Address);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 53));

        invoice.setBackground(new java.awt.Color(204, 204, 204));
        invoice.setColumns(20);
        invoice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        invoice.setRows(5);
        jScrollPane3.setViewportView(invoice);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 10, 310, 508));

        Print.setBackground(new java.awt.Color(255, 255, 255));
        Print.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Print.setForeground(new java.awt.Color(0, 0, 102));
        Print.setText("PRINT");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        jPanel1.add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 540, -1, -1));

        searchtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_Name", "Model_Name", "Quantity", "Unit_Price"
            }
        ));
        searchtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(searchtbl);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 350, 130));

        Ordersearch1.setBackground(new java.awt.Color(255, 255, 255));
        Ordersearch1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Ordersearch1.setForeground(new java.awt.Color(0, 0, 102));
        Ordersearch1.setText("SEARCH");
        Ordersearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ordersearch1ActionPerformed(evt);
            }
        });
        jPanel1.add(Ordersearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        viewtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer_name", "Address", "Phone_no", "Email", "Model_name", "Quantity", "Total_price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewtblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(viewtbl);
        if (viewtbl.getColumnModel().getColumnCount() > 0) {
            viewtbl.getColumnModel().getColumn(4).setResizable(false);
            viewtbl.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 660, 120));

        viewCus.setBackground(new java.awt.Color(255, 255, 255));
        viewCus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        viewCus.setForeground(new java.awt.Color(0, 0, 102));
        viewCus.setText("VIEW CUSTOMER DETAILS");
        viewCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCusActionPerformed(evt);
            }
        });
        jPanel1.add(viewCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        CADelete.setBackground(new java.awt.Color(255, 204, 204));
        CADelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CADelete.setForeground(new java.awt.Color(255, 0, 0));
        CADelete.setText("DELETE");
        CADelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CADeleteActionPerformed(evt);
            }
        });
        jPanel1.add(CADelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, -1));

        addtable.setBackground(new java.awt.Color(255, 255, 255));
        addtable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addtable.setForeground(new java.awt.Color(0, 0, 102));
        addtable.setText("ADD TO TABLE");
        addtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtableActionPerformed(evt);
            }
        });
        jPanel1.add(addtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 305, 160, 30));

        searchtbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Model_Name", "Quantity", "Unit_Price", "Total_price"
            }
        ));
        searchtbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtbl1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(searchtbl1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 320, 120));

        Clear.setBackground(new java.awt.Color(255, 51, 51));
        Clear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 0, 0));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel1.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitpriceActionPerformed

    private void ModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelActionPerformed

    private void findtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findtotalActionPerformed
        int unitPrice = Integer.parseInt(unitprice.getText());
        int qty = Integer.parseInt(orderqty.getText());
        double gettotal = Cashier.getTotal(qty, unitPrice);
        gettotal = Cashier.getTotal(qty, unitPrice);
        total = String.valueOf(gettotal);
        Totalprice.setText(String.valueOf(gettotal));
        String getProduct = product.getSelectedItem().toString();


    }//GEN-LAST:event_findtotalActionPerformed

    private void ClearorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearorderActionPerformed
        CusFname.setText("");
        Address.setText("");
        cusP_no.setText("");
        cusE_id.setText("");
        Model.setText("");
        unitprice.setText("");
        orderqty.setText("");
        Totalprice.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        DefaultTableModel model = (DefaultTableModel) searchtbl1.getModel();
        DefaultTableModel table = (DefaultTableModel) searchtbl.getModel();
        DefaultTableModel table1 = (DefaultTableModel) viewtbl.getModel();
        model.setRowCount(0);
        table.setRowCount(0);
        table1.setRowCount(0);
    }//GEN-LAST:event_ClearorderActionPerformed

    private void CusFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusFnameActionPerformed

    private void cusP_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusP_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusP_noActionPerformed

    private void cusE_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusE_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusE_idActionPerformed

    private void orderqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderqtyActionPerformed

    private void TotalpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalpriceActionPerformed

    }//GEN-LAST:event_TotalpriceActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try {
            invoice.print();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void searchtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtblMouseClicked
        DefaultTableModel model = (DefaultTableModel) searchtbl.getModel();
        product.setSelectedItem(model.getValueAt(searchtbl.getSelectedRow(), 0).toString());
        Model.setText(model.getValueAt(searchtbl.getSelectedRow(), 1).toString());
        unitprice.setText(model.getValueAt(searchtbl.getSelectedRow(), 3).toString());

    }//GEN-LAST:event_searchtblMouseClicked

    private void Ordersearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ordersearch1ActionPerformed
        String getProduct = SProduct.getSelectedItem().toString();
        String query;
        query = "SELECT Product_ID, Product_Name, Model_Name, Colour, Storage, Quantity, Unit_Price FROM product_details WHERE Product_Name=?";
        DefaultTableModel table = (DefaultTableModel) searchtbl.getModel();
        Cashier.Searchproduct(table, getProduct, query);

    }//GEN-LAST:event_Ordersearch1ActionPerformed

    private void placeorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeorderActionPerformed
        Date date=new Date();
        cus_name = CusFname.getText();
        cus_address = Address.getText();
        String phoneNumberString = cusP_no.getText().replaceAll("[^0-9]", "");
        String getProduct = product.getSelectedItem().toString();
        if (phoneNumberString.length() == 10||phoneNumberString.length() == 9) {
            cus_phone = Integer.parseInt(phoneNumberString);
            String Orderquantity = orderqty.getText();
            String unitPrice = unitprice.getText();
            cus_email = cusE_id.getText();
            String modelname = Model.getText();
            if (cus_name.equals("") | cus_address.equals("")) {
                JOptionPane.showMessageDialog(null, "Fields can't be empty");
            } else {
                if (jCheckBox1.isSelected()) {
                    payment = "cash";

                } else {
                    payment = "card";

                }
                invoice.setText("\n" +"\t                         INVOICE\n "
                        + "\t                     APPLE iSTORE\n"
                        + "\t             26/b AMBAGAMUWA RD, \n"
                        + "\t                        GAMPOLA\n "
                        + "\t                0812466047,0775433085\n \n"
                        +date+"\n \n "
                        + "--------------------------------------------------------------------------------------------- \n"
                        + "CUSTOMER DETAILS \n"
                        + "---------------------------------------------------------------------------------------------- \n");
                invoice.setText(invoice.getText() + "Customername:" + cus_name + "\n");
                invoice.setText(invoice.getText() + "Address:     " + "\t" + cus_address + "\n");
                invoice.setText(invoice.getText() + "Phone no:    " + "\t" + cus_phone + "\n");
                invoice.setText(invoice.getText() + "Emailid:     " + "\t" + cus_email + "\n");
                invoice.setText(invoice.getText() + "Payment method:     " + "\t" + payment + "\n"
                        + "___________________________________________________________________________ \n"
                        + "Model name \t  Quantity \t Unitprice  \t   Total price \t \n"
                        + "___________________________________________________________________________ \n");

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection(SUrl, SUser, SPass);

                    String query = "INSERT INTO customer(Customer_name,Address,Phone_no,Email_id,payment_method,Order_product,Order_model,Quantity, Total_price)value(?,?,?,?,?,?,?,?,?)";
                    pstmt = con.prepareStatement(query);

                    DefaultTableModel model = (DefaultTableModel) searchtbl1.getModel();
                    DefaultTableModel table = (DefaultTableModel) searchtbl.getModel();
                    int rowCount = model.getRowCount();
                    double totalValue = 0;

                    StringBuilder print = new StringBuilder();
                    for (int row = 0; row < rowCount; row++) {
                        StringBuilder rowData = new StringBuilder();
   
                        modelname = model.getValueAt(row, 0).toString();
                        Orderquantity = model.getValueAt(row, 1).toString();
                        String unit = model.getValueAt(row, 2).toString();
                        String total1 = model.getValueAt(row, 3).toString();
                        double total1Value = Double.parseDouble(total1);
                        totalValue = totalValue + total1Value;

                        rowData.append(modelname).append("\t").append(Orderquantity).append("\t").append(unit).append("\t").append(total1).append("\t \n");
                        invoice.append(rowData.toString());
                        pstmt.setString(1, cus_name);
                        pstmt.setString(2, cus_address);
                        pstmt.setInt(3, cus_phone);
                        pstmt.setString(4, cus_email);
                        pstmt.setString(5, payment);
                        pstmt.setString(6, getProduct);
                        pstmt.setString(7, modelname);
                        pstmt.setString(8, Orderquantity);
                        pstmt.setDouble(9, totalValue);
                        pstmt.executeUpdate();

                        String updateQuantityQuery = "UPDATE product_details SET Quantity = Quantity - ? ,Total_Price=Unit_Price*? WHERE Model_Name = ?";
                        try (PreparedStatement updateQuantityStmt = con.prepareStatement(updateQuantityQuery)) {
                            updateQuantityStmt.setString(1, Orderquantity);
                            updateQuantityStmt.setString(2, Orderquantity);
                            updateQuantityStmt.setString(3, modelname);
                            updateQuantityStmt.executeUpdate();
                        }

                    }

                    print.append("___________________________________________________________________ \n");
                    print.append("Total Price").append("\t \t \t").append(totalValue).append("\t");
                    invoice.append(print.toString());
                    JOptionPane.showMessageDialog(null, "Order succussfully placed");
                    model.setRowCount(0);
                    table.setRowCount(0);

                    CusFname.setText("");
                    Address.setText("");
                    cusP_no.setText("");
                    cusE_id.setText("");
                    Model.setText("");
                    unitprice.setText("");
                    orderqty.setText("");
                    Totalprice.setText("");
                    jCheckBox1.setSelected(false);
                    jCheckBox2.setSelected(false);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Give correct number");

        }
    }//GEN-LAST:event_placeorderActionPerformed

    private void viewtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewtblMouseClicked
        DefaultTableModel model = (DefaultTableModel) viewtbl.getModel();
        CusFname.setText(model.getValueAt(viewtbl.getSelectedRow(), 0).toString());
        Address.setText(model.getValueAt(viewtbl.getSelectedRow(), 1).toString());
        cusP_no.setText(model.getValueAt(viewtbl.getSelectedRow(), 2).toString());
        cusE_id.setText(model.getValueAt(viewtbl.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_viewtblMouseClicked

    private void viewCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCusActionPerformed
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String query = "select * from  customer";
            DefaultTableModel table = (DefaultTableModel) viewtbl.getModel();
            ResultSet rs = st.executeQuery(query);
            table.setRowCount(0);

            while (rs.next()) {
                String Customer_name = rs.getString("Customer_name");
                String adress = rs.getString("Address");
                String email = rs.getString("Email_id");
                String Phone = rs.getString("Phone_no");
                String Model = rs.getString("Order_model");
                String Quantity = rs.getString("Quantity");
                String Price = rs.getString("Total_Price");
                String tbData[] = {Customer_name,adress, Phone,email, Model, Quantity, Price};
                table.addRow(tbData);
            }

        } catch (Exception NumberFormateException) {

            JOptionPane.showMessageDialog(null, "ERROR");
        }

    }//GEN-LAST:event_viewCusActionPerformed

    private void CADeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CADeleteActionPerformed

        try {
            int selectedRow = viewtbl.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Select the row");
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(SUrl, SUser, SPass);
                cus_name = CusFname.getText();
                String query = "delete from customer where Customer_name=?";

                pstmt = con.prepareStatement(query);
                pstmt.setString(1, cus_name);
                pstmt.execute();

                JOptionPane.showMessageDialog(null, "delected");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_CADeleteActionPerformed

    private void addtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtableActionPerformed
        DefaultTableModel table = (DefaultTableModel) searchtbl1.getModel();

        String getModel = Model.getText();
        String qty = orderqty.getText();
        String Total = Totalprice.getText();
        String unit = unitprice.getText();

        table.addRow(new Object[]{getModel, qty, unit, Total});
        Model.setText("");
        unitprice.setText("");
        orderqty.setText("");
        Totalprice.setText("");

    }//GEN-LAST:event_addtableActionPerformed

    private void searchtbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtbl1MouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
         DefaultTableModel table = (DefaultTableModel) searchtbl1.getModel();
         table.setRowCount(0);
    }//GEN-LAST:event_ClearActionPerformed

private boolean checkQuantity(String modelname, String orderQuantity) {
    try {
        String query = "SELECT Quantity FROM product_details WHERE Model_Name = ?";
        try (PreparedStatement pstmtCheck = con.prepareStatement(query)) {
            pstmtCheck.setString(1, modelname);
            ResultSet rs = pstmtCheck.executeQuery();
            if (rs.next()) {
                int availableQuantity = rs.getInt("Quantity");
                int orderedQuantity = Integer.parseInt(orderQuantity);
                if (orderedQuantity > availableQuantity) {
                    JOptionPane.showMessageDialog(null, "Not enough quantity available for model: " + modelname);
                    return false;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return true;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Address;
    private javax.swing.JButton CADelete;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Clearorder;
    private javax.swing.JTextField CusFname;
    private javax.swing.JTextField Model;
    private javax.swing.JButton Ordersearch1;
    private javax.swing.JButton Print;
    private javax.swing.JComboBox<String> SProduct;
    private javax.swing.JTextField Totalprice;
    private javax.swing.JButton addtable;
    private javax.swing.JTextField cusE_id;
    private javax.swing.JTextField cusP_no;
    private javax.swing.JButton findtotal;
    private javax.swing.JTextArea invoice;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField orderqty;
    private javax.swing.JButton placeorder;
    private javax.swing.JComboBox<String> product;
    private javax.swing.JTable searchtbl;
    private javax.swing.JTable searchtbl1;
    private javax.swing.JTextField unitprice;
    private javax.swing.JButton viewCus;
    private javax.swing.JTable viewtbl;
    // End of variables declaration//GEN-END:variables
}