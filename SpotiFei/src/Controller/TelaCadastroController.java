/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
/**
 *
 * @author Dani e Fernando
 */
public class TelaCadastroController {
    private UsuarioDAO usuarioDAO;

    public TelaCadastroController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public String cadastrarUsuario(String nome, String email, String senha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            return "Todos os campos devem ser preenchidos.";
        }

        Usuario novoUsuario = new Usuario(nome, email, senha);
        boolean sucesso = usuarioDAO.cadastrarUsuario(novoUsuario);

        if (sucesso) {
            return "Usuário cadastrado com sucesso!";
        } else {
            return "Erro ao cadastrar usuário.";
        }
    }
}
