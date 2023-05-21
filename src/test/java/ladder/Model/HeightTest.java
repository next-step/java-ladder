package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @Test
    @DisplayName("높이는 숫자여야 함")
    public void height_not_number() {
        assertThatThrownBy(() -> new Height("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("높이는 양수여야 함")
    public void height_not_positive() {
        assertThatThrownBy(() -> new Height("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("높이 정상리턴")
    public void height_positive() {
        String input = "6";

        int expected = 6;
        int actual = new Height(input).height();

        assertThat(actual).isEqualTo(expected);
    }
}