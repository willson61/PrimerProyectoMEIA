/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sthephan
 */
public class VistaDatos extends javax.swing.JFrame {

    /**
     * Creates new form VistaDatos
     */
    public VistaDatos() {
        initComponents();
        if(!(user.equals(""))){
            try {
                Usuario s = buscarUsuario(user);
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                labelUsuario.setText("Nombre de Usuario: " + String.valueOf(s.getNombreDeUsuario()));
                labelNombre.setText("Nombre: " + String.valueOf(s.getNombre()));
                labelApellido.setText("Apellido: " + String.valueOf(s.getApellido()));
                if(s.isRol()){
                    labelRol.setText("Rol: Administrador");
                }
                else{
                    labelRol.setText("Rol: Usuario");
                }
                labelFechaNacimiento.setText("Fecha Nacimiento: " + date.format(s.getFechaNacimiento()));
                labelCorreo.setText("Correo: " + String.valueOf(s.getCorreoAlterno()));
                labelTelefono.setText("Telefono: " + String.valueOf(s.getTelefono()));
                labelPath.setText("Ubicacion foto: " + String.valueOf(s.getPathFotografia()));
                if(s.isEstatus()){
                    labelEstado.setText("Estado: Activo");
                }
                else{
                    labelEstado.setText("Estado: Inactivo");
                }
            } catch (ParseException ex) {
                Logger.getLogger(VistaDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String user;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuario = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        labelFechaNacimiento = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelPath = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSalir.setText("Cerrar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuario)
                    .addComponent(labelNombre)
                    .addComponent(labelApellido)
                    .addComponent(labelRol)
                    .addComponent(labelFechaNacimiento)
                    .addComponent(labelCorreo)
                    .addComponent(labelTelefono)
                    .addComponent(labelPath)
                    .addComponent(labelEstado)
                    .addComponent(btnSalir))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEstado)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    
    /**
     * Metodo de busqueda de Usuario a travez de su nombre de usuario
     * @param usuario Nombre de usuario del usuario que se buscara
     * @return Objeto Usuario con los datos del nombre de usuario encontrado
     * @throws ParseException 
     */
    public Usuario buscarUsuario(String usuario) throws ParseException {
        Usuario val = new Usuario();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
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
                        val.setNombre(quitarExtra(data[1]).toCharArray());
                        val.setApellido(quitarExtra(data[2]).toCharArray());
                        val.setPassword(quitarExtra(data[3]).toCharArray());
                        if(Integer.parseInt(data[4]) == 1){
                            val.setRol(true);
                        }
                        else{
                            val.setRol(false);
                        }
                        val.setFechaNacimiento(date.parse(data[5]));
                        val.setCorreoAlterno(quitarExtra(data[6]).toCharArray());
                        val.setTelefono(Integer.parseInt(data[7]));
                        val.setPathFotografia(quitarExtra(data[8]).toCharArray());
                        if(data[9].equals("1")){
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
                        val.setNombre(quitarExtra(data[1]).toCharArray());
                        val.setApellido(quitarExtra(data[2]).toCharArray());
                        val.setPassword(quitarExtra(data[3]).toCharArray());
                        if(Integer.parseInt(data[4]) == 1){
                            val.setRol(true);
                        }
                        else{
                            val.setRol(false);
                        }
                        val.setFechaNacimiento(date.parse(data[5]));
                        val.setCorreoAlterno(quitarExtra(data[6]).toCharArray());
                        val.setTelefono(Integer.parseInt(data[7]));
                        val.setPathFotografia(quitarExtra(data[8]).toCharArray());
                        if(data[9].equals("1")){
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
            java.util.logging.Logger.getLogger(VistaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelFechaNacimiento;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPath;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}