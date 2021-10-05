package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void 컴퓨터_3자리_숫자_생성() {
        List<Integer> numbers = computer.getNumbers();
        assertThat(numbers.size()).isEqualTo(3);
    }

}