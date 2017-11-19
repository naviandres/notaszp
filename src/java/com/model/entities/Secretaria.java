/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author IVAN ANDRES
 */
@Entity
@Table(name = "tbl_secretaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretaria.findAll", query = "SELECT s FROM Secretaria s")
    , @NamedQuery(name = "Secretaria.findByIdSecretaria", query = "SELECT s FROM Secretaria s WHERE s.idSecretaria = :idSecretaria")
    , @NamedQuery(name = "Secretaria.findByContrasena", query = "SELECT s FROM Secretaria s WHERE s.contrasena = :contrasena")})
public class Secretaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_secretaria")
    private Integer idSecretaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios fkIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSecretaria", fetch = FetchType.LAZY)
    private List<ConstanciaAcademica> constanciaAcademicaList;

    public Secretaria() {
    }

    public Secretaria(Integer idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public Secretaria(Integer idSecretaria, String contrasena) {
        this.idSecretaria = idSecretaria;
        this.contrasena = contrasena;
    }

    public Integer getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(Integer idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuarios getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuarios fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @XmlTransient
    public List<ConstanciaAcademica> getConstanciaAcademicaList() {
        return constanciaAcademicaList;
    }

    public void setConstanciaAcademicaList(List<ConstanciaAcademica> constanciaAcademicaList) {
        this.constanciaAcademicaList = constanciaAcademicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSecretaria != null ? idSecretaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretaria)) {
            return false;
        }
        Secretaria other = (Secretaria) object;
        if ((this.idSecretaria == null && other.idSecretaria != null) || (this.idSecretaria != null && !this.idSecretaria.equals(other.idSecretaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entities.Secretaria[ idSecretaria=" + idSecretaria + " ]";
    }
    
}
