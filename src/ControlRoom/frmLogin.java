/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlRoom;

import Class.logic_koneksi; //nama paketnya a Class. file l_k
import java.awt.Dimension; //untuk mengatur tampilan view app.
import java.awt.event.ActionEvent; // menangkap event tombol
import java.awt.event.ActionListener; // menangkap event tombol
import java.sql.Connection; // menggunakan komponen c dari sql
import java.sql.ResultSet; // menggunakan komponen rs dari sql
import java.sql.SQLException;
import java.sql.Statement; // menggunakan komponen st dari sql
// bentuk lain dari baris 13-15 import java.sql.*;
import javax.swing.JOptionPane; // membuat tampilanwindow notif
import javax.swing.Timer; // untuk loop loading progressbar
import static sun.font.FontManagerNativeLibrary.load;

/**
 *
 * @author Glora
 */
public class frmLogin extends javax.swing.JFrame {
    
    private boolean append;
    public String _user, id;
    Timer stopwatch;
    int count = 0;
    int delay = 100;
    int countpassed = 1;
    

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        logic_koneksi setting = new logic_koneksi ();
        setting.makeConnect();
        Dimension parentSize = this.getSize();
        Dimension childSize = this.getSize();
        setLocationRelativeTo (null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        txt_id = new javax.swing.JTextField();
        txt_user = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bMasuk = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Login Form");

        jLabel2.setText("ID");

        jLabel3.setText("Password");

        bMasuk.setText("Masuk");
        bMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasukActionPerformed(evt);
            }
        });

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        jLabel4.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_user)
                            .addComponent(txt_id)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bKeluar))
                            .addComponent(txt_nama)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMasuk)
                    .addComponent(bKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bKeluarActionPerformed

    private void bMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasukActionPerformed
        load();
    }//GEN-LAST:event_bMasukActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JPasswordField txt_user;
    // End of variables declaration//GEN-END:variables

    private void log() {
        try {
            Connection _Cnn = logic_koneksi.getConnection();
            String SQL = "Select *"
                    + "From `mstr_user`"
                    + "WHERE `user_id` = '"+txt_id.getText()+"'"
                    + "AND `password` = '" + txt_user.getText()+"'";
            Statement st = _Cnn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            while (rs.next()) {
                append = false;
                this.setVisible(append);
                new frmMenuUtama().setVisible(true);
                System.out.println(SQL);
                _Cnn = logic_koneksi.getConnection();
                
            }
            st.close();
            System.out.println("_" + st.toString());
            
        } catch (Exception err) {
            System.out.println("_ERROR" + err.toString());
            JOptionPane.showMessageDialog(null, "ERROR" + err);
        }
    }
    private void load() {
        try {
            ActionListener acl = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (count == 0) {
                        stopwatch.stop();
                        jLabel1.setText("Login Form");
                    } else {
                        jLabel1.setText(count + " %");
                        count--;
                        count = jProgressBar1.getValue() + 20;
                        if (count > jProgressBar1.getMaximum()) {
                            log();
                            count = jProgressBar1.getMinimum();
                            
                        }
                        jProgressBar1.setValue(count);
                    }
                }
            };
            stopwatch = new Timer(delay, acl);
            stopwatch.setInitialDelay(0);
            stopwatch.start();
            count = countpassed;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }
    

}