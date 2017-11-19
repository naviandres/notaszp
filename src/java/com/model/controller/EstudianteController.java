/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;

import com.model.entities.Estudiante;
import com.model.facades.EstudianteFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author IVAN ANDRES
 */
@Named(value = "estudianteController")
@Dependent
public class EstudianteController {

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {
    }
    
    @EJB
    private EstudianteFacade ef;
    private Estudiante estudiante;
    
    @PostConstruct
    public void init()
    {
        estudiante = new Estudiante();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public List<Estudiante> getEstudiantes()
    {
        return this.ef.findAll();
    }
}
