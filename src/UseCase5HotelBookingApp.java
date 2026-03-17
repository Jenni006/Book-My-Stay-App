
public class UseCase5HotelBookingApp{

    public static void main(String[] args) {


        System.out.println("=== Booking Request Queue ===\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        System.out.println("Processing booking requests in order:");
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            System.out.println("Guest: " + next.getGuestName() + ", Room Type: " + next.getRoomType());
        }

        System.out.println("\nAll booking requests processed.");
    }
}