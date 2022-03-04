package menu;

import service.ReservationService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public void displayMainMenu() {
        boolean state;
        while (state = true) {
            System.out.println("Welcome to the Hotel Reservation Application\n");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------------------------");
            System.out.println("Please type a number for menu");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Date checkInDate = null;
                    Date checkOutDate = null;
                    do {
                        System.out.println("Please enter the check-in date.(yyyy-MM-dd)");
                        Scanner checkIn = new Scanner(System.in);
                        String dateString_1 = checkIn.next();
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //因為有unhandled exception所以IDE強迫加try, catch
                        try {
                            checkInDate = formatter.parse(dateString_1);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            System.out.println("Wrong date type");
                        }
                        System.out.println("Please enter the check-out date.(yyyy-MM-dd)");
                        Scanner checkOut = new Scanner(System.in);
                        String dateString_2 = checkOut.next();
                        try {
                            checkOutDate = formatter.parse(dateString_2);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            System.out.println("Wrong date type");
                        }
                    } while (ReservationService.getInstance().findRooms(checkInDate, checkOutDate) == null);
                    ReservationService.getInstance().findRooms(checkInDate, checkOutDate);
                    System.out.println("Which room would you like to reserve?");
                    Scanner roomNumber = new Scanner(System.in);
                    String input = roomNumber.next();
                    System.out.println();

            }
        }
    }
}
