package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void name(int position) {
        Position.from(position);
    }

    @Test
    void name2() {
        assertThatThrownBy(() -> Position.from(-1))
                        .isInstanceOf(IllegalArgumentException.class);
    }
}
