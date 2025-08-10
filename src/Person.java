//************************** PART 1 & 2: Abstract base class (never directly instantiated)
public abstract class Person {

    private String firstName;         //Declaring 3 variables
    private String lastName;
    private int age;


    public Person() {}     //Default Constructor

    // Second/Parameterized Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
    }

    // Getters & setters for each declared variables
    public String getFirstName() {
        return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() {
        return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() {
        return age; }

    public void setAge(int age) { this.age = age; }

    //Return full name as a Single string
    public String getFullName() { return firstName + " " + lastName; }

    //toString method to called when printing objects
    @Override
    public String toString() {
        return getFullName() + " (age " + age + ")";
    }
}
