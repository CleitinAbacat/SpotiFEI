/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PlaylistsDAO;
import Model.Playlist;
import Model.Sessao;
/**
 *
 * @author Dani e Fernando
 */
public class ExcluirPlaylistController {
    private PlaylistsDAO playlistsDAO;

    public ExcluirPlaylistController() {
        this.playlistsDAO = new PlaylistsDAO();
    }

    public String excluirPlaylist(String nomePlaylist) {
        if (nomePlaylist.isEmpty()) {
            return "Por favor, digite o nome da playlist.";
        }

        int idUsuario = Sessao.getIdUsuarioLogado();
        Playlist playlist = playlistsDAO.buscarPlaylistPorNome(nomePlaylist, idUsuario);

        if (playlist == null) {
            return "Playlist não encontrada.";
        }

        boolean sucesso = playlistsDAO.excluirPlaylist(playlist.getIdPlaylist());
        if (sucesso) {
            return "Playlist excluída com sucesso!";
        } else {
            return "Erro ao excluir a playlist.";
        }
    }
}
