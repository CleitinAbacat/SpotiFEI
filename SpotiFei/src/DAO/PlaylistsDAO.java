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
public class PlaylistsDAO {
    
    public boolean criarPlaylist(String nome, int idUsuario) {
        String sql = "INSERT INTO playlists (nome, id_usuario) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao criar playlist: " + e.getMessage());
            return false;
        }
    }
    
    public boolean editarPlaylist(int idPlaylist, String novoNome) {
        String sql = "UPDATE playlists SET nome = ? WHERE id_playlist = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, idPlaylist);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao editar playlist: " + e.getMessage());
            return false;
        }
    }

    public boolean excluirPlaylist(int idPlaylist) {
        String sqlDeleteMusicas = "DELETE FROM playlist_musicas WHERE id_playlist = ?";
        String sqlDeletePlaylist = "DELETE FROM playlists WHERE id_playlist = ?";

        try (Connection conn = Conexao.getConexao()) {

            PreparedStatement stmt1 = conn.prepareStatement(sqlDeleteMusicas);
            stmt1.setInt(1, idPlaylist);
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sqlDeletePlaylist);
            stmt2.setInt(1, idPlaylist);
            stmt2.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao excluir playlist: " + e.getMessage());
            return false;
        }
    }
    
    public boolean adicionarMusicaNaPlaylist(int idPlaylist, int idMusica) {
        String sql = "INSERT INTO playlist_musicas (id_playlist, id_musica) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar música: " + e.getMessage());
            return false;
        }
    }
    
    public boolean removerMusicaDaPlaylist(int idPlaylist, int idMusica) {
        String sql = "DELETE FROM playlist_musicas WHERE id_playlist = ? AND id_musica = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao remover música: " + e.getMessage());
            return false;
        }
    }
    public Model.Playlist buscarPlaylistPorNome(String nomePlaylist, int idUsuario) {
        String sql = "SELECT * FROM playlists WHERE nome = ? AND id_usuario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomePlaylist);
            stmt.setInt(2, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Model.Playlist playlist = new Model.Playlist();
                playlist.setIdPlaylist(rs.getInt("id_playlist"));
                playlist.setNome(rs.getString("nome"));
                playlist.setIdUsuario(rs.getInt("id_usuario"));
                return playlist;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar playlist: " + e.getMessage());
        }
        return null;
    }

    public boolean musicaJaNaPlaylist(int idPlaylist, int idMusica) {
        String sql = "SELECT 1 FROM playlist_musicas WHERE id_playlist = ? AND id_musica = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            ResultSet rs = stmt.executeQuery();

            return rs.next();  // retorna true se já existir

        } catch (SQLException e) {
            System.err.println("Erro ao verificar música na playlist: " + e.getMessage());
            return false;
        }
    }

}
