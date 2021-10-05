package model;


import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;


public class Order {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Customer customer;
    private Room  room;

    public long getTotalPrice(){
        long numOfDay=DAYS.between(checkIn,checkOut);
        long price=room.getPrice();
        return numOfDay*price;
    }

    public Order() {
    }

    public Order(LocalDate checkIn, LocalDate checkOut, Customer customer, Room room) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.customer = customer;
        this.room = room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
