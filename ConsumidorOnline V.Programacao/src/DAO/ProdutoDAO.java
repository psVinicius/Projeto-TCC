/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.Produto;
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
public class ProdutoDAO {
   private Connection con;
    long id;
    String nome;
   
    public ProdutoDAO() throws SQLException{
       this.con = new Conexao().getConnection();
    }
    
     public Produto recolherInfo(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto prod = new Produto();
         try {
        
        con = Conexao.getConnection();
        
        
         stmt = con.prepareStatement("SELECT * FROM produto WHERE nome = ? ");
            rs = stmt.executeQuery();

            if (rs.next()) {
             prod.setId(rs.getInt("id"));
             prod.setNome(rs.getString("nome"));
                
             return prod;
            }
        
        } catch (SQLException ex) {
             Logger.getLogger(TagDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

    return prod = null;
       
     }
}
