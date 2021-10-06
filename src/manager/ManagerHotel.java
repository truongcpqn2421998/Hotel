package manager;


import model.Customer;
import model.Room;
import model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerHotel {
    ArrayList<Customer> customerArrayList=new ArrayList<>();
    ArrayList<Room> roomArrayList=new ArrayList<>();
    ArrayList<Order> orderArrayList=new ArrayList<>();

    public  ManagerHotel(ArrayList<Room> roomArrayList,ArrayList<Customer> customerArrayList){
        this.customerArrayList=customerArrayList;
        this.roomArrayList=roomArrayList;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    public ArrayList<Room> getRoomArrayList() {
        return roomArrayList;
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        this.roomArrayList = roomArrayList;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public void addNewRoom(Room room){
        roomArrayList.add(room);
    }
    public void addNewCustomer(Customer customer){
        customerArrayList.add(customer);
    }

    public long getAllTotal(){
        long total=0;
        for (Order order: orderArrayList
        ) {
            total+=order.getTotalPrice();
        }
        return total;
    }
    public void checkIdToGetMoney(ArrayList<Order> orders) {
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
    public void displayOrder(ArrayList<Order> orders) {
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
    public void addOrder(ArrayList<Customer> customerArrayList, ArrayList<Room> roomArrayList, ArrayList<Order> orders) {
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
    public int findRoom( ArrayList<Room> roomArrayList) {
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
