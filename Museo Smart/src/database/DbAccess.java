package database;
/*
 * Class DbAccess use singleton pattern and allows to instantiate a single class instance to access the db
 * @author Albanese and Virruso
 * @version 1.0
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DbAccess {
	public static DbAccess access = null;
    public static Connection conn = null;

	public static DbAccess getAccess() {		//get single istance
		if(access  == null) {
			conn = DbAccess.connect("gestione_museo");
			access = new DbAccess();
			}
		return access;
		}
	
	public static Connection connect(String DbName) {		//this method enstablish connection to DB
		try {
			String url = "jdbc:mysql://localhost:3306/" + DbName;
			return DriverManager.getConnection(url,"root","");
		}
		catch (Exception e) {
            System.err.println("DB ERROR! ");
            //System.err.println(e.getMessage());
            throw new IllegalArgumentException("** DATABASE CONNECTION FAILED **");
		}
	}
}
