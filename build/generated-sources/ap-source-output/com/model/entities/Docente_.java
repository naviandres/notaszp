package com.model.entities;

import com.model.entities.Curso;
import com.model.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:59")
@StaticMetamodel(Docente.class)
public class Docente_ { 

    public static volatile SingularAttribute<Docente, String> licenciatura;
    public static volatile SingularAttribute<Docente, Usuarios> fkIdUsuario;
    public static volatile SingularAttribute<Docente, Integer> idDocente;
    public static volatile ListAttribute<Docente, Curso> cursoList;

}