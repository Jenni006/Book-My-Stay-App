import java.util.Scanner;

public class UseCase10BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation.");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        String reservationId = "Single-1";
        String roomType = "Single Room";

        cancellationService.registerBooking(reservationId, roomType);

        cancellationService.cancelBooking(reservationId, inventory);

        cancellationService.showRollbackHistory();
    }
}