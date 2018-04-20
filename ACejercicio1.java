package acejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rosema
 */
public class ACejercicio1 {

    public void DividirArchivoEnVarios(File f, int num, boolean opcion) throws IOException {
        FileReader lectorArchivo = null;
        FileWriter escritorArchivo = null;
        Scanner sc = null;
        String texto = "";
        char buffer[]=new char[num]; //cargo un grupo de caracteres en el buffer
        try {
            sc = new Scanner(f);
            lectorArchivo = new FileReader(f);
            int numArchivo = 2;
            int i;
            if(opcion){
                while ((i = lectorArchivo.read(buffer)) != -1) {
                    escritorArchivo = new FileWriter("C:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\acejercicio1\\Archivo"+numArchivo+".txt");
                    texto = (new String(buffer,0,i)); // guardamos caracteres en el buffer
                    escritorArchivo.write(texto);
                    escritorArchivo.close();
                    numArchivo++;
                }
            }else{
                while(sc.hasNextLine()){
                    escritorArchivo = new FileWriter("C:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\acejercicio1\\Archivo"+numArchivo+".txt");
                    for(int k = 0; k < num;k++){
                        escritorArchivo.write(sc.nextLine()+"\n");
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
            if (escritorArchivo != null){
                escritorArchivo.close();
            }
            if (sc != null){
                sc.close();
            }
        }
    }
    public void leerArchivo(File f,File Directorio) throws FileNotFoundException, IOException{
        FileReader fileLectura = null;
        FileWriter fileEscritura = null;
        try{
            int i;
            String cadena = "";
            fileEscritura = new FileWriter("C:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\acejercicio1\\ArchivoComprimido.txt");
            fileLectura = new FileReader(f);
            for(File archivo : Directorio.listFiles()){
                if(archivo.isDirectory()){
                    System.out.println("Carpeta");
                }
                else if(archivo.isFile()){
                    fileLectura = new FileReader(archivo);
                    while((i = fileLectura.read())!= -1){
                        cadena += (char)i;
                        System.out.println(cadena);
                        //fileEscritura.write(cadena);
                    }
                    fileLectura.close();
                }
            }
            fileEscritura.close();
            
        }finally{
            if(fileLectura != null){
                fileLectura.close();
            }
            if(fileEscritura != null){
                fileEscritura.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ACejercicio1 eje1 = new ACejercicio1();
        File fcarpeta = new File("C:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\acejercicio1");
        File f = new File("C:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\acejercicio1\\Archivo.txt");
        eje1.leerArchivo(f,fcarpeta);
    }

}
