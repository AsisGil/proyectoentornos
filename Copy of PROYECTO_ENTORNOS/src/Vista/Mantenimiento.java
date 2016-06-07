package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class Mantenimiento extends JFrame {

	private Controlador controlador;
	private Conexion conexion;
	private JPanel contentPane;
	private Principal principal;
	private Registro registro;
 
	private JTabbedPane tabbedPane;
	private JPanel panel_materiales;
	private JTable table_material;
	private JButton btnSalir;
	private JTextField textFieldModificaMaterial;

	private JTextField textFieldModificaFamilia;
	private JLabel lblNombreAModificar;
	private JLabel lblFamiliaAModificar;
	private DefaultTableModel dtm;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JButton button;
	private JPanel panel;
	private JTextField textField_2;
	private JLabel label_2;
	private JTextField textField_3;
	private JLabel lblApellidoAModificar;
	private JButton button_1;
	private JButton button_2;
	private JLabel lblDireccionAModificar;
	private JTextField textField_6;
	private JButton button_4;
	private JScrollPane scrollPane;
	private JTable tablealumnos;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel lblCorreoAModificar;
	private JLabel lblContraseaaModificar;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_12;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JButton button_3;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JButton button_7;
	private JTable tablemodulos2;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JTextField textnota;
	private JButton button_5;
	private JPanel panel_2;
	private JScrollPane scrollPane_3;
	private JButton button_9;
	private JButton button_10;
	private JScrollPane scrollPane_2;
	private JTable tablealumnos2;
	private JLabel label_11;
	private JTextField textnom;
	private JLabel label_13;
	private JTextField texthoras;
	private JLabel label_14;
	private JButton button_11;
	private JScrollPane scrollPane_4;
	private JTable tableprofesores2;
	private JTable tablemodulos;
	private JScrollPane scrollPane_5;
	private JTable tablenotaas;
	private JLabel lblTablaNotas;

	public void rellenarTablaprofesores() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) table_material.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

	public void rellenarTablaprofesores2() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) tableprofesores2.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

	public void rellenarTablalumnos() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) tablealumnos.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}

	}

	public void rellenarTablalumnos2() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) tablealumnos2.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}

	}

	public void rellenarTablamodulos() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) tablemodulos.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

	public void rellenarTablamodulos2() {
		String[][] tabla = conexion.getMateriales();
		DefaultTableModel modelo = (DefaultTableModel) tablemodulos2.getModel();
		for (int i = 0; i < tabla.length; i++) {
			modelo.addRow(tabla[i]);
		}
	}

	public void settodo(Principal principal, Conexion conexion, Controlador controlador) {
		this.principal = principal;
		this.conexion = conexion;
		this.controlador = controlador;
	}

	public Mantenimiento() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				controlador.cargarMateriales();
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(173, 216, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1067, GroupLayout.PREFERRED_SIZE).addGap(3854)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));

		panel_materiales = new JPanel();
		panel_materiales.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("Profesores", null, panel_materiales, null);

		JScrollPane scrollPane_material1 = new JScrollPane();

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				principal.setVisible(true);
			}
		});

		textFieldModificaMaterial = new JTextField();
		textFieldModificaMaterial.setColumns(10);

		textFieldModificaFamilia = new JTextField();
		textFieldModificaFamilia.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_material.setValueAt(textFieldModificaMaterial.getText(), table_material.getSelectedRow(), 0);
				table_material.setValueAt(textFieldModificaFamilia.getText(), table_material.getSelectedRow(), 1);

			}
		});

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) table_material.getModel();
				int a = table_material.getSelectedRow();
				dtm.removeRow(a);
				//
				textFieldModificaMaterial.setText("");
				textFieldModificaFamilia.setText("");

			}
		});

		lblNombreAModificar = new JLabel("Nombre a modificar");

		lblFamiliaAModificar = new JLabel("Familia a modificar");

		label = new JLabel("NOMBRE:");
		label.setFont(new Font("Stencil", Font.ITALIC, 14));

		textField = new JTextField();
		textField.setColumns(10);

		label_1 = new JLabel("APELLIDO:");
		label_1.setFont(new Font("Stencil", Font.ITALIC, 14));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		button = new JButton("A\u00D1ADIR PROFESOR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String apellido = textField_1.getText();
				DefaultTableModel modelo = (DefaultTableModel) table_material.getModel();
				String[] fila = new String[2];
				fila[0] = nombre;
				fila[1] = apellido;

				modelo.addRow(fila);
				table_material.setModel(modelo);
				textField.setText("");
				textField_1.setText("");
			}
		});
		button.setBackground(new Color(255, 140, 0));

		GroupLayout gl_panel_materiales = new GroupLayout(panel_materiales);
		gl_panel_materiales.setHorizontalGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_materiales.createSequentialGroup().addContainerGap().addGroup(gl_panel_materiales
						.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_material1, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_materiales.createSequentialGroup()
										.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldModificaMaterial, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombreAModificar))
										.addGap(104)
										.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldModificaFamilia, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFamiliaAModificar, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_materiales.createSequentialGroup()
										.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54)
										.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_materiales.createSequentialGroup()
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 78,
																GroupLayout.PREFERRED_SIZE)
														.addGap(35).addComponent(textField, GroupLayout.PREFERRED_SIZE,
																86, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_materiales.createSequentialGroup()
														.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 86,
																GroupLayout.PREFERRED_SIZE)
														.addGap(27).addComponent(textField_1,
																GroupLayout.PREFERRED_SIZE, 86,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_materiales.createSequentialGroup().addGap(30)
														.addComponent(button, GroupLayout.PREFERRED_SIZE, 153,
																GroupLayout.PREFERRED_SIZE)))))
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(457, Short.MAX_VALUE)));
		gl_panel_materiales
				.setVerticalGroup(gl_panel_materiales.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_materiales.createSequentialGroup().addContainerGap(70, Short.MAX_VALUE)
								.addComponent(scrollPane_material1, GroupLayout.PREFERRED_SIZE, 115,
										GroupLayout.PREFERRED_SIZE)
						.addGap(15)
						.addGroup(gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldModificaMaterial, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldModificaFamilia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNombreAModificar).addComponent(lblFamiliaAModificar))
								.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_materiales.createSequentialGroup().addGap(54)
												.addGroup(gl_panel_materiales.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnBorrar).addComponent(btnModificar))
												.addGap(97).addComponent(btnSalir))
								.addGroup(gl_panel_materiales.createSequentialGroup().addGap(24)
										.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_materiales.createSequentialGroup().addGap(3)
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 15,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(textField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(31)
										.addGroup(gl_panel_materiales.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_materiales.createSequentialGroup().addGap(3)
														.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(46).addComponent(button)))
								.addContainerGap()));

		table_material = new JTable();
		table_material.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int filaSelect = table_material.getSelectedRow();
				textFieldModificaMaterial.setText(table_material.getValueAt(filaSelect, 0).toString());
				textFieldModificaFamilia.setText(table_material.getValueAt(filaSelect, 1).toString());

			}
		});

		table_material.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Apellido" }));
		scrollPane_material1.setViewportView(table_material);
		panel_materiales.setLayout(gl_panel_materiales);

		panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("Alumnos", null, panel, null);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		label_2 = new JLabel("Nombre a modificar");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		lblApellidoAModificar = new JLabel("Apellido a modificar");

		button_1 = new JButton("Borrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = (DefaultTableModel) tablealumnos.getModel();
				int a = tablealumnos.getSelectedRow();
				dtm.removeRow(a);
				//
				textFieldModificaMaterial.setText("");
				textFieldModificaFamilia.setText("");

			}
		});

		button_2 = new JButton("Modificar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablealumnos.setValueAt(textField_2.getText(), tablealumnos.getSelectedRow(), 0);
				tablealumnos.setValueAt(textField_3.getText(), tablealumnos.getSelectedRow(), 1);
				tablealumnos.setValueAt(textField_12.getText(), tablealumnos.getSelectedRow(), 2);
				tablealumnos.setValueAt(textField_13.getText(), tablealumnos.getSelectedRow(), 3);
				tablealumnos.setValueAt(textField_6.getText(), tablealumnos.getSelectedRow(), 4);

			}
		});

		lblDireccionAModificar = new JLabel("Direccion a modificar");

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		button_4 = new JButton("Salir");

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		textField_12 = new JTextField();
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setColumns(10);

		lblCorreoAModificar = new JLabel("Correo a modificar");

		lblContraseaaModificar = new JLabel("Contrase\u00F1aa modificar");

		label_3 = new JLabel("NOMBRE:");
		label_3.setFont(new Font("Stencil", Font.ITALIC, 14));

		label_4 = new JLabel("APELLIDO:");
		label_4.setFont(new Font("Stencil", Font.ITALIC, 14));

		label_5 = new JLabel("CORREO:");
		label_5.setFont(new Font("Stencil", Font.ITALIC, 14));

		label_6 = new JLabel("DIRECCION:");
		label_6.setFont(new Font("Stencil", Font.ITALIC, 14));

		label_12 = new JLabel("CONTRASE\u00D1A:");
		label_12.setFont(new Font("Stencil", Font.ITALIC, 14));

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setColumns(10);

		textField_16 = new JTextField();
		textField_16.setColumns(10);

		button_3 = new JButton("A\u00D1ADIR ALUMNO");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField_16.getText();
				String apellido = textField_15.getText();
				String correo = textField_14.getText();
				String direccion = textField_5.getText();
				String contra = textField_4.getText();

				DefaultTableModel modelo = (DefaultTableModel) tablealumnos.getModel();
				String[] fila = new String[5];
				fila[0] = nombre;
				fila[1] = apellido;
				fila[2] = correo;
				fila[3] = direccion;
				fila[4] = contra;

				modelo.addRow(fila);
				table_material.setModel(modelo);
				textField.setText("");
				textField_1.setText("");

			}
		});
		button_3.setBackground(new Color(255, 140, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(button_2, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE))
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2))
								.addGap(27)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblApellidoAModificar, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCorreoAModificar, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblDireccionAModificar)
												.addGap(18).addComponent(lblContraseaaModificar,
														GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE)
												.addGap(38).addComponent(textField_6, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(27)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 81,
														GroupLayout.PREFERRED_SIZE)
												.addGap(25).addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73,
														GroupLayout.PREFERRED_SIZE)
												.addGap(33).addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 102,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4)
												.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE)
												.addGap(66).addComponent(button_3, GroupLayout.PREFERRED_SIZE, 153,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 96,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10).addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 102,
														GroupLayout.PREFERRED_SIZE)
												.addGap(4).addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE)))))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(31)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(label_3,
												GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(label_4,
												GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_15, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(33)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(4).addComponent(label_5,
												GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(textField_14,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
										.addComponent(button_3))
								.addGap(28)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(label_6,
												GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(3).addComponent(label_12,
												GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(
								gl_panel.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_12, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_13, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
										.addComponent(lblApellidoAModificar).addComponent(lblCorreoAModificar)
										.addComponent(lblDireccionAModificar).addComponent(lblContraseaaModificar))
								.addGap(54).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(button_1).addComponent(button_2)).addGap(79)
								.addComponent(button_4)))));

		tablealumnos = new JTable();
		tablealumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSelect = tablealumnos.getSelectedRow();
				textField_2.setText(tablealumnos.getValueAt(filaSelect, 0).toString());
				textField_3.setText(tablealumnos.getValueAt(filaSelect, 1).toString());
				textField_12.setText(tablealumnos.getValueAt(filaSelect, 2).toString());
				textField_13.setText(tablealumnos.getValueAt(filaSelect, 3).toString());
				textField_6.setText(tablealumnos.getValueAt(filaSelect, 4).toString());
			}
		});
		tablealumnos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Apellido", "Correo", "Direccion", "Contrase\u00F1a" }));

		scrollPane.setViewportView(tablealumnos);
		panel.setLayout(gl_panel);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("Notas", null, panel_1, null);

		scrollPane_1 = new JScrollPane();

		button_7 = new JButton("Salir");

		label_8 = new JLabel("NOMBRE DEL MODULO:");
		label_8.setFont(new Font("Stencil", Font.ITALIC, 14));

		label_9 = new JLabel("NOMBRE DEL ALUMNO:");
		label_9.setFont(new Font("Stencil", Font.ITALIC, 14));

		label_10 = new JLabel("NOTA:");
		label_10.setFont(new Font("Stencil", Font.ITALIC, 14));

		textnota = new JTextField();
		textnota.setColumns(10);

		button_5 = new JButton("A\u00D1ADIR NOTA");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int filaSelect = tablemodulos2.getSelectedRow();
				int filaSelect2 = tablealumnos2.getSelectedRow();

				String nota = textnota.getText();
				String alumno = tablemodulos2.getValueAt(filaSelect, 0).toString();
				String modulo = tablealumnos2.getValueAt(filaSelect2, 0).toString();

				DefaultTableModel modelo = (DefaultTableModel) tablenotaas.getModel();
				String[] fila = new String[3];
				fila[0] = alumno;
				fila[1] = modulo;
				fila[2] = nota;

				modelo.addRow(fila);
				tablenotaas.setModel(modelo);
				textField.setText("");
				textField_1.setText("");
			}

		});
		button_5.setBackground(new Color(255, 140, 0));

		scrollPane_2 = new JScrollPane();

		tablemodulos2 = new JTable();
		tablemodulos2.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Horas Semanales", "Profesores" }));
		scrollPane_1.setViewportView(tablemodulos2);

		scrollPane_5 = new JScrollPane();

		lblTablaNotas = new JLabel("TABLA NOTAS");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(10).addComponent(button_7,
										GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(39).addGroup(gl_panel_1
								.createParallelGroup(Alignment.LEADING)
								.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 593,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 153,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(scrollPane_5, 0, 0, Short.MAX_VALUE))
												.addGroup(gl_panel_1.createSequentialGroup().addGap(4)
														.addComponent(textnota, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 260,
																Short.MAX_VALUE)
														.addComponent(lblTablaNotas).addGap(215))))))
						.addGap(197)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(48).addComponent(label_8))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(30)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(label_9))))
				.addGap(49)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textnota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10).addComponent(lblTablaNotas))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(button_5)
						.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				.addGap(71).addComponent(button_7)));

		tablenotaas = new JTable();
		tablenotaas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre del Modulo", "Nombre del Alumno", "Nota" }));
		scrollPane_5.setViewportView(tablenotaas);

		tablealumnos2 = new JTable();
		tablealumnos2.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Apellido", "Correo", "Direccion", "Contrase\u00F1a" }));
		scrollPane_2.setViewportView(tablealumnos2);
		panel_1.setLayout(gl_panel_1);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("Modulos", null, panel_2, null);

		scrollPane_3 = new JScrollPane();

		button_9 = new JButton("Salir");

		button_10 = new JButton("A\u00D1ADIR ALUMNO");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int filaSelect = tableprofesores2.getSelectedRow();
				String profe = tableprofesores2.getValueAt(filaSelect, 0).toString();
				String nombre = textnom.getText();
				String horas = texthoras.getText();
 
				DefaultTableModel modelo = (DefaultTableModel) tablemodulos.getModel();
				String[] fila = new String[3];
				fila[0] = nombre;
				fila[1] = horas;
				fila[2] = profe;

				modelo.addRow(fila);
				tablemodulos.setModel(modelo);
				textField.setText("");
				textField_1.setText("");

			}
		});
		button_10.setBackground(new Color(255, 140, 0));

		label_11 = new JLabel("Nombre:");
		label_11.setFont(new Font("Stencil", Font.ITALIC, 14));

		textnom = new JTextField();
		textnom.setColumns(10);

		label_13 = new JLabel("HORAS SEMANALES:");
		label_13.setFont(new Font("Stencil", Font.ITALIC, 14));
		label_13.setBackground(new Color(255, 140, 0));

		texthoras = new JTextField();
		texthoras.setColumns(10);

		label_14 = new JLabel("PROFESOR QUE LO IMPARTE:");
		label_14.setFont(new Font("Stencil", Font.ITALIC, 14));

		button_11 = new JButton("A\u00D1ADIR MODULO");
		button_11.setBackground(new Color(255, 140, 0));

		scrollPane_4 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(34)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 136,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(texthoras, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_panel_2.createSequentialGroup()
										.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 74,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4).addComponent(textnom, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_panel_2.createSequentialGroup()
										.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 211,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 405,
												GroupLayout.PREFERRED_SIZE)
										.addGap(41).addComponent(button_10, GroupLayout.PREFERRED_SIZE, 153,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(214, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(button_9,
										GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup().addGap(149)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 584,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(329, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(48)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(3).addComponent(label_11,
										GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(textnom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addGap(3).addComponent(label_13,
								GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(texthoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(33)
										.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 15,
												GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_10))
						.addGroup(gl_panel_2.createSequentialGroup().addGap(18).addComponent(scrollPane_4,
								GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
						.addGap(58)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGap(104).addComponent(button_11).addGap(62).addComponent(button_9)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tablemodulos = new JTable();
		tablemodulos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Horas Semanales", "Profesores" }));
		scrollPane_3.setViewportView(tablemodulos);

		tableprofesores2 = new JTable();
		tableprofesores2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Apellido" }));
		scrollPane_4.setViewportView(tableprofesores2);
		panel_2.setLayout(gl_panel_2);
		dtm = new DefaultTableModel(new Object[][] {

		}, new String[] { "ola" });
		contentPane.setLayout(gl_contentPane);

	}

	public void setCtrl(Controlador ctrl) {
		this.controlador = ctrl;

	}

	public void setBd(Conexion bd) {
		this.conexion = bd;
	}

}