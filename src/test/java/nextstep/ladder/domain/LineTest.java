package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 생성성공(int size) {
        assertThat(Line.of(size, () -> true)).isInstanceOf(Line.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void width_길이_예외처리(int size) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Line.of(size, () -> true));
    }

}
