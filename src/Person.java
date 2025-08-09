// PART 1 & 2: Abstract base class (never directly instantiated)
public abstract class Person {
    // At least 3 instance variables for a person
    private String firstName;
    private String lastName;
    private int age;

    // Default constructor
    public Person() {}

    // Full constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
    }

    // Getters & setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getFullName() { return firstName + " " + lastName; }

    @Override
    public String toString() {
        return getFullName() + " (age " + age + ")";
    }
}
