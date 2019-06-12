/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dal;
import java.sql.*;

/**
 *
 * @author Gravata
 */
public class ModuloConexao {
    //responsal estabelecer conexao com o banco
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //linha abaixo chama o drive  
        String driver = "com.mysql.jdbc.Driver";
        //armazenando informacoes do banco de dados
        String url= "jdbc:mysql://192.168.0.19:3306/dbinfox";
        String user="jeilsoncunha";
        String password = "Jeilson@2019";
        //estabelecendo conexao com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
