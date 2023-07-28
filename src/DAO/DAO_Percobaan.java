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
import javax.swing.JOptionPane;

public class DAO_Percobaan implements Service_Percobaan{

    private Connection connection;
    
    public DAO_Percobaan(){
        connection = Koneksi.getConnection();
    }
    
    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        String sql = "SELECT RIGHT (no_pesan,3)+1 AS Nomor FROM pemesanan ORDER BY Nomor desc";
        try{
            st = connection.prepareStatement(sql);
            rs= st.executeQuery();
            if(rs.next()){
                urutan=rs.getString(1);
                while (urutan.length()<3)
                   urutan="0"+urutan;
                   urutan =urutan;
                }else{
                    urutan ="001";
                }
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Percobaan.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (st!=null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_Percobaan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        return urutan;
    }

    
    
}
