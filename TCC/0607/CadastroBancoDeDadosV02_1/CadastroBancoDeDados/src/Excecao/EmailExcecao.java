/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excecao;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class EmailExcecao {

    

    public void validador(String s) throws Excecao {
        if (!s.contains("@gmail.com")) {

        } else {
            if (!s.contains("@hotmail.com")) {
                 throw new Excecao("Email invalido"
                        + "\nInforme se é @gmail.com ou @hotmail.com");

            } 
        }
    }

}
