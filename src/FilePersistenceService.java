import java.io.*;
import java.util.Map;

public class FilePersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
                writer.write(entry.getKey() + "-" + entry.getValue());
                writer.newLine();
            }
            System.out.println("Inventory saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    inventory.updateAvailability(roomType, count);
                }
            }
            System.out.println("Inventory loaded successfully from " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found. Starting with default inventory.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}