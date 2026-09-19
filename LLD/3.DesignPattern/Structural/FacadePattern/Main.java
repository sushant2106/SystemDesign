
class PaymentService{

    public void makePayment(String accountId,double amount){

        System.out.println("Payment of Rupees" + amount + " successful for account " +  accountId);

    }
}

class SeatReservationService{

    public void reserveSeat(String movieId,String seatNumber){
        System.out.println("Seat " + seatNumber + " reserved for movie " + movieId);
    }
}

class NotifcationService{
    public void sendBookingConfirmation(String userEmail){
        System.out.println("Booking confimration send to " + userEmail);
    }
}

class LoyaltyPointService{
    public void addPoints(String accountId,double points){
        System.out.println(points + " loyalty points added to account " + accountId);
    }
}

class TicketService{
    public  void generateTicket(String movieId,String seatNumber){
        System.out.println("Ticket generated for movie " + movieId + ", Seat: "+seatNumber);;
    }
}

class MovieBookingFacade{

    private  PaymentService paymentService;
    private  SeatReservationService seatReservationService;
    private  NotifcationService notifcationService;
    private LoyaltyPointService loyaltyPointService;
    private TicketService ticketService;


    public  MovieBookingFacade(){
        this.paymentService=new PaymentService();
        this.seatReservationService=new SeatReservationService();
        this.notifcationService=new NotifcationService();
        this.loyaltyPointService=new LoyaltyPointService();
        this.ticketService=new TicketService();

    }

    public  void bookMovieTicket(String accountId,String movieId,String seatNumber,String userEmail,double points){
        paymentService.makePayment(accountId, points);
        seatReservationService.reserveSeat(movieId, seatNumber);
        ticketService.generateTicket(movieId, seatNumber);
        loyaltyPointService.addPoints(accountId, points);
        notifcationService.sendBookingConfirmation(userEmail);

        System.out.println("Movie ticket Booking Completed sucessfully ...");
    }
}

public class Main {

    public static void main(String[] args) {

        MovieBookingFacade movieBookingFacade=new MovieBookingFacade();
        movieBookingFacade.bookMovieTicket(null, null, null, null, 0);
        
    }
}