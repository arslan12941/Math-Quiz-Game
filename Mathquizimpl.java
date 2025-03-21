import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Random;

public class Mathquizimpl extends UnicastRemoteObject implements mathquiz {
    private int score = 0;
    private int currentAnswer = 0;
    private final Random random = new Random();

    protected Mathquizimpl() throws RemoteException {
        super();
    }

    @Override
    public String getQuestion() throws RemoteException {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        String operator = getRandomOperator();

        switch (operator) {
            case "+":
                currentAnswer = a + b;
                break;
            case "-":
                currentAnswer = a - b;
                break;
            case "*":
                currentAnswer = a * b;
                break;
            case "/":
                currentAnswer = a / b;
                break;
        }

        return "What is " + a + " " + operator + " " + b + "?";
    }

    @Override
    public boolean submitAnswer(int answer) throws RemoteException {
        if (answer == currentAnswer) {
            score++;
            return true;
        }
        return false;
    }

    @Override
    public int getScore() throws RemoteException {
        return score;
    }

    private String getRandomOperator() {
        String[] operators = {"+", "-", "*", "/"};
        return operators[random.nextInt(operators.length)];
    }
}