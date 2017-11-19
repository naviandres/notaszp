/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.facades;

import com.model.entities.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *

 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "notaszpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios InicioSession(String identificacion, String clave){
        try {
            TypedQuery<Usuarios> query = getEntityManager().createNamedQuery("Usuarios.login",Usuarios.class);
            query.setParameter("identificacion", identificacion);
            query.setParameter("contraseña", clave);
            System.out.println("Si existe el usuario");
            return query.getSingleResult();
        } catch (Exception e) {
            
            System.out.println("El usuario no ingreso a la sesión");
            e.printStackTrace();
            return null;
            
        }
    }
    
    
    
}
