package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @Test
    @DisplayName("허용되지 않은 상태에 대한 생성 테스트")
    void testInstance() {
        new Point(false, false);
        new Point(false, true);
        new Point(true, false);

        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(InvalidLayoutException.class);
    }

    @ParameterizedTest
    @MethodSource("allStatus")
    @DisplayName("아랫 방향  움직임 테스트")
    void testNextIndex(Point point, int expectedIndex) {
        int startingIndex = 1;

        assertThat(point.nextIndex(startingIndex)).isEqualTo(expectedIndex);
    }

    @MethodSource
    private static Stream<Arguments> allStatus() {
        return Stream.of(
                Arguments.of(new Point(false, false), 1),
                Arguments.of(new Point(false, true), 2),
                Arguments.of(new Point(true, false), 0)
        );
    }
}
