/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class will load driver and establish connection
 * @author Eilisa & Hayati
 */
public class DBConnection {

	private String driver;
	private String dbName;
	private String connectionURL;
	private String username;
	private String password;
	
	/**
	 * Specifying database connection attributes
	 */
	public DBConnection() {
		
		driver			= "com.mysql.jdbc.Driver";
		connectionURL	= "jdbc:mysql://localhost:3306/";
		dbName			= "kindergarten";
		username		= "root";
		password		= "root";
		
	}
	
	public Connection getConnection() throws Exception {
		
		// Load JDBC driver
		Class.forName(driver);
		
		// Establish connection
		Connection connection =
				DriverManager.getConnection(
						connectionURL + dbName + "?autoReconnect=true&useSSL=false", 
						username, password);
		System.out.println("database: " + dbName );
		
		return connection;
		
	}
	
}
