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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
        inicio();
        inicio2();
        inicio3();
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
    
    private static Charset UTF8 = Charset.forName("UTF-8");
    File rutaFoto = new File("C:\\MEIA\\Imagenes");
    File test = new File("C:\\MEIA\\test2.txt");
    static ArrayList<Integer> valores = new ArrayList<Integer>();
    static ArrayList<Integer> criterio = new ArrayList<Integer>();
    File archivo1 = new File("C:\\MEIA\\puntuacion.txt");
    File archivo2 = new File("C:\\MEIA\\resultado.txt");
    
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
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
                .addContainerGap(282, Short.MAX_VALUE))
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
                .addContainerGap(119, Short.MAX_VALUE))
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
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Guardar", jPanelGuardarAsociacion);

        btnGuardarEliminacion.setText("Guardar");
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
                .addContainerGap(150, Short.MAX_VALUE))
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
    
    public Lista buscarLista(File fileName, String lista) throws IOException{
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
                    if(quitarExtra(listas[0]).equals(lista)){
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
                    if(quitarExtra(valores[0]).equals(lista)){
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
        dispose();
        VistaLogin v = new VistaLogin();
        v.setVisible(true);
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
                        VistaLogin v = new VistaLogin();
                        v.setVisible(true);
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
                ls1 = buscarLista(Proyecto1.bitacoraLista, txtBusquedaLista.getText());
                ls2 = buscarLista(Proyecto1.maestroLista, txtBusquedaLista.getText());
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
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de descripcion se encuentra vacio", "InfoBox: " + "Error en Edicion de Lista", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarL.setVisible(true);
        btnVer.setVisible(true);
        try {
            if(String.valueOf(buscarLista(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista())).getNombreLista()).equals(String.valueOf(lis.getNombreLista()))){
                lis = buscarLista(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista()));
            }
            else{
                lis = buscarLista(Proyecto1.maestroLista, String.valueOf(lis.getNombreLista()));
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
                        boolean val = editarListaEstado(Proyecto1.bitacoraLista, Proyecto1.descBitacoraLista, texto, 113, false);
                        if(!val){
                            editarListaEstado(Proyecto1.maestroLista, Proyecto1.descMaestroLista, texto, 113, false);
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
            if(String.valueOf(buscarLista(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista())).getNombreLista()).equals(String.valueOf(lis.getNombreLista()))){
                lis = buscarLista(Proyecto1.bitacoraLista, String.valueOf(lis.getNombreLista()));
            }
            else{
                lis = buscarLista(Proyecto1.maestroLista, String.valueOf(lis.getNombreLista()));
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
                ls1 = buscarLista(Proyecto1.bitacoraLista, txtBusquedaListaAsociacion.getText());
                ls2 = buscarLista(Proyecto1.maestroLista, txtBusquedaListaAsociacion.getText());
                if(String.valueOf(ls1.getNombreLista()).equals(txtBusquedaListaAsociacion.getText())){
                    lisAs = ls1;
                    labelRLista.setText("Lista Encontrada: " + txtBusquedaListaAsociacion.getText());
                    txtBusquedaListaAsociacion.setVisible(false);
                    btnBuscarListaAsociacion.setVisible(false);
                    txtBusquedaUsuarioAsociar.setVisible(true);
                    btnBuscarUsuarioAsociar.setVisible(true);
                }
                else if(String.valueOf(ls2.getNombreLista()).equals(txtBusquedaListaAsociacion.getText().trim())){
                    lisAs = ls2;
                    labelRLista.setText("Lista Encontrada: " + txtBusquedaListaAsociacion.getText());
                    txtBusquedaListaAsociacion.setVisible(false);
                    btnBuscarListaAsociacion.setVisible(false);
                    txtBusquedaUsuarioAsociar.setVisible(true);
                    btnBuscarUsuarioAsociar.setVisible(true);
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
        try{
            if(!txtBusquedaUsuarioAsociar.getText().trim().equals("")){
                usu = buscarUsuario(txtBusquedaUsuarioAsociar.getText());
                if(String.valueOf(usu.getNombreDeUsuario()).equals(txtBusquedaUsuarioAsociar.getText())){
                    usAs = usu;
                    txtBusquedaUsuarioAsociar.setVisible(false);
                    btnBuscarUsuarioAsociar.setVisible(false);
                    labelRUsuario.setVisible(true);
                    labelRUsuario.setText("Usuario Encontrado: " + txtBusquedaUsuarioAsociar.getText());
                    btnGuardarAsociacion.setVisible(true);
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
                            }
                            else{
                                siguiente = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                                siguiente.setEstatus(false);
                                actual.setSiguiente(0);
                                limpiarArchivo(Proyecto1.descIndiceListaUsuario);
                                escribirDescriptor(Proyecto1.descIndiceListaUsuario, new DescIndiceListaUsuario(descI.getNombreSimbolico(), descI.getFechaCreacion(), descI.getUsuarioCreacion(), new Date(), String.valueOf(lisAs.getUsuario()), descI.getNumRegistros(), descI.getRegistrosActivos() - 1, descI.getRegistrosInactivos() + 1, descI.getRegistroInicial()));
                                editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, actual);
                                editarEstadoIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 82, siguiente);
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
                                /*siguiente = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                                siguiente.setSiguiente(0);
                                editarIndiceLista(Proyecto1.IndiceListaUsuario, Proyecto1.descIndiceListaUsuario, 79, siguiente);*/
                            }
                            else{
                                previo = actual;
                                actual = leerIndice(Proyecto1.IndiceListaUsuario, actual.getSiguiente());
                                boolean fin = true;
                                do{
                                    if(comparar(inLsUs, actual) == 0){
                                        
                                    }
                                }while(fin);
                            }
                        }
                    }
                }
            }
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
                ls1 = buscarLista(Proyecto1.bitacoraLista, txtBusquedaListaEliminacion.getText());
                ls2 = buscarLista(Proyecto1.maestroLista, txtBusquedaListaEliminacion.getText());
                if(String.valueOf(ls1.getNombreLista()).equals(txtBusquedaListaEliminacion.getText())){
                    lisAs = ls1;
                    labelRListaEliminacion.setText("Lista Encontrada: " + txtBusquedaListaEliminacion.getText());
                    txtBusquedaListaEliminacion.setVisible(false);
                    btnBuscarListaEliminacion.setVisible(false);
                    txtBusquedaUsuarioEliminacion.setVisible(true);
                    btnBuscarUsuarioEliminacion.setVisible(true);
                }
                else if(String.valueOf(ls2.getNombreLista()).equals(txtBusquedaListaEliminacion.getText().trim())){
                    lisAs = ls2;
                    labelRListaEliminacion.setText("Lista Encontrada: " + txtBusquedaListaEliminacion.getText());
                    txtBusquedaListaEliminacion.setVisible(false);
                    btnBuscarListaEliminacion.setVisible(false);
                    txtBusquedaUsuarioEliminacion.setVisible(true);
                    btnBuscarUsuarioEliminacion.setVisible(true);
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
                    usAs = usu;
                    txtBusquedaUsuarioEliminacion.setVisible(false);
                    btnBuscarUsuarioEliminacion.setVisible(false);
                    labelRUsuarioEliminacion.setVisible(true);
                    labelRUsuarioEliminacion.setText("Usuario Encontrado: " + txtBusquedaUsuarioEliminacion.getText());
                    btnGuardarEliminacion.setVisible(true);
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
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    puntero = raf.getFilePointer();
                    if(linea.contains(String.valueOf(lis.getNombreLista())) && cont2 < 2){
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
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    puntero = raf.getFilePointer();
                    if(linea.contains(String.valueOf(lisAs.getNombreLista())) && cont2 < 2){
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
     * Editor de un campo del indice
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
                String linea = raf.readLine();
                while(raf.getFilePointer() < raf.length() + 1){
                    if(linea.contains(String.valueOf(lis.getNombreLista())) && cont2 < 2){
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
    private javax.swing.JComboBox<String> boxOpEditar;
    private javax.swing.JComboBox<String> boxOpEditarL;
    private javax.swing.JButton btnAgregarLista;
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
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JPanel jPanelEditar;
    private javax.swing.JPanel jPanelEliminarAsociacion;
    private javax.swing.JPanel jPanelGuardarAsociacion;
    private javax.swing.JPanel jPanelListaUsuario;
    private javax.swing.JPanel jPanelListas;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
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
    private javax.swing.JLabel labelImageFoto;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelLogo2;
    private javax.swing.JLabel labelLogo3;
    private javax.swing.JLabel labelLogo4;
    private javax.swing.JLabel labelLogo5;
    private javax.swing.JLabel labelLogo6;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPathFoto;
    private javax.swing.JLabel labelRLista;
    private javax.swing.JLabel labelRListaEliminacion;
    private javax.swing.JLabel labelRUsuario;
    private javax.swing.JLabel labelRUsuarioEliminacion;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField txtBusquedaLista;
    private javax.swing.JTextField txtBusquedaListaAsociacion;
    private javax.swing.JTextField txtBusquedaListaEliminacion;
    private javax.swing.JTextField txtBusquedaUsuarioAsociar;
    private javax.swing.JTextField txtBusquedaUsuarioEliminacion;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
