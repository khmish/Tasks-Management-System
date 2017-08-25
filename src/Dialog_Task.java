
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author salehalmakki
 */
public class Dialog_Task extends javax.swing.JDialog {

    Task task;
    User user;
    Form_Tasks tasks_form;
    int state; //1: New Task, 2: Sent-Task, 3: Received-task, 4: Request-To-Close-Task
    
    public Dialog_Task(User u, Task t, Form_Tasks tf, int s){
        super(new java.awt.Frame(), true);
        initComponents();
        
        new Tool().CenterForm(this);
        lblError.setVisible(false);
        
        task = t;
        user = u;
        tasks_form = tf;
        state = s;
        
        
        //if opend as new task
        if (state == 1){
            task.setUnitCode(user.getUnitCode());
        
            //setup form
            lblTitle.setText("New Task");
            txtFrom.setText(user.getUsername());
            txtSenderName.setText(user.getName());
            txtFrom.setEditable(false); //luck sender field
            txtSenderName.setEditable(false);
        
            // luck status field to In progress
            radInProgress.setSelected(true); 
            radCompleted.setEnabled(false);
            radClosed.setEnabled(false);
        }
        //if opened from sent tasks
        else if(state == 2){
            btnSend.setEnabled(false);
            txtFrom.setEditable(false);
            txtTo.setEditable(false);
            txtSenderName.setEnabled(false);
            txtReceiverName.setEnabled(false);
            txtSubject.setEditable(false);
            txtDueDate.setEditable(false);
            txtDetails.setEditable(false);
            radCompleted.setEnabled(false);
            
            radInProgress.setEnabled(false);
            radCompleted.setEnabled(false);
            radClosed.setEnabled(false);
            fillForm();
        }
        //if opened from my tasks (received tasks)
        else if(state == 3){
            txtFrom.setEditable(false);
            txtTo.setEditable(false);
            txtSenderName.setEnabled(false);
            txtReceiverName.setEnabled(false);
            txtSubject.setEditable(false);
            txtDueDate.setEditable(false);
            txtDetails.setEditable(false);
            radCompleted.setEnabled(false);
            
            radInProgress.setEnabled(false);
            radCompleted.setEnabled(true);
            radClosed.setEnabled(true);
            fillForm();
        }
        //if opened from "Tasks to close"
        else if(state == 4){
            btnSend.setEnabled(false);
            txtFrom.setEditable(false);
            txtTo.setEditable(false);
            txtSenderName.setEnabled(false);
            txtReceiverName.setEnabled(false);
            txtSubject.setEditable(false);
            txtDueDate.setEditable(false);
            txtDetails.setEditable(false);
            radCompleted.setEnabled(false);
            
            radInProgress.setEnabled(false);
            radCompleted.setEnabled(true);
            radClosed.setEnabled(true);
            fillForm();
        }
        
        
    }
    
    //this method fils the coming task into form (state should be 2,3,4)
    private void fillForm(){
        txtFrom.setText(task.getAssignor());
        txtSenderName.setText(task.getAssignorName());
        txtTo.setText(task.getAssignee());
        txtReceiverName.setText(task.getAssigneeName());
        txtSubject.setText(task.getSubject());
        txtDueDate.setText(task.getDueDate());
        txtDetails.setText(task.getDetails());
        txtSenderName.setText(task.getAssignorName());
        txtReceiverName.setText(task.getAssigneeName());
            
        if (task.getStatus() == 0) radInProgress.setSelected(true);
        else if (task.getStatus() == 1) radCompleted.setSelected(true);
        else if (task.getStatus() == 2) radClosed.setSelected(true);
    }
    
    /*
    //this method to open created task (already exist)
    public Dialog_Task(User u, Task t) {
        super(new java.awt.Frame(), true);
        initComponents();
        new Tool().CenterForm(this);
        lblError.setVisible(false);
        this.task = t;
        this.user = u;
        
        //filling form
        txtFrom.setText(task.getAssignor());
        //txtSenderName.setText(new UsersTable().getName(task.getAssignor()));
        txtTo.setText(task.getAssignee());
        //txtReceiverName.setText(new UsersTable().getName(task.getAssignee()));
        txtSubject.setText(task.getSubject());
        txtDueDate.setText(task.getDueDate());
        txtDetails.setText(task.getDetails());
        if (task.getStatus() == 0) radInProgress.setSelected(true);
        else if (task.getStatus() == 1) radCompleted.setSelected(true);
        else if (task.getStatus() == 2) radClosed.setSelected(true);
        
        
        //if the sender is the user, disable all objects (reading mood)
        if(user.getUsername().equals(txtFrom.getText())){
            btnSend.setEnabled(false);
            txtFrom.setEditable(false);
            txtTo.setEditable(false);
            txtSubject.setEditable(false);
            txtDueDate.setEditable(false);
            txtDetails.setEditable(false);
            radCompleted.setEnabled(false);
            
            radInProgress.setEnabled(false);
            radCompleted.setEnabled(false);
            radClosed.setEnabled(false);
            
        }
        
        //if the receiver is the user, enable status radi buttons
        else if (user.getUsername().equals(txtTo.getText())){
            txtFrom.setEditable(false);
            txtTo.setEditable(false);
            txtDetails.setEditable(false);
            txtSubject.setEditable(false);
            txtDueDate.setEditable(false);
            txtDetails.setEditable(false);
            
            radInProgress.setEnabled(false);
            radCompleted.setEnabled(true);
            radClosed.setEnabled(true);
        }
    }
    
    
    //this constructor to create new task (needs user to set as assignor)
    public Dialog_Task(User u) {
        super(new java.awt.Frame(), true);
        initComponents();
        new Tool().CenterForm(this);
        lblError.setVisible(false);

        this.task = new Task();
        this.user = u;
        this.task.setUnitCode(user.getUnitCode());
        
        //setup new task
        lblTitle.setText("New Task");
        lblTaskID.setText(new TasksTable().getNewID() + "");
        lblTaskID.setVisible(false);
        txtFrom.setText(user.getUsername());
        txtSenderName.setText(user.getName());
        txtFrom.setEditable(false); //luck sender field
        txtSenderName.setEditable(false);
        
        // luck status field to In progress
        radInProgress.setSelected(true); 
        radCompleted.setEnabled(false);
        radClosed.setEnabled(false);
        
    }
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusGroup = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        txtSubject = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radInProgress = new javax.swing.JRadioButton();
        radCompleted = new javax.swing.JRadioButton();
        radClosed = new javax.swing.JRadioButton();
        txtTo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDueDate = new javax.swing.JFormattedTextField();
        txtReceiverName = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        txtSenderName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblTitle.setText("Task Info");
        lblTitle.setAlignmentY(0.0F);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtSubject.setName(""); // NOI18N

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        jScrollPane1.setViewportView(txtDetails);

        jLabel2.setText("Information");

        jLabel3.setText("Due Date");

        jLabel1.setText("Subject");

        jLabel4.setText("Status");

        statusGroup.add(radInProgress);
        radInProgress.setText("In progress");

        statusGroup.add(radCompleted);
        radCompleted.setForeground(new java.awt.Color(0, 156, 0));
        radCompleted.setText("Completed");

        statusGroup.add(radClosed);
        radClosed.setForeground(new java.awt.Color(194, 0, 0));
        radClosed.setText("Close");

        txtTo.setName(""); // NOI18N
        txtTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToActionPerformed(evt);
            }
        });
        txtTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtToKeyPressed(evt);
            }
        });

        jLabel5.setText("To");

        txtFrom.setName(""); // NOI18N

        jLabel6.setText("From");

        txtDueDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtDueDate.setText("01/01/2018");

        txtReceiverName.setEditable(false);
        txtReceiverName.setName(""); // NOI18N

        lblSearch.setForeground(new java.awt.Color(0, 0, 255));
        lblSearch.setText("Users Directory");
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(230, 0, 0));
        lblError.setText("Error Message Displays Here");

        txtSenderName.setEditable(false);
        txtSenderName.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGap(6, 6, 6)
                        .addComponent(radInProgress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radCompleted)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radClosed))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblTitle)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(lblSearch)))
                .addGap(14, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReceiverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radInProgress)
                    .addComponent(radCompleted)
                    .addComponent(radClosed)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!isValidInputs()){
            lblError.setVisible(true);
            return;
        }

        //show informative message
        lblError.setForeground(Color.gray);
        lblError.setText("SENDING TASK ........");
        lblError.setVisible(true);
        
        //if valid, prepair task
        if (state == 1){
            task.setTaskID(new TasksTable().getNewID());
            task.setAssignor(txtFrom.getText());
            task.setAssignee(txtTo.getText());
            task.setCreatedDate(new Tool().getFormattedDate(new Date()));
            task.setSubject(txtSubject.getText());
            task.setDetails(txtDetails.getText());
            task.setDueDate(txtDueDate.getText());
            task.setStatus(getSelectedRadio());
            task.setUnitCode(task.getUnitCode());
            task.setAssignorName(txtSenderName.getText());
            task.setAssigneeName(txtReceiverName.getText());
            
            boolean inserted = new TasksTable().insert(task);
            if (inserted) tasks_form.insertRow(task);
        }
        else if(state == 3){
            task.setStatus(getSelectedRadio());
            new TasksTable().updateStatus(task.getTaskID(), 1);
            tasks_form.requestDeletition();
        }
        
        //exit form
        this.dispose();
    }//GEN-LAST:event_btnSendActionPerformed

    private boolean isValidInputs(){
        //Sender validation
        if (state == 1){
            User user = new UsersTable().getUser(txtTo.getText());
            if (user == null)
                lblError.setText("Username is not valid");
            else if(txtTo.getText().equals(txtFrom.getText()))
                lblError.setText("Receiver's username must be different");
            else if(!user.getName().equals(txtReceiverName.getText()))
                lblError.setText("Receiver's name and username do not match");
            else if(txtSubject.getText().equals(""))
                lblError.setText("Subject field is blank");
            else{
                lblError.setVisible(false);
                return true;
            }
        }
        
        //receiver's validation
        else if (state == 3){
            if (radInProgress.isSelected() && !radCompleted.isSelected() && !radClosed.isSelected())
                lblError.setText("Status must be updated");
            else{
                lblError.setVisible(false);
                return true;
            }
        }
        
        return false;
            
    }
    /*
    public void setAssigneeFields(String username, String name){
        txtTo.setText(username);
        txtName.setText(name);
    }
    
    public String getAssignor(){
        return this.txtFrom.getText();
    }
    */
    
    //this method is to be used in Users Search form 
    public String getUnitID(){
        return this.user.getUnitCode();
    }
    
    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        new Dialog_UsersSearch(this).setVisible(true);
    }//GEN-LAST:event_lblSearchMouseClicked

    private void txtToKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToKeyPressed

        //This occers when user press Enter in txtTo field
        //keyCode 10 is "Enter"
        if(evt.getKeyCode() != 10)
        return;

        //if user hits Enter, txtName is effected
        txtReceiverName.setText("Searching...");
        User user = new UsersTable().getUser(txtTo.getText());
        if (user == null)
        txtReceiverName.setText("NOT FOUND!");
        else
        txtReceiverName.setText(user.getName());
    }//GEN-LAST:event_txtToKeyPressed

    private void txtToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToActionPerformed

    }//GEN-LAST:event_txtToActionPerformed
    
    public int getSelectedRadio()
    {
        if(radInProgress.isSelected()) return 0;
        else if(radCompleted.isSelected()) return 1;
        else if(radClosed.isSelected()) return 2;
        else return -1;
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
            java.util.logging.Logger.getLogger(Dialog_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Dialog_Task dialog = new Dialog_Task(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton radClosed;
    private javax.swing.JRadioButton radCompleted;
    private javax.swing.JRadioButton radInProgress;
    private javax.swing.ButtonGroup statusGroup;
    private javax.swing.JTextArea txtDetails;
    private javax.swing.JFormattedTextField txtDueDate;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtReceiverName;
    private javax.swing.JTextField txtSenderName;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
