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
public class BitacoraBackup {
    public char[] rutaAbsoltua = new char[200];
    public char[] usuario = new char[20];
    public Date fechaTransaccion;
    
    public char[] getRutaAbsoltua() {
        return rutaAbsoltua;
    }

    public void setRutaAbsoltua(char[] rutaAbsoltua) {
        this.rutaAbsoltua = rutaAbsoltua;
    }

    public char[] getUsuario() {
        return usuario;
    }

    public void setUsuario(char[] usuario) {
        this.usuario = usuario;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
    
}
