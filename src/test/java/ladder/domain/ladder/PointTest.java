package ladder.domain.ladder;

import ladder.domain.result.Movement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointTest {
    @ParameterizedTest
    @CsvSource("true,true")
    @DisplayName("before/after은 동시에 true일 수 없다.")
    void point(boolean before, boolean after) {
        assertThatThrownBy(() -> Point.of(before, after))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point 전/후로 가로 라인이 존재할 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("pointAndMovements")
    @DisplayName("Point 상태에 따라 Movement를 반환한다.")
    void point_return_movement(Point point, Movement expectedMovement) {
        assertThat(point.move()).isEqualTo(expectedMovement);
    }

    static Stream<Arguments> pointAndMovements() {
        return java.util.stream.Stream.of(
                arguments(Point.of(true, false), Movement.LEFT),
                arguments(Point.of(false, false), Movement.GO),
                arguments(Point.of(false, true), Movement.RIGHT));
    }
}