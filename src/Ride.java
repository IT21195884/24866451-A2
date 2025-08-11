import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Part 1 Creating Ride  Class
public class Ride implements RideInterface {

    // Declaring 4 variables
    private String rideName;
    private Employee operator;              // required to run

    private int maxRider = 2;               // Part 5 -how many visitors per cycle
    private int numOfCycles = 0;            // Part 5 - count of cycles run



    //Part 3 - Creating Queue Interface
    // Queue for waiting visitors - FIRST IN FIRST ONE
    private Queue<Visitor> waitingLine = new LinkedList<>();

    // LinkedList for ride history - visitors who took the ride
    private LinkedList<Visitor> rideHistory = new LinkedList<>();



    // Default constructor
    public Ride() {}

    // Parametarized Constructor
    public Ride(String rideName, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.operator = operator;
        setMaxRider(maxRider);
    }

    // Getters & setters for the fields
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) {
        // ensure at least 1 rider per cycle
        this.maxRider = Math.max(1, maxRider);
    }

    public int getNumOfCycles() { return numOfCycles; }






    //Part 3 - Creating Queue Methods with the RideInterface

    @Override
    public boolean addVisitorToQueue(Visitor v) {
        boolean ok = waitingLine.offer(v);
        if (ok) {
            System.out.println("[OK] " + v.getFullName() + " joined " + rideName + " queue.");
        } else {
            System.out.println("[FAIL] Could not add " + v.getFullName() + " to queue.");
        }
        return ok;
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor v = waitingLine.poll();
        if (v != null) {
            System.out.println("[OK] " + v.getFullName() + " removed from queue.");
        } else {
            System.out.println("[INFO] Queue is empty; nothing to remove.");
        }
        return v;
    }

    @Override
    public void printQueue() {
        System.out.println("— Waiting line for '" + rideName + "' — size=" + waitingLine.size());
        if (waitingLine.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        int i = 0;
        for (Visitor v : waitingLine) {
            System.out.println("  " + (i++) + ". " + v);
        }
    }







    //Part-4 Advanced Collection Creation

    @Override
    public boolean addVisitorToHistory(Visitor v) {
        boolean ok = rideHistory.add(v);
        if (ok) {
            System.out.println("[OK] " + v.getFullName() + " added to ride history.");
        } else {
            System.out.println("[FAIL] Could not add to ride history.");
        }
        return ok;
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        // Check by visitorId to avoid equals() override requirement
        boolean found = rideHistory.stream().anyMatch(x -> x.getVisitorId().equals(v.getVisitorId()));
        System.out.println(found
                ? "[OK] " + v.getFullName() + " is in ride history."
                : "[INFO] " + v.getFullName() + " not found in ride history.");
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int n = rideHistory.size();
        System.out.println("[INFO] Number of visitors in history: " + n);
        return n;
    }

    @Override
    public void printRideHistory() {
        System.out.println("— Ride history for '" + rideName + "' — size=" + rideHistory.size());
        if (rideHistory.isEmpty()) {
            System.out.println("(no one has taken the ride yet)");
            return;
        }
        // REQUIRED - use an Iterator as specified
        Iterator<Visitor> it = rideHistory.iterator();
        int i = 0;
        while (it.hasNext()) {
            System.out.println("  " + (i++) + ". " + it.next());
        }
    }

    // Part 4B method Creation for sorts the collection
    public void sortRideHistory(java.util.Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("[OK] Ride history sorted.");
    }



    @Override
    public void runOneCycle() {
        // Preconditions
        if (operator == null) {
            System.out.println("[BLOCKED] Cannot run '" + rideName + "': no operator assigned.");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("[BLOCKED] Cannot run '" + rideName + "': no visitors in queue.");
            return;
        }

        int slots = Math.min(maxRider, waitingLine.size());
        System.out.println("[RUN] '" + rideName + "' starting cycle with up to " + maxRider +
                " riders. Actual riders this cycle: " + slots);

        for (int i = 0; i < slots; i++) {
            Visitor v = waitingLine.poll();   // remove from queue (FIFO)
            addVisitorToHistory(v);           // add to history
        }

        numOfCycles++;
        System.out.println("[DONE] Cycle complete. Total cycles run: " + numOfCycles);
    }

    //Part 6 Writing to a File

    @Override
    public boolean exportRideHistory(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor v : rideHistory) {
                String line = String.join(",",
                        v.getFirstName(),
                        v.getLastName(),
                        String.valueOf(v.getAge()),
                        v.getVisitorId(),
                        v.getTicketType());
                bw.write(line);
                bw.newLine();
            }
            System.out.println("[OK] Exported " + rideHistory.size() + " visitors to " + filePath);
            return true;
        } catch (IOException e) {
            System.out.println("[ERROR] Export failed: " + e.getMessage());
            return false;
        }
    }

    //Part 7 Reading from a file
    //Debugged Using Gen AI Tools
    @Override
    public boolean importRideHistory(String filePath) {
        int imported = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue; // Skip empty lines

                String[] parts = line.split(",", -1);
                if (parts.length != 5) {
                    System.out.println("[WARN] Bad line (ignored): " + line);
                    continue;
                }
                // Reconstruct Visitor and add to history
                Visitor v = new Visitor(parts[0], parts[1], Integer.parseInt(parts[2]),
                        parts[3], parts[4]);
                if (addVisitorToHistory(v)) imported++;
            }
            System.out.println("[OK] Imported " + imported + " visitors from " + filePath);
            return true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("[ERROR] Import failed: " + e.getMessage());
            return false;
        }
    }
}
