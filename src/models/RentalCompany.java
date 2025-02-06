package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentalCompany {
    private final List<Vehicle> vehicles;
    private final List<Rent> rents;

    public RentalCompany() {
        this.vehicles = new ArrayList<>();
        this.rents = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addRent(Rent rent) {
        rent.markRented();
        this.rents.add(rent);
    }

    public void finishRent(Rent rent) {
        rent.markReturned();
        this.rents.remove(rent);
    }

    public void listRents() {
        System.out.println("Alugueis em andamento:");
        if (this.rents.isEmpty()) {
            System.out.println("Não há nenhum aluguel em andamento registrado!");
        } else {
            for (Rent rent : rents) {
                if(Objects.equals(rent.getVehicle().getStatus(), "Rented")) {
                    System.out.println(rent);
                }
            }
        }
    }

}
