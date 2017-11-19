/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;
import com.model.entities.Usuarios;
import com.model.facades.UsuariosFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 *
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private UsuariosFacade usuariosCrud;
    private Usuarios usuariosSesion;
    private String identificacion;
    private String clave;
    private List<Usuarios> usuariosList;

    public SessionController() {
        usuariosSesion = new Usuarios();
    }

    @PostConstruct
    public void init() {
        usuariosSesion = new Usuarios();
    }

    public Usuarios getUsuariosSesion() {
        return usuariosSesion;
    }

    public void setUsuariosSesion(Usuarios usuariosSesion) {
        this.usuariosSesion = usuariosSesion;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    //base 
    public String usuarioInicarSesion() {

        try {
            if (identificacion != null && clave != null) {
                setUsuariosSesion(usuariosCrud.InicioSession(identificacion, clave));
                if (usuariosSesion != null) {
                    System.out.println("pues si perro");
                    return "inicio";
                }
            }

        } catch (Exception e) {
            System.out.println("No paso el controller");
            return "falloInicioSession";
        }
        return "falloInicioSession";
    }
    
    public String cerrarSesion()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuariosSesion = null;
        identificacion = null;
        clave = null;
        return "cerrarSession";
    }
    
    @PreDestroy
    public void preDestroy()
    {
        cerrarSesion();
    }
}
