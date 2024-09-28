Student ID : 24K-8225
Student Name : Syed Zain Badaruddin
Course : Applied Programming

			                                            HOTEL MANAGEMENT SYSTEM

1. Problem Solving Approach
The system is designed to manage the room booking process of a hotel. The main approach is implemented by creating several classes:

Class Room: To handle room details and its availability.
Class Customer: To handle customer information and room bookings of Regular as well as VIP customers.
Class Hotel: To handle rooms, customers, and their bookings.
Class HotelManagementSystem : Provides the main entry point from where all the hotel services get executed.
The system handles array for multilessor and customers. Functional programming constructions were applied in searching for rooms or customers according to requirements.

2. Extra Features
VIP Customer Service: The system facilitates the booking of up to 5 rooms for VIP customers. A normal customer can book up to 3 rooms.
Checking Availability of Rooms: The system indicates the rooms that are available and the ones booked.
Functional Programming: Streams and lambda expressions have been used everywhere possible.

begin()
The program's main loop calling the display hotel services and dealing with the user request based on him selecting a particular functionality.

displayHotelServices() :
Displays the user services list the hotel provides such as booking a room, canceling a booking, displaying available rooms or occupied ones, etc.

handleUserRequest(int userChoice):
Method starts dealing with the selected service of the hotel by the user like booking a room, canceling a reservation, etc. it ends the program

roomBooking(boolean isVIPCustomer):
It deals with the room booking for both normal and VIP customers. It captures the customer, gets the room number and allocates the room if it is available.
 
handleCustomerRegistration(Boolean isVIPCustomer):
this function is checking if the user input the cnic is already registered or not if yes then it simply returns the same user that the user is previously entered else it registers a new customer.

customerRegistration(boolean isVIPCustomer):
It captures a new customer by getting info such as CNIC, name and contact number. It forms either a regular customer or a VIP customer based on the flag supplied.
 
findRoomByRoomNumber(String roomNo):
Looks for a hotel room by its room number and returns the corresponding room object if exists.
 
cancelRoomBooking():
Removes any booking of a particular customer. It asks the user to input a CNIC and then it asks for the room number, then deletes the booking if exists.
 
displayOccupiedRooms():
Shows the rooms currently occupied by the client. The user is asked to enter their CNIC and this method then iterates over all rooms which are occupied by that user
public Room findByCustomerCNIC(String cnic):
It searches a customer from the customer list of the hotel by their CNIC. It returns the customer object if the match found is there, otherwise it throws the exception while integrated.