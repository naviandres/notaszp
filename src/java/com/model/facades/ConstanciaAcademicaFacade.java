/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.facades;

import com.model.entities.ConstanciaAcademica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IVAN ANDRES
 */
@Stateless
public class ConstanciaAcademicaFacade extends AbstractFacade<ConstanciaAcademica> {

    @PersistenceContext(unitName = "notaszpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConstanciaAcademicaFacade() {
        super(ConstanciaAcademica.class);
    }
    
}
