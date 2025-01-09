//Richard Padilla
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement; // utiliza para el slect
import java.sql.ResultSet;         // utiliza para el slect


public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/Operadores";
        String user = "root";
        String password = "1234";


        try(Connection conexionMySQL = DriverManager.getConnection(url,user,password)) {
            System.out.println(" ----- Conexión con la base de datos realizada con éxito! ----- ");

            String query = "SELECT * FROM Clientes";
            PreparedStatement stmt = conexionMySQL.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + ", " +
                        resultSet.getString("nombre") + ", " +
                        resultSet.getString("apellido") + ", " +
                        resultSet.getString("correo"));
            }
        }catch (Exception e){
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
