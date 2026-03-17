import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds;

    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();

        // Check if room type is available
        Integer available = inventory.getRoomAvailability().get(roomType);
        if (available == null || available <= 0) {
            System.out.println("No rooms available for type: " + roomType + " for guest: " + reservation.getGuestName());
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Update allocated rooms
        allocatedRoomIds.add(roomId);

        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        assignedRoomsByType.get(roomType).add(roomId);

        // Reduce inventory
        inventory.updateAvailability(roomType, available - 1);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int counter = 1;
        String roomId;
        do {
            roomId = roomType + "-" + counter;
            counter++;
        } while (allocatedRoomIds.contains(roomId));
        return roomId;
    }
}