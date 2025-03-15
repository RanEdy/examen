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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByNumprofesor", query = "SELECT p FROM Profesor p WHERE p.numprofesor = :numprofesor")
    , @NamedQuery(name = "Profesor.findByIdusuario", query = "SELECT p FROM Profesor p WHERE p.idusuario = :idusuario")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "numprofesor")
    private int numprofesor;
    @Id
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @JoinTable(name = "asignacion", joinColumns = {
        @JoinColumn(name = "idprofe", referencedColumnName = "idusuario")}, inverseJoinColumns = {
        @JoinColumn(name = "idunidad", referencedColumnName = "claveunidadaprendizaje")})
    @ManyToMany
    private List<Unidadaprendizaje> unidadaprendizajeList;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Profesor() {
    }

    public Profesor(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Profesor(Integer idusuario, int numprofesor) {
        this.idusuario = idusuario;
        this.numprofesor = numprofesor;
    }

    public int getNumprofesor() {
        return numprofesor;
    }

    public void setNumprofesor(int numprofesor) {
        this.numprofesor = numprofesor;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Unidadaprendizaje> getUnidadaprendizajeList() {
        return unidadaprendizajeList;
    }

    public void setUnidadaprendizajeList(List<Unidadaprendizaje> unidadaprendizajeList) {
        this.unidadaprendizajeList = unidadaprendizajeList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hexcrew.entidad.Profesor[ idusuario=" + idusuario + " ]";
    }
    
}
