package at.ac.hcw;

import java.util.Scanner;


public class Sim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Anzahl der Käufer*innen und Verkäufer*innen: ");
        int numberOfTraders = scanner.nextInt();

        System.out.print("Anzahl der Handelsrunden: ");
        int numberOfRounds = scanner.nextInt();

        Market market = new Market(numberOfTraders);
        for (int round = 0; round < numberOfRounds; round++) {
            market.runRound();
        }
        market.showStatistics();
    }
}
