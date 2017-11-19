package com.model.entities;

import com.model.entities.TblEstudiantesHasTblAsignaturas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:59")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, TblEstudiantesHasTblAsignaturas> fkEstudianteAsignatura;
    public static volatile SingularAttribute<Calificacion, Integer> idCalificaion;
    public static volatile SingularAttribute<Calificacion, Double> nota;

}