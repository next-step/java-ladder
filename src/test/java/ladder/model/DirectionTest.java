package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"false, false", "false, true", "true, false", "true, true"})
    @DisplayName("좌, 우 방향을 정상 입력하면 객체를 생성한다")
    void of(boolean isLeft, boolean isRight) {
        assertThat(Direction.of(isLeft, isRight)).isInstanceOf(Direction.class);
    }

    @ParameterizedTest
    @MethodSource("moveProvider")
    @DisplayName("방향에 따라 이동하는 인덱스 값을 반환한다")
    void move(Direction direction, int nowIndex, int expectedIndex) {
        assertThat(direction.move(nowIndex)).isEqualTo(expectedIndex);
    }

    static Stream<Arguments> moveProvider() {
        return Stream.of(
                arguments(Direction.of(true, false), 1, 0),
                arguments(Direction.of(true, false), 1, 0),
                arguments(Direction.of(false, false), 2, 2)
        );
    }

}