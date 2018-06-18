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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author Leonardo Faêda
 */
public class DAOFuncionario {

    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;

    

    public void listar(DefaultTableModel modelo) {
        conecta  = Conexao.conectar();
        String sql = "SELECT `codFuncionario`, `salarioFuncionaio`, "
                + "`cpfFuncionario`,"
                + " `nomeFuncionario`, "
                + "`telefoneFuncionario` FROM `funcionarios` order by codFuncionario ASC";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codFuncionario"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeFuncionario");
                dados[2] = rs.getString("salarioFuncionaio");
                dados[3] = rs.getString("cpfFuncionario");
                dados[4] = rs.getString("telefoneFuncionario");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        conecta  = Conexao.conectar();
        String Sql = "SELECT * FROM `funcionarios` where nomeFuncionario LIKE ?";
        try {
            pst = conecta.prepareStatement(Sql);
            pst.setString(1, digitado + "%");// 
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codFuncionario"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeFuncionario");
                dados[2] = rs.getString("salarioFuncionaio");
                dados[3] = rs.getString("cpfFuncionario");
                dados[4] = rs.getString("telefoneFuncionario");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void update(Funcionario f) {
        conecta  = Conexao.conectar();
        String sql = "UPDATE `funcionarios` SET "
                + "`salarioFuncionaio`=?,"
                + "`cpfFuncionario`=?,`nomeFuncionario`=?,"
                + "`telefoneFuncionario`=? WHERE codFuncionario=?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getSalarioFuncionaro());
            pst.setString(2, f.getCpfFuncionario());
            pst.setString(3, f.getNomeFuncionario());
            pst.setString(4, f.getTelefoneFuncionario());
            pst.setString(5, String.valueOf(f.getCodFuncionario()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado", "Alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void delete(String id) {
        conecta  = Conexao.conectar();
        String sql = "DELETE FROM `funcionarios` WHERE codFuncionario=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido", "Excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void insert(Funcionario f) {
        conecta  = Conexao.conectar();
        String sql = "INSERT INTO `funcionarios`"
                + "(`salarioFuncionaio`,"
                + " `cpfFuncionario`, `nomeFuncionario`,"
                + " `telefoneFuncionario`) VALUES ("
                + "?,?,?,?)";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getSalarioFuncionaro());
            pst.setString(2, f.getCpfFuncionario());
            pst.setString(3, f.getNomeFuncionario());
            pst.setString(4, f.getTelefoneFuncionario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


}
