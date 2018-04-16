package reejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author David Carrera Otero
 */
public class ReEjercicio1 {


    
    public void DividirArchivo(File f,int numLetras) throws IOException{
        FileReader fileIn = null;
        FileWriter fileOut = null;
        BufferedWriter BufferEscritura = null;
        BufferedReader BufferLectura = null;
        String texto = "";
        int num = 0;
        int i;
        try{
            fileIn = new FileReader(f);
            while((i = fileIn.read())!= -1){
                BufferLectura = new BufferedReader(fileIn,10);
            }
                for (int j = 0; j < numLetras; j++) {
                    fileOut = new FileWriter((num+"")+f);
                    BufferEscritura = new BufferedWriter(fileOut,10);
                    num++;
                }
        }finally{
            if(fileOut != null){
                fileOut.close();
            }
            if(fileIn != null){
                fileIn.close();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ReEjercicio1 eje1 = new ReEjercicio1();
        File f = new File("C:\\Users\\David Carrera Otero\\Documents\\NetBeansProjects\\ReEjercicio1\\src\\reejercicio1\\Archivo.txt");
        eje1.DividirArchivo(f,10);
    }
}
