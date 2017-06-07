/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Modelo.ClienteModelo;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Alves
 */
public class ClienteDAO {

    public boolean criar(ClienteModelo cm) {
        boolean ok = true;
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {

            
            stmt = con.prepareStatement("INSERT INTO cliente (nome,email,data_nasc,cpf,rg,login,senha)VALUES(?,?,?,?,?,?,?)");
            
            stmt.setString(1, cm.getNome());
            stmt.setString(2, cm.getEmail());
            stmt.setString(3, cm.getData_nasc());
            stmt.setString(4, cm.getCpf());
            stmt.setString(5, cm.getRg());
            stmt.setString(6, cm.getLogin());
            stmt.setString(7, cm.getSenha());

            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
            
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
    
    
    public boolean Atualizar(ClienteModelo cm) {
        boolean ok = true;
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;

        try {

            
  stmt = con.prepareStatement("UPDATE cliente SET nome = ?,email = ?,data_nasc = ?,cpf = ?,rg = ?,login = ?,senha = ? WHERE login = ?");
            
            stmt.setString(1, cm.getNome());
            stmt.setString(2, cm.getEmail());
            stmt.setString(3, cm.getData_nasc());
            stmt.setString(4, cm.getCpf());
            stmt.setString(5, cm.getRg());
            stmt.setString(6, cm.getLogin());
            stmt.setString(7, cm.getSenha());
            stmt.setString(8, cm.getLogin());

            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!"
                    + "\nAtualização não pode ser realizada"
                    + "\n" + ex);
            ok = false;
            

        } finally {
            Conexao.closeConnetion(con, stmt);
        }
        return ok;
    }
    
    

    public List<ClienteModelo> ler(String login) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ClienteModelo> listaCliente = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE login = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteModelo cm = new ClienteModelo();

                cm.setId(rs.getInt("id"));
                cm.setNome(rs.getString("nome"));
                cm.setEmail(rs.getString("email"));
                cm.setCpf(rs.getString("cpf"));
                cm.setRg(rs.getString("rg"));
                cm.setData_nasc(rs.getString("data_nasc"));
                cm.setLogin(rs.getString("login"));
                cm.setSenha(rs.getString("senha"));

                listaCliente.add(cm);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return listaCliente;
    }

    public boolean checkLogin(String login, String senha) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE login = ? AND senha = ?");

            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Login ou senha incorreto"
                    + "\n" + ex);
        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }

        return check;
    }

}
