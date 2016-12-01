/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Modelo.ClienteModelo;
import Modelo.ProdutoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class ProdutoDAO {
    
     public boolean criar(ProdutoModelo pm) {
        boolean ok = true;
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {

            
            stmt = con.prepareStatement("INSERT INTO produtos (nome, preco, id)value (?, ?, ?)");
            
            stmt.setString(1, pm.getNome());
            stmt.setDouble(2, pm.getPreco());
            stmt.setInt(3, pm.getId());
            

            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro do produto com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"
                    + "\nCadastro não pode ser realizado"
                    + "\n" + ex);
            ok = false;
            

        } finally {
            Conexao.closeConnetion(con, stmt);
        }
        return ok;
    }
    
    
   
     

    public List<ProdutoModelo> ler(String login) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ProdutoModelo> listaProduto = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT produtos.id_prod, produtos.nome, produtos.preco FROM produtos, cliente WHERE produtos.id = cliente.id and cliente.login = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoModelo pm = new ProdutoModelo();

                pm.setId_prod(rs.getInt("id_prod"));
                pm.setNome(rs.getString("nome"));
                pm.setPreco(rs.getDouble("preco"));
                

                listaProduto.add(pm);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return listaProduto;
    }
    
    
}
