package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {
    private static ReservationService instance;
    private ReservationService() {}
    public static ReservationService getInstance() {
        if(instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }
    private static Map<String, IRoom> roomMap = new HashMap<String, IRoom>();
    private static Set<Reservation> reservationSet = new HashSet<Reservation>();

    public void addRoom(IRoom room) {
        roomMap.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId) {
        return roomMap.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationSet.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> bookedRoom = new ArrayList<IRoom>();
        for (Reservation var : reservationSet) {
            if (var.getCheckInDate() == checkInDate && var.getCheckOutDate() == checkOutDate) {
                bookedRoom.add(var.getRoom());
            }
        }
        if (bookedRoom == null) {
            System.out.println("Can not find the booked room");
        }
        return bookedRoom;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> reservations = new ArrayList<Reservation>();
        for (Reservation var : reservationSet) {
            if (var.getCustomer() == customer) {
                reservations.add(var);
            }
        }
        if (reservations == null) {
            System.out.println("Can not find the reservation record");
        }
        return reservations;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservationSet) {
            System.out.println(reservation);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return roomMap.values();
    }
}
