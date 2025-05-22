/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.BuscaDAO;
import DAO.CurtidaDAO;
import DAO.HistoricoDAO;
import Model.Musica;
import Model.Sessao;

public class controllerBusca {

    private BuscaDAO buscaDAO;
    private CurtidaDAO curtidaDAO;
    private HistoricoDAO historicoDAO;

    public controllerBusca() {
        this.buscaDAO = new BuscaDAO();
        this.curtidaDAO = new CurtidaDAO();
        this.historicoDAO = new HistoricoDAO();
    }

    public Musica buscarMusica(String termo) {
        Musica musica = buscaDAO.buscarMusica(termo);
        if (musica != null) {
            int idUsuario = Sessao.getIdUsuarioLogado();
            historicoDAO.registrarBusca(idUsuario, musica.getIdMusica());
        }
        return musica;
    }

    public boolean curtirMusica(Musica musica) {
        int idUsuario = Sessao.getIdUsuarioLogado();
        return curtidaDAO.curtirMusica(idUsuario, musica.getIdMusica());
    }

    public boolean descurtirMusica(Musica musica) {
        int idUsuario = Sessao.getIdUsuarioLogado();
        return curtidaDAO.descurtirMusica(idUsuario, musica.getIdMusica());
    }
}

