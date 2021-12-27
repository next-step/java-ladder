package ladderstep4.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    @Test
    void 높이_1이상의_수로_생성가능하다_동등성가짐() {
        Assertions.assertThat(new Height(1)).isEqualTo(new Height(1));
    }

    @Test
    void 높이_생성_0이하의수를_가질수없다() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Height.INVALID_VALUE_MESSAGE);
    }
}
