import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
	    private Connection connection;
	    private Scanner scanner;

	    public Patient(Connection connection, Scanner scanner){
	        this.connection = connection;
	        this.scanner = scanner;
	    }

	    public void addPatient(){
	    	 System.out.print("Enter Patient Name: ");
	         String name = scanner.next();
	         int age = getValidAge(scanner);
	         String gender = getValidGender(scanner);

	        try{
	            String query = "INSERT INTO patient(name, age, gender) VALUES(?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, name);
	            preparedStatement.setInt(2, age);
	            preparedStatement.setString(3, gender);
	            int affectedRows = preparedStatement.executeUpdate();
	            if(affectedRows>0){
	                System.out.println("Patient Added Successfully!!");
	            }else{
	                System.out.println("Failed to add Patient!!");
	            }

	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	    }

	    public void viewPatients(){
	        String query = "select * from patient";
	        try{
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            System.out.println("Patients: ");
	            System.out.println("+------------+--------------------+----------+------------+");
	            System.out.println("| Patient Id | Name               | Age      | Gender     |");
	            System.out.println("+------------+--------------------+----------+------------+");
	            while(resultSet.next()){
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                int age = resultSet.getInt("age");
	                String gender = resultSet.getString("gender");
	                System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", id, name, age, gender);
	                System.out.println("+------------+--------------------+----------+------------+");
	            }

	        }catch (SQLException e){
	            System.out.println("An error occurred while fetching patient data: " + e.getMessage());
	        }
	    }

	    public boolean getPatientById(int id){
	        String query = "SELECT * FROM patient WHERE id = ?";
	        try{
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if(resultSet.next()){
	                return true;
	            }else{
	                return false;
	            }
	        }catch (SQLException e){
	        	System.out.println("An error occurred while querying the database: " + e.getMessage());
	        }
	        return false;
	    }
	    
	    public void deletePatientById(int id) {
	        String query = "DELETE FROM patient WHERE id = ?";
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            int affectedRows = preparedStatement.executeUpdate();
	            if (affectedRows > 0) {
	                System.out.println("Patient with ID " + id + " deleted successfully.");
	            } else {
	                System.out.println("No patient found with ID " + id + ".");
	            }
	        } catch (SQLException e) {
	        	System.out.println("An error occurred while querying the database: " + e.getMessage());
	        }
	    }
	    
	    private int getValidAge(Scanner scanner) {
	        int age;
	        while (true) {
	            System.out.print("Enter Patient Age: ");
	            if (scanner.hasNextInt()) {
	                age = scanner.nextInt();
	                if (age > 0) {
	                    break;
	                } else {
	                    System.out.println("Age must be a positive integer.");
	                }
	            } else {
	                System.out.println("Invalid input. Age must be a positive integer.");
	                scanner.next(); // Consume invalid input
	            }
	        }
	        return age;
	    }

	    private String getValidGender(Scanner scanner) {
	        String gender;
	        while (true) {
	            System.out.print("Enter Patient Gender: ");
	            gender = scanner.next().trim().toLowerCase();
	            if (gender.equals("male") || gender.equals("female") || gender.equals("other")) {
	                break;
	            } else {
	                System.out.println("Invalid gender. Please enter 'male', 'female', or 'other'.");
	            }
	        }
	        return gender;
	    }
	    
	    
	}

