/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Koneksi.Koneksi;
import Model.*;
import Service.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import Design.*;

public class DAO_Login implements Service_Login{

    private Connection conn;
    
    public DAO_Login(){
        conn = Koneksi.getConnection();
    }
            
    @Override
    public boolean prosesLogin(Model_Login log) {
        boolean hasil = false;
        PreparedStatement st = null;
        ResultSet rs    = null;
        String Id       = null;
        String Nama     = null;
        String Pangkat   = null;
        
        String sql = "SELECT * FROM pengguna WHERE (id_pengguna='"+log.getId_user()+"' OR username='"+log.getUsername()+"') AND password ='"+Encrypt.getmd5Java(log.getPass_user())+"'";
        try{            
            st = conn.prepareStatement(sql);
            rs= st.executeQuery();
            if(rs.next()){
                Id   = rs.getString("id_pengguna");
                Nama = rs.getString("nama_pengguna");
                Pangkat = rs.getString("level");
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                MenuUtama menu   = new MenuUtama(Id, Nama, Pangkat);
                menu.setVisible(true);
                menu.revalidate();
//                lg.tutup = true;
            hasil = true;
                
            }else{
                JOptionPane.showMessageDialog(null, "Login Gagal!");
                hasil = false;
//                JOptionPane.showMessageDialog(null, "Username dan Password Salah","Pesan",JOptionPane.INFORMATION_MESSAGE);
//                Login lg = new Login();
//                lg.tutup =false;
            }
        }catch (SQLException ex) {
            Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return hasil;
    }
    
}

