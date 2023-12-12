package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @Test
    @DisplayName("사다리의 높이는 1이하이면 예외가 발생한다")
    void height_exception() {
        Assertions.assertThatThrownBy(() -> {
            new Height(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}