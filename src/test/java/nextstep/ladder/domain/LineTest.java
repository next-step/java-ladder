package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static nextstep.ladder.TestUtil.asPointList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LineTest {

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void create() {
        assertNotNull(Line.of(asPointList(true, false, true)));
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생")
    void create_validate() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Line.of(new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("provideDisconnectedPoints")
    @DisplayName("Point 간의 유효성 검사")
    void validatePoints_disconnected(List<Point> points) {
        assertNotNull(Line.of(points));
    }

    private static Stream<List<Point>> provideDisconnectedPoints() {
        return Stream.of(
                asPointList(false, false, false),
                asPointList(true, false, false),
                asPointList(false, true, false),
                asPointList(false, false, true),
                asPointList(false, false, true),
                asPointList(false, false, false, false),
                asPointList(true, false, false, false),
                asPointList(false, true, false, false),
                asPointList(false, false, true, false),
                asPointList(false, false, false, true),
                asPointList(true, false, true, false),
                asPointList(true, false, false, true),
                asPointList(false, true, false, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConnectedPoints")
    @DisplayName("Point 간의 유효성 검사")
    void validatePoints_connected(List<Point> points) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Line.of(points)
        );
    }

    private static Stream<List<Point>> provideConnectedPoints() {
        return Stream.of(
                asPointList(true, true, true),
                asPointList(false, true, true),
                asPointList(true, true, false),
                asPointList(true, true, true, true),
                asPointList(false, true, true, true),
                asPointList(true, false, true, true),
                asPointList(true, true, false, true),
                asPointList(true, true, true, false),
                asPointList(false, false, true, true),
                asPointList(true, true, false, false),
                asPointList(true, true, false, false)
        );
    }

    @Test
    @DisplayName("List<Point>를 Pipes로 변환")
    void convertToPipes() {
        // given
        Line line = Line.of(asPointList(true, false, true));

        // when
        Pipes actual = line.convertToPipes();

        // then
        Pipes expected = new Pipes(Arrays.asList(Pipe.CONNECTED, Pipe.DISCONNECTED, Pipe.CONNECTED));
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2})
    @DisplayName("왼쪽으로 이동")
    void move_right(int index) {
        // given
        Line line = Line.of(asPointList(true, false, true, false));

        // when
        Direction direction = line.move(index);

        // then
        assertEquals(Direction.RIGHT, direction);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("오른쪽으로 이동")
    void move_left(int index) {
        // given
        Line line = Line.of(asPointList(true, false, true, false));

        // when
        Direction direction = line.move(index);

        // then
        assertEquals(Direction.LEFT, direction);
    }

    @Test
    @DisplayName("이동하지 않음")
    void stop() {
        // given
        Line line = Line.of(asPointList(true, false, true, false));

        // when
        Direction direction = line.move(4);

        // then
        assertEquals(Direction.STOP, direction);
    }
}
