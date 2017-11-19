package com.model.entities;

import com.model.entities.Secretaria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:58")
@StaticMetamodel(ConstanciaAcademica.class)
public class ConstanciaAcademica_ { 

    public static volatile SingularAttribute<ConstanciaAcademica, Integer> codigo;
    public static volatile SingularAttribute<ConstanciaAcademica, Integer> idConstanciaAcademica;
    public static volatile SingularAttribute<ConstanciaAcademica, String> nombre;
    public static volatile SingularAttribute<ConstanciaAcademica, Secretaria> fkIdSecretaria;

}