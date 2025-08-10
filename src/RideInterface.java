// Part 2 creating Interface
public interface RideInterface {

    boolean addVisitorToQueue(Visitor v);   //Method to add visitors to the queue
    Visitor removeVisitorFromQueue(); //Removing visitor
    void printQueue();       //Printing the queue

    void runOneCycle();     //Method to run the cycle for one time

    // History-related (LinkedList)
    boolean addVisitorToHistory(Visitor v);  //Using parameter of Visitor
    boolean checkVisitorFromHistory(Visitor v);  //Using parameter of Visitor

    int numberOfVisitors();
    void printRideHistory();

    // I/O
    boolean exportRideHistory(String filePath);
    boolean importRideHistory(String filePath);
}
