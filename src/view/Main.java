package view;

import manager.ManagerHotel;
import model.Customer;
import model.Order;
import model.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        ArrayList<Room> roomArrayList = new ArrayList<>();
        System.out.println("Enter number of room you want to manager:");
        int numberOfRoom = num.nextInt();
        for (int i = 0; i < numberOfRoom; i++) {
            System.out.println("Room "+(i+1));
            System.out.println("Enter room type:");
            String type = str.nextLine();
            System.out.println("Enter room's price:");
            long price = num.nextLong();
            roomArrayList.add(new Room(type, price));
        }
        System.out.println("Enter number of Customer:");
        int numberOfCustomer = num.nextInt();
        for (int i = 0; i < numberOfCustomer; i++) {
            System.out.println("Customer "+(i+1));
            System.out.println("Enter Customer's name:");
            String name = str.nextLine();
            System.out.println("Enter Customer's Date of Birth:");
            String birth = str.nextLine();
            System.out.println("Enter Customer's ID:");
            String id = str.nextLine();
            customerArrayList.add(new Customer(name, birth, id));
        }
        ManagerHotel hotel = new ManagerHotel(roomArrayList, customerArrayList);
        ArrayList<Order> orders = new ArrayList<>();
        hotel.setOrderArrayList(orders);
        System.out.println("Enter number of Order:");
        int numOrder=num.nextInt();
        for (int i = 0; i < numOrder; i++) {
            System.out.println(i+1+":");
            hotel.addOrder( customerArrayList, roomArrayList, orders);
        }
        hotel.displayOrder(orders);
        long allTotal=hotel.getAllTotal();
        System.out.println("Total Price:"+allTotal);

        hotel.checkIdToGetMoney(orders);
    }


}

