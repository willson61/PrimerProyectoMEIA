/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;
/**
 *
 * @author Josue Higueros
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Listener extends Thread {
    private Connection Conexion;
    private final org.postgresql.PGConnection pgconn;
    private String id;
    private String GrupoReceptor;
    private String GrupoEmisor;
    private String Receptor;
    private String Emisor;
    private String Asunto;
    private String Mensaje;
    private Notificacion Not;  

    Listener(Connection conn) throws SQLException {
		this.Conexion = conn;
		this.pgconn = (org.postgresql.PGConnection)conn;
		Statement stmt = conn.createStatement();
		stmt.execute("LISTEN q_event");
		stmt.close();
    }

    public void run() {
        while (true) {
            try {
                //Escucha en la base de Datos para ver si hay mensajes nuevos
                Statement stmt = Conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1"); 
                rs.close();
                stmt.close();

	       //Recibe las notificaciones de JDBC
                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();
                if (notifications != null) {
                    for (int i=0; i<notifications.length; i++) {
                        //Aca se recibe cada una de las notificaciones de Postgresql notifications[i] para luego descomponer el json que se recibe
                        String parameter = notifications[i].getParameter().replace("\\","");
                        String action = parameter.split("\\{")[1].split(",")[1].split(":")[1].substring(2,8);   
                                          
                        if(action.equals("INSERT")){
                        //Se comprueba si el correo es para mi
                            id = parameter.split("\\{")[2].replace("}","").split(",")[0].split(":")[1];
                            GrupoEmisor = parameter.split("\\{")[2].replace("}","").split(",")[1].split(":")[1];  
                            GrupoReceptor = parameter.split("\\{")[2].replace("}","").split(",")[2].split(":")[1];
                            Emisor = parameter.split("\\{")[2].replace("}","").split(",")[3].split(":")[1];
                            Receptor = parameter.split("\\{")[2].replace("}","").split(",")[4].split(":")[1];
                            Asunto = parameter.split("\\{")[2].replace("}","").split(",")[6].split(":")[1];
                            Mensaje = parameter.split("\\{")[2].replace("}","").split(",")[7].split(":")[1];
                            boolean existe = false;
                            
                            if(GrupoReceptor.equals("12")){
                                //si es para mi se envia el update con la respuesta
                                BDD.getInstancia().setMensaje("El Grupo " + GrupoEmisor + " te ha enviado un Correo." );
                                Not = new Notificacion();
                                Not.setVisible(true);
                             
                                //ACA USTEDES DEBEN GESTIONAR A DONDE ENVIAR LOS DATOS OBTENIDOS DE LA NOTIFICACION PARA MOSTRARLOS EN LA BANDEJA DE ENTRADA
                                
                                //si es para mi enviar el update con la respuesta de que el usuario existe
                                //Deben de validar cada uno si el usuario existe o no en su ordenador y enviar la respuesta de esta forma al servidor
                                existe = existeUsuario(Receptor);
                                if(existe){
                                    
                                    BDD.getInstancia().Update(id, existe);
                                }else{
                                    BDD.getInstancia().Update(id, existe);
                                }                                        
                            }
                        }else{
                            //UPDATE
                            
                            //comprobar si yo fui el que envie la solicitud
                            //Descomponer id, grupo emisor y grupo receptor en esta parte
                            id = parameter.split("\\{")[2].replace("}","").split(",")[0].split(":")[1];
                            GrupoEmisor = parameter.split("\\{")[2].replace("}","").split(",")[1].split(":")[1];
                            GrupoReceptor = parameter.split("\\{")[2].replace("}","").split(",")[2].split(":")[1];
                            Emisor = parameter.split("\\{")[2].replace("}","").split(",")[3].split(":")[1];
                            Receptor = parameter.split("\\{")[2].replace("}","").split(",")[4].split(":")[1];
                            Asunto = parameter.split("\\{")[2].replace("}","").split(",")[6].split(":")[1];
                            Mensaje = parameter.split("\\{")[2].replace("}","").split(",")[7].split(":")[1];
                            
                            //Aca deben de colocar su numero de Grupo 
                            if(GrupoEmisor.equals("12")){
				
                                String respuesta = parameter.split("\\{")[2].replace("}","").split(",")[7].split(":")[1];
                                 //Comprobar cual fue la respuesta
                                 if(respuesta.equals("false")){
                                    BDD.getInstancia().setMensaje("El grupo " + GrupoReceptor + " no ha encontrado el usuario al cual enviaste el correo." );
                                    Not = new Notificacion();
                                    Not.setVisible(true);
                                 }else{
                                    BDD.getInstancia().setMensaje("El grupo " + GrupoReceptor + " ha recibido el mensaje." );
                                    Not = new Notificacion();
                                    Not.setVisible(true);
                                 }
                                 
                                 //Para Eliminar la solicitud (NO ES NECESARIO, OPCIONAL)
                                 BDD.getInstancia().Delete(id);
                            }
                        }                                             
                    }
                }
            //Espera para la siguiente Notificacion
                Thread.sleep(500);
            } catch (SQLException | InterruptedException sqle) {
                    sqle.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Funcion booleana que verifica que un usuario exista en la bitacora normal o maestra de usuarios
     * @param usuario nombre de usuario por el que se buscara
     * @return valor booleano de si existe o no el usuario buscado
     */
    public boolean existeUsuario(String usuario){
        boolean val = false;
        BufferedReader br = null;
	FileReader fr = null;
        BufferedReader br2 = null;
	FileReader fr2 = null;
	try {
            fr = new FileReader(Proyecto1.bitacoraUsuario);
            br = new BufferedReader(fr);
            StringBuilder texto = new StringBuilder();
            int line = 0;
            while ((line = br.read()) != -1) {
                char valu = (char)line;
                texto.append(valu);
            }
            if(texto.toString().contains(usuario)){
                val = true;
                return val;
            }
            fr.close();
            br.close();
            texto = new StringBuilder();
            fr2 = new FileReader(Proyecto1.maestroUsuario);
            br2 = new BufferedReader(fr2);
            line = 0;
            while ((line = br2.read()) != -1) {
                char valu = (char)line;
                texto.append(valu);
            }
            if(texto.toString().contains(usuario)){
                val = true;
                return val;
            }
            fr2.close();
            br2.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
        return val;
    }
}

