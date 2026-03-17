import java.util.*;

public class UseCase6HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Room Allocation Processing ===\n");

        RoomInventory inventory = new RoomInventory();

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Abhi", "Single Room"));
        bookingQueue.addRequest(new Reservation("Subha", "Single Room"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite Room"));

        RoomAllocationService allocationService = new RoomAllocationService();

        while (bookingQueue.hasPendingRequests()) {
            Reservation nextReservation = bookingQueue.getNextRequest();
            allocationService.allocateRoom(nextReservation, inventory);
        }

        System.out.println("\nAll bookings processed.");
    }
}