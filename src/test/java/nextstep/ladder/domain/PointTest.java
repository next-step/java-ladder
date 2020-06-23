package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {

    @DisplayName("사다리 타기 :: Point 오른쪽 이동 결과 값 테스트")
    @ParameterizedTest
    @MethodSource("provideMoveRightPoint")
    void pointMoveRightTest(final XAxis xAxis, final int expectX) {
        Point point = Point.of(xAxis, YAxis.of(0));
        Point result = point.moveToRight();
        assertThat(result.getxAxis().getxAxis()).isEqualTo(expectX);
    }

    private static Stream<Arguments> provideMoveRightPoint() {
        return Stream.of(
                Arguments.of(XAxis.of(1), 2),
                Arguments.of(XAxis.of(2), 3)
        );
    }

    @DisplayName("사다리 타기 :: Point 왼쪽 이동 결과 값 테스트")
    @ParameterizedTest
    @MethodSource("provideMoveLeftPoint")
    void pointMoveLeftTest(final XAxis xAxis, final int expectX) {
        Point point = Point.of(xAxis, YAxis.of(0));
        Point result = point.moveToLeft();
        assertThat(result.getxAxis().getxAxis()).isEqualTo(expectX);
    }

    private static Stream<Arguments> provideMoveLeftPoint() {
        return Stream.of(
                Arguments.of(XAxis.of(1), 0),
                Arguments.of(XAxis.of(2), 1)
        );
    }

    @DisplayName("사다리 타기 :: Point 아래쪽 이동 결과 값 테스트")
    @ParameterizedTest
    @MethodSource("provideMoveDownPoint")
    void pointMoveDownTest(final YAxis yAxis, final Point expectPoint) {
        Point point = Point.of(XAxis.of(0), yAxis);
        Point result = point.moveToDown();
        assertThat(result.equals(expectPoint)).isEqualTo(true);
    }

    private static Stream<Arguments> provideMoveDownPoint() {
        return Stream.of(
                Arguments.of(YAxis.of(1), Point.of(XAxis.of(0), YAxis.of(2))),
                Arguments.of(YAxis.of(2), Point.of(XAxis.of(0), YAxis.of(3)))
        );
    }

}
