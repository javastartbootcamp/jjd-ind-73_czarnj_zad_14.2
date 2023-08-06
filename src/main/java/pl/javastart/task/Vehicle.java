package pl.javastart.task;

public class Vehicle {
    private String type;
    private String brand;
    private String model;
    private int productionYear;
    private double milage;
    private String vin;

    public Vehicle(String type, String brand, String model, int productionYear, double milage, String vin) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.milage = milage;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return type + " " + brand + " " + model + " " + productionYear + " " + milage + " " + vin;
    }

    public String toCsv() {
        return type + "," + brand + "," + model + "," + productionYear + "," + milage + "," + vin;
    }
}
