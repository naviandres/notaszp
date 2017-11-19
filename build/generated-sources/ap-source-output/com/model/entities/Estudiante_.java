package com.model.entities;

import com.model.entities.TblEstudiantesHasTblAsignaturas;
import com.model.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:58")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, Usuarios> fkIdUsuario;
    public static volatile SingularAttribute<Estudiante, String> observaciones;
    public static volatile SingularAttribute<Estudiante, Integer> idEstudiante;
    public static volatile ListAttribute<Estudiante, TblEstudiantesHasTblAsignaturas> tblEstudiantesHasTblAsignaturasList;

}