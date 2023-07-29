package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        String fileName = "vehicles.txt";
        ControlStation station = new ControlStation(fileName);
        ControlStationApp app = new ControlStationApp();
        app.runApp(station);
    }
}
