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

    public ItemPesquisaDAO() throws SQLException {
        this.con = new Conexao().getConnection();
    }

    public void adiciona(int id, String nome, String preco) {
        String sql = "insert into itempesquisa (id_cliente, nome_pesquisa, preco) values (?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, preco);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
                ip.setId(rs.getInt("id_pesquisa"));
                ip.setPreco(rs.getString("preco"));
                return ip;

            }

        } catch (SQLException ex) {
            Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return ip = null;

    }

    public ItemPesquisa confirmaExist(int ide, String nomeP) {
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
                ip.setId(rs.getInt("id_pesquisa"));
                return ip;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return ip = null;

    }

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

                ip.setId(rs.getInt("id_pesquisa"));
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

    public ItemPesquisa retornaValoresIDPesquisaENomePesquisa(int id, String nome) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        ItemPesquisa ip = new ItemPesquisa();
        Pesquisa_Tag pt = new Pesquisa_Tag();
        Tag tag = new Tag();

        try {
            stmt = con.prepareStatement("SELECT *\n"
                    + "FROM itemPesquisa\n"
                    + "WHERE itemPesquisa.id_cliente = ? and itemPesquisa.nome_pesquisa = ?     ");
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            rs = stmt.executeQuery();

            if (rs.next()) {
                ip.setId(rs.getInt("id_pesquisa"));
                ip.setNome_pesquisa(rs.getString("nome_pesquisa"));
                ip.setPreco(rs.getString("preco"));
                return ip;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemPesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ip = null;
    }

}
