package epn.edu.ec.modelo;

import java.io.Serializable;

public class ActividadesInstrumentos implements Serializable {

    private AdolescenteInfractorUDI idActividadesInstrumentos;
    private Boolean planEjecucionMedida;
    private Boolean planGlobalFamilia;
    private Boolean planVida;
    private Boolean planIndividualAplicaconMedida;
    

    public ActividadesInstrumentos() {
    }

    public AdolescenteInfractorUDI getIdActividadesInstrumentos() {
        return idActividadesInstrumentos;
    }

    public void setIdActividadesInstrumentos(AdolescenteInfractorUDI id_ActividadesInstrumentos) {
        this.idActividadesInstrumentos = id_ActividadesInstrumentos;
    }

    public Boolean getPlanEjecucionMedida() {
        return planEjecucionMedida;
    }

    public void setPlanEjecucionMedida(Boolean planEjecucionMedida) {
        this.planEjecucionMedida = planEjecucionMedida;
    }

    public Boolean getPlanIndividualAplicaconMedida() {
        return planIndividualAplicaconMedida;
    }

    public void setPlanIndividualAplicaconMedida(Boolean planIndividualAplicaconMedida) {
        this.planIndividualAplicaconMedida = planIndividualAplicaconMedida;
    }

    

    public Boolean getPlanGlobalFamilia() {
        return planGlobalFamilia;
    }

    public void setPlanGlobalFamilia(Boolean planGlobalFamilia) {
        this.planGlobalFamilia = planGlobalFamilia;
    }

    public Boolean getPlanVida() {
        return planVida;
    }

    public void setPlanVida(Boolean planVida) {
        this.planVida = planVida;
    }

    @Override
    public String toString() {
        return "ActividadesInstrumentos{" + "idActividadesInstrumentos=" + idActividadesInstrumentos + ", planEjecucionMedida=" + planEjecucionMedida + ", planGlobalFamilia=" + planGlobalFamilia + ", planVida=" + planVida + ", planIndividualAplicaconMedida=" + planIndividualAplicaconMedida + '}';
    }

    
    
}
