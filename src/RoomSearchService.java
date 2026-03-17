import java.util.Map;

public class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get("Single") > 0) {
            System.out.println("\nSingle Room Available: " + availability.get("Single"));
            singleRoom.displayRoomDetails();
        }

        if (availability.get("Double") > 0) {
            System.out.println("\nDouble Room Available: " + availability.get("Double"));
            doubleRoom.displayRoomDetails();
        }

        if (availability.get("Suite") > 0) {
            System.out.println("\nSuite Room Available: " + availability.get("Suite"));
            suiteRoom.displayRoomDetails();
        }
    }
}