package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	private final static class DBConfig{
		
		private final static String USER = "RLFRBDNJS";
		private final static String PASSWORD = "YLHRE123";
		private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
		
		public static String getUSER() {
			return USER;
		}
		
		public static String getPASSWORD() {
			return PASSWORD;
		}
		
		public static String getURL() {
			return URL;
		}
		
		public static String getDRIVER() {
			return DRIVER;
		}
		
	}
	
	public static Connection getConnection() throws Exception {
		Class.forName(DBConfig.getDRIVER());	
		return DriverManager.getConnection(DBConfig.getURL(), DBConfig.getUSER(), DBConfig.getPASSWORD());
	}
}
