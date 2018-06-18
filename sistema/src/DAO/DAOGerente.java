/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
/**
 *
 * @author Leonardo Faêda
 */
public class DAOGerente {
    
    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;

    

    public void listar(DefaultTableModel modelo) {
        conecta  = Conexao.conectar();
        String sql = "SELECT `codGerente`, `salarioGerente`, "
                + "`cpfGerente`, `nomeGerente`, "
                + "`telefoneGerente` FROM `gerentes` order by codGerente ASC";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codGerente"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeGerente");
                dados[2] = rs.getString("salarioGerente");
                dados[3] = rs.getString("cpfGerente");
                dados[4] = rs.getString("telefoneGerente");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        conecta  = Conexao.conectar();
        String Sql = "SELECT * FROM `gerentes` where nomeGerente LIKE ?";
        try {
            pst = conecta.prepareStatement(Sql);
            pst.setString(1, digitado + "%");// 
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codGerente"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeGerente");
                dados[2] = rs.getString("salarioGerente");
                dados[3] = rs.getString("cpfGerente");
                dados[4] = rs.getString("telefoneGerente");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void update(Gerente f) {
        conecta  = Conexao.conectar();
        String sql = "UPDATE `gerentes` SET "
                + "`salarioGerente`=?,"
                + "`cpfGerente`=?,`nomeGerente`=?,"
                + "`telefoneGerente`=? WHERE codGerente=?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getSalarioGerente());
            pst.setString(2, f.getCpfGerente());
            pst.setString(3, f.getNomeGerente());
            pst.setString(4, f.getTelefoneGerente());
            pst.setString(5, String.valueOf(f.getCodGerente()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado", "Alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void delete(String id) {
        conecta  = Conexao.conectar();
        String sql = "DELETE FROM `gerentes` WHERE codGerente=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido", "Excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

   
    public void salvar(Gerente gerente){
        conecta  = Conexao.conectar();
        
        String sql = "INSERT INTO `gerentes`(`salarioGerente`, `cpfGerente`, `nomeGerente`, `telefoneGerente`) VALUES"
                + "(?,?,?,?)";
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, gerente.getSalarioGerente());
            pst.setString(2, gerente.getCpfGerente());
            pst.setString(3, gerente.getNomeGerente());
            pst.setString(4, gerente.getTelefoneGerente());
            pst.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao incluir gerente: " + e);
        }finally{
            try{
                JOptionPane.showMessageDialog(null, "Gerente incluído com sucesso.");
                             
            }catch(Throwable e){
                JOptionPane.showMessageDialog(null, "Erro ao encerrar conexão: " + e);
            }
        }
    }

  
}
