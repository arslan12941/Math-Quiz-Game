import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            mathquiz mathQuiz = (mathquiz) registry.lookup("MathQuiz");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Math Quiz Game!");

            while (true) {
                String question = mathQuiz.getQuestion();
                System.out.println("\nQuestion: " + question);

                System.out.print("Your answer: ");
                int answer = scanner.nextInt();

                boolean isCorrect = mathQuiz.submitAnswer(answer);
                if (isCorrect) {
                    System.out.println("Correct! 🎉");
                } else {
                    System.out.println("Wrong! 😢");
                }

                int score = mathQuiz.getScore();
                System.out.println("Your score: " + score);

                System.out.print("Do you want to continue? (yes/no): ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }

            System.out.println("Thanks for playing! Your final score is: " + mathQuiz.getScore());
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}