package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public static final String RESTART_GAME = "1";
    public static final String END_GAME = "2";
    private final Player player;
    private final Referee referee;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGame() {
        player = new Player();
        referee = new Referee();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        boolean endGame = true;
        while (endGame) {
            endGame = play();
        }
    }

    private boolean play() {
        boolean isThreeStrike = false;

        Computer computer = new Computer();
        while (!isThreeStrike) {
            try {
                outputView.printInputPlayerNumber();
                player.inputNumbers();
            } catch (IllegalArgumentException iae) {
                outputView.printError();
            }
            isThreeStrike = referee.checkNumbers(computer.getNumbers(), player.getNumbers());
        }

        return checkRestartGame();
    }

    private boolean checkRestartGame() {
        String input = "";
        boolean isRestartGame = false;
        while (!isRestartGame) {
            input = inputView.inputIsRestartGame();
            isRestartGame = validateRestartInput(input);
        }
        return RESTART_GAME.equals(input);
    }

    private boolean validateRestartInput(String input) {
        return RESTART_GAME.equals(input) || END_GAME.equals(input);
    }

}
