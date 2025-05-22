/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.HistoricoDAO;
import Model.Musica;
import Model.Sessao;
import java.util.List;
/**
 *
 * @author Dani e Fernando
 */
public class TelaHistoricoController {
    private HistoricoDAO historicoDAO;

    public TelaHistoricoController() {
        this.historicoDAO = new HistoricoDAO();
    }

    public List<Musica> ultimasBuscas() {
        int idUsuario = Sessao.getIdUsuarioLogado();
        return historicoDAO.ultimasBuscas(idUsuario);
    }

    public List<Musica> listarMusicasCurtidas() {
        int idUsuario = Sessao.getIdUsuarioLogado();
        return historicoDAO.listarMusicasCurtidas(idUsuario);
    }

    public List<Musica> listarMusicasDescurtidas() {
        int idUsuario = Sessao.getIdUsuarioLogado();
        return historicoDAO.listarMusicasDescurtidas(idUsuario);
    }
}
