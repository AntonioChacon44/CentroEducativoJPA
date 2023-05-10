package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.Estudiante;
import model.Valoracionmateria;

public class EstudianteController {
	
	private static EstudianteController controller = null;
	
	/**
	 * 
	 */
	private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("CentroEducativoJPA");
	
	/**
	 * 
	 * @return
	 */
	public static EstudianteController getControlador () {
		if (controller == null) {
			controller = new EstudianteController();
		}
		return controller;
	}

	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAllEstudiantes () {
		List<Estudiante> entities = new ArrayList<Estudiante>();
		EntityManager em = getEntityManagerFactory().createEntityManager();
		try {			
			Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
			entities = (List<Estudiante>) q.getResultList();
		}
		catch (NoResultException nrEx) {
		}
		em.close();
		return entities;
	}
	
	
	/**
	 * 
	 */
	public List<Estudiante> cargarEstudiante () {
		EntityManager em = entityManagerFactory.createEntityManager();

        Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);
        List<Estudiante> lista = (List<Estudiante>) q.getResultList();

        em.close();

        return lista;
	}
	
	/**
	 * 
	 * @param o
	 */
	public static void update(Estudiante o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
}
