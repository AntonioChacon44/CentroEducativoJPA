package view;

import java.awt.Panel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;

import model.Estudiante;
import model.Materia;
import model.Profesor;

import java.awt.Insets;
import javax.swing.JSpinner;

public class Panel_complementario extends Panel {
	
	private Profesor idProfesor;
	private Materia idMateria;
	private Estudiante idEstudiante;
	
	
	public Panel_complementario(Profesor idProfesor, Materia idMateria, Estudiante idEstudiante) {
		
		super();
		this.idProfesor = idProfesor;
		this.idMateria = idMateria;
		this.idEstudiante = idEstudiante;
		
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
		
		JSpinner spinner = new JSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 0;
		add(spinner, gbc_spinner);
	}
	
	private void cargaNota() {
		
	}
	
	public void guardaNota() {
		
	}

}
