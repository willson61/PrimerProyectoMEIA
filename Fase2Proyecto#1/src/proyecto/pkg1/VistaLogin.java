/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sthephan
 */
public class VistaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    public VistaLogin() throws ClassNotFoundException, SQLException {
        initComponents();
        ImageIcon im = new ImageIcon(Proyecto1.logo.getPath());
        Image image = im.getImage(); // transform it 
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        im = new ImageIcon(newimg);
        labelImage.setIcon(im);
        BDD.getInstancia().conexion();
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
    
    /**
     * Funcion que remueve los caracteres especiales "~" de una cadena 
     * @param texto cadena a la que se la van a remover los caracteres especiales
     * @return texto sin caracteres especiales
     */
    public String quitarExtra(String texto){
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == '~'){
                cont++;
            }
        }
        int pos = texto.length() - cont;
        texto = texto.substring(0, pos);
        return texto;
    }
    
    /**
     * Funcion que encripta la contraseña recibida con md5
     * @param source texto con la contraseña a encriptar
     * @return contraseña encriptada
     */
    public String encriptarContraseña(String source){
        String md5 = null;
        try{
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(source.getBytes(), 0, source.length());
            md5 = new BigInteger(1, mdEnc.digest()).toString(16);
        }catch(Exception e){
            e.printStackTrace();
        }
        return md5;
    }
    
    /**
     * Metodo de busqueda de Usuario a travez de su nombre de usuario
     * @param usuario Nombre de usuario del usuario que se buscara
     * @return Objeto Usuario con los datos del nombre de usuario encontrado
     * @throws ParseException 
     */
    public Usuario buscarUsuario(String usuario){
        Usuario val = new Usuario();
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
                String[] cont = texto.toString().split("\\r?\\n");
                for(int i = 0; i < cont.length; i++){
                    String[] data = cont[i].split("\\|");
                    if(quitarExtra(data[0]).equals(usuario)){
                        val.setNombreDeUsuario(quitarExtra(data[0]).toCharArray());
                        val.setPassword(quitarExtra(data[3]).toCharArray());
                        if(Integer.parseInt(data[4]) == 1){
                            val.setRol(true);
                        }
                        else{
                            val.setRol(false);
                        }
                        if(Integer.parseInt(data[9]) == 1){
                            val.setEstatus(true);
                        }
                        else{
                            val.setEstatus(false);
                        }
                        return val;
                    }
                }
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
                String[] cont = texto.toString().split("\\r?\\n");
                for(int i = 0; i < cont.length; i++){
                    String[] data = cont[i].split("\\|");
                    if(quitarExtra(data[0]).equals(usuario)){
                        val.setNombreDeUsuario(quitarExtra(data[0]).toCharArray());
                        val.setPassword(quitarExtra(data[3]).toCharArray());
                        if(Integer.parseInt(data[4]) == 1){
                            val.setRol(true);
                        }
                        else{
                            val.setRol(false);
                        }
                        if(Integer.parseInt(data[9]) == 1){
                            val.setEstatus(true);
                        }
                        else{
                            val.setEstatus(false);
                        }
                        return val;
                    }
                }
            }
            fr2.close();
            br2.close();
	} catch (IOException e) {
            e.printStackTrace();
	}
        return val;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNomUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnIngreso = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        labelImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngreso.setText("Ingresar");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        labelImage.setText("Aplicacion MEIA - Login");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImage)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIngreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNomUsuario)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngreso)
                    .addComponent(btnSalir))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton de accion de LogIn
     * @param evt 
     */
    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        if((txtNomUsuario.getText().equals("")) || (txtContraseña.getPassword().length == 0)){
            JOptionPane.showMessageDialog(null, "Alguno de los campos de login se encuentra vacio, por favor ingreselos", "InfoBox: " + "Error en creacion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Usuario us = buscarUsuario(txtNomUsuario.getText());
            if(us != null){
                String contr = encriptarContraseña(String.valueOf(txtContraseña.getPassword()));
                if((txtNomUsuario.getText().equals(String.valueOf(us.getNombreDeUsuario()))) && (contr.equals(String.valueOf(us.getPassword())))){
                    if(us.isEstatus()){
                        JOptionPane.showMessageDialog(null, "Login Exitoso!!", "InfoBox: " + "mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        if(us.isRol()){
                            MenuAdmin.admin = String.valueOf(us.getNombreDeUsuario());
                            dispose();
                            MenuAdmin v = new MenuAdmin();
                            v.setVisible(true);
                        }
                        else{
                            MenuUsuario.user = String.valueOf(us.getNombreDeUsuario());
                            dispose();
                            MenuUsuario v = new MenuUsuario();
                            v.setVisible(true);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El usuario se encuentra inactivo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "La contraseña no coincide con el usuario ingresado", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario ingresado", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnIngresoActionPerformed

    /**
     * Boton para cerrar Aplicacion
     * @param evt 
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaLogin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelImage;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNomUsuario;
    // End of variables declaration//GEN-END:variables
}
