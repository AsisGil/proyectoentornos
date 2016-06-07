package Modelo;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Vista.Mantenimiento;

public class Conexion {

	public String bdNick;
	public String bdPass;
	private String mi_url = "jdbc:oracle:thin:@localhost:1521:XE";
	private int contador;
	private Component panel;
	private DefaultTableModel dtm;

	private Connection conexion;
	private String bd, login, pwd, url;
	private String[][] tabla;
	private Mantenimiento mantenimiento;
	private String[] combo;
	private Principal principal;
	private Controlador controlador;

	Vista.ini ini = new Vista.ini();

	Properties propiedades = new Properties();
	InputStream entrada = null;

	public Conexion() {
		// "jdbc:oracle:thin:@localhost:1521:XE"
		// establecerini();

		try {

			File miFichero = new File("configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				// cargamos el archivo de propiedades
				propiedades.load(entrada);

				String url = propiedades.getProperty("url");
				String usuario = propiedades.getProperty("usuario");
				String contrasena = propiedades.getProperty("clave");

				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, usuario, contrasena);
				System.out.println("-- Conexión establecida --");
				// mantenimiento.setVisible(true);
			}

		} catch (SQLException e) {
			// System.out.println("Falla la conexión");
			JOptionPane.showMessageDialog(panel, "CONFIGURACION INCORRECTA INI", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void establecerini() {
		ini.valoresini();
	}

	public void Consulta(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {

				bdNick = rset.getString(2);
				bdPass = rset.getString(6);

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void insertInto(String query) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery(query);

		} catch (Exception e) {

			System.out.println("No se ha insertado1");
		}

	}

	public int numeroUsuarios(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {

				contador = contador + 1;
			}

		} catch (Exception e) {

			System.out.println("No se ha insertado2");
		}
		return contador;

	}

	public void validaUsuario(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {

				bdNick = rset.getString(2);
				System.out.println(bdNick);
			}

		} catch (SQLException s) {
			System.out.println("Fallo");
		}
	}

	public String getNick(String query) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {

				bdNick = rset.getString(2);

			}

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return bdNick;
	}

	public void consultaMateriales() {
		// CONSULTA DATOS TABLA PROFESORES
		try {
			String nfilas = "Select count(*) from pentornos.profesores";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
 			rset.next();
			int f = rset.getInt(1);
			String query = "SELECT NOMBRE_profesor, apellido_profesor from pentornos.profesores";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tabla = new String[f][c];
			while (rset.next()) {
				tabla[i][0] = rset.getString(1);
				tabla[i][1] = rset.getString(2);
 				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		mantenimiento.rellenarTablaprofesores();
		mantenimiento.rellenarTablaprofesores2();

		
		// CONSULTA DATOS TABLA aLUMNOS
		try {
			String nfilas = "Select count(*) from pentornos.ALUMNOS";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
 			rset.next();
			int f = rset.getInt(1);
			String query = "SELECT nombre_alumno, apellido_alumno, correo_alumno, direccion_alumno, contraseña_alumno from pentornos.alumnos";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tabla = new String[f][c];
			while (rset.next()) {
				tabla[i][0] = rset.getString(1);
				tabla[i][1] = rset.getString(2);
				tabla[i][2] = rset.getString(3);
				tabla[i][3] = rset.getString(4);
				tabla[i][4] = rset.getString(5);

 				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		mantenimiento.rellenarTablalumnos();
		mantenimiento.rellenarTablalumnos2();

		// CONSULTA DATOS TABLA MODULOS
				try {
					String nfilas = "Select count(*) from pentornos.modulos";
					Statement stmt = conexion.createStatement();
					ResultSet rset = stmt.executeQuery(nfilas);
		 			rset.next();
					int f = rset.getInt(1);
					String query = "SELECT NOMBRE_modulo, horas_modulo, profesores_cod_profesor from pentornos.modulos";
					stmt = conexion.createStatement();
					rset = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rset.getMetaData();
					int c = rsmd.getColumnCount();
					int i = 0;
					tabla = new String[f][c];
					while (rset.next()) {
						tabla[i][0] = rset.getString(1);
						tabla[i][1] = rset.getString(2);
						tabla[i][2] = rset.getString(3);

		 				i++;
					}
					rset.close();
					stmt.close();
				} catch (SQLException s) {
					s.printStackTrace();
				}
				mantenimiento.rellenarTablamodulos();
				mantenimiento.rellenarTablamodulos2();

				// CONSULTA DATOS TABLA al
				 
	}

	public String[][] getMateriales() {
		return tabla;
	}

	public String[] getComboBox() {
		return combo;
	}

	public void setMateriales(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public void comprobacion(String usuario, String contrasena) {
		Consulta("select * from  DBMA.usuarios where nick='" + usuario + "' and password='" + contrasena + "'");
		if (usuario.equals(bdNick) && contrasena.equals(bdPass))
			mantenimiento.setVisible(true);
		else if (!usuario.equals(bdNick) || (!contrasena.equals(bdPass))) {
			contador++;
			if (contador >= 3)
				System.exit(0);
		}
	}

	public void setmantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
}
