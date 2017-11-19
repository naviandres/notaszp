/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByIdDocente", query = "SELECT d FROM Docente d WHERE d.idDocente = :idDocente")
    , @NamedQuery(name = "Docente.findByLicenciatura", query = "SELECT d FROM Docente d WHERE d.licenciatura = :licenciatura")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_docente")
    private Integer idDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "licenciatura")
    private String licenciatura;
    @JoinTable(name = "tbl_docente_has_tbl_cursos", joinColumns = {
        @JoinColumn(name = "fk_id_docente", referencedColumnName = "id_docente")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_curso", referencedColumnName = "id_curso")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Curso> cursoList;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios fkIdUsuario;

    public Docente() {
    }

    public Docente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Docente(Integer idDocente, String licenciatura) {
        this.idDocente = idDocente;
        this.licenciatura = licenciatura;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public Usuarios getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuarios fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocente != null ? idDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.idDocente == null && other.idDocente != null) || (this.idDocente != null && !this.idDocente.equals(other.idDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entities.Docente[ idDocente=" + idDocente + " ]";
    }
    
}
