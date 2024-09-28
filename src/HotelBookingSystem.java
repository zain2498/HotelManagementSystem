public class HotelBookingSystem {
    public static void main(String[] args) {

        System.out.println("-----------------------------------------------------------------");
        System.out.println("-------------->      Good Evening Sir/Madam      <---------------");
        System.out.println("----------------------Welcome to the hotel-----------------------");
        System.out.println("-----------------------------------------------------------------");

       Customer[] customers = new Customer[15];
       Booking[] bookings = new Booking[15];

       Hotel hotel = new Hotel("The Great Grand Palace",new Room[3],customers);
       addRoomsInHotel(hotel);
       hotel.setBookings(bookings);

       HotelManagementSystem hotelManagementSystem = new HotelManagementSystem(hotel);
       hotelManagementSystem.begin();
    }
    private static void addRoomsInHotel(Hotel hotel){
        Room room1 = new Room();
        room1.setRoomType("Standard");
        room1.setRoomNumber("001");
        hotel.addRoom(room1);

        Room room2 = new Room();
        room2.setRoomType("Deluxe");
        room2.setRoomNumber("002");
        hotel.addRoom(room2);

        Room room3 = new Room();
        room3.setRoomType("Suite");
        room3.setRoomNumber("003");
        hotel.addRoom(room3.getRoomNumber(),room3.getRoomType());
    }
}