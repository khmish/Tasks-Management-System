
import javax.swing.JDialog;
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
    User user;
    Form_Tasks tasksForm;
    
    public Form_UserSettings(User user, Form_Tasks tasksForm) {
        initComponents();
        new Tool().CenterForm(this);
        this.user = user;
        this.tasksForm = tasksForm;
        setup();
    }
    
    private void setup(){
        txtName.setText(user.getName());
        txtUser.setText(user.getUsername());
            
        txtName.setEditable(false);
        txtUser.setEditable(false);
        txtOldPass.setEditable(true);
        txtPass1.setEditable(true);
        txtPass2.setEditable(true);
        lblErrorMessage.setVisible(false);
        lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        
        if(this.user.isAdmin()) lblAdminSettings.setVisible(true);
        else lblAdminSettings.setVisible(false);
        
        LoginsTable logsTable = new LoginsTable();
        int logs = logsTable.getNumberOfDevicesRegistered(user.getUsername());
        
        //current device is counted
        if (logs == 1){
            lblLogsInfo.setText("There is no other devices connected to your account");
            lblLogoutUser.setEnabled(false);
        }
        else if(logs == 2)
            lblLogsInfo.setText("There is 1 other device connected to your account");
        else if(logs > 2)
            lblLogsInfo.setText("There are " + logs + " other devices connected to your account");
        else //this occers when -1 is returnend
            lblLogsInfo.setText("Number of devices connected: (Information Not Available)");
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
        lblLogsInfo = new javax.swing.JLabel();
        lblLogoutDevice = new javax.swing.JLabel();
        lblLogoutUser = new javax.swing.JLabel();
        lblAdminSettings = new javax.swing.JLabel();

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

        txtOldPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOldPassKeyPressed(evt);
            }
        });

        txtPass1.setForeground(new java.awt.Color(0, 163, 12));
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass1KeyPressed(evt);
            }
        });

        txtPass2.setForeground(new java.awt.Color(0, 163, 12));
        txtPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass2KeyPressed(evt);
            }
        });

        jLabel5.setText("New Password");

        jLabel6.setText("Confirm Password");

        lblErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMessage.setText("Error Message");

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

        lblAdminSettings.setForeground(new java.awt.Color(0, 0, 255));
        lblAdminSettings.setText("Admin Settings");
        lblAdminSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdminSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminSettingsMouseClicked(evt);
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
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAdminSettings))
                    .addGroup(layout.createSequentialGroup()
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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtOldPass, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addComponent(txtPass1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPass2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogoutDevice)
                            .addComponent(lblLogoutUser)
                            .addComponent(lblLogsInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAdminSettings)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void update(){
        if(isValidInputs()){
            lblErrorMessage.setVisible(false);
            JOptionPane.showMessageDialog(null, "Changes have been updated successfully!");
            this.clearPasswords();
        }
        else
            lblErrorMessage.setVisible(true);
    }
    
    private void lblLogoutDeviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutDeviceMouseClicked
        boolean loggedOut = new LoginsTable().logout();
        if (loggedOut){
            JOptionPane.showMessageDialog(null, "Your account has been logged out from this device!");
            System.exit(0);
        }
        else{
            JOptionPane.showMessageDialog(null, "Error occuerd, could not log you out. Please check \nyour internet connection");
        }
        
    }//GEN-LAST:event_lblLogoutDeviceMouseClicked

    private void lblLogoutUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutUserMouseClicked
        boolean loggedOut = new LoginsTable().logAllSessionOut(user.getUsername());
        if (loggedOut){
            lblLogoutUser.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Your account has been logged out from the other devices");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error occuerd, could not log you out from the other devices.\nPlease check your internet connection");
        }
    }//GEN-LAST:event_lblLogoutUserMouseClicked

    private void lblAdminSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminSettingsMouseClicked
        JDialog form = new Dialog_AdminSettings(user);
        form.setVisible(true);
    }//GEN-LAST:event_lblAdminSettingsMouseClicked

    private void txtOldPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOldPassKeyPressed
        if (evt.getKeyCode() == 10)
            update();
    }//GEN-LAST:event_txtOldPassKeyPressed

    private void txtPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyPressed
        if (evt.getKeyCode() == 10)
            update();
    }//GEN-LAST:event_txtPass1KeyPressed

    private void txtPass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass2KeyPressed
        if (evt.getKeyCode() == 10)
            update();
    }//GEN-LAST:event_txtPass2KeyPressed

 
    private boolean isValidInputs(){
        if (txtName.getText().length() < 1)
            lblErrorMessage.setText("Name field cannot left blank");
        else if (txtUser.getText().length() < 1)
            lblErrorMessage.setText("Error with username");
        else if(txtPass1.getText().length() < 4)
            lblErrorMessage.setText("Password must be no less than 4 characters");
        else if (!txtOldPass.getText().equals(user.getPassword()))
            lblErrorMessage.setText("Incorrect password");
        else if(!txtPass1.getText().equals(txtPass2.getText()))
            lblErrorMessage.setText("Passwords does not match");
        else{
            
            boolean updated = new UsersTable().updatePassword(user.getUsername(), txtPass1.getText());
            if(updated)
                return true;
            else
                lblErrorMessage.setText("Sorry, something went wrong while saving your changes!");
        }
        return false;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdminSettings;
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
