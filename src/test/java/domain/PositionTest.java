package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    @DisplayName("매개변수로 음수가 넘어오면 IllegalArgumentException")
    void valueOf_exception() {
        Assertions.assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> Position.valueOf(-1)),
                () -> assertThatNoException().isThrownBy(() -> Position.valueOf(0))
        );
    }

    @ParameterizedTest
    @MethodSource("beforePositionAndPointDirectionAndAfterPosition")
    @DisplayName("PointDirection에 따라 Position을 변환")
    void move(Position beforPosition, PointDirection pointDirection, Position afterPosition) {
        assertThat(beforPosition.move(pointDirection)).isEqualTo(afterPosition);
    }

    static Stream<Arguments> beforePositionAndPointDirectionAndAfterPosition() {
        return Stream.of(
                Arguments.arguments(Position.valueOf(1), PointDirection.LEFT, Position.valueOf(0)),
                Arguments.arguments(Position.valueOf(1), PointDirection.RIGHT, Position.valueOf(2)),
                Arguments.arguments(Position.valueOf(1), PointDirection.DOWN, Position.valueOf(1))
        );
    }
}
