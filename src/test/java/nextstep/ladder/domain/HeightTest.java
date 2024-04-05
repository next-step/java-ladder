package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    void height() {
        assertThat(new Height(1)).isEqualTo(new Height(1));
    }

    @Test
    void heightException() {
        assertThatThrownBy(() -> new Height(-100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상이어야 합니다.");
    }

}
