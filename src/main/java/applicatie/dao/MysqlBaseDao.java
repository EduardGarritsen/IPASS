package applicatie.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MysqlBaseDao {
    protected Connection getConnection() {
    	Connection result = null;
    	
    	try {
    		InitialContext  ic = new InitialContext();
    		DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/MysqlDS");
    		result = ds.getConnection();
    	}
    	catch (Exception ex) {
    		System.out.println("Geen Connectie :(,omdat euh:");
    		ex.printStackTrace();
    	}
    	return result;
    }
    
}

