/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projektokobangunan;

import Design.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Scanner;

public class ProjekTokoBangunan {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            new Login().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ProjekTokoBangunan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//        for(int i=1;i<a*2;i++) {
//            for(int j=1;j<a*2;j++) {
//                if((i+j)%2==0 && i+j>=a+1 && i+(a-1)>=j && j+(a-1)>=i && i+j<=(a*3)-1) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println("a");
//    }
    
}
