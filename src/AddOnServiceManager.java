import java.util.*;

public class AddOnServiceManager {

    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);
        if (services == null) return 0.0;

        double total = 0.0;
        for (AddOnService s : services) {
            total += s.getCost();
        }
        return total;
    }

    public void printServices(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);
        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services for reservation: " + reservationId);
            return;
        }

        System.out.println("Add-on services for " + reservationId + ":");
        for (AddOnService s : services) {
            System.out.println("- " + s.getServiceName() + " ($" + s.getCost() + ")");
        }
        System.out.println("Total Add-on Cost: $" + calculateTotalServiceCost(reservationId));
    }
}
