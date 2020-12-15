package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbAccess {
	public static DbAccess access = null;
    public static Connection conn = null;

	public static DbAccess getAccess() {		//Single istance(Pattern Singleton)
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
