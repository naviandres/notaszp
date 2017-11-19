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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author IVAN ANDRES
 */
@Entity
@Table(name = "tbl_estudiantes_has_tbl_asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstudiantesHasTblAsignaturas.findAll", query = "SELECT t FROM TblEstudiantesHasTblAsignaturas t")
    , @NamedQuery(name = "TblEstudiantesHasTblAsignaturas.findByIdEstudianteAsignatura", query = "SELECT t FROM TblEstudiantesHasTblAsignaturas t WHERE t.idEstudianteAsignatura = :idEstudianteAsignatura")})
public class TblEstudiantesHasTblAsignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante_asignatura")
    private Integer idEstudianteAsignatura;
    @OneToMany(mappedBy = "fkEstudianteAsignatura", fetch = FetchType.LAZY)
    private List<Calificacion> calificacionList;
    @JoinColumn(name = "fk_id_asignatura", referencedColumnName = "idtbl_asignaturas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asignatura fkIdAsignatura;
    @JoinColumn(name = "fk_id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estudiante fkIdEstudiante;

    public TblEstudiantesHasTblAsignaturas() {
    }

    public TblEstudiantesHasTblAsignaturas(Integer idEstudianteAsignatura) {
        this.idEstudianteAsignatura = idEstudianteAsignatura;
    }

    public Integer getIdEstudianteAsignatura() {
        return idEstudianteAsignatura;
    }

    public void setIdEstudianteAsignatura(Integer idEstudianteAsignatura) {
        this.idEstudianteAsignatura = idEstudianteAsignatura;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    public Asignatura getFkIdAsignatura() {
        return fkIdAsignatura;
    }

    public void setFkIdAsignatura(Asignatura fkIdAsignatura) {
        this.fkIdAsignatura = fkIdAsignatura;
    }

    public Estudiante getFkIdEstudiante() {
        return fkIdEstudiante;
    }

    public void setFkIdEstudiante(Estudiante fkIdEstudiante) {
        this.fkIdEstudiante = fkIdEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudianteAsignatura != null ? idEstudianteAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEstudiantesHasTblAsignaturas)) {
            return false;
        }
        TblEstudiantesHasTblAsignaturas other = (TblEstudiantesHasTblAsignaturas) object;
        if ((this.idEstudianteAsignatura == null && other.idEstudianteAsignatura != null) || (this.idEstudianteAsignatura != null && !this.idEstudianteAsignatura.equals(other.idEstudianteAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entities.TblEstudiantesHasTblAsignaturas[ idEstudianteAsignatura=" + idEstudianteAsignatura + " ]";
    }
    
}
