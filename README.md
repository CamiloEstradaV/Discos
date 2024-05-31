### Titulo Proyecto
Clovertify

### Descripción
Clovertify nace para ser una alternativa a Spotify dados los recientes cambios que ha sufrido es aplicación y que ya no es amable con el usuario del común que no accede a su versión premium. Es un programa realizado en el lenguaje de programación Java que hace uso de JACo MP3 Player para poder implementar la música de tal manera que le permita al usuario escucharla y mediante métodos creados por nosotros poder controlarla de distintas maneras, nos permite crear playList, crear/agregar nuevas canciones y así expandir las colecciones de pistas disponibles para escuchar. El código busca ser una alternativa a Spotify y se busco que sus funcionalidades fueran muy parecidas.

### Autores
[Camilo Estrada] (https://github.com/CamiloEstradaV)
[Santiago Sánchez] (https://github.com/XChronoX) 
[Esteban Romano] (https://github.com/Estbn05)

### Instalación
La instalación para ejecutar el programa es bastante simple, accedemos al GitHub perteneciente al proyecto y descargamos su .zip para luego abrirlo en nuestro IDE de confianza, en lo personal recomendamos Visual Studio Code (Con la extensión del lenguaje JAVA) o Netbeans y también descargamos las bibliotecas de JACo y Tritonus para poder usar el programa de la manera ideal para acceder a su función principal que es la de escuchar música. 

### Uso 
Diseñamos el programa para que fuera lo más intuitivo posible, sin embargo, al estar en una fase temprana del desarrollo puede ser confuso para usuarios primerizos que usen el programa, a pesar de ello esto será algo que se ira arreglando a la hora de implementar la parte grafica del programa en un futuro. El código cuenta con un menú desde el cual se podrán acceder a todas las funcionalidades disponibles en el programa. Dicho menú es el siguiente: 

________________________________________________________________________________
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

_______________________________________________________________________________

El fragmento del código anterior nos permite observar el menú principal del programa en donde podemos notar como cada función que puede realizar el programa está determinada por un numero el cual colocaremos en el siguiente fragmento de código:  

________________________________________________________________________________

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
________________________________________________________________________________

Donde se evaluará el número que se haya escrito y realizara la opción perteneciente a dicho numero y en caso de que el numero no pertenezca a aquellas opciones posibles devolverá un mensaje de error el cual no permitirá que el programa continue y que este vuelva al inicio. 


Si el programa no funciona, verifique que tenga las  bnibliotecas de JaCo MP3 y Java Sound Sampled


### Derechos de Autor  
© [2024] [Camilo Estrada], [Santiago Sanchez], [Esteban Avila]. Este proyecto es parte de un proyecto finalde la asignautra de tecnicas de programacion I de la Fundacion Universitaria Konrad Lorenz. A menos que se indique lo contrario, está destinado exclusivamente para fines educativos y académicos. No se permite su uso comercial sin el permiso explicito de los autores. 
