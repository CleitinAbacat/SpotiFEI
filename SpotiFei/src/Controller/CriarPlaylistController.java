/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.PlaylistsDAO;
import Model.Sessao;
/**
 *
 * @author Dani e Fernando
 */
public class CriarPlaylistController {
    private PlaylistsDAO playlistsDAO;

    public CriarPlaylistController() {
        this.playlistsDAO = new PlaylistsDAO();
    }

    public boolean criarPlaylist(String nomePlaylist) {
        int idUsuario = Sessao.getIdUsuarioLogado();
        return playlistsDAO.criarPlaylist(nomePlaylist, idUsuario);
    }
}
