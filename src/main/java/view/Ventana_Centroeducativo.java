package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import controller.MateriaController;
import controller.ProfesorController;
import controller.ValoracionController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ventana_Centroeducativo extends JFrame {

	JPanel panelEstudiantes;
	private JPanel contentPane;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private List<Panel_complementario> panelesAlumnos;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Centroeducativo frame = new Ventana_Centroeducativo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_Centroeducativo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{88, 0, 0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.weightx = 1.0;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		contentPane.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		contentPane.add(jcbProfesor, gbc_jcbProfesor);
		
		JButton btnNewButton = new JButton("Boton refrescar alumnado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 30, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		panelEstudiantes = new JPanel();
		GridBagConstraints gbc_panelEstudiantes = new GridBagConstraints();
		gbc_panelEstudiantes.gridwidth = 3;
		gbc_panelEstudiantes.insets = new Insets(0, 0, 5, 5);
		gbc_panelEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_panelEstudiantes.gridx = 0;
		gbc_panelEstudiantes.gridy = 2;
		contentPane.add(panelEstudiantes, gbc_panelEstudiantes);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarNotas();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		llenarMateria();
		llenarProfesor();
	}
	
	private void llenarMateria() {
		try {
			jcbMateria.removeAllItems();
		} catch (Exception e) {
		}
		for (Materia m : MateriaController.cargarMateria()) {
			jcbMateria.addItem(m);
		}
	}

	private void llenarProfesor() {
		try {
			jcbProfesor.removeAllItems();
		} catch (Exception e) {
		}
		for (Profesor p : ProfesorController.llenarProfesor()) {
			jcbProfesor.addItem(p);
		}
	}
	
	/**
	 * 
	 */
	private void cargarEstudiantes() {
		this.panelEstudiantes.removeAll();
		panelesAlumnos = new ArrayList<Panel_complementario>();

		List<Estudiante> l = EstudianteController.cargarEstudiante();
		for (Estudiante estudiante : l) {
//			panelesAlumnos.toString();
			Panel_complementario nuevoPanel = new Panel_complementario(estudiante, (Materia) jcbMateria.getSelectedItem(),
					(Profesor) jcbProfesor.getSelectedItem());
			panelEstudiantes.add(nuevoPanel);
			panelesAlumnos.add(nuevoPanel);
		}

		this.repaint();
		this.revalidate();
	}
	
	/**
	 * 
	 */
	private void guardarNotas() {
		for (Panel_complementario estudiantePanel : panelesAlumnos) {
			Valoracionmateria v = estudiantePanel.guardar();
			if (v != null) {
				System.out.println(v.toString());
				ValoracionController.update(v);
			}
			else {
				v = new Valoracionmateria();
				v.setProfesor((Profesor) jcbProfesor.getSelectedItem());
				v.setEstudiante(estudiantePanel.devolverEstudiante());
				v.setMateria((Materia) jcbMateria.getSelectedItem());
				v.setValoracion(estudiantePanel.devolverValoracion());
				ValoracionController.insert(v);
			}
		}
	}
}
