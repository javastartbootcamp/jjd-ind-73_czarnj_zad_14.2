package pl.javastart.task;

import java.util.Queue;

public class ControlStation {
    private Queue<Vehicle> vehicles;
    private String fileName;
    private FileOperator operator = new FileOperator();

    public ControlStation(String fileName) {
        this.fileName = fileName;
        vehicles = operator.readVehicles(fileName);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.offer(vehicle);
    }

    public Vehicle readNextVehicle() {
        return vehicles.poll();
    }

    public void saveVehicles() {
        operator.saveVehicles(vehicles, fileName);
    }
}
