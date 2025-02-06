package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Rent {
    private Client client;
    private Vehicle vehicle;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private double totalValue;

    public Rent(Client client, Vehicle vehicle, LocalDate dateStart , LocalDate dateEnd) {
        if (!vehicle.getStatus().equals("Available")) {
            throw new IllegalArgumentException("O veículo já está alugado!");
        }

        setClient(client);
        setVehicle(vehicle);
        setDateStart(dateStart);
        setDateEnd(dateEnd);
        setTotalValue(calculateValue());
        markRented();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rent rent)) return false;
        return Double.compare(getTotalValue(), rent.getTotalValue()) == 0 && Objects.equals(getClient(), rent.getClient()) && Objects.equals(getVehicle(), rent.getVehicle()) && Objects.equals(getDateStart(), rent.getDateStart()) && Objects.equals(getDateEnd(), rent.getDateEnd());
    }

    @Override
    public String toString() {
        return "Aluguel: [" +
                "Cliente= " + getClient() +
                ", Veículo= " + getVehicle() +
                ", Data de início= " + getDateStart() +
                ", Data de fim= " + getDateEnd() +
                ", Total = R$" + getTotalValue() +
                ']';
    }

    public double calculateValue(){
        long days = ChronoUnit.DAYS.between(getDateStart(), getDateEnd());
        double valueDaily = 70.0; // Value for day
        return days * valueDaily;
    }

    public void markReturned(){
        getVehicle().setStatus("Available");
    }

    public void markRented(){
        if(getVehicle().getStatus().equals("Available")){
            getVehicle().setStatus("Rented");
        } else {
            System.out.println("O veículo não pode ser alugado!");
        }
    }

    public void showDetails() {
        System.out.println("Cliente: " + client.getName());
        System.out.println("Veículo: " + vehicle.getModel() + " | Placa: " + vehicle.getPlate());
        System.out.println("Data Início: " + getDateStart());
        System.out.println("Data Fim: " + getDateEnd());
        System.out.println("Valor Total: R$" + getTotalValue());
    }
}
