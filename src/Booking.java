import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {

    private String bookingId;
    private Customer customer;
    private Room[] rooms;
    private Date bookingDate;

    public Booking(String bookingId, Customer customer, Date bookingDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.bookingDate = bookingDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void roomBooking(){
        System.out.println();
    }

}
