package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Computer {

    private List<Integer> numbers = new ArrayList<>();

    public Computer() {
        initNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void initNumbers() {
        while (numbers.size() < 3) {
            addNumber(Randoms.pickNumberInRange(1, 9));
        }
    }

    private void addNumber(int number) {
        if(!isDuplicate(number)) {
            numbers.add(number);
        }
    }

    private Boolean isDuplicate(int number) {
        return numbers.contains(number);
    }

}
