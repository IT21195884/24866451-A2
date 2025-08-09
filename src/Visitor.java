// PART 1: Visitor extends Person
public class Visitor extends Person {
    // At least 2 instance variables for a theme park member/visitor
    private String visitorId;
    private String ticketType; // e.g., "Standard", "VIP"

    // Default constructor
    public Visitor() {}

    // Full constructor (includes Person fields)
    public Visitor(String firstName, String lastName, int age,
                   String visitorId, String ticketType) {
        super(firstName, lastName, age);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    // Getters & setters
    public String getVisitorId() { return visitorId; }
    public void setVisitorId(String visitorId) { this.visitorId = visitorId; }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    @Override
    public String toString() {
        return "Visitor{" + getFullName() + ", id=" + visitorId + ", ticket=" + ticketType + "}";
    }
}
