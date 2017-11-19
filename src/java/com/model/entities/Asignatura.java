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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByIdtblAsignaturas", query = "SELECT a FROM Asignatura a WHERE a.idtblAsignaturas = :idtblAsignaturas")
    , @NamedQuery(name = "Asignatura.findByCodigo", query = "SELECT a FROM Asignatura a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Asignatura.findByNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre = :nombre")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbl_asignaturas")
    private Integer idtblAsignaturas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "tbl_cursos_has_tbl_asignaturas", joinColumns = {
        @JoinColumn(name = "fk_id_asignatura", referencedColumnName = "idtbl_asignaturas")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_curso", referencedColumnName = "id_curso")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Curso> cursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdAsignatura", fetch = FetchType.LAZY)
    private List<TblEstudiantesHasTblAsignaturas> tblEstudiantesHasTblAsignaturasList;

    public Asignatura() {
    }

    public Asignatura(Integer idtblAsignaturas) {
        this.idtblAsignaturas = idtblAsignaturas;
    }
    
    public Asignatura(Integer idtblAsignaturas, int codigo, String nombre) {
        this.idtblAsignaturas = idtblAsignaturas;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdtblAsignaturas() {
        return idtblAsignaturas;
    }

    public void setIdtblAsignaturas(Integer idtblAsignaturas) {
        this.idtblAsignaturas = idtblAsignaturas;
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

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @XmlTransient
    public List<TblEstudiantesHasTblAsignaturas> getTblEstudiantesHasTblAsignaturasList() {
        return tblEstudiantesHasTblAsignaturasList;
    }

    public void setTblEstudiantesHasTblAsignaturasList(List<TblEstudiantesHasTblAsignaturas> tblEstudiantesHasTblAsignaturasList) {
        this.tblEstudiantesHasTblAsignaturasList = tblEstudiantesHasTblAsignaturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblAsignaturas != null ? idtblAsignaturas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idtblAsignaturas == null && other.idtblAsignaturas != null) || (this.idtblAsignaturas != null && !this.idtblAsignaturas.equals(other.idtblAsignaturas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entities.Asignatura[ idtblAsignaturas=" + idtblAsignaturas + " ]";
    }
    
}
