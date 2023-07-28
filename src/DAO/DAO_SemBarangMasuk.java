/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Koneksi.Koneksi;
import Model.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import Service.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO_SemBarangMasuk implements Service_SemBarangMasuk{

    private Connection connection;
    
    public DAO_SemBarangMasuk(){
        connection = Koneksi.getConnection();
    }
    
    @Override
    public void tambahData(Model_SemBarangMasuk modsem) {
        PreparedStatement st = null;
//        String sql = "INSERT INTO sementara_barang_masuk (kode_barang, nama_barang, satuan, harga, jml_masuk, subtotal_masuk) VALUES (?,?,?,?,?,?)";
        try{
            String sql = "INSERT INTO sementara_barang_masuk VALUES ('"+modsem.getMdl_barang().getKode_barang()+"',"
                    + "'"+modsem.getMdl_barang().getNama_barang()+"',"
                    + "'"+modsem.getMdl_barang().getSatuan()+"',"
                    + ""+modsem.getMdl_barang().getHarga()+","
                    + ""+modsem.getMdl_detmasuk().getJml_masuk()+","
                    + ""+modsem.getMdl_detmasuk().getSubtotal_masuk()+")";
            st = connection.prepareStatement(sql);
//            String a = modsem.getMdl_barang().getKode_barang();
//            String b = modsem.getMdl_barang().getNama_barang();
//            String c = modsem.getMdl_barang().getSatuan();
//            System.out.println(a);
//            st.setString(1, a);
//            System.out.println(b);
//            st.setString(2, b);
//            System.out.println(c);
//            st.setString(3, c);
//            System.out.println("d");
//            st.setLong  (4, modsem.getMdl_barang().getHarga());
//            System.out.println("e");
//            st.setInt   (5, modsem.getMdl_detmasuk().getJml_masuk());
//            System.out.println("f");
//            st.setLong  (6, modsem.getMdl_detmasuk().getSubtotal_masuk());
//            System.out.println("g");
            st.executeUpdate();
        }catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    
    @Override
    public Model_SemBarangMasuk getByid(String id) 
    {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sementara_barang_masuk";
        try{
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                Model_SemBarangMasuk smt = new Model_SemBarangMasuk();
                Model_Barang brg = new Model_Barang();
                Model_DetBarangMasuk det_psn = new Model_DetBarangMasuk();
                
                brg.setKode_barang  (rs.getString ("kode_barang"));
                brg.setNama_barang  (rs.getString ("nama_barang"));
                brg.setSatuan  (rs.getString ("satuan"));
                brg.setHarga        (rs.getLong   ("harga"));
                
                det_psn.setJml_masuk(rs.getInt    ("jml_masuk"));
                det_psn.setSubtotal_masuk(rs.getLong   ("subtotal_masuk"));
                
                smt.setMdl_barang(brg);
                smt.setMdl_detmasuk(det_psn);
                
            }return null;
        }catch (SQLException ex) 
            {
                java.util.logging.Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }finally   
        {
            if (st!=null) 
            {
                try 
                {
                    st.close();
                } catch (SQLException ex) 
                    {
                        java.util.logging.Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            if (rs!=null) 
            {
                try 
                {
                    rs.close();
                } catch (SQLException ex) 
                    {
                    java.util.logging.Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }

    @Override
    public List<Model_SemBarangMasuk> getData() {
        
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM sementara_barang_masuk";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_SemBarangMasuk smt = new Model_SemBarangMasuk();
                Model_Barang brg = new Model_Barang();
                Model_DetBarangMasuk det_psn = new Model_DetBarangMasuk();
                
                brg.setKode_barang  (rs.getString ("kode_barang"));
                brg.setNama_barang  (rs.getString ("nama_barang"));
                brg.setSatuan  (rs.getString ("satuan"));
                brg.setHarga        (rs.getLong ("harga"));
                
                det_psn.setJml_masuk(rs.getInt    ("jml_masuk"));
                det_psn.setSubtotal_masuk(rs.getLong   ("subtotal_masuk"));
                
                smt.setMdl_barang(brg);
                smt.setMdl_detmasuk(det_psn);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public void perbaruiData(Model_SemBarangMasuk modsem) {
        PreparedStatement st = null;
        String sql = "UPDATE sementara_barang_masuk SET kode_barang='"+modsem.getMdl_barang().getKode_barang()+"', nama_barang=?, satuan=?, harga=?, jml_masuk=?, subtotal_masuk=? WHERE kode_barang='"+modsem.getMdl_barang().getKode_barang()+"'";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, modsem.getMdl_barang().getNama_barang());
            st.setString(2, modsem.getMdl_barang().getSatuan());
            st.setLong  (3, modsem.getMdl_barang().getHarga());
            st.setInt   (4, modsem.getMdl_detmasuk().getJml_masuk());
            st.setLong  (5, modsem.getMdl_detmasuk().getSubtotal_masuk());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemBarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_SemBarangMasuk modsem) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_barang_masuk WHERE kode_barang=?";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, modsem.getMdl_barang().getKode_barang());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    @Override
    public void hapusIsi() {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_barang_masuk";
        try{
            st = connection.prepareStatement(sql);
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    @Override
    public boolean cekIsi(String id) {
        ResultSet rs;
        boolean cek = false;
        PreparedStatement st = null;
        String sql = "SELECT * FROM sementara_barang_masuk";
        try{
            st = connection.prepareStatement(sql);
            
            rs = st.executeQuery();
            while(rs.next()) {
                if(id.equals(rs.getString("kode_barang"))) {
                    cek = true;
                    break;
                }
            }
        }catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
            }
        }
        return cek;
    }

    
}
