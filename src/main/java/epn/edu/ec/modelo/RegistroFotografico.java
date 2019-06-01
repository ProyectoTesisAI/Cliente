package epn.edu.ec.modelo;

import java.io.Serializable;

public class RegistroFotografico implements Serializable {

    private Integer idRegistroFotografico;
    private String foto;
    private String descripcion;
    private InformePsicologia idInformePsicologia;
    private Fotografia imagen;

    public RegistroFotografico() {
    }

    public Integer getIdRegistroFotografico() {
        return idRegistroFotografico;
    }

    public void setIdRegistroFotografico(Integer idRegistroFotografico) {
        this.idRegistroFotografico = idRegistroFotografico;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InformePsicologia getIdInformePsicologia() {
        return idInformePsicologia;
    }

    public void setIdInformePsicologia(InformePsicologia idInformePsicologia) {
        this.idInformePsicologia = idInformePsicologia;
    }

    public Fotografia getImagen() {
        return imagen;
    }

    public void setImagen(Fotografia imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "RegistroFotografico{" + "idRegistroFotografico=" + idRegistroFotografico + ", foto=" + foto + ", descripcion=" + descripcion + ", idInformePsicologia=" + idInformePsicologia + ", imagen=" + imagen + '}';
    }

    
}
