package QuizApplication;

import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadSampleQuestions();
    }

    private void loadSampleQuestions() {
        questions.add(new Question(
            "What is the capital of France?",
            "Berlin", "Madrid", "Paris", "Rome",
            "C"
        ));

        questions.add(new Question(
            "Which language is used for Android development?",
            "Swift", "Kotlin", "Ruby", "JavaScript",
            "B"
        ));

        questions.add(new Question(
            "What is the output of 5 + 3?",
            "6", "8", "10", "9",
            "B"
        ));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int timeLimit = 30; // seconds
        long startTime = System.currentTimeMillis();

        for (Question q : questions) {
            q.displayQuestion();

            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine();

            if ((System.currentTimeMillis() - startTime) / 1000 > timeLimit) {
                System.out.println("⏱️ Time's up!");
                break;
            }

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\nYour Score: " + score + "/" + questions.size());
    }
}
