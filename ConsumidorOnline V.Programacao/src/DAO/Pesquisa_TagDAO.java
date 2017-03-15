/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.Pesquisa_Tag;
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
public class Pesquisa_TagDAO {
    
    private Connection con;
    long id_pesquisa;
    long id_tag;
   
    public Pesquisa_TagDAO() throws SQLException{
       this.con = new Conexao().getConnection();
    }
    
     public void adiciona(Pesquisa_Tag pt){
        String sql = "insert into pesquisa_tag (id_pesquisa, id_tag) values (?,?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pt.getId_pesquisa());
            stmt.setInt(2, pt.getId_tag());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      
    
}
