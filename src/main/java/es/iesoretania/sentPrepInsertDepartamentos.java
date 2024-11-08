package es.iesoretania;
import java.sql.*;

public class sentPrepInsertDepartamentos{
    public static void main(String[] args){
        
        //Recogemos los valores de los argumentos al programa.
        String dep = args[0];
        String dnombre = args[1];
        String loc = args[2];
        
        try {
            Connection conexion = DriverManager.getConnection
            ("jdbc:mysql://localhost/practica","root", "practica");

            //construimos la orden INSERT
            String sql = "INSERT INTO departamentos VALUES (?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, Integer.parseInt(dep));
            sentencia.setString(2, dnombre);
            sentencia.setString(3, loc);

            int filas = sentencia.executeUpdate(); 
            System.out.printf("Registros guardados: %d%n", filas);

            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}