
import javafx.scene.paint.Color;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salehalmakki
 */
public class Dialog_UserUpdate extends javax.swing.JDialog {

    /**
     * Creates new form Dialog_UserUpdate
     */
    User user;
    Dialog_AdminSettings adminSettings;
    
    public Dialog_UserUpdate(User user, Dialog_AdminSettings dialog) {
        super(new java.awt.Frame(), true);
        initComponents();
        new Tool().CenterForm(this);
        this.adminSettings = dialog;
        this.user = user;
        txtUsername.setText(user.getUsername());
        txtUsername.setEditable(false);
        txtName.setText(user.getName());
        lblConfirmationMessage.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        btnUpdateName = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdatePassword = new javax.swing.JButton();
        lblConfirmationMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtNameInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        btnUpdateName.setText("Update Name");
        btnUpdateName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateNameMouseClicked(evt);
            }
        });
        btnUpdateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Username");

        txtUsername.setEnabled(false);

        jLabel3.setText("Password");

        txtPassword.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtPasswordInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        jLabel1.setText("Name");

        btnUpdatePassword.setText("Update Password");
        btnUpdatePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdatePasswordMouseClicked(evt);
            }
        });
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });

        lblConfirmationMessage.setForeground(new java.awt.Color(0, 150, 0));
        lblConfirmationMessage.setText("Confirmation Message Here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfirmationMessage)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdatePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblConfirmationMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePassword))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateNameMouseClicked

    }//GEN-LAST:event_btnUpdateNameMouseClicked

    private void btnUpdateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNameActionPerformed
        updateName();
    }//GEN-LAST:event_btnUpdateNameActionPerformed
    
    private void updateName(){
        if(txtName.getText().length() == 0){
            lblConfirmationMessage.setForeground(java.awt.Color.red);
            lblConfirmationMessage.setText("Name Field can not left blank");
            return;
        }
        
        
        btnUpdateName.setText("Please Wait...");
        
        boolean updated = new UsersTable().updateName(txtUsername.getText(), txtName.getText());
        if (updated){
            lblConfirmationMessage.setForeground(new java.awt.Color(0, 150, 0));
            lblConfirmationMessage.setText("Name has been updated successfully");
            this.adminSettings.setNeedUpdate();
        }
        else{
            lblConfirmationMessage.setForeground(java.awt.Color.red);
            lblConfirmationMessage.setText("Sorry, something went wrong, please try again later");
        }
    }
    private void btnUpdatePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdatePasswordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdatePasswordMouseClicked

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        updatePassword();
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void updatePassword(){
        if(txtPassword.getText().length() < 3){
            lblConfirmationMessage.setForeground(java.awt.Color.red);
            lblConfirmationMessage.setText("Password must be no less than 4 characters");
            return;
        }
        
        btnUpdatePassword.setText("Please Wait...");

        boolean updated = new UsersTable().updatePassword(txtUsername.getText(), txtPassword.getText());
        if (updated){
            lblConfirmationMessage.setForeground(new java.awt.Color(0, 150, 0));
            lblConfirmationMessage.setText("User's password has been updated successfully");
            txtPassword.setText("");
        }
        else{
            lblConfirmationMessage.setForeground(java.awt.Color.red);
            lblConfirmationMessage.setText("Sorry, something went wrong, please try again later");
        }
    }
    
    private void txtNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtNameInputMethodTextChanged
        if(txtName.getText().length() > 0)
            btnUpdateName.setEnabled(true);
        else
            btnUpdateName.setEnabled(false);
    }//GEN-LAST:event_txtNameInputMethodTextChanged

    private void txtPasswordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPasswordInputMethodTextChanged
        if(txtPassword.getText().length() > 0)
            btnUpdatePassword.setEnabled(true);
        else
            btnUpdatePassword.setEnabled(false);
    }//GEN-LAST:event_txtPasswordInputMethodTextChanged

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if(evt.getKeyCode() == 10)
            updateName();
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(evt.getKeyCode() == 10)
            updatePassword();
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Dialog_UserUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_UserUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_UserUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_UserUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_UserUpdate dialog = new Dialog_UserUpdate(null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateName;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblConfirmationMessage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
