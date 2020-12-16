import java.sql.*;
import java.util.Properties;

public class Queries {

    public static void main(String[] args) {
        //Queries test = new Queries();
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/gestione_museo";
            conn = DriverManager.getConnection(url,"root","");
            Statement stmt = conn.createStatement();
            ResultSet rs;
            //stmt.executeUpdate("INSERT INTO room VALUES (5, 12.5, 1, 7, 11.5, 0, 23)");
            //stmt.executeUpdate("UPDATE art_piece set Availability='In restauro' where ID_art= 2");
 
            rs = stmt.executeQuery("SELECT * FROM room where ID_room = 5 " );
           // while ( rs.next() ) {
            rs.next();
                String column = rs.getString("Temperature");
                System.out.println(column);
                
                System.out.println(rs.next());
            //}
            System.out.println(" DB connected ");
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
    }
        return;
    }

}