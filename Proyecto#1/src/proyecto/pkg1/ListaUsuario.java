/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Sthephan
 */
public class ListaUsuario {
    public char[] nombreLista = new char[30];
    public char[] usuario = new char[20];
    public char[] usuarioAsociado = new char[20];
    public char[] descripcion = new char[40];
    public Date fechaCreacion;
    public boolean estatus;

    public char[] getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(char[] nombreLista) {
        this.nombreLista = nombreLista;
    }

    public char[] getUsuario() {
        return usuario;
    }

    public void setUsuario(char[] usuario) {
        this.usuario = usuario;
    }

    public char[] getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(char[] usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public char[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(char[] descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}

class ListUserComparator implements Comparator<ListaUsuario>{
    
    @Override  
    public int compare(ListaUsuario obj1, ListaUsuario obj2) {
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
}
