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

    @Test
    @DisplayName("사다리 중간 다리 생성 기능 추가")
    void testMiddlePoints() {
        Point sampleFirstPoint = Point.first(true);

        assertThat(sampleFirstPoint.next(false))
                .isEqualTo(Point.custom(true, false));
    }

    @Test
    @DisplayName("사다리에 마지막 다리 생성 기능 추가")
    void testLastPoint() {
        Point sample = Point.custom(true, false);

        assertThat(sample.last())
                .isEqualTo(Point.custom(false, false));
    }

    @Test
    @DisplayName("pass 생성")
    public void next_stay() {
        Point second = Point.first1(false).next1(false);
        assertThat(second.nextIndex1()).isEqualTo(1);
    }

    @Test
    @DisplayName("좌측 이동 테스트")
    public void next_left() {
        Point second = Point.first1(true).next1(false);
        assertThat(second.nextIndex1()).isEqualTo(0);
    }

    @Test
    @DisplayName("우측 이동 테스트")
    public void next_right() {
        Point second = Point.first1(false).next1(true);
        assertThat(second.nextIndex1()).isEqualTo(2);
    }

    @Test
    @DisplayName("불가능한 상태에 대해 방어 테스트")
    public void next() {
        Point second = Point.first1(true).next1(true);
        // false, true 순서로 생성된다.
        assertThat(second.nextIndex1()).isEqualTo(0);
    }
}
