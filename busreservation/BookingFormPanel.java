package busreservation;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

public class BookingFormPanel extends JFrame {

    public BookingFormPanel(JFrame parentFrame, ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        setTitle("Book a Ticket");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Form Fields
        JLabel nameLabel = new JLabel("Passenger Name:");
        JTextField nameField = new JTextField();

        JLabel busNoLabel = new JLabel("Bus Number:");
        JTextField busNoField = new JTextField();

        JLabel dateLabel = new JLabel("Date (dd-MM-yyyy):");
        JTextField dateField = new JTextField();

        JButton bookButton = new JButton("Book");
        JButton cancelButton = new JButton("Cancel");

        // Add components
        add(nameLabel);
        add(nameField);

        add(busNoLabel);
        add(busNoField);

        add(dateLabel);
        add(dateField);

        add(bookButton);
        add(cancelButton);

        // Button Actions
        bookButton.addActionListener(e -> {
            String name = nameField.getText();
            int busNo;
            try {
                busNo = Integer.parseInt(busNoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid bus number!");
                return;
            }

            String dateInput = dateField.getText();

            try {
                Booking booking = new Booking(name, busNo, dateInput);
                if (booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                    JOptionPane.showMessageDialog(this, "Booking Confirmed!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Bus is full on that date!");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format!");
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }
}
