
package ACejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Rosema
 */
public class ACejercicio2 {
    public void copiaDeArchivoMp3EnBytes () throws FileNotFoundException, IOException{
    FileOutputStream salidaBin = null;
    FileInputStream archivoBin = null;
    float porcentaje = 0;
    int cont = 0;
    File archivo = new File("c:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\ACejercicio2\\doom.mp3");
    try{
        salidaBin = new FileOutputStream("c:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\ACejercicio2\\doomCopia.mp3");
        archivoBin = new FileInputStream(archivo);
        int b;
        byte[] descarga = new byte[20];
        while((b = archivoBin.read(descarga)) != -1){
            salidaBin.write(descarga,0,b);
            cont+=20;
            //System.out.println(cont);
            if(cont > 9134.635){
                cont = 0;
                porcentaje++;
                System.out.println(String.format("%.0f",porcentaje));
                
            }
            
        }
        salidaBin.close();
        archivoBin.close();
    }finally{
        if(archivoBin != null){
            archivoBin.close();
        }
        if(salidaBin != null){
            salidaBin.close();
        }
    }
    }
    public static void main(String [] args) throws IOException{
        ACejercicio2 eje2 = new ACejercicio2();
        eje2.copiaDeArchivoMp3EnBytes();
    }   
}
