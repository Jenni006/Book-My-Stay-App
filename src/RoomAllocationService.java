public class RoomAllocationService {

    private int singleCount = 5;
    private int doubleCount = 3;
    private int suiteCount = 2;

    // Allocate a room based on reservation
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        String allocatedRoomId = "";

        switch (roomType) {
            case "Single":
                if (singleCount > 0) {
                    singleCount--;
                    allocatedRoomId = "Single-" + (5 - singleCount);
                }
                break;
            case "Double":
                if (doubleCount > 0) {
                    doubleCount--;
                    allocatedRoomId = "Double-" + (3 - doubleCount);
                }
                break;
            case "Suite":
                if (suiteCount > 0) {
                    suiteCount--;
                    allocatedRoomId = "Suite-" + (2 - suiteCount);
                }
                break;
        }

        if (!allocatedRoomId.isEmpty()) {
            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName()
                    + ", Room ID: " + allocatedRoomId);

            // Update centralized inventory
            int currentCount = inventory.getRoomAvailability().get(roomType);
            inventory.updateAvailability(roomType, currentCount - 1);
        }
    }
}