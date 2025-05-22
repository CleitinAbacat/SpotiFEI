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
public class EditarPlaylistController {
    private PlaylistsDAO playlistsDAO;

    public EditarPlaylistController() {
        this.playlistsDAO = new PlaylistsDAO();
    }

    public String editarPlaylist(String nomeAtual, String novoNome) {
        if (nomeAtual.isEmpty() || novoNome.isEmpty()) {
            return "Por favor, preencha os dois campos.";
        }

        int idUsuario = Sessao.getIdUsuarioLogado();
        Playlist playlist = playlistsDAO.buscarPlaylistPorNome(nomeAtual, idUsuario);

        if (playlist == null) {
            return "Playlist não encontrada.";
        }

        boolean sucesso = playlistsDAO.editarPlaylist(playlist.getIdPlaylist(), novoNome);

        if (sucesso) {
            return "Nome da playlist atualizado com sucesso!";
        } else {
            return "Erro ao atualizar a playlist.";
        }
    }
}
