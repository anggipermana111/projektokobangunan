/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_BarangKeluar;
import java.util.List;

public interface Service_BarangKeluar {
    void tambahData     (Model_BarangKeluar modkeluar);
    
    Model_BarangKeluar getByid (String id);
    List<Model_BarangKeluar> getData();
    List<Model_BarangKeluar> pencarian(String id);
    String nomor();
    
    
}
