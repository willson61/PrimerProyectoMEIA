/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.Date;

/**
 *
 * @author Sthephan
 */
public class Correo {
    public int izquierdo;
    public int derecho;
    public char[] emisor = new char[20];
    public char[] receptor = new char[20];
    public Date fechaTransaccion;
    public char[] asunto = new char[30];
    public char[] mensaje = new char[100];
    public boolean Estatus;

    public int getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(int izquierdo) {
        this.izquierdo = izquierdo;
    }

    public int getDerecho() {
        return derecho;
    }

    public void setDerecho(int derecho) {
        this.derecho = derecho;
    }

    public char[] getEmisor() {
        return emisor;
    }

    public void setEmisor(char[] emisor) {
        this.emisor = emisor;
    }

    public char[] getReceptor() {
        return receptor;
    }

    public void setReceptor(char[] receptor) {
        this.receptor = receptor;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public char[] getAsunto() {
        return asunto;
    }

    public void setAsunto(char[] asunto) {
        this.asunto = asunto;
    }

    public char[] getMensaje() {
        return mensaje;
    }

    public void setMensaje(char[] mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEstatus() {
        return Estatus;
    }

    public void setEstatus(boolean Estatus) {
        this.Estatus = Estatus;
    }

    
    
}
