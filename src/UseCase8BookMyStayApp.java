import java.util.ArrayList;
import java.util.List;

public class UseCase8BookMyStayApp {

    public class BookingHistory {

        private List<Reservation> confirmedReservations;

        public BookingHistory() {
            confirmedReservations = new ArrayList<>();
        }

        public void addReservation(Reservation reservation) {
            confirmedReservations.add(reservation);
        }

        public List<Reservation> getConfirmedReservations() {
            return confirmedReservations;
        }
    }


    public class BookingReportService {

        public void generateReport(BookingHistory history) {

            System.out.println("Booking History and Reporting");
            System.out.println("Booking History Report");

            for (Reservation r : history.getConfirmedReservations()) {
                System.out.println("Guest: " + r.getGuestName() +
                        ", Room Type: " + r.getRoomType());
            }
        }
    }

    public static void main(String[] args) {

        UseCase8BookMyStayApp app = new UseCase8BookMyStayApp();

        BookingHistory history = app.new BookingHistory();
        BookingReportService report = app.new BookingReportService();


        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));


        report.generateReport(history);
    }
}