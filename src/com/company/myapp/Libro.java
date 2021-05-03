package com.company.myapp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    private String nombreLibro;
    private String categoria;
    private int isbn;
    private int anioPublicacion;
    @JoinTable(name = "autores_x_libro",
            joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name="idAutor"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Autor> autores = new ArrayList<>();
    private String editorial;

    public Libro() {
    }

    public Libro(String nombreLibro, String categoria, int isbn, int anioPublicacion, String editorial) {
        this.nombreLibro = nombreLibro;
        this.categoria = categoria;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.autores = new ArrayList<>();
    }

    public void agregarAutor(Autor autor){
        if(autores == null) autores = new ArrayList<>();
        autores.add(autor);
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }


    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", nombreLibro='" + nombreLibro + '\'' +
                ", categoria='" + categoria + '\'' +
                ", isbn=" + isbn +
                ", anioPublicacion=" + anioPublicacion +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}