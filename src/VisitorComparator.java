public class VisitorComparator {

    import java.util.Comparator;

    // PART 4B: Comparator using at least TWO fields.
// Here we sort by lastName, then firstName; if tied, VIP over Standard by ticketType.
    public class VisitorComparator implements Comparator<Visitor> {
        @Override
        public int compare(Visitor a, Visitor b) {
            int last = a.getLastName().compareToIgnoreCase(b.getLastName());
            if (last != 0) return last;

            int first = a.getFirstName().compareToIgnoreCase(b.getFirstName());
            if (first != 0) return first;

            // Secondary criteria: VIP ahead of others (reverse so VIP is "smaller")
            return a.getTicketType().compareToIgnoreCase(b.getTicketType());
        }
    }

}
