/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */

public class Conexao {
    private static Connection conn = null;
    
    private Conexao(){
        try{
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_dsc", "root", "");
            System.out.println("conectou");
        }catch(SQLException e){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
           System.out.println(e.getMessage());
        }
    }
    
    public static Connection conectar(){
        if(conn == null){
            new Conexao();
        }
        return conn;
    }
    
    public static void closeConn(){
        try{
            conn.close();
        } catch (SQLException e){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
