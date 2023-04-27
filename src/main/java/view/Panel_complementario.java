package view;

import java.awt.Panel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.ValoracionController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.Insets;
import javax.swing.JSpinner;

public class Panel_complementario extends Panel {
	
	private Profesor p;
	private Materia m;
	private Estudiante e;
	private JSpinner spinner;
	
	@Override
	public String toString() {
		return m.getNombre() + " " + e.getNombre() + " " + p.getNombre() + " " + spinner.getValue();
	}
	
	
	public Panel_complementario(Estudiante idEstudiante, Materia idMateria, Profesor idProfesor) {
		
		super();
		this.p = idProfesor;
		this.m = idMateria;
		this.e = idEstudiante;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel(idEstudiante.getNombre() + " " + idEstudiante.getApellido1() + " " + idEstudiante.getApellido2());
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(valoracionEstudiante(), null, 10, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 0;
		add(spinner, gbc_spinner);
	}
	
	/**
	 * 
	 * @return
	 */
	private int valoracionEstudiante() {
		Valoracionmateria valoracion = ValoracionController.findBySomeId(m.getId(), p.getId(), e.getId());
		if (valoracion != null) {
			return (int) valoracion.getValoracion();
		} else {
			return 0;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Estudiante devolverEstudiante() {
		return e;
	}
	
	/**
	 * 
	 * @return
	 */
	public int devolverValoracion() {
		return (int) spinner.getValue();
	}
	
	/**
	 * 
	 * @return
	 */
	public Valoracionmateria guardar() {
		Valoracionmateria o1 = ValoracionController.findBySomeId(m.getId(), p.getId(), e.getId());
		Valoracionmateria o = new Valoracionmateria();
		
		if(o1 != null) {
			o.setId(o1.getId()); 
			o.setProfesor(p);
			o.setEstudiante(e);
			o.setMateria(m);
			o.setValoracion((int) spinner.getValue());
	
			return o;
		}
		else {
			return null;
		}
	}

}
