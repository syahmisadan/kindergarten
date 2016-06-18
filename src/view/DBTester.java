import connection.DBConnection;
import java.sql.Connection;
public class DBTester {
	private static DBConnection dbConn;
	private static Connection conn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dbConn = new DBConnection();
		try {
			conn = dbConn.getConnection();
			System.out.println(" berjaya connect database");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
