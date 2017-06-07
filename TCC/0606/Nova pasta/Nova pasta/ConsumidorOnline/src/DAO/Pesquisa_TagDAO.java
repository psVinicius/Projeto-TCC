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

    PreparedStatement stmt = null;
    private Connection con;
    long id_pesquisa;
    long id_tag;
    public int[] array = new int[5];

    public Pesquisa_TagDAO() throws SQLException {
        this.con = new Conexao().getConnection();
    }

    public void deleta(int id) {
        try {
            Conexao.getConnection();

            String sql = "delete pesquisa_tag.*\n"
                    + "from pesquisa_tag\n"
                    + "where pesquisa_tag.id_pesquisa = ?";
            

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
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

    public void update(int id_tagUpdate, int id_pesquisa, int id_tag) {
        String sql = "update pesquisa_tag\n"
                + "set pesquisa_tag.id_tag = ?\n"
                + "where pesquisa_tag.id_pesquisa = ? and pesquisa_tag.id_tag = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_tagUpdate);
            stmt.setInt(2, id_pesquisa);
            stmt.setInt(3, id_tag);
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Pesquisa_Tag> retornaTagsDaPesquisa(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pesquisa_Tag pt = new Pesquisa_Tag();
        ItemPesquisa ip = new ItemPesquisa();
        Tag tag = new Tag();
        ArrayList<Pesquisa_Tag> listaBonita = new ArrayList();

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

    public void zera() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public Pesquisa_Tag tags(int id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pesquisa_Tag pt = new Pesquisa_Tag();
        Tag tag = new Tag();
        zera();
        int i = -1;
        try {
            stmt = con.prepareStatement("select pesquisa_tag.id_tag from pesquisa_tag where pesquisa_tag.id_pesquisa = ? ");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                i++;
                tag.setId(rs.getInt("id_tag"));
                array[i] = tag.getId();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Pesquisa_TagDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pt;
    }

}
