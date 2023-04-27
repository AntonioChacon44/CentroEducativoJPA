package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

public class ValoracionController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("CentroEducativoJPA");

	/** 
	 * 
	 */
	public static Valoracionmateria findBySomeId(Materia idMateria, Profesor idProfesor, Estudiante idEstudiante) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Valoracionmateria o = null;

		try {
			Query q = em.createNativeQuery(
					"SELECT * FROM valoracionmateria where idMateria = ? and idProfesor = ? and idEstudiante = ?;",
					Valoracionmateria.class);
			q.setParameter(1, idMateria);
			q.setParameter(2, idProfesor);
			q.setParameter(3, idEstudiante);

			o = (Valoracionmateria) q.getSingleResult();
		} catch (Exception e) {
		}

		em.close();

		return o;
	}

	/**
	 * 
	 * @param o
	 */
	public static void update(Valoracionmateria o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param o
	 */
	public static void insert(Valoracionmateria o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

}