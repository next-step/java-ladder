package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void RIGHT_이후_LEFT_생성(boolean isLast) {
        Direction before = Direction.RIGHT;
        Direction direction = Direction.of(before, isLast);
        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @ParameterizedTest
    @CsvSource({
            "RIGHT, LEFT",
            "LEFT, STRAIGHT",
            "STRAIGHT, STRAIGHT"
    })
    void 마지막_값_테스트(Direction before, Direction result) {
        Direction direction = Direction.of(before, true);
        assertThat(direction).isEqualTo(result);
    }
}
