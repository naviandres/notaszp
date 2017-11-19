package com.model.entities;

import com.model.entities.Curso;
import com.model.entities.TblEstudiantesHasTblAsignaturas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:59")
@StaticMetamodel(Asignatura.class)
public class Asignatura_ { 

    public static volatile SingularAttribute<Asignatura, Integer> codigo;
    public static volatile SingularAttribute<Asignatura, Integer> idtblAsignaturas;
    public static volatile SingularAttribute<Asignatura, String> nombre;
    public static volatile ListAttribute<Asignatura, Curso> cursoList;
    public static volatile ListAttribute<Asignatura, TblEstudiantesHasTblAsignaturas> tblEstudiantesHasTblAsignaturasList;

}