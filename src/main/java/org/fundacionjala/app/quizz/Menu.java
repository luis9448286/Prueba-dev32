package org.fundacionjala.app.quizz;

import java.util.Map;
import java.util.HashMap;

import org.fundacionjala.app.quizz.console.QuizUIHandler;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;
import org.fundacionjala.app.quizz.console.util.InputReader;

public class Menu {

    private Quiz quiz;
    private QuizAnswers quizAnswers;

    public Menu() {
        this.quiz = null;
        this.quizAnswers = null;
    }

    public boolean process() {
        showMainMenu();
        char option = InputReader.readOption();
        boolean shouldExit = false;
        try {
            Map<Character, Runnable> commands = new HashMap<>();
            commands.put('1', () -> quiz = QuizUIHandler.createQuiz());
            commands.put('2', () -> fillQuiz());
            commands.put('3', () -> showQuiz());
            commands.get(option).run();
            
        } catch (Exception e) {
            System.out.println("closing");
            shouldExit = true;
        }


        System.out.println(System.lineSeparator());
        return shouldExit;
    }

    private void showQuiz() {
        if (quiz == null || quizAnswers == null) {
            System.out.println("No filled quiz available, you must create and fill a quiz");
            return;
        }

        QuizUIHandler.showQuiz(quizAnswers);
    }

    private void fillQuiz() {
        if (quiz == null) {
            System.out.println("No quiz available, you must create first a quiz");
            return;
        }

        quizAnswers = QuizUIHandler.fillQuiz(quiz);
    }

    private void showMainMenu() {
        System.out.println("Quizc - A command quiz utility");
        System.out.println("======================================");
        System.out.println("1. Create quiz");
        System.out.println("2. Fill quiz");
        System.out.println("3. Show quiz");
        System.out.println("4. Exit");
        System.out.println("======================================");
    }
}
