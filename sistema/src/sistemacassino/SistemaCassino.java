/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacassino;

import DAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.JFLogin;
import view.JFprincipal;

/**
 *
 * @author Leonardo Faêda
 */
public class SistemaCassino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFLogin login = new JFLogin();
        login.setVisible(true);

    
         //   JFLogin login = new JFLogin();
           // login.setVisible(true);
    }

}
