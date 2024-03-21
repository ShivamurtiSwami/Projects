package employees_management_system;

public class Query {
	static String insert="INSERT INTO EmployeeMS (id,name,email,salary) VALUES(?,?,?,?)";
	static String update="UPDATE EmployeeMS SET name =? WHERE id=?";
	static String delete="DELETE FROM EmployeeMS WHERE id=?";
	static String select="SELECT * FROM EmployeeMS";
	
}
