// **************PART 1: Employee extends Person
public class Employee extends Person {

    private String employeeId;      //Declaring 2 variables
    private String role;


    public Employee() {}     // Default constructor

    // Parametarized Constructor
    public Employee(String firstName, String lastName, int age,
                    String employeeId, String role) {
        super(firstName, lastName, age);
        this.employeeId = employeeId;
        this.role = role;
    }

    // Getters & setters for each field
    public String getEmployeeId() {
        return employeeId; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getRole() {
        return role; }

    public void setRole(String role) { this.role = role; }

    //toString method to called when printing objects
    @Override
    public String toString() {
        return "Employee{" + getFullName() + ", id=" + employeeId + ", role=" + role + "}";
    }
}
