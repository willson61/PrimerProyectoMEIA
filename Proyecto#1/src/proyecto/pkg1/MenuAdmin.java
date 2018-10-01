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
import static proyecto.pkg1.MenuUsuario.user;

/**
 *
 * @author Sthephan
 */
public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creacion del menu del administrador
     * Establecimiento de datos del administrador
     */
    public MenuAdmin() {
        initComponents();
        ImageIcon im = new ImageIcon(Proyecto1.logo.getPath());
        Image image = im.getImage(); // transform it 
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        im = new ImageIcon(newimg);
        labelLogo1.setIcon(im);
        labelLogo3.setIcon(im);
        labelLogo2.setIcon(im);
        labelLogo4.setIcon(im);
        inicio1();
        inicio2();
        btnVer.setVisible(false);
    }
    
    private static Charset UTF8 = Charset.forName("UTF-8");
    public static String admin;
    public Usuario adminUs;
    public Usuario usuarioBus;
    File rutaFoto = new File("C:\\MEIA\\Imagenes");
    static ArrayList<Integer> valores = new ArrayList<Integer>();
    static ArrayList<Integer> criterio = new ArrayList<Integer>();
    File archivo1 = new File("C:\\MEIA\\puntuacion.txt");
    File archivo2 = new File("C:\\MEIA\\resultado.txt");
    File root = new File("C:\\MEIA");
    /**
     * Estado inical de los campos en pestaña de edicion del administrador
     */
    public void inicio1(){
        btnGuardarContr.setVisible(false);
        btnGuardarCorreo.setVisible(false);
        btnGuardarFecha.setVisible(false);
        btnGuardarFoto.setVisible(false);
        btnGuardarTele.setVisible(false);
        btnBuscarFoto.setVisible(false);
        labelContraseña.setVisible(false);
        labelCorreo.setVisible(false);
        labelFechaN.setVisible(false);
        labelFormatoFecha.setVisible(false);
        labelFoto.setVisible(false);
        labelTelefono.setVisible(false);
        labelPathFoto.setVisible(false);
        txtContraseña.setVisible(false);
        txtCorreo.setVisible(false);
        txtFechaNacimiento.setVisible(false);
        txtTelefono.setVisible(false);
        txtContraseña.setText("");
        txtFechaNacimiento.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        labelPathFoto.setText("");
        try {
            adminUs = buscarUsuario(admin);
            labelNombre.setText("Nombre de Usuario: " + String.valueOf(adminUs.getNombreDeUsuario()));
            if(adminUs.isRol()){
                labelRol.setText("Rol: Administrador");
            }
            else{
                labelRol.setText("Rol: Usuario");
            }
        } catch (ParseException ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon im2 = new ImageIcon(String.valueOf(adminUs.getPathFotografia()));
        Image image2 = im2.getImage(); // transform it 
        Image newimg2 = image2.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        im2 = new ImageIcon(newimg2);
        labelFotoA.setIcon(im2);
    }
    
    /**
     * Estado inicial de los campos en pestaña de edicion de la busqueda de usuarios
     */
    public void inicio2(){
        btnGuardarContrU.setVisible(false);
        btnGuardarCorreoU.setVisible(false);
        btnGuardarFechaU.setVisible(false);
        btnGuardarFotoU.setVisible(false);
        btnGuardarTeleU.setVisible(false);
        btnBuscarFotoU.setVisible(false);
        btnGuardarEstaU.setVisible(false);
        boxOpEditarU.setVisible(false);
        btnEditar.setVisible(false);
        chbActivoU.setVisible(false);
        chbInactivoU.setVisible(false);
        labelContraseñaU.setVisible(false);
        labelCorreoU.setVisible(false);
        labelFechaNU.setVisible(false);
        labelFormatoFechaU.setVisible(false);
        labelFotoU.setVisible(false);
        labelTelefonoU.setVisible(false);
        labelPathFotoU.setVisible(false);
        labelEstatusU.setVisible(false);
        txtContraseñaU.setVisible(false);
        txtCorreoU.setVisible(false);
        txtFechaNacimientoU.setVisible(false);
        txtTelefonoU.setVisible(false);
        txtContraseñaU.setText("");
        txtFechaNacimientoU.setText("");
        txtCorreoU.setText("");
        txtTelefonoU.setText("");
        labelPathFotoU.setText("");
        chbActivoU.setSelected(false);
        chbInactivoU.setSelected(false);
    }

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
        labelFotoA = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        btnCrearUsuario = new javax.swing.JButton();
        btnBackUp = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        labelLogo1 = new javax.swing.JLabel();
        jPanelEditar = new javax.swing.JPanel();
        btnBuscarFoto = new javax.swing.JButton();
        labelFechaN = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        labelFormatoFecha = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        labelFoto = new javax.swing.JLabel();
        labelPathFoto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        labelLogo2 = new javax.swing.JLabel();
        boxOpEditar = new javax.swing.JComboBox<>();
        btnGuardarContr = new javax.swing.JButton();
        btnGuardarFecha = new javax.swing.JButton();
        btnGuardarCorreo = new javax.swing.JButton();
        btnGuardarTele = new javax.swing.JButton();
        btnGuardarFoto = new javax.swing.JButton();
        jPanelBuscar = new javax.swing.JPanel();
        labelNomUsuario = new javax.swing.JLabel();
        txtNomUsuario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        labelEstado = new javax.swing.JLabel();
        labelExiste = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnCancelarU = new javax.swing.JButton();
        btnBuscarFotoU = new javax.swing.JButton();
        chbInactivoU = new javax.swing.JCheckBox();
        labelEstatusU = new javax.swing.JLabel();
        labelFechaNU = new javax.swing.JLabel();
        txtFechaNacimientoU = new javax.swing.JTextField();
        labelFormatoFechaU = new javax.swing.JLabel();
        labelCorreoU = new javax.swing.JLabel();
        txtCorreoU = new javax.swing.JTextField();
        labelTelefonoU = new javax.swing.JLabel();
        labelContraseñaU = new javax.swing.JLabel();
        txtTelefonoU = new javax.swing.JTextField();
        txtContraseñaU = new javax.swing.JPasswordField();
        labelFotoU = new javax.swing.JLabel();
        chbActivoU = new javax.swing.JCheckBox();
        labelPathFotoU = new javax.swing.JLabel();
        labelLogo3 = new javax.swing.JLabel();
        boxOpEditarU = new javax.swing.JComboBox<>();
        btnGuardarContrU = new javax.swing.JButton();
        btnGuardarFechaU = new javax.swing.JButton();
        btnGuardarCorreoU = new javax.swing.JButton();
        btnGuardarTeleU = new javax.swing.JButton();
        btnGuardarFotoU = new javax.swing.JButton();
        btnGuardarEstaU = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        jPanelVerificacion = new javax.swing.JPanel();
        labelLogo4 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        btnBuscarUs = new javax.swing.JButton();
        labelBusqueda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNombre.setText("Nombre:");

        labelRol.setText("Rol:");

        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnBackUp.setText("Hacer Respaldo");
        btnBackUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackUpActionPerformed(evt);
            }
        });

        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        labelLogo1.setText("Aplicacion MEIA - Perfil de Administrador");

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBackUp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFotoA)
                            .addComponent(labelNombre)
                            .addComponent(labelRol)
                            .addComponent(labelLogo1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo1)
                .addGap(52, 52, 52)
                .addComponent(labelFotoA)
                .addGap(18, 18, 18)
                .addComponent(labelNombre)
                .addGap(18, 18, 18)
                .addComponent(labelRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearUsuario)
                    .addComponent(btnBackUp)
                    .addComponent(btnLogOut))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Usuario", jPanelUsuario);

        btnBuscarFoto.setText("Buscar");
        btnBuscarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoActionPerformed(evt);
            }
        });

        labelFechaN.setText("Fecha de Nacimiento:");

        labelFormatoFecha.setText("Formato: numDia/numMes/numAño");

        labelCorreo.setText("Correo Electronico:");

        labelTelefono.setText("Telefono:");

        labelContraseña.setText("Contraseña:");

        labelFoto.setText("Foto:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        labelLogo2.setText("Aplicacion MEIA - Edicion de Administrador");

        boxOpEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contraseña", "Fecha de Nacimiento", "Correo Electronico", "Telefono", "Foto" }));
        boxOpEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxOpEditarActionPerformed(evt);
            }
        });

        btnGuardarContr.setText("Guardar");
        btnGuardarContr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContrActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelEditarLayout = new javax.swing.GroupLayout(jPanelEditar);
        jPanelEditar.setLayout(jPanelEditarLayout);
        jPanelEditarLayout.setHorizontalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxOpEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addComponent(labelFechaN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFormatoFecha)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelEditarLayout.createSequentialGroup()
                                    .addComponent(labelCorreo)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelEditarLayout.createSequentialGroup()
                                    .addComponent(labelTelefono)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelEditarLayout.createSequentialGroup()
                                    .addComponent(labelFoto)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscarFoto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelPathFoto)))
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addComponent(labelContraseña)
                                .addGap(18, 18, 18)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarContr, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarTele, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarFecha, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar)
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelLogo2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelEditarLayout.setVerticalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo2)
                .addGap(18, 18, 18)
                .addComponent(boxOpEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarTele)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarFoto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelContraseña)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarContr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelFechaN)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardarFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFormatoFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCorreo)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelTelefono)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelFoto)
                                    .addComponent(btnBuscarFoto)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                                .addComponent(labelPathFoto)
                                .addGap(16, 16, 16)))))
                .addGap(44, 44, 44)
                .addComponent(btnCancelar)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Editar", jPanelEditar);

        labelNomUsuario.setText("Nombre de Usuario:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelEstado.setText("Estado:");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelarU.setText("Cancelar");
        btnCancelarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUActionPerformed(evt);
            }
        });

        btnBuscarFotoU.setText("Buscar");
        btnBuscarFotoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFotoUActionPerformed(evt);
            }
        });

        chbInactivoU.setText("Inactivo");

        labelEstatusU.setText("Estatus:");

        labelFechaNU.setText("Fecha de Nacimiento:");

        labelFormatoFechaU.setText("Formato: numDia/numMes/numAño");

        labelCorreoU.setText("Correo Electronico:");

        labelTelefonoU.setText("Telefono:");

        labelContraseñaU.setText("Contraseña:");

        labelFotoU.setText("Foto:");

        chbActivoU.setText("Activo");

        labelLogo3.setText("Aplicacion MEIA - Busqueda y Edicion de Usuario");

        boxOpEditarU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contraseña", "Estatus", "Fecha de Nacimiento", "Correo Electronico", "Telefono", "Foto" }));
        boxOpEditarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxOpEditarUActionPerformed(evt);
            }
        });

        btnGuardarContrU.setText("Guardar");
        btnGuardarContrU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContrUActionPerformed(evt);
            }
        });

        btnGuardarFechaU.setText("Guardar");
        btnGuardarFechaU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFechaUActionPerformed(evt);
            }
        });

        btnGuardarCorreoU.setText("Guardar");
        btnGuardarCorreoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCorreoUActionPerformed(evt);
            }
        });

        btnGuardarTeleU.setText("Guardar");
        btnGuardarTeleU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTeleUActionPerformed(evt);
            }
        });

        btnGuardarFotoU.setText("Guardar");
        btnGuardarFotoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFotoUActionPerformed(evt);
            }
        });

        btnGuardarEstaU.setText("Guardar");
        btnGuardarEstaU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstaUActionPerformed(evt);
            }
        });

        btnVer.setText("Ver Datos");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarLayout = new javax.swing.GroupLayout(jPanelBuscar);
        jPanelBuscar.setLayout(jPanelBuscarLayout);
        jPanelBuscarLayout.setHorizontalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelBuscarLayout.createSequentialGroup()
                            .addComponent(labelFotoU)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarFotoU)
                            .addGap(18, 18, 18)
                            .addComponent(labelPathFotoU)
                            .addGap(223, 223, 223))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBuscarLayout.createSequentialGroup()
                            .addComponent(labelTelefonoU)
                            .addGap(18, 18, 18)
                            .addComponent(txtTelefonoU, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBuscarLayout.createSequentialGroup()
                            .addComponent(labelCorreoU)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCorreoU, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)))
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelarU)
                            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                                .addComponent(labelFechaNU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFormatoFechaU)
                                    .addComponent(txtFechaNacimientoU, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                                .addComponent(labelEstatusU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbActivoU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbInactivoU))
                            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                                .addComponent(labelContraseñaU)
                                .addGap(18, 18, 18)
                                .addComponent(txtContraseñaU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarFotoU))
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarContrU)
                            .addComponent(btnGuardarFechaU)
                            .addComponent(btnGuardarCorreoU)
                            .addComponent(btnGuardarTeleU)
                            .addComponent(btnGuardarEstaU))
                        .addContainerGap())))
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addComponent(labelNomUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelLogo3))
                    .addComponent(boxOpEditarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addComponent(labelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelExiste, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVer)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBuscarLayout.setVerticalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomUsuario)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(btnVer))
                    .addComponent(labelExiste, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxOpEditarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContraseñaU)
                    .addComponent(txtContraseñaU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarContrU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstatusU)
                    .addComponent(chbActivoU)
                    .addComponent(chbInactivoU)
                    .addComponent(btnGuardarEstaU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFechaNU)
                    .addComponent(txtFechaNacimientoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarFechaU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFormatoFechaU)
                .addGap(11, 11, 11)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreoU)
                    .addComponent(txtCorreoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCorreoU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addComponent(btnGuardarTeleU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPathFotoU))
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefonoU)
                            .addComponent(txtTelefonoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFotoU)
                            .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscarFotoU)
                                .addComponent(btnGuardarFotoU)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarU)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar", jPanelBuscar);

        labelLogo4.setText("Aplicacion MEIA - Verificacion de Usuario");

        btnBuscarUs.setText("Buscar Usuario");
        btnBuscarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVerificacionLayout = new javax.swing.GroupLayout(jPanelVerificacion);
        jPanelVerificacion.setLayout(jPanelVerificacionLayout);
        jPanelVerificacionLayout.setHorizontalGroup(
            jPanelVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVerificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogo4)
                    .addGroup(jPanelVerificacionLayout.createSequentialGroup()
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarUs))
                    .addComponent(labelBusqueda))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanelVerificacionLayout.setVerticalGroup(
            jPanelVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVerificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo4)
                .addGap(18, 18, 18)
                .addGroup(jPanelVerificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelBusqueda)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Verificacion", jPanelVerificacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton de busqueda de nueva foto en pestaña de edicion del administrado
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
     * Boton de busqueda de nueva foto en pestaña de edicion de la busqueda de usuario
     * @param evt 
     */
    private void btnBuscarFotoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFotoUActionPerformed
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
            labelPathFotoU.setText(foto.getPath());
            btnGuardarFotoU.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarFotoUActionPerformed

    /**
     * Boton de llamada al JFrame de creacion de nuevo Usuario
     * @param evt 
     */
    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        VistaCrearUsuario.admin = MenuAdmin.admin.toString();
        VistaCrearUsuario v = new VistaCrearUsuario();
        v.setVisible(true);
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

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
     * Choice box de seleccion de campo a editar del administrador
     * @param evt 
     */
    private void boxOpEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxOpEditarActionPerformed
        switch(boxOpEditar.getSelectedItem().toString()){
            case "Contraseña":
                labelContraseña.setVisible(true);
                btnGuardarContr.setVisible(true);
                txtContraseña.setVisible(true);
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
     * Boton que guarda el nuevo valor de contraseña para el administrador
     * @param evt 
     */
    private void btnGuardarContrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContrActionPerformed
        if((txtContraseña.getPassword().length > 0)){
            String texto = String.valueOf(txtContraseña.getPassword());
            if(!(calcularSeguridad(txtContraseña.getPassword()).equals("Contraseña Insegura"))){
                texto = encriptarContraseña(texto);
                texto = completarTexto(texto, 40);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 83, adminUs);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 83, adminUs);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El nivel de seguridad de la contraseña es muy bajo", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de contraseña se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarContrActionPerformed

    /**
     * Boton que guarda el nuevo valor de fecha de nacimiento para el administrador
     * @param evt 
     */
    private void btnGuardarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFechaActionPerformed
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        if(!(txtFechaNacimiento.getText().equals(""))){
            try {
                Date fecha = date.parse(txtFechaNacimiento.getText());
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, date.format(fecha), 126, adminUs);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, date.format(fecha), 126, adminUs);
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha para continuar", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarFechaActionPerformed

    /**
     * Boton que guarda el nuevo valor de correo electronico para el administrador
     * @param evt 
     */
    private void btnGuardarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCorreoActionPerformed
        if(!(txtCorreo.getText().equals(""))){
            if(!(txtCorreo.getText().toCharArray().length > 40)){
                String texto = txtCorreo.getText();
                texto = completarTexto(texto, 40);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 137, adminUs);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 137, adminUs);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño del correo a excedido la longitud de 40 caracteres", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de correo se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCorreoActionPerformed

    /**
     * Boton que guarda el nuevo valor de telefono para el administrador
     * @param evt 
     */
    private void btnGuardarTeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTeleActionPerformed
        if(!(txtTelefono.getText().equals(""))){
            if(!(txtTelefono.getText().length() != 8)){
                try{
                    int num = Integer.parseInt(txtTelefono.getText());
                    String texto = String.valueOf(num);
                    boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 178, adminUs);
                    if(!val){
                        editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 178, adminUs);
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
    }//GEN-LAST:event_btnGuardarTeleActionPerformed

    /**
     * Boton que guarda la ubicacion de la nueva foto del administrador
     * @param evt 
     */
    private void btnGuardarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFotoActionPerformed
        if(!(labelPathFoto.getText().equals(""))){
            if(!(labelPathFoto.getText().toCharArray().length > 200)){
                String texto = labelPathFoto.getText();
                texto = completarTexto(texto, 200);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 187, adminUs);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 187, adminUs);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño de la ubicacion de la foto a excedido la longitud de 200 caracteres", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de ubicacion de foto se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarFotoActionPerformed

    /**
     * Boton que cancela la edicion del campo actual para seleccionar otro campo a editar
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        inicio1();
        boxOpEditar.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Boton que guarda el nuevo valor de contraseña para el usuario buscado
     * @param evt 
     */
    private void btnGuardarContrUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContrUActionPerformed
        if((txtContraseñaU.getPassword().length > 0)){
            String texto = String.valueOf(txtContraseñaU.getPassword());
            if(!(calcularSeguridad(txtContraseñaU.getPassword()).equals("Contraseña Insegura"))){
                texto = encriptarContraseña(texto);
                texto = completarTexto(texto, 40);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 83, adminUs, usuarioBus);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 83, adminUs, usuarioBus);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El nivel de seguridad de la contraseña es muy bajo", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de contraseña se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnGuardarContrUActionPerformed

    /**
     * Boton que guarda el nuevo valor de fecha para el usuario buscado
     * @param evt 
     */
    private void btnGuardarFechaUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFechaUActionPerformed
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        if(!(txtFechaNacimientoU.getText().equals(""))){
            try {
                Date fecha = date.parse(txtFechaNacimientoU.getText());
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, date.format(fecha), 126, adminUs, usuarioBus);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, date.format(fecha), 126, adminUs, usuarioBus);
                }
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha para continuar", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnGuardarFechaUActionPerformed

    /**
     * Boton que guarda el nuevo valor de correo para el usuario buscado
     * @param evt 
     */
    private void btnGuardarCorreoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCorreoUActionPerformed
        if(!(txtCorreoU.getText().equals(""))){
            if(!(txtCorreoU.getText().toCharArray().length > 40)){
                String texto = txtCorreoU.getText();
                texto = completarTexto(texto, 40);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 137, adminUs, usuarioBus);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 137, adminUs, usuarioBus);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño del correo a excedido la longitud de 40 caracteres", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de edicion de correo se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnGuardarCorreoUActionPerformed

    /**
     * Boton que guarda el nuevo valor de telefono para el usuario buscado
     * @param evt 
     */
    private void btnGuardarTeleUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTeleUActionPerformed
        if(!(txtTelefonoU.getText().equals(""))){
            if(!(txtTelefonoU.getText().length() != 8)){
                try{
                    int num = Integer.parseInt(txtTelefonoU.getText());
                    String texto = String.valueOf(num);
                    boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 178, adminUs, usuarioBus);
                    if(!val){
                        editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 178, adminUs, usuarioBus);
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
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnGuardarTeleUActionPerformed

    /**
     * Boton que guarda la ubicacion de la nueva foto para el usuario buscado
     * @param evt 
     */
    private void btnGuardarFotoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFotoUActionPerformed
        if(!(labelPathFotoU.getText().equals(""))){
            if(!(labelPathFotoU.getText().toCharArray().length > 200)){
                String texto = labelPathFotoU.getText();
                texto = completarTexto(texto, 200);
                boolean val = editarUsuario(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 187, adminUs, usuarioBus);
                if(!val){
                    editarUsuario(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 187, adminUs, usuarioBus);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El tamaño de la ubicacion de la foto a excedido la longitud de 200 caracteres", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de ubicacion de foto se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnGuardarFotoUActionPerformed

    /**
     * Boton que busca un usuario en la bitacora y en el archivo maestro para su edicion
     * @param evt 
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!(txtNomUsuario.getText().equals(""))){
            try {
                if(!(txtNomUsuario.getText().equals(admin))){
                    usuarioBus = buscarUsuario(txtNomUsuario.getText());
                    if(usuarioBus.getNombreDeUsuario().length > 0){
                        labelExiste.setText("El usuario buscado existe");
                        btnEditar.setVisible(true);
                        btnVer.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario", "InfoBox: " + "Error en Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Si desea editar el administrador actual porfavor haga click en la pestaña de editar de esta ventana", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } catch (ParseException ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El campo de busqueda de usuario se encuentra vacio", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Boton que guardar el nuevo estado del usuario buscado
     * @param evt 
     */
    private void btnGuardarEstaUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstaUActionPerformed
        String texto = null;
        if((chbActivoU.isSelected() == false) && (chbInactivoU.isSelected() == false)){
            if((chbActivoU.isSelected() == true) && (chbInactivoU.isSelected() == true)){
                JOptionPane.showMessageDialog(null, "Debe seleccionar unicamente una opcion, administrador o usuario", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                if(chbActivoU.isSelected()){
                    texto = "1";
                    if(usuarioBus.isEstatus()){
                        JOptionPane.showMessageDialog(null, "El usuario ya se encuentra activo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        boolean val = editarUsuarioEstado(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 388, true, adminUs, usuarioBus);
                        if(!val){
                            editarUsuarioEstado(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 388, true, adminUs, usuarioBus);
                        }
                        dispose();
                        VistaLogin v = new VistaLogin();
                    }
                }
                if(chbInactivoU.isSelected()){
                    texto = "0";
                    if(usuarioBus.isEstatus()){
                        JOptionPane.showMessageDialog(null, "El usuario ya se encuentra inactivo", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        boolean val = editarUsuarioEstado(Proyecto1.bitacoraUsuario, Proyecto1.descBitacoraUsuario, texto, 388, false, adminUs, usuarioBus);
                        if(!val){
                            editarUsuarioEstado(Proyecto1.maestroUsuario, Proyecto1.descMaestroUsuario, texto, 388, false, adminUs, usuarioBus);
                        }
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna opcion para continuar", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnGuardarEstaUActionPerformed

    /**
     * Boton que busca un usuario en la bitacora y en el archivo maestro para ver si existe o no
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
     * Choice box de seleccion de campo a editar del resultado de la busqueda de usuario
     * @param evt 
     */
    private void boxOpEditarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxOpEditarUActionPerformed
        switch(boxOpEditarU.getSelectedItem().toString()){
            case "Contraseña":
                labelContraseñaU.setVisible(true);
                btnGuardarContrU.setVisible(true);
                txtContraseñaU.setVisible(true);
                break;
            case "Estatus":
                chbActivoU.setVisible(true);
                chbInactivoU.setVisible(true);
                btnGuardarEstaU.setVisible(true);
                labelEstatusU.setVisible(true);
                break;
            case "Fecha de Nacimiento":
                txtFechaNacimientoU.setVisible(true);
                labelFechaNU.setVisible(true);
                labelFormatoFechaU.setVisible(true);
                btnGuardarFechaU.setVisible(true);
                break;
            case "Correo Electronico":
                txtCorreoU.setVisible(true);
                labelCorreoU.setVisible(true);
                btnGuardarCorreoU.setVisible(true);
                break;
            case "Telefono":
                txtTelefonoU.setVisible(true);
                labelTelefonoU.setVisible(true);
                btnGuardarTeleU.setVisible(true);
                break;
            case "Foto":
                labelPathFotoU.setVisible(true);
                labelFotoU.setVisible(true);
                btnBuscarFotoU.setVisible(true);
                break;
        }
        boxOpEditarU.setVisible(false);
    }//GEN-LAST:event_boxOpEditarUActionPerformed

    /**
     * Boton que cancela la edicion del campo actual para seleccionar otro campo a editar
     * @param evt 
     */
    private void btnCancelarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUActionPerformed
        inicio2();
        boxOpEditarU.setVisible(true);
    }//GEN-LAST:event_btnCancelarUActionPerformed

    /**
     * Boton que muestra las opciones de edicion del resultado de la busqueda de usuario
     * @param evt 
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        boxOpEditarU.setVisible(true);
        labelExiste.setText("Usuario Actual: " + txtNomUsuario.getText());
        txtNomUsuario.setText("");
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Realiza el backup de los archivos de la carpeta C:\\MEIA en la ubicacion seleccionada
     * @param evt 
     */
    private void btnBackUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackUpActionPerformed
        File[] archivosMEIA = root.listFiles();
        File destRoot = null;
        JFileChooser dialogo = new JFileChooser();
        dialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dialogo.setAcceptAllFileFilterUsed(false);
        if (dialogo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            int cont = 0;
            destRoot = dialogo.getSelectedFile();
            try{
                File dest = new File(destRoot, "MEIA_Backup");
                dest.mkdirs();
                File destImagenes = new File(dest, "Imagenes");
                destImagenes.mkdirs();
                for (File archivo : archivosMEIA) {
                    if (archivo.getPath().contains(".txt")) {
                        File copy = new File(dest, archivo.getName());
                        copiarArchivo(archivo, copy);
                        cont++;
                    } else {
                        File[] imagenes = archivo.listFiles();
                        for (File imagen : imagenes) {
                            File copy = new File(destImagenes, imagen.getName());
                            copiarArchivo(imagen, copy);
                            cont++;
                        }
                    }
                }
                if(leerArchivo(Proyecto1.bitacoraBackup).equals("")){
                    BitacoraBackup bk = new BitacoraBackup();
                    bk.setFechaTransaccion(new Date());
                    if(!(dest.getAbsolutePath().toCharArray().length > 200)){
                        bk.setRutaAbsoltua(dest.getAbsolutePath().toCharArray());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La ruta del backup excede el limite de 200 caracteres", "InfoBox: " + "Error en Creacion de Bitacora", JOptionPane.INFORMATION_MESSAGE);
                    }
                    bk.setUsuario(adminUs.getNombreDeUsuario());
                    escribirBitacoraBackup(Proyecto1.bitacoraBackup, bk);
                    escribirDescriptorBackup(Proyecto1.descBitacoraBackup, new DescBitacoraBackup("bitacora_Backup", new Date(), String.valueOf(adminUs.getNombreDeUsuario()), new Date(), String.valueOf(adminUs.getNombreDeUsuario()), 1));
                }
                else{
                    BitacoraBackup bk = new BitacoraBackup();
                    bk.setFechaTransaccion(new Date());
                    if(!(dest.getAbsolutePath().toCharArray().length > 200)){
                        bk.setRutaAbsoltua(dest.getAbsolutePath().toCharArray());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La ruta del backup excede el limite de 200 caracteres", "InfoBox: " + "Error en Creacion de Bitacora", JOptionPane.INFORMATION_MESSAGE);
                    }
                    bk.setUsuario(adminUs.getNombreDeUsuario());
                    escribirBitacoraBackup(Proyecto1.bitacoraBackup, bk);
                    DescBitacoraBackup descBackup = leerDescriptorBackup(Proyecto1.descBitacoraBackup);
                    limpiarArchivo(Proyecto1.descBitacoraBackup);
                    escribirDescriptorBackup(Proyecto1.descBitacoraBackup, new DescBitacoraBackup(descBackup.getNombreSimbolico(), descBackup.getFechaCreacion(), descBackup.getUsuarioCreacion(), new Date(), String.valueOf(adminUs.getNombreDeUsuario()), descBackup.getNumRegistros() + 1));
                }
                JOptionPane.showMessageDialog(null, "Backup realizado con exito", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "no se ha seleccionado el destino del backup", "InfoBox: " + "Error en Edicion de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBackUpActionPerformed

    /**
     * Llama a la vista de visualizacion de los elementos del usuario buscado
     * @param evt 
     */
    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        VistaDatos.user = String.valueOf(usuarioBus.getNombreDeUsuario());
        VistaDatos v = new VistaDatos();
        v.setVisible(true);
    }//GEN-LAST:event_btnVerActionPerformed

    /**
     * Editor de un campo del administrador
     * @param archivo File donde se buscara el usuario
     * @param descriptor descriptor que se actualizara al editar el usuario
     * @param texto nuevo campo del usuario
     * @param pos posicion en la linea del campo a editar
     * @param administrador usuario a buscar en el archivo y que hace las momdificaciones
     * @return valor booleano de si se econtro y edito el usuario o no
     */
    public boolean editarUsuario(File archivo, File descriptor, String texto, int pos, Usuario administrador){
        boolean fin = false;
            int cont = 0;
            long puntero = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                raf.seek(0);
                String linea = raf.readLine();
                while(!fin){
                    if(linea.contains(String.valueOf(administrador.getNombreDeUsuario()))){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(administrador.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getMaxReorganizacion()));
                        fin = true;
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        cont = cont + 391;
                    }
                }
                JOptionPane.showMessageDialog(null, "El usuario se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                boxOpEditar.setVisible(true);
                inicio1();
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }

    /**
     * Editor de un campo del resultado de busqueda de usuario
     * @param archivo File donde se buscara el usuario
     * @param descriptor descriptor que se actualizara al editar el usuario
     * @param texto nuevo campo del usuario
     * @param pos posicion en la linea del campo a editar
     * @param administrador usuario que realiza las modificaciones
     * @param busqueda usuario en el que se modifican los campos
     * @return valor booleano de si se econtro y edito el usuario o no
     */
    public boolean editarUsuario(File archivo, File descriptor, String texto, int pos, Usuario administrador, Usuario busqueda){
        boolean fin = false;
            int cont = 0;
            long puntero = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                raf.seek(0);
                String linea = raf.readLine();
                while(!fin){
                    if(linea.contains(String.valueOf(busqueda.getNombreDeUsuario()))){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        escribirDescriptor(descriptor, new DescUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(administrador.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos(), desB.getRegistrosInactivos(), desB.getMaxReorganizacion()));
                        fin = true;
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        cont = cont + 391;
                    }
                }
                JOptionPane.showMessageDialog(null, "El usuario se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                boxOpEditarU.setVisible(true);
                inicio1();
                inicio2();
            } catch (Exception ex) {
                Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fin;
    }
    
    /**
     * Editor del Estatus del resultado de busqueda de usuario
     * @param archivo File donde se buscara el usuario
     * @param descriptor descriptor que se actualizara al editar el usuario
     * @param texto nuevo campo del usuario
     * @param pos posicion en la linea del campo a editar
     * @param val booleano que determina si se le agrega o quita a los registros activos
     * @param administrador usuario que realiza las modificaciones
     * @param busqueda usuario en el que se modifican los campos
     * @return valor booleano de si se econtro y edito el usuario o no
     */
     public boolean editarUsuarioEstado(File archivo, File descriptor, String texto, int pos, boolean val, Usuario administrador, Usuario busqueda){
        boolean fin = false;
            int cont = 0;
            long puntero = 0;
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                raf.seek(0);
                String linea = raf.readLine();
                while(!fin){
                    if(linea.contains(String.valueOf(busqueda.getNombreDeUsuario()))){
                        puntero = raf.getFilePointer();
                        raf.seek(cont + pos);
                        raf.writeBytes(texto);
                        DescUsuario desB = leerDescriptor(descriptor);
                        limpiarArchivo(descriptor);
                        if(val){
                            escribirDescriptor(descriptor, new DescUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(administrador.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() + 1, desB.getRegistrosInactivos() - 1, desB.getMaxReorganizacion()));
                        }
                        else{
                            escribirDescriptor(descriptor, new DescUsuario(desB.getNombreSimbolico(), desB.getFechaCreacion(), desB.getUsuarioCreacion(), new Date(), String.valueOf(administrador.getNombreDeUsuario()), desB.getNumRegistros(), desB.getRegistrosActivos() - 1, desB.getRegistrosInactivos() + 1, desB.getMaxReorganizacion()));
                        }
                        fin = true;
                        break;
                    }
                    else{
                        linea = raf.readLine();
                        cont = cont + 391;
                    }
                }
                JOptionPane.showMessageDialog(null, "El usuario se ha modificado exitosamente", "InfoBox: " + "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                boxOpEditarU.setVisible(true);
                inicio1();
                inicio2();
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
     * Metodo que escribe al descriptor de usuario 
     * @param archivo informacion que se escribira
     * @param des archivo al que se escribira
     * @throws IOException 
     */
    public void escribirDescriptor(File archivo, DescUsuario des) throws IOException{
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
     * Metodo que escribe al descriptor de la bitacora del backup
     * @param archivo
     * @param des
     * @throws IOException 
     */
    public void escribirDescriptorBackup(File archivo, DescBitacoraBackup des) throws IOException{
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
        FileOutputStream fos = new FileOutputStream(archivo, true);
        fos.write(texto.getBytes());
        fos.flush();
        fos.close();
    }
    
    /**
     * Metodo que escribe una entrada a la bitacora de backups
     * @param archivo archivo al que se escribe la entrada
     * @param bit informacion que se va a escribir a la bitacora de backups
     * @throws IOException 
     */
    public void escribirBitacoraBackup(File archivo, BitacoraBackup bit)throws IOException{
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        String texto = "";
        String div = "|";
        String fin = "\r\n";
        texto += completarTexto(String.valueOf(bit.getRutaAbsoltua()), 200);
        texto += div;
        texto += completarTexto(String.valueOf(bit.getUsuario()), 20);
        texto += div;
        texto += date.format(bit.getFechaTransaccion());
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
     * Funcion que lee el contenido del descriptor de la bitacora de usuarios
     * @param archivo Archivo del descriptor que se va a leer
     * @return informacion leida del descriptor
     * @throws IOException 
     */
    public DescUsuario leerDescriptor(File archivo) throws IOException{
        DescUsuario desc = null;
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
                desc = new DescUsuario(contenido[0], date.parse(contenido[1]), contenido[2], date.parse(contenido[3]), contenido[4], Integer.parseInt(contenido[5]), Integer.parseInt(contenido[6]), Integer.parseInt(contenido[7]), Integer.parseInt(contenido[8]));
            }catch(Exception e){
                e.printStackTrace();
            }
            return desc;
        }
    }
    
    /**
     * Funcion que lee el contenido del descriptor de la bitacora de backups
     * @param archivo Archivo del descriptor que se va a leer
     * @return informacion leida del descriptor
     * @throws IOException
     */
    public DescBitacoraBackup leerDescriptorBackup(File archivo)throws IOException{
        DescBitacoraBackup desc = null;
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
                desc = new DescBitacoraBackup(contenido[0], date.parse(contenido[1]), contenido[2], date.parse(contenido[3]), contenido[4], Integer.parseInt(contenido[5]));
            }catch(Exception e){
                e.printStackTrace();
            }
            return desc;
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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxOpEditar;
    private javax.swing.JComboBox<String> boxOpEditarU;
    private javax.swing.JButton btnBackUp;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarFoto;
    private javax.swing.JButton btnBuscarFotoU;
    private javax.swing.JButton btnBuscarUs;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarU;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardarContr;
    private javax.swing.JButton btnGuardarContrU;
    private javax.swing.JButton btnGuardarCorreo;
    private javax.swing.JButton btnGuardarCorreoU;
    private javax.swing.JButton btnGuardarEstaU;
    private javax.swing.JButton btnGuardarFecha;
    private javax.swing.JButton btnGuardarFechaU;
    private javax.swing.JButton btnGuardarFoto;
    private javax.swing.JButton btnGuardarFotoU;
    private javax.swing.JButton btnGuardarTele;
    private javax.swing.JButton btnGuardarTeleU;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnVer;
    private javax.swing.JCheckBox chbActivoU;
    private javax.swing.JCheckBox chbInactivoU;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JPanel jPanelEditar;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPanel jPanelVerificacion;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelBusqueda;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelContraseñaU;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelCorreoU;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelEstatusU;
    private javax.swing.JLabel labelExiste;
    private javax.swing.JLabel labelFechaN;
    private javax.swing.JLabel labelFechaNU;
    private javax.swing.JLabel labelFormatoFecha;
    private javax.swing.JLabel labelFormatoFechaU;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelFotoA;
    private javax.swing.JLabel labelFotoU;
    private javax.swing.JLabel labelLogo1;
    private javax.swing.JLabel labelLogo2;
    private javax.swing.JLabel labelLogo3;
    private javax.swing.JLabel labelLogo4;
    private javax.swing.JLabel labelNomUsuario;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPathFoto;
    private javax.swing.JLabel labelPathFotoU;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTelefonoU;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JPasswordField txtContraseñaU;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoU;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoU;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoU;
    // End of variables declaration//GEN-END:variables
}
