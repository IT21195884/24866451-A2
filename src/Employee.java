public class Employee {

    // PART 1: Employee extends Person
    public class Employee extends Person {
        // At least 2 instance variables for staff
        private String employeeId;
        private String role; // e.g., "Ride Operator"

        // Default constructor
        public Employee() {}

        // Full constructor (includes Person fields)
        public Employee(String firstName, String lastName, int age,
                        String employeeId, String role) {
            super(firstName, lastName, age);
            this.employeeId = employeeId;
            this.role = role;
        }

        // Getters & setters
        public String getEmployeeId() { return employeeId; }
        public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        @Override
        public String toString() {
            return "Employee{" + getFullName() + ", id=" + employeeId + ", role=" + role + "}";
        }
    }

}
//(1)