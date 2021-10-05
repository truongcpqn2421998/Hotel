package model;

public class Room {
    private String type;
    private long price;
    private boolean status;

    public Room() {
    }

    public Room( String type, long price) {
        this.type = type;
        this.price = price;
        this.status = false;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
