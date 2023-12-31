/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.AdminView;

import Controllers.Controller;
import Models.User;
import Views.UserLoginView;

/**
 *
 * @author Quan's PC
 */
public class AdminMenuView extends javax.swing.JFrame {
    private User user;
    /**
     * Creates new form AdminMenuView
     */
    public AdminMenuView() {
        initComponents();
        setTitle("Admin Menu");
        this.user = Controller.getUser();
        idLabelShow.setText(user.getUserId()+"");
        fullnameLabelShow.setText(user.getName());
        usernameLabelShow.setText(user.getUsername());
        phoneLabelShow.setText(user.getPhone());
        emailLabelShow.setText(user.getEmail());
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
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel2 = new javax.swing.JPanel();
        IdLabelTitle = new javax.swing.JLabel();
        idLabelShow = new javax.swing.JLabel();
        usernameLabelShow = new javax.swing.JLabel();
        usernameLabelTitle = new javax.swing.JLabel();
        fullnameLabelShow = new javax.swing.JLabel();
        fullnameLabelTitle = new javax.swing.JLabel();
        phoneLabelShow = new javax.swing.JLabel();
        phoneLabelTitle = new javax.swing.JLabel();
        emailLabelTitle = new javax.swing.JLabel();
        emailLabelShow = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        editAdminBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        manipulateCourseBtn = new javax.swing.JButton();
        viewCourseListBtn = new javax.swing.JButton();
        registerStudentBtn = new javax.swing.JButton();
        registerFacultyBtn = new javax.swing.JButton();
        studentsRegisterCourseBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN MENU");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);
        jPanel1.add(filler1, java.awt.BorderLayout.PAGE_START);

        IdLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        IdLabelTitle.setText("AdminID:");

        idLabelShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        idLabelShow.setText("jLabel3");

        usernameLabelShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usernameLabelShow.setText("jLabel3");

        usernameLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usernameLabelTitle.setText("Username:");

        fullnameLabelShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullnameLabelShow.setText("jLabel3");

        fullnameLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fullnameLabelTitle.setText("Fullname:");

        phoneLabelShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phoneLabelShow.setText("jLabel3");

        phoneLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneLabelTitle.setText("Phone:");

        emailLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailLabelTitle.setText("Email:");

        emailLabelShow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        emailLabelShow.setText("jLabel3");

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutBtn.setText("LogOut");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        editAdminBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editAdminBtn.setText("Edit Information");
        editAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAdminBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(logoutBtn)
                .addGap(91, 91, 91)
                .addComponent(editAdminBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(editAdminBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdLabelTitle)
                    .addComponent(usernameLabelTitle)
                    .addComponent(fullnameLabelTitle)
                    .addComponent(phoneLabelTitle)
                    .addComponent(emailLabelTitle))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabelShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabelShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullnameLabelShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneLabelShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailLabelShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLabelTitle)
                    .addComponent(idLabelShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabelTitle)
                    .addComponent(usernameLabelShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullnameLabelTitle)
                    .addComponent(fullnameLabelShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabelTitle)
                    .addComponent(phoneLabelShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabelTitle)
                    .addComponent(emailLabelShow))
                .addGap(197, 197, 197)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );

        manipulateCourseBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manipulateCourseBtn.setText("Manipulate Course Information");
        manipulateCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manipulateCourseBtnActionPerformed(evt);
            }
        });

        viewCourseListBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        viewCourseListBtn.setText("View List Of Courses");
        viewCourseListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCourseListBtnActionPerformed(evt);
            }
        });

        registerStudentBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registerStudentBtn.setText("Register Student");
        registerStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerStudentBtnActionPerformed(evt);
            }
        });

        registerFacultyBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registerFacultyBtn.setText("Register Faculty");
        registerFacultyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFacultyBtnActionPerformed(evt);
            }
        });

        studentsRegisterCourseBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentsRegisterCourseBtn.setText("View Students Register Course");
        studentsRegisterCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsRegisterCourseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(manipulateCourseBtn)
                    .addComponent(registerStudentBtn)
                    .addComponent(registerFacultyBtn)
                    .addComponent(viewCourseListBtn)
                    .addComponent(studentsRegisterCourseBtn))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(registerStudentBtn)
                .addGap(50, 50, 50)
                .addComponent(registerFacultyBtn)
                .addGap(50, 50, 50)
                .addComponent(viewCourseListBtn)
                .addGap(50, 50, 50)
                .addComponent(studentsRegisterCourseBtn)
                .addGap(51, 51, 51)
                .addComponent(manipulateCourseBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        this.dispose();
        new UserLoginView().setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void editAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAdminBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminEditInformationView().setVisible(true);
    }//GEN-LAST:event_editAdminBtnActionPerformed

    private void manipulateCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manipulateCourseBtnActionPerformed
        // TODO add your handling code here:
         this.dispose();
        new AdminManipulateCourseView().setVisible(true);
    }//GEN-LAST:event_manipulateCourseBtnActionPerformed

    private void viewCourseListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCourseListBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminViewCourseView().setVisible(true);
    }//GEN-LAST:event_viewCourseListBtnActionPerformed

    private void registerStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerStudentBtnActionPerformed
        // TODO add your handling code here:
         this.dispose();
        new AdminRegisterStudentView().setVisible(true);
    }//GEN-LAST:event_registerStudentBtnActionPerformed

    private void registerFacultyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFacultyBtnActionPerformed
        // TODO add your handling code here:
         this.dispose();
        new AdminRegisterFacultyView().setVisible(true);
    }//GEN-LAST:event_registerFacultyBtnActionPerformed

    private void studentsRegisterCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsRegisterCourseBtnActionPerformed
        // TODO add your handling code here:
         this.dispose();
        new ViewStudentsRegisterCourseView().setVisible(true);
    }//GEN-LAST:event_studentsRegisterCourseBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdLabelTitle;
    private javax.swing.JButton editAdminBtn;
    private javax.swing.JLabel emailLabelShow;
    private javax.swing.JLabel emailLabelTitle;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel fullnameLabelShow;
    private javax.swing.JLabel fullnameLabelTitle;
    private javax.swing.JLabel idLabelShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manipulateCourseBtn;
    private javax.swing.JLabel phoneLabelShow;
    private javax.swing.JLabel phoneLabelTitle;
    private javax.swing.JButton registerFacultyBtn;
    private javax.swing.JButton registerStudentBtn;
    private javax.swing.JButton studentsRegisterCourseBtn;
    private javax.swing.JLabel usernameLabelShow;
    private javax.swing.JLabel usernameLabelTitle;
    private javax.swing.JButton viewCourseListBtn;
    // End of variables declaration//GEN-END:variables
}
