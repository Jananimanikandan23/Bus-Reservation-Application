package busreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking {
    private String passengerName;
    private int busNo;
    private Date date;

    public Booking(String name, int busNo, String dateInput) throws ParseException {
        this.passengerName = name;
        this.busNo = busNo;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.date = formatter.parse(dateInput);
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
                break;
            }
        }

        int booked = 0;
        for (Booking b : bookings) {
            if (b.busNo == this.busNo && b.date.equals(this.date)) {
                booked++;
            }
        }

        return booked < capacity;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getBusNo() {
        return busNo;
    }

    public Date getDate() {
        return date;
    }
}
