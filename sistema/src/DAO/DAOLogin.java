/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Login;

/**
 *
 * @author Leonardo Faêda
 */
public class DAOLogin {
    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;
    
    public void listar(DefaultTableModel modelo) {
        conecta  = Conexao.conectar();
        String sql = "SELECT `codAcesso`, "
                + "`nome`,"
                + " `login`, "
                + " `senha`, "
                    + "`tipoAcesso` FROM `acesso` order by codAcesso ASC";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codAcesso"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nome");
                dados[2] = rs.getString("login");
                dados[3] = rs.getString("senha");
                dados[4] = rs.getString("tipoAcesso");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        conecta  = Conexao.conectar();
        String Sql = "SELECT * FROM `acesso` where nome LIKE ?";
        try {
            pst = conecta.prepareStatement(Sql);
            pst.setString(1, digitado + "%");// 
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codAcesso"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nome");
                dados[2] = rs.getString("login");
                dados[3] = rs.getString("senha");
                dados[4] = rs.getString("tipoAcesso");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void update(Login f) {
        conecta  = Conexao.conectar();
        String sql = "UPDATE `acesso` SET "
                + "`nome`=?,`login`=?,"
                + "`senha`=?,"
                + "`tipoAcesso`=? WHERE codAcesso=?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getNomeLogin());
            pst.setString(2, f.getLogin());
            pst.setString(3, f.getSenhaLogin());
            pst.setString(4, f.getNivel());
            pst.setString(5, String.valueOf(f.getCodLogin()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado", "Alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void delete(String id) {
        conecta  = Conexao.conectar();
        String sql = "DELETE FROM `acesso` WHERE codAcesso=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido", "Excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
 
    public void salvar(Login c){
   
        conecta  = Conexao.conectar();
        String sql = "INSERT INTO `acesso`("
                + "`nome`, `login`, `senha`,"
                + " `tipoAcesso`) "
                + "VALUES (?,?,?,?)";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, c.getNomeLogin());
            pst.setString(2, c.getLogin());
            pst.setString(3, c.getSenhaLogin());
            pst.setString(4, c.getNivel());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
        
    }
}
