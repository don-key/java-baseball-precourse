package baseball.domain;

import baseball.view.OutputView;

import java.util.List;

public class Referee {

    private final OutputView outputView;

    public Referee() {
        outputView = new OutputView();
    }

    public boolean checkNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = checkStrike(computerNumbers, playerNumbers);
        int ball = checkBall(computerNumbers, playerNumbers);
        outputView.printCheckNumbers(strike, ball);
        if (strike == 3) {
            outputView.printEndGame();
            return true;
        } else {
            return false;
        }
    }

    private int checkStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;

        for (Integer computerNumber : computerNumbers) {
            strike += addStrike(computerNumbers.indexOf(computerNumber), computerNumber, playerNumbers);
        }

        return strike;
    }

    private int addStrike(int index, Integer computerNumber, List<Integer> playerNumbers) {
        if (playerNumbers.contains(computerNumber) && playerNumbers.get(index).equals(computerNumber)) {
            return 1;
        }
        return 0;
    }

    private int checkBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ball = 0;

        for (Integer computerNumber : computerNumbers) {
            ball += addBall(computerNumbers.indexOf(computerNumber), computerNumber, playerNumbers);
        }

        return ball;
    }

    private int addBall(int index, Integer computerNumber, List<Integer> playerNumbers) {
        if (playerNumbers.contains(computerNumber) && !playerNumbers.get(index).equals(computerNumber)) {
            return 1;
        }
        return 0;
    }

}
