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

    public void adiciona(int id, String nome) {
        String sql = "insert into itempesquisa (id_cliente, nome_pesquisa) values (?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
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
        List<Cliente> clienteL = new ArrayList<>();
        List<Tag> tagi = new ArrayList<>();

        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = con.prepareStatement("SELECT cliente.id, cliente.nome, itemPesquisa.id_pesquisa, itemPesquisa.nome_pesquisa, tag.id, tag.nome_tag\n"
                    + "FROM cliente, itempesquisa, tag, pesquisa_tag\n"
                    + "WHERE pesquisa_tag.id_pesquisa = itemPesquisa.id_pesquisa AND \n"
                    + "cliente.id = itemPesquisa.id_cliente AND \n"
                    + "pesquisa_tag.id_tag = tag.id AND cliente.id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                ItemPesquisa ip = new ItemPesquisa();
                Tag tag = new Tag();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                ip.setId(rs.getInt("id_pesquisa"));
                ip.setNome_pesquisa(rs.getString("nome_pesquisa"));
                tag.setId(rs.getInt("id"));
                tag.setNome_tag(rs.getString("nome_tag"));

                itemPesquisa.add(ip);
                clienteL.add(cliente);
                tagi.add(tag);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemPesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);

        }
        return itemPesquisa;
    }

}
