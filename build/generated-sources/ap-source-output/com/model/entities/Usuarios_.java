package com.model.entities;

import com.model.entities.Acudiente;
import com.model.entities.Docente;
import com.model.entities.Estudiante;
import com.model.entities.Secretaria;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-19T14:14:58")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> segundoNombre;
    public static volatile SingularAttribute<Usuarios, String> primerNombre;
    public static volatile SingularAttribute<Usuarios, String> primerApellido;
    public static volatile SingularAttribute<Usuarios, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuario;
    public static volatile SingularAttribute<Usuarios, String> direccion;
    public static volatile SingularAttribute<Usuarios, String> segundoApellido;
    public static volatile SingularAttribute<Usuarios, String> identificacion;
    public static volatile ListAttribute<Usuarios, Secretaria> secretariaList;
    public static volatile ListAttribute<Usuarios, Estudiante> estudianteList;
    public static volatile ListAttribute<Usuarios, Acudiente> acudienteList;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile ListAttribute<Usuarios, Docente> docenteList;
    public static volatile SingularAttribute<Usuarios, String> contraseña;

}