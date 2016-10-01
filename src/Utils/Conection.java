package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conection {

	public Connection getConnection() throws Exception {
//		Connection connection = null;
//		String databaseName = "ElectronDB";
//		String user = "sys";
//		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Properties access = new Properties();
			access.put("user", "ELECTRONSERVER");
			access.put("password", "1234");
			Connection conn = DriverManager.getConnection(url, access);
			System.out.println("ok" + conn);
			return conn;
			
//			String connectionString = "jdbc:oracle:thin:@localhost:1521:ElectronDB ","sys",
//					"1234" + password + ";";
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ElectronDB ","sys",
//					"1234");
		} catch (Exception ex) {
			throw ex;
		}

//		return connection;
	}
}
