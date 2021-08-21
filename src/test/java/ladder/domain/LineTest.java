package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("DirectionMakingStrategy 전략이 Right인 경우 다음 Direction은 Left, 홀수인 경우 마지막 Direction은 None")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("argumentsProvider")
    void initLine(int ladderWidth, Direction direction, List<Direction> expected) {
        Line line = Line.initLine(new LadderWidth(ladderWidth), () -> direction);
        assertThat(line.getDirections()).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.arguments(2, Direction.RIGHT, toList(Direction.RIGHT, Direction.LEFT)),
                Arguments.arguments(3, Direction.RIGHT, toList(Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                Arguments.arguments(4, Direction.RIGHT, toList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)),
                Arguments.arguments(5, Direction.RIGHT, toList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.NONE)),
                Arguments.arguments(2, Direction.NONE, toList(Direction.NONE, Direction.NONE)),
                Arguments.arguments(3, Direction.NONE, toList(Direction.NONE, Direction.NONE, Direction.NONE))
        );
    }

    private static List<Direction> toList(Direction... directions) {
        return Stream.of(directions)
                .collect(Collectors.toList());
    }
}