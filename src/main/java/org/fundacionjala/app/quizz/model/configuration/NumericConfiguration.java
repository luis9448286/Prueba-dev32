package org.fundacionjala.app.quizz.model.configuration;


import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class NumericConfiguration extends QuestionConfiguration {

    public NumericConfiguration() {
        super(false, ValidatorType.REQUIRED, ValidatorType.MIN, ValidatorType.MAX);
    }
        
    @Override
    public String convertValue(String value) {
        try {
            int value_int = Integer.parseInt(value);
            return value;
        } catch (Exception e) {
            return "You must enter a integer number";
        }
    }
}
