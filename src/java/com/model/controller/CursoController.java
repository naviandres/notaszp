/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;

import com.model.entities.Curso;
import com.model.facades.CursoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author
 */
@Named(value = "cursoController")
@SessionScoped
public class CursoController implements Serializable {

    /**
     * Creates a new instance of CursosController
     */
    public CursoController() {

    }

    @EJB
    private CursoFacade cf;
    private Curso curso;
    private boolean colorAlert;

    @PostConstruct
    public void init() {
        curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isColorAlert() {
        return colorAlert;
    }

    public void setColorAlert(boolean colorAlert) {
        this.colorAlert = colorAlert;
    }

    public void registrar() {
        try {
            this.cf.create(curso);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro satisfactorio"));
            this.setColorAlert(true);
            init();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error"));
            System.out.println("Eroor" + e.getMessage());
            this.setColorAlert(false);
        }
    }

    public String colorAlerta() {
        System.out.println("ColorAler" + colorAlert);
        if (colorAlert) {
            return "ui green message";
        } else if (colorAlert == false) {
            return "ui red message";
        }
        return "";
    }

    public java.util.List<Curso> getCursos() {
        return this.cf.findAll();
    }

    public void eliminar() {
        this.cf.remove(curso);
    }

    public String editar(Curso c) {
        //guarda el objeto curso para su posterior edicion
        setCurso(c);
        return "EditarCurso.xhtml?faces-redirect=true";
    }

    public String guardarEditar() {
        //guarda la edicion del curso
        this.cf.edit(curso);
        return "ListaCursos.xhtml?faces-redirect=true";
    }

}
