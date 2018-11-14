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
public class CorreoRed {
    public int grupoemisor;
    public int gruporeceptor;
    public String emisor;
    public String receptor;
    public String asunto;
    public String mensaje;
    public Date fechaTransaccion;

    public CorreoRed(int grupoemisor, int gruporeceptor, String emisor, String receptor, String asunto, String mensaje, Date fechaTransaccion) {
        this.grupoemisor = grupoemisor;
        this.gruporeceptor = gruporeceptor;
        this.emisor = emisor;
        this.receptor = receptor;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.fechaTransaccion = fechaTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
    

    public int getGrupoemisor() {
        return grupoemisor;
    }

    public void setGrupoemisor(int grupoemisor) {
        this.grupoemisor = grupoemisor;
    }

    public int getGruporeceptor() {
        return gruporeceptor;
    }

    public void setGruporeceptor(int gruporeceptor) {
        this.gruporeceptor = gruporeceptor;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
