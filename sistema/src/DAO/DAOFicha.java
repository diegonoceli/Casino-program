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
import model.Ficha;

/**
 *
 * @author Leonardo Faêda
 */
public class DAOFicha {

    Connection conecta = Conexao.conectar();
    PreparedStatement pst;
    ResultSet rs;

    public void listar(ArrayList<String> preco) {
        conecta = Conexao.conectar();
        String sql = "SELECT `codFicha`, `precoFicha` FROM `ficha`";
        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                //System.out.println(rs.getString("precoFicha"));
                preco.add(rs.getString("precoFicha"));
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
     public void update(Ficha f) {
        conecta  = Conexao.conectar();
        String sql = "UPDATE `ficha` SET `precoFicha`=? WHERE codFicha=1";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, f.getPreco());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado", "Alterado com sucesso!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
}
