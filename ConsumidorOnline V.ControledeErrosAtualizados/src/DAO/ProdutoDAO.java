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
     
      public void adiciona(Produto prod){
        String sql = "insert into produto (nome) values (?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, prod.getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public Produto pegarInfProd(int ok) {
        String sql = "select * \n"
                + "from produto\n"
                + "where produto.id = ?;";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = null;
            Produto p = new Produto();
            stmt.setInt(1, ok);
            stmt.execute();
            rs = stmt.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                return p;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
