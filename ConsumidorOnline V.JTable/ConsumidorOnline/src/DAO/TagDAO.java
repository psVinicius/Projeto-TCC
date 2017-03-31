/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.Cliente;
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
public class TagDAO {
    
     private Connection con;
    long id;
    String nome;
    
       public TagDAO() throws SQLException{
       this.con = new Conexao().getConnection();
    }
    
     public void adiciona(Tag tag){
        String sql = "insert into tag (nome_tag) values (?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tag.getNome_tag());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Tag recolherInfo(String n){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tag tag = new Tag();
         try {
        
        con = Conexao.getConnection();
        
        
         stmt = con.prepareStatement("SELECT * FROM Tag where nome_tag = ?");
         stmt.setString(1, n);  
         rs = stmt.executeQuery();

            if (rs.next()) {
             tag.setId(rs.getInt("id"));
             tag.setNome_tag(rs.getString("nome_tag"));
                
             return tag;
            }
        
        } catch (SQLException ex) {
             Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

    return tag = null;
       
     }
     
     public Tag checkExiste(String nome){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tag tag = new Tag();
         try {
        
        con = Conexao.getConnection();
        
        
            stmt = con.prepareStatement("SELECT * FROM Tag WHERE nome_tag == ? ");
            rs = stmt.executeQuery();

            if (rs.next()) {
             tag.setId(rs.getInt("id"));
             tag.setNome_tag(rs.getString("nome_tag"));
                
             return tag;
            }
        
        } catch (SQLException ex) {
             Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

    return tag = null;
       
     }
      
     
    
    
}
