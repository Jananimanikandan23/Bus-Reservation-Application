package busreservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BusReservationApp extends JFrame {
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public BusReservationApp() {
        // Initialize dummy data
        buses.add(new Bus(1, true, 1));
        buses.add(new Bus(2, false, 2));
        buses.add(new Bus(3, true, 1));

        // Window settings
        setTitle("Bus Reservation System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel with buttons
        JPanel menuPanel = new JPanel();
        JButton viewBtn = new JButton("View Buses");
        JButton bookBtn = new JButton("Book Ticket");
        JButton exitBtn = new JButton("Exit");

        menuPanel.add(viewBtn);
        menuPanel.add(bookBtn);
        menuPanel.add(exitBtn);
        add(menuPanel, BorderLayout.CENTER);

        // Button actions
        viewBtn.addActionListener(e -> {
            new BusListPanel(this, buses);
        });

        bookBtn.addActionListener(e -> {
            new BookingFormPanel(this, bookings, buses);
        });

        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new BusReservationApp();
    }
}
