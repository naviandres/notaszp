/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;

import com.model.entities.Asignatura;
import com.model.entities.Calificacion;
import com.model.entities.Estudiante;
import com.model.entities.TblEstudiantesHasTblAsignaturas;
import com.model.facades.AsignaturaFacade;
import com.model.facades.CalificacionFacade;
import com.model.facades.EstudianteFacade;
import com.model.facades.TblEstudiantesHasTblAsignaturasFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author IVAN ANDRES
 */
@Named(value = "calificacionController")
@SessionScoped
public class CalificacionController implements Serializable {

    /**
     * Creates a new instance of Calificacion
     */
    public CalificacionController() {
    }

    @EJB
    private CalificacionFacade cf;
    @EJB
    private TblEstudiantesHasTblAsignaturasFacade eaf;
    @EJB
    private AsignaturaFacade af;
    @EJB
    private EstudianteFacade ef;

    private Calificacion calificacion;
    private Estudiante estudiante;
    private Asignatura asignatura;
    private TblEstudiantesHasTblAsignaturas estudianteAsignatura;
    private int est;
    private int asi;
    private boolean colorAlert;

    @PostConstruct
    public void init() {
        calificacion = new Calificacion();
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public int getAsi() {
        return asi;
    }

    public void setAsi(int asi) {
        this.asi = asi;
    }

    public boolean isColorAlert() {
        return colorAlert;
    }

    public void setColorAlert(boolean colorAlert) {
        this.colorAlert = colorAlert;
    }

    public void registrar() {
        if (calificacion.getNota().longValue() >= 0 && calificacion.getNota().longValue() <= 6) {
            estudianteAsignatura = new TblEstudiantesHasTblAsignaturas();
            asignatura = af.find(asi);
            estudiante = ef.find(est);

            estudianteAsignatura.setFkIdAsignatura(asignatura);
            estudianteAsignatura.setFkIdEstudiante(estudiante);
            this.eaf.create(estudianteAsignatura);

            calificacion.setFkEstudianteAsignatura(estudianteAsignatura);
            this.cf.create(calificacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro satisfactorio"));
            this.setColorAlert(true);
            init();
        } else {
            this.setColorAlert(false);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("La calificacio debe estar entre: 0.0 y 6.0"));
        }

    }

    public String colorAlerta() {
        if (colorAlert) {
            return "ui green message";
        } else if (colorAlert == false) {
            return "ui red message";
        }
        return "";
    }

    public List<Calificacion> getCalificaciones() {
        return this.cf.findAll();
    }

    public void eliminar() {

        this.cf.remove(calificacion);
    }

    public String editar(Calificacion c) {
        this.setCalificacion(c);
        return "EditarCalificacion.xhtml?faces-redirect=true";
    }

    public String guardarEdicion() {
        this.cf.edit(calificacion);
        return "ListaCalificacion.xhtml?faces-redirect=true";
    }

}
