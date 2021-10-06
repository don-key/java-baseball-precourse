package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballConstants.*;

public class Player {

    private List<Integer> numbers;

    public void inputNumbers(String stringNumbers) {
        addNumber(stringNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void addNumber(String stringNumbers) {
        validateString(stringNumbers);
        numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int number = Character.getNumericValue(stringNumbers.charAt(i));
            validateNumber(number);
            numbers.add(number);
        }
    }

    private void validateString(String stringNumber) {
        checkLength(stringNumber);
    }

    private void checkLength(String stringNumber) {
        if (stringNumber.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(int number) {
        if (!isNumber(number) || isDuplicate(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(int number) {
        return (NUMBER_MIN <= number && number <= NUMBER_MAX);
    }

    private boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

}
