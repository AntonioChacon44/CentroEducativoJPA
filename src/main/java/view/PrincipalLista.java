package view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import controller.MateriaController;
import controller.ProfesorController;
import controller.ValoracionController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class PrincipalLista extends JFrame {
	
	private JPanel contentPane;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Float> jcbNota;
	private JList jlistEstudiantesIzq;
	private JList jlistEstudiantesDer;
	private DefaultListModel<Estudiante> listModelEstudiantesIzq = null;
	private DefaultListModel<Estudiante> listModelEstudiantesDer = null;
	private List<Estudiante> estudiantes = EstudianteController.getControlador().findAllEstudiantes();
	private List<Estudiante> listaProvisional = new ArrayList<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalLista frame = new PrincipalLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 */
	public PrincipalLista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(185, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weightx = 1.0;
		gbc_panel_1.insets = new Insets(0, 0, 10, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Materia: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel_1.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		jcbProfesor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel_1.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox<Float>();
		jcbNota.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel_1.add(jcbNota, gbc_jcbNota);
		
		JButton btnAlumnos = new JButton("Botón actualizar de alumnos");
		btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoIzq();
			}
		});
		btnAlumnos.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnAlumnos = new GridBagConstraints();
		gbc_btnAlumnos.anchor = GridBagConstraints.EAST;
		gbc_btnAlumnos.gridx = 1;
		gbc_btnAlumnos.gridy = 3;
		panel_1.add(btnAlumnos, gbc_btnAlumnos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 206));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.weighty = 1.0;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alumno no seleccionado:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weightx = 1.0;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Alumno seleccionado:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3_1.weightx = 1.0;
		gbc_lblNewLabel_3_1.gridx = 2;
		gbc_lblNewLabel_3_1.gridy = 0;
		panel_2.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		jlistEstudiantesIzq = new JList(this.getDefaultListModelIzq());

		this.jlistEstudiantesIzq.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		JScrollPane scrollPaneIzq = new JScrollPane(jlistEstudiantesIzq);
		GridBagConstraints gbc_scrollPaneIzq = new GridBagConstraints();
		gbc_scrollPaneIzq.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneIzq.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneIzq.gridx = 0;
		gbc_scrollPaneIzq.gridy = 1;
		panel_2.add(scrollPaneIzq, gbc_scrollPaneIzq);
		
		JPanel panel_medio = new JPanel();
		panel_medio.setBackground(new Color(255, 176, 138));
		GridBagConstraints gbc_panel_medio = new GridBagConstraints();
		gbc_panel_medio.weightx = 1.0;
		gbc_panel_medio.insets = new Insets(0, 0, 0, 5);
		gbc_panel_medio.fill = GridBagConstraints.BOTH;
		gbc_panel_medio.gridx = 1;
		gbc_panel_medio.gridy = 1;
		panel_2.add(panel_medio, gbc_panel_medio);
		GridBagLayout gbl_panel_medio = new GridBagLayout();
//		gbl_panel_3.columnWidths = new int[]{0};
//		gbl_panel_3.rowHeights = new int[]{0};
//		gbl_panel_3.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel_3.rowWeights = new double[]{Double.MIN_VALUE};
		panel_medio.setLayout(gbl_panel_medio);
		
		JButton btnIzqTodos = new JButton("<<");
		btnIzqTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoIzq();
			}
		});
		GridBagConstraints gbc_btnIzqTodos = new GridBagConstraints();
		gbc_btnIzqTodos.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzqTodos.gridx = 0;
		gbc_btnIzqTodos.gridy = 0;
		panel_medio.add(btnIzqTodos, gbc_btnIzqTodos);
		
		JButton btnIzq = new JButton("<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarIzq();
			}
		});
		GridBagConstraints gbc_btnIzq = new GridBagConstraints();
		gbc_btnIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzq.gridx = 0;
		gbc_btnIzq.gridy = 1;
		panel_medio.add(btnIzq, gbc_btnIzq);
		
		JButton btnDer = new JButton(">");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarDer();
			}
		});
		GridBagConstraints gbc_btnDer = new GridBagConstraints();
		gbc_btnDer.insets = new Insets(0, 0, 5, 0);
		gbc_btnDer.gridx = 0;
		gbc_btnDer.gridy = 2;
		panel_medio.add(btnDer, gbc_btnDer);
		
		JButton btnDerTodos = new JButton(">>");
		btnDerTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoDer();
			}
		});
		GridBagConstraints gbc_btnDerTodos = new GridBagConstraints();
		gbc_btnDerTodos.gridx = 0;
		gbc_btnDerTodos.gridy = 3;
		panel_medio.add(btnDerTodos, gbc_btnDerTodos);
		
		jlistEstudiantesDer = new JList(this.getDefaultListModelDer());

		this.jlistEstudiantesDer.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		JScrollPane scrollPaneDer = new JScrollPane(jlistEstudiantesDer);
		GridBagConstraints gbc_scrollPaneDer = new GridBagConstraints();
		gbc_scrollPaneDer.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDer.gridx = 2;
		gbc_scrollPaneDer.gridy = 1;
		panel_2.add(scrollPaneDer, gbc_scrollPaneDer);
		
		JButton btnGuardar = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 2;
		panel.add(btnGuardar, gbc_btnGuardar);
		
		llenarMateria();
		llenarProfesor();
		llenarNota();
		
	}
	
	/**
	 * 
	 */
	private void llenarMateria() {
		try {
			jcbMateria.removeAllItems();
		} catch (Exception e) {
		}
		for (Materia m : MateriaController.cargarMateria()) {
			jcbMateria.addItem(m);
		}
	}
	
	/**
	 * 
	 */
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
	private void llenarNota() {
		for (float i = 0; i < 11; i++) {
			jcbNota.addItem(i);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModelIzq () {
		this.listModelEstudiantesIzq = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesIzq;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModelDer () {
		this.listModelEstudiantesDer = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesDer;
	}
	
	/**
	 * 
	 */
	private void pasarTodoIzq () {
		listModelEstudiantesDer.removeAllElements();
		listModelEstudiantesIzq.removeAllElements();
		listModelEstudiantesIzq.addAll(estudiantes);
	}
	
	/**
	 * 
	 */
	private void pasarTodoDer () {
		listModelEstudiantesIzq.removeAllElements();
		listModelEstudiantesDer.removeAllElements();
		listModelEstudiantesDer.addAll(estudiantes);
	}
	
	/**
	 * 
	 */
	private void pasarIzq () {
		listModelEstudiantesIzq.addAll(jlistEstudiantesDer.getSelectedValuesList());
		for (int i = this.jlistEstudiantesDer.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelEstudiantesDer.removeElementAt(this.jlistEstudiantesDer.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * 
	 */
	private void pasarDer () {
		listModelEstudiantesDer.addAll(jlistEstudiantesIzq.getSelectedValuesList());
		for (int i = this.jlistEstudiantesIzq.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelEstudiantesIzq.removeElementAt(this.jlistEstudiantesIzq.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * 
	 */
	private void guardar () {
		listaProvisional.removeAll(listaProvisional);
		for (int i = 0; i < listModelEstudiantesDer.size(); i++) {
			listaProvisional.add(listModelEstudiantesDer.getElementAt(i));
		}
		for (Estudiante e : listaProvisional) {
			Valoracionmateria v = ValoracionController.findBySomeId((Materia) jcbMateria.getSelectedItem(),
					(Profesor) jcbProfesor.getSelectedItem(), e);
			if (v != null) {
				v.setValoracion((float) jcbNota.getSelectedItem());
			
				ValoracionController.update(v);
			} else {
				v = new Valoracionmateria();
				v.setMateria((Materia) jcbMateria.getSelectedItem());
				v.setProfesor((Profesor) jcbProfesor.getSelectedItem());
				v.setEstudiante(e);
				v.setValoracion((float) jcbNota.getSelectedItem());
				ValoracionController.insert(v);
			}
		}
	}
	
}
