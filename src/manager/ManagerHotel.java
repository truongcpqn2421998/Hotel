package manager;


import model.Customer;
import model.Room;
import model.Order;

import java.util.ArrayList;

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

}
