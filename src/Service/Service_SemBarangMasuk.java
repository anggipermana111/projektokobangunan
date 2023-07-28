/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_SemBarangMasuk;
import java.util.List;

public interface Service_SemBarangMasuk {
    void tambahData     (Model_SemBarangMasuk modsem);
    void perbaruiData   (Model_SemBarangMasuk modsem);
    void hapusData      (Model_SemBarangMasuk modsem);
    void hapusIsi       ();
    boolean cekIsi      (String id);
    Model_SemBarangMasuk getByid (String id);
    List<Model_SemBarangMasuk> getData();
    
}
