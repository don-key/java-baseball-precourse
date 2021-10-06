package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballConstants.*;

public class Computer {

    private final List<Integer> numbers = new ArrayList<>();

    public Computer() {
        generateNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void initNumbers() {
        numbers.clear();
        generateNumbers();
    }

    private void generateNumbers() {
        while (numbers.size() < NUMBER_SIZE) {
            addNumber(Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX));
        }
    }

    private void addNumber(int number) {
        if (!isDuplicate(number)) {
            numbers.add(number);
        }
    }

    private boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

}
