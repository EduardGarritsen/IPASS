package applicatie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlBaseDao {
	private String dbURL = "jdbc:mysql://localhost:3306/slufter?useSSL=false";
	private String dbUser = "root";
	private String dbPass = "geheim";
	
	protected Connection myConn = getConnection();
    
    protected Connection getConnection() {
    	
    	try {
    		Connection myConn = DriverManager.getConnection(dbURL, 
    				dbUser, dbPass);
            if (myConn != null) {
                return myConn;
            }
    	}
    	catch (SQLException ex) {
    		System.out.println("Geen Connectie :(");
    	}
    	return null;
    }
    
    public void closeConnection() {
    	
    }
}

