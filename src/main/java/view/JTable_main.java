package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.EstudianteController;
import model.Estudiante;

import javax.swing.JPanel;

public class JTable_main {
	
	private JPanel panelComodin = new PanelComodin();
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable_main window = new JTable_main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JTable_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		frame.getContentPane().add(splitPane, gbc_splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable(getDatosDeTabla(), getTitulosColumnas());
		scrollPane.setViewportView(table);
		scrollPane.setMinimumSize(new Dimension(100,100));
		
		splitPane.setRightComponent(panelComodin);
		
		
		// Accedo a los clics realizados sobre la tabla
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				List<Estudiante> estudiantes = EstudianteController.findAllEstudiantes();
				int i = 0;
				for (Estudiante estudiante : estudiantes) {
					if (i == table.getSelectedRow()) {
						crearPanel(estudiante);
					}
					i++;
				}
			}
		});
		
	}
	
	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "Apellido1", "Apellido2", "Dni", "direccion", "email", "tlf"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> personas = EstudianteController.findAllEstudiantes();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][8];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Estudiante estudiante = personas.get(i);
			datos[i][0] = estudiante.getId();
			datos[i][1] = estudiante.getNombre();
			datos[i][2] = estudiante.getApellido1();
			datos[i][3] = estudiante.getApellido2();
			datos[i][4] = estudiante.getDni();
			datos[i][5] = estudiante.getDireccion();
			datos[i][6] = estudiante.getEmail();
			datos[i][7] = estudiante.getTelefono();
		}
		
		return datos;
	}
	
	private static void crearPanel(Estudiante e) {
		PanelComodin.setId(e.getId());
		PanelComodin.setNombre(e.getNombre());
		PanelComodin.setApellido1(e.getApellido1());
		PanelComodin.setApellido2(e.getApellido2());
		PanelComodin.setDNI(e.getDni());
		PanelComodin.setDireccion(e.getDireccion());
		PanelComodin.setEmail(e.getEmail());
		PanelComodin.setTelefono(e.getTelefono());
	}

}
