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
public class ClasseThread extends Thread {

    JF_Tela_Principal principal;

    public void enviarEmail() {
        while (true) {
            try {
                Thread.sleep(5000);

                this.principal.procuraItemAut(this.principal.id, this.principal.email);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClasseThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void run() {
        enviarEmail();
    }

    public void setPrincipal(JF_Tela_Principal p) {
        this.principal = p;
    }

}
