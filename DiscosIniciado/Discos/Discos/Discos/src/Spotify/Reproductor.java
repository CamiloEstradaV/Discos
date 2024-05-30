package src.Spotify;

/*import java.util.ArrayList;

public class Reproductor {

    ArrayList<Cancion> reproductor;
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
*/
import jaco.mp3.player.MP3Player;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Reproductor {


    private static final String MUSIC_FOLDER_PATH = "music"; // Ruta de la carpeta donde están almacenadas las canciones
    private static Scanner scanner = new Scanner(System.in); 
    private static MP3Player mp3Player; // Reproductor MP3
    private static boolean isPaused = false; 
    private static List<String> playlist = new ArrayList<>(); 
    private static int indice = 0; 
    private static List <String> recomendados = new ArrayList<>();
    
    
    public static void main(String[] args) {
        cargarCanciones(); 
        recomendaciones();
       // reproducirCancion(playlist.get(indice)); // Reproducir la primera canción de la lista
        reproducirCancion(recomendados.get(indice));
        
        while (true) { // Bucle infinito para mostrar el menú y esperar la entrada del usuario
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine()); // Leer la opción del usuario
            
            switch (opcion) {
                case 1:
                    if (isPaused) {
                        reanudarCancion(); // Reanudar la canción si está pausada
                    } else {
                        pausarReproduccion(); // Pausar la reproducción si no está pausada
                    }
                    break;
                case 2:
                    siguienteCancion(); // Reproducir la siguiente canción
                    break;
                case 3:
                    cancionAnterior(); // Reproducir la canción anterior
                    break;
                case 0:
                    detenerReproduccion(); // Detener la reproducción y salir del programa
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida"); // Mensaje de error para opción no válida
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("----- Menu -----");
        if (isPaused) {
            System.out.println("1. Reanudar"); 
        } else {
            System.out.println("1. Pausar"); 
        }
        System.out.println("2. Siguiente canción"); 
        System.out.println("3. Canción anterior"); 
        System.out.println("0. Salir"); 
        System.out.print("Ingrese su opción: ");
    }

    private static void cargarCanciones() {
        File musicFolder = new File(MUSIC_FOLDER_PATH); 
        if (musicFolder.exists() && musicFolder.isDirectory()) { // Verificar si la carpeta existe y es un directorio
            File[] canciones = musicFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3")); // Obtener todos los archivos MP3
            if (canciones != null) {
                for (File file : canciones) {
                    playlist.add(file.getName()); // Añadir el nombre del archivo MP3 a la lista de reproducción
                }
            }
        }
        if (playlist.isEmpty()) { // Si no se encontraron canciones, mostrar un mensaje y salir del programa
            System.out.println("No se encontraron canciones en la carpeta " + MUSIC_FOLDER_PATH);
            System.exit(0);
        }
    }

    private static void reproducirCancion(String nombreCancion) {
        String rutaCancion = MUSIC_FOLDER_PATH + File.separator + nombreCancion; // Construir la ruta completa de la canción
        File cancion = new File(rutaCancion); 

        if (cancion.exists()) { 
            if (mp3Player != null) {
                mp3Player.stop(); 
            }
            mp3Player = new MP3Player(cancion); 
            mp3Player.play(); // Reproducir la canción
            System.out.println("Reproduciendo la canción: " + nombreCancion);
            isPaused = false;
        } else {
            System.out.println("La canción no existe."); // Mensaje de error si la canción no se encuentra
        }
    }

    private static void detenerReproduccion() {
        if (mp3Player != null) {
            mp3Player.stop(); 
        }
    }

    private static void pausarReproduccion() {
        if (mp3Player != null && !isPaused) {
            mp3Player.pause(); 
            isPaused = true; 
            System.out.println("Reproducción pausada.");
        }
    }

    private static void reanudarCancion() {
        if (mp3Player != null && isPaused) {
            mp3Player.play(); 
            isPaused = false; 
            System.out.println("Reproducción reanudada.");
        }
    }

    private static void siguienteCancion() {
        if (indice < playlist.size() - 1) {
            indice++; 
            reproducirCancion(playlist.get(indice)); 

            System.out.println("Ya estás en la última canción de la lista."); 
        }
    }

    private static void cancionAnterior() {
        if (indice > 0) {
            indice--; // Decrementar el índice para la canción anterior
            reproducirCancion(playlist.get(indice)); 
        } else {
            System.out.println("Ya estás en la primera canción de la lista."); // Mensaje si ya se está en la primera canción
        }
    }
    
   /* private static void recomendaciones (){
        
        int contador = 0;
        int canciones = 1;
        
        
        do {  

            int cancionRandom = (int) (Math.random()*canciones);
            recomendados.add(playlist.get(cancionRandom));
            contador++;

        } while (contador!= 12);
    
        
        


        
    }*/
    private static void recomendaciones() {
        Set<String> cancionesUnicas = new HashSet<>();

        while (cancionesUnicas.size() < 12 && cancionesUnicas.size() < playlist.size()) {
            int cancionRandom = (int) (Math.random() * playlist.size());
            cancionesUnicas.add(playlist.get(cancionRandom));
        }

        recomendados.addAll(cancionesUnicas);
    }
}
