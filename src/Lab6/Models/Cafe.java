package Lab6.Models;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cafe {
    private int availableTables;
    private Queue<Visitor> waitingQueue = new LinkedList<>();
    private PriorityQueue<Reservation> reservations = new PriorityQueue<>(
            (r1, r2) -> r1.getReservationTime().compareTo(r2.getReservationTime())
    );

    public Cafe() {}

    public Cafe(int availableTables) {
        this.availableTables = availableTables;
    }

    public int getAvailableTables() {
        return availableTables;
    }

    public void setAvailableTables(int availableTables) {
        this.availableTables = availableTables;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return availableTables == cafe.availableTables;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(availableTables);
    }

    public void arrive(Visitor visitor, LocalDateTime arrivalTime) {
        System.out.println(arrivalTime + ": " + visitor.getName() + " " +
                visitor.getSurname() + " прийшов до кафе.");
        if (availableTables > 0) {
            availableTables--;
            System.out.println(arrivalTime + ": " + visitor.getName() + " " +
                    visitor.getSurname() + " зайняв столик.");
        }

        else {
            waitingQueue.offer(visitor);
            System.out.println(arrivalTime + ": " + visitor.getName() + " " +
                    visitor.getSurname() + " став у чергу.");
        }
    }

    public void makeReservation(Visitor visitor, LocalDateTime reservationTime) {
        reservations.offer(new Reservation(visitor, reservationTime));
        System.out.println(LocalDateTime.now() + ": " + visitor.getName() + " " +
                visitor.getSurname() + " зробив резерв на " + reservationTime + ".");
    }

    public void checkReservations(LocalDateTime currentTime) {
        Reservation nextReservation = reservations.peek();
        while (nextReservation != null && !waitingQueue.isEmpty() &&
                nextReservation.getReservationTime()
                        .isBefore(ChronoLocalDate.from(currentTime.plusMinutes(1)))) {
            Visitor reservedVisitor = nextReservation.getVisitor();
            System.out.println(currentTime + ": Прибув резерв для " + reservedVisitor.getName() + " " +
                    reservedVisitor.getSurname() + ".");

            if (availableTables > 0) {
                availableTables--;
                System.out.println(currentTime + ": " + reservedVisitor.getName() + " " +
                        reservedVisitor.getSurname() + " зайняв зарезервований столик.");
            }

            else {
                Visitor firstInQueue = waitingQueue.poll();
                if (firstInQueue != null) {
                    availableTables++;
                    System.out.println(currentTime + ": " + firstInQueue.getName()
                            + " " + firstInQueue.getSurname() + " звільнив столик для "
                            + " " + reservedVisitor.getName() + " " + reservedVisitor.getSurname() + ".");
                    availableTables--;
                    System.out.println(currentTime + ": " + reservedVisitor.getName()
                            + " " + reservedVisitor.getSurname() + " зайняв зарезервований столик.");
                    waitingQueue.offer(firstInQueue);
                }

                else {
                    availableTables--;
                    System.out.println(currentTime + ": " + reservedVisitor.getName()
                            + " " + reservedVisitor.getSurname() + " зайняв зарезервований столик.");
                }
            }

            reservations.poll();
            nextReservation = reservations.peek();
        }
    }

    public void tableFreed(LocalDateTime currentTime) {
        if (!waitingQueue.isEmpty()) {
            Visitor nextVisitor = waitingQueue.poll();
            availableTables++;
            System.out.println(currentTime + ": Столик звільнився. " + nextVisitor.getName()
                    + " " + nextVisitor.getSurname() + " зайняв його.");
            availableTables--;
        }

        else {
            availableTables++;
            System.out.println(currentTime + ": Столик звільнився.");
        }
    }

    public void displayQueue(LocalDateTime currentTime) {
        if (!waitingQueue.isEmpty()) {
            System.out.println(currentTime + ": Черга очікування: " + waitingQueue);
        }

        else {
            System.out.println(currentTime + ": Черга очікування порожня.");
        }

        if (!reservations.isEmpty()) {
            System.out.println(currentTime + ": Заплановані резерви: " + reservations);
        }

        else {
            System.out.println(currentTime + ": Запланованих резервів немає.");
        }

        System.out.println(currentTime + ": Вільних столиків: " + availableTables);
    }
}