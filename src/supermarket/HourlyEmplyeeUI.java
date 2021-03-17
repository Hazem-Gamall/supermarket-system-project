/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hazem
 */
public class HourlyEmplyeeUI extends javax.swing.JFrame {

    /**
     * Creates new form HourlyEmplyeeU
     */
    
    final String table = "hourly_employee";
    
    public HourlyEmplyeeUI() {
        initComponents();
        jTable1.setDefaultEditor(Object.class, null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hourly Employees");
        setMinimumSize(new java.awt.Dimension(530, 400));
        setPreferredSize(new java.awt.Dimension(530, 400));
        setSize(new java.awt.Dimension(530, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        addButton.setText("Add");
        addButton.setMinimumSize(new java.awt.Dimension(65, 28));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Hourly Employees Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(120, 120, 120)
                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(148, 148, 148))
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        createInputMessage();//create the panel to be shown in the ConfirmDialog

        int x = JOptionPane.showConfirmDialog(null,myPanel,"input",JOptionPane.OK_CANCEL_OPTION);

        if(x == JOptionPane.OK_OPTION){

            //setting the data fields to the input
            try{
                
                HourlyEmployee hourEmp = null;
                
                Long.parseLong(phone_numField.getText());
                if(phone_numField.getText().length() != 11) throw new Exception("The entered phone number is incorrect, please make sure it's an egyptian phone number with 11 digits.");
                
                
                if(nameField.getText().matches("[a-zA-Z]+")){

                    hourEmp = new HourlyEmployee(new PersonSpec(nameField.getText(),
                            phone_numField.getText(),
                            Integer.parseInt(ageField.getText()),
                            Integer.parseInt(idField.getText())),
                            Double.parseDouble(hourRateField.getText()),
                            Double.parseDouble(hoursField.getText()));

                }else{
                    throw new Exception("Please enter a Proper name.");
                }

                
                try(Connection con = ProjectUtil.getcon()){     //try-with-resources will auto close connection
                    hourEmp.update(con);
                    jTable1.setModel(ProjectUtil.fetchToTableModel(con, table));
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error! Please make sure to Enter proper values");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        try(Connection con = ProjectUtil.getcon()){     //try-with-resources will auto close connection
            ProjectUtil.delete(con, table, (int)jTable1.getValueAt(jTable1.getSelectedRow(), 0), jTable1);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Please Select a row to remove.");
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        ProjectUtil.switchFrame(this, new Welcome());
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try(Connection con = ProjectUtil.getcon()){     //try-with-resources will auto close connection
            jTable1.setModel(ProjectUtil.fetchToTableModel(con, table));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HourlyEmplyeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HourlyEmplyeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HourlyEmplyeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HourlyEmplyeeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HourlyEmplyeeUI().setVisible(true);
            }
        });
    }
    
         private void createInputMessage(){
        myPanel = new JPanel();
        myPanel.add(new JLabel("Id:"));
        myPanel.add(idField);
        
        myPanel.add(Box.createHorizontalStrut(5)); // a spacer
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        
        myPanel.add(Box.createHorizontalStrut(5)); // a spacer
        myPanel.add(new JLabel("Age:"));
        myPanel.add(ageField);
        
        myPanel.add(Box.createHorizontalStrut(5)); // a spacer
        myPanel.add(new JLabel("Phone Number:"));
        myPanel.add(phone_numField);
        
        myPanel.add(Box.createHorizontalStrut(5)); // a spacer
        myPanel.add(new JLabel("Hour Rate:"));
        myPanel.add(hourRateField);
        
        myPanel.add(Box.createHorizontalStrut(5)); // a spacer
        myPanel.add(new JLabel("Hours:"));
        myPanel.add(hoursField);
    }

    
    JPanel myPanel = new JPanel();
    
    JTextField idField = new JTextField(6);
    JTextField nameField = new JTextField(6);
    JTextField ageField = new JTextField(6);
    JTextField phone_numField = new JTextField(6);
    JTextField hourRateField = new JTextField(6);
    JTextField hoursField = new JTextField(6);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
