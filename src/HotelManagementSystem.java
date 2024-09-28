import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class HotelManagementSystem {
    private final Hotel hotel;
    private final Scanner scanner;

    public HotelManagementSystem(Hotel hotel) {
        this.hotel = hotel;
        this.scanner = new Scanner(System.in);
    }

    public void begin() {
        while (true) {
            displayHotelServices();
            int usrRequest = scanner.nextInt();
            handleUserRequest(usrRequest);
        }
    }

    private void displayHotelServices() {
        System.out.println("Welcome to the Hotel " + hotel.getName());
        System.out.println("1. Display Available Rooms");
        System.out.println("2. Book Room for Regular Customer");
        System.out.println("3. Book Room for VIP Customer");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Display the Occupied Rooms");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private void handleUserRequest(int userChoice) {
        switch (userChoice) {
            case 1:
                hotel.displayAvailableRooms();
                break;
            case 2:
                roomBooking(false);
                break;
            case 3:
                roomBooking(true);
                break;
            case 4:
                cancelRoomBooking();
                break;
            case 5:
                displayOccupiedRooms();
                break;
            case 6:
                System.out.println("Thank you for coming to our hotel " + hotel.getName() +"\n");
                scanner.close();
                System.out.println(0);
            default:
                System.out.println("Please enter a valid option");
                break;
        }
    }
    private void roomBooking(boolean isVIPCustomer) {
        Customer registeredCustomer = handleCustomerRegistration(isVIPCustomer);
        System.out.println("Please tell us which room you want to book, by entering a room number ? ");
        String roomNumber = scanner.next();
        Room bookARoom = findRoomByRoomNumber(roomNumber);

        if(bookARoom != null){
            String bookingMessage = registeredCustomer.bookARoom(bookARoom);
            if(bookingMessage.contains("Successfully booked")){
                Booking booking = new Booking(roomNumber,registeredCustomer,new Date());
                hotel.addBooking(booking);
            }else {
                System.out.println("Sorry!, The room number you have provided is not found in our system");
            }
        }
    }

    public Customer handleCustomerRegistration(boolean isVIPCustomer){
        System.out.println("Enter your government issued cnic ");
        String customerId = scanner.next();
        Customer existingCustomer = findByCustomerCNIC(customerId);

        if(existingCustomer!=null){
            return existingCustomer;
        }else {
            return customerRegistration(isVIPCustomer, customerId);
        }
    }
    private Customer customerRegistration(boolean isVIPCustomer, String customerId) {

        System.out.println("Enter your name ");
        String name = scanner.next();
        System.out.println("Please provide your contact number for complete registration");
        String contactNumber = scanner.next();

        Customer customer = isVIPCustomer ? new VIPCustomer(customerId, name, contactNumber) : new Customer(customerId, name, contactNumber);
        hotel.addCustomer(customer);
        return customer;
    }

    private Room findRoomByRoomNumber(String roomNo) {
        return Arrays.stream(hotel.getRooms())
                .filter(room -> room.getRoomNumber().equals(roomNo))
                .findFirst()
                .orElse(null);
    }

    private void cancelRoomBooking() {
        System.out.println("Please enter your cnic in order to cancel the room");
        String customerId = scanner.next();
        System.out.println("Please enter a room number you have booked.");
        String roomNumber = scanner.next();
        Customer customerInfo = findByCustomerCNIC(customerId);
        if(customerInfo != null){
            customerInfo.cancelRoomBooking(roomNumber);
        }else {
            System.out.println("Sorry, The CNIC you have provided have no room booking found in our system");
        }
    }
    private void displayOccupiedRooms(){
        System.out.println("Please enter your CNIC in order to find a room booked against it.");
        String customerId = scanner.next();
        Customer customerInfo = findByCustomerCNIC(customerId);
        customerInfo.displayBookRooms();
    }
    private Customer findByCustomerCNIC(String cnic){
        if(hotel.getCustomers() == null || hotel.getCustomers().length ==0){
            return null;
        }
       return Arrays.stream(hotel.getCustomers())
                .filter(customer -> customer!=null && customer.getCustomerId().equals(cnic))
                .findFirst()
                .orElse(null);
    }

}
