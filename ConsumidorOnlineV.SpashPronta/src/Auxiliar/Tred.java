/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import Tela.JF_Tela_Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Alves
 */
public class Tred extends Thread{

    JF_Tela_Principal principal;

    @Override
    public void run() {
        while (true) {
            try {
                
                
                Thread.sleep(60000);
           
                principal.procuraItemAut(principal.id, principal.email);

                
            } catch (InterruptedException ex) {
                Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void principal(JF_Tela_Principal p) {
        this.principal = p;
    }

}
