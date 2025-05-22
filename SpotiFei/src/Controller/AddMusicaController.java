/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.MusicaDAO;
import DAO.PlaylistsDAO;
import Model.Musica;
import Model.Playlist;
import Model.Sessao;
/**
 *
 * @author Dani e Fernando
 */
public class AddMusicaController {
    
    private PlaylistsDAO playlistsDAO;
    private MusicaDAO musicaDAO;

    public AddMusicaController() {
        this.playlistsDAO = new PlaylistsDAO();
        this.musicaDAO = new MusicaDAO();
    }

    public String adicionarMusicaNaPlaylist(String nomePlaylist, String nomeMusica) {
        int idUsuario = Sessao.getIdUsuarioLogado();

        Playlist playlist = playlistsDAO.buscarPlaylistPorNome(nomePlaylist, idUsuario);
        if (playlist == null) {
            return "Playlist não encontrada.";
        }

        Musica musica = musicaDAO.buscarMusicaPorNome(nomeMusica);
        if (musica == null) {
            return "Música não encontrada.";
        }

        boolean jaExiste = playlistsDAO.musicaJaNaPlaylist(playlist.getIdPlaylist(), musica.getIdMusica());
        if (jaExiste) {
            return "Esta música já está na playlist.";
        }

        boolean sucesso = playlistsDAO.adicionarMusicaNaPlaylist(playlist.getIdPlaylist(), musica.getIdMusica());
        if (sucesso) {
            return "Música adicionada com sucesso!";
        } else {
            return "Erro ao adicionar música.";
        }
    }
}
