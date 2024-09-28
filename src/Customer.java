import java.util.*;

public class Customer {

    private String customerId;
    private String name;
    private String contactNumber;
    protected Room[] bookedRooms;
    private int totalBookedRooms;
    private String message = "";

    public Customer(String customerId, String name, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.bookedRooms = new Room[3];
        totalBookedRooms = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String bookARoom(Room room) {
        if (totalBookedRooms >= 3) {
            message = "Sorry you cannot book more than 3 rooms";
            return message;
        }

        if (room.isBooked()) {
            message = "Sorry, The room you have selected is already booked";
            return message;
        }
        room.setBooked(true);
        bookedRooms[totalBookedRooms] = room;
        totalBookedRooms++;
        message = "You have Successfully booked a " + room.getRoomType() + " room: " + room.getRoomNumber()+
        " under the following information "+
        "\n Name: " + getName()+
        "\n CNIC: "+getCustomerId()+
        "\n Contact Number: "+getContactNumber();
        System.out.println(message);
        System.out.println();
        return message;
    }

    public String cancelRoomBooking(String roomNumber) {
        if (totalBookedRooms == 0) {
            return message = "Sorry, there are no room booking,All rooms are available";
        }

        Optional<Room> optionalRoom = Arrays.stream(bookedRooms)
                .filter(room -> room.getRoomNumber().equals(roomNumber))
                .findFirst();

        if (optionalRoom.isPresent()) {
            Room cancelRoom = optionalRoom.get();
            cancelRoom.setBooked(false);
            message = "You have successfully cancelled your room. The following is your roomId: " + cancelRoom.getRoomNumber() +"\n";

            for (int i = 0; i < totalBookedRooms; i++) {
                if (bookedRooms[i].getRoomNumber().equals(cancelRoom.getRoomNumber())) {
                    for (int j = i; j < totalBookedRooms - 1; j++) {
                        bookedRooms[j] = bookedRooms[j + 1];
                    }
                    totalBookedRooms = totalBookedRooms - 1;
                    bookedRooms[totalBookedRooms] = null;
                    break;
                }
            }
            System.out.println(message);
            return message;
        } else {
            message = "The roomId you provide is not valid,Please enter a valid roomID \n";
            System.out.println(message);
            return message ;
        }
    }
    public void displayBookRooms() {
        if (totalBookedRooms == 0) {
            System.out.println("There are no room bookings \n");
        } else {
            System.out.println("The Following Room bookings are:");
            Arrays.stream(bookedRooms)
                    .filter(Objects::nonNull)
                    .forEach(bookRoom -> System.out.println("Room number: " + bookRoom.getRoomNumber() +" is booked against this CNIC "+ getCustomerId()+ " \n"));
        }
    }
}
