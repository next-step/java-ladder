package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Position;
import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.wrapper.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("Line 생성 테스트")
    @Test
    void create_라인_생성테스트() {
        // given
        Line line = Line.valueOf(2);
        // when
        Line expected = Line.valueOf(2);
        // then
        assertThat(line).isEqualTo(expected);
    }

    @DisplayName("Line 전략별 생성 테스트")
    @Test
    void create_랜덤_전략_테스트() {
        // given
        LineGenerator lineGenerator = countOfPerson -> Arrays.asList(Point.init(), Point.valueOf(true));
        // when
        Line line = Line.valueOf(2, lineGenerator);
        List<Point> points = line.points();
        // then
        assertAll(
                () -> assertThat(points.get(0).isExist()).isFalse(),
                () -> assertThat(points.get(1).isExist()).isTrue()
        );
    }

    @DisplayName("Line의 Point 확인 테스트 참여자 2인: |-----|")
    @Test
    void check_point_값_확인_테스트() {
        // given
        Line line = Line.valueOf(2, countOfPerson -> Arrays.asList(Point.init(), Point.valueOf(true), Point.init()));
        // when
        Point[] expected = {Point.init(), Point.valueOf(true), Point.init()};
        // then
        assertThat(line.points()).containsExactly(expected);
    }

    private static Stream<Arguments> ladderMovedTestCase() {
        /**
         * user1  user2  user3
         *      |-----|     |
         *
         * 상황에서 이동 테스트
         */
        return Stream.of(
                Arguments.of(Position.valueOf(0), Position.valueOf(1)), // 1 -> 0
                Arguments.of(Position.valueOf(1), Position.valueOf(0)) // 0 -> 1
        );
    }

    @DisplayName("|-----| 인 사다리에서 이동이 가능한지 테스트")
    @ParameterizedTest
    @MethodSource(value = "ladderMovedTestCase")
    void move_테스트(Position actual, Position expected) {
        // given
        LineGenerator lineGenerator = countOfPerson -> Arrays.asList(Point.init(), Point.valueOf(true), Point.init());
        Line line = Line.valueOf(3, lineGenerator);
        // when
        Position movedPosition = line.move(actual);
        // then
        assertThat(movedPosition).isEqualTo(expected);
    }
}
