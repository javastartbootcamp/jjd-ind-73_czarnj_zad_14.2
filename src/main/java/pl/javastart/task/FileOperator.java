package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FileOperator {

    public Queue<Vehicle> readVehicles(String fileName) {
        Queue<Vehicle> vehicles = new LinkedList<>();
        try (var br = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                Vehicle vehicle = parseVehicle(nextLine);
                vehicles.offer(vehicle);
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        return vehicles;
    }

    public void saveVehicles(Queue<Vehicle> vehicles, String fileName) {
        try (var bw = new BufferedWriter(new FileWriter(fileName))) {
            while (vehicles.peek() != null) {
                String vehicleWithoutWhiteSpaces = vehicles.poll().toCsv();
                bw.write(vehicleWithoutWhiteSpaces + "\n");
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    private Vehicle parseVehicle(String line) {
        String[] splittedLine = line.split(",");
        String type = splittedLine[0];
        String brand = splittedLine[1];
        String model = splittedLine[2];
        int productionYear = Integer.parseInt(splittedLine[3]);
        double milage = Double.parseDouble(splittedLine[4]);
        String vin = splittedLine[5];
        return new Vehicle(type, brand, model, productionYear, milage, vin);
    }
}
