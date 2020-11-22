package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.ladder.Ladder;
import step4.domain.ladder.LadderLine;
import step4.domain.ladder.Line;
import step4.domain.ladder.Point;
import step4.exceptions.OutOfRangePositionException;
import step4.type.DirectionType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step4.type.DirectionType.*;

public class DirectionTest {


    @DisplayName("방향이동 테스트")
    @ParameterizedTest
    @MethodSource("providePointAndDirectionType")
    void pointMove(Point point, DirectionType type, Point endPoint) {
        Point resultPoint = DirectionType.execute(type, point);

        assertThat(resultPoint).isEqualTo(endPoint);
    }

    private static Stream<Arguments> providePointAndDirectionType() {
        return Stream.of(
                Arguments.of(new Point(0, 0), DOWN, new Point(0, 1)),
                Arguments.of(new Point(1, 0), DirectionType.LEFT, new Point(0, 0)),
                Arguments.of(new Point(0, 0), RIGHT, new Point(1, 0))
        );
    }

    @DisplayName("방향이동 예외 테스트")
    @Test
    void pointMoveFromException() {
        Point start = new Point(0, 0);
        assertThatThrownBy(() -> {
            Point point = start.leftMove();
        }).isInstanceOf(OutOfRangePositionException.class);
    }

    @DisplayName("방향이동 다중 명령어 테스트")
    @ParameterizedTest
    @MethodSource("providePointAndDirectionTypes")
    void executeMultiMoveCommand(Point endPoint, List<DirectionType> typeList) {
        Point start = new Point(0, 0);

        Point moved = execute(start, typeList);

        assertThat(moved).isEqualTo(endPoint);
    }

    private static Stream<Arguments> providePointAndDirectionTypes() {
        return Stream.of(
                Arguments.of(new Point(1,3), Arrays.asList(RIGHT, DOWN, DOWN, RIGHT, DOWN, LEFT))
        );
    }

    @DisplayName("사다리 중간 방향이동 테스트")
    @ParameterizedTest
    @MethodSource("providePointAndLadderAndEndPoint")
    void moveLadderNextStep(Point currentPoint, LadderLine ladderLine, Point endPoint) {
        Point moved = ladderLine.nextPosition(currentPoint);

        assertThat(moved).isEqualTo(endPoint);
    }

    private static Stream<Arguments> providePointAndLadderAndEndPoint() {
        List<Line> lines = Arrays.asList(
                Line.of(Arrays.asList(true, false, true, false)),
                Line.of(Arrays.asList(false, false, false, false)),
                Line.of(Arrays.asList(false, true, false, true))
        );
        LadderLine ladderLine = new LadderLine(lines);
        return Stream.of(
                Arguments.of(new Point(1, 0), ladderLine, new Point(0,1)),
                Arguments.of(new Point(1, 1), ladderLine, new Point(1,2))
        );
    }

}
