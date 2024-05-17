import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    static Scanner scan = new Scanner(System.in);
    static CrearCancion cancion;
    static ArrayList<CrearCancion> Bibiloteca = new ArrayList<>();
    static ArrayList<CrearCancion> CancionesCreadas = new ArrayList<>();
    static int canciones;
    //int cancionRandom =(int) (Math.random()*canciones); eso es para que el reproductor ponga las canciones de manera aleatoria



    public static void main(String[] args) throws Exception {
        menu();


    }

    public static void menu(){
        
    }

    public static void ociones(int opcion){

        switch (opcion) {
            
            case 1:
                CrearCancion();
                break;
            case 2:
                
                break;    
        
            default:
                break;
        }

    }

    public static void CrearCancion(){
         
        String Nombre = scan.nextLine();
        String Atrista = scan.nextLine();
        String Album = scan.nextLine();
        String Genero = scan.nextLine();
        cancion = new CrearCancion(Atrista, Album, Nombre, Genero);
        CancionesCreadas.add(cancion);
        canciones ++;

        System.out.println("Desea Agrargar la cancion a la biblioteca del reproducor?");
        

        
    }

    public static void agregarBibiloteca(){


    }
}
