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
public class DescBitacoraBackup {
    public String nombreSimbolico;
    public Date fechaCreacion;
    public String usuarioCreacion;
    public Date fechaModificacion;
    public String usuarioModificacion;
    public int numRegistros;

    public DescBitacoraBackup(String nombreSimbolico, Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion, int numRegistros) {
        this.nombreSimbolico = nombreSimbolico;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
        this.numRegistros = numRegistros;
    }
        

    public String getNombreSimbolico() {
        return nombreSimbolico;
    }

    public void setNombreSimbolico(String nombreSimbolico) {
        this.nombreSimbolico = nombreSimbolico;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public int getNumRegistros() {
        return numRegistros;
    }

    public void setNumRegistros(int numRegistros) {
        this.numRegistros = numRegistros;
    }
    
}
