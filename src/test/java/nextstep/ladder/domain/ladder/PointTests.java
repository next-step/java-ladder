package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointTests {
    @DisplayName("현재 위치와 Direction을 전달 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Point point = new Point(2, new Direction(false, false));
        assertThat(point).isNotNull();
    }

    @DisplayName("첫번째 Point를 생성할 수 있다.")
    @Test
    void createFirst() {
        PointAddStrategy pointAddStrategy = new SimplePointAddStrategy();
        Point firstPoint = Point.first(pointAddStrategy);
        assertThat(firstPoint).isEqualTo(new Point(0, new Direction(false, true)));
    }

    @DisplayName("현재 Point 상태를 기반으로 다음 Point를 생성할 수 있다.")
    @Test
    void createNextText() {
        PointAddStrategy pointAddStrategy = new SimplePointAddStrategy();
        Point point = new Point(1, new Direction(false, false));

        Point nextPoint = point.next(pointAddStrategy);
        Point twoNextPoint = nextPoint.next(pointAddStrategy);

        assertThat(nextPoint)
                .isEqualTo(new Point(2, new Direction(false, true)));
        assertThat(twoNextPoint)
                .isEqualTo(new Point(3, new Direction(true, false)));
    }

    @DisplayName("Ladder Line의 마지막 Point를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("createLastTestCases")
    void createLastTest(Point beforeLastPoint, Point lastPoint) {
        assertThat(beforeLastPoint.last()).isEqualTo(lastPoint);
    }
    public static Stream<Arguments> createLastTestCases() {
        return Stream.of(
                Arguments.of(
                        new Point(3, new Direction(false, false)),
                        new Point(4, new Direction(false, false))
                ),
                Arguments.of(
                        new Point(2, new Direction(false, true)),
                        new Point(3, new Direction(true, false))
                ),
                Arguments.of(
                        new Point(0, new Direction(true, false)),
                        new Point(1, new Direction(false, false))
                )
        );
    }

    @DisplayName("현재 상황에서 움직일 수 있는 이동 정책을 반환한다.")
    @ParameterizedTest
    @MethodSource("directionAndResult")
    void moveTest(Direction direction, HorizontalMoveStrategy horizontalMoveStrategy) {
        Point point = new Point(2, direction);
        assertThat(point.move()).isEqualTo(horizontalMoveStrategy);
    }
    public static Stream<Arguments> directionAndResult() {
        return Stream.of(
                Arguments.of(new Direction(true, false), HorizontalMoveStrategy.MOVE_LEFT),
                Arguments.of(new Direction(false, false), HorizontalMoveStrategy.STAY),
                Arguments.of(new Direction(false, true), HorizontalMoveStrategy.MOVE_RIGHT)
        );
    }
}
