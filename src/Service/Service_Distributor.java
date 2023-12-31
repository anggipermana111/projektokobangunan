/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Model_Distributor;
import java.util.List;

public interface Service_Distributor {
    void tambahData     (Model_Distributor modis);
    void perbaruiData   (Model_Distributor modis);
    void hapusData      (Model_Distributor modis);
    
    Model_Distributor getByid (String id);
    
    List<Model_Distributor> getData();
    List<Model_Distributor> pencarian(String id);
    
    String nomor();
}
