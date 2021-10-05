package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final InputView inputView;
    private final List<Integer> numbers = new ArrayList<>();

    public Player() {
        inputView = new InputView();
    }

    public void inputNumbers() {
        String stringNumbers = inputView.inputPlayerNumbers();
        if(stringNumbers.length() != 3) {
            //TODO ERROR 메세지 추가
            return;
        }

        for (int i = 0; i < 3; i++) {
            addNumber(Character.getNumericValue(stringNumbers.charAt(i)));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void addNumber(int number) {
        if(!validateNumber(number)){
            numbers.add(number);
        }
    }

    private boolean validateNumber(int number) {
        return isNumber(number) && !isDuplicate(number);

    }

    private boolean isNumber(int number) {
        return (0 < number && number < 10);
    }

    private Boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

}
