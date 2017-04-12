/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import DAO.ClienteDAO;
import ModeloTabela.Cliente;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class JF_Login_CriarConta extends javax.swing.JFrame {

    /**
     * Creates new form JF_Login_CriarConta
     */
    String nome = null;
    String email = null;
    int id = 0;
    String senha = null;
    String login = null;

    public boolean infoCliente(String login, String senha) {
        try {
            ClienteDAO cd = new ClienteDAO();

            this.nome = cd.checkLogin(login, senha).getNome();
            this.senha = cd.checkLogin(login, senha).getSenha();
            this.email = cd.checkLogin(login, senha).getEmail();
            this.id = cd.checkLogin(login, senha).getId();
            this.login = cd.checkLogin(login, senha).getLogin();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(JF_Login_CriarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    boolean clienteVazio(String login, String senha) {
        ClienteDAO cd;
        boolean ok = true;
        try {
            cd = new ClienteDAO();
            cd.checkLogin(login, senha);
            if (cd.checkLogin(login, senha) == null) {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
            }
        } catch (SQLException ex) {

            ok = false;
        }
        return true;
    }

    public void chamarTelaPrincipal(String nome, String senha, String login, String email, int id) {
        JF_Tela_Principal principal = new JF_Tela_Principal(nome, senha, login, email, id);
        principal.setVisible(true);
    }

    public JF_Login_CriarConta() {
        initComponents();
        URL caminhoIcone = getClass().getResource("/IMG/IconeCO7.PNG");
        Image iconeTitile = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitile);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_Titulo = new javax.swing.JLabel();
        JL_Senha = new javax.swing.JLabel();
        JTF_Login_Usu = new javax.swing.JTextField();
        JL_CriarConta_Usu = new javax.swing.JLabel();
        JL_Login1 = new javax.swing.JLabel();
        JL_Login_Usu1 = new javax.swing.JLabel();
        JTF_Login_Cria_Usu = new javax.swing.JTextField();
        JTF_NomeUsu_Usu2 = new javax.swing.JTextField();
        JTF_Cria_Email_Confirma = new javax.swing.JTextField();
        JTF_Cria_Email = new javax.swing.JTextField();
        JL_NomeUsu = new javax.swing.JLabel();
        JL_LoginUsu = new javax.swing.JLabel();
        JL_Cria_Email_Confirma = new javax.swing.JLabel();
        JL_Cria_Senha_Confirma = new javax.swing.JLabel();
        JL_Cria_Email2 = new javax.swing.JLabel();
        JL_Cria_Senha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        JRB_Aceita_Contrato = new javax.swing.JRadioButton();
        JB_Criar_Conta = new javax.swing.JButton();
        JB_Cancelar_Conta = new javax.swing.JButton();
        JB_Entra_Login = new javax.swing.JButton();
        JB_Cancelar_Login = new javax.swing.JButton();
        JTF_Senha_Usu = new javax.swing.JPasswordField();
        JTF_Cria_Senha_Confirma = new javax.swing.JPasswordField();
        JTF_Senha_Cria = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        getContentPane().setLayout(null);

        JL_Titulo.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        JL_Titulo.setText("CONSUMIDOR ONLINE  UMA BUSCA INTELIGENTE  ");
        getContentPane().add(JL_Titulo);
        JL_Titulo.setBounds(143, 31, 1183, 56);

        JL_Senha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Senha.setText("SENHA");
        getContentPane().add(JL_Senha);
        JL_Senha.setBounds(60, 265, 70, 22);

        JTF_Login_Usu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_Login_Usu);
        JTF_Login_Usu.setBounds(140, 208, 355, 30);

        JL_CriarConta_Usu.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        JL_CriarConta_Usu.setText("CRIAR CONTA");
        getContentPane().add(JL_CriarConta_Usu);
        JL_CriarConta_Usu.setBounds(920, 150, 244, 43);

        JL_Login1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Login1.setText("LOGIN");
        getContentPane().add(JL_Login1);
        JL_Login1.setBounds(67, 207, 55, 22);

        JL_Login_Usu1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        JL_Login_Usu1.setText("LOGIN");
        getContentPane().add(JL_Login_Usu1);
        JL_Login_Usu1.setBounds(270, 160, 111, 43);

        JTF_Login_Cria_Usu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_Login_Cria_Usu);
        JTF_Login_Cria_Usu.setBounds(860, 243, 355, 30);

        JTF_NomeUsu_Usu2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTF_NomeUsu_Usu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NomeUsu_Usu2ActionPerformed(evt);
            }
        });
        getContentPane().add(JTF_NomeUsu_Usu2);
        JTF_NomeUsu_Usu2.setBounds(860, 203, 355, 30);

        JTF_Cria_Email_Confirma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_Cria_Email_Confirma);
        JTF_Cria_Email_Confirma.setBounds(860, 326, 355, 30);

        JTF_Cria_Email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_Cria_Email);
        JTF_Cria_Email.setBounds(860, 286, 355, 30);

        JL_NomeUsu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_NomeUsu.setText("NOME DO USUARIO");
        getContentPane().add(JL_NomeUsu);
        JL_NomeUsu.setBounds(671, 209, 171, 22);

        JL_LoginUsu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_LoginUsu.setText("LOGIN");
        getContentPane().add(JL_LoginUsu);
        JL_LoginUsu.setBounds(787, 249, 55, 22);

        JL_Cria_Email_Confirma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Email_Confirma.setText("CONFIRMAÇÃO DE EMAIL");
        getContentPane().add(JL_Cria_Email_Confirma);
        JL_Cria_Email_Confirma.setBounds(623, 332, 219, 22);

        JL_Cria_Senha_Confirma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Senha_Confirma.setText("CONFIRMAÇÃO DE SENHA");
        getContentPane().add(JL_Cria_Senha_Confirma);
        JL_Cria_Senha_Confirma.setBounds(608, 422, 228, 22);

        JL_Cria_Email2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Email2.setText("EMAIL");
        getContentPane().add(JL_Cria_Email2);
        JL_Cria_Email2.setBounds(790, 292, 52, 22);

        JL_Cria_Senha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Senha.setText("SENHA");
        getContentPane().add(JL_Cria_Senha);
        JL_Cria_Senha.setBounds(775, 382, 61, 22);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Lorem ipsum dolor sit amet, consequat lorem sapien fusce\n elit sed, lacus vitae orci facilisis, sem nec vel adipiscing \nconsectetuer  placerat lacus, fringilla lobortis delectus \nsit nunc magna, faucibus sit. Dolor viverra egestas vitae \nwisi  vivamus, amet tristique ut, eu enim officia. \nTellus nonummy  fringilla in, lectus eget, curabitur sapien,\n est dolorem nec dui ipsum eu eos. Nec egestas placerat, \nultrices molestie tristique vitae rerum  tincidunt repellat, \nsollicitudin dictum et. Velit mattis donec taciti, velit eget\n commodo risus fermentum dictum, eu placerat felis nulla, \nid montes eget tincidunt at proin dignissimos. Vitae dolor ac \nut lorem tristique. Nunc amet eleifend ultricies aliquet non, \nsodales maecenas aliquam  vestibulum in mi. Accumsan diam \nin mi scelerisque, mi sem, duis vestibulum. Ut lorem at, lacus class \nvestibulum, turpis malesuada aenean, risus hymenaeos \nante nibh, penatibus neque. Euismod lacinia vivamus ridiculus \nenim cursus nec. Gravida at sodales vehicula vestibulum, in \nante, nunc id euismod ullamcorper porttitor mattis cursus, quisque \ndolor porta vehicula, orci quam. Orci luctus  morbi leo vehicula, \nelementum mi ultrices duis cubilia. Vestibulum iaculis ut, euismod sociosqu \nnam pede class et. Nulla adipiscing hendrerit fringilla vitae. Ultrices dignissim, \nlacinia eleifend nunc dolor massa. Aliquam cras maecenas vitae  lorem do, \ncursus felis, ligula neque eget metus a imperdiet, quis magna. Ligula eu sed, \nin suspendisse interdum, placerat erat tristique pede, id mauris at ante nulla \nvarius,  ut a. Imperdiet rutrum dictumst, mattis lacus, duis nam risus enim \nperferendis, iaculis commodo lacinia. A id volutpat nunc, sed volutpat enim \ntincidunt ipsum, eu eget morbi,  wisi metus netus, pharetra litora est inceptos \npenatibus mollis. Lobortis praesent id gravida hendrerit scelerisque nunc, in \nnatoque non in, vitae aenean lacus nibh, vivamus vestibulum at.  Sit viverra \nscelerisque per luctus ut gravida, posuere curabitur aenean fusce justo, proin nisl\naugue congue rhoncus, rhoncus luctus sagittis sit.\nUt massa pharetra a in. Pellentesque adipiscing, turpis quam etiam tortor pretium \ntellus. Consectetuer vel sociis velit, ut magna vel, velit urna in habitasse et, molestie \ndonec quis proin urna, nisl deserunt. Fusce duis, et magna, diam blandit tincidunt augue, \npretium risus condimentum sed ipsum eu dictum. Nulla amet consequat urna id eros, \neuismod consequat urna vestibulum, orci viverra tortor quis blandit amet vitae, per \nnullam turpis nam quis ut aliquam, ante vel vel nec. Pede tempus neque at id donec\n gravida, vitae molestie auctor vulputate, nisl egestas lacus nulla class urna, \net vitae et montes nibh excepturi, a ut nec ut vulputate sapien. Integer consectetuer \nwisi vehicula. Posuere gravida sed quam urna, consectetuer neque donec bibendum at mollis, \nut proin, non proin eget vel et ante dolor. Fusce in viverra ac adipiscing ac. Sit qui libero \nfermentum in purus, lorem porttitor nunc luctus magna magna non, mauris semper vel et \nturpis vel euismod, sodales justo a quam scelerisque laoreet. Morbi aenean aliquam sapien \nerat hendrerit condimentum. In sed ipsum montes eu convallis, amet suspendisse lorem pede, \nnisl nunc.");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(611, 456, 595, 110);

        JRB_Aceita_Contrato.setText("Aceito");
        getContentPane().add(JRB_Aceita_Contrato);
        JRB_Aceita_Contrato.setBounds(880, 572, 55, 23);

        JB_Criar_Conta.setText("CADASTRAR");
        JB_Criar_Conta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_Criar_ContaMouseClicked(evt);
            }
        });
        JB_Criar_Conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Criar_ContaActionPerformed(evt);
            }
        });
        getContentPane().add(JB_Criar_Conta);
        JB_Criar_Conta.setBounds(623, 612, 600, 23);

        JB_Cancelar_Conta.setText("CANCELAR");
        getContentPane().add(JB_Cancelar_Conta);
        JB_Cancelar_Conta.setBounds(623, 652, 600, 23);

        JB_Entra_Login.setText("ENTRAR");
        JB_Entra_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Entra_LoginActionPerformed(evt);
            }
        });
        getContentPane().add(JB_Entra_Login);
        JB_Entra_Login.setBounds(209, 310, 91, 23);

        JB_Cancelar_Login.setText("CANCELAR");
        getContentPane().add(JB_Cancelar_Login);
        JB_Cancelar_Login.setBounds(337, 310, 85, 23);
        getContentPane().add(JTF_Senha_Usu);
        JTF_Senha_Usu.setBounds(140, 266, 355, 30);
        getContentPane().add(JTF_Cria_Senha_Confirma);
        JTF_Cria_Senha_Confirma.setBounds(860, 415, 355, 30);
        getContentPane().add(JTF_Senha_Cria);
        JTF_Senha_Cria.setBounds(860, 375, 355, 30);

        setSize(new java.awt.Dimension(1649, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_Entra_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Entra_LoginActionPerformed
        String login = JTF_Login_Usu.getText();
        String senha = "";

        char[] pass = JTF_Senha_Usu.getPassword();

        for (int i = 0; i < pass.length; i++) {
            senha += pass[i];
        }

        if ((login.isEmpty()) || (senha.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Campo em branco");
        } else {
            if (clienteVazio(login, senha) == false) {

            } else {
                if (infoCliente(login, senha) == false) {

                } else {
                    infoCliente(login, senha);
                    JF_Tela_Principal principal = new JF_Tela_Principal(nome, senha, login, email, id);
                    principal.receberInfo(nome, senha, login, email, id);
                    chamarTelaPrincipal(nome, senha, login, email, id);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_JB_Entra_LoginActionPerformed

    private void JB_Criar_ContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Criar_ContaActionPerformed


    }//GEN-LAST:event_JB_Criar_ContaActionPerformed

    private void JTF_NomeUsu_Usu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NomeUsu_Usu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_NomeUsu_Usu2ActionPerformed

    private void JB_Criar_ContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_Criar_ContaMouseClicked

        Cliente cli = new Cliente();
        String nome = JTF_NomeUsu_Usu2.getText().toUpperCase();
        String login = JTF_Login_Cria_Usu.getText();
        String email = JTF_Cria_Email.getText();
        String confirmaEmail = JTF_Cria_Email_Confirma.getText();
        String senha = "";
        String confirmaSenha = "";

        char[] repass = JTF_Cria_Senha_Confirma.getPassword();

        for (int i = 0; i < repass.length; i++) {
            confirmaSenha += repass[i];
        }

        char[] pass = JTF_Senha_Cria.getPassword();

        for (int i = 0; i < pass.length; i++) {
            senha += pass[i];
        }

        if ((nome.isEmpty()) || (login.isEmpty()) || (email.isEmpty()) || (senha.isEmpty()) || (confirmaSenha.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Campo em branco");
        } else {
            if (!(email.equals(confirmaEmail))) {
                JOptionPane.showMessageDialog(null, "E-mails não compativeis");

            } else {
                if (!(senha.equals(confirmaSenha))) {
                    JOptionPane.showMessageDialog(null, "Senhas não compativeis");

                } else {
                    if (JRB_Aceita_Contrato.isSelected()) {

                        cli.setEmail(email);
                        cli.setLogin(login);
                        cli.setNome(nome);
                        cli.setSenha(senha);

                        ClienteDAO cd = null;
                        try {
                            cd = new ClienteDAO();
                        } catch (SQLException ex) {
                            Logger.getLogger(JF_Login_CriarConta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cd.adiciona(cli);
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                        JTF_NomeUsu_Usu2.setText("");
                        JTF_Login_Cria_Usu.setText("");
                        JTF_Senha_Cria.setText("");
                        JTF_Cria_Senha_Confirma.setText("");
                        JTF_Cria_Email_Confirma.setText("");
                        JTF_Cria_Email.setText("");
                        //JRB_Aceita_Contrato
                    } else {
                        JOptionPane.showMessageDialog(null, "Aceitar os termos de contrato é obrigatório");
                    }
                }
            }
        }
    }//GEN-LAST:event_JB_Criar_ContaMouseClicked

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
            java.util.logging.Logger.getLogger(JF_Login_CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Login_CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Login_CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Login_CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Login_CriarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Cancelar_Conta;
    private javax.swing.JButton JB_Cancelar_Login;
    private javax.swing.JButton JB_Criar_Conta;
    private javax.swing.JButton JB_Entra_Login;
    private javax.swing.JLabel JL_Cria_Email2;
    private javax.swing.JLabel JL_Cria_Email_Confirma;
    private javax.swing.JLabel JL_Cria_Senha;
    private javax.swing.JLabel JL_Cria_Senha_Confirma;
    private javax.swing.JLabel JL_CriarConta_Usu;
    private javax.swing.JLabel JL_Login1;
    private javax.swing.JLabel JL_LoginUsu;
    private javax.swing.JLabel JL_Login_Usu1;
    private javax.swing.JLabel JL_NomeUsu;
    private javax.swing.JLabel JL_Senha;
    private javax.swing.JLabel JL_Titulo;
    private javax.swing.JRadioButton JRB_Aceita_Contrato;
    private javax.swing.JTextField JTF_Cria_Email;
    private javax.swing.JTextField JTF_Cria_Email_Confirma;
    private javax.swing.JPasswordField JTF_Cria_Senha_Confirma;
    private javax.swing.JTextField JTF_Login_Cria_Usu;
    private javax.swing.JTextField JTF_Login_Usu;
    private javax.swing.JTextField JTF_NomeUsu_Usu2;
    private javax.swing.JPasswordField JTF_Senha_Cria;
    private javax.swing.JPasswordField JTF_Senha_Usu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
