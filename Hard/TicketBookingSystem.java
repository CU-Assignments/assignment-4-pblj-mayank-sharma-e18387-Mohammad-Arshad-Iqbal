class TicketCounter {
    private int availableSeats = 5;

    public synchronized void bookTicket(String customerName, int seatsRequested) {
        if (seatsRequested <= availableSeats) {
            System.out.println(customerName + " booked " + seatsRequested + " seat(s).");
            availableSeats -= seatsRequested;
        } else {
            System.out.println(customerName + " failed to book. Not enough seats.");
        }
    }
}

class BookingThread extends Thread {
    private TicketCounter counter;
    private String customerName;
    private int seatsRequested;

    public BookingThread(TicketCounter counter, String customerName, int seatsRequested) {
        this.counter = counter;
        this.customerName = customerName;
        this.seatsRequested = seatsRequested;
    }

    public void run() {
        counter.bookTicket(customerName, seatsRequested);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        BookingThread t1 = new BookingThread(counter, "VIP - Arshad", 2);
        BookingThread t2 = new BookingThread(counter, "Regular - John", 2);
        BookingThread t3 = new BookingThread(counter, "VIP - Keerthi", 1);
        BookingThread t4 = new BookingThread(counter, "Regular - Alice", 2);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
