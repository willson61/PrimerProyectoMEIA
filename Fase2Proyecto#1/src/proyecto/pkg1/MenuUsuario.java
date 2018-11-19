/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Sthephan
 */
public class MenuUsuario extends javax.swing.JFrame {

    /**
     * Creacion del menu del Usuario
     * Establecimiento de datos del usuario
     */
    public MenuUsuario() {
        initComponents();
        ImageIcon im = new ImageIcon(Proyecto1.logo.getPath());
        Image image = im.getImage(); // transform it 
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        im = new ImageIcon(newimg);
        labelLogo.setIcon(im);
        labelLogo2.setIcon(im);
        labelLogo3.setIcon(im);
        labelLogo4.setIcon(im);
        labelLogo5.setIcon(im);
        labelLogo6.setIcon(im);
        labelLogo8.setIcon(im);
        labelLogo9.setIcon(im);
        labelLogo10.setIcon(im);
        labelLogo11.setIcon(im);
        labelLogo12.setIcon(im);
        inicio();
        inicio2();
        inicio3();
        inicio4();
        iniciarBandejas();
    }
    
    public void inicio(){
        btnGuardarContr.setVisible(false);
        btnGuardarCorreo.setVisible(false);
        btnGuardarEsta.setVisible(false);
        btnGuardarFecha.setVisible(false);
        btnGuardarFoto.setVisible(false);
        btnGuardarTele.setVisible(false);
        btnBuscarFoto.setVisible(false);
        chbActivo.setVisible(false);
        chbInactivo.setVisible(false);
        labelContraseña.setVisible(false);
        labelCorreo.setVisible(false);
        labelEstatus.setVisible(false);
        labelFechaN.setVisible(false);
        labelFormatoFecha.setVisible(false);
        labelFoto.setVisible(false);
        labelTelefono.setVisible(false);
        labelPathFoto.setVisible(false);
        txtContraseña.setVisible(false);
        txtCorreo.setVisible(false);
        txtFechaNacimiento.setVisible(false);
        txtTelefono.setVisible(false);
        try {
            us = buscarUsuario(user);
            labelNombre.setText("Nombre de Usuario: " + String.valueOf(us.getNombreDeUsuario()));
            if(us.isRol()){
                labelRol.setText("Rol: Administrador");
            }
            else{
                labelRol.setText("Rol: Usuario");
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon im2 = new ImageIcon(String.valueOf(us.getPathFotografia()));
        Image image2 = im2.getImage(); // transform it 
        Image newimg2 = image2.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        im2 = new ImageIcon(newimg2);
        labelImageFoto.setIcon(im2);
        txtContraseña.setText("");
        chbActivo.setSelected(false);
        chbInactivo.setSelected(false);
        txtFechaNacimiento.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        labelPathFoto.setText("");
    }
    
    public void inicio2(){
        btnEditar.setVisible(false);
        btnVer.setVisible(false);
        labelDescripcion.setVisible(false);
        txtDescripcion.setVisible(false);
        btnGuardarDescripcion.setVisible(false);
        boxOpEditarL.setVisible(false);
        chbActivoL.setVisible(false);
        chbInactivoL.setVisible(false);
        labelEstatusL.setVisible(false);
        btnGuardarEstaL.setVisible(false);
        chbActivoL.setSelected(false);
        chbInactivoL.setSelected(false);
    }
    
    public void inicio3(){
        btnGuardarAsociacion.setVisible(false);
        labelRLista.setText("");
        txtBusquedaUsuarioAsociar.setVisible(false);
        btnBuscarUsuarioAsociar.setVisible(false);
        labelRUsuario.setText("");
        labelRUsuario.setVisible(false);
    }
    
    public void inicio4(){
        btnGuardarEliminacion.setVisible(false);
        labelRListaEliminacion.setText("");
        txtBusquedaUsuarioEliminacion.setVisible(false);
        btnBuscarUsuarioEliminacion.setVisible(false);
        labelRUsuarioEliminacion.setText("");
        labelRUsuarioEliminacion.setVisible(false);
    }
    
    public void iniciarBandejas(){
        DefaultListModel modelEntrada = new DefaultListModel();
        DefaultListModel modelSalida = new DefaultListModel();
        if(correosEntrada.size() > 0){
            correosEntrada.removeAll(correosEntrada);
        }
        if(correosSalida.size() > 0){
            correosSalida.removeAll(correosSalida);
        }
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        try {
            DescIndiceListaUsuario dec = leerDescriptorIndice(Proyecto1.descArbolCorreos);
            leerBandejaDeEntrada(leerCorreo(Proyecto1.arbolCorreos, dec.getRegistroInicial()));
            leerBandejaDeSalida(leerCorreo(Proyecto1.arbolCorreos, dec.getRegistroInicial()));
            if(correosEntrada.size() > 0){
                for(int i = 0; i < correosEntrada.size(); i++){
                    Correo c = correosEntrada.get(i);
                    if(c.isEstatus()){
                        String linea = "";
                        linea += "Emisor: ";
                        linea += String.valueOf(c.getEmisor());
                        linea += "----";
                        linea += "Receptor: ";
                        linea += String.valueOf(c.getReceptor());
                        linea += "----";
                        linea += "Asunto: ";
                        linea += String.valueOf(c.getAsunto());
                        linea += "----";
                        linea += "Mensaje: ";
                        linea += String.valueOf(c.getMensaje());
                        linea += "----";
                        linea += "Fecha: ";
                        linea += date.format(c.getFechaTransaccion());
                        modelEntrada.addElement(linea);
                    }
                }
                BandejaEntrada.setModel(modelEntrada);
            }
            if(correosSalida.size() > 0){
                for(int i = 0; i < correosSalida.size(); i++){
                    Correo c = correosSalida.get(i);
                    if(c.isEstatus()){
                        String linea = "";
                        linea += "Emisor: ";
                        linea += String.valueOf(c.getEmisor());
                        linea += "----";
                        linea += "Receptor: ";
                        linea += String.valueOf(c.getReceptor());
                        linea += "----";
                        linea += "Asunto: ";
                        linea += String.valueOf(c.getAsunto());
                        linea += "----";
                        linea += "Mensaje: ";
                        linea += String.valueOf(c.getMensaje());
                        linea += "----";
                        linea += "Fecha: ";
                        linea += date.format(c.getFechaTransaccion());
                        modelSalida.addElement(linea);
                    }
                }
                BandejaSalida.setModel(modelSalida);
            }
        } catch (Exception ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Charset UTF8 = Charset.forName("UTF-8");
    File rutaFoto = new File("C:\\MEIA\\Imagenes");
    File test = new File("C:\\MEIA\\test2.txt");
    static ArrayList<Integer> valores = new ArrayList<Integer>();
    static ArrayList<Integer> criterio = new ArrayList<Integer>();
    File archivo1 = new File("C:\\MEIA\\puntuacion.txt");
    File archivo2 = new File("C:\\MEIA\\resultado.txt");
    public static ArrayList<Correo> correosEntrada = new ArrayList<>();
    public static ArrayList<Correo> correosSalida = new ArrayList<>();
    
    public static String user;
    public Usuario us;
    public Lista lis;
    public Lista lisAs;
    public Usuario usAs;
    public static boolean primeraAsociacion;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelUsuario = new javax.swing.JPanel();
        labelImageFoto = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnAgregarLista = new javax.swing.JButton();
        jPanelEditar = new javax.swing.JPanel();
        txtContraseña = new javax.swing.JPasswordField();
        labelContraseña = new javax.swing.JLabel();
        labelEstatus = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        chbInactivo = new javax.swing.JCheckBox();
        labelFechaN = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        btnBuscarFoto = new javax.swing.JButton();
        labelFormatoFecha = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        labelFoto = new javax.swing.JLabel();
        chbActivo = new javax.swing.JCheckBox();
        labelPathFoto = new javax.swing.JLabel();
        btnGuardarContr = new javax.swing.JButton();
        labelLogo2 = new javax.swing.JLabel();
        boxOpEditar = new javax.swing.JComboBox<>();
        btnGuardarEsta = new javax.swing.JButton();
        btnGuardarFecha = new javax.swing.JButton();
        btnGuardarCorreo = new javax.swing.JButton();
        btnGuardarTele = new javax.swing.JButton();
        btnGuardarFoto = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanelBuscar = new javax.swing.JPanel();
        labelLogo3 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        btnBuscarUs = new javax.swing.JButton();
        labelBusqueda = new javax.swing.JLabel();
        jPanelListas = new javax.swing.JPanel();
        labelLogo4 = new javax.swing.JLabel();
        txtBusquedaLista = new javax.swing.JTextField();
        btnBuscarLista = new javax.swing.JButton();
        labelResultado = new javax.swing.JLabel();
        boxOpEditarL = new javax.swing.JComboBox<>();
        labelDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnGuardarDescripcion = new javax.swing.JButton();
        btnCancelarL = new javax.swing.JButton();
        labelEstado = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        labelEstatusL = new javax.swing.JLabel();
        chbActivoL = new javax.swing.JCheckBox();
        chbInactivoL = new javax.swing.JCheckBox();
        btnGuardarEstaL = new javax.swing.JButton();
        jPanelListaUsuario = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelGuardarAsociacion = new javax.swing.JPanel();
        labelLogo5 = new javax.swing.JLabel();
        txtBusquedaListaAsociacion = new javax.swing.JTextField();
        labelRLista = new javax.swing.JLabel();
        btnBuscarListaAsociacion = new javax.swing.JButton();
        txtBusquedaUsuarioAsociar = new javax.swing.JTextField();
        btnBuscarUsuarioAsociar = new javax.swing.JButton();
        labelRUsuario = new javax.swing.JLabel();
        btnGuardarAsociacion = new javax.swing.JButton();
        btnCancelarAsociacion = new javax.swing.JButton();
        jPanelEliminarAsociacion = new javax.swing.JPanel();
        btnGuardarEliminacion = new javax.swing.JButton();
        btnCancelarEliminacion = new javax.swing.JButton();
        labelRUsuarioEliminacion = new javax.swing.JLabel();
        txtBusquedaUsuarioEliminacion = new javax.swing.JTextField();
        labelRListaEliminacion = new javax.swing.JLabel();
        txtBusquedaListaEliminacion = new javax.swing.JTextField();
        btnBuscarListaEliminacion = new javax.swing.JButton();
        btnBuscarUsuarioEliminacion = new javax.swing.JButton();
        labelLogo6 = new javax.swing.JLabel();
        jPanelCorreo = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        BandejaEntrada = new javax.swing.JList<>();
        btnEliminarCorreosEntrada = new javax.swing.JButton();
        labelLogo11 = new javax.swing.JLabel();
        btnActualizarEntrada = new javax.swing.JButton();
        btnBuscarCorreo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        BandejaSalida = new javax.swing.JList<>();
        labelLogo12 = new javax.swing.JLabel();
        btnEliminarCorreosSalida = new javax.swing.JButton();
        btnActualizarSalida = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanelEnvioUsuario = new javax.swing.JPanel();
        labelLogo9 = new javax.swing.JLabel();
        labelUsuarioCorreoLocal = new javax.swing.JLabel();
        txtUsuarioCorreoLocal = new javax.swing.JTextField();
        txtAsuntoCorreoLocal = new javax.swing.JTextField();
        labelAsuntoCorreoLocal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtContenidoCorreoLocal = new javax.swing.JTextArea();
        btnEnviarLocal = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        labelLogo10 = new javax.swing.JLabel();
        labelListaCorreoLocal = new javax.swing.JLabel();
        txtListaCorreoLocal = new javax.swing.JTextField();
        txtAsuntoListaCorreoLocal = new javax.swing.JTextField();
        labelAsuntoListaCorreoLocal = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContenidoListaCorreoLocal = new javax.swing.JTextArea();
        btnEnviarListaLocal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtUsuarioCorreoRed = new javax.swing.JTextField();
        labelLogo8 = new javax.swing.JLabel();
        labelAsuntoRed = new javax.swing.JLabel();
        txtAsuntoRed = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContenidoCorreoRed = new javax.swing.JTextArea();
        btnEnviarRed = new javax.swing.JButton();
        labelUsuarioCorreo = new javax.swing.JLabel();
        opGrupo = new javax.swing.JComboBox<>();
        labelGrupo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNombre.setText("Nombre:");

        labelRol.setText("Rol:");

        labelLogo.setText("Aplicacion MEIA - Perfil de Usuario");

        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnAgregarLista.setText("Agregar Lista");
        btnAgregarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImageFoto)
                    .addComponent(labelNombre)
                    .addComponent(labelRol)
                    .addComponent(labelLogo)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(btnLogOut)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarLista)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(labelImageFoto)
                .addGap(37, 37, 37)
                .addComponent(labelNombre)
                .addGap(18, 18, 18)
                .addComponent(labelRol)
                .addGap(18, 18, 18)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(btnAgregarLista))
                .addGap(82, 82, 82))
        );

        jTabbedPane1.addTab("Usuario", jPanelUsuario);

        labelContraseña.setText("Contraseña:");

        labelEstatus.setText("Estatus:");

        chbInactivo.setText("Inactivo");

        labelFechaN.setText("Fecha de Nacimiento:");

        labelTelefono.setText("Telefono:");

        labelCorreo.setText("Correo Electronico:");

        btnBuscarFoto.setText("Buscar");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        labelFormatoFecha.setText("Formato: numDia/numMes/numAño");

        labelFoto.setText("Foto:");

        chbActivo.setText("Activo");

        btnGuardarContr.setText("Guardar");
        btnGuardarContr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContrActionPerformed(evt);
            }
        });

        labelLogo2.setText("Aplicacion MEIA - Edicion de Usuario");

        boxOpEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contraseña", "Estatus", "Fecha de Nacimiento", "Correo Electronico", "Telefono", "Foto" }));
        boxOpEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxOpEditarActionPerformed(evt);
            }
        });

        btnGuardarEsta.setText("Guardar");
        btnGuardarEsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstaActionPerformed(evt);
            }
        });

        btnGuardarFecha.setText("Guardar");
        btnGuardarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFechaActionPerformed(evt);
            }
        });

        btnGuardarCorreo.setText("Guardar");
        btnGuardarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCorreoActionPerformed(evt);
            }
        });

        btnGuardarTele.setText("Guardar");
        btnGuardarTele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTeleActionPerformed(evt);
            }
        });

        btnGuardarFoto.setText("Guardar");
        btnGuardarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFotoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEditarLayout = new javax.swing.GroupLayout(jPanelEditar);
        jPanelEditar.setLayout(jPanelEditarLayout);
        jPanelEditarLayout.setHorizontalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLogo2)
                            .addComponent(btnCancelar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addComponent(labelFechaN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 32, Short.MAX_VALUE)
                                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelFormatoFecha)))
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addComponent(labelContraseña)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addComponent(labelTelefono)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(26, 26, 26))
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addComponent(labelCorreo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addComponent(labelFoto)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarFoto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelPathFoto))
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addComponent(labelEstatus)
                                        .addGap(18, 18, 18)
                                        .addComponent(chbActivo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chbInactivo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardarEsta))
                                    .addComponent(boxOpEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarContr, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarTele, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarFecha, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanelEditarLayout.setVerticalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo2)
                .addGap(18, 18, 18)
                .addComponent(boxOpEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContraseña)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarContr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstatus)
                    .addComponent(chbActivo)
                    .addComponent(chbInactivo)
                    .addComponent(btnGuardarEsta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFechaN)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFormatoFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarTele))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPathFoto)
                    .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFoto)
                        .addComponent(btnBuscarFoto)
                        .addComponent(btnGuardarFoto)))
                .addGap(24, 24, 24)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Editar", jPanelEditar);

        labelLogo3.setText("Aplicacion MEIA - Verificacion de Usuario");

        btnBuscarUs.setText("Buscar Usuario");
        btnBuscarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarLayout = new javax.swing.GroupLayout(jPanelBuscar);
        jPanelBuscar.setLayout(jPanelBuscarLayout);
        jPanelBuscarLayout.setHorizontalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo3)
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarUs))
                    .addComponent(labelBusqueda))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanelBuscarLayout.setVerticalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo3)
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelBusqueda)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar", jPanelBuscar);

        labelLogo4.setText("Aplicacion MEIA - Manejo de Listas");

        btnBuscarLista.setText("Buscar Lista");
        btnBuscarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarListaActionPerformed(evt);
            }
        });

        boxOpEditarL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descripcion", "Estatus" }));
        boxOpEditarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxOpEditarLActionPerformed(evt);
            }
        });

        labelDescripcion.setText("Descripcion: ");

        btnGuardarDescripcion.setText("Guardar");
        btnGuardarDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDescripcionActionPerformed(evt);
            }
        });

        btnCancelarL.setText("Cancelar");
        btnCancelarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLActionPerformed(evt);
            }
        });

        labelEstado.setText("Estado: ");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVer.setText("Ver Datos");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        labelEstatusL.setText("Estatus:");

        chbActivoL.setText("Activo");

        chbInactivoL.setText("Inactivo");

        btnGuardarEstaL.setText("Guardar");
        btnGuardarEstaL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstaLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListasLayout = new javax.swing.GroupLayout(jPanelListas);
        jPanelListas.setLayout(jPanelListasLayout);
        jPanelListasLayout.setHorizontalGroup(
            jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelLogo4)
                    .addComponent(boxOpEditarL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelListasLayout.createSequentialGroup()
                        .addComponent(labelDescripcion)
                        .addGap(33, 33, 33)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarDescripcion))
                    .addComponent(btnCancelarL)
                    .addGroup(jPanelListasLayout.createSequentialGroup()
                        .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelListasLayout.createSequentialGroup()
                                .addComponent(labelEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelResultado)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVer))
                    .addGroup(jPanelListasLayout.createSequentialGroup()
                        .addComponent(labelEstatusL)
                        .addGap(18, 18, 18)
                        .addComponent(chbActivoL)
                        .addGap(18, 18, 18)
                        .addComponent(chbInactivoL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarEstaL)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanelListasLayout.setVerticalGroup(
            jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo4)
                .addGap(18, 18, 18)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelResultado)
                    .addComponent(labelEstado)
                    .addComponent(btnEditar)
                    .addComponent(btnVer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxOpEditarL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstatusL)
                    .addComponent(chbActivoL)
                    .addComponent(chbInactivoL)
                    .addComponent(btnGuardarEstaL))
                .addGap(18, 18, 18)
                .addComponent(btnCancelarL)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listas", jPanelListas);

        labelLogo5.setText("Aplicacion MEIA - Asociacion de Usuarios a Lista");

        labelRLista.setText("jLabel1");

        btnBuscarListaAsociacion.setText("Buscar Lista");
        btnBuscarListaAsociacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarListaAsociacionActionPerformed(evt);
            }
        });

        btnBuscarUsuarioAsociar.setText("Buscar Usuario");
        btnBuscarUsuarioAsociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioAsociarActionPerformed(evt);
            }
        });

        labelRUsuario.setText("jLabel1");

        btnGuardarAsociacion.setText("Guardar");
        btnGuardarAsociacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAsociacionActionPerformed(evt);
            }
        });

        btnCancelarAsociacion.setText("Cancelar");
        btnCancelarAsociacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAsociacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGuardarAsociacionLayout = new javax.swing.GroupLayout(jPanelGuardarAsociacion);
        jPanelGuardarAsociacion.setLayout(jPanelGuardarAsociacionLayout);
        jPanelGuardarAsociacionLayout.setHorizontalGroup(
            jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardarAsociacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGuardarAsociacionLayout.createSequentialGroup()
                        .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRLista)
                            .addComponent(labelLogo5)
                            .addComponent(labelRUsuario)
                            .addGroup(jPanelGuardarAsociacionLayout.createSequentialGroup()
                                .addComponent(btnGuardarAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelGuardarAsociacionLayout.createSequentialGroup()
                        .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaListaAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusquedaUsuarioAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarUsuarioAsociar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarListaAsociacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelGuardarAsociacionLayout.setVerticalGroup(
            jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardarAsociacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo5)
                .addGap(18, 18, 18)
                .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaListaAsociacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarListaAsociacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaUsuarioAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuarioAsociar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRUsuario)
                .addGap(18, 18, 18)
                .addGroup(jPanelGuardarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarAsociacion)
                    .addComponent(btnCancelarAsociacion))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Guardar", jPanelGuardarAsociacion);

        btnGuardarEliminacion.setText("Eliminar");
        btnGuardarEliminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEliminacionActionPerformed(evt);
            }
        });

        btnCancelarEliminacion.setText("Cancelar");
        btnCancelarEliminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEliminacionActionPerformed(evt);
            }
        });

        labelRUsuarioEliminacion.setText("jLabel1");

        labelRListaEliminacion.setText("jLabel1");

        btnBuscarListaEliminacion.setText("Buscar Lista");
        btnBuscarListaEliminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarListaEliminacionActionPerformed(evt);
            }
        });

        btnBuscarUsuarioEliminacion.setText("Buscar Usuario");
        btnBuscarUsuarioEliminacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioEliminacionActionPerformed(evt);
            }
        });

        labelLogo6.setText("Aplicacion MEIA -Eliminacion de Usuarios de Lista");

        javax.swing.GroupLayout jPanelEliminarAsociacionLayout = new javax.swing.GroupLayout(jPanelEliminarAsociacion);
        jPanelEliminarAsociacion.setLayout(jPanelEliminarAsociacionLayout);
        jPanelEliminarAsociacionLayout.setHorizontalGroup(
            jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarAsociacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEliminarAsociacionLayout.createSequentialGroup()
                        .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRListaEliminacion)
                            .addComponent(labelLogo6)
                            .addComponent(labelRUsuarioEliminacion)
                            .addGroup(jPanelEliminarAsociacionLayout.createSequentialGroup()
                                .addComponent(btnGuardarEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelEliminarAsociacionLayout.createSequentialGroup()
                        .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaListaEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusquedaUsuarioEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarUsuarioEliminacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarListaEliminacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelEliminarAsociacionLayout.setVerticalGroup(
            jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarAsociacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo6)
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaListaEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarListaEliminacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRListaEliminacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaUsuarioEliminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuarioEliminacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRUsuarioEliminacion)
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarAsociacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEliminacion)
                    .addComponent(btnCancelarEliminacion))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Eliminar", jPanelEliminarAsociacion);

        javax.swing.GroupLayout jPanelListaUsuarioLayout = new javax.swing.GroupLayout(jPanelListaUsuario);
        jPanelListaUsuario.setLayout(jPanelListaUsuarioLayout);
        jPanelListaUsuarioLayout.setHorizontalGroup(
            jPanelListaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanelListaUsuarioLayout.setVerticalGroup(
            jPanelListaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Lista - Usuario", jPanelListaUsuario);

        BandejaEntrada.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(BandejaEntrada);

        btnEliminarCorreosEntrada.setText("Eliminar");
        btnEliminarCorreosEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCorreosEntradaActionPerformed(evt);
            }
        });

        labelLogo11.setText("Aplicacion MEIA - Bandeja de entrada de Correos");

        btnActualizarEntrada.setText("Actualizar");
        btnActualizarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEntradaActionPerformed(evt);
            }
        });

        btnBuscarCorreo.setText("BuscarCorreo");
        btnBuscarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelLogo11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEliminarCorreosEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(btnActualizarEntrada)
                        .addGap(81, 81, 81)
                        .addComponent(btnBuscarCorreo)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarCorreosEntrada)
                    .addComponent(btnBuscarCorreo)
                    .addComponent(btnActualizarEntrada))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bandeja de Entrada", jPanel4);

        BandejaSalida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(BandejaSalida);

        labelLogo12.setText("Aplicacion MEIA - Bandeja de entrada de Correos");

        btnEliminarCorreosSalida.setText("Eliminar");
        btnEliminarCorreosSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCorreosSalidaActionPerformed(evt);
            }
        });

        btnActualizarSalida.setText("Actualizar");
        btnActualizarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelLogo12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnEliminarCorreosSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(btnActualizarSalida)
                        .addGap(178, 178, 178)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarCorreosSalida)
                    .addComponent(btnActualizarSalida))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bandeja de Salida", jPanel5);

        labelLogo9.setText("Aplicacion MEIA - Envio de Correos a Usuarios Locales");

        labelUsuarioCorreoLocal.setText("Usuario:");

        labelAsuntoCorreoLocal.setText("Asunto");

        txtContenidoCorreoLocal.setColumns(20);
        txtContenidoCorreoLocal.setRows(5);
        jScrollPane2.setViewportView(txtContenidoCorreoLocal);

        btnEnviarLocal.setText("Enviar");
        btnEnviarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEnvioUsuarioLayout = new javax.swing.GroupLayout(jPanelEnvioUsuario);
        jPanelEnvioUsuario.setLayout(jPanelEnvioUsuarioLayout);
        jPanelEnvioUsuarioLayout.setHorizontalGroup(
            jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnvioUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogo9)
                    .addGroup(jPanelEnvioUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAsuntoCorreoLocal)
                            .addComponent(labelUsuarioCorreoLocal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAsuntoCorreoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtUsuarioCorreoLocal)))
                    .addComponent(btnEnviarLocal))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelEnvioUsuarioLayout.setVerticalGroup(
            jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnvioUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo9)
                .addGap(18, 18, 18)
                .addGroup(jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioCorreoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuarioCorreoLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEnvioUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAsuntoCorreoLocal)
                    .addComponent(txtAsuntoCorreoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarLocal)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Usuario", jPanelEnvioUsuario);

        labelLogo10.setText("Aplicacion MEIA - Envio de Correos a Listas Locales");

        labelListaCorreoLocal.setText("Lista:");

        labelAsuntoListaCorreoLocal.setText("Asunto");

        txtContenidoListaCorreoLocal.setColumns(20);
        txtContenidoListaCorreoLocal.setRows(5);
        jScrollPane3.setViewportView(txtContenidoListaCorreoLocal);

        btnEnviarListaLocal.setText("Enviar");
        btnEnviarListaLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarListaLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogo10)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAsuntoListaCorreoLocal)
                            .addComponent(labelListaCorreoLocal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAsuntoListaCorreoLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtListaCorreoLocal)))
                    .addComponent(btnEnviarListaLocal))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo10)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtListaCorreoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelListaCorreoLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAsuntoListaCorreoLocal)
                    .addComponent(txtAsuntoListaCorreoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarListaLocal)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Lista Distribucion", jPanel8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane3.addTab("Envio Correo - Local", jPanel6);

        labelLogo8.setText("Aplicacion MEIA - Envio de Correos a Usuarios de Otros Grupos");

        labelAsuntoRed.setText("Asunto");

        txtContenidoCorreoRed.setColumns(20);
        txtContenidoCorreoRed.setRows(5);
        jScrollPane1.setViewportView(txtContenidoCorreoRed);

        btnEnviarRed.setText("Enviar");
        btnEnviarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarRedActionPerformed(evt);
            }
        });

        labelUsuarioCorreo.setText("Usuario:");

        opGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        labelGrupo.setText("Grupo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelLogo8)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelAsuntoRed)
                                .addComponent(labelUsuarioCorreo)
                                .addComponent(labelGrupo))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(opGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuarioCorreoRed, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAsuntoRed)))))
                    .addComponent(btnEnviarRed))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioCorreoRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuarioCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAsuntoRed)
                    .addComponent(txtAsuntoRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarRed)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Envio Correo - Grupos", jPanel2);

        javax.swing.GroupLayout jPanelCorreoLayout = new javax.swing.GroupLayout(jPanelCorreo);
        jPanelCorreo.setLayout(jPanelCorreoLayout);
        jPanelCorreoLayout.setHorizontalGroup(
            jPanelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanelCorreoLayout.setVerticalGroup(
            jPanelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Correo", jPanelCorreo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
     * Metodo de busqueda de una lista en base a un nombre de lista y el usuario 
     * @param fileName Archivo donde se buscara la lista
     * @param lista nombre de la lista que se busca
     * @return Objeto Lista con los valores encontrados
     * @throws IOException 
     */
    public Lista buscarLista(File fileName, String lista){
        Lista lis = new Lista();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        BufferedReader br = null;
	FileReader fr = null;
	try{
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
            if(texto.toString().equals("")){
                lis = null;
                return lis;
            }
            else{
                String[] contenido = texto.toString().split("\\r?\\n");
                for(int i = 0; i < contenido.length; i++){
                    try{
                        String[] listas = contenido[i].split("\\|");
                        if(quitarExtra(listas[0]).equals(lista) && quitarExtra(listas[1]).equals(user)){
                            lis.setNombreLista(quitarExtra(listas[0]).toCharArray());
                            lis.setUsuario(quitarExtra(listas[1]).toCharArray());
                            lis.setDescripcion(quitarExtra(listas[2]).toCharArray());
                            lis.setNumeroUsuarios(Integer.parseInt(listas[3]));
                            lis.setFechaCreacion(date.parse(listas[4]));
                            if(listas[5].equals("1")){
                                lis.setEstatus(true);
                            }
                            else{
                                lis.setEstatus(false);
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(String.valueOf(lis.getNombreLista()).equals(lista)){
            return lis;
        }
        else{
            lis = null;
            return lis;
        }
    }
    
    /**
     * Metodo de busqueda de una lista en base a un nombre de lista y el usuario 
     * @param fileName Archivo donde se buscara la lista
     * @param lista nombre de la lista que se busca
     * @return Objeto Lista con los valores encontrados
     * @throws IOException 
     */
    public Lista buscarListaAsociacion(File fileName, String lista) throws IOException{
        Lista lis = new Lista();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
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
        if(texto.toString().equals("")){
            return lis;
        }
        else{
            String[] contenido = texto.toString().split("\\r?\\n");
            for(int i = 0; i < contenido.length; i++){
                try{
                    String[] listas = contenido[i].split("\\|");
                    if(quitarExtra(listas[0]).equals(lista) && quitarExtra(listas[1]).equals(String.valueOf(us.getNombreDeUsuario()))){
                        lis.setNombreLista(quitarExtra(listas[0]).toCharArray());
                        lis.setUsuario(quitarExtra(listas[1]).toCharArray());
                        lis.setDescripcion(quitarExtra(listas[2]).toCharArray());
                        lis.setNumeroUsuarios(Integer.parseInt(listas[3]));
                        lis.setFechaCreacion(date.parse(listas[4]));
                        if(listas[5].equals("1")){
                            lis.setEstatus(true);
                        }
                        else{
                            lis.setEstatus(false);
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return lis;
    }
    
    /**
     * Bsca todos los usuarios relacionados a una lista de un usuario
     * @param fileName File donde se buscan los usuarios
     * @param lista lista a la que se esta buscando
     * @return ArrayList con los usuarios encontrados para la lista buscada
     * @throws IOException 
     */
    public ArrayList<String> buscarUsuariosAsociados(File fileName, String lista) throws IOException{
        ArrayList<String> usuarios = new ArrayList<>();
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
        if(texto.toString().equals("")){
            return usuarios;
        }
        else{
            String[] contenido = texto.toString().split("\\r?\\n");
            for(int i = 0; i < contenido.length; i++){
                try{
                    String[] valores = contenido[i].split("\\|");
                    if(quitarExtra(valores[0]).equals(lista) && quitarExtra(valores[1]).equals(String.valueOf(us.getNombreDeUsuario()))){
                        usuarios.add(quitarExtra(valores[2]));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return usuarios;
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
     * Boton de busqueda de nueva foto en para usuario
     * @param evt 
     */
    private void btnBuscarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoActionPerformed
        JFileChooser dialogo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagen files", ImageIO.getReaderFileSuffixes());
        File ficheroImagen;
        String rutaArchivo;
        dialogo.setFileFilter(filtro);
        int valor = dialogo.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION)
        {
            ficheroImagen = dialogo.getSelectedFile();
            rutaArchivo = ficheroImagen.getPath();
            String name = ficheroImagen.getName();
            rutaFoto.mkdirs();
            File foto = new File(rutaFoto, name);
            try{
                copiarArchivo(ficheroImagen, foto);
            }catch(Exception e){
                e.printStackTrace();
            }
            labelPathFoto.setText(foto.getPath());
            btnGuardarFoto.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarFotoActionPerformed

    /**
     * Boton de cerrar sesion
     * @param evt 
     */
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        try{
            reorganizacionSecuencialListas();
            reorganizacionIndizado();
        }catch(Exception e){
            e.printStackTrace();
        }
        dispose();
        VistaLogin v;
        try {
            v = new VistaLogin();
            v.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    /**
     * Choice box de seleccion de campo a editar del usuario
     * @param evt 
     */
    private void boxOpEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxOpEditarActionPerformed
        switch(boxOpEditar.getSelectedItem().toString()){
            case "Contraseña":
                labelContraseña.setVisible(true);
                btnGuardarContr.setVisible(true);
                txtContraseña.setVisible(true);
                break;
            case "Estatus":
                chbActivo.setVisible(true);
                chbInactivo.setVisible(true);
                btnGuardarEsta.setVisible(true);
                labelEstatus.setVisible(true);
                break;
            case "Fecha de Nacimiento":
                txtFechaNacimiento.setVisible(true);
                labelFechaN.setVisible(true);
                labelFormatoFecha.setVisible(true);
                btnGuardarFecha.setVisible(true);
                break;
            case "Correo Electronico":
                txtCorreo.setVisible(true);
                labelCorreo.setVisible(true);
                btnGuardarCorreo.setVisible(true);
                break;
            case "Telefono":
                txtTelefono.setVisible(true);
                labelTelefono.setVisible(true);
                btnGuardarTele.setVisible(true);
                break;
            case "Foto":
                labelPathFoto.setVisible(true);
                labelFoto.setVisible(true);
                btnBuscarFoto.setVisible(true);
                break;
        }
        boxOpEditar.setVisible(false);
    }//GEN-LAST:event_boxOpEditarActionPerformed

    /**
     * Boton que guarda el nuevo valor de contraseña para el usuario
     * @param evt 
     */
    private void btnGuardarContrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContrActionPerformed
        if((txtContraseña.getPassword().length > 0)){
            String texto = String.valueOf(txtContraseña.getPassword());
            if(!(calcularSeguridad(txtContraseña.getPassword()).equals("Contraseña Insegura"))){
                texto = encriptarContraseña(texto);
                texto = completarTexto(texto, 40);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 83);
                if(!val){
                     editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 83);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El nivel de seguridad de la contraseña es muy bajo", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de contraseña se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            us = buscarUsuario(String.valueOf(us.getNombreDeUsuario()));
        } catch (ParseException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarContrActionPerformed

    private void btnGuardarEstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstaActionPerformed
        String texto = null;
        if((chbActivo.isSelected()) || (chbInactivo.isSelected())){
            if((chbActivo.isSelected()) && (chbInactivo.isSelected())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar unicamente una opcion, administrador o usuario", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                if(chbActivo.isSelected()){
                    texto = "1";
                    if(us.isEstatus()){
                        JOptionPane.showMessageDialog(null, "El usuario ya se encuentra activo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        boolean val = editarUsuarioEstado(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 388, true);
                        if(!val){
                            editarUsuarioEstado(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 388, true);
                        }
                        dispose();
                        VistaLogin v;
                        try {
                            v = new VistaLogin();
                            v.setVisible(true);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(chbInactivo.isSelected()){
                    texto = "0";
                    if(!us.isEstatus()){
                        JOptionPane.showMessageDialog(null, "El usuario ya se encuentra inactivo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        boolean val = editarUsuarioEstado(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 388, false);
                        if(!val){
                            editarUsuarioEstado(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 388, false);
                        }
                    }
                }
            }
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna opcion para continuar", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            us = buscarUsuario(String.valueOf(us.getNombreDeUsuario()));
        } catch (ParseException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnGuardarEstaActionPerformed

    /**
     * Boton que guarda el nuevo valor de fecha de nacimiento para el usuario
     * @param evt 
     */
    private void btnGuardarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFechaActionPerformed
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        if(!(txtFechaNacimiento.getText().equals(""))){
            try {
                Date fecha = date.parse(txtFechaNacimiento.getText());
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, date.format(fecha), 126);
                if(!val){
                     editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, date.format(fecha), 126);
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha para continuar", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            us = buscarUsuario(String.valueOf(us.getNombreDeUsuario()));
        } catch (ParseException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarFechaActionPerformed

    /**
     * Boton que guarda el nuevo valor de correo electronico para el usuario
     * @param evt 
     */
    private void btnGuardarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCorreoActionPerformed
        if(!(txtCorreo.getText().equals(""))){
            if(!(txtCorreo.getText().toCharArray().length > 40)){
                String texto = txtCorreo.getText();
                texto = completarTexto(texto, 40);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 137);
                if(!val){
                     editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 137);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño del correo a excedido la longitud de 40 caracteres", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de correo se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            us = buscarUsuario(String.valueOf(us.getNombreDeUsuario()));
        } catch (ParseException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarCorreoActionPerformed

    /**
     * Boton que guarda el nuevo valor de telefono para el usuario
     * @param evt 
     */
    private void btnGuardarTeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTeleActionPerformed
        if(!(txtTelefono.getText().equals(""))){
            if(!(txtTelefono.getText().length() != 8)){
                try{
                    int num = Integer.parseInt(txtTelefono.getText());
                    String texto = String.valueOf(num);
                    boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 178);
                    if(!val){
                         editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 178);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                     JOptionPane.showMessageDialog(null, "El numero de telefono contiene caracteres erroneos", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El numero de telefono no cumple los parametros necasarios", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de telefono se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            us = buscarUsuario(String.valueOf(us.getNombreDeUsuario()));
        } catch (ParseException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarTeleActionPerformed

    /**
     * Boton que guarda la ubicacion de la nueva foto del usuario
     * @param evt 
     */
    private void btnGuardarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFotoActionPerformed
        if(!(labelPathFoto.getText().equals(""))){
            if(!(labelPathFoto.getText().toCharArray().length > 200)){
                String texto = labelPathFoto.getText();
                texto = completarTexto(texto, 200);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 187);
                if(!val){
                     editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 187);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño de la ubicacion de la foto a excedido la longitud de 200 caracteres", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de ubicacion de foto se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            us = buscarUsuario(String.valueOf(us.getNombreDeUsuario()));
        } catch (ParseException ex) {
            Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarFotoActionPerformed

    /**
     * Metodo de busqueda que verifica si un usuario existe o no
     * @param evt 
     */
    private void btnBuscarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsActionPerformed
        if(!(txtNom.getText().equals(""))){
            if(existeUsuario(txtNom.getText())){
                labelBusqueda.setText("El usuario buscado si existe");
            }
            else{
                labelBusqueda.setText("El usuario buscado no existe");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de busqueda de usuario se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarUsActionPerformed

    
    /**
     * Boton que cancela la edicion del campo actual para seleccionar otro campo a editar
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inicio();
        boxOpEditar.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarListaActionPerformed
        try{
            if((leerArchivo(Proyecto1.bitacoraLista).equals("")) && (leerArchivo(Proyecto1.maestroLista).equals(""))){
                VistaCrearLista.primeraLista = true;
            }
            VistaCrearLista.nombreUsuario = user;
            VistaCrearLista fr = new VistaCrearLista();
            fr.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarListaActionPerformed

    private void btnBuscarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarListaActionPerformed
        Lista ls1 = new Lista();
        Lista ls2 = new Lista();
        inicio2();
        try{
            if(!txtBusquedaLista.getText().trim().equals("")){
                ls1 = buscarListaAsociacion(Proyecto1.bitacoraLista, txtBusquedaLista.getText());
                ls2 = buscarListaAsociacion(Proyecto1.maestroLista, txtBusquedaLista.getText());
                if(String.valueOf(ls1.getNombreLista()).equals(txtBusquedaLista.getText())){
                    lis = ls1;
                    labelEstado.setVisible(true);
                    labelResultado.setVisible(true);
                    btnEditar.setVisible(true);
                    btnVer.setVisible(true);
                    labelResultado.setText("Lista Encontrada");
                }
                else if(String.valueOf(ls2.getNombreLista()).equals(txtBusquedaLista.getText().trim())){
                    lis = ls2;
                    labelEstado.setVisible(true);
                    labelResultado.setVisible(true);
                    btnEditar.setVisible(true);
                    btnVer.setVisible(true);
                    labelResultado.setText("Lista Encontrada");
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la lista", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de una lista a buscar para continuar", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarListaActionPerformed

    private void boxOpEditarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxOpEditarLActionPerformed
        switch(boxOpEditarL.getSelectedItem().toString()){
            case "Descripcion":
                labelDescripcion.setVisible(true);
                txtDescripcion.setVisible(true);
                btnGuardarDescripcion.setVisible(true);
                break;
            case "Estatus":
                chbActivoL.setVisible(true);
                chbInactivoL.setVisible(true);
                labelEstatusL.setVisible(true);
                btnGuardarEstaL.setVisible(true);
                break;
        }
        boxOpEditarL.setVisible(false);
    }//GEN-LAST:event_boxOpEditarLActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        boxOpEditarL.setVisible(true);
        labelResultado.setText("Lista Actual: " + txtBusquedaLista.getText());
        txtBusquedaLista.setText("");
        btnEditar.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDescripcionActionPerformed
        if(!(txtDescripcion.getText().equals(""))){
            if(!(txtDescripcion.getText().toCharArray().length > 40)){
                String texto = txtDescripcion.getText();
                texto = completarTexto(texto, 40);
                boolean val = editarLista(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 52);
                if(!val){
                     editarLista(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 52);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño de la descripcion a excedido la longitud de 40 caracteres", "InfoBox: " + "Error en Edicion de Lista", JOptionPane.INFORMATION_MESSAGE);
            }
            inicio2();
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de descripcion se encuentra vacio", "InfoBox: " + "Error en Edicion de Lista", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarL.setVisible(true);
        btnVer.setVisible(true);
        try {
            if(String.valueOf(buscarListaAsociacion(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista())).getNombreLista()).equals(String.valueOf(lis.getNombreLista()))){
                lis = buscarListaAsociacion(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista()));
            }
            else{
                lis = buscarListaAsociacion(Proyecto1.maestroLista, String.valueOf(lis.getNombreLista()));
            }
        } catch (Exception ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarDescripcionActionPerformed

    private void btnGuardarEstaLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstaLActionPerformed
        String texto = null;
        if((chbActivoL.isSelected()) || (chbInactivoL.isSelected())){
            if((chbActivoL.isSelected()) && (chbInactivoL.isSelected())){
                JOptionPane.showMessageDialog(null, "Debe seleccionar unicamente una opcion, activo o inactivo", "InfoBox: " + "Error en Edicion de Lista", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                if(chbActivoL.isSelected()){
                    texto = "1";
                    if(lis.isEstatus()){
                        JOptionPane.showMessageDialog(null, "La lista ya se encuentra activo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        boolean val = editarListaEstado(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 113, true);
                        if(!val){
                            editarListaEstado(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 113, true);
                        }
                    }
                }
                if(chbInactivoL.isSelected()){
                    texto = "0";
                    if(!lis.isEstatus()){
                        JOptionPane.showMessageDialog(null, "La lista ya se encuentra inactivo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        if(lis.getNumeroUsuarios() > 0){
                            JOptionPane.showMessageDialog(null, "Debe eliminar todos los usuarios relacionados a esta lista para eliminarla", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            boolean val = editarListaEstado(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 113, false);
                            if(!val){
                                editarListaEstado(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 113, false);
                            }
                        }
                    }
                }
                inicio2();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna opcion para continuar", "InfoBox: " + "Error en Edicion de Lista", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarL.setVisible(true);
        btnVer.setVisible(true);
        try {
            if(String.valueOf(buscarListaAsociacion(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista())).getNombreLista()).equals(String.valueOf(lis.getNombreLista()))){
                lis = buscarListaAsociacion(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista()));
            }
            else{
                lis = buscarListaAsociacion(Proyecto1.maestroLista, String.valueOf(lis.getNombreLista()));
            }
        } catch (Exception ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarEstaLActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        VistaDatosLista.ls = lis;
        VistaDatosLista vs = new VistaDatosLista();
        vs.setVisible(true);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnCancelarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLActionPerformed
        inicio2();
        boxOpEditarL.setVisible(true);
        btnVer.setVisible(true);
    }//GEN-LAST:event_btnCancelarLActionPerformed

    private void btnBuscarListaAsociacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarListaAsociacionActionPerformed
        Lista ls1 = new Lista();
        Lista ls2 = new Lista();
        inicio3();
        try{
            if(!txtBusquedaListaAsociacion.getText().trim().equals("")){
                ls1 = buscarListaAsociacion(Proyecto1.bitacoraLista, txtBusquedaListaAsociacion.getText());
                ls2 = buscarListaAsociacion(Proyecto1.maestroLista, txtBusquedaListaAsociacion.getText());
                if(String.valueOf(ls1.getNombreLista()).equals(txtBusquedaListaAsociacion.getText())){
                    if(ls1.isEstatus()){
                        lisAs = ls1;
                        labelRLista.setText("Lista Encontrada: " + txtBusquedaListaAsociacion.getText());
                        txtBusquedaListaAsociacion.setVisible(false);
                        btnBuscarListaAsociacion.setVisible(false);
                        txtBusquedaUsuarioAsociar.setVisible(true);
                        btnBuscarUsuarioAsociar.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La lista buscada no se encuentra activa", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(String.valueOf(ls2.getNombreLista()).equals(txtBusquedaListaAsociacion.getText().trim())){
                    if(ls2.isEstatus()){
                        lisAs = ls2;
                        labelRLista.setText("Lista Encontrada: " + txtBusquedaListaAsociacion.getText());
                        txtBusquedaListaAsociacion.setVisible(false);
                        btnBuscarListaAsociacion.setVisible(false);
                        txtBusquedaUsuarioAsociar.setVisible(true);
                        btnBuscarUsuarioAsociar.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La lista buscada no se encuentra activa", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la lista", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de una lista a buscar para continuar", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarListaAsociacionActionPerformed

    private void btnBuscarUsuarioAsociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioAsociarActionPerformed
        Usuario usu = new Usuario();
        int cont = 0;
        try{
            if(!txtBusquedaUsuarioAsociar.getText().trim().equals("")){
                ArrayList<String> usuarios = buscarUsuariosAsociados(Proyecto1.bitacoraListaUsuario, String.valueOf(lisAs.getNombreLista()));
                usu = buscarUsuario(txtBusquedaUsuarioAsociar.getText());
                for(int i = 0; i < usuarios.size(); i++){
                    if(usuarios.get(i).equals(String.valueOf(usu.getNombreDeUsuario()))){
                        cont++;
                    }
                }
                if(!String.valueOf(usu.getNombreDeUsuario()).equals(String.valueOf(us.getNombreDeUsuario()))){
                    if(cont == 0){
                        if(String.valueOf(usu.getNombreDeUsuario()).equals(txtBusquedaUsuarioAsociar.getText())){
                            if(usu.isEstatus()){
                                usAs = usu;
                                txtBusquedaUsuarioAsociar.setVisible(false);
                                btnBuscarUsuarioAsociar.setVisible(false);
                                labelRUsuario.setVisible(true);
                                labelRUsuario.setText("Usuario Encontrado: " + txtBusquedaUsuarioAsociar.getText());
                                btnGuardarAsociacion.setVisible(true);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "El usuario buscado no se encuentra activa", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No se ha encontrado el Usuario", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "NO se puede asociar un usuario ya existente en la lista", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se puede asociar el propietario de la lista a la lista", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de un usuario a buscar para continuar", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarUsuarioAsociarActionPerformed

    private void btnCancelarAsociacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAsociacionActionPerformed
        inicio3();
        txtBusquedaListaAsociacion.setVisible(true);
        txtBusquedaListaAsociacion.setText("");
        btnBuscarListaAsociacion.setVisible(true);
        txtBusquedaUsuarioAsociar.setText("");
        lisAs = new Lista();
        usAs = new Usuario();
    }//GEN-LAST:event_btnCancelarAsociacionActionPerformed

    private void btnGuardarAsociacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAsociacionActionPerformed
        try{
            if((leerArchivo(Proyecto1.bitacoraListaUsuario).equals("")) && (leerArchivo(Proyecto1.IndiceListaUsuario).equals(""))){
                MenuUsuario.primeraAsociacion = true;
            }
            else{
                MenuUsuario.primeraAsociacion = false;
            }
            ListaUsuario lsUs = new ListaUsuario();
            lsUs.setNombreLista(lisAs.getNombreLista());
            lsUs.setUsuario(lisAs.getUsuario());
            lsUs.setUsuarioAsociado(usAs.getNombreDeUsuario());
            lsUs.setDescripcion(lisAs.getDescripcion());
            lsUs.setFechaCreacion(new Date());
            lsUs.setEstatus(true);
            IndiceListaUsuario inLsUs = new IndiceListaUsuario();
            long regLI = tamañoDeArchivo(Proyecto1.IndiceListaUsuario);
            if(regLI != 0){
                inLsUs.setNumeroRegistro(((int) regLI/85) + 1);
            }
            else{
                inLsUs.setNumeroRegistro(1);
            }
            long regLU = tamañoDeArchivo(Proyecto1.bitacoraListaUsuario);
            if(regLU != 0){
                inLsUs.setPosicion(((int) regLU/134) + 1);
            }
            else{
                inLsUs.setPosicion(1);
            }
            inLsUs.setNombreLista(lisAs.getNombreLista());
            inLsUs.setUsuario(lisAs.getUsuario());
            inLsUs.setUsuarioAsociado(usAs.getNombreDeUsuario());
            inLsUs.setEstatus(true);
            String texto = "";
            if((lisAs.getNumeroUsuarios() + 1) < 10){
                texto += "0";
                texto += lisAs.getNumeroUsuarios() + 1;
            }
            else{
                texto += lisAs.getNumeroUsuarios() + 1;
            }
            if(MenuUsuario.primeraAsociacion){
                inLsUs.setSiguiente(0);
                escribirListaUsuario(Proyecto1.bitacoraListaUsuario, lsUs);
                escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, inLsUs);
                boolean val = editarNumeroUsuariosLista(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 93);
                if(!val){
                     editarNumeroUsuariosLista(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 93);
                }
                escribirDescriptor(Proyecto1.descBitacoraListaUsuario, new DescUsuario_Lista("bitacora_asociacion_usuario-lista", new Date(), String.valueOf(lisAs.getUsuario()), new Date(), String.valueOf(lisAs.getUsuario()), 1, 1, 0, -1));
                escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario("indice_asociacion_usuario-lista", new Date(), String.valueOf(lisAs.getUsuario()), new Date(), String.valueOf(lisAs.getUsuario()), 1, 1, 0, 1));
                JOptionPane.showMessageDialog(null, "La asociacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                escribirListaUsuario(Proyecto1.bitacoraListaUsuario, lsUs);
                boolean val = editarNumeroUsuariosLista(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 93);
                if(!val){
                     editarNumeroUsuariosLista(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 93);
                }
                DescUsuario_Lista descLU = leerDescriptor(Proyecto1.descBitacoraListaUsuario);
                limpiarArchivo(Proyecto1.descBitacoraListaUsuario);
                escribirDescriptor(Proyecto1.descBitacoraListaUsuario, new DescUsuario_Lista(descLU.getNombreSimbolico(), descLU.getFechaCreacion(), descLU.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descLU.getNumRegistros() + 1, descLU.getRegistrosActivos() + 1, descLU.getRegistrosInactivos(), descLU.getMaxReorganizacion()));
                DescIndiceListaUsuario descI = leerDescriptorIndice(Proyecto1.descIndiceListaUsuario);
                IndiceListaUsuario actual;
                IndiceListaUsuario previo;
                if(inLsUs.getNumeroRegistro() < 3){
                    actual = leerIndice(Proyecto1.IndiceListaUsuario, descI.getRegistroInicial());
                    if(comparar(inLsUs, actual) < 0){
                        descI.setRegistroInicial(inLsUs.getNumeroRegistro());
                        inLsUs.setSiguiente(actual.getNumeroRegistro());
                        limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                        escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros() + 1, descI.getRegistrosActivos() + 1, descI.getRegistrosInactivos(), descI.getRegistroInicial()));
                        escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, inLsUs);
                        JOptionPane.showMessageDialog(null, "La asociacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        actual.setSiguiente(inLsUs.getNumeroRegistro());
                        inLsUs.setSiguiente(0);
                        escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, inLsUs);
                        limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                        escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros() + 1, descI.getRegistrosActivos() + 1, descI.getRegistrosInactivos(), descI.getRegistroInicial()));
                        editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, actual);
                        JOptionPane.showMessageDialog(null, "La asociacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    actual = leerIndice(Proyecto1.IndiceListaUsuario, descI.getRegistroInicial());
                    if(comparar(inLsUs, actual) < 0){
                        descI.setRegistroInicial(inLsUs.getNumeroRegistro());
                        inLsUs.setSiguiente(actual.getNumeroRegistro());
                        limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                        escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros() + 1, descI.getRegistrosActivos() + 1, descI.getRegistrosInactivos(), descI.getRegistroInicial()));
                        escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, inLsUs);
                        JOptionPane.showMessageDialog(null, "La asociacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        previo = actual;
                        actual = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                        boolean fin = true;
                        do{
                            if(comparar(inLsUs, actual) < 0){
                                previo.setSiguiente(inLsUs.getNumeroRegistro());
                                inLsUs.setSiguiente(actual.getNumeroRegistro());
                                limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros() + 1, descI.getRegistrosActivos() + 1, descI.getRegistrosInactivos(), descI.getRegistroInicial()));
                                escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, inLsUs);
                                editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, previo);
                                fin = false;
                                break;
                            }
                            else{
                                if(actual.getSiguiente() == 0){
                                    inLsUs.setSiguiente(0);
                                    actual.setSiguiente(inLsUs.getNumeroRegistro());
                                    escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, inLsUs);
                                    limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                    escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros() + 1, descI.getRegistrosActivos() + 1, descI.getRegistrosInactivos(), descI.getRegistroInicial()));
                                    editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, actual);
                                    fin = false;
                                    break;
                                }
                                else{
                                    previo = actual;
                                    actual = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente()); 
                                }
                            }
                        }while(fin);
                        JOptionPane.showMessageDialog(null, "La asociacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            inicio3();
            txtBusquedaListaAsociacion.setVisible(true);
            txtBusquedaListaAsociacion.setText("");
            btnBuscarListaAsociacion.setVisible(true);
            txtBusquedaUsuarioAsociar.setText("");
            lisAs = new Lista();
            usAs = new Usuario();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarAsociacionActionPerformed

    private void btnGuardarEliminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEliminacionActionPerformed
        try{
            if((!leerArchivo(Proyecto1.bitacoraListaUsuario).equals("")) && (!leerArchivo(Proyecto1.IndiceListaUsuario).equals(""))){
                long numeroRegistros = tamañoDeArchivo(Proyecto1.IndiceListaUsuario);
                if(numeroRegistros > 0){
                    numeroRegistros = numeroRegistros/85;
                    IndiceListaUsuario inLsUs = new IndiceListaUsuario();
                    inLsUs.setNombreLista(lisAs.getNombreLista());
                    inLsUs.setUsuario(lisAs.getUsuario());
                    inLsUs.setUsuarioAsociado(usAs.getNombreDeUsuario());
                    String texto = "";
                    if((lisAs.getNumeroUsuarios() - 1) < 10){
                        texto += "0";
                        texto += lisAs.getNumeroUsuarios() - 1;
                    }
                    else{
                        texto += lisAs.getNumeroUsuarios() - 1;
                    }
                    boolean val = editarNumeroUsuariosLista(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 93);
                    if(!val){
                         editarNumeroUsuariosLista(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 93);
                    }
                    DescIndiceListaUsuario descI = leerDescriptorIndice(Proyecto1.descIndiceListaUsuario);
                    IndiceListaUsuario actual;
                    IndiceListaUsuario previo;
                    IndiceListaUsuario siguiente;
                    if(numeroRegistros == 1){
                        actual = leerIndice(Proyecto1.IndiceListaUsuario, descI.getRegistroInicial());
                        actual.setEstatus(false);
                        limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                        escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos() - 1, descI.getRegistrosInactivos() + 1, descI.getRegistroInicial()));
                        editarEstadoIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 82, actual);
                        editarEstadoAsociacion(Proyecto1.bitacoraListaUsuario, Proyecto1.descBitacoraListaUsuario, actual.getPosicion(), inLsUs);
                        JOptionPane.showMessageDialog(null, "La eliminacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        if(numeroRegistros < 3){
                            actual = leerIndice(Proyecto1.IndiceListaUsuario, descI.getRegistroInicial());
                            if(comparar(inLsUs, actual) == 0){
                                descI.setRegistroInicial(actual.getSiguiente());
                                limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos() - 1, descI.getRegistrosInactivos() + 1, descI.getRegistroInicial()));
                                actual.setEstatus(false);
                                editarEstadoIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 82, actual);
                                siguiente = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                                siguiente.setSiguiente(0);
                                editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, siguiente);
                                editarEstadoAsociacion(Proyecto1.bitacoraListaUsuario, Proyecto1.descBitacoraListaUsuario, actual.getPosicion(), inLsUs);
                                JOptionPane.showMessageDialog(null, "La eliminacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                siguiente = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                                siguiente.setEstatus(false);
                                actual.setSiguiente(0);
                                limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos() - 1, descI.getRegistrosInactivos() + 1, descI.getRegistroInicial()));
                                editarEstadoIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 82, siguiente);
                                editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, actual);
                                editarEstadoAsociacion(Proyecto1.bitacoraListaUsuario, Proyecto1.descBitacoraListaUsuario, siguiente.getPosicion(), inLsUs);
                                JOptionPane.showMessageDialog(null, "La eliminacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else{
                            actual = leerIndice(Proyecto1.IndiceListaUsuario, descI.getRegistroInicial());
                            if(comparar(inLsUs, actual) == 0){
                                descI.setRegistroInicial(actual.getSiguiente());
                                limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos() - 1, descI.getRegistrosInactivos() + 1, descI.getRegistroInicial()));
                                actual.setEstatus(false);
                                editarEstadoIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 82, actual);
                                editarEstadoAsociacion(Proyecto1.bitacoraListaUsuario, Proyecto1.descBitacoraListaUsuario, actual.getPosicion(), inLsUs);
                                JOptionPane.showMessageDialog(null, "La eliminacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                previo = actual;
                                actual = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                                boolean fin = true;
                                do{
                                    if(comparar(inLsUs, actual) == 0){
                                        previo.setSiguiente(actual.getSiguiente());
                                        actual.setEstatus(false);
                                        limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                        escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos() - 1, descI.getRegistrosInactivos() + 1, descI.getRegistroInicial()));
                                        editarEstadoIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 82, actual);
                                        editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, previo);
                                        editarEstadoAsociacion(Proyecto1.bitacoraListaUsuario, Proyecto1.descBitacoraListaUsuario, actual.getPosicion(), inLsUs);
                                        fin = false;
                                        break;
                                    }
                                    else{
                                        previo = actual;
                                        actual = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente()); 
                                    }
                                }while(fin);
                                JOptionPane.showMessageDialog(null, "La eliminacion se realizo exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay asociaciones que se puedan eliminar", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
            inicio4();
            txtBusquedaListaEliminacion.setVisible(true);
            txtBusquedaListaEliminacion.setText("");
            btnBuscarListaEliminacion.setVisible(true);
            txtBusquedaUsuarioEliminacion.setText("");
            lisAs = new Lista();
            usAs = new Usuario();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarEliminacionActionPerformed

    private void btnCancelarEliminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEliminacionActionPerformed
        inicio4();
        txtBusquedaListaEliminacion.setVisible(true);
        txtBusquedaListaEliminacion.setText("");
        btnBuscarListaEliminacion.setVisible(true);
        txtBusquedaUsuarioEliminacion.setText("");
        lisAs = new Lista();
        usAs = new Usuario();
    }//GEN-LAST:event_btnCancelarEliminacionActionPerformed

    private void btnBuscarListaEliminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarListaEliminacionActionPerformed
        Lista ls1 = new Lista();
        Lista ls2 = new Lista();
        inicio4();
        try{
            if(!txtBusquedaListaEliminacion.getText().trim().equals("")){
                ls1 = buscarListaAsociacion(Proyecto1.bitacoraLista, txtBusquedaListaEliminacion.getText());
                ls2 = buscarListaAsociacion(Proyecto1.maestroLista, txtBusquedaListaEliminacion.getText());
                if(String.valueOf(ls1.getNombreLista()).equals(txtBusquedaListaEliminacion.getText())){
                    if(ls1.isEstatus()){
                        lisAs = ls1;
                        labelRListaEliminacion.setText("Lista Encontrada: " + txtBusquedaListaEliminacion.getText());
                        txtBusquedaListaEliminacion.setVisible(false);
                        btnBuscarListaEliminacion.setVisible(false);
                        txtBusquedaUsuarioEliminacion.setVisible(true);
                        btnBuscarUsuarioEliminacion.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La lista buscada no se encuentra activa", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(String.valueOf(ls2.getNombreLista()).equals(txtBusquedaListaEliminacion.getText().trim())){
                    if(ls2.isEstatus()){
                        lisAs = ls2;
                        labelRListaEliminacion.setText("Lista Encontrada: " + txtBusquedaListaEliminacion.getText());
                        txtBusquedaListaEliminacion.setVisible(false);
                        btnBuscarListaEliminacion.setVisible(false);
                        txtBusquedaUsuarioEliminacion.setVisible(true);
                        btnBuscarUsuarioEliminacion.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La lista buscada no se encuentra activa", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la lista", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de una lista a buscar para continuar", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarListaEliminacionActionPerformed

    private void btnBuscarUsuarioEliminacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioEliminacionActionPerformed
        Usuario usu = new Usuario();
        try{
            if(!txtBusquedaUsuarioEliminacion.getText().trim().equals("")){
                ArrayList<String> usuarios = buscarUsuariosAsociados(Proyecto1.bitacoraListaUsuario, String.valueOf(lisAs.getNombreLista()));
                for(int i = 0; i < usuarios.size(); i++){
                    if(String.valueOf(buscarUsuario(usuarios.get(i)).getNombreDeUsuario()).equals(txtBusquedaUsuarioEliminacion.getText().trim())){
                        usu = buscarUsuario(usuarios.get(i));
                    }
                }
                if(String.valueOf(usu.getNombreDeUsuario()).equals(txtBusquedaUsuarioEliminacion.getText())){
                    if(usu.isEstatus()){
                        usAs = usu;
                        txtBusquedaUsuarioEliminacion.setVisible(false);
                        btnBuscarUsuarioEliminacion.setVisible(false);
                        labelRUsuarioEliminacion.setVisible(true);
                        labelRUsuarioEliminacion.setText("Usuario Encontrado: " + txtBusquedaUsuarioEliminacion.getText());
                        btnGuardarEliminacion.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El usuario buscado no se encuentra activa", "InfoBox: " + "Error en Busqueda de Lista", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el Usuario", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de un usuario a buscar para continuar", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarUsuarioEliminacionActionPerformed

    private void btnEliminarCorreosEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreosEntradaActionPerformed
        if(BandejaEntrada.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un correo a eliminar", "InfoBox: " + "Error en eliminacion de corre", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try{
                DescIndiceListaUsuario descN;
                Correo raiz;
                Correo eliminar;
                Correo padre;
                descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
                raiz = leerCorreo(Proyecto1.arbolCorreos, descN.getRegistroInicial());
                String datos = BandejaEntrada.getSelectedValue();
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
                Correo c = new Correo();
                String[] valores = datos.split("----");
                String[] val = valores[0].split(":");
                c.setEmisor(val[1].trim().toCharArray());
                val = valores[1].split(":");
                c.setReceptor(val[1].trim().toCharArray());
                val = valores[2].split(":");
                c.setAsunto(val[1].trim().toCharArray());
                val = valores[3].split(":");
                c.setMensaje(val[1].trim().toCharArray());
                val = valores[4].split(":");
                c.setFechaTransaccion(date.parse(val[1].concat(":" + val[2]).replace(" ", "")));
                eliminar = buscarCorreo(raiz, c);
                padre = buscarPadre(raiz, c);
                if(padre != null){
                    if(comparar(eliminar, padre) < 0){
                        if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() == -1){
                            padre.setIzquierdo(-1);
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() != -1){
                            padre.setIzquierdo(eliminar.getDerecho());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() == -1){
                            padre.setIzquierdo(eliminar.getIzquierdo());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() != -1){
                            padre.setIzquierdo(buscarMasIzquierdoDeLadoDerecho(eliminar));
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                    }
                    if(comparar(eliminar, padre) > 0){
                        if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() == -1){
                            padre.setDerecho(-1);
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() != -1){
                            padre.setDerecho(eliminar.getDerecho());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() == -1){
                            padre.setDerecho(eliminar.getIzquierdo());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() != -1){
                            padre.setDerecho(buscarMasIzquierdoDeLadoDerecho(eliminar));
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                    }
                    limpiarArchivo(Proyecto1.descArbolCorreos);
                    escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros(), descN.getRegistrosActivos() - 1, descN.getRegistrosInactivos() + 1, descN.getRegistroInicial()));
                }
                else{
                    descN.setRegistroInicial(buscarMasIzquierdoDeLadoDerecho(eliminar));
                    limpiarArchivo(Proyecto1.descArbolCorreos);
                    escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros(), descN.getRegistrosActivos() - 1, descN.getRegistrosInactivos() + 1, descN.getRegistroInicial()));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        iniciarBandejas();
    }//GEN-LAST:event_btnEliminarCorreosEntradaActionPerformed

    private void btnActualizarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEntradaActionPerformed
        try{
            reorganizacionArbol();
        }catch(Exception e){
            e.printStackTrace();
        }
        iniciarBandejas();
    }//GEN-LAST:event_btnActualizarEntradaActionPerformed

    private void btnEliminarCorreosSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreosSalidaActionPerformed
        if(BandejaSalida.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un correo a eliminar", "InfoBox: " + "Error en eliminacion de corre", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try{
                DescIndiceListaUsuario descN;
                Correo raiz;
                Correo eliminar;
                Correo padre;
                descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
                raiz = leerCorreo(Proyecto1.arbolCorreos, descN.getRegistroInicial());
                String datos = BandejaSalida.getSelectedValue();
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
                Correo c = new Correo();
                String[] valores = datos.split("----");
                String[] val = valores[0].split(":");
                c.setEmisor(val[1].trim().toCharArray());
                val = valores[1].split(":");
                c.setReceptor(val[1].trim().toCharArray());
                val = valores[2].split(":");
                c.setAsunto(val[1].trim().toCharArray());
                val = valores[3].split(":");
                c.setMensaje(val[1].trim().toCharArray());
                val = valores[4].split(":");
                c.setFechaTransaccion(date.parse(val[1].concat(":" + val[2]).replace(" ", "")));
                eliminar = buscarCorreo(raiz, c);
                padre = buscarPadre(raiz, c);
                if(padre != null){
                    if(comparar(eliminar, padre) < 0){
                        if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() == -1){
                            padre.setIzquierdo(-1);
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() != -1){
                            padre.setIzquierdo(eliminar.getDerecho());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() == -1){
                            padre.setIzquierdo(eliminar.getIzquierdo());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() != -1){
                            padre.setIzquierdo(buscarMasIzquierdoDeLadoDerecho(eliminar));
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                    }
                    if(comparar(eliminar, padre) > 0){
                        if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() == -1){
                            padre.setDerecho(-1);
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() == -1 && eliminar.getDerecho() != -1){
                            padre.setDerecho(eliminar.getDerecho());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() == -1){
                            padre.setDerecho(eliminar.getIzquierdo());
                            eliminar.setEstatus(false);
                            editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), eliminar);
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                        else if(eliminar.getIzquierdo() != -1 && eliminar.getDerecho() != -1){
                            padre.setDerecho(buscarMasIzquierdoDeLadoDerecho(eliminar));
                            editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), padre);
                        }
                    }
                    limpiarArchivo(Proyecto1.descArbolCorreos);
                    escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros(), descN.getRegistrosActivos() - 1, descN.getRegistrosInactivos() + 1, descN.getRegistroInicial()));
                }
                else{
                    descN.setRegistroInicial(buscarMasIzquierdoDeLadoDerecho(eliminar));
                    limpiarArchivo(Proyecto1.descArbolCorreos);
                    escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros(), descN.getRegistrosActivos() - 1, descN.getRegistrosInactivos() + 1, descN.getRegistroInicial()));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        iniciarBandejas();
    }//GEN-LAST:event_btnEliminarCorreosSalidaActionPerformed

    private void btnActualizarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSalidaActionPerformed
        try{
            reorganizacionArbol();
        }catch(Exception e){
            e.printStackTrace();
        }
        iniciarBandejas();
    }//GEN-LAST:event_btnActualizarSalidaActionPerformed

    private void btnEnviarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarLocalActionPerformed
        if(txtUsuarioCorreoLocal.getText().equals("") || (txtAsuntoCorreoLocal.getText().equals("")) || (txtContenidoCorreoLocal.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "Algun campo del correo se encuentra vacio, por favor ingrese todos los campos", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            if(existeUsuario(txtUsuarioCorreoLocal.getText())){
                Correo c = new Correo();
                c.setEmisor(user.toCharArray());
                c.setReceptor(txtUsuarioCorreoLocal.getText().toCharArray());
                c.setAsunto(txtAsuntoCorreoLocal.getText().toCharArray());
                c.setMensaje(txtContenidoCorreoLocal.getText().toCharArray());
                c.setEstatus(true);
                c.setFechaTransaccion(new Date());
                c.setIzquierdo(-1);
                c.setDerecho(-1);
                DescIndiceListaUsuario descN;
                Correo actual;
                try{
                    long tamaño = tamañoDeArchivo(Proyecto1.arbolCorreos);
                    int cant = 0;
                    if(tamaño > 0){
                        cant = (int)tamaño/200;
                    }
                    if(cant == 0){
                        escribirCorreo(Proyecto1.arbolCorreos, c);
                        descN = new DescIndiceListaUsuario("bitacora_de_correos", c.getFechaTransaccion(), user, c.getFechaTransaccion(), user, 1, 1, 0, 1);
                        escribirDescriptor(Proyecto1.descArbolCorreos, descN);
                        JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(cant < 2){
                        descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
                        actual = leerCorreo(Proyecto1.arbolCorreos, descN.getRegistroInicial());
                        if(comparar(c, actual) < 0){
                            if(actual.getIzquierdo() == -1){
                                escribirCorreo(Proyecto1.arbolCorreos, c);
                                actual.setIzquierdo(cant + 1);
                                editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), actual);
                                limpiarArchivo(Proyecto1.descArbolCorreos);
                                escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros() + 1, descN.getRegistrosActivos() + 1, descN.getRegistrosInactivos(), descN.getRegistroInicial()));
                                JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else if(comparar(c, actual) > 0){
                            if(actual.getDerecho() == -1){
                                escribirCorreo(Proyecto1.arbolCorreos, c);
                                actual.setDerecho(cant + 1);
                                editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), actual);
                                limpiarArchivo(Proyecto1.descArbolCorreos);
                                escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros() + 1, descN.getRegistrosActivos() + 1, descN.getRegistrosInactivos(), descN.getRegistroInicial()));
                                JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    else if (cant >= 2){
                        descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
                        editarRecursivo(descN.getRegistroInicial(), c, cant, descN.getRegistroInicial());
                        limpiarArchivo(Proyecto1.descArbolCorreos);
                        escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros() + 1, descN.getRegistrosActivos() + 1, descN.getRegistrosInactivos(), descN.getRegistroInicial()));
                        JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                txtUsuarioCorreoLocal.setText("");
                txtAsuntoCorreoLocal.setText("");
                txtContenidoCorreoLocal.setText("");
                iniciarBandejas();
            }
            else{
                JOptionPane.showMessageDialog(null, "El usuario al que dese enviar correo no existe", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEnviarLocalActionPerformed

    private void btnEnviarListaLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarListaLocalActionPerformed
        if(txtListaCorreoLocal.getText().equals("") || (txtAsuntoListaCorreoLocal.getText().equals("")) || (txtContenidoListaCorreoLocal.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "Algun campo del correo se encuentra vacio, por favor ingrese todos los campos", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Lista lis = new Lista();
            try{
                if(String.valueOf(buscarLista(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista())).getNombreLista()).equals(String.valueOf(lis.getNombreLista()))){
                    lis = buscarLista(Proyecto1.bitacoraLista, txtListaCorreoLocal.getText());
                }
                else{
                    lis = buscarLista(Proyecto1.maestroLista, txtListaCorreoLocal.getText());
                }
                if(lis != null){
                    ArrayList<String> usuarios = buscarUsuariosAsociados(Proyecto1.bitacoraListaUsuario, String.valueOf(lis.getNombreLista()));
                    Correo c = new Correo();
                    c.setEmisor(user.toCharArray());
                    c.setAsunto(txtAsuntoListaCorreoLocal.getText().toCharArray());
                    c.setMensaje(txtContenidoListaCorreoLocal.getText().toCharArray());
                    c.setEstatus(true);
                    c.setFechaTransaccion(new Date());
                    c.setIzquierdo(-1);
                    c.setDerecho(-1);
                    DescIndiceListaUsuario descN;
                    Correo actual;
                    long tamaño = tamañoDeArchivo(Proyecto1.arbolCorreos);
                    int cant = 0;
                    if(usuarios.size() > 0){
                        for(int i = 0; i < usuarios.size(); i++){
                            c.setReceptor(usuarios.get(i).toCharArray());
                            if(tamaño > 0){
                                cant = (int)tamaño/200;
                            }
                            if(cant == 0){
                                escribirCorreo(Proyecto1.arbolCorreos, c);
                                descN = new DescIndiceListaUsuario("bitacora_de_correos", c.getFechaTransaccion(), user, c.getFechaTransaccion(), user, 1, 1, 0, 1);
                                escribirDescriptor(Proyecto1.descArbolCorreos, descN);
                                JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else if(cant < 2){
                                descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
                                actual = leerCorreo(Proyecto1.arbolCorreos, descN.getRegistroInicial());
                                if(comparar(c, actual) < 0){
                                    if(actual.getIzquierdo() == -1){
                                        escribirCorreo(Proyecto1.arbolCorreos, c);
                                        actual.setIzquierdo(cant + 1);
                                        editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), actual);
                                        limpiarArchivo(Proyecto1.descArbolCorreos);
                                        escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros() + 1, descN.getRegistrosActivos() + 1, descN.getRegistrosInactivos(), descN.getRegistroInicial()));
                                        JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                                else if(comparar(c, actual) > 0){
                                    if(actual.getDerecho() == -1){
                                        escribirCorreo(Proyecto1.arbolCorreos, c);
                                        actual.setDerecho(cant + 1);
                                        editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), actual);
                                        limpiarArchivo(Proyecto1.descArbolCorreos);
                                        escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros() + 1, descN.getRegistrosActivos() + 1, descN.getRegistrosInactivos(), descN.getRegistroInicial()));
                                        JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                            }
                            else if (cant >= 2){
                                descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
                                editarRecursivo(descN.getRegistroInicial(), c, cant, descN.getRegistroInicial());
                                limpiarArchivo(Proyecto1.descArbolCorreos);
                                escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descN.getNombreSimbolico(), descN.getFechaCreacion(), descN.getUsuarioCreacion(), new Date(), user, descN.getNumRegistros() + 1, descN.getRegistrosActivos() + 1, descN.getRegistrosInactivos(), descN.getRegistroInicial()));
                                JOptionPane.showMessageDialog(null, "Correo enviado exitosamente", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La lista que selecciono no posee ningun usuario asociado", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "La lista a la que desea enviar un correo no existe", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            txtListaCorreoLocal.setText("");
            txtAsuntoListaCorreoLocal.setText("");
            txtContenidoListaCorreoLocal.setText("");
            iniciarBandejas();
        }
    }//GEN-LAST:event_btnEnviarListaLocalActionPerformed

    private void btnEnviarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarRedActionPerformed
        if(txtUsuarioCorreoRed.getText().equals("") || (txtAsuntoRed.getText().equals("")) || (txtContenidoCorreoRed.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "Algun campo del correo se encuentra vacio, por favor ingrese todos los campos", "InfoBox: " + "Error en Envio de Correo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try {
                CorreoRed correo = new CorreoRed(12, Integer.parseInt(opGrupo.getSelectedItem().toString()), user, txtUsuarioCorreoRed.getText(), txtAsuntoRed.getText(), txtContenidoCorreoRed.getText(), new Date());
                BDD.getInstancia().Insert(correo.getGrupoemisor(), correo.getGruporeceptor(), correo.getEmisor(), correo.getReceptor(), correo.getAsunto(), correo.getMensaje());
                txtAsuntoRed.setText("");
                txtUsuarioCorreoRed.setText("");
                txtContenidoCorreoRed.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnEnviarRedActionPerformed

    private void btnBuscarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCorreoActionPerformed
        VistsaBuscarCorreo v = new VistsaBuscarCorreo();
        v.setVisible(true);
    }//GEN-LAST:event_btnBuscarCorreoActionPerformed

    /**
     * Obtiener lista de mensajes recibidos por el usuario
     * @param actual correo raiz del arbol de correos
     * @return ArrayList de correos
     * @throws IOException
     * @throws ParseException 
     */
    public void leerBandejaDeEntrada(Correo actual) throws IOException, ParseException{
        if(actual != null){
            leerBandejaDeEntrada(leerCorreo(Proyecto1.arbolCorreos, actual.getIzquierdo()));
            if(String.valueOf(actual.getReceptor()).equals(user)){
                correosEntrada.add(actual);
            }
            leerBandejaDeEntrada(leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho()));
        }
    }
    
    /**
     * Obtiener lista de mensajes enviados por el usuario
     * @param actual correo raiz del arbol de correos
     * @return ArrayList de correos
     * @throws IOException
     * @throws ParseException 
     */
    public void leerBandejaDeSalida(Correo actual) throws IOException, ParseException{
        if(actual != null){
            leerBandejaDeSalida(leerCorreo(Proyecto1.arbolCorreos, actual.getIzquierdo()));
            if(String.valueOf(actual.getEmisor()).equals(user)){
                correosSalida.add(actual);
            }
            leerBandejaDeSalida(leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho()));
        }
    }
    
    /**
     * Busca el elemento correo en base a datos del receptor, emisor y fecha de transaccion
     * @param actual Correo inical de la bitacora de arboles
     * @param busqueda Correo con los parametros de busqueda
     * @return
     * @throws IOException
     * @throws ParseException 
     */
    public Correo buscarCorreo(Correo actual, Correo busqueda) throws IOException, ParseException{
        Correo c = null;
        if(actual != null){
            c = buscarCorreo(leerCorreo(Proyecto1.arbolCorreos, actual.getIzquierdo()), busqueda);
            if(comparar(actual, busqueda) == 0){
                return actual;
            }
            c = buscarCorreo(leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho()), busqueda);
        }
        return c;
    }
    
    /**
     * Busca el elemento padre de un correo especifica
     * @param actual Correo inical de la bitacora de arboles
     * @param busqueda Correo con los parametros de busqueda
     * @return
     * @throws IOException
     * @throws ParseException 
     */
    public Correo buscarPadre(Correo actual, Correo busqueda) throws IOException, ParseException{
        Correo c = null;
        if(actual != null){
            if(comparar(actual, busqueda) == 0){
                return null;
            }
            buscarCorreo(leerCorreo(Proyecto1.arbolCorreos, actual.getIzquierdo()), busqueda);
            if(actual.getIzquierdo() != -1){
                if(comparar(leerCorreo(Proyecto1.arbolCorreos, actual.getIzquierdo()), busqueda) == 0){
                    return actual;
                }
            }
            if(actual.getDerecho() != -1){
                if(comparar(leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho()), busqueda) == 0){
                    return actual;
                }
            }
            buscarCorreo(leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho()), busqueda);
        }
        return c;
    }
    
    /**
     * Busca el nodo mas pequeño a la izquierda del nodo derecho del correo
     * @param actual Correo de inicio de busqueda
     * @return
     * @throws IOException
     * @throws ParseException 
     */
    public int buscarMasIzquierdoDeLadoDerecho(Correo actual) throws IOException, ParseException{
        Correo c = null;
        int posicion = 0;
        DescIndiceListaUsuario descN = leerDescriptorIndice(Proyecto1.descArbolCorreos);
        if(actual != null){
            Correo cParent = null;
            Correo aux = leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho());
            while(aux != null){
                cParent = c;
                c = aux;
                aux = leerCorreo(Proyecto1.arbolCorreos, aux.getIzquierdo());
            }
            if(c != null){
                posicion = cParent.getIzquierdo();
                actual.setEstatus(false);
                editarEstadoIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), actual);
                if(comparar(c, leerCorreo(Proyecto1.arbolCorreos, actual.getDerecho())) != 0){
                    cParent.setIzquierdo(c.getDerecho());
                    c.setDerecho(actual.getDerecho());
                    c.setIzquierdo(actual.getIzquierdo());
                    editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), c);
                    editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), cParent);
                }
                else{
                    c.setDerecho(actual.getDerecho());
                    c.setIzquierdo(actual.getIzquierdo());
                    editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, descN.getRegistroInicial(), c);
                }
            }
        }
        return posicion;
    }
    
    /**
     * Metodo recursivo para la edicion de correos
     * @param pos posicion de correo de inicio
     * @param reg Correo que se busca editar
     * @param cant Canitdad de nodos en la bitacora del arbol
     * @param raiz posicion de la raiz de la bitacora de correos
     * @return 
     */
    public boolean editarRecursivo(int pos, Correo reg, int cant, int raiz){
        Correo actual;
        try{
            actual = leerCorreo(Proyecto1.arbolCorreos, pos);
            if(comparar(reg, actual) < 0){
                if(actual.getIzquierdo() == -1){
                    escribirCorreo(Proyecto1.arbolCorreos, reg);
                    actual.setIzquierdo(cant + 1);
                    editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, raiz, actual);
                    return true;
                }
                else{
                    editarRecursivo(actual.getIzquierdo(), reg, cant, raiz);
                }
            }
            else if(comparar(reg, actual) > 0){
                if(actual.getDerecho() == -1){
                    escribirCorreo(Proyecto1.arbolCorreos, reg);
                    actual.setDerecho(cant + 1);
                    editarPosicionIndiceArbol(Proyecto1.arbolCorreos, Proyecto1.descArbolCorreos, raiz, actual);
                    return true;
                }
                else{
                    editarRecursivo(actual.getDerecho(), reg, cant, raiz);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Funcion que lee las listas del archivo enviado 
     * @param fileName archivo en el que se buscan los usuarios
     * @return lista con las listas encontrados en el archivo
     * @throws IOException 
     */
    public LinkedList<Correo> leerCorreos(File fileName) throws IOException{
        LinkedList<Correo> ls = new LinkedList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
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
        if(texto.toString().equals("")){
            return ls;
        }
        else{
            String[] contenido = texto.toString().split("\\r?\\n");
            for(int i = 0; i < contenido.length; i++){
                try{
                    String[] listas = contenido[i].split("\\|");
                    Correo c = new Correo();
                    c.setIzquierdo(Integer.parseInt(listas[0]));
                    c.setDerecho(Integer.parseInt(listas[1]));
                    c.setEmisor(quitarExtra(listas[2]).toCharArray());
                    c.setReceptor(quitarExtra(listas[3]).toCharArray());
                    c.setFechaTransaccion(date.parse(listas[4]));
                    c.setAsunto(quitarExtra(listas[5]).toCharArray());
                    c.setMensaje(quitarExtra(listas[6]).toCharArray());
                    if(listas[7].equals("1")){
                        c.setEstatus(true);
                    }
                    else{
                        c.setEstatus(false);
                    }
                    ls.add(c);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return ls;
        }
    }
    
    /**
     * Metodo de reorganizacion/actualizacion de los datos del archivo indizado arbol
     * @throws Exception 
     */
    public void reorganizacionArbol() throws Exception{
        LinkedList<Correo> bitCorreo = leerCorreos(Proyecto1.arbolCorreos);
        LinkedList<Correo> nuevoListaCorreo = new LinkedList<>();
        int contA = 0;
        int contI = 0;
        int reg = 0;
        DescIndiceListaUsuario descI = leerDescriptorIndice(Proyecto1.descArbolCorreos);
        if(bitCorreo.size() > 0){
            for(int i = 0; i < bitCorreo.size(); i++){
                if(bitCorreo.get(i).isEstatus()){
                    contA++;
                    nuevoListaCorreo.add(bitCorreo.get(i));
                }
                else{
                    contI++;
                }
            }
            if(!(bitCorreo.size() == nuevoListaCorreo.size())){
                reg = bitCorreo.size() - nuevoListaCorreo.size();
                descI.setRegistroInicial(descI.getRegistroInicial() - reg);
                for(int y = 0; y < nuevoListaCorreo.size(); y++){
                    Correo val1 = nuevoListaCorreo.get(y);
                    if(val1.getIzquierdo() != -1){
                        val1.setIzquierdo(val1.getIzquierdo() - reg);
                    }
                    if(val1.getDerecho() != -1){
                        val1.setDerecho(val1.getDerecho() - reg);
                    }
                    nuevoListaCorreo.set(y, val1);
                }
                limpiarArchivo(Proyecto1.arbolCorreos);
                for(int i = 0; i < nuevoListaCorreo.size(); i++){
                    escribirCorreo(Proyecto1.arbolCorreos, nuevoListaCorreo.get(i));
                }
                limpiarArchivo(Proyecto1.descArbolCorreos);
                escribirDescriptor(Proyecto1.descArbolCorreos, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), contA, contA, 0, descI.getRegistroInicial()));
            }
            
        }
    }
    
    /**
     * Editor de las pocisiones de nodos hijos en bitacora de arbol
     * @param archivo Archivo de la bitacora de correo
     * @param descriptor Descriptor de la bitacora de correos
     * @param pos Numero de entrada en la bitacora de correos
     * @param regB Correo a editor
     * @return 
     */
    public boolean editarPosicionIndiceArbol(File archivo, File descriptor, int pos, Correo regB){         
        int cont = 0;      
        int cont2 = 0;     
        long puntero = 0;     
        long size = 0;       
        int reg = 0;
        boolean fin2 = true;
        boolean fin = false;
        try {    
            DescIndiceListaUsuario desB = leerDescriptorIndice(descriptor);        
            reg = pos;      
            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");          
            size = raf.length();         
            raf.seek(0);           
            String linea = "";           
            Correo val = leerCorreo(archivo, reg);           
            if(regB.getIzquierdo() < 10 && regB.getIzquierdo() > 0){          
                linea += "0";
                linea += regB.getIzquierdo();
            }           
            else{           
                linea += regB.getIzquierdo();       
            }
            linea += "|";
            if(regB.getDerecho() < 10 && regB.getDerecho() > 0){          
                linea += "0";
                linea += regB.getDerecho();
            }           
            else{           
                linea += regB.getDerecho();       
            } 
            puntero = raf.getFilePointer();                      
            if(comparar(regB, val) == 0){                          
                if(reg > 1){                                 
                    raf.seek((reg - 1) * 200);                        
                    }                                     
                else{                                   
                    raf.seek(0);                                           
                }                                   
                puntero = raf.getFilePointer();                                    
                raf.writeBytes(linea);                                   
                limpiarArchivo(descriptor);                                    
                escribirDescriptor(descriptor, new DescIndiceListaUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(regB.getEmisor()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getRegistroInicial()));                
                return true;
            }                
            else{
                if(val.getIzquierdo() != -1){
                   editarPosicionIndiceArbol(archivo, descriptor, val.getIzquierdo(), regB);
                }
                if(val.getDerecho() != -1){
                    editarPosicionIndiceArbol(archivo, descriptor, val.getDerecho(), regB);
                }             
            }           
        } catch (Exception ex) {  
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return false;
    }
    
    /**
     * Editor de estado del indice de correos
     * @param archivo File donde se buscara el correo
     * @param descriptor descriptor que se actualizara al editar el correo
     * @param regB Correo a comparar que contiene la posicion a modificar
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarEstadoIndiceArbol(File archivo, File descriptor, int pos, Correo regB){         
        int cont = 0;      
        int cont2 = 0;     
        long puntero = 0;     
        long size = 0;       
        int reg = 0;
        boolean fin2 = true;
        boolean fin = false;
        try {    
            DescIndiceListaUsuario desB = leerDescriptorIndice(descriptor);        
            reg = pos;      
            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");          
            size = raf.length();         
            raf.seek(0);           
            String linea = "";           
            Correo val = leerCorreo(archivo, reg);           
            if(regB.isEstatus()){
                linea += "1";
            }
            else{
                linea += "0";
            }
            puntero = raf.getFilePointer();                      
            if(comparar(regB, val) == 0){                          
                if(reg > 1){                                 
                    raf.seek(((reg - 1) * 200) + 197);                        
                    }                                     
                else{                                   
                    raf.seek(197);                                           
                }                                   
                puntero = raf.getFilePointer();                                    
                raf.writeBytes(linea);                                   
                limpiarArchivo(descriptor);                                    
                escribirDescriptor(descriptor, new DescIndiceListaUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(regB.getEmisor()), desB.getNumRegistros(), desB.getRegistrosActivos() - 1, desB.getRegistrosInactivos() + 1, desB.getRegistroInicial()));                
                return true;
            }                
            else{
                if(val.getIzquierdo() != -1){
                    editarEstadoIndiceArbol(archivo, descriptor, val.getIzquierdo(), regB);
                }
                if(val.getDerecho() != -1){
                    editarEstadoIndiceArbol(archivo, descriptor, val.getDerecho(), regB);
                }             
            }           
        } catch (Exception ex) {  
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return false;
    }
    
    /**
     * Metodo de comparacion de llaves emisor, receptor y fecha de transaccion
     * @param obj1 Correo que se esta comprando 
     * @param obj2 Correo con el que se va a comparar
     * @return 
     */
    public int comparar(Correo obj1, Correo obj2) {
        if (String.valueOf(obj1.getEmisor()).toUpperCase().equals(String.valueOf(obj2.getEmisor()).toUpperCase())) {
            if (String.valueOf(obj1.getReceptor()).toUpperCase().equals(String.valueOf(obj2.getReceptor()).toUpperCase())) {
                if (obj1.getFechaTransaccion().equals(obj2.getFechaTransaccion())) {
                    return 0;
                }
                if (String.valueOf(obj1.getFechaTransaccion()).equals("")) {
                    return -1;
                }
                if (String.valueOf(obj2.getFechaTransaccion()).equals("")) {
                    return 1;
                }
                return obj1.getFechaTransaccion().compareTo(obj2.getFechaTransaccion());
            }
            if (String.valueOf(obj1.getReceptor()).equals("")) {
                return -1;
            }
            if (String.valueOf(obj2.getReceptor()).equals("")) {
                return 1;
            }
            return String.valueOf(obj1.getReceptor()).toUpperCase().compareTo(String.valueOf(obj2.getReceptor()).toUpperCase());
        }
        if (String.valueOf(obj1.getEmisor()).equals("")) {
            return -1;
        }
        if (String.valueOf(obj2.getEmisor()).equals("")) {
            return 1;
        }
        return String.valueOf(obj1.getEmisor()).toUpperCase().compareTo(String.valueOf(obj2.getEmisor()).toUpperCase());
    }
    
    /**
     * Metodo que escribe una entrada al arbol de correos
     * @param archivo File al que se escribira la entrada
     * @param s Correo con la iformacion para la entrada
     * @throws IOException 
     */
    public void escribirCorreo(File archivo, Correo s) throws IOException{
        String texto = "";
        String div = "|";
        String fin = "\r\n";
        String txtCompleto = "";
        if (s.getIzquierdo() < 10 && s.getIzquierdo() > 0) {
            texto += "0";
            texto += String.valueOf(s.getIzquierdo());
        }
        if (s.getIzquierdo() == -1 || s.getIzquierdo() > 10) {
            texto += String.valueOf(s.getIzquierdo());
        }
        texto += div;
        if (s.getDerecho() < 10 && s.getDerecho() > 0) {
            texto += "0";
            texto += String.valueOf(s.getDerecho());
        }
        if (s.getDerecho() == -1 || s.getDerecho() > 10) {
            texto += String.valueOf(s.getDerecho());
        }
        texto += div;
        texto += completarTexto(String.valueOf(s.getEmisor()), 20);
        texto += div;
        texto += completarTexto(String.valueOf(s.getReceptor()), 20);
        texto += div;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        texto += date.format(s.getFechaTransaccion());
        texto += div;
        texto += completarTexto(String.valueOf(s.getAsunto()), 30);
        texto += div;
        texto += completarTexto(String.valueOf(s.getMensaje()), 100);
        texto += div;
        if(s.isEstatus()){
            //Esta activo
            texto += "1";
        }
        else{
            //Esta Inactivo
            texto += "0";
        }
        texto += fin;
        if(archivo.exists()){
            FileOutputStream fos = new FileOutputStream(archivo, true);
            Writer wr = new OutputStreamWriter(fos, UTF8);
            wr.write(texto);
            wr.flush();
            wr.close();
            fos.close();
        }
    }
    
    /**
     * Metodo que lee una entrada en la bitacora de correos n bas e a una posicoin especifica
     * @param archivo archivo de la bitacora de correos
     * @param posicion posicion de la que se lee la entrada
     * @return Objeto correo con los datos de la entrada
     * @throws IOException
     * @throws ParseException 
     */
    public Correo leerCorreo(File archivo, int posicion) throws IOException, ParseException{
        Correo c = new Correo();
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        if(posicion > 1){
            raf.seek((posicion - 1) * 200);
        }
        else{
            if(posicion == -1){
                c = null;
                return c;
            }
            else{
                raf.seek(0);
            }
        }
        String line = raf.readLine();
        if(!line.equals("")){
            String[] contenido = line.split("\\|");
            c.setIzquierdo(Integer.parseInt(contenido[0]));
            c.setDerecho(Integer.parseInt(contenido[1]));
            c.setEmisor(quitarExtra(contenido[2]).toCharArray());
            c.setReceptor(quitarExtra(contenido[3]).toCharArray());
            c.setFechaTransaccion(date.parse(contenido[4]));
            c.setAsunto(quitarExtra(contenido[5]).toCharArray());
            c.setMensaje(quitarExtra(contenido[6]).toCharArray());
            if(contenido[7].equals("1")){
                c.setEstatus(true);
            }
            else{
                c.setEstatus(false);
            }
        }
        else{
            c = null;
        }
        return c;
    }
    
    /**
     * Metodo de comparacion de llaves Nombre de lista, usuario y usuario asociado
     * @param obj1 IndiceListaUsuario que se esta comprando 
     * @param obj2 IndiceListaUsuario con el que se va a comparar
     * @return 
     */
    public int comparar(IndiceListaUsuario obj1, IndiceListaUsuario obj2) {
        if (String.valueOf(obj1.getNombreLista()).toUpperCase().equals(String.valueOf(obj2.getNombreLista()).toUpperCase())) {
            if (String.valueOf(obj1.getUsuario()).toUpperCase().equals(String.valueOf(obj2.getUsuario()).toUpperCase())) {
                if (String.valueOf(obj1.getUsuarioAsociado()).toUpperCase().equals(String.valueOf(obj2.getUsuarioAsociado()).toUpperCase())) {
                    return 0;
                }
                if (String.valueOf(obj1.getUsuarioAsociado()).equals("")) {
                    return -1;
                }
                if (String.valueOf(obj2.getUsuarioAsociado()).equals("")) {
                    return 1;
                }
                return String.valueOf(obj1.getUsuarioAsociado()).toUpperCase().compareTo(String.valueOf(obj2.getUsuarioAsociado()).toUpperCase());
            }
            if (String.valueOf(obj1.getUsuario()).equals("")) {
                return -1;
            }
            if (String.valueOf(obj2.getUsuario()).equals("")) {
                return 1;
            }
            return String.valueOf(obj1.getUsuario()).toUpperCase().compareTo(String.valueOf(obj2.getUsuario()).toUpperCase());
        }
        if (String.valueOf(obj1.getNombreLista()).equals("")) {
            return -1;
        }
        if (String.valueOf(obj2.getNombreLista()).equals("")) {
            return 1;
        }
        return String.valueOf(obj1.getNombreLista()).toUpperCase().compareTo(String.valueOf(obj2.getNombreLista()).toUpperCase());
    }
    
    /**
     * Metodo de comparacion de llaves Nombre de lista, usuario y usuario asociado
     * @param obj1 IndiceListaUsuario que se esta comprando 
     * @param obj2 ListaUsuario con el que se va a comparar
     * @return 
     */
    public int comparar(IndiceListaUsuario obj1, ListaUsuario obj2) {
        if (String.valueOf(obj1.getNombreLista()).toUpperCase().equals(String.valueOf(obj2.getNombreLista()).toUpperCase())) {
            if (String.valueOf(obj1.getUsuario()).toUpperCase().equals(String.valueOf(obj2.getUsuario()).toUpperCase())) {
                if (String.valueOf(obj1.getUsuarioAsociado()).toUpperCase().equals(String.valueOf(obj2.getUsuarioAsociado()).toUpperCase())) {
                    return 0;
                }
                if (String.valueOf(obj1.getUsuarioAsociado()).equals("")) {
                    return -1;
                }
                if (String.valueOf(obj2.getUsuarioAsociado()).equals("")) {
                    return 1;
                }
                return String.valueOf(obj1.getUsuarioAsociado()).toUpperCase().compareTo(String.valueOf(obj2.getUsuarioAsociado()).toUpperCase());
            }
            if (String.valueOf(obj1.getUsuario()).equals("")) {
                return -1;
            }
            if (String.valueOf(obj2.getUsuario()).equals("")) {
                return 1;
            }
            return String.valueOf(obj1.getUsuario()).toUpperCase().compareTo(String.valueOf(obj2.getUsuario()).toUpperCase());
        }
        if (String.valueOf(obj1.getNombreLista()).equals("")) {
            return -1;
        }
        if (String.valueOf(obj2.getNombreLista()).equals("")) {
            return 1;
        }
        return String.valueOf(obj1.getNombreLista()).toUpperCase().compareTo(String.valueOf(obj2.getNombreLista()).toUpperCase());
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
    
    /**
     * Editor de un campo del usuario
     * @param archivo File donde se buscara el usuario
     * @param descriptor descriptor que se actualizara al editar el usuario
     * @param texto nuevo campo del usuario
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito el usuario o no
     */
    public boolean editarUsuario(File archivo, File descriptor, String texto, int pos){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            long size = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                size = raf.length();
                raf.seek(0);
                if(raf.length() == 0){
                    return fin;
                }
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    puntero = raf.getFilePointer();
                    if(linea.contains(String.valueOf(us.getNombreDeUsuario())) && cont2 < 2){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario_Lista desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getMaxReorganizacion()));
                        fin = true;
                        JOptionPane.showMessageDialog(null, "El usuario se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        boxOpEditar.setVisible(true);
                        inicio();
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        puntero = raf.getFilePointer();
                        cont = cont + 391;
                        if(cont2 == 1){
                            break;
                        }
                        if(391 == raf.length()){
                            break;
                        }
                        if(raf.getFilePointer() == raf.length()){
                            cont2++;
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor de un campo de la lista
     * @param archivo File donde se buscara la lista
     * @param descriptor descriptor que se actualizara al editar la lista
     * @param texto nuevo campo de la lista
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarLista(File archivo, File descriptor, String texto, int pos){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            long size = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                size = raf.length();
                raf.seek(0);
                if(raf.length() == 0){
                    return fin;
                }
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    puntero = raf.getFilePointer();
                    if(linea.contains(String.valueOf(lis.getNombreLista())) && cont2 < 2 && (linea.contains(String.valueOf(us.getNombreDeUsuario())))){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario_Lista desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(lis.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getMaxReorganizacion()));
                        fin = true;
                        JOptionPane.showMessageDialog(null, "La lista se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        boxOpEditarL.setVisible(true);
                        inicio2();
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        puntero = raf.getFilePointer();
                        cont = cont + 116;
                        if(cont2 == 1){
                            break;
                        }
                        if(116 == raf.length()){
                            break;
                        }
                        if(raf.getFilePointer() == raf.length()){
                            cont2++;
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor de un el numero de usuarios de la lista
     * @param archivo File donde se buscara la lista
     * @param descriptor descriptor que se actualizara al editar la lista
     * @param texto nuevo campo de la lista
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarNumeroUsuariosLista(File archivo, File descriptor, String texto, int pos){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            long size = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                size = raf.length();
                raf.seek(0);
                if(raf.length() == 0){
                    return fin;
                }
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    puntero = raf.getFilePointer();
                    if(linea.contains(String.valueOf(lisAs.getNombreLista())) && cont2 < 2 && linea.contains(String.valueOf(lisAs.getUsuario()))){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario_Lista desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getMaxReorganizacion()));
                        fin = true;
                        //JOptionPane.showMessageDialog(null, "La lista se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        puntero = raf.getFilePointer();
                        cont = cont + 116;
                        if(cont2 == 1){
                            break;
                        }
                        if(116 == raf.length()){
                            break;
                        }
                        if(raf.getFilePointer() == raf.length()){
                            cont2++;
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor de un campo del indice
     * @param archivo File donde se buscara la lista
     * @param descriptor descriptor que se actualizara al editar la lista
     * @param regB IndiceListaUsuario a comparar que contiene la posicion a modificar
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarIndiceLista(File archivo, File descriptor, int pos, IndiceListaUsuario regB){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            long size = 0;
            int reg = 0;
            try {
                DescIndiceListaUsuario desB = leerDescriptorIndice(descriptor);
                reg = desB.getRegistroInicial();
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                size = raf.length();
                raf.seek(0);
                String linea = "";
                IndiceListaUsuario val = leerIndice(archivo, reg);
                if(regB.getSiguiente() < 10){
                    linea += "0";
                    linea += regB.getSiguiente();
                }
                else{
                    linea += regB.getSiguiente();
                }
                boolean fin2 = true;
                do{
                    puntero = raf.getFilePointer();
                    if(comparar(regB, val) == 0){
                        if(reg > 1){
                            raf.seek(((reg - 1) * 85) + pos);
                        }
                        else{
                            raf.seek(0 + pos);
                        }
                        puntero = raf.getFilePointer();
                        raf.writeBytes(linea);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescIndiceListaUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(regB.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getRegistroInicial()));
                        //JOptionPane.showMessageDialog(null, "El indice se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        fin2 = false;
                        break;
                    }
                    else{
                        reg = val.getSiguiente();
                        val = leerIndice(archivo, reg);
                    }
                }while(fin2);
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor de un campo de la asociacin de un usuario y lista
     * @param archivo File donde se buscara la lista
     * @param descriptor descriptor que se actualizara al editar la lista
     * @param regB IndiceListaUsuario a comparar que contiene la posicion a modificar
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarEstadoAsociacion(File archivo, File descriptor, int pos, IndiceListaUsuario regB){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            long size = 0;
            int reg = 0;
            try {
                DescUsuario_Lista desB = leerDescriptor(descriptor);
                reg = pos;
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                size = raf.length();
                raf.seek(0);
                String linea = "";
                ListaUsuario val = leerListaUsuario(archivo, reg);
                linea += "0";
                if(comparar(regB, val) == 0){
                    if(reg > 1){
                        raf.seek(((reg - 1) * 134) + 131);
                    }
                    else{
                        raf.seek(131);
                    }
                    puntero = raf.getFilePointer();
                    raf.writeBytes(linea);
                    limpiarArchivo(descriptor);
                    escribirDescriptor(descriptor, new DescIndiceListaUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(regB.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() - 1, desB.getRegistrosInactivos() + 1, desB.getMaxReorganizacion()));
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor de estado del indice
     * @param archivo File donde se buscara la lista
     * @param descriptor descriptor que se actualizara al editar la lista
     * @param regB IndiceListaUsuario a comparar que contiene la posicion a modificar
     * @param pos posicion en la linea del campo a editar
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarEstadoIndiceLista(File archivo, File descriptor, int pos, IndiceListaUsuario regB){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            long size = 0;
            int reg = 0;
            try {
                DescIndiceListaUsuario desB = leerDescriptorIndice(descriptor);
                reg = desB.getRegistroInicial();
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                size = raf.length();
                raf.seek(0);
                String linea = "";
                IndiceListaUsuario val = leerIndice(archivo, reg);
                if(regB.isEstatus()){
                    linea += "1";
                }
                else{
                    linea += "0";
                }
                boolean fin2 = true;
                do{
                    puntero = raf.getFilePointer();
                    if(comparar(regB, val) == 0){
                        if(reg > 1){
                            raf.seek(((reg - 1) * 85) + pos);
                        }
                        else{
                            raf.seek(0 + pos);
                        }
                        puntero = raf.getFilePointer();
                        raf.writeBytes(linea);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescIndiceListaUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(regB.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getRegistroInicial()));
                        //JOptionPane.showMessageDialog(null, "El indice se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        fin2 = false;
                        break;
                    }
                    else{
                        reg = val.getSiguiente();
                        val = leerIndice(archivo, reg);
                    }
                }while(fin2);
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Metodo que lee una entrada en el indice en base a una posicion y archivo
     * @param archivo File del indice
     * @param regInicial posicion de entrada que se va a leer
     * @return Objeto IndiceListaUsuario con los datos de la entrada buscada
     * @throws IOException 
     */
    public IndiceListaUsuario leerIndice(File archivo, int regInicial)throws IOException{
        IndiceListaUsuario val = new IndiceListaUsuario();
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        if(regInicial > 1){
            raf.seek((regInicial - 1) * 85);
        }
        else{
            raf.seek(0);
        }
        String line = raf.readLine();
        if(!line.equals("")){
            String[] contenido = line.split("\\|");
            val.setNumeroRegistro(Integer.parseInt(contenido[0]));
            val.setPosicion(Integer.parseInt(contenido[1]));
            val.setNombreLista(quitarExtra(contenido[2]).toCharArray());
            val.setUsuario(quitarExtra(contenido[3]).toCharArray());
            val.setUsuarioAsociado(quitarExtra(contenido[4]).toCharArray());
            val.setSiguiente(Integer.parseInt(contenido[5]));
            val.setEstatus(true);
            if(contenido[6].equals("1")){
                val.setEstatus(true);
            }
            else{
                val.setEstatus(false);
            }
        }
        return val;
    }
    
    /**
     * Lee los datos de una lista de un usuario en una posicion especifica
     * @param archivo File donde se encuentra la entrada
     * @param pos Posicion en la que se lee la lista
     * @return Objeto ListaUsuario donde se encuentran los datos de la entrada
     * @throws Exception 
     */
    public ListaUsuario leerListaUsuario(File archivo, int pos)throws Exception{
        ListaUsuario val = new ListaUsuario();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        if(pos > 1){
            raf.seek((pos - 1) * 134);
        }
        else{
            raf.seek(0);
        }
        String line = raf.readLine();
        if(!line.equals("")){
            String[] contenido = line.split("\\|");
            val.setNombreLista(quitarExtra(contenido[0]).toCharArray());
            val.setUsuario(quitarExtra(contenido[1]).toCharArray());
            val.setUsuarioAsociado(quitarExtra(contenido[2]).toCharArray());
            val.setDescripcion(quitarExtra(contenido[3]).toCharArray());
            val.setFechaCreacion(date.parse(contenido[4]));
            if(contenido[5].equals("1")){
                val.setEstatus(true);
            }
            else{
                val.setEstatus(false);
            }
        }
        return val;
    }
    
    /**
     * Editor del Estatus del resultado de busqueda de usuario
     * @param archivo File donde se buscara el usuario
     * @param descriptor descriptor que se actualizara al editar el usuario
     * @param texto nuevo campo del usuario
     * @param pos posicion en la linea del campo a editar
     * @param val booleano que determina si se le agrega o quita a los registros activos
     * @return valor booleano de si se econtro y edito el usuario o no
     */
    public boolean editarUsuarioEstado(File archivo, File descriptor, String texto, int pos, boolean val){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                raf.seek(0);
                if(raf.length() == 0){
                    return fin;
                }
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    if(linea.contains(String.valueOf(us.getNombreDeUsuario())) && cont2 < 2){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario_Lista desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        if(val){
                            escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() + 1, desB.getRegistrosInactivos() - 1, desB.getMaxReorganizacion()));
                        }
                        else{
                            escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() - 1, desB.getRegistrosInactivos() + 1, desB.getMaxReorganizacion()));
                        }
                        fin = true;
                        JOptionPane.showMessageDialog(null, "El usuario se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        boxOpEditar.setVisible(true);
                        inicio();
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        cont = cont + 391;
                        if(cont2 == 1){
                            break;
                        }
                        if(391 == raf.length()){
                            break;
                        }
                        if(raf.getFilePointer() == raf.length()){
                            cont2++;
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor del Estatus del resultado de busqueda de lista (Eliminacion logica)
     * @param archivo File donde se buscara la lista
     * @param descriptor descriptor que se actualizara al editar la lista
     * @param texto nuevo campo de la lista
     * @param pos posicion en la linea del campo a editar
     * @param val booleano que determina si se le agrega o quita a los registros activos
     * @return valor booleano de si se econtro y edito la lista o no
     */
    public boolean editarListaEstado(File archivo, File descriptor, String texto, int pos, boolean val){
        boolean fin = false;
            int cont = 0;
            int cont2 = 0;
            long puntero = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                raf.seek(0);
                if(raf.length() == 0){
                    return fin;
                }
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    if(linea.contains(String.valueOf(lis.getNombreLista())) && cont2 < 2 && (linea.contains(String.valueOf(us.getNombreDeUsuario())))){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario_Lista desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        if(val){
                            escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(lis.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() + 1, desB.getRegistrosInactivos() - 1, desB.getMaxReorganizacion()));
                        }
                        else{
                            escribirDescriptor(descriptor, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(lis.getUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() - 1, desB.getRegistrosInactivos() + 1, desB.getMaxReorganizacion()));
                        }
                        fin = true;
                        JOptionPane.showMessageDialog(null, "La lista se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                        boxOpEditarL.setVisible(true);
                        inicio2();
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        cont = cont + 116;
                        if(cont2 == 1){
                            break;
                        }
                        if(116 == raf.length()){
                            break;
                        }
                        if(raf.getFilePointer() == raf.length()){
                            cont2++;
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
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
     * Funcion que completa una cadena hasta un limite determinado con el caracter especial "~"
     * @param texto texto original sin agregar caracteres especiales
     * @param limite numero limite para agregar caracteres especiales
     * @return texto con caracteres especiales
     */
    public String completarTexto(String texto, int limite){
        while(texto.length() < limite){
            texto += "~";
        }
        return texto;
    }
    
    /**
     * Metodo de copia de archivos 
     * @param source File del archivo original
     * @param dest File del archivo de destino
     * @throws IOException 
     */
    private static void copiarArchivo(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    
    /**
     * Metodo que escribe al descriptor de usuario 
     * @param archivo informacion que se escribira
     * @param des archivo al que se escribira
     * @throws IOException 
     */
    public void escribirDescriptor(File archivo, DescUsuario_Lista des) throws IOException{
        String texto = "";
        String div = "|";
        texto += des.getNombreSimbolico();
        texto += div;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        texto += date.format(des.getFechaCreacion());
        texto += div;
        texto += des.getUsuarioCreacion();
        texto += div;
        texto += date.format(des.getFechaModificacion());
        texto += div;
        texto += des.getUsuarioModificacion();
        texto += div;
        texto += des.getNumRegistros();
        texto += div;
        texto += des.getRegistrosActivos();
        texto += div;
        texto += des.getRegistrosInactivos();
        texto += div;
        texto += des.getMaxReorganizacion();
        FileOutputStream fos = new FileOutputStream(archivo, true);
        fos.write(texto.getBytes());
        fos.flush();
        fos.close();
    }
    
    /**
     * Metodo que escribe al descriptor del indice de usuario asociado a lista 
     * @param archivo informacion que se escribira
     * @param des archivo al que se escribira
     * @throws IOException 
     */
    public void escribirDescriptor(File archivo, DescIndiceListaUsuario des) throws IOException{
        String texto = "";
        String div = "|";
        texto += des.getNombreSimbolico();
        texto += div;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        texto += date.format(des.getFechaCreacion());
        texto += div;
        texto += des.getUsuarioCreacion();
        texto += div;
        texto += date.format(des.getFechaModificacion());
        texto += div;
        texto += des.getUsuarioModificacion();
        texto += div;
        texto += des.getNumRegistros();
        texto += div;
        texto += des.getRegistrosActivos();
        texto += div;
        texto += des.getRegistrosInactivos();
        texto += div;
        texto += des.getRegistroInicial();
        FileOutputStream fos = new FileOutputStream(archivo, true);
        fos.write(texto.getBytes());
        fos.flush();
        fos.close();
    }
    
    /**
     * Funcion que lee el contenido del descriptor de la bitacora de usuarios
     * @param archivo Archivo del descriptor que se va a leer
     * @return informacion leida del descriptor
     * @throws IOException 
     */
    public DescUsuario_Lista leerDescriptor(File archivo) throws IOException{
        DescUsuario_Lista desc = null;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        BufferedReader br = null;
	FileReader fr = null;
	fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        StringBuilder texto = new StringBuilder();
        int line = 0;
        while ((line = br.read()) != -1) {
            char val = (char)line;
            texto.append(val);
        }
        fr.close();
        br.close();
        if(texto.toString().equals("")){
            return desc;
        }
        else{
            try{
                String[] contenido = texto.toString().split("\\|");
                desc = new DescUsuario_Lista(contenido[0], date.parse(contenido[1]), contenido[2], date.parse(contenido[3]), contenido[4], Integer.parseInt(contenido[5]), Integer.parseInt(contenido[6]), Integer.parseInt(contenido[7]), Integer.parseInt(contenido[8]));
            }catch(Exception e){
                e.printStackTrace();
            }
            return desc;
        }
    }
    
    /**
     * Funcion que lee el contenido del descriptor del indice de usuarios asociados a listas
     * @param archivo Archivo del descriptor que se va a leer
     * @return informacion leida del descriptor
     * @throws IOException 
     */
    public DescIndiceListaUsuario leerDescriptorIndice(File archivo) throws IOException{
        DescIndiceListaUsuario desc = null;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        BufferedReader br = null;
	FileReader fr = null;
	fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        StringBuilder texto = new StringBuilder();
        int line = 0;
        while ((line = br.read()) != -1) {
            char val = (char)line;
            texto.append(val);
        }
        fr.close();
        br.close();
        if(texto.toString().equals("")){
            return desc;
        }
        else{
            try{
                String[] contenido = texto.toString().split("\\|");
                desc = new DescIndiceListaUsuario(contenido[0], date.parse(contenido[1]), contenido[2], date.parse(contenido[3]), contenido[4], Integer.parseInt(contenido[5]), Integer.parseInt(contenido[6]), Integer.parseInt(contenido[7]), Integer.parseInt(contenido[8]));
            }catch(Exception e){
                e.printStackTrace();
            }
            return desc;
        }
    }
    
    /**
     * Metodo que escribe una entrada a la bitacora de usuarios asociados a listas
     * @param archivo File al que se escribira la entrada
     * @param s Listausuario con la iformacion para la entrada
     * @throws IOException 
     */
    public void escribirListaUsuario(File archivo, ListaUsuario s) throws IOException{
        String texto = "";
        String div = "|";
        String fin = "\r\n";
        String txtCompleto = "";
        texto += completarTexto(String.valueOf(s.getNombreLista()), 30);
        texto += div;
        texto += completarTexto(String.valueOf(s.getUsuario()), 20);
        texto += div;
        texto += completarTexto(String.valueOf(s.getUsuarioAsociado()), 20);
        texto += div;
        texto += completarTexto(String.valueOf(s.getDescripcion()), 40);
        texto += div;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        texto += date.format(s.getFechaCreacion());
        texto += div;
        if(s.isEstatus()){
            //Esta activo
            texto += "1";
        }
        else{
            //Esta Inactivo
            texto += "0";
        }
        texto += fin;
        if(archivo.exists()){
            FileOutputStream fos = new FileOutputStream(archivo, true);
            Writer wr = new OutputStreamWriter(fos, UTF8);
            wr.write(texto);
            wr.flush();
            wr.close();
            fos.close();
        }
    }
    
    /**
     * Metodo que escribe una entrada a la bitacora de indices de usuarios asociados a listas
     * @param archivo File al que se escribira la entrada
     * @param s IndiceListaUsuario con la iformacion para la entrada
     * @throws IOException 
     */
    public void escribirIndiceListaUsuario(File archivo, IndiceListaUsuario s) throws IOException{
        String texto = "";
        String div = "|";
        String fin = "\r\n";
        String txtCompleto = "";
        if(s.getNumeroRegistro() < 10){
            texto += "0";
            texto += s.getNumeroRegistro();
        }
        else{
            texto += s.getNumeroRegistro();
        }
        texto += div;
        if(s.getPosicion() < 10){
            texto += "0";
            texto += s.getPosicion();
        }
        else{
            texto += s.getPosicion();
        }
        texto += div;
        texto += completarTexto(String.valueOf(s.getNombreLista()), 30);
        texto += div;
        texto += completarTexto(String.valueOf(s.getUsuario()), 20);
        texto += div;
        texto += completarTexto(String.valueOf(s.getUsuarioAsociado()), 20);
        texto += div;
        if(s.getSiguiente() < 10){
            texto += "0";
            texto += s.getSiguiente();
        }
        else{
            texto += s.getSiguiente();
        }
        texto += div;
        if(s.isEstatus()){
            //Esta activo
            texto += "1";
        }
        else{
            //Esta Inactivo
            texto += "0";
        }
        texto += fin;
        if(archivo.exists()){
            FileOutputStream fos = new FileOutputStream(archivo, true);
            Writer wr = new OutputStreamWriter(fos, UTF8);
            wr.write(texto);
            wr.flush();
            wr.close();
            fos.close();
        }
    }
    
    /**
     * Metodo que limpia el contenido de un archivo
     * @param archivo archivo al que se le limpiara el contenido
     * @throws IOException 
     */
    public void limpiarArchivo(File archivo)throws IOException{
        PrintWriter writer = new PrintWriter(archivo);
        writer.print("");
        writer.close();
    }
    
    /**
     * Metodo que devuelve el la cantidad de caracteres en un erchivo
     * @param archivo Archivo que se va a utilizar
     * @return long con la cantidad de caracteres
     * @throws IOException 
     */
    public long tamañoDeArchivo(File archivo)throws IOException{
        long size = 0;
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
        size = raf.length();
        return size;
    }
    
    /**
     * Metodo que lee los parametros para la verificacion de seguridad de la contraseña
     */
    public void leerParametrosContraseña(){
        FileReader puntuacion;
        FileReader resultado;
        valores = new ArrayList<>();
        criterio = new ArrayList<>();
            try{
                puntuacion = new FileReader(archivo1);
                BufferedReader lectura = new BufferedReader(puntuacion);
                String linea;
                try{
                    linea = lectura.readLine();
                    while(linea != null){
                        valores.add(Integer.parseInt(linea));
                        linea = lectura.readLine();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                puntuacion.close();
                lectura.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                resultado = new FileReader(archivo2);
                BufferedReader lectura2 = new BufferedReader(resultado);
                String linea2;
                String[] split = null;
                try{
                    linea2 = lectura2.readLine();
                    while(linea2 != null){
                        if(!"".equals(linea2)){
                            split = linea2.split(",");
                        }
                        criterio.add(Integer.parseInt(split[0]));
                        criterio.add(Integer.parseInt(split[1]));
                        linea2 = lectura2.readLine();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                lectura2.close();
                resultado.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            
    }
    
    /**
     * Funcion que mide el grado de seguridad de una contraseña
     * @param password contraseña a la que se le verificara el nivel de seguridad
     * @return nivel de seguridad de la contraseña
     */
    public String calcularSeguridad(char[] password){
        leerParametrosContraseña();
        String contraseña = "";
        for(int i = 0; i < password.length; i++){
            contraseña += Character.toString(password[i]);
        }
        int puntos = 0;
        String mensaje = "";
        if(contraseña.length() < valores.get(0)){
            mensaje = ("La contraseña debe ser mayor a "+valores.get(0).toString() + " caracteres \n porfavor ingrese nuevamente una contraseña");
        }
        else{
            puntos += valores.get(1)*contraseña.length();
            puntos += valores.get(2)*calcularMayus(contraseña);
            puntos += valores.get(3)*calcularLetras(contraseña);
            puntos += valores.get(4)*calcularNumeros(contraseña);
            puntos += (calcularSimbolos(contraseña)*(contraseña.length()+valores.get(5)));
            if(calcularLetras(contraseña) == contraseña.length()){
                puntos = puntos - valores.get(6);
            }
            if(calcularNumeros(contraseña) == contraseña.length()){
                puntos = puntos - valores.get(7);
            }
            if((puntos >= criterio.get(0)) && (puntos <= criterio.get(1))){
            mensaje = "Contraseña Insegura";
            }
            if((puntos >= criterio.get(2)) && (puntos <= criterio.get(3))){
                mensaje = "Contraseña poco Segura";
            }
            if((puntos >= criterio.get(4)) && (puntos <= criterio.get(5))){
                mensaje = "Contraseña Segura";
            }
            if((puntos >= criterio.get(6)) && (puntos <= criterio.get(7))){
                mensaje = "Contraseña muy Segura";
            }
        }
        return mensaje;
    }
    
    /**
     * Funcion de calculo de numero de letras mayusculas en un texto
     * @param contraseña texto del que se hara el calculo
     * @return numero de mayusculas en el texto
     */
    public int calcularMayus(String contraseña){
        int cont = 0;
        for(int i = 0; i < contraseña.length(); i++){
            if(Character.isUpperCase(contraseña.charAt(i))){
                cont++;
            }             
        }
        return cont;
    }
    
    /**
     * Funcion de calculo de numero de letras en un texto
     * @param contraseña texto del que se hara el calculo
     * @return numero de letras en el texto
     */
    public int calcularLetras(String contraseña){
        int cont = 0;
        for(int i = 0; i < contraseña.length(); i++){
            if(Character.isLetter(contraseña.charAt(i))){
                cont++;
            }             
        }
        return cont;
    }
    
    /**
     * Funcion de calculo de numero de digitos en un texto
     * @param contraseña texto del que se hara el calculo
     * @return numero de digitos en el texto
     */
    public int calcularNumeros(String contraseña){
        int cont = 0;
        for(int i = 0; i < contraseña.length(); i++){
            if(Character.isDigit(contraseña.charAt(i))){
                cont++;
            }             
        }
        return cont;
    }
    
    /**
     * Funcion de calculo de numero de simbolos en un texto
     * @param contraseña texto del que se hara el calculo
     * @return numero de simbolos en el texto
     */
    public int calcularSimbolos(String contraseña){
        int cont = 0;
        for(int i = 0; i < contraseña.length(); i++){
            if((Character.valueOf(contraseña.charAt(i)).equals('/')) || (Character.valueOf(contraseña.charAt(i)).equals('¿')) || (Character.valueOf(contraseña.charAt(i)).equals('?')) || (Character.valueOf(contraseña.charAt(i)).equals('%')) || (Character.valueOf(contraseña.charAt(i)).equals('$')) || (Character.valueOf(contraseña.charAt(i)).equals('#'))){
                cont++;
            }             
        }
        return cont;
    }
    
    /**
     * Funcion que lee las listas del archivo enviado 
     * @param fileName archivo en el que se buscan los usuarios
     * @return lista con las listas encontrados en el archivo
     * @throws IOException 
     */
    public LinkedList<Lista> leerListas(File fileName) throws IOException{
        LinkedList<Lista> ls = new LinkedList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
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
        if(texto.toString().equals("")){
            return ls;
        }
        else{
            String[] contenido = texto.toString().split("\\r?\\n");
            for(int i = 0; i < contenido.length; i++){
                try{
                    String[] listas = contenido[i].split("\\|");
                    Lista lis = new Lista();
                    lis.setNombreLista(quitarExtra(listas[0]).toCharArray());
                    lis.setUsuario(quitarExtra(listas[1]).toCharArray());
                    lis.setDescripcion(quitarExtra(listas[2]).toCharArray());
                    lis.setNumeroUsuarios(Integer.parseInt(listas[3]));
                    lis.setFechaCreacion(date.parse(listas[4]));
                    if(listas[5].equals("1")){
                        lis.setEstatus(true);
                    }
                    else{
                        lis.setEstatus(false);
                    }
                    ls.add(lis);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return ls;
        }
    }
    
    /**
     * Funcion que lee las listas del archivo enviado 
     * @param fileName archivo en el que se buscan los usuarios
     * @return lista con las listas encontrados en el archivo
     * @throws IOException 
     */
    public LinkedList<ListaUsuario> leerListaUsuarios(File fileName) throws IOException{
        LinkedList<ListaUsuario> ls = new LinkedList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
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
        if(texto.toString().equals("")){
            return ls;
        }
        else{
            String[] contenido = texto.toString().split("\\r?\\n");
            for(int i = 0; i < contenido.length; i++){
                try{
                    String[] listas = contenido[i].split("\\|");
                    ListaUsuario lis = new ListaUsuario();
                    lis.setNombreLista(quitarExtra(listas[0]).toCharArray());
                    lis.setUsuario(quitarExtra(listas[1]).toCharArray());
                    lis.setUsuarioAsociado(quitarExtra(listas[2]).toCharArray());
                    lis.setDescripcion(quitarExtra(listas[3]).toCharArray());
                    lis.setFechaCreacion(date.parse(listas[4]));
                    if(listas[5].equals("1")){
                        lis.setEstatus(true);
                    }
                    else{
                        lis.setEstatus(false);
                    }
                    ls.add(lis);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return ls;
        }
    }
    
    /**
     * Metodo que escribe una entrada a la bitacora o maestro de listas
     * @param archivo File al que se escribira la entrada
     * @param s Lista con la iformacion para la entrada
     * @throws IOException 
     */
    public void escribirLista(File archivo, Lista s) throws IOException{
        String texto = "";
        String div = "|";
        String fin = "\r\n";
        String txtCompleto = "";
        texto += completarTexto(String.valueOf(s.getNombreLista()), 30);
        texto += div;
        texto += completarTexto(String.valueOf(s.getUsuario()), 20);
        texto += div;
        texto += completarTexto(String.valueOf(s.getDescripcion()), 40);
        texto += div;
        if(s.getNumeroUsuarios() < 10){
            texto += "0";
            texto += s.getNumeroUsuarios();
        }
        else{
            texto += s.getNumeroUsuarios();
        }
        texto += div;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        texto += date.format(s.getFechaCreacion());
        texto += div;
        if(s.isEstatus()){
            //Esta activo
            texto += "1";
        }
        else{
            //Esta Inactivo
            texto += "0";
        }
        texto += fin;
        if(archivo.exists()){
            FileOutputStream fos = new FileOutputStream(archivo, true);
            Writer wr = new OutputStreamWriter(fos, UTF8);
            wr.write(texto);
            wr.flush();
            wr.close();
            fos.close();
        }
    }
    
    /**
     * Funcion que lee las entradas de usuarios asociados del archivo enviado 
     * @param fileName archivo en el que se buscan los usuarios
     * @return lista con las listas encontrados en el archivo
     * @throws IOException 
     */
    public LinkedList<IndiceListaUsuario> leerUsuariosAsociados(File fileName) throws IOException{
        LinkedList<IndiceListaUsuario> ls = new LinkedList<>();
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
        if(texto.toString().equals("")){
            return ls;
        }
        else{
            String[] contenido = texto.toString().split("\\r?\\n");
            for(int i = 0; i < contenido.length; i++){
                try{
                    String[] valores = contenido[i].split("\\|");
                    IndiceListaUsuario val = new IndiceListaUsuario();
                    val.setNumeroRegistro(Integer.parseInt(valores[0]));
                    val.setPosicion(Integer.parseInt(valores[1]));
                    val.setNombreLista(quitarExtra(valores[2]).toCharArray());
                    val.setUsuario(quitarExtra(valores[3]).toCharArray());
                    val.setUsuarioAsociado(quitarExtra(valores[4]).toCharArray());
                    val.setSiguiente(Integer.parseInt(valores[5]));
                    val.setEstatus(true);
                    if(valores[6].equals("1")){
                        val.setEstatus(true);
                    }
                    else{
                        val.setEstatus(false);
                    }
                    ls.add(val);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return ls;
        }
    }
    
    /**
     * Metodo de reorganizacion/actualizacion de los datos del archivo indizado
     * @throws Exception 
     */
    public void reorganizacionIndizado() throws Exception{
        LinkedList<ListaUsuario> bitListaUsuario = leerListaUsuarios(Proyecto1.bitacoraListaUsuario);
        LinkedList<ListaUsuario> nuevoListaUsuario = new LinkedList<>();
        int contA = 0;
        int contI = 0;
        if(bitListaUsuario.size() > 0){
            for(int i = 0; i < bitListaUsuario.size(); i++){
                if(bitListaUsuario.get(i).isEstatus()){
                    contA++;
                    nuevoListaUsuario.add(bitListaUsuario.get(i));
                }
                else{
                    contI++;
                }
            }
            limpiarArchivo(Proyecto1.bitacoraListaUsuario);
            for(int i = 0; i < nuevoListaUsuario.size(); i++){
                escribirListaUsuario(Proyecto1.bitacoraListaUsuario, nuevoListaUsuario.get(i));
            }
            DescUsuario_Lista desM = leerDescriptor(Proyecto1.descBitacoraListaUsuario);
            limpiarArchivo(Proyecto1.descBitacoraListaUsuario);
            escribirDescriptor(Proyecto1.descBitacoraListaUsuario, new DescUsuario_Lista(desM.getNombreSimbolico(), desM.getFechaCreacion(), desM.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), contA, contA, 0, desM.getMaxReorganizacion()));
        }
        LinkedList<IndiceListaUsuario> bitIndiceUsuarios = leerUsuariosAsociados(Proyecto1.IndiceListaUsuario);
        LinkedList<IndiceListaUsuario> nuevoIndiceUsuarios = new LinkedList<>();
        contA = 0;
        contI = 0;
        DescIndiceListaUsuario descI = leerDescriptorIndice(Proyecto1.descIndiceListaUsuario);
        if(bitIndiceUsuarios.size() > 0){
            for(int i = 0; i < bitIndiceUsuarios.size(); i++){
                if(bitIndiceUsuarios.get(i).isEstatus()){
                    contA++;
                    nuevoIndiceUsuarios.add(bitIndiceUsuarios.get(i));
                }
                else{
                    contI++;
                }
            }
            for(int i = 0; i < (nuevoIndiceUsuarios.size()); i++){
                int val = nuevoIndiceUsuarios.get(i).getNumeroRegistro();
                for(int y = 0; y < nuevoIndiceUsuarios.size(); y++){
                    IndiceListaUsuario val1 = nuevoIndiceUsuarios.get(y);
                    descI = leerDescriptorIndice(Proyecto1.descIndiceListaUsuario);
                    if(val1.getNumeroRegistro() == val){
                        val1.setNumeroRegistro(i + 1);
                    }
                    if(val1.getPosicion() == val){
                        val1.setPosicion(i + 1);
                    }
                    if(val1.getSiguiente() == val){
                        val1.setSiguiente(i + 1);
                    }
                    if(descI.getRegistroInicial() == val){
                        descI.setRegistroInicial(i + 1);
                    }
                    nuevoIndiceUsuarios.set(y, val1);
                    limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                    escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos(), descI.getRegistrosInactivos(), descI.getRegistroInicial()));
                }
            }
            limpiarArchivo(Proyecto1.IndiceListaUsuario);
            for(int i = 0; i < nuevoListaUsuario.size(); i++){
                escribirIndiceListaUsuario(Proyecto1.IndiceListaUsuario, nuevoIndiceUsuarios.get(i));
            }
            limpiarArchivo(Proyecto1.descIndiceListaUsuario);
            escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), contA, contA, 0, descI.getRegistroInicial()));
        }
    }
    
    /**
     * Metodo de reorganizacion/actualizacion de los datos del archivo secuencial de listas
     * @throws Exception 
     */
    public void reorganizacionSecuencialListas() throws Exception{
        LinkedList<Lista> bitLista = leerListas(Proyecto1.bitacoraLista);
        LinkedList<Lista> masLista = leerListas(Proyecto1.maestroLista);
        int contA = 0;
        int contI = 0;
        LinkedList<Lista> nuevoMasLista = new LinkedList<>();
        if(masLista.size() > 0){
            for(int i = 0; i < bitLista.size(); i++){
                if(bitLista.get(i).isEstatus()){
                    contA++;
                    nuevoMasLista.add(bitLista.get(i));
                }
                else{
                    contI++;
                }
            }
            for(int i = 0; i < masLista.size(); i++){
                if(masLista.get(i).isEstatus()){
                    contA++;
                    nuevoMasLista.add(masLista.get(i));
                }
                else{
                    contI++;
                }
            }
            Collections.sort(nuevoMasLista, new ListComparator());
            limpiarArchivo(Proyecto1.maestroLista);
            limpiarArchivo(Proyecto1.bitacoraLista);
            DescUsuario_Lista desB = leerDescriptor(Proyecto1.descBitacoraLista);
            limpiarArchivo(Proyecto1.descBitacoraLista);
            escribirDescriptor(Proyecto1.descBitacoraLista, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), 0, 0, 0, desB.getMaxReorganizacion()));
            for(int i = 0; i < nuevoMasLista.size(); i++){
                escribirLista(Proyecto1.maestroLista, nuevoMasLista.get(i));
            }
            DescUsuario_Lista desM = leerDescriptor(Proyecto1.descMaestroLista);
            limpiarArchivo(Proyecto1.descMaestroLista);
            escribirDescriptor(Proyecto1.descMaestroLista, new DescUsuario_Lista(desM.getNombreSimbolico(), desM.getFechaCreacion(), desM.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), contA, contA, 0, desM.getMaxReorganizacion()));
        }
        else if (bitLista.size() > 0 && masLista.isEmpty()){
            for(int i = 0; i < bitLista.size(); i++){
                if(bitLista.get(i).isEstatus()){
                    contA++;
                    nuevoMasLista.add(bitLista.get(i));
                }
                else{
                    contI++;
                }
            }
            Collections.sort(nuevoMasLista, new ListComparator());
            limpiarArchivo(Proyecto1.maestroLista);
            limpiarArchivo(Proyecto1.bitacoraLista);
            DescUsuario_Lista desB = leerDescriptor(Proyecto1.descBitacoraLista);
            limpiarArchivo(Proyecto1.descBitacoraLista);
            escribirDescriptor(Proyecto1.descBitacoraLista, new DescUsuario_Lista(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(us.getNombreDeUsuario()), 0, 0, 0, desB.getMaxReorganizacion()));
            for(int i = 0; i < nuevoMasLista.size(); i++){
                escribirLista(Proyecto1.maestroLista, nuevoMasLista.get(i));
            }
            DescUsuario_Lista desM = leerDescriptor(Proyecto1.descMaestroLista);
            limpiarArchivo(Proyecto1.descMaestroLista);
            escribirDescriptor(Proyecto1.descMaestroLista, new DescUsuario_Lista("maestro_Lista", new Date(), String.valueOf(us.getNombreDeUsuario()), new Date(), String.valueOf(us.getNombreDeUsuario()), contA, contA, 0, -1));
        }
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
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> BandejaEntrada;
    private javax.swing.JList<String> BandejaSalida;
    private javax.swing.JComboBox<String> boxOpEditar;
    private javax.swing.JComboBox<String> boxOpEditarL;
    private javax.swing.JButton btnActualizarEntrada;
    private javax.swing.JButton btnActualizarSalida;
    private javax.swing.JButton btnAgregarLista;
    private javax.swing.JButton btnBuscarCorreo;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnBuscarLista;
    private javax.swing.JButton btnBuscarListaAsociacion;
    private javax.swing.JButton btnBuscarListaEliminacion;
    private javax.swing.JButton btnBuscarUs;
    private javax.swing.JButton btnBuscarUsuarioAsociar;
    private javax.swing.JButton btnBuscarUsuarioEliminacion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarAsociacion;
    private javax.swing.JButton btnCancelarEliminacion;
    private javax.swing.JButton btnCancelarL;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarCorreosEntrada;
    private javax.swing.JButton btnEliminarCorreosSalida;
    private javax.swing.JButton btnEnviarListaLocal;
    private javax.swing.JButton btnEnviarLocal;
    private javax.swing.JButton btnEnviarRed;
    private javax.swing.JButton btnGuardarAsociacion;
    private javax.swing.JButton btnGuardarContr;
    private javax.swing.JButton btnGuardarCorreo;
    private javax.swing.JButton btnGuardarDescripcion;
    private javax.swing.JButton btnGuardarEliminacion;
    private javax.swing.JButton btnGuardarEsta;
    private javax.swing.JButton btnGuardarEstaL;
    private javax.swing.JButton btnGuardarFecha;
    private javax.swing.JButton btnGuardarFoto;
    private javax.swing.JButton btnGuardarTele;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnVer;
    private javax.swing.JCheckBox chbActivo;
    private javax.swing.JCheckBox chbActivoL;
    private javax.swing.JCheckBox chbInactivo;
    private javax.swing.JCheckBox chbInactivoL;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JPanel jPanelCorreo;
    private javax.swing.JPanel jPanelEditar;
    private javax.swing.JPanel jPanelEliminarAsociacion;
    private javax.swing.JPanel jPanelEnvioUsuario;
    private javax.swing.JPanel jPanelGuardarAsociacion;
    private javax.swing.JPanel jPanelListaUsuario;
    private javax.swing.JPanel jPanelListas;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel labelAsuntoCorreoLocal;
    private javax.swing.JLabel labelAsuntoListaCorreoLocal;
    private javax.swing.JLabel labelAsuntoRed;
    private javax.swing.JLabel labelBusqueda;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelEstatus;
    private javax.swing.JLabel labelEstatusL;
    private javax.swing.JLabel labelFechaN;
    private javax.swing.JLabel labelFormatoFecha;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelGrupo;
    private javax.swing.JLabel labelImageFoto;
    private javax.swing.JLabel labelListaCorreoLocal;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelLogo10;
    private javax.swing.JLabel labelLogo11;
    private javax.swing.JLabel labelLogo12;
    private javax.swing.JLabel labelLogo2;
    private javax.swing.JLabel labelLogo3;
    private javax.swing.JLabel labelLogo4;
    private javax.swing.JLabel labelLogo5;
    private javax.swing.JLabel labelLogo6;
    private javax.swing.JLabel labelLogo8;
    private javax.swing.JLabel labelLogo9;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPathFoto;
    private javax.swing.JLabel labelRLista;
    private javax.swing.JLabel labelRListaEliminacion;
    private javax.swing.JLabel labelRUsuario;
    private javax.swing.JLabel labelRUsuarioEliminacion;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelUsuarioCorreo;
    private javax.swing.JLabel labelUsuarioCorreoLocal;
    private javax.swing.JComboBox<String> opGrupo;
    private javax.swing.JTextField txtAsuntoCorreoLocal;
    private javax.swing.JTextField txtAsuntoListaCorreoLocal;
    private javax.swing.JTextField txtAsuntoRed;
    private javax.swing.JTextField txtBusquedaLista;
    private javax.swing.JTextField txtBusquedaListaAsociacion;
    private javax.swing.JTextField txtBusquedaListaEliminacion;
    private javax.swing.JTextField txtBusquedaUsuarioAsociar;
    private javax.swing.JTextField txtBusquedaUsuarioEliminacion;
    private javax.swing.JTextArea txtContenidoCorreoLocal;
    private javax.swing.JTextArea txtContenidoCorreoRed;
    private javax.swing.JTextArea txtContenidoListaCorreoLocal;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtListaCorreoLocal;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuarioCorreoLocal;
    private javax.swing.JTextField txtUsuarioCorreoRed;
    // End of variables declaration//GEN-END:variables
}
