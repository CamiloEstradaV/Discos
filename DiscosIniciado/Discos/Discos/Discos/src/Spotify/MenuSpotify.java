package src.Spotify;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSpotify {

    static Scanner scan = new Scanner(System.in);
    static Cancion cancion;
    static ArrayList<Cancion> Biblioteca = new ArrayList<>();
    static ArrayList<Cancion> CancionesCreadas = new ArrayList<>();
    static ArrayList<Listas> ListasCreadas = new ArrayList<>(); // Guardar las listas de reproduccion
    static int canciones;

    //int cancionRandom = (int) (Math.random()*canciones); eso es para que el reproductor ponga las canciones de manera aleatoria


    public static void main(String[] args) throws Exception {
        
            do { 
    
                Menu();
    
            } while (true);

    }

    public static void Menu(){

        
        System.out.println("");
        System.out.println("____________________________________________________________________");
        System.out.println("");
        System.out.println("       Bienvenido a Clovertify: Su reproductor musical de confianza");

        System.out.println("");
        System.out.println("Estimado usuario por favor seleccione el procedimiento que desea realizar");
        System.out.println("");

        System.out.println("");
        System.out.println("");
        System.out.println("____________________________________________________________________");
        System.out.println("");
        System.out.println("0 = Salir");
        System.out.println("1 = Crear una canción");
        System.out.println("2 = Eliminar una canción");
        System.out.println("3 = Agregar canciones a la biblioteca");
        System.out.println("4 = Crear una lista de reproduccion de canciones");
        System.out.println("5 = Reproducir canciones/listas");
        System.out.println("6 = Mostrar listas creadas");

        System.out.println("____________________________________________________________________");
        System.out.println("");

        System.out.print("Digite el procedimiento que desee realizar: ");
        int opcion = scan.nextInt();

        acciones(opcion);

    }

    public static void acciones(int opcion){

        switch (opcion) {

            case 0:

                System.exit(0);

                break;
            
            case 1:

                Cancion();

                break;

            case 2:

                elmCancion();
                 
                break;  
            
            case 3:

                agregarBibiloteca();
                 
                break;  

            case 4:

                CrearPlaylist();
                 
                break;  

                
            case 5:

                ReproducirMusica();
                 
                break;  

                
            case 6:

                MostrarListas();
                 
                break;  
        
            default:

                System.out.println("IMPORTANTE: Opcion Invalida, intentelo nuevamente en el rango de 0 a 6");
            
                break;
        }

    }

    public static void Cancion(){
        
        System.out.print("Escriba el titulo de la cancion: ");
        String titulo = scan.nextLine();

        System.out.print("Escriba el artista que interpreta esta cancion: ");
        String artista = scan.nextLine();

        System.out.print("Escriba el genero de la cancion: ");
        String genero = scan.nextLine();

        System.out.print("Escriba la duración de la cancion en n:nn en estos terminos: ");
        String duracion1=scan.nextLine();
        String seg[]=duracion1.split(":");
        int duracion=Integer.parseInt(seg[1]) + Integer.parseInt(seg[0])*60 ;
        System.out.println("la cancion dura "+duracion+" segundos");
            System.out.println("cambio");
        System.out.print("Desea agregar la cancion a la biblioteca del reproductor? (Si o No): ");
        String modificar = scan.nextLine();
        
        if (modificar.equals("No")) {

            System.out.println("La cancion no ha sido guardada");

        }else{

            cancion = new Cancion(titulo, artista, genero, duracion);
            CancionesCreadas.add(cancion);
            canciones++;

            

        }

        
    }
    public static void allCanciones(){
        for (int  i= 0; i< CancionesCreadas.size(); ++i) {
            System.out.println(i+1 + ". " + CancionesCreadas.get(i).getTitulo());
        }
    }

    public static void elmCancion(){
       allCanciones();
       System.out.println("Ingrese el numero de la cancion que desea borrar");
       int posicionEliminar = scan.nextInt()-1;
        CancionesCreadas.remove(posicionEliminar);
    }
    

    public static void agregarBibiloteca(){

    }

    public static void CrearPlaylist(){

    }

    public static void ReproducirMusica(){


    }

    public static void MostrarListas(){

    }




}
