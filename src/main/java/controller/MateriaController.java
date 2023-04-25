package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;
import model.Profesor;


public class MateriaController {
	
	/**
	 * 
	 */
	private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("CentroEducativoJPA");
	
	/**
	 * 
	 */
	public static List<Materia> cargarMateria () {
		EntityManager em = entityManagerFactory.createEntityManager();

        Query q = em.createNativeQuery("SELECT * FROM materia;", Materia.class);
        List<Materia> lista = (List<Materia>) q.getResultList();

        em.close();

        return lista;
	}
	
}
