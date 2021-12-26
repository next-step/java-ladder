package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static nextstep.ladder.domain.IndexTest.ix;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    public void init() {
        Point first = Point.first(false);
        Point last = first.last();
        assertThat(LadderLine.of(List.of(first, last))).isEqualTo(LadderLine.of(List.of(first, last)));
    }

    static Stream<Arguments> parseInitFailed() {
        return Stream.of(
                Arguments.of(List.of(Point.first(false)))
        );
    }

    @ParameterizedTest(name = "init failed: {arguments}")
    @NullAndEmptySource
    @MethodSource("parseInitFailed")
    public void initFailed(List<Point> points) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.of(points));
    }

    static Stream<Arguments> parseMoveArguments() {
        return Stream.of(
                Arguments.of(ll(2, NO_LINE_STRATEGY), 0, 0),
                Arguments.of(ll(2, TestLadderPointStrategy.reverseLineStrategy()), 1, 0),
                Arguments.of(ll(2, TestLadderPointStrategy.reverseLineStrategy()), 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parseMoveArguments")
    public void move(LadderLine line, int move, int expected) {
        assertThat(line.move(ix(move))).isEqualTo(ix(expected));
    }

    @Test
    public void boolStream() {
        assertThat(simpleLine().boolStream()).hasSameElementsAs(List.of(false, true, false));
    }

    public static LadderLine ll(int railCount, LadderPointGenerateStrategy strategy) {
        LadderLineBuilder builder = LadderLineBuilder.of(railCount, strategy);
        return builder.build();
    }

    public static LadderLine simpleLine() {
        Point first = Point.first(true);
        Point last = first.last();
        return LadderLine.of(List.of(first, last));
    }
}
