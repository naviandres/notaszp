/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IVAN ANDRES
 */
@Entity
@Table(name = "tbl_constanciasacademicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstanciaAcademica.findAll", query = "SELECT c FROM ConstanciaAcademica c")
    , @NamedQuery(name = "ConstanciaAcademica.findByIdConstanciaAcademica", query = "SELECT c FROM ConstanciaAcademica c WHERE c.idConstanciaAcademica = :idConstanciaAcademica")
    , @NamedQuery(name = "ConstanciaAcademica.findByCodigo", query = "SELECT c FROM ConstanciaAcademica c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "ConstanciaAcademica.findByNombre", query = "SELECT c FROM ConstanciaAcademica c WHERE c.nombre = :nombre")})
public class ConstanciaAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_constancia_academica")
    private Integer idConstanciaAcademica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "fk_id_secretaria", referencedColumnName = "id_secretaria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Secretaria fkIdSecretaria;

    public ConstanciaAcademica() {
    }

    public ConstanciaAcademica(Integer idConstanciaAcademica) {
        this.idConstanciaAcademica = idConstanciaAcademica;
    }

    public ConstanciaAcademica(Integer idConstanciaAcademica, int codigo, String nombre) {
        this.idConstanciaAcademica = idConstanciaAcademica;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdConstanciaAcademica() {
        return idConstanciaAcademica;
    }

    public void setIdConstanciaAcademica(Integer idConstanciaAcademica) {
        this.idConstanciaAcademica = idConstanciaAcademica;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Secretaria getFkIdSecretaria() {
        return fkIdSecretaria;
    }

    public void setFkIdSecretaria(Secretaria fkIdSecretaria) {
        this.fkIdSecretaria = fkIdSecretaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConstanciaAcademica != null ? idConstanciaAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstanciaAcademica)) {
            return false;
        }
        ConstanciaAcademica other = (ConstanciaAcademica) object;
        if ((this.idConstanciaAcademica == null && other.idConstanciaAcademica != null) || (this.idConstanciaAcademica != null && !this.idConstanciaAcademica.equals(other.idConstanciaAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entities.ConstanciaAcademica[ idConstanciaAcademica=" + idConstanciaAcademica + " ]";
    }
    
}
