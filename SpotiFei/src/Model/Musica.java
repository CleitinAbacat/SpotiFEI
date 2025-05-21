/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dani e Fernando
 */
public class Musica {
    private int idMusica;
    private String titulo;
    private String genero;
    private String nomeArtista;

    // Construtor vazio
    public Musica() {
    }

    // Construtor com parâmetros (opcional)
    public Musica(String titulo, String genero, String nomeArtista) {
        this.titulo = titulo;
        this.genero = genero;
        this.nomeArtista = nomeArtista;
    }

    // Getters e Setters
    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
}
