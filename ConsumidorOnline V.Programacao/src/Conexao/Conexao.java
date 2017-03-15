/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class Conexao {
        String banco = "ConsumidorOnlineTCC";
        String usuario = "root";
        String senha = "2Y7t3m.00/#//";
        
public static java.sql.Connection getConnection() throws SQLException {

        String banco = "consumidoronlinetcc";
        String usuario = "root";
        String senha = "2Y7t3m.00/#//";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + banco, usuario, senha);
            
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Não encontrou o driver"
                    + "\n" + ex.getMessage());
        }
    }

public static void closeConnetion(Connection con) {
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnetion(Connection con, PreparedStatement stmt) {
        
        closeConnetion(con);
        
        try {
            if (stmt != null) {

                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnetion(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnetion(con, stmt);
        
        
        try {
            if (rs != null) {

                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
 

    }


}        
        
        

