/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.ItemPesquisa;
import ModeloTabela.Pesquisa_Tag;
import ModeloTabela.Tag;
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
public class Pesquisa_TagDAO {

    private Connection con;
    long id_pesquisa;
    long id_tag;

    public Pesquisa_TagDAO() throws SQLException {
        this.con = new Conexao().getConnection();
    }

    public void adiciona(int id_pesquisa, int id_tag) {
        String sql = "insert into pesquisa_tag (id_pesquisa, id_tag) values (?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_pesquisa);
            stmt.setInt(2, id_tag);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Pesquisa_Tag> retornaTagsDaPesquisa(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pesquisa_Tag pt  = new Pesquisa_Tag();
        ItemPesquisa ip = new ItemPesquisa();
        Tag tag = new Tag();
        ArrayList<Pesquisa_Tag>listaBonita = new ArrayList();
        
        
        
        try {
            stmt = con.prepareStatement("SELECT *\n"
                    + "FROM pesquisa_tag\n"
                    + "WHERE pesquisa_tag.id_pesquisa = ? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
      
                
                tag.setId(rs.getInt("id_tag"));
                pt.setId_tag(tag);
                listaBonita.add(pt);
                
                tag = new Tag();
                pt = new Pesquisa_Tag();
                
                
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemPesquisaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaBonita;
    }
}


