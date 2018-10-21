/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sthephan
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    
    static File bitacoraUsuario = new File("C:\\MEIA\\bitacora_Usuario.txt");
    static File descBitacoraUsuario = new File("C:\\MEIA\\desc_Bitacora_Usuario.txt");
    static File maestroUsuario = new File("C:\\MEIA\\maestro_Usuario.txt");
    static File descMaestroUsuario = new File("C:\\MEIA\\desc_Maestro_Usuario.txt");
    static File bitacoraLista = new File("C:\\MEIA\\bitacora_Lista.txt");
    static File descBitacoraLista = new File("C:\\MEIA\\desc_Bitacora_Lista.txt");
    static File maestroLista = new File("C:\\MEIA\\maestro_Lista.txt");
    static File descMaestroLista = new File("C:\\MEIA\\desc_Maestro_Lista.txt");
    static File bitacoraBackup = new File("C:\\MEIA\\bitacora_Backup.txt");
    static File descBitacoraBackup = new File("C:\\MEIA\\desc_Bitacora_Backup.txt");
    static File logo = new File("C:\\MEIA\\Imagenes\\logoProyecto.png");
    static File root = new File("C:\\MEIA");
    static File rootImg = new File("C:\\MEIA\\Imagenes");
    
    public static void main(String[] args) {
        VistaLogin main = new VistaLogin();
        main.setVisible(true);
        root.mkdirs();
        rootImg.mkdirs();
        try{
            if(!bitacoraUsuario.exists()){
                bitacoraUsuario.createNewFile();
            }
            if(!(descBitacoraUsuario.exists())){
                descBitacoraUsuario.createNewFile();
            }
            if(!(maestroUsuario.exists())){
                maestroUsuario.createNewFile();
            }
            if(!(descMaestroUsuario.exists())){
                descMaestroUsuario.createNewFile();
            }
            if(!bitacoraLista.exists()){
                bitacoraLista.createNewFile();
            }
            if(!(descBitacoraLista.exists())){
                descBitacoraLista.createNewFile();
            }
            if(!(maestroLista.exists())){
                maestroLista.createNewFile();
            }
            if(!(descMaestroLista.exists())){
                descMaestroLista.createNewFile();
            }
            if(!(descBitacoraBackup.exists())){
                descBitacoraBackup.createNewFile();
            }
            if(!(bitacoraBackup.exists())){
                bitacoraBackup.createNewFile();
            }
            if((leerArchivo(bitacoraUsuario).equals("")) && (leerArchivo(maestroUsuario).equals(""))){
                int reply = JOptionPane.showConfirmDialog(null, "Desea crear un nuevo Usuario", "No existen usuarios en los archivos", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    VistaCrearUsuario.firstUser = true;
                    VistaCrearUsuario fr = new VistaCrearUsuario();
                    main.setVisible(false);
                    fr.setVisible(true);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Funcion que lee el contenido de un archivo 
     * @param fileName archivo que se va a leer
     * @return el contenido del archivo en un string
     * @throws IOException 
     */
    public static String leerArchivo(File fileName) throws IOException{
        BufferedReader br = null;
	FileReader fr = null;
	fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        StringBuilder texto = new StringBuilder();
        int line = 0;
        while ((line = br.read()) != -1) {
            char val = (char)line;
            texto.append(val);
        }
        fr.close();
        br.close();
        return texto.toString();
    }
    
}
