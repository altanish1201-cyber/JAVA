import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface CalculatorService extends Remote {
    double add(double a, double b) throws RemoteException;
    double subtract(double a, double b) throws RemoteException;
    double multiply(double a, double b) throws RemoteException;
    double divide(double a, double b) throws RemoteException;
}

class CalculatorServiceImpl extends UnicastRemoteObject implements CalculatorService {

    public CalculatorServiceImpl() throws RemoteException {
        super();
    }

    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiply(double a, double b) throws RemoteException {
        return a * b;
    }

    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division by zero is not allowed");
        }
        return a / b;
    }
}

public class CalculatorRMIServer {
    private static final int PORT = 1099;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("CalculatorService", new CalculatorServiceImpl());
            System.out.println("Calculator RMI Server is ready on port " + PORT + "...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

class CalculatorRMIClient {
    private static final int PORT = 1099;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", PORT);
            CalculatorService calc = (CalculatorService) registry.lookup("CalculatorService");

            double a = 25, b = 5;
            System.out.println("Connected to remote Calculator Service");
            System.out.println("Addition       : " + a + " + " + b + " = " + calc.add(a, b));
            System.out.println("Subtraction    : " + a + " - " + b + " = " + calc.subtract(a, b));
            System.out.println("Multiplication : " + a + " * " + b + " = " + calc.multiply(a, b));
            System.out.println("Division       : " + a + " / " + b + " = " + calc.divide(a, b));
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
