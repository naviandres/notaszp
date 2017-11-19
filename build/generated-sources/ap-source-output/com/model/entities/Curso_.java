package com.model.entities;

import com.model.entities.Asignatura;
import com.model.entities.Docente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:58")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile ListAttribute<Curso, Asignatura> asignaturaList;
    public static volatile SingularAttribute<Curso, Integer> idCurso;
    public static volatile SingularAttribute<Curso, String> grupo;
    public static volatile SingularAttribute<Curso, String> nombre;
    public static volatile ListAttribute<Curso, Docente> docenteList;

}