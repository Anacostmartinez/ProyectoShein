package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
	 * Clse que permite la conexion con la base de datos
	 * registrando un driver de tipo MariaDB
	 */
public class ConexionDB {

/** Propiedades de la conexion */
	//Cambiar el dato para conectar a otra base de datos
	private static String database="empresa";
	private static String usuario="root";
	private static String contraseña ="";
	private static String url="jdbc:mariadb://localhost:3306/"+database;
	
	//objeto Connection que debemos usar en JDBC
	private Connection conexion=null;
	/**
	 * metodo de la clase que devuelve el objeto Connection innecesario
	 * para operar con la base de datos.
	 * @return el objeto Connection 
	 */
	
	public Connection getConexion() {
		if (this.conexion!=null) {
			// Ya está la conexión creada , la devuelvo
			return this.conexion;
		}
		
		// Inicializamos la conexion a la base de datos
		
		try {
			
		//Registrar el driver. Previamente habrá que haber añadido el driver
		// al proyecto (Build Path)
		
		
			Class.forName("org.mariadb.jdbc.Driver");
			
			//Obtenemos el objeto Connection de la clase 
			//DriveManager. Lanzará una exception
			//SQLException sino se puede connectar
			this.conexion = DriverManager.getConnection(
					url, usuario,contraseña);
			System.out.println("Conexion a base de datos correcta.");
					
		} catch (ClassNotFoundException e) {
			System.out.println("error al administrar el driver.");
			
		} catch (SQLException e) {
			System.out.println("No se puede conectar a la base de datos."+e.getLocalizedMessage());
		}
		return this.conexion;
		
	}
	/**
	 * Metodo de la clase que libera los recursos asociados a la conexion
	 */
	
	public void desconectar () {
		if (this.conexion!=null) {
			try {
				this.conexion.close();
			} catch (SQLException e) {
				System.out.println("Error, no se puede liberar la conexión");
			
			}
		}
		
		
	}
}
