/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Sessao;
import Model.Usuario;
/**
 *
 * @author Dani e Fernando
 */
public class TelaLoginController {
    
    private UsuarioDAO usuarioDAO;

    public TelaLoginController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public String logarUsuario(String email, String senha) {
        if (email.isEmpty() || senha.isEmpty()) {
            return "Todos os campos devem ser preenchidos.";
        }

        Usuario usuarioLogado = usuarioDAO.loginUsuario(email, senha);

        if (usuarioLogado != null) {
            Sessao.setUsuarioLogado(usuarioLogado);
            return "Usuário logado com sucesso!";
        } else {
            return "Erro ao logar usuário.";
        }
    }
}
