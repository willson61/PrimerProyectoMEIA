/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

/**
 *
 * @author Sthephan
 */
public class IndiceListaUsuario {
    public int numeroRegistro;
    public int posicion;
    public char[] nombreLista = new char[30];
    public char[] usuario = new char[20];
    public char[] usuarioAsociado = new char[20];
    public int siguiente;
    public boolean estatus;

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

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

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}
