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
import java.util.ArrayList;
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
    public int idprod[] = new int[90000];

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

    public ArrayList<Integer> acharProduto(int tag1, int tag2, int tag3, int tag4, int tag5, int numTag) {
        int i = -1;
        ArrayList<Integer>listaidprod = new ArrayList<Integer>();

        Produto_Tag pt = new Produto_Tag();
        String sql = "select produto_tag.id_produto from produto_tag where produto_tag.id_tag = ? or produto_tag.id_tag = ?\n"
                + "or produto_tag.id_tag = ? or produto_tag.id_tag = ?\n"
                + "or produto_tag.id_tag = ?\n"
                + "group by (produto_tag.id_produto) having count(*) >= ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = null;

            stmt.setInt(1, tag1);
            stmt.setInt(2, tag2);
            stmt.setInt(3, tag3);
            stmt.setInt(4, tag4);
            stmt.setInt(5, tag5);
            stmt.setInt(6, numTag);

            rs = stmt.executeQuery();

           
            while (rs.next()) {
               i++;
               
                pt.setId_produto(rs.getInt("id_produto"));

              listaidprod.add(pt.getId_produto());
               

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaidprod;
    }

}
