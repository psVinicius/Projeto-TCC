/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.ItemPesquisa;
import ModeloTabela.Tag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Alves
 */
public class ItemPesquisaDAO {

    private Connection con;
    long id;
    int id_cliente;
    String nome_pesquisa;

    public ItemPesquisaDAO() throws SQLException {
        this.con = new Conexao().getConnection();
    }

    public void adiciona(ItemPesquisa ip) {
        String sql = "insert into itempesquisa (id_cliente, nome_pesquisa) values (?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, ip.getCliente().getId());
            stmt.setString(2, ip.getNome_pesquisa());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ItemPesquisa recolherInfo() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ItemPesquisa pt = new ItemPesquisa();
        try {

            con = Conexao.getConnection();

            stmt = con.prepareStatement("SELECT * FROM itemPesquisa WHERE id_cliente = ? ");
            rs = stmt.executeQuery();

            if (rs.next()) {
                pt.setId(rs.getInt("id"));
               
                pt.setNome_pesquisa(rs.getString("nome_pesquisa"));

                return pt;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return pt = null;

    }

}
