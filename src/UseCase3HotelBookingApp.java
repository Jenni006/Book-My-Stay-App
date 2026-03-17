import java.util.Map;

public class UseCase3HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay - Inventory Setup ===\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display room details
        System.out.println("Single Room Details:");
        single.displayRoomDetails();

        System.out.println("\nDouble Room Details:");
        doubleRoom.displayRoomDetails();

        System.out.println("\nSuite Room Details:");
        suite.displayRoomDetails();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("\n=== Room Availability ===");

        Map<String, Integer> availability = inventory.getRoomAvailability();

        for (Map.Entry<String, Integer> entry : availability.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}