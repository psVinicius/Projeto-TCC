/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeemail;

import org.javahelp4u.mailSender.MailSender;

/**
 *
 * @author Vinicius Alves
 */
public class TesteEmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("enviando email....");
        MailSender.sendMail("psviniciusalves@gmail.com", "teste de envio de email", "eba");
        System.out.println("email enviando");
        
    }
    
}
