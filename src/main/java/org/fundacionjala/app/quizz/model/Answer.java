package org.fundacionjala.app.quizz.model;

import java.util.Arrays;
import java.util.Set;

public class Answer {
    private final Question question;
    private final Set<String> answers;

    public Answer(Question question, Set<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String toString() {
        String result = "Question: " + question.getTitle() + "\n" ;
        for(String answer: answers ){
            result += "Answer: " + answer;
        }
        return result;
    }
}
