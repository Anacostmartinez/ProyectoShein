package principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionDB;

public class centros {

	public static void main(String[] args) {
		
		  ConexionDB conexion = new ConexionDB ();
	        
	       
          
          System.out.println("Conectando a la base de datos...");
          //Paso 1. Obtener la conexion 
          Connection con = conexion.getConexion();
          
          // Objetos necesarios para hacer una consulta
      
          Statement sentencia= null;
          ResultSet resultado = null;
		
          //Algun procesamiento con la base de datos...
         
          
          try {
       	   // Paso 2. Obtener el Statement
			sentencia = con.createStatement();
			
			//Paso 3. Ejecutr la sentencia
			resultado=sentencia.executeQuery("select cod_centro, nombre, direccion"
					+ " from centros");
			System.out.println("cod-Centro\tNombre\tDireccion");
			
			//Paso 4. Recorrer el resultado
			while (resultado.next ()) {
				int codCentro = resultado.getInt("cod_centro");
				String nombre= resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				
				System.out.println(codCentro+"\t"+nombre+"\t"+direccion);
			}
		} catch (SQLException e) {
		System.out.println("Error al consultar los datos." +e.getMessage());
		}finally {
			try {
				resultado.close();
				sentencia.close();
			} catch (SQLException e) {
			System.out.println("Error al liberar los recursos");
			}
		}
          
          
          //Liberamos la conexion
          System.out.println("Desconectando de la base de datos");
          conexion.desconectar(); 
		
	}




	}
