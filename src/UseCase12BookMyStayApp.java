import java.util.Scanner;

public class UseCase12BookMyStayApp{

    public static void main(String[] args) {

        System.out.println("Booking System with Data Persistence & Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();
        Scanner scanner = new Scanner(System.in);

        String filePath = "inventory_data.txt";

        // Load inventory from file at startup
        persistenceService.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("Current Inventory:");
        inventory.getRoomAvailability().forEach((roomType, count) ->
                System.out.println(roomType + ": " + count));

        // Example: Modify inventory (simulate bookings)
        System.out.print("Enter room type to book: ");
        String roomType = scanner.nextLine();

        if (inventory.isRoomAvailable(roomType)) {
            int count = inventory.getRoomAvailability().get(roomType);
            inventory.updateAvailability(roomType, count - 1);
            System.out.println("Booking confirmed for room type: " + roomType);
        } else {
            System.out.println("Room not available or invalid type.");
        }

        // Save inventory after booking
        persistenceService.saveInventory(inventory, filePath);

        // Show updated inventory
        System.out.println("Updated Inventory:");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + ": " + count));

        scanner.close();
    }
}