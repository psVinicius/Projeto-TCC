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
    String nome, login, senha, email;
//conexão com o banco    

    public ClienteDAO() throws SQLException {
        this.con = new Conexao().getConnection();
    }

    //adiciona um novo cliente    
    public void adiciona(Cliente cli) {
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

    public void update(Cliente cli) {
        String sql = "update cliente\n"
                + "set nome = ?, login = ?, senha = ?, email = ?\n"
                + "where cliente.id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getLogin());
            stmt.setString(4, cli.getEmail());
            stmt.setString(3, cli.getSenha());
            stmt.setInt(5, cli.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSenha(Cliente cli) throws SQLException {

        String sql = "UPDATE cliente SET cliente.senha = ? WHERE cliente.id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cli.getSenha());
        stmt.setInt(2, cli.getId());
        stmt.execute();
        stmt.close();

    }

    public Cliente recuperaSenha(String login) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cli = new Cliente();
        String sql = "SELECT * FROM cliente WHERE cliente.login = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);

            rs = stmt.executeQuery();

            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setEmail(rs.getString("email"));
                cli.setLogin(rs.getString("login"));
                cli.setNome(rs.getString("nome"));
                cli.setSenha(rs.getString("senha"));
                return cli;
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli = null;
    }

    //busca cliente no banco de dados baseado no login e senha, fazendo com que comprove a existência deste usuario    
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

    public Cliente checkEmai(String email) throws SQLException {
        con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean ok = false;
        Cliente cliente = new Cliente();
        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE email = ?");

            stmt.setString(1, email);

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
            System.out.println(ex);

        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }
        return cliente = null;

    }
    
    public Cliente recolheinfo(int id) throws SQLException {
        con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean ok = false;
        Cliente cliente = new Cliente();
        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE id = ?");

            stmt.setInt(1, id);

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
            System.out.println(ex);

        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }
        return cliente = null;

    }

    
    

    
    
     public Cliente checkLoginL(String Login) throws SQLException {
        con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean ok = false;
        Cliente cliente = new Cliente();
        try {

            stmt = con.prepareStatement("SELECT * FROM cliente WHERE login = ?");

            stmt.setString(1, Login);

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
            System.out.println(ex);

        } finally {
            Conexao.closeConnetion(con, stmt, rs);
        }
        return cliente = null;

    }
    //uma lista de cliente, na qual nem me lembro aonde uso     

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
