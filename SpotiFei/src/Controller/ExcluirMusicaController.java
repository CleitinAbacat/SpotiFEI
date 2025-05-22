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
public class ExcluirMusicaController {
    private PlaylistsDAO playlistsDAO;
    private MusicaDAO musicaDAO;

    public ExcluirMusicaController() {
        this.playlistsDAO = new PlaylistsDAO();
        this.musicaDAO = new MusicaDAO();
    }

    public String excluirMusicaDaPlaylist(String nomePlaylist, String nomeMusica) {
        if (nomePlaylist.isEmpty() || nomeMusica.isEmpty()) {
            return "Por favor, preencha ambos os campos.";
        }

        int idUsuario = Sessao.getIdUsuarioLogado();

        Playlist playlist = playlistsDAO.buscarPlaylistPorNome(nomePlaylist, idUsuario);
        if (playlist == null) {
            return "Playlist não encontrada.";
        }

        Musica musica = musicaDAO.buscarMusicaPorNome(nomeMusica);
        if (musica == null) {
            return "Música não encontrada.";
        }

        boolean sucesso = playlistsDAO.removerMusicaDaPlaylist(playlist.getIdPlaylist(), musica.getIdMusica());
        if (sucesso) {
            return "Música removida da playlist com sucesso!";
        } else {
            return "Erro ao remover música da playlist.";
        }
    }
}
