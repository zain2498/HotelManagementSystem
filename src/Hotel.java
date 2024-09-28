import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Hotel {

    private String name;
    private Room[] rooms;
    private Customer[] customers;
    private Booking[] bookings;
    private int noOfRooms;

    public Hotel(String name, Room[] rooms, Customer[] customer) {
        this.name = name;
        this.rooms = rooms;
        this.customers = customer;
        noOfRooms = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }

    public void addCustomer(Customer customer) {
        IntStream.range(0, customers.length)
                .filter(i -> customers[i] == null)
                .findFirst()
                .ifPresentOrElse(
                        i -> customers[i] = customer,
                        () -> System.out.println("Sorry, Our Customer list is filled")
                );
    }
    public void addBooking(Booking booking) {
        IntStream.range(0, bookings.length)
                .filter(j -> bookings[j] == null)
                .findFirst()
                .ifPresentOrElse(
                        j -> bookings[j] = booking,
                        () -> System.out.println("Sorry all rooms are occupied there are no vacant rooms")
                );
    }
    public void addRoom(Room room) {

        if (noOfRooms >= rooms.length) {
            System.out.println("We are really sorry, There are no rooms available at the moment\n");
            return;
        }
        if (room.isBooked()) {
            System.out.println("Sorry you are late, This room is already booked by someone else\n");
            return;
        }
        rooms[noOfRooms] = room;
        noOfRooms++;
        System.out.println("Your room number " + room.getRoomNumber() + " and category " + room.getRoomType() + " is successfully added\n");
    }

    public void addRoom(String roomNumber, String roomType) {
        if (noOfRooms >= rooms.length) {
            System.out.println("We are really sorry, There are no rooms available at the moment\n");
            return;
        }
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setRoomType(roomType);

        rooms[noOfRooms] = room;
        noOfRooms++;
        System.out.println("Your room number " + room.getRoomNumber() + " and category " + room.getRoomType() + " is successfully added\n");
    }

    public Room[] roomAvailibility() {
        return Arrays.stream(rooms).filter(room -> !room.isBooked()).toArray(Room[]::new);
    }

    public void displayAvailableRooms() {
        Room[] availableRooms = roomAvailibility();

        if (availableRooms.length == 0) {
            System.out.println("\nSorry, There are no available rooms at the moment ");
        } else {
            System.out.println("\nAvailable Rooms are: ");
            Arrays.stream(availableRooms).forEach(room -> {
                System.out.println("Room:" + room.getRoomNumber() + " and Room type:" + room.getRoomType());
            });
        }
        System.out.println();
    }

}
