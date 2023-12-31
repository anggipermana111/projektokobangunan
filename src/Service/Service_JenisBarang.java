/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_JenisBarang;
import java.util.List;

public interface Service_JenisBarang {
    void tambahData     (Model_JenisBarang mokat);
    void perbaruiData   (Model_JenisBarang mokat);
    void hapusData      (Model_JenisBarang mokat);
    
    Model_JenisBarang getByid (String id);
    
    List<Model_JenisBarang> getData();
    List<Model_JenisBarang> pencarian(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang(Model_JenisBarang mokat);
}
