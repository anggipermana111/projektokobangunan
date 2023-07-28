/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_BarangMasuk;
import java.util.List;

public interface Service_BarangMasuk {
    void tambahData     (Model_BarangMasuk modmasuk);
    void perbaruiStatus (String kd_barang);
    
    Model_BarangMasuk getByid (String id);
    List<Model_BarangMasuk> getData();
    List<Model_BarangMasuk> pencarian(String id);
    String nomor();
    
}
