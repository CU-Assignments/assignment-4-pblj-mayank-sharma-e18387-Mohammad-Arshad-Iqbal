import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Show All Employees");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    list.add(new Employee(id, name, salary));
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    for (Employee e : list) {
                        if (e.getId() == uid) {
                            sc.nextLine();
                            System.out.print("Enter new Name: ");
                            e.setName(sc.nextLine());
                            System.out.print("Enter new Salary: ");
                            e.setSalary(sc.nextDouble());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to remove: ");
                    int rid = sc.nextInt();
                    list.removeIf(e -> e.getId() == rid);
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    boolean found = false;
                    for (Employee e : list) {
                        if (e.getId() == sid) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Employee not found.");
                    break;
                case 5:
                    for (Employee e : list) System.out.println(e);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
