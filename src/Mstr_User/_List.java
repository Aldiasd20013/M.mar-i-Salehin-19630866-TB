/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mstr_User;

/**
 *
 * @author Glora
 */
import Class.logic_koneksi;
import Class.mstr_user;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import javax.swing.JOptionPane;

public class _List extends javax.swing.JInternalFrame {

    Timer stopwatch;
    int count = 0;
    int delay = 100;
    int countPassed = 1;
    private boolean append;
    private DefaultTableModel awalModelTabel;
    Connection _Cnn;
    String _User;
    
    
    
    /**
     * Creates new form _List
     */
    public _List() {
        initComponents();
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setForeground(Color.red);
        String[] kolomtbl = {"USER ID", "NAMA", "JENIS_KELAMIN", "TEMPAT_LAHIR", "TANGGAL_LAHIR","ALAMAT","PASSWORD"};
        //'user_id', 'nama', 'jenis_kelamin', 'tempat_lahir', 'tanggal_lahir','alamat','password'
        awalModelTabel = new DefaultTableModel(null, kolomtbl) {
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
            };
            
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            public boolean isCellEditable(int row, int col) {
                int kol = awalModelTabel.getColumnCount();
                return (col < kol) ? false : true;
            }
        };
        masterTable.setModel(awalModelTabel);
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bTambah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bRef = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        detikLabel = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        bUbah = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        PencarianLabel = new javax.swing.JLabel();

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bRef.setText("Refresh");
        bRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefActionPerformed(evt);
            }
        });

        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        detikLabel.setText("~");

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
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
        masterScrollPane.setViewportView(masterTable);

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcariKeyTyped(evt);
            }
        });

        PencarianLabel.setText("Pencarian");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bUbah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bKeluar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bRef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PencarianLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcari)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detikLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(masterScrollPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PencarianLabel)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bKeluar)
                        .addGap(96, 96, 96))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detikLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        tambahRecord();
    }//GEN-LAST:event_bTambahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        hapusRecord();
    }//GEN-LAST:event_bHapusActionPerformed

    private void bRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefActionPerformed
        RefreshOrCariRecor();
    }//GEN-LAST:event_bRefActionPerformed

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bKeluarActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        ubahRecord();
    }//GEN-LAST:event_bUbahActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        RefreshOrCariRecor();
    }//GEN-LAST:event_txtcariKeyReleased

    private void txtcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyTyped
        RefreshOrCariRecor();
    }//GEN-LAST:event_txtcariKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PencarianLabel;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bKeluar;
    private javax.swing.JButton bRef;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private javax.swing.JLabel detikLabel;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables

public void hapusRowData() {
    int row = awalModelTabel.getColumnCount();
    while (awalModelTabel.getRowCount() > 0) {
        awalModelTabel.setRowCount(0);//removeRow(0);
    }
}

private void loadData() {
    String _sql = "";
    logic_koneksi vcon = new logic_koneksi();
    vcon.makeConnect();
    hapusRowData();
    try{
        _Cnn = vcon.vkoneksi;
        if (txtcari.getText().equals("")) {
            _sql = ""
                    + "SELECT * FROM `mstr_user`";
        } else {
            _sql = ""
                    + "SELECT * FROM `mstr_user` WHERE"
                    + " `user_id` LIKE '%" + txtcari.getText() + "%' OR"
                    + " `nama` LIKE '%" + txtcari.getText() + "%' OR"
                    + " `jenis_kelamin` LIKE '%" + txtcari.getText() + "%' OR"
                    + " `tempat_lahir` LIKE '%" + txtcari.getText() + "%' OR"
                    + " `tanggal_lahir` LIKE '%" + txtcari.getText() + "%' OR"
                    + " `alamat` LIKE '%" + txtcari.getText() + "%' OR"
                    + " `password` LIKE '%" + txtcari.getText() + "%'";
        }
        System.out.println(_sql);
        Statement st = _Cnn.createStatement();
        ResultSet rst = st.executeQuery(_sql);
        while (rst.next()) {
            String rst_user_id = rst.getString(1);
            String rst_nama = rst.getString(2);
            String rst_jenis_kelamin = rst.getString(3);
            String rst_tempat_lahir = rst.getString(4);
            String rst_tanggal_lahir = rst.getString(5);
            String rst_alamat = rst.getString(6);
            String rst_password = rst.getString(7);
            Object[] data = {rst_user_id, rst_nama, rst_jenis_kelamin, rst_tempat_lahir, rst_tanggal_lahir, rst_alamat, rst_password};
            awalModelTabel.addRow(data);
            
        }
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }

public void refresh() {
        try{
            ActionListener acl = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (count == 0) {
                        stopwatch.stop();
                        detikLabel.setText("");
                    }else{
                        detikLabel.setText("Telah selesai " + count + " %");
                        count--;
                        count = jProgressBar1.getValue() + 25;
                        if (count > jProgressBar1.getMaximum()) {
                            count = jProgressBar1.getMinimum();
                        }
                        jProgressBar1.setValue(count);
                        loadData();
                    }
                }
            };
            stopwatch = new Timer(delay, acl);
            stopwatch.setInitialDelay(0);
            stopwatch.start();
            count = countPassed;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }
    //methode yang diperlukan untuk event ActionPerformed button dan field
    void keluar() {
        this.dispose();
    }
    
    void tambahRecord() {
        try {
            _Entry f = new _Entry("","","Add");
            Dimension parentSize = this.getSize();
            f.setLocation((parentSize.width) / 2, (parentSize.height) / 2);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.b_Keluar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    refresh();
                }
            });
            f.b_Simpan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    refresh();
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    void hapusRecord() {
        String kode = masterTable.getValueAt(masterTable.getSelectedRow(), 0).toString();
        int pilih = JOptionPane.showConfirmDialog(this, "Hapus data user : " + kode, "KONFIRMASI", JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION) {
            mstr_user D = new mstr_user();
            D.hapusdata(kode);
            refresh();
        }
    }
     
    void ubahRecord() {
        try {
            String kode = masterTable.getValueAt(masterTable.getSelectedRow(), 0).toString();
            _Entry f = new _Entry("", kode, "Edit");
            Dimension parentSize = this.getSize();
            f.setLocation((parentSize.width) / 2, (parentSize.height) / 2);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.b_Keluar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    refresh();
                }
            });
            f.b_Simpan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    refresh();
                }
            });
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
    }
    
    void RefreshOrCariRecor() {
        try {
            refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
}