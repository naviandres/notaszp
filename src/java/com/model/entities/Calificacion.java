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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author IVAN ANDRES
 */
@Entity
@Table(name = "tbl_calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdCalificaion", query = "SELECT c FROM Calificacion c WHERE c.idCalificaion = :idCalificaion")
    , @NamedQuery(name = "Calificacion.findByNota", query = "SELECT c FROM Calificacion c WHERE c.nota = :nota")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificaion")
    private Integer idCalificaion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @JoinColumn(name = "fk_estudiante_asignatura", referencedColumnName = "id_estudiante_asignatura")
    @ManyToOne(fetch = FetchType.EAGER)
    private TblEstudiantesHasTblAsignaturas fkEstudianteAsignatura;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificaion) {
        this.idCalificaion = idCalificaion;
    }

    public Integer getIdCalificaion() {
        return idCalificaion;
    }

    public void setIdCalificaion(Integer idCalificaion) {
        this.idCalificaion = idCalificaion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public TblEstudiantesHasTblAsignaturas getFkEstudianteAsignatura() {
        return fkEstudianteAsignatura;
    }

    public void setFkEstudianteAsignatura(TblEstudiantesHasTblAsignaturas fkEstudianteAsignatura) {
        this.fkEstudianteAsignatura = fkEstudianteAsignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificaion != null ? idCalificaion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idCalificaion == null && other.idCalificaion != null) || (this.idCalificaion != null && !this.idCalificaion.equals(other.idCalificaion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entities.Calificacion[ idCalificaion=" + idCalificaion + " ]";
    }
    
}
