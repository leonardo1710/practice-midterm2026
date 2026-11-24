package at.ac.hcw.cinema;

public class Seat {
    private int seatId;
    private double price;
    private boolean reserved;

    public Seat(int seatId, double price) {
        this.seatId = seatId;
        this.price = price;
    }

    public boolean isReserved(){
        return this.reserved;
    }

    public double getPrice() {
        return price;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setPrice(double price) {
        if(!this.reserved && price > 0){
            this.price = price;    
        }
        
    }

    public boolean reserve(){
        if(this.reserved){
            return false;
        } 

        this.reserved = true;
        return true;
    }

    public void cancelReservation(){
        this.reserved = false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String isReserved = "Reserved";
        if(!this.reserved){
            isReserved = "Available";
        }
        return "Seat " + this.seatId + ": " + isReserved;
    }
}
