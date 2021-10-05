package baseball.view;

public class OutputView {

    public void printInputPlayerNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printError() {
        System.out.println("[ERROR] 잘못된 값을 입력하였습니다.");
    }

    public void printCheckNumbers(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if(strike > 0) {
            sb.append(strike);
            sb.append("스트라이크 ");
        }

        if(ball > 0) {
            sb.append(ball);
            sb.append("볼");
        }

        if(strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    public void printEndGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
