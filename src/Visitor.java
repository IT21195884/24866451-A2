// ************PART 1: Visitor extends Person
public class Visitor extends Person {

    //Declaring 2 variables
    private String visitorId;
    private String ticketType; // For an example "Standard", "VIP"

    // Default constructor
    public Visitor() {}

    //Parametarized Constructor
    public Visitor(String firstName, String lastName, int age,
                   String visitorId, String ticketType) {
        super(firstName, lastName, age);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    // Getters & setters for the fields
    public String getVisitorId() { return visitorId; }
    public void setVisitorId(String visitorId) { this.visitorId = visitorId; }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    //toString method to called when printing objects
    @Override
    public String toString() {
        return "Visitor{" + getFullName() + ", id=" + visitorId + ", ticket=" + ticketType + "}";
    }
}
