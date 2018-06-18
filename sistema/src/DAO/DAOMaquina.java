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
import model.Maquina;

/**
 *
 * @author Leonardo Faêda
 */
public class DAOMaquina {
    
     Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;

    

    public void listar(DefaultTableModel modelo) {
        conecta  = Conexao.conectar();
        String sql = "SELECT `codMaquina`, `nomeMaquina`, `statusMaquina` FROM `maquinas` order by codMaquina ASC";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codMaquina"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeMaquina");
                dados[2] = rs.getString("statusMaquina");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void pesquisar(DefaultTableModel modelo, String digitado) {
        conecta  = Conexao.conectar();
        String Sql = "SELECT * FROM `maquinas` WHERE `nomeMaquina` LIKE ?";
        try {
            pst = conecta.prepareStatement(Sql);
            pst.setString(1, digitado + "%");// 
            rs = pst.executeQuery();
            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("codMaquina"); //onde "ID" é o nome da coluna no seu banco de dados 
                dados[1] = rs.getString("nomeMaquina");
                dados[2] = rs.getString("statusMaquina");
                modelo.addRow(dados); //adiciona uma nova linha em sua JTable; 
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);

        }
    }

    public void update(Maquina f) {
        conecta  = Conexao.conectar();
        String sql = "UPDATE `maquinas` SET "
                + "`nomeMaquina`=?,"
                + "`statusMaquina`=? WHERE codMaquina=?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getNomeMaquina());
            pst.setString(2, f.getStatusMaquina());
            pst.setString(3, String.valueOf(f.getCodMaquina()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado", "Alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public void delete(String id) {
        conecta  = Conexao.conectar();
        String sql = "DELETE FROM `maquinas` WHERE codMaquina=?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(id));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Excluido", "Excluido com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void insert(Maquina f) {
        conecta  = Conexao.conectar();
        String sql = "INSERT INTO `maquinas`"
                + "( `nomeMaquina`,`statusMaquina`) "
                + "VALUES"
                + " (?,?)";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getNomeMaquina());
            pst.setString(2, f.getStatusMaquina());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado", "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
    
    public void gerarRelatorio (ArrayList<Maquina> arrayMaquina){
        conecta  = Conexao.conectar();
            String sql = "SELECT `codMaquina`, `nomeMaquina`, statusMaquina FROM `maquinas` WHERE statusMaquina = 1 order by codMaquina ASC";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            Maquina m = new Maquina();
            while (rs.next()) {
                m.setCodMaquina(Integer.valueOf(rs.getString("codMaquina")));
                m.setNomeMaquina(rs.getString("nomeMaquina"));
                m.setStatusMaquina(rs.getString("statusMaquina"));
                arrayMaquina.add(m);
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
}
