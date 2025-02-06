import models.Client;
import models.Rent;
import models.Vehicle;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("João Silva", "123.456.789-00", "99999-9999");
        Vehicle vehicle = new Vehicle("Toyota Corolla", "ABC-1234", 2022);

        LocalDate start = LocalDate.of(2024, 9, 1);  // Data de início
        LocalDate end = LocalDate.of(2024, 9, 5);  // Data de devolução

        Rent aluguel = new Rent(client, vehicle, start, end);
        aluguel.showDetails();
    }
}