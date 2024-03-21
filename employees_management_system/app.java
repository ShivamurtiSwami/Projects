package employees_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class app {
	public static void main(String[] args) throws Exception {
		while (true) {
			System.out.println("\n Employyee Management:");
			System.out.println("1=Crete 2=Read 3=Update 4=Delete");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice < 1 || choice > 5)
				break;
			switch (choice) {
			case 1:
				System.out.println("Enter your ID:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter your name:");
				String name = sc.nextLine();
				System.out.println("Enter your email:");
				String email = sc.nextLine();
				System.out.println("Enter your salary:");
				double salary = sc.nextDouble();
				Employee emp = new Employee(id, name, email, salary);
				DAOEmp.createEmployee(emp);
				break;

			case 2:
				ArrayList<Employee> list = DAOEmp.readAllEmployee();
				for (Employee employee : list) {
					System.out.println(employee);
				}
				break;

			case 3:
				System.out.println("id,name");
				id = sc.nextInt();
				sc.hasNextLine();
				name = sc.nextLine();
				DAOEmp.updateEmployee(id, name);
				break;

			case 4:
				System.out.println("id");
				id = sc.nextInt();
				DAOEmp.deleteEmployee(id);
				break;
				
			}
		}
	}
}
