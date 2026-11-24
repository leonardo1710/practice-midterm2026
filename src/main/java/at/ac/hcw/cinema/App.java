package at.ac.hcw.cinema;

import java.util.Scanner;

public class App {

    private Cinema cinema;
    private Scanner scanner;

    public static void main(String[] args) {
        /* 
        Seat s1 = new Seat(1, 900);

        s1.setPrice(23);
        Seat s2 = new Seat(2, 27);
        s1.reserve();
        s1.reserve();

        Cinema apollo = new Cinema(5);
        Cinema multiplex = new Cinema(1);

        Seat s3 = apollo.getSeat(2);
        System.out.println(s3);

        Seat s4 = apollo.getSeat(100);
        System.out.println(s4);

        Seat mySearchedSeat = apollo.getSeat(2);
        mySearchedSeat.reserve();
        
        apollo.getSeat(1).reserve();

        apollo.showSeats();

        System.out.println(apollo.getAvailableSeats());
        */

        App myApp = new App(10, new Scanner(System.in));

        int userInput = -1;
        
        do{
            System.out.println("=== Cinema Management ===");
            System.out.println("1 - Show seats");
            System.out.println(" 2... 3... 4.. 0 -> exit");

            userInput = myApp.scanner.nextInt();

            switch (userInput) {
                case 1:
                    myApp.cinema.showSeats();
                    break;
                case 2:
                    
                default:
                    break;
            }
            

        } while(userInput != 0);
       
    }

    public App(int numberOfSeats, Scanner scanner) {
        this.scanner = scanner;
        this.cinema = new Cinema(numberOfSeats);
    }
}

