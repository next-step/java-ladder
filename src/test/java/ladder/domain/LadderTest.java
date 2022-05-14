package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @ParameterizedTest
    @NullSource
    void Ladder_라인들이_null_인_경우(List<Line> lines) {
        assertThatThrownBy(() -> new Ladder(lines)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    void create_사다리높이_1_미만인_경우(int height) {
        assertThatThrownBy(() -> Ladder.create(3, height, () -> true)).isInstanceOf(IllegalArgumentException.class);
    }
}