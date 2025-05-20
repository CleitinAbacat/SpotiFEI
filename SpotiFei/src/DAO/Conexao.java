/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Dani e Fernando
 */
public class Conexao {
    public class ConexaoBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/SpotiFEI";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "Akechi_sama1!";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    public class TesteConexao {
    public static void main(String[] args) {
        try {
            try (Connection conn = ConexaoBD.conectar()) {
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}

}
}
