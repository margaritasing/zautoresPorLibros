package com.company.myapp;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autores")
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;
    private String nombre;
    @ManyToMany(mappedBy="autores",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Libro> librosEscritos;
    private String paginaWeb;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(String nombre, String paginaWeb, String nacionalidad) {
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.nacionalidad = nacionalidad;
        this.librosEscritos = new ArrayList<>();
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(List<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}