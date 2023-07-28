/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_Pengguna;
import java.util.List;

public interface Service_Pengguna {
    void tambahData     (Model_Pengguna moduser);
    void perbaruiData   (Model_Pengguna moduser);
    void hapusData      (Model_Pengguna moduser);
    
    Model_Pengguna getByid (String id);
    
    List<Model_Pengguna> getData();
    List<Model_Pengguna> pencarian(String id);
    
    String nomor();
}
