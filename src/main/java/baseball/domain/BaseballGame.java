package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public static final String RESTART_GAME = "1";
    public static final String END_GAME = "2";
    public static final int THREE_STRIKE = 3;
    private final Player player;
    private final Computer computer;
    private final Referee referee;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGame() {
        player = new Player();
        computer = new Computer();
        referee = new Referee();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        boolean endGame = false;
        while (!endGame) {
            endGame = play();
        }
    }

    private boolean play() {
        boolean isThreeStrike = false;
        while (!isThreeStrike) {
            try {
                inputPlayerNumbers();

                Score score = checkScore();
                printCheckScore(score);

                isThreeStrike = isThreeStrike(score);
            } catch (IllegalArgumentException iae) {
                printError();
            }
        }

        return checkRestartGame();
    }

    private Score checkScore() {
        return referee.checkScore(computer.getNumbers(), player.getNumbers());
    }

    private void inputPlayerNumbers() {
        outputView.printInputPlayerNumber();
        player.inputNumbers(inputView.inputPlayerNumbers());
    }

    private void printCheckScore(Score score) {
        outputView.printCheckScore(score.getStrike(), score.getBall());
    }

    private boolean isThreeStrike(Score score) {
        if (score.getStrike() == THREE_STRIKE) {
            outputView.printEndGame();
            return true;
        } else {
            return false;
        }
    }

    private boolean validateRestartInput(String input) {
        return RESTART_GAME.equals(input) || END_GAME.equals(input);
    }

    private boolean checkRestartGame() {
        String input = "";
        boolean inputCheck = false;

        while (!inputCheck) {
            input = inputView.inputIsRestartGame();
            inputCheck = validateRestartInput(input);
        }

        if (END_GAME.equals(input)) {
            return true;
        } else {
            computer.initNumbers();
            return false;
        }
    }

    private void printError() {
        outputView.printError();
    }

}
