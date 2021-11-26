package nextstep.ladder.domain.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("입력 값이 음수면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] value: {0}")
    @ValueSource(ints = {-1, -10000})
    void create_negative_thrownException(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(value))
                .withMessage(Position.NEGATIVE_ERROR_MESSAGE);
    }

    @DisplayName("좌우 이동")
    @ParameterizedTest(name = "[{index}] direction: {0}, value: {1}, expectedValue: {2}")
    @CsvSource(value = {
            "LEFT, 1, 0",
            "RIGHT, 1, 2"
    })
    void move_leftAndRight(Direction direction, int value, int expectedValue) {
        Position position = new Position(value);
        assertThat(position.move(direction)).isEqualTo(new Position(expectedValue));
    }

    @DisplayName("입력 값 보다 작지 않으면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] value: {0}, other: {1}")
    @CsvSource({
            "1, 0",
            "11234, 1000"
    })
    void checkLessThan_notLessThan_thrownException (int value, int other) {
        Position position = new Position(value);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> position.checkLessThan(other))
                .withMessageContaining(Position.NOT_LESS_THAN_ERROR_MESSAGE);
    }
}
