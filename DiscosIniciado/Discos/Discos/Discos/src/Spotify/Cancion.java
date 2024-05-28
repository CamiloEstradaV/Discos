package src.Spotify;

public class Cancion {
    
    private String titulo;
    private String artista;
    private String genero;
    private int duracion;

    
    public Cancion(String titulo, String artista, String genero, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getArtista() {
        return artista;
    }


    public void setArtista(String artista) {
        this.artista = artista;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public int getDuracion() {
        return duracion;
    }


    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
