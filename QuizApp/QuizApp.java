//*****************************This Is Abhijeet Kiran Bhosale Project*****************************//
package QuizApp;

import java.util.Scanner;

public class QuizApp {
    private static Scanner scanner = new Scanner(System.in);
    private static int userScore = 0;

    public static void main(String[] args) {
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                new String[]{"A. Berlin", "B. Paris", "C. Rome", "D. Madrid"}, 1);

        displayQuestion(question1);
        submitAnswer(question1, getUserInput());
    }

    private static void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());

        for (int i = 0; i < question.getOptions().length; i++) {
            System.out.println(question.getOptions()[i]);
        }
    }

    private static void submitAnswer(QuizQuestion question, int userAnswer) {
        if (userAnswer == question.getCorrectAnswer()) {
            System.out.println("Correct!");
            userScore++;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
        }

        // Add logic to move to the next question or end the quiz
    }

    private static int getUserInput() {
        System.out.print("Enter your answer (1-4): ");
        return scanner.nextInt();
    }
}
//*****************************This Is Abhijeet Kiran Bhosale Project*****************************//