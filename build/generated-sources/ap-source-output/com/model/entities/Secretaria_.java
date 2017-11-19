package com.model.entities;

import com.model.entities.ConstanciaAcademica;
import com.model.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:58")
@StaticMetamodel(Secretaria.class)
public class Secretaria_ { 

    public static volatile SingularAttribute<Secretaria, Integer> idSecretaria;
    public static volatile ListAttribute<Secretaria, ConstanciaAcademica> constanciaAcademicaList;
    public static volatile SingularAttribute<Secretaria, Usuarios> fkIdUsuario;
    public static volatile SingularAttribute<Secretaria, String> contrasena;

}