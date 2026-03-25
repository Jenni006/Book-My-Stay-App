import java.util.*;

public class CancellationService {

    private Stack<String> releasedReservationIds;

    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedReservationIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("No such reservation found: " + reservationId);
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        int currentCount = inventory.getRoomAvailability().getOrDefault(roomType, 0);
        inventory.updateAvailability(roomType, currentCount + 1);

        releasedReservationIds.push(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        System.out.println("Updated " + roomType + " Availability: " + inventory.getRoomAvailability().get(roomType));
    }

   public void showRollbackHistory() {
        System.out.println("Rollback History (Most Recent First):");
        for (String reservationId : releasedReservationIds) {
            System.out.println("Released Reservation ID: " + reservationId);
        }
    }
}