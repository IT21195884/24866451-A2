public class RideInterface {

    // PART 2: Interface to enforce required ride behaviours
    public interface RideInterface {
        // Queue-related
        boolean addVisitorToQueue(Visitor v);
        Visitor removeVisitorFromQueue(); // FIFO removal; returns removed visitor or null
        void printQueue();

        // Ride cycle
        void runOneCycle();

        // History-related (LinkedList)
        boolean addVisitorToHistory(Visitor v);
        boolean checkVisitorFromHistory(Visitor v);
        int numberOfVisitors();
        void printRideHistory();

        // I/O
        boolean exportRideHistory(String filePath);
        boolean importRideHistory(String filePath);
    }

}
