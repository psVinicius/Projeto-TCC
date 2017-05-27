/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Auxiliar.EnviarEmail;
import DAO.ClienteDAO;
import ModeloTabela.Cliente;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class JF_AlterarInfoConta extends javax.swing.JFrame {

    /**
     * Creates new form JF_AlterarInfoConta
     */
    String nome, senha, email, login, emailOk, loginOK = null;

    int id = 0;

    public JF_AlterarInfoConta(String nome, String login, String senha, String email, int id) throws SQLException {
        initComponents();

        URL caminhoIcone = getClass().getResource("/IMG/IconeCO7.PNG");
        Image iconeTitile = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitile);
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.login = login;
        this.id = id;
        this.loginOK = this.login;
        this.emailOk = this.email;
        info();
        retornaTudoCertinho();

    }

    public void info() {
        jTextField1.setText(this.nome);
        jTextField2.setText(this.email);
        jTextField3.setText(this.email);
        jTextField4.setText(this.login);
        jTextField5.setText(this.senha);
        jTextField6.setText(this.senha);

    }

    public void retornaTudoCertinho() throws SQLException {
        ClienteDAO cd = new ClienteDAO();
        cd.recolheinfo(this.id);

        jTextField1.setText(cd.recolheinfo(this.id).getNome());
        jTextField2.setText(cd.recolheinfo(this.id).getEmail());
        jTextField3.setText(cd.recolheinfo(this.id).getEmail());
        jTextField4.setText(cd.recolheinfo(this.id).getLogin());
        jTextField5.setText(cd.recolheinfo(this.id).getSenha());
        jTextField6.setText(cd.recolheinfo(this.id).getSenha());

    }

    public boolean checkMudou(String nome, String login, String email, String email2, String senha, String senha2) {
        if (this.nome.equals(nome)) {

            if (this.login.equals(login)) {
                if (this.email.equals(email)) {
                    if (this.email.equals(email2)) {
                        if (this.senha.equals(senha)) {
                            if (this.senha.equals(senha2)) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("CONSUMIDOR ONLINE");

        jLabel8.setText("INFORMACOES DA CONTA");

        jLabel1.setText("NOME DE USUARIO");

        jLabel2.setText("EMAIL");

        jLabel3.setText("CONFIRMA EMAIL");

        jLabel4.setText("LOGIN");

        jLabel5.setText("SENHA");

        jLabel6.setText("CONFIRMA SENHA");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField4)
                            .addComponent(jTextField1)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Cliente cli = new Cliente();
            System.out.println(cli);
            String nome = jTextField1.getText().toUpperCase();
            System.out.println(nome);
            String login = jTextField4.getText();
            System.out.println(login);
            String email = jTextField2.getText();
            System.out.println(email);
            String confirmaEmail = jTextField3.getText();
            System.out.println(confirmaEmail);
            String senha = "";
            System.out.println("senha: " + senha);
            String confirmaSenha = "";
            System.out.println("confirmaSenha: " + confirmaSenha);

            char[] repass = jTextField6.getPassword();

            for (int i = 0; i < repass.length; i++) {
                confirmaSenha += repass[i];
                System.out.println("iiiii " + i);
            }
            System.out.println(confirmaSenha);

            char[] pass = jTextField5.getPassword();

            for (int i = 0; i < pass.length; i++) {
                senha += pass[i];
                System.out.println("iiiii " + i);

            }
            System.out.println(senha);

            if (checkMudou(nome, login, email, confirmaEmail, senha, confirmaSenha) == true) {
                System.out.println(nome);
                System.out.println(login);
                System.out.println(email);
                System.out.println(confirmaEmail);
                System.out.println(senha);
                System.out.println(confirmaSenha);

                JF_Tela_Principal tp = new JF_Tela_Principal(nome, senha, login, email, this.id);
                tp.setVisible(true);
                this.dispose();

            } else {

                if ((nome.isEmpty()) || (login.isEmpty()) || (email.isEmpty()) || (senha.isEmpty()) || (confirmaSenha.isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Campo em branco");
                } else {
                    if (!(email.equals(confirmaEmail))) {
                        JOptionPane.showMessageDialog(null, "E-mails não compativeis");
                        jTextField3.setText("");
                    } else {
                        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", jTextField2.getText()))) {
                            JOptionPane.showMessageDialog(null, "Por favor, informe um e-mail valido", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (!(senha.equals(confirmaSenha))) {
                                JOptionPane.showMessageDialog(null, "Senhas não compativeis");

                            } else {
                                int opcao = 0;
                                System.out.println(opcao);
                                Object[] options = {"Confirmar", "Cancelar"};

                                System.out.println(options[0] + " sss " + options[1]);

                                opcao = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                                if (opcao == 0) {
                                    System.out.println("teste");
                                    jButton2.setEnabled(false);
                                    jButton3.setEnabled(false);
                                    if (!(email.equals(this.emailOk))) {
                                        ClienteDAO cd = null;

                                        cd = new ClienteDAO();
                                        if (login.equals(loginOK)) {

                                            if (cd.checkEmai(email) == null) {
                                                EnviarEmail envia = new EnviarEmail();
                                                String codi = "Q2.s";
                                                String titulo = "Codigo de atualização de infomações da conta";
                                                String texto = "O codigo para autenticar e-mail: " + codi;

                                                envia.enviarMail(email, titulo, texto);
                                                JOptionPane.showMessageDialog(this, "Um código foi enviado para o seu novo email");
                                                JF_TrocouEmail tro = new JF_TrocouEmail(codi, email, nome, login, senha, this.id);
                                                tro.setVisible(true);
                                                this.dispose();
                                            } else {
                                                JOptionPane.showMessageDialog(this, "Email ja cadastrado, por favor "
                                                        + "registre um novo email!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                jTextField3.setText("");
                                                jTextField2.setText("");
                                            }
                                        } else {
                                            if (cd.checkLoginL(login) != null) {
                                                JOptionPane.showMessageDialog(this, "Nome de login ja cadastrado, por favor registre um novo login!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                jTextField4.setText("");

                                            } else {
                                                if (cd.checkEmai(email) == null) {
                                                    EnviarEmail envia = new EnviarEmail();
                                                    String codi = "Q2.s";
                                                    String titulo = "Codigo de atualização de infomações da conta";
                                                    String texto = "O codigo para autenticar e-mail: " + codi;
                                                    JOptionPane.showMessageDialog(this, "Um código foi enviado para o seu novo email");
                                                    JF_TrocouEmail tro = new JF_TrocouEmail(codi, email, nome, login, senha, this.id);
                                                    tro.setVisible(true);

                                                    envia.enviarMail(email, titulo, texto);
                                                    this.dispose();
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Email ja cadastrado, por favor "
                                                            + "registre um novo email!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                    jTextField3.setText("");
                                                    jTextField2.setText("");
                                                }
                                            }

                                        }
                                    } else {

                                        cli.setId(this.id);
                                        cli.setEmail(email);
                                        cli.setLogin(login);
                                        cli.setNome(nome);
                                        cli.setSenha(senha);

                                        ClienteDAO cd = null;

                                        cd = new ClienteDAO();

                                        if (login.equals(this.loginOK)) {
                                            System.out.println(cd);

                                            cd.update(cli);
                                            System.out.println(cd);

                                            JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso");

                                            jTextField2.setText("");
                                            jTextField1.setText("");
                                            jTextField3.setText("");
                                            jTextField4.setText("");
                                            jTextField5.setText("");
                                            jTextField6.setText("");

                                            JF_Tela_Principal p = new JF_Tela_Principal(nome, senha, login, email, id);
                                            p.setVisible(true);
                                            this.dispose();
                                        } else {
                                            if (cd.checkLoginL(login) == null) {

                                                System.out.println(cd);

                                                cd.update(cli);
                                                System.out.println(cd);

                                                JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso");

                                                jTextField2.setText("");
                                                jTextField1.setText("");
                                                jTextField3.setText("");
                                                jTextField4.setText("");
                                                jTextField5.setText("");
                                                jTextField6.setText("");

                                                JF_Tela_Principal p = new JF_Tela_Principal(nome, senha, login, email, id);
                                                p.setVisible(true);
                                                this.dispose();
                                            } else {
                                                JOptionPane.showMessageDialog(this, "Nome de login ja cadastrado, por favor registre um novo login!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                jTextField4.setText("");
                                            }

                                        }
                                    }
                                    if (opcao == 1) {

                                    }
                                    if (opcao == -1) {

                                    }

                                }
                            }
                        }
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_AlterarInfoConta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(this.nome);
        jTextField2.setText(this.email);
        jTextField3.setText(this.email);
        jTextField4.setText(this.login);
        jTextField5.setText(this.senha);
        jTextField6.setText(this.senha);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        JF_Tela_Principal prin = new JF_Tela_Principal(this.nome, this.senha, this.login, this.email, this.id);
        prin.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_AlterarInfoConta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_AlterarInfoConta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_AlterarInfoConta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_AlterarInfoConta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /* java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new JF_AlterarInfoConta().setVisible(true);
         }
         });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPasswordField jTextField5;
    private javax.swing.JPasswordField jTextField6;
    // End of variables declaration//GEN-END:variables
}