/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Sthephan
 */
public class Usuario {
    public char[] nombreDeUsuario = new char[20];
    public char[] nombre = new char[30];
    public char[] apellido = new char[30];
    public char[] password = new char[40];
    public boolean rol;
    public Date fechaNacimiento;
    public char[] correoAlterno = new char[40];
    public int telefono;
    public char[] pathFotografia = new char[200];
    public boolean estatus;

    public char[] getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(char[] nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char[] getCorreoAlterno() {
        return correoAlterno;
    }

    public void setCorreoAlterno(char[] correoAlterno) {
        this.correoAlterno = correoAlterno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public char[] getPathFotografia() {
        return pathFotografia;
    }

    public void setPathFotografia(char[] pathFotografia) {
        this.pathFotografia = pathFotografia;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
}
class StringComparator  implements Comparator<Usuario> {
    
    @Override  
    public int compare(Usuario obj1, Usuario obj2) {
        if (String.valueOf(obj1.getNombreDeUsuario()).equals(String.valueOf(obj2.getNombreDeUsuario()))) {
            return 0;
        }
        if (String.valueOf(obj1.getNombreDeUsuario()).equals("")) {
            return -1;
        }
        if (String.valueOf(obj2.getNombreDeUsuario()).equals("")) {
            return 1;
        }
        return String.valueOf(obj1.getNombreDeUsuario()).compareTo(String.valueOf(obj2.getNombreDeUsuario()));
    }
}
