import java.util.ArrayList;

public class Reproductor {

    ArrayList<CrearCancion> reproductor;
     static Boolean reproduciendo;

    
    public Reproductor(){
        this.reproduciendo = false;

    }

    public static void Reproducir(){
        
        reproduciendo=true;

    }

    public static Boolean Reproduciendo(){

        return reproduciendo;
    }

}
