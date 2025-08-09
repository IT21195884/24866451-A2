// Driver class containing partThree .. partSeven demos
public class AssignmentTwo {

    public static void AssignmentTwo(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();

        // Call the parts one by one for an automated demo
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
        a2.partFive();
        a2.partSix();
        a2.partSeven();
    }

    // Helper: quick visitor maker
    private Visitor V(String fn, String ln, int age, String id, String ticket) {
        return new Visitor(fn, ln, age, id, ticket);
    }

    public void partThree() {
        System.out.println("\n=== PART 3: Queue demo ===");
        Employee op = new Employee("Ava", "Brown", 28, "E100", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", op, 2);

        // Add >= 5 visitors to queue
        ride.addVisitorToQueue(V("Jack","Hill",22,"V001","Standard"));
        ride.addVisitorToQueue(V("Sharon","Ray",27,"V002","VIP"));
        ride.addVisitorToQueue(V("Benny","Stone",19,"V003","Standard"));
        ride.addVisitorToQueue(V("Leo","West",24,"V004","Standard"));
        ride.addVisitorToQueue(V("Nina","Cole",21,"V005","VIP"));

        // Remove one visitor from the queue
        ride.removeVisitorFromQueue();

        // Print queue
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\n=== PART 4A: History (LinkedList) demo ===");
        Ride ride = new Ride("Thunderstorm", new Employee("Tom","Ward",31,"E101","Ride Operator"), 4);

        // Add >= 5 visitors directly to history (simulating after ride taken)
        Visitor a = V("Tom","Parker",29,"V100","Standard");
        Visitor b = V("Sherly","Green",26,"V101","VIP");
        Visitor c = V("Ben","Adams",23,"V102","Standard");
        Visitor d = V("David","King",22,"V103","Standard");
        Visitor e = V("Amy","King",20,"V104","VIP");

        ride.addVisitorToHistory(a);
        ride.addVisitorToHistory(b);
        ride.addVisitorToHistory(c);
        ride.addVisitorToHistory(d);
        ride.addVisitorToHistory(e);

        // Check presence
        ride.checkVisitorFromHistory(b);

        // Print count
        ride.numberOfVisitors();

        // Print all using iterator (inside Ride)
        ride.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n=== PART 4B: Sort history using Comparator demo ===");
        Ride ride = new Ride("Splash Wave", new Employee("Mia","Lee",33,"E102","Ride Operator"), 3);

        ride.addVisitorToHistory(V("Zack","Young",20,"V200","Standard"));
        ride.addVisitorToHistory(V("Alice","Brown",21,"V201","VIP"));
        ride.addVisitorToHistory(V("Ben","Brown",22,"V202","Standard"));
        ride.addVisitorToHistory(V("Cathy","Andrews",23,"V203","VIP"));
        ride.addVisitorToHistory(V("David","Andrews",24,"V204","Standard"));

        System.out.println("Before sort:");
        ride.printRideHistory();

        // Sort using Comparator (lastName, firstName, then ticketType)
        ride.sortRideHistory(new VisitorComparator());

        System.out.println("After sort:");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n=== PART 5: Run one ride cycle demo ===");
        Ride ride = new Ride("Galaxy Drop",
                new Employee("Ethan","Brooks",30,"E103","Ride Operator"), 4);

        // Add >= 10 to queue
        ride.addVisitorToQueue(V("Jack","Lee",18,"V300","Standard"));
        ride.addVisitorToQueue(V("Leo","Chan",19,"V301","VIP"));
        ride.addVisitorToQueue(V("Mia","Ng",20,"V302","Standard"));
        ride.addVisitorToQueue(V("Noah","Li",21,"V303","Standard"));
        ride.addVisitorToQueue(V("Olivia","Guo",22,"V304","VIP"));
        ride.addVisitorToQueue(V("Paul","Lim",23,"V305","Standard"));
        ride.addVisitorToQueue(V("Quinn","Low",24,"V306","Standard"));
        ride.addVisitorToQueue(V("Rita","Koh",25,"V307","VIP"));
        ride.addVisitorToQueue(V("Sam","Tan",26,"V308","Standard"));
        ride.addVisitorToQueue(V("Tina","Yap",27,"V309","Standard"));

        System.out.println("Queue BEFORE cycle:");
        ride.printQueue();

        // Run one cycle: removes up to maxRider from queue and adds to history
        ride.runOneCycle();

        System.out.println("Queue AFTER 1 cycle:");
        ride.printQueue();

        System.out.println("Ride history AFTER 1 cycle:");
        ride.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n=== PART 6: Export ride history to file demo ===");
        Ride ride = new Ride("Comet Run", new Employee("Ivy","Park",29,"E104","Ride Operator"), 3);

        // Add >= 5 visitors to history
        ride.addVisitorToHistory(V("Tom","Gray",28,"V400","Standard"));
        ride.addVisitorToHistory(V("Sherly","Black",26,"V401","VIP"));
        ride.addVisitorToHistory(V("Ben","White",23,"V402","Standard"));
        ride.addVisitorToHistory(V("David","Blue",22,"V403","Standard"));
        ride.addVisitorToHistory(V("Amy","Pink",20,"V404","VIP"));

        // Export to CSV in project root (adjust if needed)
        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        System.out.println("\n=== PART 7: Import ride history from file demo ===");
        Ride ride = new Ride("Comet Run (Restored)", null, 3);

        // Import previously exported file
        ride.importRideHistory("ride_history.csv");

        // Confirm count and contents
        ride.numberOfVisitors();
        ride.printRideHistory();
    }
}
