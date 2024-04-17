import java.util.HashMap;

public class Flight {
    static int fid=0;
    int fightNo;
    int totalSeats;
    int ticketPrice;
    HashMap<Integer,Passenger> bookedPassengers;

    public int getFightNo() {
        return fightNo;
    }

    public void setFightNo(int fightNo) {
        this.fightNo = fightNo;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    Flight(){
        totalSeats = 50;
        fightNo=++fid;
        ticketPrice=1000;
        bookedPassengers = new HashMap<>();
    }

    public int  booking (Passenger passenger) {
        int flightId = passenger.fightNo;
        if(this.totalSeats < passenger.tickets) {
            return 0;
        }
        this.totalSeats -= passenger.tickets;
        int totalPrice = this.ticketPrice*passenger.tickets;
        bookedPassengers.put(passenger.id, passenger);
        return totalPrice;
    }

    public void details(int flightId) {
        System.out.println("Flight number:" + flightId);
        System.out.println("Available tickets" + this.totalSeats);
        for(int x : bookedPassengers.keySet()) {
            System.out.println("--------------------------");
            System.out.println("passenger name:"+bookedPassengers.get(x).name);
            System.out.println("Flight number:"+bookedPassengers.get(x).fightNo);
            System.out.println("total ticktes:"+bookedPassengers.get(x).tickets);
            System.out.println("--------------------------");
        }
    }

    public int cancel(int cancellerId) {
        Passenger cancelPass = bookedPassengers.get(cancellerId);
        this.totalSeats+=cancelPass.tickets;
        bookedPassengers.remove(cancellerId);
        return totalSeats;
    }
}
