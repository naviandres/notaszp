/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;

import com.model.entities.Asignatura;
import com.model.facades.AsignaturaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author IVAN ANDRES
 */
@Named(value = "asignaturaController")
@Dependent
public class AsignaturaController {

    /**
     * Creates a new instance of AsignaturaController
     */
    public AsignaturaController() {
    }
    
    @EJB
    private AsignaturaFacade af;
    
    private Asignatura asignatura;
    
    public List<Asignatura> getAsignaturas()
    {
        return this.af.findAll();
    }
    
}
