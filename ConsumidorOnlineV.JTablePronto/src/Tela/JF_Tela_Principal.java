/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import DAO.ItemPesquisaDAO;
import DAO.Pesquisa_TagDAO;
import DAO.TagDAO;
import ModeloTabela.Cliente;
import ModeloTabela.ItemPesquisa;
import ModeloTabela.Pesquisa_Tag;
import ModeloTabela.Tag;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicius Alves
 */
public class JF_Tela_Principal extends javax.swing.JFrame {

    /**
     * Creates new form JF_Tela_Principal
     */
    String senha, login, email, nome, nome_pesquisaJTable = null;
    int id;
    int id_tag[] = new int[10];
    int id_Pesquisa = 0;
    int numeroLinha = 0;
    ArrayList<JTextField> listaTagSelecionadas = new ArrayList();

    public void listIDTag(String nome) {

        try {
            Tag tag = new Tag();
            TagDAO td = new TagDAO();

            String tag1 = JTF_tag1.getText();
            String tag2 = JTF_tag2.getText();
            String tag3 = JTF_tag3.getText();
            String tag4 = JTF_tag4.getText();
            String tag5 = JTF_tag5.getText();
            String preco = JTF_tag_Preco_maximo.getText();
            int id = 0;

            /*    ArrayList<Tag> lista = new ArrayList();
             lista.add(tag);

             for (Tag t : lista) {
             if (td.recolherInfo(nome).getNome_tag() == nome){
             this.id_tag = td.recolherInfo(nome).getId();
             }
             }

             } catch (SQLException ex) {
             Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
             } */
        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recolherInfoTag(String a) {
        TagDAO tag;
        int ok = 0;
        try {
            tag = new TagDAO();
            for (int i = 0; i < id_tag.length; i++) {
                if (this.id_tag[i] == 0) {
                    ok = i;
                }
            }
            tag.recolherInfo(a);
            this.id_tag[ok] = tag.recolherInfo(a).getId();

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void recolherInfoItemPesquisa(int id, String nomeP) {
        try {
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
            this.id_Pesquisa = ipd.recolherInfo(this.id, nomeP).getId();

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean confirmaExistItemPesquisa(int id, String nomeP) {
        try {
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
            if (ipd.confirmaExist(this.id, nomeP) != null) {
                JOptionPane.showMessageDialog(null, "Você ja usa este nome de pesquisa");
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void list() {

        try {
            Tag tag = new Tag();
            TagDAO td = new TagDAO();

            String tag1 = JTF_tag1.getText();
            String tag2 = JTF_tag2.getText();
            String tag3 = JTF_tag3.getText();
            String tag4 = JTF_tag4.getText();
            String tag5 = JTF_tag5.getText();
            String preco = JTF_tag_Preco_maximo.getText();
            int id = 0;

            ArrayList<Tag> lista = new ArrayList();
            lista.add(tag);

            for (Tag t : lista) {
                td.checkExiste(tag1);
                if (td.checkExiste(tag1) != null) {
                    id = td.checkExiste(tag1).getId();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void adiconaPesquisaTAg(int id_pesquisa, int id_tag) {

        try {
            Pesquisa_Tag pt = new Pesquisa_Tag();
            Pesquisa_TagDAO ptd = new Pesquisa_TagDAO();
            ptd.adiciona(id_pesquisa, id_tag);

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inicaliza() {
        for (int i = 0; i < this.id_tag.length; i++) {
            this.id_tag[i] = 0;
        }

        //Inicializa array de tags selecionadas
        listaTagSelecionadas.add(JTF_tag1_selecionado);
        listaTagSelecionadas.add(JTF_tag2_selecionado);
        listaTagSelecionadas.add(JTF_tag3_selecionado);
        listaTagSelecionadas.add(JTF_tag4_selecionado);
        listaTagSelecionadas.add(JTF_tag5_selecionado);
        listaTagSelecionadas.add(JTF_tag_Preco_maximo_selecionado);
    }

    public void chamar_Alterar_Info_Conta() {
        JF_Alterar_Info_Conta info = new JF_Alterar_Info_Conta(nome, login, senha, email, id);
        info.setVisible(true);
        this.dispose();
    }

    public JF_Tela_Principal(String nome, String senha, String login, String email, int id) {
        initComponents();
        int i = 0;

        inicaliza();

        URL caminhoIcone = getClass().getResource("/IMG/IconeCO7.PNG");
        Image iconeTitile = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitile);

        this.senha = senha;
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.id = id;

        receberInfo(nome, senha, login, email, id);
        JL_Nome_Usu_Bonito.setText(nome);
        listaJTable(id);
    }

    public void receberInfo(String nome, String senha, String login, String email, int id) {
        this.senha = senha;
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public void listaJTable(int id) {
        DefaultTableModel modelo = (DefaultTableModel) JTable.getModel();
        modelo.setNumRows(0);
        ItemPesquisaDAO ipd;
        try {
            ipd = new ItemPesquisaDAO();

            for (ItemPesquisa ip : ipd.listaItensPesquisados(id)) {
                modelo.addRow(new Object[]{
                    ip.getNome_pesquisa(),
                    ip.getId()

                });

            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void descobreLinha() {
        this.numeroLinha = JTable.getSelectedRow();

    }

    public void retornaObjetoJTable() {
        JTable.getValueAt(this.numeroLinha, 0);
        JTF_Nome_Pesquisa_selecionado.setText((String) JTable.getValueAt(this.numeroLinha, 0));
        nome_pesquisaJTable = JTF_Nome_Pesquisa_selecionado.getText();

    }

    public void limpaCamposSelecionado() {
        for (int i = 0; i < 6; i++) {
            listaTagSelecionadas.get(i).setText("");
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

        JL_Ola_Usu = new javax.swing.JLabel();
        JL_Nome_Usu_Bonito = new javax.swing.JLabel();
        JL_Novo_Item_Pesquisa = new javax.swing.JLabel();
        JL_Tag_Pesquisa = new javax.swing.JLabel();
        JL_Nome_pesquisa = new javax.swing.JLabel();
        JTF_tag1 = new javax.swing.JTextField();
        JTF_tag2 = new javax.swing.JTextField();
        JTF_tag3 = new javax.swing.JTextField();
        JTF_tag4 = new javax.swing.JTextField();
        JTF_tag5 = new javax.swing.JTextField();
        JBTN_Salvar_Criar_Item = new javax.swing.JButton();
        JBTN_Cancelar_Criar_item = new javax.swing.JButton();
        JL_Preco_Item = new javax.swing.JLabel();
        JTF_Nome_Pesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        JL_Items_Pesquisados = new javax.swing.JLabel();
        JL_Nome_pesquisa1 = new javax.swing.JLabel();
        JL_Tag_Pesquisa_Selecionado = new javax.swing.JLabel();
        JTF_Nome_Pesquisa_selecionado = new javax.swing.JTextField();
        JL_Preco_Item1 = new javax.swing.JLabel();
        JBTN_Cancelar_Selecionado = new javax.swing.JButton();
        JL_Item_selecionado_Pesquisa = new javax.swing.JLabel();
        JBTN_Salvar_Selecionado = new javax.swing.JButton();
        JTF_tag2_selecionado = new javax.swing.JTextField();
        JTF_tag3_selecionado = new javax.swing.JTextField();
        JTF_tag4_selecionado = new javax.swing.JTextField();
        JTF_tag5_selecionado = new javax.swing.JTextField();
        JTF_tag1_selecionado = new javax.swing.JTextField();
        JBTN_Editar_Selecionado = new javax.swing.JButton();
        JTF_tag_Preco_maximo = new javax.swing.JFormattedTextField();
        JTF_tag_Preco_maximo_selecionado = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JL_Ola_Usu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JL_Ola_Usu.setText("OLÁ");

        JL_Nome_Usu_Bonito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JL_Nome_Usu_Bonito.setText("VINICIUS");

        JL_Novo_Item_Pesquisa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Novo_Item_Pesquisa.setText("NOVO ITEM DE PESQUISA");

        JL_Tag_Pesquisa.setText("TAGS DE PESQUISA");

        JL_Nome_pesquisa.setText("NOME DA PESQUISA");

        JBTN_Salvar_Criar_Item.setText("Salvar");
        JBTN_Salvar_Criar_Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_Salvar_Criar_ItemActionPerformed(evt);
            }
        });

        JBTN_Cancelar_Criar_item.setText("Cancelar");

        JL_Preco_Item.setText("PRECO MAXIMO DO ITEM");

        JTF_Nome_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Nome_PesquisaActionPerformed(evt);
            }
        });

        JTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome da pesquisa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.setGridColor(new java.awt.Color(51, 51, 255));
        JTable.setSelectionBackground(new java.awt.Color(255, 102, 51));
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        JTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTableFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);

        JL_Items_Pesquisados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Items_Pesquisados.setText("ITEM DE PESQUISA");

        JL_Nome_pesquisa1.setText("NOME DA PESQUISA");

        JL_Tag_Pesquisa_Selecionado.setText("TAGS DE PESQUISA DO ITEM SELECIONADO");

        JTF_Nome_Pesquisa_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTF_Nome_Pesquisa_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Nome_Pesquisa_selecionadoActionPerformed(evt);
            }
        });

        JL_Preco_Item1.setText("PRECO MAXIMO DO ITEM");

        JBTN_Cancelar_Selecionado.setText("Cancelar");

        JL_Item_selecionado_Pesquisa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Item_selecionado_Pesquisa.setText("ITEM DA PESQUISA");

        JBTN_Salvar_Selecionado.setText("Salvar");

        JTF_tag2_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_tag3_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_tag4_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_tag5_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JTF_tag1_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JBTN_Editar_Selecionado.setText("EDITAR");

        try {
            JTF_tag_Preco_maximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###,###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            JTF_tag_Preco_maximo_selecionado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###,###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jMenu2.setText("MENU");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("ALTERAR INFORMACOES DA CONTA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("CADASTRO DE PRODUTO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("SAIR");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Ola_Usu)
                        .addGap(10, 10, 10)
                        .addComponent(JL_Nome_Usu_Bonito))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(JL_Tag_Pesquisa))
                            .addComponent(JTF_tag1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_tag2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_tag3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_tag4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_tag5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(JL_Preco_Item))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(JL_Nome_pesquisa))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(JBTN_Salvar_Criar_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(JBTN_Cancelar_Criar_item))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTF_tag_Preco_maximo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(JTF_Nome_Pesquisa, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(112, 112, 112)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(JL_Tag_Pesquisa_Selecionado))
                            .addComponent(JTF_tag1_selecionado)
                            .addComponent(JTF_tag2_selecionado)
                            .addComponent(JTF_tag3_selecionado)
                            .addComponent(JTF_tag4_selecionado)
                            .addComponent(JTF_tag5_selecionado)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(JL_Preco_Item1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(JL_Nome_pesquisa1))
                            .addComponent(JTF_Nome_Pesquisa_selecionado)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBTN_Editar_Selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(JBTN_Salvar_Selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(JBTN_Cancelar_Selecionado))
                            .addComponent(JTF_tag_Preco_maximo_selecionado)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Novo_Item_Pesquisa)
                        .addGap(279, 279, 279)
                        .addComponent(JL_Items_Pesquisados)
                        .addGap(235, 235, 235)
                        .addComponent(JL_Item_selecionado_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(447, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Ola_Usu)
                    .addComponent(JL_Nome_Usu_Bonito))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Novo_Item_Pesquisa)
                    .addComponent(JL_Items_Pesquisados)
                    .addComponent(JL_Item_selecionado_Pesquisa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Tag_Pesquisa)
                        .addGap(6, 6, 6)
                        .addComponent(JTF_tag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_tag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_tag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(JTF_tag4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(JTF_tag5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(JL_Preco_Item)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_tag_Preco_maximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(JL_Nome_pesquisa)
                        .addGap(11, 11, 11)
                        .addComponent(JTF_Nome_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBTN_Salvar_Criar_Item)
                            .addComponent(JBTN_Cancelar_Criar_item)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(JL_Tag_Pesquisa_Selecionado)
                        .addGap(3, 3, 3)
                        .addComponent(JTF_tag1_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_tag2_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_tag3_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(JTF_tag4_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(JTF_tag5_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(JL_Preco_Item1)
                        .addGap(9, 9, 9)
                        .addComponent(JTF_tag_Preco_maximo_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JL_Nome_pesquisa1)
                        .addGap(11, 11, 11)
                        .addComponent(JTF_Nome_Pesquisa_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBTN_Editar_Selecionado)
                            .addComponent(JBTN_Salvar_Selecionado)
                            .addComponent(JBTN_Cancelar_Selecionado)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        chamar_Alterar_Info_Conta();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void JTF_Nome_Pesquisa_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Nome_Pesquisa_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_Nome_Pesquisa_selecionadoActionPerformed

    private void JBTN_Salvar_Criar_ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_Salvar_Criar_ItemActionPerformed

        String tag1 = JTF_tag1.getText();
        String tag2 = JTF_tag2.getText();
        String tag3 = JTF_tag3.getText();
        String tag4 = JTF_tag4.getText();
        String tag5 = JTF_tag5.getText();
        
        String tagAr[] = new String[5];
        
        String preco = JTF_tag_Preco_maximo.getText();
        String nome_pesquisa = JTF_Nome_Pesquisa.getText();
        
        Cliente cliente = new Cliente();

        int i = 0;
        int ok = 0;
        
        for (i = 0; i < tagAr.length; i++) {
            tagAr[i] = null;
        }

        cliente.setId(this.id);

        try {
            ItemPesquisaDAO ipd2 = new ItemPesquisaDAO();
            ItemPesquisa ip2 = new ItemPesquisa();
        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean validar = false;
        try {
            Tag tag = new Tag();
            TagDAO td = new TagDAO();

            if (tag1.isEmpty()) {

            } else {
                validar = true;
                tagAr[0] = tag1;

            }

            if (tag2.isEmpty()) {

            } else {
                validar = true;
                tagAr[1] = tag2;
               
            }

            if (tag3.isEmpty()) {
            } else {
                validar = true;
                tagAr[2] = tag3;
               
            }

            if (tag4.isEmpty()) {
            } else {
                validar = true;
                tagAr[3] = tag4;
               
            }

            if (tag5.isEmpty()) {
            } else {
                validar = true;
                tagAr[4] = tag5;
               

            }
            if (preco.isEmpty()) {

            } else {
                validar = true;

            }

            if (validar == false) {
                JOptionPane.showMessageDialog(null, "Campos em branco");
            } else {
                if (nome_pesquisa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome de pesquisa é obrigatório");

                } else {
                    if (confirmaExistItemPesquisa(this.id, nome_pesquisa) == true) {
                        try {
                            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
                            ItemPesquisa ip = new ItemPesquisa();

                            for (i = 0; i < tagAr.length; i++) {
                                if (tagAr[i] == null) {
                                    break;
                                }
                                tag.setNome_tag(tagAr[i]);
                                td.adiciona(tag);
                                recolherInfoTag(tagAr[i]);
                                System.out.println(tagAr[i]);
                            }
                            ip.setNome_pesquisa(nome_pesquisa);
                            ip.setCliente(cliente);
                            if (preco.isEmpty()) {
                                preco = "0";
                            }
                            ipd.adiciona(this.id, nome_pesquisa, preco);

                            recolherInfoItemPesquisa(this.id, nome_pesquisa);

                            for (i = 0; i < this.id_tag.length; i++) {
                                if (this.id_tag[i] > 0) {
                                    ok = i;
                                    adiconaPesquisaTAg(this.id_Pesquisa, this.id_tag[ok]);
                                }
                            }

                            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                            listaJTable(this.id);
                            inicaliza();
                            JTF_tag1.setText("");
                            JTF_tag2.setText("");
                            JTF_tag3.setText("");
                            JTF_tag4.setText("");
                            JTF_tag5.setText("");
                            JTF_tag_Preco_maximo.setText("");
                            JTF_Nome_Pesquisa.setText("");

                        } catch (SQLException ex) {
                            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_JBTN_Salvar_Criar_ItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        JF_Produto_Empresa prod = new JF_Produto_Empresa();
        prod.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTableFocusGained


    }//GEN-LAST:event_JTableFocusGained

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        limpaCamposSelecionado();
        String preco = "0";
        try {
            int id = 0;
            int id_t[] = new int[6];
            int num = 0;
            String nomeT[] = new String[6];
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
            Pesquisa_TagDAO ptd = new Pesquisa_TagDAO();
            TagDAO tag = new TagDAO();
            int i = 0;
            descobreLinha();
            JTF_Nome_Pesquisa_selecionado.setText(this.nome_pesquisaJTable);
            retornaObjetoJTable();
            id = ipd.retornaValoresIDPesquisaENomePesquisa(this.id, this.nome_pesquisaJTable).getId();
            preco = ipd.retornaValoresIDPesquisaENomePesquisa(this.id, this.nome_pesquisaJTable).getPreco();

            JTF_tag_Preco_maximo_selecionado.setText(preco);
            ArrayList<Pesquisa_Tag> lista = new ArrayList();
            lista = (ptd.retornaTagsDaPesquisa(id));
            Collections.reverse(lista);
            for (Pesquisa_Tag pt2 : lista) {
                id_t[i] = pt2.getId_tag().getId();

                i++;
            }

            for (i = 0; i < id_t.length; i++) {
                if (id_t[i] == 0) {
                    break;
                }
                nomeT[i] = tag.recolherNometag(id_t[i]).getNome_tag();
                //JTF_tag1_selecionado.setText(nomeT[i]);
                retornaCampoTag(i).setText(nomeT[i]);

            }

        } catch (Exception ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_JTableMouseClicked

    private void JTF_Nome_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Nome_PesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_Nome_PesquisaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*     java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new JF_Tela_Principal().setVisible(true);
         }
         }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTN_Cancelar_Criar_item;
    private javax.swing.JButton JBTN_Cancelar_Selecionado;
    private javax.swing.JButton JBTN_Editar_Selecionado;
    private javax.swing.JButton JBTN_Salvar_Criar_Item;
    private javax.swing.JButton JBTN_Salvar_Selecionado;
    private javax.swing.JLabel JL_Item_selecionado_Pesquisa;
    private javax.swing.JLabel JL_Items_Pesquisados;
    private javax.swing.JLabel JL_Nome_Usu_Bonito;
    private javax.swing.JLabel JL_Nome_pesquisa;
    private javax.swing.JLabel JL_Nome_pesquisa1;
    private javax.swing.JLabel JL_Novo_Item_Pesquisa;
    private javax.swing.JLabel JL_Ola_Usu;
    private javax.swing.JLabel JL_Preco_Item;
    private javax.swing.JLabel JL_Preco_Item1;
    private javax.swing.JLabel JL_Tag_Pesquisa;
    private javax.swing.JLabel JL_Tag_Pesquisa_Selecionado;
    private javax.swing.JTextField JTF_Nome_Pesquisa;
    private javax.swing.JTextField JTF_Nome_Pesquisa_selecionado;
    private javax.swing.JTextField JTF_tag1;
    private javax.swing.JTextField JTF_tag1_selecionado;
    private javax.swing.JTextField JTF_tag2;
    private javax.swing.JTextField JTF_tag2_selecionado;
    private javax.swing.JTextField JTF_tag3;
    private javax.swing.JTextField JTF_tag3_selecionado;
    private javax.swing.JTextField JTF_tag4;
    private javax.swing.JTextField JTF_tag4_selecionado;
    private javax.swing.JTextField JTF_tag5;
    private javax.swing.JTextField JTF_tag5_selecionado;
    private javax.swing.JFormattedTextField JTF_tag_Preco_maximo;
    private javax.swing.JFormattedTextField JTF_tag_Preco_maximo_selecionado;
    private javax.swing.JTable JTable;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private JTextField retornaCampoTag(int i) {
        return listaTagSelecionadas.get(i);
    }

}
