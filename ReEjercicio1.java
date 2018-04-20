package reejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author David Carrera Otero
 */
public class ReEjercicio1 {

    /**
     * @author Rosema
     */
    public void DividirArchivoEnVarios(File f, int num, boolean opcion) throws IOException {
        FileReader lectorArchivo = null;
        FileWriter escritorArchivo = null;
        Scanner sc = null;
        String texto = "";
        char buffer[] = new char[num]; //cargo un grupo de caracteres en el buffer
        try {
            sc = new Scanner(f);
            lectorArchivo = new FileReader(f);
            int numArchivo = 2;
            int i;
            if (opcion) {
                while ((i = lectorArchivo.read(buffer)) != -1) {
                    escritorArchivo = new FileWriter("Archivo" + numArchivo + ".txt");
                    texto = (new String(buffer, 0, i)); // guardamos caracteres en el buffer
                            escritorArchivo.write(texto);

                    escritorArchivo.close();
                    numArchivo++;
                }
            } else {
                while (sc.hasNextLine()) {
                    escritorArchivo = new FileWriter("Archivo" + numArchivo + ".txt");
                    for (int k = 0; k < num; k++) {
                        if (sc.hasNextLine()) {
                            escritorArchivo.write(sc.nextLine() + "\n");
                        } else {

                        }

                    }
                    numArchivo++;
                    escritorArchivo.close();
                }
            }
            num = 2;
        } finally {
            if (lectorArchivo != null) {
                lectorArchivo.close();
            }
            if (escritorArchivo != null) {
                escritorArchivo.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    public void leerArchivo(File f, File Directorio) throws FileNotFoundException, IOException {

        FileReader fileLectura = null;
        FileWriter fileEscritura = null;
        try {
            int i;

            String cadena = "";
            fileEscritura = new FileWriter("ArchivoComprimido.txt");
            fileLectura = new FileReader(f);
            for (File archivo : Directorio.listFiles()) {
                if (archivo.isDirectory()) {
                } 
                else if(archivo.isFile() && archivo.getName().endsWith(".txt")){
                    fileLectura = new FileReader(archivo);
                    while((i = fileLectura.read())!= -1){
                        cadena += (char)i;
                    }
                }
            }
            fileEscritura.write(cadena);
            fileEscritura.close();
            fileLectura.close();

        } finally {
            if (fileLectura != null) {
                fileLectura.close();
            }
            if (fileEscritura != null) {
                fileEscritura.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ReEjercicio1 eje1 = new ReEjercicio1();
        File f = new File("Archivo.txt");
        File Directorio = new File("C:\\Users\\David Carrera Otero\\Documents\\NetBeansProjects\\ReEjercicio1");
        //eje1.DividirArchivoEnVarios(f, 4, false);
        eje1.leerArchivo(f, Directorio);
    }
}
