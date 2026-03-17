
public class UseCase7HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("=== Add-On Service Selection ===\n");

        String res1 = "Single Room-1";
        String res2 = "Suite Room-1";

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        AddOnService breakfast = new AddOnService("Breakfast", 15.0);
        AddOnService spa = new AddOnService("Spa", 50.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 25.0);

        serviceManager.addService(res1, breakfast);
        serviceManager.addService(res1, airportPickup);

        serviceManager.addService(res2, spa);

        serviceManager.printServices(res1);
        System.out.println();
        serviceManager.printServices(res2);
    }
}