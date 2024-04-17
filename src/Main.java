import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Flight> flights = new ArrayList<>();

        Flight airIndia = new Flight();
        Flight airAsia = new Flight();


        flights.add(airIndia);
        flights.add(airAsia);

        int userFlightId;
        int passengerId=0;
        Flight userFlight = null;
        boolean flag=false;
        boolean userChoice=true;
        while (userChoice) {
            System.out.println("Available flights!");
            for(Flight flight : flights){
                System.out.println("Flight no:" + flight.getFightNo());
            }
            System.out.println("Enter your flight number to start!!");

            userFlightId= sc.nextInt();

            for(Flight flight : flights){
                if(flight.getFightNo() == userFlightId){
                    flag=true;
                    userFlight=flight;
                }

            }

            if(flag){
                System.out.println("Your requested Flight available");
                System.out.println("--------------------------");
                System.out.println("1.booking");
                System.out.println("2.Cancel");
                System.out.println("3.details");
                System.out.println("4.Exit");
                System.out.println("--------------------------");
                int choice=sc.nextInt();

                switch (choice) {
                    case 1 : {
                        System.out.println("booking process started!");
                        System.out.println("Enter your name:");
                        String name = sc.next();
                        System.out.println("Enter no of tickets needed:");
                        int tickets = sc.nextInt();
                        Passenger passenger = new Passenger(name,tickets,userFlightId,++passengerId);
                        int totalPrice =  userFlight.booking(passenger);
                        if(totalPrice == 0) {
                            System.out.println("Tickets not available!");
                            break;
                        }
                        System.out.println("Total price:" + totalPrice);
                        System.out.println("Booked sucessfully!");
                        System.out.println("--------------------------");
                        break;
                    }
                    case 2 : {
                        System.out.println("Cancel process started!");
                        System.out.println("Enter the passenger id:");
                        int cancellerId = sc.nextInt();
                        int seats = userFlight.cancel(cancellerId);
                        System.out.println("Total seats after cancelling:" + seats);
                        System.out.println("Cancellation doone sucessfully!");
                        System.out.println("--------------------------");
                        break;
                    }
                    case 3 : {
                        System.out.println("details process started!");
                        userFlight.details(userFlightId);
                        break;
                    }
                    case 4 : {
                        System.out.println("4.Exit");
                        userChoice=false;
                        break;
                    }

                }

            }
            else {
                System.out.println("Flight not available");
                break;
            }

        }
    }
}