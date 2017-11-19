package com.model.entities;

import com.model.entities.Asignatura;
import com.model.entities.Calificacion;
import com.model.entities.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:59")
@StaticMetamodel(TblEstudiantesHasTblAsignaturas.class)
public class TblEstudiantesHasTblAsignaturas_ { 

    public static volatile SingularAttribute<TblEstudiantesHasTblAsignaturas, Asignatura> fkIdAsignatura;
    public static volatile SingularAttribute<TblEstudiantesHasTblAsignaturas, Estudiante> fkIdEstudiante;
    public static volatile SingularAttribute<TblEstudiantesHasTblAsignaturas, Integer> idEstudianteAsignatura;
    public static volatile ListAttribute<TblEstudiantesHasTblAsignaturas, Calificacion> calificacionList;

}