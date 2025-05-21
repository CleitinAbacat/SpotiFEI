/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Dani e Fernando
 */
public class MusicaDAO {
    
    public Model.Musica buscarMusicaPorNome(String nomeMusica) {
        String sql = "SELECT * FROM musicas WHERE titulo ILIKE ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeMusica);
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
            System.err.println("Erro ao buscar música: " + e.getMessage());
        }
        return null;
    }
    
    public boolean inserirMusica(Musica musica) {
        String sql = "INSERT INTO musicas (titulo, genero, nome_artista) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, musica.getTitulo());
            stmt.setString(2, musica.getGenero());
            stmt.setString(3, musica.getNomeArtista());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir música: " + e.getMessage());
            return false;
        }
    }
    
    public java.util.List<Musica> listarTodasAsMusicas() {
        String sql = "SELECT * FROM musicas";
        java.util.List<Musica> lista = new java.util.ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Musica musica = new Musica();
                musica.setIdMusica(rs.getInt("id_musica"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setGenero(rs.getString("genero"));
                musica.setNomeArtista(rs.getString("nome_artista"));
                lista.add(musica);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar músicas: " + e.getMessage());
        }
        return lista;
    }
}
