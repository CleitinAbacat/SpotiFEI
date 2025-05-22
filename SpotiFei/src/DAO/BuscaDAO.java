/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Dani e Fernando
 */
public class BuscaDAO {
    
    public Model.Musica buscarMusica(String termoBusca) {
    String sql = "SELECT * FROM musicas " +
                 "WHERE titulo ILIKE ? OR genero ILIKE ? OR nome_artista ILIKE ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String busca = "%" + termoBusca + "%";
        stmt.setString(1, busca);
        stmt.setString(2, busca);
        stmt.setString(3, busca);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Model.Musica musica = new Model.Musica();
            musica.setIdMusica(rs.getInt("id_musica"));
            musica.setTitulo(rs.getString("titulo"));
            musica.setGenero(rs.getString("genero"));
            musica.setNomeArtista(rs.getString("nome_artista"));
            return musica;
        }
    } catch (SQLException e) {
        System.err.println("Erro na busca: " + e.getMessage());
    }
    return null;
}

}
