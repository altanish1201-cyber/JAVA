import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

interface TemperatureService extends Remote {
    double celsiusToFahrenheit(double celsius) throws RemoteException;
    double fahrenheitToCelsius(double fahrenheit) throws RemoteException;
}

class TemperatureServiceImpl extends UnicastRemoteObject implements TemperatureService {

    public TemperatureServiceImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        System.out.println("Request received: convert " + celsius + " C to F");
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) throws RemoteException {
        System.out.println("Request received: convert " + fahrenheit + " F to C");
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class TemperatureRMIServer {
    private static final int PORT = 1100;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("TemperatureService", new TemperatureServiceImpl());
            System.out.println("Temperature RMI Server is ready on port " + PORT + "...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

class TemperatureRMIClient {
    private static final int PORT = 1100;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", PORT);
            TemperatureService temp = (TemperatureService) registry.lookup("TemperatureService");
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            System.out.print("Enter temperature : ");
            double value = sc.nextDouble();

            if (choice == 1) {
                System.out.printf("%.2f C = %.2f F%n", value, temp.celsiusToFahrenheit(value));
            } else if (choice == 2) {
                System.out.printf("%.2f F = %.2f C%n", value, temp.fahrenheitToCelsius(value));
            } else {
                System.out.println("Invalid choice");
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
