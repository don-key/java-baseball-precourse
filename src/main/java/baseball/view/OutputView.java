package baseball.view;

public class OutputView {

    private static final String INPUT_PLAYER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크 ";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String ERROR_INVAILD_VALUE = "[ERROR] 잘못된 값을 입력하였습니다.";
    private static final String FINISH_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printInputPlayerNumber() {
        System.out.println(INPUT_PLAYER_NUMBER);
    }

    public void printError() {
        System.out.println(ERROR_INVAILD_VALUE);
    }

    public void printCheckScore(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if (strike > 0) {
            sb.append(strike);
            sb.append(STRIKE);
        }

        if (ball > 0) {
            sb.append(ball);
            sb.append(BALL);
        }

        if (strike == 0 && ball == 0) {
            sb.append(NOTHING);
        }

        System.out.println(sb);
    }

    public void printEndGame() {
        System.out.println(FINISH_GAME);
    }
}
