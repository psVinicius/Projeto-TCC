/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class Validador {
 
    
    String  quebrado[];
    
    public Validador(String data) {
    this.quebrado = data.split("/");
    }
    
    public int retornaDia(){
        return Integer.valueOf(quebrado[0]);
    }
    
    public int retornaMes(){
        return Integer.valueOf(quebrado[1]);
    }
    
    public int retornaAno(){
        return Integer.valueOf(quebrado[2]);
    }
    
    
    
}
