/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author User
 */
public class RegistroAsistencia implements Serializable {

    private TallerPsicologia idRegistroAsistencia;

    private Date fecha;
    private String tematica;
    private String seccion;

    public RegistroAsistencia() {
    }

    public TallerPsicologia getIdRegistroAsistencia() {
        return idRegistroAsistencia;
    }

    public void setIdRegistroAsistencia(TallerPsicologia idRegistroAsistencia) {
        this.idRegistroAsistencia = idRegistroAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "RegistroAsistencia{" + "idRegistroAsistencia=" + idRegistroAsistencia + ", fecha=" + fecha + ", tematica=" + tematica + ", seccion=" + seccion + '}';
    }
  
}
