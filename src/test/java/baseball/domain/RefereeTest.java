package baseball.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    public static final java.util.List<Integer> COMPUTER_NUMBERS = Arrays.asList(4, 2, 5);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,1,0", "4,5,6,1,1", "7,8,9,0,0", "4,2,5,3,0"})
    void 기능목록_입력에_대한_결과_테스트(int firstNumber, int secondNumber, int thirdNumber, int strike, int ball) {
        Score score = referee.checkScore(COMPUTER_NUMBERS, Arrays.asList(firstNumber, secondNumber, thirdNumber));
        assertThat(strike).isEqualTo(score.getStrike());
        assertThat(ball).isEqualTo(score.getBall());
    }

}