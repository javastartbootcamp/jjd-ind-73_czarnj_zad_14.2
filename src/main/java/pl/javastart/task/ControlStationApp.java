package pl.javastart.task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlStationApp {
    private static final int EXIT = 0;
    private static final int ADD_CAR = 1;
    private static final int READ_CAR = 2;
    private Scanner scanner = new Scanner(System.in);

    public void runApp(ControlStation station) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case EXIT -> {
                    station.saveVehicles();
                    shouldContinue = false;
                }
                case ADD_CAR -> {
                    Vehicle vehicle = getVehicleFromUser();
                    station.addVehicle(vehicle);
                }
                case READ_CAR -> {
                    Vehicle vehicle = station.readNextVehicle();
                    if (vehicle != null) {
                        System.out.println("Pojazd do kontroli: " + vehicle);
                    } else {
                        System.out.println("Brak pojazdów w kolejce");
                    }
                }
                default -> System.out.println("Podaj opcję z menu");
            }
        }
    }

    private void showMenu() {
        System.out.println("Wybierz opcję:");
        System.out.println("1 - dodaj pojazd do kolejki");
        System.out.println("2 - zabierz kolejny pojazd na przegląd");
        System.out.println("0 - zakończ program");
    }

    private Vehicle getVehicleFromUser() {
        System.out.println("Podaj typ: ");
        String type = scanner.nextLine();
        System.out.println("Podaj markę: ");
        String brand = scanner.nextLine();
        System.out.println("Podaj model: ");
        String model = scanner.nextLine();
        System.out.println("Podaj rok produkcji: ");
        int productionYear = scanner.nextInt();
        System.out.println("Podaj przebieg: ");
        double milage = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj vim: ");
        String vim = scanner.nextLine();
        return new Vehicle(type, brand, model, productionYear, milage, vim);
    }
}
