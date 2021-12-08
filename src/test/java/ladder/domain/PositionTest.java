package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void create(int input) {
        assertThat(new Position(input)).isEqualTo(new Position(input));
        assertThat(new Position(input)).isNotEqualTo(new Position(input + 1));
    }
}
