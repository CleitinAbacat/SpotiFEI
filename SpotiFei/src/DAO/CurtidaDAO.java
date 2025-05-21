/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Dani e Fernando
 */
public class CurtidaDAO {
    
    public boolean curtirMusica(int idUsuario, int idMusica) {
        String sql = "INSERT INTO curtidas (id_usuario, id_musica, curtida) " +
                 "VALUES (?, ?, TRUE) " +
                 "ON CONFLICT (id_usuario, id_musica) DO UPDATE SET curtida = TRUE";

        try (Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao curtir música: " + e.getMessage());
            return false;
        }
    }   
    
    public boolean descurtirMusica(int idUsuario, int idMusica) {
        String sql = "UPDATE curtidas SET curtida = FALSE WHERE id_usuario = ? AND id_musica = ?";

        try (Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idMusica);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao descurtir música: " + e.getMessage());
            return false;
            }
    }
}
