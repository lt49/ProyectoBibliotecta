/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author isai
 */
@Entity
public class Persona {

    public Persona() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idpersona;
    @Column(length = 50)
    private String nombres;
    @Column(length = 50)
    private String apellidos;
    private int idtipo_doc;
    @Column(length = 15)
    private String nro_doc;
    @Column(length = 50)
    private String fecha_nac;
    @Column(length = 50)
    private String direccion;
    @Column(length = 50)
    private String genero;
    @Column(length = 50)
    private String nivel;
    @Column(length = 50)
    private String grado;
    @Column(length = 50)
    private String seccion;
    @Column(length = 50)
    private String turno;
    @Column(length = 45)
    private String condicion;


    public Persona(int idpersona, String nombres, String apellidos, int idtipo_doc, String nro_doc, String fecha_nac, String direccion, String genero, String nivel, String grado, String seccion, String turno, String condicion) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idtipo_doc = idtipo_doc;
        this.nro_doc = nro_doc;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.genero = genero;
        this.nivel = nivel;
        this.grado = grado;
        this.seccion = seccion;
        this.turno = turno;
        this.condicion = condicion;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdtipo_doc() {
        return idtipo_doc;
    }

    public void setIdtipo_doc(int idtipo_doc) {
        this.idtipo_doc = idtipo_doc;
    }

    public String getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(String nro_doc) {
        this.nro_doc = nro_doc;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
   

}
