package ladder;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성된다")
    void success() {
        Line line = LineFactory.generate(5);
        assertThatNoException()
            .isThrownBy(() -> Ladder.of(List.of(line)));
    }

    @Test
    @DisplayName("빈 Line이라면 사다리가 정상적으로 생성되지 않는다")
    void name() {
        assertThatThrownBy(() -> Ladder.of(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class);

    }
}
