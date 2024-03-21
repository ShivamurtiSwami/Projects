package employees_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEmp {
	public static void createEmployee(Employee employee) throws SQLException{
		Connection conn=DB.connect();
		String query=Query.insert;
		PreparedStatement ps=conn.prepareStatement(query);
		 
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getName());
		ps.setString(3, employee.getEmail());
		ps.setDouble(4,employee.getSalary());
		
		System.out.println("\n ps ="+ps+"\n"+employee);
		ps.executeUpdate();
		ps.close();
	}
	
	public static void updateEmployee(int id, String name) throws SQLException{
		Connection conn=DB.connect();
		String query=Query.update;
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(2,id);
		ps.setString(1, name);
		
		System.out.println("\n ps ="+ps);
		ps.executeUpdate();
		ps.close();
	}
		public static ArrayList<Employee> readAllEmployee() throws SQLException{
			ArrayList<Employee> emplist= new ArrayList<Employee>();
			Connection conn=DB.connect();
			String query=Query.select;
			PreparedStatement ps=conn.prepareStatement(query);
			System.out.println("\n st="+ps);
			ResultSet rs=ps.executeQuery(query);
			
			while(rs.next()) {
				Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				emplist.add(emp);
			}
			 ps.close();
			 return emplist;
		}
		public static void deleteEmployee(int id) throws SQLException{
			Connection conn=DB.connect();
			String query=Query.delete;
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.executeUpdate();
			ps.close();
		}
}
