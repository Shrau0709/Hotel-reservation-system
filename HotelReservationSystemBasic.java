import java.util.*;

class Room {
    int roomNumber;
    boolean isAvailable;
    double pricePerNight;

    Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }
}

public class HotelReservationSystemBasic {
    public static void main(String[] args) {
        Room[] rooms = {
            new Room(101, 100.0),
            new Room(102, 150.0)
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\nAvailable Rooms:");
                for (Room room : rooms) {
                    if (room.isAvailable) {
                        System.out.println("Room " + room.roomNumber + " - Rs" + room.pricePerNight);
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                sc.nextLine(); // Consume newline
                String guestName = sc.nextLine();
                System.out.print("Enter room number to book: ");
                int roomNumber = sc.nextInt();
                boolean roomFound = false;

                for (Room room : rooms) {
                    if (room.roomNumber == roomNumber) {
                        roomFound = true;
                        if (room.isAvailable) {
                            room.isAvailable = false;
                            System.out.println("Reservation confirmed for " + guestName + " in Room " + roomNumber);
                            System.out.println("Total cost: Rs" + room.pricePerNight);
                        } else {
                            System.out.println("Room is not available.");
                        }
                        break;
                    }
                }

                if (!roomFound) {
                    System.out.println("Invalid room number.");
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
