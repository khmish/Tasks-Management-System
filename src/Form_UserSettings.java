
import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Form_UserSettings extends javax.swing.JFrame {

    /**
     * Creates new form FormSettings
     */
    int access_type; // if 1, access as an administrator. 0, access as normal user
    User user;
    Form_Tasks tasksForm;
    
    public Form_UserSettings(User user, int access_type, Form_Tasks tasksForm) {
        initComponents();
        new Tool().CenterForm(this);
        this.user = user;
        this.access_type = access_type;
        this.tasksForm = tasksForm;
        
        txtName.setText(user.getName());
        txtUser.setText(user.getUserName());
            
        if (this.access_type == 1){
            txtName.setEditable(true);
            txtUser.setEditable(false);
            chbSetAdmin.setVisible(true);
            txtOldPass.setEditable(false);
            txtPass1.setEditable(true);
            txtPass2.setEditable(true);
        }
        else{
            txtName.setEditable(false);
            txtUser.setEditable(false);
            chbSetAdmin.setVisible(false);
            txtOldPass.setEditable(true);
            txtPass1.setEditable(true);
            txtPass2.setEditable(true);
        }
        lblErrorMessage.setVisible(false);
        lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        
        LoginsTable logsTable = new LoginsTable();
        int logs = logsTable.getNumberOfDevicesRegistered(user.getUserName()) - 1;
        if (logs == 1){
            lblLogsInfo.setText("There are no other devices connected to your account");
            lblLogoutUser.setEnabled(false);
        }
        else if(logs == 2)
            lblLogsInfo.setText("There is another device connected to your account");
        else
            lblLogsInfo.setText("There are " + logs + " other devices connected to your account");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        lstMenu = new javax.swing.JList();
        txtName = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtOldPass = new javax.swing.JPasswordField();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblErrorMessage = new javax.swing.JLabel();
        chbSetAdmin = new javax.swing.JCheckBox();
        lblLogsInfo = new javax.swing.JLabel();
        lblLogoutDevice = new javax.swing.JLabel();
        lblLogoutUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstMenu.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "My Tasks", "Sent Tasks", "Settings" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstMenu.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstMenuValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstMenu);

        jLabel1.setText("Name");

        jLabel2.setText("User");

        jLabel3.setText("Old Password");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel4.setText("User's Settings");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtPass1.setForeground(new java.awt.Color(0, 163, 12));

        txtPass2.setForeground(new java.awt.Color(0, 163, 12));

        jLabel5.setText("New Password");

        jLabel6.setText("Confirm Password");

        lblErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMessage.setText("Error Message");

        chbSetAdmin.setForeground(new java.awt.Color(0, 0, 255));
        chbSetAdmin.setText("Set as Admin");

        lblLogsInfo.setText("logs info");

        lblLogoutDevice.setForeground(new java.awt.Color(0, 0, 255));
        lblLogoutDevice.setText("Log out from this device");
        lblLogoutDevice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogoutDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutDeviceMouseClicked(evt);
            }
        });

        lblLogoutUser.setForeground(new java.awt.Color(0, 0, 255));
        lblLogoutUser.setText("Log out from ALL other devices");
        lblLogoutUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogoutUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutUserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOldPass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(txtPass1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPass2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbSetAdmin))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogoutDevice)
                    .addComponent(lblLogoutUser)
                    .addComponent(lblLogsInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(chbSetAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage)
                .addGap(45, 45, 45)
                .addComponent(lblLogsInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoutDevice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogoutUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstMenuValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMenuValueChanged
        this.tasksForm.setVisible(true);
        this.tasksForm.setMenuSelection(lstMenu.getSelectedIndex());
        this.setVisible(false);
    }//GEN-LAST:event_lstMenuValueChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //System.out.println(txtPass1.getPassword() +" --- "+txtPass2.getPassword());
        //System.out.println(txtPass1.getPassword().toString()+" --- "+txtPass2.getText());
        if (this.access_type == 1)
            this.validateAsAdmin();
        else
            this.validateInputs();
        
        
        lblErrorMessage.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblLogoutDeviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutDeviceMouseClicked
        new LoginsTable().logout();
    }//GEN-LAST:event_lblLogoutDeviceMouseClicked

    private void lblLogoutUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutUserMouseClicked
        new LoginsTable().logAllSessionOut(null);
    }//GEN-LAST:event_lblLogoutUserMouseClicked

    private void validateAsAdmin(){
        if (txtName.getText().length() < 1)
            lblErrorMessage.setText("Name field cannot left blank");
        else if (txtUser.getText().length() < 1)
            lblErrorMessage.setText("Error with username");
        else if(txtPass1.getText().length() < 4)
            lblErrorMessage.setText("Password must be no less than 4 characters");
        else if(!txtPass1.getText().equals(txtPass2.getText()))
            lblErrorMessage.setText("Passwords does not match");
        else{
            user.setName(txtName.getText());
            user.setPassword(txtPass1.getText());
            user.setAdmin(chbSetAdmin.isSelected());
            
            boolean updated = new UsersTable().Update(user);
            if(updated){
                JOptionPane.showMessageDialog(null, "Changes have been updated successfully!");
                this.clearPasswords();
                lblErrorMessage.setVisible(false);
            }
            else
                lblErrorMessage.setText("Sorry, something went wrong while saving your changes!");
        }
    }
 
    private void validateInputs(){
        if (txtName.getText().length() < 1)
            lblErrorMessage.setText("Name field cannot left blank");
        else if (txtUser.getText().length() < 1)
            lblErrorMessage.setText("Error with username");
        else if(txtPass1.getText().length() < 4)
            lblErrorMessage.setText("Password must be no less than 4 characters");
        else if (txtOldPass.getText().equals(user.getPassword()))
            lblErrorMessage.setText("Incorrect password");
        else if(!txtPass1.getText().equals(txtPass2.getPassword()))
            lblErrorMessage.setText("Passwords does not match");
        else{
            
            boolean updated = new UsersTable().UpdatePass(user.getName(), txtPass1.getText());
            if(updated){
                JOptionPane.showMessageDialog(null, "Changes have been updated successfully!");
                this.clearPasswords();
            }
            else
                lblErrorMessage.setText("Sorry, something went wrong while saving your changes!");
        }
    }
    
    private void clearPasswords(){
        txtOldPass.setText("");
        txtPass1.setText("");
        txtPass2.setText("");
    }
    public void setMenuSelection(int value){
        lstMenu.setSelectedIndex(value);
    }
    
        
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
            java.util.logging.Logger.getLogger(Form_UserSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_UserSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_UserSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_UserSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Form_UserSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chbSetAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblLogoutDevice;
    private javax.swing.JLabel lblLogoutUser;
    private javax.swing.JLabel lblLogsInfo;
    private javax.swing.JList lstMenu;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}