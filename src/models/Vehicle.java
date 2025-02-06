package models;

import java.util.Objects;

public class Vehicle {
    private String model;
    private String plate;
    private int year;
    private String status;

    public Vehicle(String model, String plate, int year) {
        setModel(model);
        setPlate(plate);
        setYear(year);
        setStatus("Available");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(plate, vehicle.plate);
    }

    public void showInfo() {
        System.out.println("Modelo: " + getModel() + "\nPlaca: " + getPlate() + "\nAno: " + getYear());
    }
}
