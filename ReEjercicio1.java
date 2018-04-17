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
        String texto;
        int num = 2;
        int i;
        try{
            fileIn = new FileReader(f);
            char buffer [] = new char [numLetras];
            while ((i = fileIn.read(buffer)) != -1) {
                fileOut = new FileWriter("Archivo"+num+".txt");
                texto = (new String(buffer,0,i));
                //System.out.print(texto);
                fileOut.write(texto);
                fileOut.close();
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
        eje1.DividirArchivo(f,60);
        
    }
}
