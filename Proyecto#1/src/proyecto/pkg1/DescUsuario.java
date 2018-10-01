/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.util.Date;

/**
 * Clase del descriptor de la bitacora de usuarios
 * Con sus variables, getters y setters
 * @author Sthephan
 */
public class DescUsuario {
    public String nombreSimbolico;
    public Date fechaCreacion;
    public String usuarioCreacion;
    public Date fechaModificacion;
    public String usuarioModificacion;
    public int numRegistros;
    public int registrosActivos;
    public int registrosInactivos;
    public int maxReorganizacion;

    public DescUsuario(String nombreSimbolico, Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion, int numRegistros, int registrosActivos, int registrosInactivos, int maxReorganizacion) {
        this.nombreSimbolico = nombreSimbolico;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
        this.numRegistros = numRegistros;
        this.registrosActivos = registrosActivos;
        this.registrosInactivos = registrosInactivos;
        this.maxReorganizacion = maxReorganizacion;
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

    public int getRegistrosActivos() {
        return registrosActivos;
    }

    public void setRegistrosActivos(int registrosActivos) {
        this.registrosActivos = registrosActivos;
    }

    public int getRegistrosInactivos() {
        return registrosInactivos;
    }

    public void setRegistrosInactivos(int registrosInactivos) {
        this.registrosInactivos = registrosInactivos;
    }

    public int getMaxReorganizacion() {
        return maxReorganizacion;
    }

    public void setMaxReorganizacion(int maxReorganizacion) {
        this.maxReorganizacion = maxReorganizacion;
    }
    
}
