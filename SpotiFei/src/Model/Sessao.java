/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dani e Fernando
 */
public class Sessao {
     private static Usuario usuarioLogado;

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static int getIdUsuarioLogado() {
        return usuarioLogado != null ? usuarioLogado.getIdUsuario() : -1;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
    }
}
