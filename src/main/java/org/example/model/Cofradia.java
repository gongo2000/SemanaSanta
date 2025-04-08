package org.example.model;

import javax.xml.bind.annotation.*;

/**
 * Clase que representa una Cofradía.
 */
@XmlRootElement(name = "cofradia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cofradia {
    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "numeroHermanos")
    private int numeroHermanos;

    @XmlElement(name = "fundacion")
    private int fundacion;

    @XmlElement(name = "ciudad")
    private String ciudad;

    public Cofradia() {
    }

    public Cofradia(String nombre, int numeroHermanos, int fundacion, String ciudad) {
        this.nombre = nombre;
        this.numeroHermanos = numeroHermanos;
        this.fundacion = fundacion;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }


    public int getNumeroHermanos() {
        return numeroHermanos;
    }

    public int getFundacion() {
        return fundacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroHermanos(int numeroHermanos) {
        this.numeroHermanos = numeroHermanos;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }




    @Override
    public String toString() {
        return "Cofradia{" +
                "nombre='" + nombre + '\'' +
                ", numeroHermanos=" + numeroHermanos +
                ", fundacion=" + fundacion +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
