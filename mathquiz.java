import java.rmi.Remote;
import java.rmi.RemoteException;

public interface mathquiz extends Remote {
    String getQuestion() throws RemoteException;
    boolean submitAnswer(int answer) throws RemoteException;
    int getScore() throws RemoteException;
}