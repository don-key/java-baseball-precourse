package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 유효한_문자입력_시_정상_테스트() {
        String value = "123";
        player.inputNumbers(value);
        List<Integer> numbers = player.getNumbers();

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(1)).isEqualTo(2);
        assertThat(numbers.get(2)).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "000", "asdfgasdf", "1sa", "1", "sab###", "#", "100", "111"})
    void 유효하지않은_문자입력_시_에러발생(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> player.inputNumbers(input));
    }

}