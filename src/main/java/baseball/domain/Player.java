package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int NUMBER_SIZE = 3;
    private final InputView inputView;
    private final List<Integer> numbers = new ArrayList<>();

    public Player() {
        inputView = new InputView();
    }

    public void inputNumbers() {
        String stringNumbers = inputView.inputPlayerNumbers();
        addNumber(stringNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void addNumber(String stringNumbers) {
        validateString(stringNumbers);
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
        if(!isNumber(number) && isDuplicate(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(int number) {
        return (0 < number && number < 10);
    }

    private boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

}
