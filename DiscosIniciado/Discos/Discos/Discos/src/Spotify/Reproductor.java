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
import java.util.List;
import java.util.Scanner;

public class Reproductor {
    private static final String MUSIC_FOLDER_PATH = "music"; // Ruta de la carpeta donde están almacenadas las canciones
    private static Scanner scanner = new Scanner(System.in); // Escáner para leer la entrada del usuario
    private static MP3Player mp3Player; // Reproductor MP3
    private static boolean isPaused = false; // Bandera para controlar si la reproducción está pausada
    private static List<String> playlist = new ArrayList<>(); // Lista de reproducción
    private static int currentIndex = 0; // Índice de la canción actual
    private static List <String> recomendados = new ArrayList<>();
    
    
    public static void main(String[] args) {
        cargarCanciones(); // Cargar las canciones en la lista de reproducción
        
        reproducirCancion(playlist.get(currentIndex)); // Reproducir la primera canción de la lista
        
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
            System.out.println("1. Reanudar"); // Opción para reanudar la reproducción
        } else {
            System.out.println("1. Pausar"); // Opción para pausar la reproducción
        }
        System.out.println("2. Siguiente canción"); // Opción para reproducir la siguiente canción
        System.out.println("3. Canción anterior"); // Opción para reproducir la canción anterior
        System.out.println("0. Salir"); // Opción para salir del programa
        System.out.print("Ingrese su opción: ");
    }

    private static void cargarCanciones() {
        File musicFolder = new File(MUSIC_FOLDER_PATH); // Crear un objeto File para la carpeta de música
        if (musicFolder.exists() && musicFolder.isDirectory()) { // Verificar si la carpeta existe y es un directorio
            File[] files = musicFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3")); // Obtener todos los archivos MP3
            if (files != null) {
                for (File file : files) {
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
        File cancionFile = new File(rutaCancion); // Crear un objeto File para la canción

        if (cancionFile.exists()) { // Verificar si la canción existe
            if (mp3Player != null) {
                mp3Player.stop(); // Detener la reproducción actual si hay una canción reproduciéndose
            }
            mp3Player = new MP3Player(cancionFile); // Crear un nuevo reproductor MP3 con la canción
            mp3Player.play(); // Reproducir la canción
            System.out.println("Reproduciendo la canción: " + nombreCancion);
            isPaused = false; // Establecer la bandera de pausa en false
        } else {
            System.out.println("La canción no existe."); // Mensaje de error si la canción no se encuentra
        }
    }

    private static void detenerReproduccion() {
        if (mp3Player != null) {
            mp3Player.stop(); // Detener la reproducción
        }
    }

    private static void pausarReproduccion() {
        if (mp3Player != null && !isPaused) {
            mp3Player.pause(); // Pausar la reproducción
            isPaused = true; // Establecer la bandera de pausa en true
            System.out.println("Reproducción pausada.");
        }
    }

    private static void reanudarCancion() {
        if (mp3Player != null && isPaused) {
            mp3Player.play(); // Reanudar la reproducción
            isPaused = false; // Establecer la bandera de pausa en false
            System.out.println("Reproducción reanudada.");
        }
    }

    private static void siguienteCancion() {
        if (currentIndex < playlist.size() - 1) {
            currentIndex++; // Incrementar el índice para la siguiente canción
            reproducirCancion(playlist.get(currentIndex)); // Reproducir la siguiente canción
        } else {
            System.out.println("Ya estás en la última canción de la lista."); // Mensaje si ya se está en la última canción
        }
    }

    private static void cancionAnterior() {
        if (currentIndex > 0) {
            currentIndex--; // Decrementar el índice para la canción anterior
            reproducirCancion(playlist.get(currentIndex)); // Reproducir la canción anterior
        } else {
            System.out.println("Ya estás en la primera canción de la lista."); // Mensaje si ya se está en la primera canción
        }
    }
    
    private static void recomendaciones (){
        
        int contador = 0;
        int canciones = 1;
        
        cargarCanciones();
        
        int cancionRandom = (int) (Math.random()*canciones);
        
        do {  
            

        } while (contador!= 12);
        
        


        
    }
}
