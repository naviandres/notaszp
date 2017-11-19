package com.model.entities;

import com.model.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:58")
@StaticMetamodel(Acudiente.class)
public class Acudiente_ { 

    public static volatile SingularAttribute<Acudiente, Integer> idAcudiente;
    public static volatile SingularAttribute<Acudiente, String> parentesco;
    public static volatile SingularAttribute<Acudiente, Usuarios> fkIdUsuario;

}