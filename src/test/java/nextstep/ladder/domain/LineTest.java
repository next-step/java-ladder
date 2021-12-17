package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static nextstep.ladder.domain.PointCountTest.ptc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {1, 10})
    public void create(int pointCount) {
        assertThat(Line.of(pointCount, TestLineStrategy.NO_LINE_STRATEGY))
                .isEqualTo(Line.of(pointCount, TestLineStrategy.NO_LINE_STRATEGY));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(ptc(4), null),
                Arguments.of(null, TestLineStrategy.NO_LINE_STRATEGY)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseCreateFailed")
    public void createFailed(PointCount pointCount, LineGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(pointCount, strategy))
                .withMessageContaining("cannot be null");
    }

    @Test
    public void createFailedByInvalidGenerator() {
        final int pointCount = 4;
        final LineGenerateStrategy invalidStrategy = number -> Stream.generate(() -> Boolean.FALSE)
                        .limit(pointCount + 1)
                        .collect(Collectors.toList());
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.of(pointCount, invalidStrategy))
                .withMessageContaining("generated size is not match");
    }

    @Test
    public void stream() {
        final int pointCount = 5;
        final Boolean[] pointList = new Boolean[pointCount];
        Arrays.fill(pointList, Boolean.FALSE);
        assertThat(Line.of(pointCount, TestLineStrategy.NO_LINE_STRATEGY).stream())
                .hasSize(pointCount);
        assertThat(Line.of(pointCount, TestLineStrategy.NO_LINE_STRATEGY).stream())
                .hasSameElementsAs(Arrays.asList(pointList));
    }

    static Stream<Arguments> parseNextPosition() {
        return Stream.of(
                Arguments.of(Line.of(ptc(1), TestLineStrategy.NO_LINE_STRATEGY), List.of(0, 1), List.of(0, 1)),
                Arguments.of(Line.of(ptc(1), TestLineStrategy.ALL_LINE_STRATEGY), List.of(0, 1), List.of(1, 0)),
                Arguments.of(Line.of(ptc(2), TestLineStrategy.VALID_STRATEGY), List.of(0, 1, 2), List.of(1, 0, 2))
        );
    }

    @ParameterizedTest(name = "next position: {arguments}")
    @MethodSource("parseNextPosition")
    public void nextPosition(Line line, List<Integer> current, List<Integer> next) {
        assertThat(line.nextPosition(current)).hasSameElementsAs(next);
    }

    static Stream<Arguments> parseMove() {
        return Stream.of(
                Arguments.of(Line.of(ptc(1), TestLineStrategy.NO_LINE_STRATEGY), 0, 0),
                Arguments.of(Line.of(ptc(1), TestLineStrategy.NO_LINE_STRATEGY), 1, 1),
                Arguments.of(Line.of(ptc(1), TestLineStrategy.ALL_LINE_STRATEGY), 0, 1),
                Arguments.of(Line.of(ptc(1), TestLineStrategy.ALL_LINE_STRATEGY), 1, 0),
                Arguments.of(Line.of(ptc(3), TestLineStrategy.VALID_STRATEGY), 0, 0),
                Arguments.of(Line.of(ptc(3), TestLineStrategy.VALID_STRATEGY), 1, 2),
                Arguments.of(Line.of(ptc(3), TestLineStrategy.VALID_STRATEGY), 2, 1)
        );
    }

    @ParameterizedTest(name = "move : {arguments}")
    @MethodSource("parseMove")
    public void move(Line line, int current, int next) {
        assertThat(line.move(current)).isEqualTo(next);
    }

    @Test
    public void hasPoint() {
        Line line = Line.of(ptc(1), TestLineStrategy.ALL_LINE_STRATEGY);
        assertThat(line.hasPoint(0)).isPresent();
        assertThat(line.hasPoint(1)).isEmpty();
    }

    public static Line l(int pointCount, LineGenerateStrategy strategy) {
        return Line.of(pointCount, strategy);
    }
}
