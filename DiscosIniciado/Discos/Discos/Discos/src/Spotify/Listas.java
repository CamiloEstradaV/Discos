package src.Spotify;

import java.util.ArrayList;

public class Listas {
    
    private String nombreLista;
    
    ArrayList<Cancion> listaGuardado;

    public Listas(String nombreLista, ArrayList<Cancion> listaGuardado) {
        this.listaGuardado = listaGuardado;
        this.nombreLista = nombreLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public ArrayList<Cancion> getListaGuardado() {
        return listaGuardado;
    }

    public void setListaGuardado(ArrayList<Cancion> listaGuardado) {
        this.listaGuardado = listaGuardado;
    }

}
