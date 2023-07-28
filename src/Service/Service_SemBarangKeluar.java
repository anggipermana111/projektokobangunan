/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_SemBarangKeluar;
import java.util.List;

public interface Service_SemBarangKeluar {
    void tambahData     (Model_SemBarangKeluar modsem);
    void perbaruiData   (Model_SemBarangKeluar modsem);
    void hapusData      (Model_SemBarangKeluar modsem);
    void hapusIsi       ();
//    boolean cekIsi      (String id);
    
    Model_SemBarangKeluar getByid (String id);
    List<Model_SemBarangKeluar> getData();
    
}
