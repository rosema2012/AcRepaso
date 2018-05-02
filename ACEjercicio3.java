package ACejercicio2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rosema
 */
public class ACEjercicio3 {
    String alumnos;
    String fecha;
    int codigo;

    public ACEjercicio3(String nombre, String fecha, int codigo){
        this.alumnos = nombre;
        this.fecha = fecha;
        this.codigo = codigo;
    }
    public String getAlumnos() {
        return alumnos;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCodigo() {
        return codigo;
    }
    
    
    public void alumnos(File fichero, ArrayList <ACEjercicio3> datos) throws IOException{
        DataOutputStream DataOut = null;
        FileOutputStream fileOut = null;
        
        int codigo = 222;
        try{
            fileOut =  new FileOutputStream(fichero);
            DataOut = new DataOutputStream(fileOut);
            datos.add(new ACEjercicio3("David", "07-04-1884", 007));                        
            datos.add(new ACEjercicio3("Jose", "21-07-1994", 007));
            datos.add(new ACEjercicio3("Andrea", "27-11-1594", 007));
            datos.add(new ACEjercicio3("Marta", "23-01-1794", 007));

            for(ACEjercicio3 alu: datos){
                try{
                    DataOut.writeUTF(alu.getAlumnos());
                    DataOut.writeUTF(alu.getFecha());
                    DataOut.writeInt(alu.getCodigo());
                }catch(IOException e){
                    System.out.println("Error guardando: "+e.getLocalizedMessage());
                }
            }
        }finally{
            if(DataOut != null){
                DataOut.close();
            }
            if(fileOut != null){
                fileOut.close();
                
            }
        }
    }
    public void VerAlumnos(ArrayList <ACEjercicio3> datos){
        for(ACEjercicio3 alu : datos){
            System.out.print(alu.getAlumnos()+" "+alu.getFecha()+" "+alu.getCodigo()+"\n");
        }
    }
    
    public void ModAlumnos(ArrayList <ACEjercicio3> datos){
        Scanner scan = new Scanner(System.in);
        System.out.println("elige un alumnos para cambiar por numero de 0 al que desees");
        int eleccion = scan.nextInt();
        datos.set(eleccion, new ACEjercicio3("ARNOLD", "66-66-6666", 666));
    }
    public void removeAlumnos(ArrayList <ACEjercicio3> datos){
        datos.removeAll(datos);
    }
    public static void main(String [] args) throws IOException{
        ACEjercicio3 ACE =new ACEjercicio3("David", "27-01-1994", 007);
        File fichero = new File("C:\\Users\\Rosema\\Documents\\NetBeansProjects\\ACejercicio1\\src\\ACejercicio2\\Datos.dat");
        ArrayList <ACEjercicio3> alu = new ArrayList<ACEjercicio3>();
        ACE.alumnos(fichero, alu);
        ACE.VerAlumnos(alu);
        ACE.ModAlumnos(alu);
        ACE.VerAlumnos(alu);
        ACE.removeAlumnos(alu);

    }
}
