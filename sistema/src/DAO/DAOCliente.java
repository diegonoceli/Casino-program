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
import model.*;

/**
 *
 * @author Leonardo Faêda
 */
public class DAOCliente {
    
    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;
    
    public void listar(DefaultTableModel modelo) {
        conecta  = Conexao.conectar();
        String sql = "SELECT `codCliente`, "
                + "`cpfCliente`,"
                + " `nomeCliente`, "
                + "`telefoneCliente` FROM `clientes` order by codCliente ASC";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codCliente"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeCliente");
                dados[2] = rs.getString("cpfCliente");
                dados[3] = rs.getString("telefoneCliente");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        conecta  = Conexao.conectar();
        String Sql = "SELECT * FROM `clientes` where nomeCliente LIKE ?";
        try {
            pst = conecta.prepareStatement(Sql);
            pst.setString(1, digitado + "%");// 
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codCliente"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeCliente");
                dados[2] = rs.getString("cpfCliente");
                dados[3] = rs.getString("telefoneCliente");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void update(Cliente f) {
        conecta  = Conexao.conectar();
        String sql = "UPDATE `clientes` SET "
                + "`cpfCliente`=?,`nomeCliente`=?,"
                + "`telefoneCliente`=? WHERE codCliente=?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getCpfCliente());
            pst.setString(2, f.getNomeCliente());
            pst.setString(3, f.getTelefoneCliente());
            pst.setString(4, String.valueOf(f.getCodCliente()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado", "Alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void delete(String id) {
        conecta  = Conexao.conectar();
        String sql = "DELETE FROM `clientes` WHERE codCliente=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido", "Excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
 
    public void salvar(Cliente c){
   
        conecta  = Conexao.conectar();
        String sql = "INSERT INTO `clientes`("
                + "`cpfCliente`, `nomeCliente`,"
                + " `telefoneCliente`) "
                + "VALUES (?,?,?)";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, c.getCpfCliente());
            pst.setString(2, c.getNomeCliente());
            pst.setString(3, c.getTelefoneCliente());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
        
    }
    
    
}
