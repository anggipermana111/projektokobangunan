/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
//import menu.MenuItem;

public class MenuUtama extends javax.swing.JFrame {

    public MenuUtama(String Id, String Nama, String Pangkat) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lb_id.setText(Id);
        lb_nama.setText(Nama);
        lb_pangkat.setText(Pangkat);

        execute(Pangkat);
    }

    ImageIcon setIcon(String link) {
        return new ImageIcon(Objects.requireNonNull(
                this.getClass().getResource(link)));
    }

    private void execute(String Level2) {
        //  icon Master
        ImageIcon iconMaster = new ImageIcon(getClass().getResource("/bahan/master.png"));
        ImageIcon iconSubMenuBrg = new ImageIcon(getClass().getResource("/bahan/barang.png"));
        ImageIcon iconSubMenuJnsBrg = new ImageIcon(getClass().getResource("/bahan/jenis.png"));
        ImageIcon iconSubMenuDst = new ImageIcon(getClass().getResource("/bahan/distributor.png"));
        ImageIcon iconSubMenuPgn = new ImageIcon(getClass().getResource("/bahan/pengguna.png"));

        //  icon Transaksi
        ImageIcon iconTransaksi = new ImageIcon(getClass().getResource("/bahan/transaksi.png"));
        ImageIcon iconSubMenuPesan = new ImageIcon(getClass().getResource("/bahan/pesan.png"));
        ImageIcon iconSubMenuMasuk = new ImageIcon(getClass().getResource("/bahan/masuk.png"));
        ImageIcon iconSubMenuKeluar = new ImageIcon(getClass().getResource("/bahan/keluar.png"));
        ImageIcon iconOwner = new ImageIcon(getClass().getResource("/bahan/businessman.png"));
        ImageIcon iconStaff = new ImageIcon(getClass().getResource("/bahan/staff1.png"));
//        ImageIcon iconStaff         = new ImageIcon(getClass().getResource("/menu/user.png"));
//        ImageIcon iconSetting       = new ImageIcon(getClass().getResource("/menu/setting.png"));
//        ImageIcon iconDatabase      = new ImageIcon(getClass().getResource("/menu/database.png"));
//        ImageIcon iconMessage       = new ImageIcon(getClass().getResource("/menu/message.png"));
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/bahan/home.png"));
        ImageIcon iconLogout = new ImageIcon(getClass().getResource("/bahan/logout.png"));

//        ImageIcon iconNext          = new ImageIcon(getClass().getResource("/menu/next.png"));
        //Menu utama
        MenuItem menuHome = new MenuItem(iconHome, false, null, "Home", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.removeAll();
//                String Ide = lb_id.getText();
//                String Nm = lb_nama.getText();
                jPanel2.add(new ViewHome());
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //  Master Barang
        MenuItem masBarang = new MenuItem(null, true, iconSubMenuBrg, "Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jPanel2.removeAll();
                String Id = lb_id.getText();
                jPanel2.add(new Master_Barang());
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //  Master Jenis Barang
        MenuItem masJenis = new MenuItem(null, true, iconSubMenuJnsBrg, "Jenis Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jPanel2.removeAll();
                String Id = lb_id.getText();
                jPanel2.add(new Master_JenisBarang());
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //  Master Distributor
        MenuItem masDistributor = new MenuItem(null, true, iconSubMenuDst, "Distributor", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.removeAll();
                String Id = lb_id.getText();
                jPanel2.add(new Master_Distributor());
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //  Master Pengguna
        MenuItem masPengguna = new MenuItem(null, true, iconSubMenuPgn, "Pengguna", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.removeAll();
                String Id = lb_id.getText();
                jPanel2.add(new Master_Pengguna());
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //  Transaksi Barang Masuk 
        MenuItem transBarangMasuk = new MenuItem(null, true, iconSubMenuMasuk, "Barang Masuk", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.removeAll();
                String Id = lb_id.getText();
                jPanel2.add(new Form_BarangMasuk(Id));
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //  Transaksi Barang Keluar
        MenuItem transBarangKeluar = new MenuItem(null, true, iconSubMenuKeluar, "Barang Keluar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel2.removeAll();
                String Id = lb_id.getText();
                jPanel2.add(new Form_BarangKeluar(Id));
                jPanel2.repaint();
                jPanel2.revalidate();
            }
        });

        //Logout
        MenuItem menuLogin = new MenuItem(iconLogout, false, null, "Logout", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null, "Yakin Logout?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    new Login().show();
                dispose();
                }
                
            }
        });
        MenuItem menuTransaksi = new MenuItem(iconTransaksi, false, null, "Transaksi", null, transBarangMasuk, transBarangKeluar);
        MenuItem menuMaster = new MenuItem(iconMaster, false, null, "Master", null, masBarang, masJenis, masDistributor, masPengguna);
//        MenuItem menuTransaksi   = new MenuItem(iconTransaksi, false, null, "Transaksi", null, transPemesanan, transBarangMasuk, transBarangKeluar);
//        MenuItem menuLaporan     = new MenuItem(iconDatabase, false, null, "Laporan", null, lapStokBarang, lapPemesananBarang, lapBarangMasuk, lapBarangKeluar);

        if (Level2.equals("Owner")) {
//            addMenu(menuHome, menuMaster, menuTransaksi, menuLaporan, menuLogin);
//            this.lb_iconAdmin.setVisible(true);
            addMenu(menuHome, menuMaster, menuTransaksi, menuLogin);
            jLabel2.setIcon(iconOwner);
        } else {
//            addMenu(menuHome, menuTransaksi, menuLaporan, menuLogin);
//            this.lb_iconStaff.setVisible(true);
//            this.lb_iconAdmin.setVisible(false);
            addMenu(menuHome, menuTransaksi, menuLogin);
            jLabel2.setIcon(iconStaff);
        }
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
        jLabel5 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        lb_pangkat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/MonicaIcon.png"))); // NOI18N

        lb_id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_id.setForeground(new java.awt.Color(255, 255, 255));
        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(925, 925, 925)
                .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(665, 665, 665))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/staff1.png"))); // NOI18N

        lb_nama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_nama.setForeground(new java.awt.Color(0, 0, 102));
        lb_nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nama.setText("Nama Admin");

        lb_pangkat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lb_pangkat.setForeground(new java.awt.Color(0, 0, 102));
        lb_pangkat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pangkat.setText("Jabatan");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setLayout(new javax.swing.BoxLayout(menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
            .addComponent(lb_pangkat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_nama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_pangkat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jPanel2.add(new ViewHome());
        jPanel2.repaint();
        jPanel2.revalidate();
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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama("ID", "Nama", "Level").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_pangkat;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
    private void addMenu(MenuItem... menu1) {
        for (int i = 0; i < menu1.length; i++) {
            menu.add(menu1[i]);
            ArrayList<MenuItem> subMenu = menu1[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menu.revalidate();
    }

}
