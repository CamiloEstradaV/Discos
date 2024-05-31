package src.Spotify;

import java.util.ArrayList;
import java.util.Scanner;


public class MenuSpotify {

    static Scanner scan = new Scanner(System.in);
    static Cancion cancion;
    static ArrayList<Cancion> colaReproduccion = new ArrayList<>();
    static ArrayList<Cancion> CancionesCreadas = new ArrayList<>();
    static ArrayList<Listas> ListasCreadas = new ArrayList<>(); // Guardar las listas de reproduccion
    static int canciones;

    public static void main(String[] args) throws Exception {

        System.out.println("");
        System.out.println("____________________________________________________________________");
        System.out.println("");
        System.out.println("       Bienvenido a Clovertify: Su reproductor musical de confianza");

        System.out.println("");
        System.out.println("Estimado usuario por favor seleccione el procedimiento que desea realizar");
        System.out.println("");

        System.out.println("");

        do {

            Menu();

        } while (true);

    }

    public static void Menu() {

        
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
        System.out.println("7 = Mostrar Todas las canciones(solo el nombre)");

        System.out.println("____________________________________________________________________");
        System.out.println("");

        System.out.print("Digite el procedimiento que desee realizar: ");
        int opcion = scan.nextInt();

        acciones(opcion);

    }

    public static void acciones(int opcion) {

        switch (opcion) {

            case 0:

                System.exit(0);

                break;

            case 1:

                Cancion();
                validarContinuar();
                break;

            case 2:

                elmCancion();
                scan.nextLine();
                validarContinuar();
                break;

            case 3:

                agregarBibiloteca();
                scan.nextLine();
                validarContinuar();
                break;

            case 4:

                CrearPlaylist();
                scan.nextLine();
                validarContinuar();
                break;

            case 5:

                ReproducirMusica();
                scan.nextLine();
    
                break;

            case 6:

                MostrarListas();
                scan.nextLine();
                validarContinuar();
                break;

            case 7:
                if (CancionesCreadas.size() == 0) {
                    System.out.println("No existen canciones en el reproductor");
                } else {
                    allCanciones();
                }
                scan.nextLine();
                validarContinuar();
                break;

            default:

                System.out.println("IMPORTANTE: Opcion Invalida, intentelo nuevamente en el rango de 0 a 7");

                break;
        }

    }

    public static void Cancion() {

        System.out.print("Escriba el titulo de la cancion: ");
        scan.nextLine();
        String titulo = scan.nextLine();

        System.out.print("Escriba el artista que interpreta esta cancion: ");
        String artista = scan.nextLine();

        System.out.print("Escriba el genero de la cancion: ");
        String genero = scan.nextLine();

        System.out.print("Escriba la duración de la cancion en n:nn en estos terminos: ");
        String duracion1 = scan.nextLine();
        String seg[] = duracion1.split(":");
        int duracion = Integer.parseInt(seg[1]) + Integer.parseInt(seg[0]) * 60;
        System.out.println("la cancion dura " + duracion + " segundos");
        System.out.print("Desea agregar la cancion a la cola de Reproduccion? (Si o No): ");
        String modificar = scan.nextLine();

        if (modificar.equals("No")) {
            cancion = new Cancion(titulo, artista, genero, duracion);
            CancionesCreadas.add(cancion);
            System.out.println("\nLa cancion no ha sido agregada a la cola de reproduccion");

        } else {

            cancion = new Cancion(titulo, artista, genero, duracion);
            CancionesCreadas.add(cancion);
            colaReproduccion.add(cancion);
            canciones++;
            System.out.println("\nLa cancion ha sido agregada a la cola de reproduccion");

        }

    }

    public static void allCanciones() {
        for (int i = 0; i < CancionesCreadas.size(); ++i) {
            System.out.println(i + 1 + ". " + CancionesCreadas.get(i).getTitulo());
        }
    }

    public static void elmCancion() {
        allCanciones();
        System.out.println("Ingrese el numero de la cancion que desea borrar");
        int posicionEliminar = scan.nextInt() - 1;
        System.out.println("La cancion " + CancionesCreadas.get(posicionEliminar).getTitulo() + " Ha sido eliminada");
        CancionesCreadas.remove(posicionEliminar);
    }

    public static void agregarBibiloteca() { // En este apartado se creo un ArrayList momentaneo de Bilioteca, en caso
                                             // de que este apartado sea lo mismo que el ArrayList CancionesCreadas,
                                             // simplemente cambiamos estos valores en las variables correspondientes,
                                             // puesto que se podrian considerar como lo mismo si analizamos cual es su
                                             // función. Es simplemente algo que logre notar mientras estaba haciendo mi
                                             // parte del codigo.

        ArrayList<Cancion> Biblioteca = new ArrayList<>();

        allCanciones();
        System.out.println("Ingrese el numero de la cancion que quiere agregar a la Biblioteca del reproductor");
        int aggBiblioteca = scan.nextInt() - 1;
        Biblioteca.add(cancion);
    }



    public static void CrearPlaylist() {

    
            ArrayList<Cancion> cancionAgregar = new ArrayList<>();

            scan.nextLine();

            System.out.print("Digite el nombre de la Playlist que desea crear: ");
            String nombrePlayList = scan.nextLine();
            System.out.println("");

            System.out.print("Digite el numero de canciones que desea agregar a su PlayList: ");

                int cancionesPlayList = scan.nextInt();
                System.out.println("");

                scan.nextLine();
                allCanciones();

                boolean comprobar = false;

                    for (int i = 0; i < cancionesPlayList; i++) {
                        
                        System.out.println("");

                        System.out.println("Digite el numero perteneciente a la cancion que desee agregar: ");
                        int cancionAgregada = scan.nextInt() - 1;

                        if (cancionAgregada < 0) {

                            System.out.println("");
                            System.out.println("Cancion no existente. Intentelo nuevamente");
                            System.out.println("");

                            i--;

                            comprobar = true;

                        } else {

                            String titulo = CancionesCreadas.get(cancionAgregada).getTitulo();
                            String artista = CancionesCreadas.get(cancionAgregada).getArtista();
                            String genero = CancionesCreadas.get(cancionAgregada).getGenero();
                            int duracion = CancionesCreadas.get(cancionAgregada).getDuracion();

                            Cancion unaCancion = new Cancion(titulo, artista, genero, duracion);
                        
                            cancionAgregar.add(unaCancion);

                            comprobar = false;
                        }

            
                }

            if (comprobar == false) {

                Listas nuevaPlayList = new Listas(nombrePlayList, cancionAgregar);

            ListasCreadas.add(nuevaPlayList);


            System.out.println("Su PlayList fue guardada con exito");
            System.out.println("");
            
            }
            

    }

    public static void ReproducirMusica() {

        Scanner reproducir = new Scanner(System.in);

        System.out.println("1. Ingrese el titulo de la cancion");
        System.out.println("2. buscar en la playlist");

        String opcion = reproducir.nextLine();

        switch (opcion) {

            case "1":
            String titulo = reproducir.nextLine();
            titulo = titulo + ".mp3";
            
            Reproductor.reproducirCancion(titulo);
            Reproductor.bucleMenu();
                break;

            case "2":
            MostrarListas();
            



            break;
        
            default:
                break;
        }

       
        
        

        reproducir.close();


    }

    public static void MostrarListas() {

        System.out.println("                    PlayList Creadas");


        for(int i = 0; i < ListasCreadas.size(); i++){

            System.out.println("");
            System.out.println((i+1)+ ". " + ListasCreadas.get(i).getNombreLista());
            
                // System.out.println("Persona " + (i+1) + ". ");
                // System.out.println("Hamburguesa: " + elPedido.getMenu().get(i).getHamburguesa());
                // System.out.println("Bebida: " + elPedido.getMenu().get(i).getBebida());
                // System.out.println("Guarnición: " + elPedido.getMenu().get(i).getGuarnicion());
                // System.out.println("");
        }
        
        System.out.println("");
        System.out.print("Desea visualizar el contenido de alguna PlayList? (Si o No): ");
        scan.nextLine();
        String modificar = scan.nextLine();
        System.out.println("");

        if (modificar.equals("No")) {


            System.out.println("Volviendo al Menu...");
            System.out.println("");

        } else {

            System.out.print("Digite el numero de la PlayList a la cual desea acceder: ");
            int playListContenido = scan.nextInt() - 1;
            System.out.println("");
            
            for(int i = 0; i < ListasCreadas.get(playListContenido).getListaGuardado().size(); i++){

                System.out.println("");
                System.out.println(i + 1 + ". " + ListasCreadas.get(playListContenido).getListaGuardado().get(i).getTitulo());
                
            }

        }


    }

    public static void validarContinuar() {
        System.out.println("\nPara continuar oprima ENTER");
        scan.nextLine();

    }

}

