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

public class DAO_SemBarangKeluar implements Service_SemBarangKeluar{

    private Connection connection;
    
    public DAO_SemBarangKeluar(){
        connection = Koneksi.getConnection();
    }
    
    @Override
    public void tambahData(Model_SemBarangKeluar modsem) {
        PreparedStatement st = null;
//        String sql = "INSERT INTO sementara_keluar (kode_barang, nama_barang, harga, jml_keluar, subtotal_keluar) VALUES (?,?,?,?,?)";
        try{
            String sql = "INSERT INTO sementara_keluar VALUES ('"+modsem.getMdl_barang().getKode_barang()+"',"
                    + "'"+modsem.getMdl_barang().getNama_barang()+"',"
                    + "'"+modsem.getMdl_barang().getSatuan()+"',"
                    + ""+modsem.getMdl_barang().getHarga()+","
                    + ""+modsem.getMdl_detkeluar().getJml_keluar()+","
                    + ""+modsem.getMdl_detkeluar().getSubtotal_keluar()+")";
            st = connection.prepareStatement(sql);
            st = connection.prepareStatement(sql);
            
//            st.setString(1, modsem.getMdl_barang().getKode_barang());
//            st.setString(2, modsem.getMdl_barang().getNama_barang());
//            st.setLong  (3, modsem.getMdl_barang().getHarga());
//            st.setLong  (4, modsem.getMdl_detkeluar().getJml_keluar());
//            st.setLong  (5, modsem.getMdl_detkeluar().getSubtotal_keluar());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    
    @Override
    public Model_SemBarangKeluar getByid(String id) 
    {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sementara_keluar";
        try{
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()) {
                Model_SemBarangKeluar smt = new Model_SemBarangKeluar();
                Model_Barang brg = new Model_Barang();
                Model_DetBarangKeluar det_psn = new Model_DetBarangKeluar();
                
                brg.setKode_barang  (rs.getString ("kode_barang"));
                brg.setNama_barang  (rs.getString ("nama_barang"));
                brg.setHarga        (rs.getLong   ("harga"));
                
                det_psn.setJml_keluar(rs.getInt    ("jml_keluar"));
                det_psn.setSubtotal_keluar(rs.getLong   ("subtotal_keluar"));
                
                smt.setMdl_barang(brg);
                smt.setMdl_detkeluar(det_psn);
                
            }return null;
        }catch (SQLException ex) 
            {
                java.util.logging.Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
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
                        java.util.logging.Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            if (rs!=null) 
            {
                try 
                {
                    rs.close();
                } catch (SQLException ex) 
                    {
                    java.util.logging.Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
    }

    @Override
    public List<Model_SemBarangKeluar> getData() {
        
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM sementara_keluar";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_SemBarangKeluar smt = new Model_SemBarangKeluar();
                Model_Barang brg = new Model_Barang();
                Model_DetBarangKeluar det_psn = new Model_DetBarangKeluar();
                
                brg.setKode_barang  (rs.getString ("kode_barang"));
                brg.setNama_barang  (rs.getString ("nama_barang"));
                brg.setSatuan  (rs.getString ("satuan"));
                brg.setHarga        (rs.getLong ("harga"));
                
                det_psn.setJml_keluar(rs.getInt("jml_keluar"));
                det_psn.setSubtotal_keluar(rs.getLong   ("subtotal_keluar"));
                
                smt.setMdl_barang(brg);
                smt.setMdl_detkeluar(det_psn);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public void perbaruiData(Model_SemBarangKeluar modsem) {
        PreparedStatement st = null;
        String sql = "UPDATE sementara_keluar SET nama_barang=?, harga=?, jml_keluar=?, subtotal_keluar=? WHERE kode_barang='"+modsem.getMdl_barang().getKode_barang()+"'";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, modsem.getMdl_barang().getNama_barang());
            st.setLong  (2, modsem.getMdl_barang().getHarga());
            st.setLong  (3, modsem.getMdl_detkeluar().getJml_keluar());
            st.setLong  (4, modsem.getMdl_detkeluar().getSubtotal_keluar());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemBarangKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_SemBarangKeluar modsem) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_keluar WHERE kode_barang=?";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, modsem.getMdl_barang().getKode_barang());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("eror");
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
        String sql = "DELETE FROM sementara_keluar";
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

    
}
