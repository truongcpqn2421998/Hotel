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
            addOrder( customerArrayList, roomArrayList, orders);
        }
        displayOrder(orders);
        long allTotal=hotel.getAllTotal();
        System.out.println("Total Price:"+allTotal);

        checkIdToGetMoney(orders);
    }
    private static void checkIdToGetMoney(ArrayList<Order> orders) {
        Scanner str=new Scanner(System.in);
        String check=null;
        long totalPrice=0;
        do {
            System.out.println("Enter the ID to find the amount to be paid by the customer:");
            String findID=str.nextLine();
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getCustomer().getID().equals(findID)) {
                    check=orders.get(i).getCustomer().getName();
                    totalPrice+=orders.get(i).getTotalPrice();
                }
            }
            if(check!=null){
                System.out.println(check+" must paid "+totalPrice);
            }
            if(check==null){
                System.out.println("Not found ID");
            }
        }while (check==null);
    }

    private static void displayOrder(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Customer"+(i+1));
            System.out.println(
                    orders.get(i).getCustomer().toString()
            );
            System.out.println(
                    orders.get(i).getRoom().toString()
            );
        }
    }

    private static void addOrder(ArrayList<Customer> customerArrayList, ArrayList<Room> roomArrayList, ArrayList<Order> orders) {
        Scanner num=new Scanner(System.in);
        String customer=null;
        do {
            System.out.println("Enter Customer' name want to Order:");
            String name = num.nextLine();
            for (int i = 0; i < customerArrayList.size(); i++) {
                if (customerArrayList.get(i).getName().equals(name)) {
                    customer = customerArrayList.get(i).getName();
                    int indexRoom=findRoom(roomArrayList);
                    System.out.println("Enter checkIn day:");
                    int dayIn = num.nextInt();
                    System.out.println("Enter checkIn month:");
                    int monthIn = num.nextInt();
                    System.out.println("Enter checkIn year:");
                    int yearIn = num.nextInt();
                    System.out.println("Enter checkOut day");
                    int dayOut = num.nextInt();
                    System.out.println("Enter checkOut month");
                    int monthOut = num.nextInt();
                    System.out.println("Enter checkOut year");
                    int yearOut = num.nextInt();
                    LocalDate in=LocalDate.of(yearIn,monthIn,dayIn);
                    LocalDate out=LocalDate.of(yearOut,monthOut,dayOut);
                    orders.add(new Order(in, out, customerArrayList.get(i), roomArrayList.get(indexRoom)));
                }
            }
            if(customer==null){
                System.out.println("This customer does not exist");
            }
        }while (customer==null);
    }

    private static int findRoom( ArrayList<Room> roomArrayList) {
        Scanner str=new Scanner(System.in);
        int index=-1;
        do{
            System.out.println("Enter Room's type:");
            String roomType = str.nextLine();
            for (int i = 0; i < roomArrayList.size(); i++) {
                if (roomArrayList.get(i).getType().equals(roomType)){
                index=i;
                }
            }
            if (index==-1) {
                System.out.println("This room type is not available in the hotel");
            }
        }while (index==-1);
        return index;
    }
}

