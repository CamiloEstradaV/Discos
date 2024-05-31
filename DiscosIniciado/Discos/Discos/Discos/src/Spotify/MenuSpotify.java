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
     static boolean continuar = true;

    public static void main(String[] args) throws Exception {

        String nombreString = "Biblioteca";
        Listas biblioteca = new Listas(nombreString, CancionesCreadas);

  

        ListasCreadas.add(biblioteca);

        System.out.println("");
        System.out.println("____________________________________________________________________");
        System.out.println("");
        System.out.println("       Bienvenido a Clovertify: Su reproductor musical de confianza");

        System.out.println("");
        System.out.println("Estimado usuario por favor seleccione el procedimiento que desea realizar");
        System.out.println("");

        System.out.println("");


        while (continuar) { // Bucle para permitir interacción continua con el menú
            Menu();
        }

        

           

     

    }

    public static void Menu() {
        boolean continuar = true; // Variable booleana para controlar si se debe continuar en el menú
    
        while (continuar) { // Utilizar la variable booleana para controlar el bucle
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
            System.out.println("8 = Guardar cancion el lista");
            System.out.println("____________________________________________________________________");
            System.out.println("");
            System.out.print("Digite el procedimiento que desee realizar: ");
            
            
            if (scan.hasNextInt()) {
                int opcion = scan.nextInt();
                // Limpiar el buffer del scanner
                scan.nextLine();
                
                acciones(opcion);
            } else {
                // Si no hay un entero disponible, mostrar un mensaje de error
                ;
                scan.nextLine();
                System.out.println("Error: No se proporcionó una entrada válida.");
                continuar = false; // Cambiar la variable booleana para salir del bucle
            }
        }
    }
    

    public static void acciones(int opcion) {

        switch (opcion) {

            case 0:

                System.exit(0);

                break;

            case 1:

                Cancion();

                break;

            case 2:

                elmCancion();
                scan.nextLine();

                break;

            case 3:

                agregarBibiloteca();
                scan.nextLine();

                break;

            case 4:

                CrearPlaylist();
                scan.nextLine();

                break;

            case 5:

                ReproducirMusica();


    
                break;

            case 6:

                MostrarListas();
                scan.nextLine();

                break;

            case 7:
                if (CancionesCreadas.size() == 0) {
                    System.out.println("No existen canciones en el reproductor");
                } else {
                    allCanciones();
                }
                scan.nextLine();

                break;

                case 8:
                agregarCancionesAPlaylistExistente();
                break;

            default:

                System.out.println("IMPORTANTE: Opcion Invalida, intentelo nuevamente en el rango de 0 a 8");

                break;
        }

    }

    public static void Cancion() {

        System.out.print("Escriba el titulo de la cancion: ");
        String titulo = scan.nextLine();
        titulo= titulo+ ".mp3";

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
        scan.nextLine();
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
        scan.nextLine(); 
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
                         scan.nextLine(); 

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
    
        boolean salir = false; // Variable para controlar la salida del bucle
    
        while (!salir) { // Bucle para permitir interacción continua con el menú
            System.out.println("1. Ingrese el título de la canción");
            System.out.println("2. Buscar en la playlist");
            System.out.println("0. salir");
            System.out.print("Ingrese su opción: ");
    
            String opcion = reproducir.nextLine();
    
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el título de la canción: ");
                    String titulo = reproducir.nextLine();
                    titulo = titulo + ".mp3";
                    Reproductor.EscucharCancion(titulo);             
                    break;
    
                case "2":
                    buscarEnPlaylist();
                    break;
                
                case "0":
                    salir = true; // Si se selecciona la opción 0, salir del bucle
                    scan.reset();
                    break;
    
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        
        MenuSpotify.Menu();
    }


    public static void buscarEnPlaylist() {
        MostrarListas();
        
        System.out.print("Digite el número de la playlist en la cual desea buscar: ");
        int indicePlaylist = scan.nextInt() - 1;
        scan.nextLine(); // Limpiar el buffer
        
        if (indicePlaylist >= 0 && indicePlaylist < ListasCreadas.size()) {
            Listas selectedPlaylist = ListasCreadas.get(indicePlaylist);
            System.out.println("PlayList seleccionada: " + selectedPlaylist.getNombreLista());
            
            ArrayList<String> nombresCanciones = new ArrayList<>();
            for (Cancion cancion : selectedPlaylist.getListaGuardado()) {
                nombresCanciones.add(cancion.getTitulo());
            }
            
            // Reproducir la lista de reproducción completa
            for (int i = 0; i < nombresCanciones.size(); i++) {
                Reproductor.reproducirPlaylist(nombresCanciones);
            }
            
        } else {
            System.out.println("Número de playlist no válido.");
        }
    }
    
    
    
    

    public static void agregarCancionesAPlaylistExistente() {
        MostrarListas();
        System.out.print("Digite el número de la lista de reproducción a la que desea agregar canciones: ");
        int indiceLista = scan.nextInt() - 1;
        scan.nextLine(); // Limpiar el buffer

        if (indiceLista < 0 || indiceLista >= ListasCreadas.size()) {
            System.out.println("Número de lista de reproducción no válido.");
            return;
        }

        Listas listaSeleccionada = ListasCreadas.get(indiceLista);
        mostrarCanciones();

        System.out.print("Digite el número de la canción que desea agregar a la lista de reproducción: ");
        int indiceCancion = scan.nextInt() - 1;
        scan.nextLine(); // Limpiar el buffer

        if (indiceCancion < 0 || indiceCancion >= CancionesCreadas.size()) {
            System.out.println("Número de canción no válido.");
            return;
        }

        Cancion cancionSeleccionada = CancionesCreadas.get(indiceCancion);
        listaSeleccionada.agregarCancion(cancionSeleccionada);
        System.out.println("La canción se ha agregado exitosamente a la lista de reproducción.");
    }

    public static void mostrarCanciones() {
        System.out.println("Canciones disponibles:");
        for (int i = 0; i < CancionesCreadas.size(); i++) {
            System.out.println((i + 1) + ". " + CancionesCreadas.get(i).getTitulo());
        }
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


}



