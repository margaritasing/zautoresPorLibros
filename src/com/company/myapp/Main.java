package com.company.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        System.out.println("LISTO LOS LIBROS: ");
        List<Libro> libros = (List<Libro>) session.createQuery("FROM Libro").list();
        for(Libro libro : libros)
            System.out.println(libro);

        System.out.println("AHORA LOS AUTORES:");
        List<Autor> autores = (List<Autor>) session.createQuery("FROM Autor").list();
        for(Autor autor: autores)
            System.out.println(autor);

        Libro unLibro = new Libro("Matematica 1", "ciencias", 123414, 2020, "MiEditorial");
        unLibro.agregarAutor(new Autor("juliana", "juliana.com", "argentina"));

        session.beginTransaction();
        session.save(unLibro);
        System.out.println("El Id:"+unLibro.getIdLibro());// es 0 acá
        session.getTransaction().commit();
        session.close();






    }
}