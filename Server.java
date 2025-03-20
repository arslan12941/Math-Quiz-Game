import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Mathquizimpl mathQuiz = new Mathquizimpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("MathQuiz", mathQuiz);
            System.out.println("Math Quiz Server is ready!");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}