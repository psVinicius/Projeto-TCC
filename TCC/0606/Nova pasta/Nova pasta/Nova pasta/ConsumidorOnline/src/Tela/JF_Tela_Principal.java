/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Auxiliar.EnviarEmail;
import DAO.ClienteDAO;
import DAO.ItemPesquisaDAO;
import DAO.Pesquisa_TagDAO;
import DAO.ProdutoDAO;
import DAO.Produto_TagDAO;
import DAO.TagDAO;
import ModeloTabela.Cliente;
import ModeloTabela.ItemPesquisa;
import ModeloTabela.Pesquisa_Tag;
import ModeloTabela.Produto;
import ModeloTabela.Tag;
import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

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
    String precoinicial = "";
    String nomepesquisainicial = "";
    String[] nomeCamposESelecionado = new String[5];
    ArrayList<JTextField> listaTagSelecionadas = new ArrayList();
    boolean status = true;

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

    public void jtableVeSeEstaPreenchido() {
        JTable table = new JTable();
        int sel = table.getSelectedRow();
        boolean vazia = true;
        for (int i = 0; i < table.getColumnCount(); i++) {
            Object obj = table.getValueAt(sel, i);
            if (obj != null && obj.toString().trim().length() > 0) {
                vazia = false;
                break;
            }
        }
        if (vazia) {

        } else {
            JTable.setEnabled(true);
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
            this.id_Pesquisa = ipd.recolherInfo(this.id, nomeP).getId_pesquisa();

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean confirmaExistItemPesquisa(int id, String nomeP) {
        try {
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
            if (ipd.recolherInfo(this.id, nomeP) != null) {
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
                if (td.recolherInfo(tag1) != null) {
                    id = td.recolherInfo(tag1).getId();
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

    public void chamar_Alterar_Info_Conta() throws SQLException {
        JF_AlterarInfoConta info = new JF_AlterarInfoConta(nome, login, senha, email, id);
        info.setVisible(true);
        this.dispose();
    }

    public void enviaEmailComItemAchado(String nome, String pesquisa, String marca, double preco, String descricao, String link, String email) {
        EnviarEmail enviarmail = new EnviarEmail();

        String titulo = "Seu produto " + nome + " encontrado";
        String texto = "Encontramos seu produto, derivado da pesquisa: " + pesquisa + ". \n"
                + "Caracteristicas do item encontrado: \n"
                + "\n"
                + "Nome : " + nome + "\n"
                + "Marca: " + marca + "\n"
                + "Preco: " + preco + "\n"
                + "Descricao:\n" + descricao + "\n"
                + "Link da pagina para efetuar a compra: \n"
                + link + "\n"
                + "\n"
                + "Algum problema com o item encontrado? Insatisfeito com o serviço oferecido?\n"
                + "Entre em contado com tcccoj@gmail.com\n"
                + "\n"
                + "Agradecemos por sua preferencia pelo Consumidor Online!";

           JOptionPane.showMessageDialog(this, "Um email foi enviado para: " + email + "\n"
                + "Encontrado o item: " + nome + "\n"
                + "A pesquisa foi: " + pesquisa + "\n"
                + "O email pode demorar alguns minutos para chegar");

        enviarmail.enviarMail(email, titulo, texto);
    }

    public void procuraItemAut(int id, String email) {
        try {
            ArrayList<Integer> listaIdPesquisa = new ArrayList<Integer>();
            ArrayList<Integer> listaIdProd = new ArrayList<Integer>();

            int[] ArrayTag = new int[7];
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
            Produto_TagDAO ptd = new Produto_TagDAO();
            ProdutoDAO pd = new ProdutoDAO();
            Pesquisa_TagDAO tagdao = new Pesquisa_TagDAO();

            listaIdProd.clear();
            int i = 0;
            int contador = 0;
            ipd.info(id);

            listaIdPesquisa.clear();

            for (i = 0; i < ipd.idpesquisa.length; i++) {

                if (ipd.idpesquisa[i] == 0) {
                    break;
                }
                listaIdPesquisa.add(ipd.idpesquisa[i]);

            }

            for (i = 0; i < listaIdPesquisa.size(); i++) {
                contador = 0;

                if (ipd.informacoes(listaIdPesquisa.get(i)).isStatus() == false) {

                } else {

                    tagdao.tags(listaIdPesquisa.get(i));

                    listaIdProd.clear();

                    for (int j = 0; j < tagdao.array.length; j++) {
                        if (tagdao.array[j] == 0) {

                            break;
                        }
                        ArrayTag[j] = tagdao.array[j];

                        System.out.println("id de tag " + ArrayTag[j]);

                        contador++;

                        System.out.println("contador " + contador);
                    }
                    tagdao.zera();

                    listaIdProd = ptd.acharProduto(ArrayTag[0], ArrayTag[1], ArrayTag[2], ArrayTag[3], ArrayTag[4], contador);

                    for (int jj = 0; jj < ArrayTag.length; jj++) {
                        ArrayTag[jj] = 0;
                    }

                    for (int k = 0; k < listaIdProd.size(); k++) {

                        if (listaIdProd.get(k) == 0) {

                        } else {
                            double pesquisaPreco = Double.valueOf(ipd.informacoes(listaIdPesquisa.get(i)).getPreco());
                            double produtoPreco = pd.recolherInfo(listaIdProd.get(k)).getPreco();

                            if (pesquisaPreco == 0) {
                                enviaEmailComItemAchado(pd.recolherInfo(listaIdProd.get(k)).getNome(), ipd.informacoes(listaIdPesquisa.get(i)).getNome_pesquisa(),
                                        pd.recolherInfo(listaIdProd.get(k)).getMarca(), pd.recolherInfo(listaIdProd.get(k)).getPreco(), pd.recolherInfo(listaIdProd.get(k)).getDescricao(),
                                        pd.recolherInfo(listaIdProd.get(k)).getLink(), email);
                                System.out.println("lista id prod " + listaIdProd.get(k));

                            } else {
                                if (produtoPreco <= pesquisaPreco) {
                                    enviaEmailComItemAchado(pd.recolherInfo(listaIdProd.get(k)).getNome(), ipd.informacoes(listaIdPesquisa.get(i)).getNome_pesquisa(),
                                            pd.recolherInfo(listaIdProd.get(k)).getMarca(), pd.recolherInfo(listaIdProd.get(k)).getPreco(), pd.recolherInfo(listaIdProd.get(k)).getDescricao(),
                                            pd.recolherInfo(listaIdProd.get(k)).getLink(), email);
                                    System.out.println("lista id prod " + listaIdProd.get(k));

                                } else {

                                }
                            }
                        }

                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JF_Tela_Principal(String nome, String senha, String login, String email, int id) {
        initComponents();

        setExtendedState(JF_Tela_Principal.MAXIMIZED_BOTH);
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
        jtableVeSeEstaPreenchido();

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
                    ip.getId_pesquisa()

                });

            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
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

    public boolean checkTagExiste(String nome) throws SQLException {
        TagDAO tag = new TagDAO();
        if (tag.recolherInfo(nome) != null) {
            return true;
        }
        return false;
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
        JTF_tag_Preco_maximo = new javax.swing.JTextField();
        JTF_tag_Preco_maximo_selecionado = new javax.swing.JTextField();
        jbtnEncontrarItem = new javax.swing.JButton();
        JBTN_Deletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRB_ContinuarPesquisa = new javax.swing.JRadioButton();
        jRB_PausarrPesquisa = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JL_Ola_Usu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JL_Ola_Usu.setText("OLÁ");
        getContentPane().add(JL_Ola_Usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        JL_Nome_Usu_Bonito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JL_Nome_Usu_Bonito.setText("VINICIUS");
        getContentPane().add(JL_Nome_Usu_Bonito, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 11, -1, -1));

        JL_Novo_Item_Pesquisa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Novo_Item_Pesquisa.setText("NOVO ITEM DE PESQUISA");
        getContentPane().add(JL_Novo_Item_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));

        JL_Tag_Pesquisa.setText("TAGS DE PESQUISA");
        getContentPane().add(JL_Tag_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 107, -1, -1));

        JL_Nome_pesquisa.setText("NOME DA PESQUISA");
        getContentPane().add(JL_Nome_pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 357, -1, -1));
        getContentPane().add(JTF_tag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 225, -1));
        getContentPane().add(JTF_tag2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 225, -1));
        getContentPane().add(JTF_tag3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, 224, -1));
        getContentPane().add(JTF_tag4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 239, 224, -1));
        getContentPane().add(JTF_tag5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 224, -1));

        JBTN_Salvar_Criar_Item.setText("Salvar");
        JBTN_Salvar_Criar_Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_Salvar_Criar_ItemActionPerformed(evt);
            }
        });
        getContentPane().add(JBTN_Salvar_Criar_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 420, 71, -1));

        JBTN_Cancelar_Criar_item.setText("Cancelar");
        JBTN_Cancelar_Criar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_Cancelar_Criar_itemActionPerformed(evt);
            }
        });
        getContentPane().add(JBTN_Cancelar_Criar_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 420, -1, -1));

        JL_Preco_Item.setText("PRECO MAXIMO DO ITEM");
        getContentPane().add(JL_Preco_Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 306, -1, -1));

        JTF_Nome_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Nome_PesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(JTF_Nome_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 382, 224, -1));

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
        JTable.setSelectionBackground(new java.awt.Color(51, 0, 255));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 107, -1, 419));

        JL_Items_Pesquisados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Items_Pesquisados.setText("ITEM DE PESQUISA");
        getContentPane().add(JL_Items_Pesquisados, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 67, -1, -1));

        JL_Nome_pesquisa1.setText("NOME DA PESQUISA");
        getContentPane().add(JL_Nome_pesquisa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(949, 375, -1, -1));

        JL_Tag_Pesquisa_Selecionado.setText("TAGS DE PESQUISA DO ITEM SELECIONADO");
        getContentPane().add(JL_Tag_Pesquisa_Selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(894, 110, -1, -1));

        JTF_Nome_Pesquisa_selecionado.setEditable(false);
        JTF_Nome_Pesquisa_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTF_Nome_Pesquisa_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Nome_Pesquisa_selecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(JTF_Nome_Pesquisa_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 400, 233, -1));

        JL_Preco_Item1.setText("PRECO MAXIMO DO ITEM");
        getContentPane().add(JL_Preco_Item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(938, 321, -1, -1));

        JBTN_Cancelar_Selecionado.setText("Cancelar");
        JBTN_Cancelar_Selecionado.setEnabled(false);
        JBTN_Cancelar_Selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_Cancelar_SelecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(JBTN_Cancelar_Selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 480, -1, -1));

        JL_Item_selecionado_Pesquisa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JL_Item_selecionado_Pesquisa.setText("ITEM DA PESQUISA");
        getContentPane().add(JL_Item_selecionado_Pesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(917, 67, 269, -1));

        JBTN_Salvar_Selecionado.setText("Salvar");
        JBTN_Salvar_Selecionado.setEnabled(false);
        JBTN_Salvar_Selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_Salvar_SelecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(JBTN_Salvar_Selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 480, 71, -1));

        JTF_tag2_selecionado.setEditable(false);
        JTF_tag2_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_tag2_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 168, 233, -1));

        JTF_tag3_selecionado.setEditable(false);
        JTF_tag3_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_tag3_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 209, 233, -1));

        JTF_tag4_selecionado.setEditable(false);
        JTF_tag4_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_tag4_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 248, 233, -1));

        JTF_tag5_selecionado.setEditable(false);
        JTF_tag5_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(JTF_tag5_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 282, 233, -1));

        JTF_tag1_selecionado.setEditable(false);
        JTF_tag1_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTF_tag1_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_tag1_selecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(JTF_tag1_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 127, 233, -1));

        JBTN_Editar_Selecionado.setText("Editar");
        JBTN_Editar_Selecionado.setEnabled(false);
        JBTN_Editar_Selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_Editar_SelecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(JBTN_Editar_Selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 71, -1));
        getContentPane().add(JTF_tag_Preco_maximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 331, 224, -1));

        JTF_tag_Preco_maximo_selecionado.setEditable(false);
        JTF_tag_Preco_maximo_selecionado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JTF_tag_Preco_maximo_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_tag_Preco_maximo_selecionadoActionPerformed(evt);
            }
        });
        getContentPane().add(JTF_tag_Preco_maximo_selecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 341, 233, -1));

        jbtnEncontrarItem.setText("Fazer Pesquisa Agora");
        jbtnEncontrarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEncontrarItemMouseClicked(evt);
            }
        });
        jbtnEncontrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEncontrarItemActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnEncontrarItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 535, 255, -1));

        JBTN_Deletar.setText("Deletar");
        JBTN_Deletar.setEnabled(false);
        JBTN_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_DeletarActionPerformed(evt);
            }
        });
        getContentPane().add(JBTN_Deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 250, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("CONTINUAR PESQUISA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 429, -1, -1));

        jRB_ContinuarPesquisa.setText("Continuar");
        jRB_ContinuarPesquisa.setEnabled(false);
        jRB_ContinuarPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_ContinuarPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_ContinuarPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, -1, -1));

        jRB_PausarrPesquisa.setText("Pausar");
        jRB_PausarrPesquisa.setEnabled(false);
        jRB_PausarrPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_PausarrPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_PausarrPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 450, -1, -1));

        jMenu2.setText("MENU");

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Ajuda");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("ALTERAR INFORMACOES DA CONTA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("SAIR");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        try {
            chamar_Alterar_Info_Conta();

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void JTF_Nome_Pesquisa_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Nome_Pesquisa_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_Nome_Pesquisa_selecionadoActionPerformed

    private void JBTN_Salvar_Criar_ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_Salvar_Criar_ItemActionPerformed
//variaveis que recebem os textos (tags)
        try {
            ItemPesquisaDAO ipd2 = new ItemPesquisaDAO();
            ItemPesquisa ip2 = new ItemPesquisa();
            Tag tag = new Tag();
            TagDAO td = new TagDAO();
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();
            ItemPesquisa ip = new ItemPesquisa();

            String tag1 = JTF_tag1.getText().toUpperCase();
            String tag2 = JTF_tag2.getText().toUpperCase();
            String tag3 = JTF_tag3.getText().toUpperCase();
            String tag4 = JTF_tag4.getText().toUpperCase();
            String tag5 = JTF_tag5.getText().toUpperCase();
            float preco = 0;
            String tagAr[] = new String[5];
            int tagID[] = new int[5];
            int i = 0;
            int ok = 0;
            String nome_pesquisa = JTF_Nome_Pesquisa.getText();
            Cliente cliente = new Cliente();
            //estou inicizaliando o id do cliente colocando o id do usuario atual
            cliente.setId(this.id);
            //validando o preco, se tiver vazia, a pariavel preco ja inicalizou com 0, se tiver com alguma coisa, ela recebe o
            //que tiver dentro do texto e ja converte para float
            if (JTF_tag_Preco_maximo.getText().isEmpty()) {
            } else {
                preco = Float.valueOf(JTF_tag_Preco_maximo.getText());
            }
//colocando todos os campos em null
            for (i = 0; i < tagAr.length; i++) {
                tagAr[i] = null;
            }

            //colocando todos os campos em 0
            for (i = 0; i < tagAr.length; i++) {
                tagID[i] = 0;
            }

            boolean validar = false;

            //validando os campos de tags
            if (tag1.isEmpty()) {

            } else {
                validar = true;
                tag1.toUpperCase();
                tagAr[0] = tag1;

            }

            if (tag2.isEmpty()) {

            } else {
                validar = true;
                tag2.toUpperCase();
                tagAr[1] = tag2;

            }

            if (tag3.isEmpty()) {
            } else {
                validar = true;
                tag3.toUpperCase();
                tagAr[2] = tag3;

            }

            if (tag4.isEmpty()) {
            } else {
                validar = true;
                tag4.toUpperCase();
                tagAr[3] = tag4;

            }

            if (tag5.isEmpty()) {
            } else {
                validar = true;
                tag5.toUpperCase();
                tagAr[4] = tag5;

            }
            if (preco == 0) {

            } else {

            }
            //fim da validaçao das tags

            //validando se alguma tag foi colocada ou preco
            if (validar == false) {
                JOptionPane.showMessageDialog(null, "Campos em branco", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                if (nome_pesquisa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome de pesquisa é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);

                } else {
                    //checando se o nome da pesquisa esse usuario atual ja utiliza
                    //o método em questão ja da a mensagem de erro, por isso aqui não tem um if else
                    if (confirmaExistItemPesquisa(this.id, nome_pesquisa) == true) {

                        //estou colocando dentro do item_pesquisa o nome da pesquisa
                        ip.setNome_pesquisa(nome_pesquisa);
                        //estou colocando o cliente dentro do cliente de item_pesquisa 
                        ip.setId_cliente(this.id);
                        //estou adicionando o item_pesquisa com os 3 parametros dele
                        ipd.adiciona(this.id, nome_pesquisa, preco, true);
                        //tirando informações do itemPesquisa baseado no id do usuario e o nome da pesquisa
                        recolherInfoItemPesquisa(this.id, nome_pesquisa);

                        //agora estou percorrendo pela variavel tagAr para ver os nomes de tag
                        //quando chegar num resultado nulo, o for para;
                        for (i = 0; i < tagAr.length; i++) {
                            if (tagAr[i] == null) {

                                break;

                            } else {
                                if (checkTagExiste(tagAr[i]) == true) {

                                    for (int j = 0; j < tagID.length; j++) {
                                        if (tagID[j] == 0) {
                                            tagID[j] = td.recolherInfo(tagAr[i]).getId();
                                            adiconaPesquisaTAg(this.id_Pesquisa, tagID[j]);

                                            break;
                                        }
                                    }

                                } else {
                                    tag.setNome_tag(tagAr[i]);
                                    td.adiciona(tag);
                                    recolherInfoTag(tagAr[i]);

                                    for (int c = 0; c < this.id_tag.length; c++) {
                                        if (this.id_tag[c] > 0) {

                                            adiconaPesquisaTAg(this.id_Pesquisa, this.id_tag[c]);
                                            break;
                                        }
                                    }
                                }

                                //estou checando se a tag ja existe, se ela existir, ja cadastro a tag dentro da pesquisa
                                //caso contrario faço o processo todo de adicionar a tag
                            }
                        }

                        JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                        //adiciona no jTable
                        listaJTable(this.id);

                        //iniciliza faz com que a variavel id_tag[] tenha seus slots todos zerados ou nulos novamente
                        inicaliza();
                        JTF_tag1.setText("");
                        JTF_tag2.setText("");
                        JTF_tag3.setText("");
                        JTF_tag4.setText("");
                        JTF_tag5.setText("");
                        JTF_tag_Preco_maximo.setText("");
                        JTF_Nome_Pesquisa.setText("");

                        for (i = 0; i < tagID.length; i++) {
                            tagID[i] = 0;
                        }
                        for (i = 0; i < tagAr.length; i++) {
                            tagAr[i] = null;

                        }

                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBTN_Salvar_Criar_ItemActionPerformed

    private void JTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTableFocusGained


    }//GEN-LAST:event_JTableFocusGained

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        jtableVeSeEstaPreenchido();
        if (JTable.isEnabled() == false) {

        } else {
            JBTN_Editar_Selecionado.setEnabled(true);
            JBTN_Deletar.setEnabled(true);
        }

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
            boolean status = true;

            descobreLinha();
            JTF_Nome_Pesquisa_selecionado.setText(this.nome_pesquisaJTable);
            retornaObjetoJTable();

            id = ipd.recolherInfo(this.id, this.nome_pesquisaJTable).getId_pesquisa();

            preco = ipd.recolherInfo(this.id, this.nome_pesquisaJTable).getPreco();

            status = ipd.recolherInfo(this.id, this.nome_pesquisaJTable).isStatus();

            this.id_Pesquisa = id;
            JTF_tag_Preco_maximo_selecionado.setText(preco);

            if (status == true) {
                jRB_ContinuarPesquisa.setSelected(true);
                jRB_PausarrPesquisa.setSelected(false);
            } else {
                jRB_PausarrPesquisa.setSelected(true);
                jRB_ContinuarPesquisa.setSelected(false);
            }

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
            Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_JTableMouseClicked

    private void JTF_Nome_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Nome_PesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_Nome_PesquisaActionPerformed

    private void JTF_tag_Preco_maximo_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_tag_Preco_maximo_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_tag_Preco_maximo_selecionadoActionPerformed

    private void jbtnEncontrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEncontrarItemActionPerformed

        procuraItemAut(this.id, this.email);

    }//GEN-LAST:event_jbtnEncontrarItemActionPerformed

    private void jbtnEncontrarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEncontrarItemMouseClicked


    }//GEN-LAST:event_jbtnEncontrarItemMouseClicked

    private void JBTN_Cancelar_Criar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_Cancelar_Criar_itemActionPerformed

        JTF_tag1.setText("");
        JTF_tag2.setText("");
        JTF_tag3.setText("");
        JTF_tag4.setText("");
        JTF_tag5.setText("");
        JTF_tag_Preco_maximo.setText("");
        JTF_Nome_Pesquisa.setText("");

    }//GEN-LAST:event_JBTN_Cancelar_Criar_itemActionPerformed

    private void JBTN_Editar_SelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_Editar_SelecionadoActionPerformed
        if (JTF_Nome_Pesquisa_selecionado.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nenhuma pesquisa foi selecionada", "Erro", JOptionPane.ERROR_MESSAGE, null);
        } else {
            JTF_tag1.setEditable(false);
            JTF_tag2.setEditable(false);
            JTF_tag3.setEditable(false);
            JTF_tag4.setEditable(false);
            JTF_tag5.setEditable(false);
            JTF_tag_Preco_maximo.setEditable(false);
            JTF_Nome_Pesquisa.setEditable(false);

            if (jRB_ContinuarPesquisa.isSelected()) {
                this.status = true;
            } else {
                this.status = false;
            }

            JBTN_Salvar_Criar_Item.setEnabled(false);
            JBTN_Cancelar_Criar_item.setEnabled(false);
            JTable.setEnabled(false);
            JBTN_Salvar_Selecionado.setEnabled(true);
            JBTN_Cancelar_Selecionado.setEnabled(true);
            JBTN_Editar_Selecionado.setEnabled(false);
            JBTN_Deletar.setEnabled(false);

            jRB_ContinuarPesquisa.setEnabled(true);
            jRB_PausarrPesquisa.setEnabled(true);

            this.nomeCamposESelecionado[0] = JTF_tag1_selecionado.getText().toUpperCase();
            this.nomeCamposESelecionado[1] = JTF_tag2_selecionado.getText().toUpperCase();
            this.nomeCamposESelecionado[2] = JTF_tag3_selecionado.getText().toUpperCase();
            this.nomeCamposESelecionado[3] = JTF_tag4_selecionado.getText().toUpperCase();
            this.nomeCamposESelecionado[4] = JTF_tag5_selecionado.getText().toUpperCase();
            this.precoinicial = JTF_tag_Preco_maximo_selecionado.getText();
            this.nomepesquisainicial = JTF_Nome_Pesquisa_selecionado.getText();

            JTF_tag1_selecionado.setEditable(true);
            JTF_tag2_selecionado.setEditable(true);
            JTF_tag3_selecionado.setEditable(true);
            JTF_tag4_selecionado.setEditable(true);
            JTF_tag5_selecionado.setEditable(true);
            JTF_tag_Preco_maximo_selecionado.setEditable(true);
            JTF_Nome_Pesquisa_selecionado.setEditable(true);
        }

    }//GEN-LAST:event_JBTN_Editar_SelecionadoActionPerformed

    private void JBTN_Salvar_SelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_Salvar_SelecionadoActionPerformed

        String[] tags = new String[5];
        int idTag = 0;
        int idTagUp = 0;
        String nome_pesquisa = null;
        float preco = 0;
        int opcao = 0;
        boolean status = true;

        Object[] options = {"Confirmar", "Cancelar"};

        opcao = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (opcao == 1) {

        }
        if (opcao == -1) {

        }
        if (opcao == 0) {
            try {
                TagDAO tagd;

                tagd = new TagDAO();

                Tag tag = new Tag();

                if (jRB_ContinuarPesquisa.isSelected()) {
                    status = true;
                } else {
                    status = false;

                }

                ItemPesquisaDAO ipd = new ItemPesquisaDAO();
                Pesquisa_TagDAO ptd = new Pesquisa_TagDAO();

                for (int i = 0; i < tags.length; i++) {
                    tags[i] = "";
                }

                if (JTF_tag1_selecionado.getText().isEmpty()) {

                } else {
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i].equals("")) {
                            tags[i] = JTF_tag1_selecionado.getText().toUpperCase();
                            break;
                        }
                    }
                }

                if (JTF_tag2_selecionado.getText().isEmpty()) {

                } else {
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i].equals("")) {
                            tags[i] = JTF_tag2_selecionado.getText().toUpperCase();
                            break;
                        }
                    }
                }
                if (JTF_tag3_selecionado.getText().isEmpty()) {

                } else {
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i].equals("")) {
                            tags[i] = JTF_tag3_selecionado.getText().toUpperCase();
                            break;
                        }
                    }
                }
                if (JTF_tag4_selecionado.getText().isEmpty()) {

                } else {
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i].equals("")) {
                            tags[i] = JTF_tag4_selecionado.getText().toUpperCase();
                            break;
                        }
                    }
                }
                if (JTF_tag5_selecionado.getText().isEmpty()) {

                } else {
                    for (int i = 0; i < tags.length; i++) {
                        if (tags[i].equals("")) {
                            tags[i] = JTF_tag5_selecionado.getText().toUpperCase();
                            break;
                        }
                    }
                }

                preco = Float.valueOf(JTF_tag_Preco_maximo_selecionado.getText());
                nome_pesquisa = JTF_Nome_Pesquisa_selecionado.getText();

                for (int i = 0; i < tags.length; i++) {

                    if (tags[i].equals("")) {
                        break;

                    } else {

                        if (tagd.recolherInfo(tags[i]) == null) {
                            tag.setNome_tag(tags[i]);

                            tagd.adiciona(tag);

                            idTag = tagd.recolherInfo(tags[i]).getId();

                            if (this.nomeCamposESelecionado[i].isEmpty()) {
                                ptd.adiciona(this.id_Pesquisa, idTag);

                            } else {
                                idTagUp = tagd.recolherInfo(this.nomeCamposESelecionado[i]).getId();

                                ptd.update(idTag, this.id_Pesquisa, idTagUp);

                                ipd.updatePreco(preco, this.id_Pesquisa);

                                ipd.updateNome(nome_pesquisa, this.id_Pesquisa);
                              
                                ipd.updateStatus(status, this.id_Pesquisa);
                            }
                        } else {

                            idTag = tagd.recolherInfo(tags[i]).getId();

                            if (this.nomeCamposESelecionado[i].isEmpty()) {
                                ptd.adiciona(this.id_Pesquisa, idTag);

                            } else {
                                idTagUp = tagd.recolherInfo(this.nomeCamposESelecionado[i]).getId();

                                ptd.update(idTag, this.id_Pesquisa, idTagUp);

                                ipd.updatePreco(preco, this.id_Pesquisa);

                                ipd.updateNome(nome_pesquisa, this.id_Pesquisa);
                                ipd.updateStatus(status, this.id_Pesquisa);
                            }
                        }
                    }

                }
                JBTN_Deletar.setEnabled(true);
                JBTN_Salvar_Criar_Item.setEnabled(true);
                JBTN_Cancelar_Criar_item.setEnabled(true);
                JTF_tag1.setEditable(true);
                JTF_tag2.setEditable(true);
                JTF_tag3.setEditable(true);
                JTF_tag4.setEditable(true);
                JTF_tag_Preco_maximo.setEditable(true);
                JTF_Nome_Pesquisa.setEditable(true);
                JTF_tag5.setEditable(true);
                JTF_tag1_selecionado.setEditable(false);
                JTF_tag2_selecionado.setEditable(false);
                JTF_tag3_selecionado.setEditable(false);
                JTF_tag4_selecionado.setEditable(false);
                JTF_tag5_selecionado.setEditable(false);
                JTF_tag_Preco_maximo_selecionado.setEditable(false);
                JTF_Nome_Pesquisa_selecionado.setEditable(false);
                listaJTable(this.id);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                JBTN_Salvar_Criar_Item.setEnabled(true);
                JBTN_Cancelar_Criar_item.setEnabled(true);
                JTable.setEnabled(true);
                JBTN_Salvar_Selecionado.setEnabled(false);

                jRB_ContinuarPesquisa.setEnabled(false);
                jRB_PausarrPesquisa.setEnabled(false);

                JBTN_Cancelar_Selecionado.setEnabled(false);
                JBTN_Editar_Selecionado.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(JF_Tela_Principal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JBTN_Salvar_SelecionadoActionPerformed


    private void JBTN_Cancelar_SelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_Cancelar_SelecionadoActionPerformed
        Object[] options = {"Confirmar", "Cancelar"};
        int opcao = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcao == 1) {

        }
        if (opcao == -1) {

        }
        if (opcao == 0) {
            JBTN_Deletar.setEnabled(true);
            JBTN_Salvar_Selecionado.setEnabled(false);
            JBTN_Cancelar_Selecionado.setEnabled(false);
            JBTN_Editar_Selecionado.setEnabled(true);
            JTF_tag1.setEditable(true);
            JTF_tag2.setEditable(true);
            JTF_tag3.setEditable(true);
            JTF_tag4.setEditable(true);
            JTF_tag5.setEditable(true);
            JTF_tag_Preco_maximo.setEditable(true);
            JTF_Nome_Pesquisa.setEditable(true);
            JTF_tag1_selecionado.setText(nomeCamposESelecionado[0]);
            JTF_tag2_selecionado.setText(nomeCamposESelecionado[1]);
            JTF_tag3_selecionado.setText(nomeCamposESelecionado[2]);
            JTF_tag4_selecionado.setText(nomeCamposESelecionado[3]);
            JTF_tag5_selecionado.setText(nomeCamposESelecionado[4]);
            JTF_tag_Preco_maximo_selecionado.setText(this.precoinicial);
            JTF_Nome_Pesquisa_selecionado.setText(nomepesquisainicial);
            JBTN_Salvar_Criar_Item.setEnabled(true);
            JBTN_Cancelar_Criar_item.setEnabled(true);
            JTF_tag1_selecionado.setEditable(false);
            JTF_tag2_selecionado.setEditable(false);
            JTF_tag3_selecionado.setEditable(false);
            JTF_tag4_selecionado.setEditable(false);
            JTF_tag5_selecionado.setEditable(false);

            if (this.status == true) {
                jRB_ContinuarPesquisa.setSelected(true);
                jRB_PausarrPesquisa.setSelected(false);
            } else {
                jRB_PausarrPesquisa.setSelected(true);
                jRB_ContinuarPesquisa.setSelected(false);
            }

            jRB_ContinuarPesquisa.setEnabled(false);
            jRB_PausarrPesquisa.setEnabled(false);

            JTF_tag_Preco_maximo_selecionado.setEditable(false);
            JTF_Nome_Pesquisa_selecionado.setEditable(false);
            JTable.setEnabled(true);

        }

    }//GEN-LAST:event_JBTN_Cancelar_SelecionadoActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JF_Login_CriarConta lc = new JF_Login_CriarConta();
        lc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JBTN_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_DeletarActionPerformed

        try {
            String nomePesquisa = JTF_Nome_Pesquisa_selecionado.getText();
            int idPes = 0;

            Pesquisa_TagDAO ptd = new Pesquisa_TagDAO();
            ItemPesquisaDAO ipd = new ItemPesquisaDAO();

            Object[] options = {"Confirmar", "Cancelar"};
            int opcao = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (opcao == 0) {
                idPes = ipd.recolherInfo(this.id, nomePesquisa).getId_pesquisa();

                ptd.deleta(idPes);
                ipd.deleta(idPes);
                JOptionPane.showMessageDialog(this, "Deletado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                listaJTable(this.id);

                JTF_Nome_Pesquisa_selecionado.setText("");
                JTF_tag1_selecionado.setText("");
                JTF_tag2_selecionado.setText("");
                JTF_tag3_selecionado.setText("");
                JTF_tag4_selecionado.setText("");
                JTF_tag5_selecionado.setText("");
                JTF_tag_Preco_maximo_selecionado.setText("");
                JBTN_Editar_Selecionado.setEnabled(false);

            }
            if (opcao == 1) {

            }
            if (opcao == -1) {

            }

        } catch (SQLException ex) {
            Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_JBTN_DeletarActionPerformed

    private void JTF_tag1_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_tag1_selecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_tag1_selecionadoActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed

        JF_Ajuda ajuda = new JF_Ajuda();
        ajuda.setVisible(true);

    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jRB_PausarrPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_PausarrPesquisaActionPerformed

        if (jRB_PausarrPesquisa.isSelected()) {
            jRB_ContinuarPesquisa.setSelected(false);
        }

    }//GEN-LAST:event_jRB_PausarrPesquisaActionPerformed

    private void jRB_ContinuarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_ContinuarPesquisaActionPerformed
        // TODO add your handling code here:]
        if (jRB_ContinuarPesquisa.isSelected()) {
            jRB_PausarrPesquisa.setSelected(false);
        }

    }//GEN-LAST:event_jRB_ContinuarPesquisaActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Tela_Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton JBTN_Deletar;
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
    private javax.swing.JTextField JTF_tag_Preco_maximo;
    private javax.swing.JTextField JTF_tag_Preco_maximo_selecionado;
    private javax.swing.JTable JTable;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JRadioButton jRB_ContinuarPesquisa;
    private javax.swing.JRadioButton jRB_PausarrPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEncontrarItem;
    // End of variables declaration//GEN-END:variables

    private JTextField retornaCampoTag(int i) {
        return listaTagSelecionadas.get(i);
    }

}
