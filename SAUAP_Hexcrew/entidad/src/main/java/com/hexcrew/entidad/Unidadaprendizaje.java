/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hexcrew.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "unidadaprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadaprendizaje.findAll", query = "SELECT u FROM Unidadaprendizaje u")
    , @NamedQuery(name = "Unidadaprendizaje.findByClaveunidadaprendizaje", query = "SELECT u FROM Unidadaprendizaje u WHERE u.claveunidadaprendizaje = :claveunidadaprendizaje")
    , @NamedQuery(name = "Unidadaprendizaje.findByNombreunidad", query = "SELECT u FROM Unidadaprendizaje u WHERE u.nombreunidad = :nombreunidad")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasclase", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasclase = :horasclase")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorastaller", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horastaller = :horastaller")
    , @NamedQuery(name = "Unidadaprendizaje.findByHoraslab", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horaslab = :horaslab")})
public class Unidadaprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "claveunidadaprendizaje")
    private Integer claveunidadaprendizaje;
    @Column(name = "nombreunidad")
    private String nombreunidad;
    @Column(name = "horasclase")
    private Integer horasclase;
    @Column(name = "horastaller")
    private Integer horastaller;
    @Column(name = "horaslab")
    private Integer horaslab;
    @ManyToMany(mappedBy = "unidadaprendizajeList")
    private List<Profesor> profesorList;

    public Unidadaprendizaje() {
    }

    public Unidadaprendizaje(Integer claveunidadaprendizaje) {
        this.claveunidadaprendizaje = claveunidadaprendizaje;
    }

    public Integer getClaveunidadaprendizaje() {
        return claveunidadaprendizaje;
    }

    public void setClaveunidadaprendizaje(Integer claveunidadaprendizaje) {
        this.claveunidadaprendizaje = claveunidadaprendizaje;
    }

    public String getNombreunidad() {
        return nombreunidad;
    }

    public void setNombreunidad(String nombreunidad) {
        this.nombreunidad = nombreunidad;
    }

    public Integer getHorasclase() {
        return horasclase;
    }

    public void setHorasclase(Integer horasclase) {
        this.horasclase = horasclase;
    }

    public Integer getHorastaller() {
        return horastaller;
    }

    public void setHorastaller(Integer horastaller) {
        this.horastaller = horastaller;
    }

    public Integer getHoraslab() {
        return horaslab;
    }

    public void setHoraslab(Integer horaslab) {
        this.horaslab = horaslab;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveunidadaprendizaje != null ? claveunidadaprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadaprendizaje)) {
            return false;
        }
        Unidadaprendizaje other = (Unidadaprendizaje) object;
        if ((this.claveunidadaprendizaje == null && other.claveunidadaprendizaje != null) || (this.claveunidadaprendizaje != null && !this.claveunidadaprendizaje.equals(other.claveunidadaprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hexcrew.entidad.Unidadaprendizaje[ claveunidadaprendizaje=" + claveunidadaprendizaje + " ]";
    }
    
}
