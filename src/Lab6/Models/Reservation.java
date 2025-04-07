package Lab6.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private Visitor visitor;
    private LocalDate reservationTime;

    public Reservation() {}

    public Reservation(Visitor visitor, LocalDateTime reservationTime) {
        this.visitor = visitor;
        this.reservationTime = reservationTime.toLocalDate();
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public LocalDate getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDate reservationTime) {
        this.reservationTime = reservationTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "Відвідувач = " + visitor +
                ", Час резервування = " + reservationTime +
                '}';
    }
}
