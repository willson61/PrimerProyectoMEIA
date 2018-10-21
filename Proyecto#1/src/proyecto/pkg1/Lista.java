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
public class Lista {
    public char[] nombreLista = new char[30];
    public char[] usuario = new char[20];
    public char[] descripcion = new char[40];
    public int numeroUsuarios;
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

    public char[] getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(char[] descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroUsuarios() {
        return numeroUsuarios;
    }

    public void setNumeroUsuarios(int numeroUsuarios) {
        this.numeroUsuarios = numeroUsuarios;
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

class ListComparator implements Comparator<Lista>{
    
    @Override  
    public int compare(Lista obj1, Lista obj2) {
        if (String.valueOf(obj1.getNombreLista()).equals(String.valueOf(obj2.getNombreLista()))) {
            if (String.valueOf(obj1.getUsuario()).equals(String.valueOf(obj2.getUsuario()))) {
                return 0;
            }
            if (String.valueOf(obj1.getUsuario()).equals("")) {
                return -1;
            }
            if (String.valueOf(obj2.getUsuario()).equals("")) {
                return 1;
            }
            return String.valueOf(obj1.getUsuario()).compareTo(String.valueOf(obj2.getUsuario()));
        }
        if (String.valueOf(obj1.getNombreLista()).equals("")) {
            return -1;
        }
        if (String.valueOf(obj2.getNombreLista()).equals("")) {
            return 1;
        }
        return String.valueOf(obj1.getNombreLista()).compareTo(String.valueOf(obj2.getNombreLista()));
    }
}
