package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Profesor;

public class ProfesorController {
	
	  private static EntityManagerFactory entityManagerFactory = Persistence
	            .createEntityManagerFactory("CentroEducativoJPA");

	    public static List<Profesor> llenarProfesor() {
	        EntityManager em = entityManagerFactory.createEntityManager();

	        Query q = em.createNativeQuery("SELECT * FROM profesor;", Profesor.class);
	        List<Profesor> lista = (List<Profesor>) q.getResultList();

	        em.close();

	        return lista;

	    }
}
