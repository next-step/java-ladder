package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void create() {
        assertNotNull(Line.of(4));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("팩토리 메소드 예외 발생")
    void create_validate(int countOfPerson) {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(countOfPerson));
    }

    @Test
    @DisplayName("Line 추가 성공")
    void add() {
        Line line = Line.of(3);
        assertTrue(line.add(Point.of(false)));
    }

    @Test
    @DisplayName("Line 추가 실패")
    void add_fail() {
        Line line = Line.of(3);
        assertTrue(line.add(Point.of(false)));
        assertTrue(line.add(Point.of(false)));
        assertTrue(line.add(Point.of(false)));
        assertFalse(line.add(Point.of(false)));
    }

    @ParameterizedTest
    @MethodSource("provideDisconnectedPoints")
    @DisplayName("Line 유효성 검사 성공")
    void add_validate(List<Point> points) {
        Line line = Line.of(points.size());
        for (Point point : points) {
            assertTrue(line.add(point));
        }
    }

    @ParameterizedTest
    @MethodSource("provideConnectedPoints")
    @DisplayName("Line 유효성 검사 실패")
    void add_validate_fail(List<Point> points) {
        Line line = Line.of(points.size());
        assertThatIllegalArgumentException().isThrownBy(() -> {
            for (Point point : points) {
                line.add(point);
            }
        });
    }

    private static Stream<List<Point>> provideDisconnectedPoints() {
        return Stream.of(
                asPointList(false, false, false),
                asPointList(true, false, false),
                asPointList(false, true, false),
                asPointList(false, false, true),
                asPointList(true, false, true),
                asPointList(false, false, false, false),
                asPointList(true, false, false, false),
                asPointList(false, true, false, false),
                asPointList(false, false, true, false),
                asPointList(false, false, false, true),
                asPointList(true, false, true, false),
                asPointList(false, true, false, true),
                asPointList(true, false, false, true),
                asPointList(false, false, false, true)
        );
    }

    private static Stream<List<Point>> provideConnectedPoints() {
        return Stream.of(
                asPointList(true, true, true),
                asPointList(true, true, false),
                asPointList(false, true, true),
                asPointList(true, true, true, true),
                asPointList(false, true, true, true),
                asPointList(false, true, true, false),
                asPointList(false, false, true, true),
                asPointList(true, false, true, true),
                asPointList(true, true, false, true),
                asPointList(true, true, true, false),
                asPointList(true, true, false, false)
        );
    }

    private static List<Point> asPointList(Boolean...points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(Collectors.toList());
    }
}
