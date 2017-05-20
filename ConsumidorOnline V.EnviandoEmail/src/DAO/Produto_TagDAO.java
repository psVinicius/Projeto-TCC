/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.Pesquisa_Tag;
import ModeloTabela.Produto;
import ModeloTabela.Produto_Tag;
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
public class Produto_TagDAO {

    private Connection con;
    long id_protudo;
    long id_tag;

    public Produto_TagDAO() throws SQLException {
        this.con = new Conexao().getConnection();
    }

    public void adiciona(Produto_Tag pt) {
        String sql = "insert into produto_tag (id_produto, id_tag) values (?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pt.getId_produto());
            stmt.setInt(2, pt.getId_tag());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produto_Tag acharProduto(int ok) {
    
        String sql = "SELECT produto_tag.id_produto    \n"
                + "FROM  produto_tag\n"
                + "WHERE produto_tag.id_tag = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = null;
            Produto_Tag pt = new Produto_Tag();
            stmt.setInt(1, ok);
            stmt.execute();
            rs = stmt.executeQuery();
            if (rs.next()) {
                pt.setId_produto(rs.getInt("id_produto"));
               

                return pt;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
}
