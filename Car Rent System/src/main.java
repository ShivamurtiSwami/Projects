public class main {
 public static void main(String[] args) {
        RentalSystem rentalSystem=new RentalSystem();
        Car car1=new Car("C101","Toyota","Camry",50.00);
        Car car2 = new Car("C002", "Honda", "Accord", 70.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
        }
}