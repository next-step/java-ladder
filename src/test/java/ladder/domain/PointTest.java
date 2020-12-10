package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @Test
    @DisplayName("허용되지 않은 상태에 대한 생성 테스트")
    void testInstance() {
        Point.custom(false, false);
        Point.custom(false, true);
        Point.custom(true, false);

        assertThatThrownBy(() -> Point.custom(true, true))
                .isInstanceOf(InvalidLayoutException.class);
    }

    @ParameterizedTest
    @MethodSource("allStatus")
    @DisplayName("아랫 방향 움직임 테스트")
    void testNextIndex(Point point, int expectedIndex) {
        int startingIndex = 1;

        assertThat(point.nextIndex(startingIndex)).isEqualTo(expectedIndex);
    }

    private static Stream<Arguments> allStatus() {
        return Stream.of(
                Arguments.of(Point.custom(false, false), 1),
                Arguments.of(Point.custom(false, true), 2),
                Arguments.of(Point.custom(true, false), 0)
        );
    }

    @Test
    @DisplayName("동일성 테스트")
    void testEquality() {
        assertThat(Point.custom(false, false))
                .isEqualTo(Point.custom(false, false));
    }

    @Test
    @DisplayName("사다리 시작 점 생성 기능 추가")
    void testFirstPoint() {
        assertThat(Point.first(true))
                .isEqualTo(Point.custom(false, true));
    }
}
