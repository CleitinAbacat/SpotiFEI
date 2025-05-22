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
public class HistoricoDAO {
    public boolean registrarBusca(int idUsuario, int idMusica){
        String sql = "INSERT INTO historico_buscas (id_usuario, id_musica) VALUES(?, ?)";
        
        try (Connection conn = Conexao.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;
        } catch(SQLException e){
            System.err.println("Erro ao registrar: "+ e.getMessage());
            return false;
        }
    }
    public java.util.List<Model.Musica> ultimasBuscas(int idUsuario) {
        String sql = "SELECT m.* FROM historico_buscas hb " +
                     "JOIN musicas m ON hb.id_musica = m.id_musica " +
                     "WHERE hb.id_usuario = ? " +
                     "ORDER BY hb.id_historico DESC LIMIT 10";

        java.util.List<Model.Musica> lista = new java.util.ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Model.Musica musica = new Model.Musica();
                musica.setIdMusica(rs.getInt("id_musica"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setGenero(rs.getString("genero"));
                musica.setNomeArtista(rs.getString("nome_artista"));
                lista.add(musica);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar histórico: " + e.getMessage());
        }
        return lista;
    }
    
    public java.util.List<Model.Musica> listarMusicasDescurtidas(int idUsuario) {
        String sql = "SELECT m.* FROM curtidas c " +
                     "JOIN musicas m ON c.id_musica = m.id_musica " +
                     "WHERE c.id_usuario = ? AND c.curtida = FALSE";

        java.util.List<Model.Musica> lista = new java.util.ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Model.Musica musica = new Model.Musica();
                musica.setIdMusica(rs.getInt("id_musica"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setGenero(rs.getString("genero"));
                musica.setNomeArtista(rs.getString("nome_artista"));
                lista.add(musica);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar músicas descurtidas: " + e.getMessage());
        }

        return lista;
    }
    
    public java.util.List<Model.Musica> listarMusicasCurtidas(int idUsuario) {
        String sql = "SELECT m.* FROM curtidas c " +
                     "JOIN musicas m ON c.id_musica = m.id_musica " +
                     "WHERE c.id_usuario = ? AND c.curtida = TRUE";

        java.util.List<Model.Musica> lista = new java.util.ArrayList<>();

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Model.Musica musica = new Model.Musica();
                musica.setIdMusica(rs.getInt("id_musica"));
                musica.setTitulo(rs.getString("titulo"));
                musica.setGenero(rs.getString("genero"));
                musica.setNomeArtista(rs.getString("nome_artista"));
                lista.add(musica);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar músicas curtidas: " + e.getMessage());
        }

        return lista;
    }

}
