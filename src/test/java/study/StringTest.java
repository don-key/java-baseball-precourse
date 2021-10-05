package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 메소드를 활용하여 '1,2'를 ,로 분리, '1'을 ,로 분리 후 반환")
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");

        values = "1".split(",");
        assertThat(values).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)'를 substring 메소드를 활용하여 ()를 제거한 후 '1,2'를 반환")
    void substring() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 활용한 StringIndexOutOfBoundsException 발생 테스트")
    void charAt() {
        String value = "abc";
        assertThatThrownBy(() -> value.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(3))
                .withMessageMatching("String index out of range: 3");
    }

}
