package at.ac.hcw.cinema;

import java.util.Locale;

public class Cinema {
    private Seat[] seats;

    public Cinema(int numberOfSeats) {
        if (numberOfSeats < 1) {
            numberOfSeats = 1;
        }

        this.seats = new Seat[numberOfSeats];

        for (int i = 0; i < seats.length; i++) {
            int price = 10;

            if( (i + 1) % 2 == 0){
                price = 12;
            }

            seats[i] = new Seat(i + 1, price);
        }
        /* 
        seats[1] = new Seat(2, 10);
        seats[2] = new Seat(3, 100);
        seats[3] = new Seat(4, 10);
        seats[4] = new Seat(5, 100);
        */
    }

    public Seat getSeat(int searchId){

        for (Seat seat : this.seats) {
            if(seat.getSeatId() == searchId){
                return seat;
            }
        }

        return null;
    }

    public int getAvailableSeats(){
        int count = 0;

        for (Seat seat : this.seats) {
            if(!seat.isReserved()){
                count++;
            }
        }

        return count;
    }

    public int getTotalRevenue(){
        int revenue = 0;

        for (Seat seat : this.seats) {
            if(seat.isReserved()){
                revenue += seat.getPrice();
            }
        }

        return revenue;
    }

    public void showSeats(){
        for (Seat seat : seats) {
            //System.out.println(seat + " (" + seat.getPrice() + " EUR)");

            System.out.println(String.format(Locale.CANADA,"%s (%.2f EUR)", seat, seat.getPrice()));
        }
    }
}
