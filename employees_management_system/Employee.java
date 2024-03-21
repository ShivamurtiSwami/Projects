package employees_management_system;

public class Employee {

	private int id;
	private String name;
	private String email;
	private double salary;

	// constr
	public Employee(int id, String name, String email, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	// getter setters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getSalary() {
		return salary;
	}

	
	// to string
	@Override
	public String toString() {
		return "Employee id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary;
	}

}
