/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import ModeloTabela.Cliente;
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
public class ClienteDAO {
    
    private Connection con;
    long id;
    String id_ok;
    String nome, login ,senha, email;
    
       public ClienteDAO() throws SQLException{
       this.con = new Conexao().getConnection();
    }
    
     public void adiciona(Cliente cli){
        String sql = "insert into cliente (nome, login, email, senha) values (?,?,?,?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getLogin());
            stmt.setString(3, cli.getEmail());
            stmt.setString(4, cli.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public Cliente checkLogin(String login, String senha) throws SQLException {
        con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean ok = false;
        Cliente cliente = new Cliente();
        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE login = ? AND senha = ?");

            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
             cliente.setId(rs.getInt("id"));
             cliente.setEmail(rs.getString("email"));
             cliente.setNome(rs.getString("nome"));
             cliente.setLogin(rs.getString("login"));
             cliente.setSenha(rs.getString("senha"));
                
             return cliente;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Login ou senha incorreta");
                   
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return cliente = null;
    }
      
        public List<Cliente> ler(String login) throws SQLException {
        con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> listaCliente = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE login = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cl = new Cliente();

                cl.setId(rs.getInt("id"));
               
                cl.setNome(rs.getString("nome"));
                cl.setEmail(rs.getString("email"));
                cl.setLogin(rs.getString("login"));
                cl.setSenha(rs.getString("senha"));

                listaCliente.add(cl);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return listaCliente;
    }
     
     
     
}
