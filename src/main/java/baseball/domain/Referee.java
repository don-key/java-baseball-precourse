package baseball.domain;

import java.util.List;

public class Referee {

    public Referee() {
    }

    public Score checkScore(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = checkStrike(computerNumbers, playerNumbers);
        int ball = checkBall(computerNumbers, playerNumbers);
        return new Score(strike, ball);
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
