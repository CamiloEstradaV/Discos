package src.Spotify;

import jaco.mp3.player.MP3Player;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import javax.sound.sampled.*;
import java.util.Set;

public class Reproductor {


    private static final String MUSIC_FOLDER_PATH = "music"; // Ruta de la carpeta donde están almacenadas las canciones
    private static Scanner scanner = new Scanner(System.in); 
    private static MP3Player mp3Player; // Reproductor MP3
    private static boolean pausa = false; 
    private static boolean reproducir = false;
    private static List<String> playlist = new ArrayList<>(); 
    private static int indice = 0; 
    private static List <String> recomendados = new ArrayList<>();
    private static float volumen = 0.5f;
    private static String titulo;
    
    
        /*cargarCanciones(); 
        recomendaciones();

       
        reproducirCancion(recomendados.get(indice));
        
       */
    

    public static void mostrarMenu() {
        System.out.println("----- Menu -----");
        if (pausa) {
            System.out.println("1. Reanudar"); 
        } else {
            System.out.println("1. Pausar"); 
        }
        if (reproducir) {
            System.out.println("2. Reproducir Cancíon");
        } else {
            System.out.println("2. Detener Cancíon"); 
        }
        
        System.out.println("3. Siguiente canción");
        System.out.println("4. Canción anterior"); 
        System.out.println("5. Subir volumen"); 
        System.out.println("6. Bajar volumen"); 
        System.out.println("0. Salir"); 
        System.out.print("Ingrese su opción: ");
    }

    public static void bucleMenu() {
        boolean continuar = true; // Variable booleana para controlar el bucle
    
        while (continuar) { // Utilizar la variable booleana para controlar el bucle
            mostrarMenu();
            
            int opcion = Integer.parseInt(scanner.nextLine()); // Leer la opción del usuario
            
            switch (opcion) {
                case 1:
                    if (pausa) {
                        reanudarCancion(); // Reanudar la canción si está pausada
                    } else {
                        pausarReproduccion(); // Pausar la reproducción si no está pausada
                    }
                    break;
    
                case 2:
                if (reproducir) {
                    reproducirCancion(titulo);
                } else {
                    detenerReproduccion(); // Pausar la reproducción si no está pausada
                }
                    break;
    
                case 3:
                    siguienteCancion(); // Reproducir la siguiente canción
                    break;
    
                case 4:
                    cancionAnterior(); // Reproducir la canción anterior
                    break;
    
                case 5:
                    cambiarVolumen(volumen + 0.1f);
                    break;
    
                case 6:
                    cambiarVolumen(volumen - 0.1f);
                    break;
    
                case 0:
                    detenerReproduccion(); // Detener la reproducción y salir del programa
                    System.out.println("Volviendo al menú principal...");
                    continuar = false; // Cambiar la variable booleana para salir del bucle
                    titulo = null;
                    break;
    
                default:
                    System.out.println("Opción no válida"); // Mensaje de error para opción no válida
            }
        }
    }
    

    public static void cargarCanciones() {
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

    public static void reproducirCancion(String nombreCancion) {
        String rutaCancion = MUSIC_FOLDER_PATH + File.separator + nombreCancion; // Construir la ruta completa de la canción
        File cancion = new File(rutaCancion); 

        if (cancion.exists()) { 
            if (mp3Player != null) {
                mp3Player.stop(); 
            }
            mp3Player = new MP3Player(cancion); 
            mp3Player.play(); // Reproducir la canción
            System.out.println("Reproduciendo la canción: " + nombreCancion);
            pausa = false;
            reproducir = false;
            titulo = nombreCancion;
        } else {
            System.out.println("La canción no existe."); // Mensaje de error si la canción no se encuentra
        }
    }

    public static void reproducirPlaylist(ArrayList<String> playlist) {
        for (String nombreCancion : playlist) {
            reproducirCancion(nombreCancion);
        }
    }

    public static void detenerReproduccion() {
        if (mp3Player != null) {
            mp3Player.stop(); 
            reproducir = true;
        }
    }

    public static void pausarReproduccion() {
        if (mp3Player != null && !pausa) {
            mp3Player.pause(); 
            pausa = true; 
            System.out.println("Reproducción pausada.");
        }
    }

    public static void reanudarCancion() {
        if (mp3Player != null && pausa) {
            mp3Player.play(); 
            pausa = false; 
            System.out.println("Reproducción reanudada.");
        }
    }

    public static void siguienteCancion() {
        if (indice < playlist.size() - 1) {
            indice++; 
            reproducirCancion(playlist.get(indice)); 

            System.out.println("Ya estás en la última canción de la lista."); 
        }
    }

    public static void cancionAnterior() {
        if (indice > 0) {
            indice--; // Decrementar el índice para la canción anterior
            reproducirCancion(playlist.get(indice)); 
        } else {
            System.out.println("Ya estás en la primera canción de la lista."); // Mensaje si ya se está en la primera canción
        }
    }

    public static void cambiarVolumen(float nuevoVolumen) {

        if (nuevoVolumen < 0.0f ) {

            System.out.println("El volumen se encuentra al minimo posible");

            return;

        }

        else if ( nuevoVolumen > 1.0f) {

            System.out.println("El volumen se encuentra al maximo posible");

        }
        
        else if (mp3Player != null) {

            volumen = nuevoVolumen;
            Line.Info sourceLineInfo = Port.Info.SPEAKER;
            if (AudioSystem.isLineSupported(sourceLineInfo)) {
                try {
                    Port outline = (Port) AudioSystem.getLine(sourceLineInfo);
                    outline.open();
                    if (outline.isControlSupported(FloatControl.Type.VOLUME)) {
                        FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);
                        volumeControl.setValue(volumen);
                        System.out.println("Nuevo volumen: " + (int) (volumen * 100) + "%");
                    } else {
                        System.out.println("Control de volumen no soportado.");
                    }
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Línea de audio no soportada.");
            }
        }
    }
    
    public static void recomendaciones() {
        Set<String> cancionesUnicas = new HashSet<>();

        while (cancionesUnicas.size() < 12 && cancionesUnicas.size() < playlist.size()) {
            int cancionRandom = (int) (Math.random() * playlist.size());
            cancionesUnicas.add(playlist.get(cancionRandom));
        }

        recomendados.addAll(cancionesUnicas);
    }


    public static void EscucharCancion(String titulo) {
        cargarCanciones();
        
        boolean cancionEncontrada = false;
        int tamaño = playlist.size();
        
        for (int i = 0; i < tamaño; i++) {
            if (playlist.get(i).equalsIgnoreCase(titulo)) {
                reproducirCancion(playlist.get(i));  // Reproducir la canción encontrada
                bucleMenu();
                cancionEncontrada = true;
                break;  // Romper el bucle una vez que la canción se ha encontrado y reproducido
            }
        }
        
        if (!cancionEncontrada) {
            System.out.println("La canción " + titulo + " no se encuentra en la carpeta o no es un archivo .mp3.");
        }
    }
    

}
