package principal;

import java.sql.Connection;

import conexion.ConexionDB;

public class PruebaConexion {

	public static void main(String[] args) {
		
           ConexionDB conexion = new ConexionDB ();
           System.out.println("Conectando a la base de datos...");
           Connection con = conexion.getConexion();
		
           //Algun procesamiento con la base de datos...
           
           //Liberamos la conexion
           conexion.desconectar(); 
		
	}

}
