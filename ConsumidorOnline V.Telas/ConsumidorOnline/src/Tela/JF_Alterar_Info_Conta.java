/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

/**
 *
 * @author Vinicius Alves
 */
public class JF_Alterar_Info_Conta extends javax.swing.JFrame {

    /**
     * Creates new form JF_Alterar_Info_Conta
     */
    public JF_Alterar_Info_Conta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_Cria_Email2 = new javax.swing.JLabel();
        JL_Cria_Email_Confirma = new javax.swing.JLabel();
        JL_Cria_Senha_Confirma = new javax.swing.JLabel();
        JL_NomeUsu = new javax.swing.JLabel();
        JL_LoginUsu = new javax.swing.JLabel();
        JTF_Cria_Senha_Confirma = new javax.swing.JTextField();
        JTF_Senha_Cria = new javax.swing.JTextField();
        JTF_Cria_Email_Confirma = new javax.swing.JTextField();
        JTF_Cria_Email = new javax.swing.JTextField();
        JL_Cria_Senha = new javax.swing.JLabel();
        JTF_NomeUsu_Usu2 = new javax.swing.JTextField();
        JTF_Login_Cria_Usu = new javax.swing.JTextField();
        JBTN_Salvar_Info_Conta = new javax.swing.JButton();
        JBTN_Cancelar_Info_Conta = new javax.swing.JButton();
        JL_Info_Conta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_Cria_Email2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Email2.setText("EMAIL");

        JL_Cria_Email_Confirma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Email_Confirma.setText("CONFIRMAÇÃO DE EMAIL");

        JL_Cria_Senha_Confirma.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Senha_Confirma.setText("CONFIRMAÇÃO DE SENHA");

        JL_NomeUsu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_NomeUsu.setText("NOME DO USUARIO");

        JL_LoginUsu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_LoginUsu.setText("LOGIN");

        JTF_Cria_Senha_Confirma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_Senha_Cria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_Cria_Email_Confirma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_Cria_Email.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JL_Cria_Senha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Cria_Senha.setText("SENHA");

        JTF_NomeUsu_Usu2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_Login_Cria_Usu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JBTN_Salvar_Info_Conta.setText("SALVAR");

        JBTN_Cancelar_Info_Conta.setText("CANCELAR");

        JL_Info_Conta.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        JL_Info_Conta.setText("INFORMACOES DA CONTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(JL_NomeUsu)
                                    .addGap(18, 18, 18)
                                    .addComponent(JTF_NomeUsu_Usu2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(176, 176, 176)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JL_Cria_Email2)
                                        .addComponent(JL_LoginUsu))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JTF_Login_Cria_Usu, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTF_Cria_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(JL_Cria_Senha_Confirma)
                                                .addComponent(JL_Cria_Senha))
                                            .addGap(21, 21, 21))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(JL_Cria_Email_Confirma)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JTF_Cria_Email_Confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTF_Senha_Cria, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JTF_Cria_Senha_Confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBTN_Salvar_Info_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBTN_Cancelar_Info_Conta)
                                .addGap(108, 108, 108))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(JL_Info_Conta)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(JL_Info_Conta)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_NomeUsu_Usu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_NomeUsu))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Login_Cria_Usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_LoginUsu))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Cria_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Cria_Email2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Cria_Email_Confirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Cria_Email_Confirma))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Senha_Cria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Cria_Senha))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Cria_Senha_Confirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Cria_Senha_Confirma))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTN_Salvar_Info_Conta)
                    .addComponent(JBTN_Cancelar_Info_Conta))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JF_Alterar_Info_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Alterar_Info_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Alterar_Info_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Alterar_Info_Conta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Alterar_Info_Conta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTN_Cancelar_Info_Conta;
    private javax.swing.JButton JBTN_Salvar_Info_Conta;
    private javax.swing.JLabel JL_Cria_Email2;
    private javax.swing.JLabel JL_Cria_Email_Confirma;
    private javax.swing.JLabel JL_Cria_Senha;
    private javax.swing.JLabel JL_Cria_Senha_Confirma;
    private javax.swing.JLabel JL_Info_Conta;
    private javax.swing.JLabel JL_LoginUsu;
    private javax.swing.JLabel JL_NomeUsu;
    private javax.swing.JTextField JTF_Cria_Email;
    private javax.swing.JTextField JTF_Cria_Email_Confirma;
    private javax.swing.JTextField JTF_Cria_Senha_Confirma;
    private javax.swing.JTextField JTF_Login_Cria_Usu;
    private javax.swing.JTextField JTF_NomeUsu_Usu2;
    private javax.swing.JTextField JTF_Senha_Cria;
    // End of variables declaration//GEN-END:variables
}
