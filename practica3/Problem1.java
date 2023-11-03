package practica3;
import java.util.Scanner;

public class Problem1 {
    static class Ticket {
    private String movieName;
    private String showTime;
    private int roomNumber;
    private int availableSeats;

    public Ticket(String movieName, String showTime, int roomNumber, int availableSeats) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.roomNumber = roomNumber;
        this.availableSeats = availableSeats;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void reserveSeats(int numSeats) {
        availableSeats -= numSeats;
    }
}

static class Cinema {
    private Ticket[] tickets;

    public Cinema() {
        tickets = new Ticket[3];
        tickets[0] = new Ticket("Pelicula 1", "10:00 AM", 1, 20);
        tickets[1] = new Ticket("Pelicula 2", "02:00 PM", 2, 25);
        tickets[2] = new Ticket("Pelicula 3", "06:00 PM", 3, 16);
    }

    public void displayMovies() {
        System.out.println("Funciones disponibles:");
        for (int i = 0; i < tickets.length; i++) {
            System.out.println((i + 1) + ". " + tickets[i].getMovieName() + " - " + tickets[i].getShowTime() + " - Sala " + tickets[i].getRoomNumber() + " - Asientos disponibles: " + tickets[i].getAvailableSeats());
        }
    }

    public void bookTicket(int ticketIndex, int numSeats) {
        Ticket selectedTicket = tickets[ticketIndex];
        if (selectedTicket.getAvailableSeats() >= numSeats) {
            selectedTicket.reserveSeats(numSeats);
            String bookingCode = generateBookingCode();
            System.out.println("¡Reserva exitosa!");
            System.out.println("Película: " + selectedTicket.getMovieName());
            System.out.println("Horario: " + selectedTicket.getShowTime());
            System.out.println("Sala: " + selectedTicket.getRoomNumber());
            System.out.println("Asientos reservados: " + numSeats);
            System.out.println("Código de venta: " + bookingCode);
        } else {
            System.out.println("Lo sentimos, no hay suficientes asientos disponibles.");
        }
    }

    private String generateBookingCode() {
        // Lógica para generar un código de venta único
        // Puedes implementar tu propia lógica aquí, como usar un número aleatorio o generar un código basado en la fecha y hora actual.
        return "ABC123"; // Ejemplo de código de venta generado
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();

        System.out.print("Ingrese su nombre completo: ");
        String fullName = scanner.nextLine();
        System.out.print("Ingrese su número de teléfono: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.nextLine();

        cinema.displayMovies();

        System.out.print("Seleccione una función (1-3): ");
        int selectedFunction = scanner.nextInt();

        System.out.print("Ingrese la cantidad de asientos que desea reservar (máximo 4): ");
        int numSeats = scanner.nextInt();

        cinema.bookTicket(selectedFunction - 1, numSeats);

        scanner.close();
    }
}
}
