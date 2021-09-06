package laddergame.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 높이는")
class HeightTest {

    @DisplayName("1 이상이다.")
    @Test
    void create() {
        assertThat(new Height(1)).isEqualTo(new Height(1));
    }

    @DisplayName("1 미만일 경우 예외 발생")
    @Test
    void moreThan0() {
        assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class);
    }

}
