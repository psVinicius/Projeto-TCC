/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.Cliente;
import ModeloTabela.ItemPesquisa;
import ModeloTabela.Pesquisa_Tag;
import ModeloTabela.Tag;
import com.sun.javafx.image.impl.IntArgb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Alves
 */
public class ItemPesquisaDAO {

    private Connection con;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    long id;
    int id_cliente;
    String nome_pesquisa;

    public int tamnho = 0;
    public int[] idpesquisa = new int[100];

    public void zera() {
        for (int i = 0; i < idpesquisa.length; i++) {
            idpesquisa[i] = 0;
        }
    }

//conexão com o banco
    public ItemPesquisaDAO() throws SQLException {
        this.con = new Conexao().getConnection();

    }
//adiciona um novo item de pesquisa

    public void deleta(int id) {
        String sql = "delete itempesquisa.*\n"
                + "from itempesquisa\n"
                + "where itempesquisa.id_pesquisa = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void adiciona(int id, String nome, float preco) {
        String sql = "insert into itempesquisa (id_cliente, nome_pesquisa, preco) values (?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setFloat(3, preco);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePreco(float preco, int id) {
        String sql = "update itempesquisa\n"
                + "set preco = ?\n"
                + "where itempesquisa.id_pesquisa = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setFloat(1, preco);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateNome(String nome, int id) {
        String sql = "update itempesquisa\n"
                + "set nome_pesquisa = ?\n"
                + "where itempesquisa.id_pesquisa = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// recolhe id e preco do item de pesquisa com base que vc ja tenha o nome da mesma e sua id
    public ItemPesquisa recolherInfo(int ide, String nomeP) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemPesquisa ip = new ItemPesquisa();
        try {

            con = Conexao.getConnection();

            stmt = con.prepareStatement("select cliente.id, itemPesquisa.*\n"
                    + "from cliente, itemPesquisa\n"
                    + "where cliente.id = itemPesquisa.id_cliente \n"
                    + "and ((id_cliente = ?) and (itemPesquisa.nome_pesquisa = ?))");

            stmt.setInt(1, ide);
            stmt.setString(2, nomeP);
            rs = stmt.executeQuery();

            if (rs.next()) {
                ip.setId_pesquisa(rs.getInt("id_pesquisa"));
                ip.setPreco(rs.getString("preco"));
                ip.setNome_pesquisa(rs.getString("nome_pesquisa"));
                return ip;

            }

        } catch (SQLException ex) {
            Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ip = null;

    }

//lista de items pesquisados, isso eu usei, me lembro O.O
    public List<ItemPesquisa> listaItensPesquisados(int id) {

        List<ItemPesquisa> itemPesquisa = new ArrayList<>();

        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = con.prepareStatement("select itemPesquisa.*\n"
                    + "from itemPesquisa\n"
                    + "where itemPesquisa.id_cliente = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ItemPesquisa ip = new ItemPesquisa();

                ip.setId_pesquisa(rs.getInt("id_pesquisa"));
                ip.setNome_pesquisa(rs.getString("nome_pesquisa"));

                itemPesquisa.add(ip);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemPesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);

        }
        return itemPesquisa;
    }

    public ItemPesquisa tamanhoArray(int id) {

        PreparedStatement stmt = null;

        ItemPesquisa ip = new ItemPesquisa();
        ResultSet rs = null;
        int i = 0;
        try {

            con = Conexao.getConnection();

            //   stmt = con.prepareStatement(" select count(itempesquisa.id_pesquisa) from itempesquisa where itempesquisa.id_cliente = ?");
            stmt = con.prepareStatement("select * from itempesquisa where itempesquisa.id_cliente = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {

                i++;

            }
           
            this.tamnho = i;
           
        } catch (SQLException ex) {
            Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip;
    }

    public ItemPesquisa informacoes(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemPesquisa ip = new ItemPesquisa();
        try {
            con = Conexao.getConnection();

            stmt = con.prepareStatement("select * from itempesquisa where itempesquisa.id_pesquisa = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ip.setId_pesquisa(rs.getInt("id_pesquisa"));

                ip.setPreco(rs.getString("preco"));

                ip.setNome_pesquisa(rs.getString("nome_pesquisa"));

                ip.setId_cliente(rs.getInt("id_cliente"));
                return ip;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemPesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int info(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemPesquisa ip = new ItemPesquisa();
        Cliente cli = new Cliente();
        int[] array = new int[100];
        int i = -1;
        zera();
        try {

            con = Conexao.getConnection();

            stmt = con.prepareStatement("select * from itempesquisa where itempesquisa.id_cliente = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                i++;

                ip.setId_pesquisa(rs.getInt("id_pesquisa"));
                idpesquisa[i] = ip.getId_pesquisa();

                ip.setPreco(rs.getString("preco"));

                ip.setNome_pesquisa(rs.getString("nome_pesquisa"));

                ip.setId_cliente(rs.getInt("id_cliente"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }
        return array[i];
    }

}
