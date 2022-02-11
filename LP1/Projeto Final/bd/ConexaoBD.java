/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package help.bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String USUARIO = "root";
    private static final String SENHA = "0508";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/helpdesk";

    public static Connection conectar(){
        Connection conn = null;

        try {
                        
            Class.forName(DRIVER);            
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);            
            
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de conexão: driver não encontrado");
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro de conexão: parâmetros inválidos");
        }

        return conn;
    }
}
