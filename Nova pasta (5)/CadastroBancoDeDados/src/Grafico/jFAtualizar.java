package Grafico;

import Conexao.Conexao;
import DAO.ClienteDAO;
import Excecao.EmailExcecao;

import Excecao.Excecao;
import Modelo.ClienteModelo;
import Objeto.Validador;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class jFAtualizar extends javax.swing.JFrame {

    String login;
    public jFAtualizar(String login) {
        initComponents();
        this.login = login;
        informacoes();
      
        
        jLBPlanoFundo.setBounds(0, 0, 520, 470);

        ImageIcon img = new ImageIcon(jFAtualizar.class.getResource("/IMG/img.jpg"));
        Image imagem = img.getImage().getScaledInstance(jLBPlanoFundo.getWidth(), jLBPlanoFundo.getHeight(), Image.SCALE_SMOOTH);

        jLBPlanoFundo.setIcon(new ImageIcon(imagem));

    }
    
     public void informacoes(){
      
        ClienteDAO cd = new ClienteDAO();
        String nome;
        String nomeL;
        
        
        for (ClienteModelo c: cd.ler(login)){
            nome = c.getNome();
            nomeL = nome.toLowerCase();
            jTFNome.setText(nomeL);
            jTFEmail.setText(c.getEmail());
            jTFLogin.setText(c.getLogin());
            jFCPF.setText(c.getCpf());
            jFDataNasc.setText(c.getData_nasc());
            jFRG.setText(c.getRg());
            jPSenha.setText(c.getSenha());
            jPReSenha.setText(c.getSenha());
        }
    }

    public void validaEmail(String email) throws Excecao {
        EmailExcecao ee = new EmailExcecao();
        try {
            ee.validador(email);
        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLBNome = new javax.swing.JLabel();
        jLBEmail = new javax.swing.JLabel();
        jLBDataNasc = new javax.swing.JLabel();
        jLBCPF = new javax.swing.JLabel();
        jLBRG = new javax.swing.JLabel();
        jLBLogin = new javax.swing.JLabel();
        jLBSenha = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFLogin = new javax.swing.JTextField();
        jPReSenha = new javax.swing.JPasswordField();
        jFDataNasc = new javax.swing.JFormattedTextField();
        jLBTitle = new javax.swing.JLabel();
        jFCPF = new javax.swing.JFormattedTextField();
        jFRG = new javax.swing.JFormattedTextField();
        jPSenha = new javax.swing.JPasswordField();
        jLBReSenha = new javax.swing.JLabel();
        jLBPlanoFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLBNome.setText("Nome");
        getContentPane().add(jLBNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLBEmail.setText("Email");
        getContentPane().add(jLBEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLBDataNasc.setText("Data/Nasc");
        getContentPane().add(jLBDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLBCPF.setText("CPF");
        getContentPane().add(jLBCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLBRG.setText("R.G");
        getContentPane().add(jLBRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLBLogin.setText("Login");
        getContentPane().add(jLBLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLBSenha.setText("Senha");
        getContentPane().add(jLBSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jTFNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFNomeKeyTyped(evt);
            }
        });
        getContentPane().add(jTFNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 410, -1));

        jTFEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFEmailKeyTyped(evt);
            }
        });
        getContentPane().add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 410, -1));

        jTFLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFLoginKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFLoginKeyTyped(evt);
            }
        });
        getContentPane().add(jTFLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 410, -1));

        jPReSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPReSenhaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPReSenhaKeyTyped(evt);
            }
        });
        getContentPane().add(jPReSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 410, -1));

        try {
            jFDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFDataNascActionPerformed(evt);
            }
        });
        jFDataNasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFDataNascKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFDataNascKeyTyped(evt);
            }
        });
        getContentPane().add(jFDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 410, -1));

        jLBTitle.setText("Atualizar Conta");
        getContentPane().add(jLBTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        try {
            jFCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFCPFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFCPFKeyTyped(evt);
            }
        });
        getContentPane().add(jFCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 410, -1));

        try {
            jFRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFRGKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFRGKeyTyped(evt);
            }
        });
        getContentPane().add(jFRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 410, -1));

        jPSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPSenhaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPSenhaKeyTyped(evt);
            }
        });
        getContentPane().add(jPSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 410, -1));

        jLBReSenha.setText("Senha");
        getContentPane().add(jLBReSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));
        getContentPane().add(jLBPlanoFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 470));

        jMenuBar1.setOpaque(false);

        jMenu1.setText("Salvar");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cancelar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(515, 527));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

        dispose();

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

       jFPrincipal pri = new jFPrincipal(login);
       pri.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jFDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFDataNascActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        boolean ok = true;
        String senha = "";
        String email = "";
        String emailL = "";
        String nome;
        String nomeU = "";
        String resenha = "";

        try {
            char[] repass = jPReSenha.getPassword();

            for (int i = 0; i < repass.length; i++) {
                resenha += repass[i];
            }

            char[] pass = jPSenha.getPassword();

            for (int i = 0; i < pass.length; i++) {
                senha += pass[i];
            }
            email = jTFEmail.getText();
            emailL = email.toLowerCase();
            ClienteModelo cm = new ClienteModelo();
            ClienteDAO cd = new ClienteDAO();
            if ((jTFNome.getText().equals(""))
                    || (emailL.equals(""))
                    || (jTFLogin.getText().equals(""))
                    || (jFCPF.getText().equals(""))
                    || (jFDataNasc.getText().equals(""))
                    || (jFRG.getText().equals(""))
                    || (senha.equals(""))
                    || (resenha.equals(""))) {

                JOptionPane.showMessageDialog(null, "Campo em branco");
            } else {
                if (!emailL.contains("@gmail.com")) {
                         if (!emailL.contains("@hotmail.com")) {
                            JOptionPane.showMessageDialog(null, "Email invalido"
                                    + "\nInforme se é @gmail.com ou @hotmail.com");
                            ok = false;
                        }
                    } 
                if (!(senha.equals(resenha))) {
                    JOptionPane.showMessageDialog(null, "Senha invalida");
                } else {
                    Validador v = new Validador(jFDataNasc.getText());

                    if (v.retornaDia() > 31) {
                        JOptionPane.showMessageDialog(null, "Data invalida");
                        ok = false;
                    }
                    if (v.retornaMes() > 12) {
                        JOptionPane.showMessageDialog(null, "Mes invalida");
                        ok = false;
                    }
                    if (v.retornaAno() < 1880) {
                        JOptionPane.showMessageDialog(null, "Você não é humano!");
                        ok = false;
                    }
                    if (v.retornaAno() > 2016) {
                        JOptionPane.showMessageDialog(null, "De volta para o futuro!");
                        ok = false;
                    }
                    

                    if (ok == true) {
                        nome = jTFNome.getText();
                        nomeU = nome.toUpperCase();
                        cm.setNome(nomeU);
                        cm.setEmail(jTFEmail.getText());
                        cm.setLogin(jTFLogin.getText());
                        cm.setCpf(jFCPF.getText());
                        cm.setData_nasc(jFDataNasc.getText());
                        cm.setRg(jFRG.getText());
                        cm.setSenha(senha);

                        if (cd.Atualizar(cm)) {
                            jFPrincipal pri = new jFPrincipal(login);
                            pri.setVisible(true);
                            
                            this.dispose();
                            
                        } else {

                        }
                    }
                }
            }
        } catch (RuntimeException rx) {
            JOptionPane.showMessageDialog(null, rx);
        }

    }//GEN-LAST:event_jMenu1MouseClicked

    private void jTFNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNomeKeyTyped

        char c = evt.getKeyChar();

        if (c < 'a' || c > 'z') {
            evt.consume();
        }


    }//GEN-LAST:event_jTFNomeKeyTyped

    private void jTFEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEmailKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jTFEmailKeyPressed

    private void jFDataNascKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFDataNascKeyPressed
        // TODO add your handling code here:
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jFDataNascKeyPressed

    private void jFCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFCPFKeyPressed
        // TODO add your handling code here:
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jFCPFKeyPressed

    private void jFRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFRGKeyPressed
        // TODO add your handling code here:
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jFRGKeyPressed

    private void jTFLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFLoginKeyPressed
        // TODO add your handling code here:
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jTFLoginKeyPressed

    private void jPSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSenhaKeyPressed
        // TODO add your handling code here:
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jPSenhaKeyPressed

    private void jPReSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPReSenhaKeyPressed
        // TODO add your handling code here:
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        jTFNomeKeyPressed(evt);
}
    }//GEN-LAST:event_jPReSenhaKeyPressed

    private void jTFEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFEmailKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTFEmailKeyTyped

    private void jFDataNascKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFDataNascKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jFDataNascKeyTyped

    private void jFCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFCPFKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jFCPFKeyTyped

    private void jFRGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFRGKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jFRGKeyTyped

    private void jTFLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFLoginKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTFLoginKeyTyped

    private void jPSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSenhaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jPSenhaKeyTyped

    private void jPReSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPReSenhaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jPReSenhaKeyTyped

    private void jTFNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNomeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        boolean ok = true;
        String senha = "";
        String email = "";
        String emailL = "";
        String nome;
        String nomeU = "";
        String resenha = "";

        try {
            char[] repass = jPReSenha.getPassword();

            for (int i = 0; i < repass.length; i++) {
                resenha += repass[i];
            }

            char[] pass = jPSenha.getPassword();

            for (int i = 0; i < pass.length; i++) {
                senha += pass[i];
            }
            email = jTFEmail.getText();
            emailL = email.toLowerCase();
            ClienteModelo cm = new ClienteModelo();
            ClienteDAO cd = new ClienteDAO();
            if ((jTFNome.getText().equals(""))
                    || (emailL.equals(""))
                    || (jTFLogin.getText().equals(""))
                    || (jFCPF.getText().equals(""))
                    || (jFDataNasc.getText().equals(""))
                    || (jFRG.getText().equals(""))
                    || (senha.equals(""))
                    || (resenha.equals(""))) {

                JOptionPane.showMessageDialog(null, "Campo em branco");
            } else {
                if (!emailL.contains("@gmail.com")) {
                         if (!emailL.contains("@hotmail.com")) {
                            JOptionPane.showMessageDialog(null, "Email invalido"
                                    + "\nInforme se é @gmail.com ou @hotmail.com");
                            ok = false;
                        }
                    } 
                if (!(senha.equals(resenha))) {
                    JOptionPane.showMessageDialog(null, "Senha invalida");
                } else {
                    Validador v = new Validador(jFDataNasc.getText());

                    if (v.retornaDia() > 31) {
                        JOptionPane.showMessageDialog(null, "Data invalida");
                        ok = false;
                    }
                    if (v.retornaMes() > 12) {
                        JOptionPane.showMessageDialog(null, "Mes invalida");
                        ok = false;
                    }
                    if (v.retornaAno() < 1880) {
                        JOptionPane.showMessageDialog(null, "Você não é humano!");
                        ok = false;
                    }
                    if (v.retornaAno() > 2016) {
                        JOptionPane.showMessageDialog(null, "De volta para o futuro!");
                        ok = false;
                    }
                    

                    if (ok == true) {
                        nome = jTFNome.getText();
                        nomeU = nome.toUpperCase();
                        cm.setNome(nomeU);
                        cm.setEmail(jTFEmail.getText());
                        cm.setLogin(jTFLogin.getText());
                        cm.setCpf(jFCPF.getText());
                        cm.setData_nasc(jFDataNasc.getText());
                        cm.setRg(jFRG.getText());
                        cm.setSenha(senha);

                        if (cd.Atualizar(cm)) {
                            jFPrincipal pri = new jFPrincipal(login);
                            pri.setVisible(true);
                            
                            this.dispose();
                            
                        } else {

                        }
                    }
                }
            }
        } catch (RuntimeException rx) {
            JOptionPane.showMessageDialog(null, rx);
        }
        }
    }//GEN-LAST:event_jTFNomeKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFAtualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFAtualizar().setVisible(true);
            }
        });
              */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFCPF;
    private javax.swing.JFormattedTextField jFDataNasc;
    private javax.swing.JFormattedTextField jFRG;
    private javax.swing.JLabel jLBCPF;
    private javax.swing.JLabel jLBDataNasc;
    private javax.swing.JLabel jLBEmail;
    private javax.swing.JLabel jLBLogin;
    private javax.swing.JLabel jLBNome;
    private javax.swing.JLabel jLBPlanoFundo;
    private javax.swing.JLabel jLBRG;
    private javax.swing.JLabel jLBReSenha;
    private javax.swing.JLabel jLBSenha;
    private javax.swing.JLabel jLBTitle;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField jPReSenha;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFLogin;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
