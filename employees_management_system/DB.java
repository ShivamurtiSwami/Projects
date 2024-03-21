package employees_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection connect() {
		 Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/yourdb";
			String username = "root";
			String password = "root";

			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
