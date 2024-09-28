public class VIPCustomer extends Customer{
    public VIPCustomer(String customerId, String name, String contactNumber) {
        super(customerId, name, contactNumber);
        this.bookedRooms= new Room[5];
    }
    @Override
    public String bookARoom(Room room) {
        return super.bookARoom(room);
    }
}
