package reejercicio4;

import com.sun.security.ntlm.Client;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author David Carrera Otero
 */
public class Cliente implements Serializable {

    String nombre;
    int edad;

    public Cliente(String Nombre, int Edad) {
        this.nombre = Nombre;
        this.edad = Edad;
    }

    public Cliente() {
        this.nombre = "Jorge";
        this.edad = 20;
    }

    public void escribirObjeto(File fichero, ArrayList<Cliente> datos, ArrayList<Depart> datosDepart) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);
            for (Cliente cl : datos) {
                oos.writeObject(cl);
            }
            for (Depart dp : datosDepart) {
                oos.writeObject(dp);
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
    }

    public void leerObjetos(File fichero) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        Depart dp;
        Cliente cl;
        try {
            fis = new FileInputStream(fichero);
            in = new ObjectInputStream(fis);
            try {

                while (true) {
                    Object obj = in.readObject();
                    if (obj instanceof Cliente) {
                        cl = (Cliente) obj;
                        System.out.printf("1 Nombre: %s "
                                + "Años: %d\n", cl.nombre, cl.edad);
                    } else if (obj instanceof Depart) {
                        dp = (Depart) obj;
                        System.out.printf("2 Nombre: %s "
                                + "Antiguedad: %d\n", dp.nombre, dp.antiguedad);
                    }
                }
            } catch (EOFException e) {
                System.out.println("Fin de fichero");
            } catch (ClassCastException e) {
                System.out.println("Ocurrio un error de clases");
            }
        } finally {

            if (fis != null) {
                fis.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }

    public static class Depart implements Serializable {

        String nombre;
        int antiguedad;

        public Depart() {
            this.nombre = "Monstruos.sa";
            this.antiguedad = 3000;
        }

        public Depart(String nombre, int antiguedad) {
            this.nombre = nombre;
            this.antiguedad = antiguedad;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cliente cl = new Cliente();
        File archivo = new File("objeto.dat");
        ArrayList<Cliente> dat = new <Cliente> ArrayList();
        ArrayList<Depart> datDepart = new <Depart> ArrayList();
        //Datos Clientes
        dat.add(new Cliente("David", 24));
        dat.add(new Cliente("Mauro", 23));
        dat.add(new Cliente("Sheyla", 23));
        //Datos Depart
        datDepart.add(new Depart("Redbull", 30));
        datDepart.add(new Depart("Cocacola", 23));
        datDepart.add(new Depart("Semaforo", 25));
        //Incluimos personas con el metodo Escribir Objeto
        cl.escribirObjeto(archivo, dat, datDepart);
        //Consultamos los datos 
        cl.leerObjetos(archivo);
    }
}
