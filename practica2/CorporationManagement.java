import java.util.Scanner;

class Employee {
    public int UUID;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String address;
    private String RFC;
    public String CURP;
    private String NSS;
    private int horas;
    private double salary;
    private String position;
    private double vales;

    public Employee(int UUID, String nombre, String apellido_paterno, String apellido_materno, int horas, double salary, String address, String RFC, String NSS, String CURP, String Position) {
        this.UUID = UUID;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.horas = horas;
        this.salary = salary;
        this.address = address;
        this.RFC = RFC;
        this.NSS = NSS;
        this.CURP = CURP;
        this.position = Position;
        this.vales = salary * 0.072;
    }

    public void updatePersonalData(String new_address) {
        this.address = new_address;
    }

    public void increaseSalary(double percentage) {
        this.salary += (this.salary * percentage) / 100;
        this.vales = salary * 0.072;
    }

    public void updatePosition(String position) {
        this.position = position;
        increaseSalary(3); // Incrementar el salario en 3% cuando sube de puesto
    }

    public void displayEmployeeDetails() {
        System.out.println("UUID: " + UUID);
        System.out.println("Name: " + nombre + " " + apellido_paterno + " " + apellido_materno);
        System.out.println("Address: " + address);
        System.out.println("RFC: " + RFC);
        System.out.println("CURP: " + CURP);
        System.out.println("NSS: " + NSS);
        System.out.println("Salary: $" + salary);
        System.out.println("Position: " + position);
        System.out.println("horas: " + horas);
        System.out.println("vales: $" + vales);
        System.out.println("------------------------");
    }
}

public class CorporationManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee[] employees = new Employee[20]; // Array to store employee objects

        // Admin login
        System.out.println("Admin Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Check admin credentials
        if (username.equals("admin") && password.equals("password")) {
            System.out.println("Login Successful!");

            // Creating new employees
            for (int i = 0; i < 2; i++) {
                System.out.println("Creating Employee " + (i + 1));
                System.out.print("Nombre: ");
                String name = scanner.nextLine();
                System.out.print("Apellido paterno: ");
                String apellido_paterno = scanner.nextLine();
                System.out.print("Apellido materno: ");
                String apellido_materno = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("RFC: ");
                String RFC = scanner.nextLine();
                System.out.print("CURP: ");
                String CURP = scanner.nextLine();
                System.out.print("NSS: ");
                String NSS = scanner.nextLine();
                System.out.print("horas: ");
                int horas = scanner.nextInt();
                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Position: ");
                String position = scanner.nextLine();

                employees[i] = new Employee(i, name, apellido_paterno, apellido_materno, horas, salary, address, RFC, NSS, CURP, position);

                System.out.println("Employee created successfully!");
                System.out.println("------------------------");
            }

            // Updating employee data
            System.out.println("Updating Employee Data");
            System.out.print("Enter Employee UUID: ");
            int UUID = scanner.nextInt();

            // Find employee with given CURP
            Employee selectedEmployee = null;
            for (Employee employee : employees) {
                if (employee != null && UUID == employee.UUID) {
                    selectedEmployee = employee;
                    break;
                }
            }

            if (selectedEmployee != null) {
                System.out.println("Employee found!");
                System.out.print("New Address: ");
                String newAddress = scanner.nextLine();
                selectedEmployee.updatePersonalData(newAddress);

                System.out.print("Increase Salary by percentage (if any): ");
                double percentage = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                selectedEmployee.increaseSalary(percentage);

                System.out.print("New Position: ");
                String newPosition = scanner.nextLine();
                selectedEmployee.updatePosition(newPosition);

                System.out.println("Employee data updated successfully!");
                System.out.println("------------------------");
            } else {
                System.out.println("Employee not found!");
            }

            // Display all employee details
            System.out.println("Employee Details");
            for (Employee employee : employees) {
                if (employee != null) {
                    employee.displayEmployeeDetails();
                }
            }
        } else {
            System.out.println("Login Failed! Invalid credentials.");
        }

        scanner.close();
    }
}