package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.LadderFrameTest.lf;
import static nextstep.ladder.domain.PlayerCountTest.pc;
import static nextstep.ladder.domain.PlayerTest.p;
import static nextstep.ladder.domain.PointCountTest.ptc;
import static nextstep.ladder.domain.ResultTest.r;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final int pointCount = 5;
        final int height = 5;
        final LineGenerateStrategy strategy = TestLineStrategy.NO_LINE_STRATEGY;

        assertThat(Ladder.of(pointCount, height, strategy)).isEqualTo(Ladder.of(pointCount, height, strategy));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                Arguments.of(null, h(5), TestLineStrategy.NO_LINE_STRATEGY),
                Arguments.of(ptc(5), null, TestLineStrategy.NO_LINE_STRATEGY),
                Arguments.of(ptc(5), h(5), null)
        );
    }

    @ParameterizedTest
    @MethodSource("parseInvalidLadder")
    public void createFailed(PointCount pointCount, Height height, LineGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(pointCount, height, strategy));
    }

    @Test
    public void stream() {
        final PlayerCount playerCount = pc(3);
        final Height height = h(5);
        final LineGenerateStrategy strategy = TestLineStrategy.NO_LINE_STRATEGY;
        assertThat(Ladder.of(playerCount, height, strategy).stream()).hasSize(height.toInt());
        assertThat(Ladder.of(playerCount, height, strategy).stream()).hasOnlyElementsOfType(Line.class);
    }

    static Stream<Arguments> parseLadderResult() {
        return Stream.of(
                Arguments.of(Ladder.of(1, 2, TestLineStrategy.NO_LINE_STRATEGY),
                        lf(List.of("p1", "p2"), List.of("r1", "r2")),
                        ResultOfGame.of(Map.of(p("p1"), r("r1"), p("p2"), r("r2")))),
                Arguments.of(Ladder.of(1, 1, TestLineStrategy.ALL_LINE_STRATEGY),
                        lf(List.of("p1", "p2"), List.of("r1", "r2")),
                        ResultOfGame.of(Map.of(p("p1"), r("r2"), p("p2"), r("r1")))),
                Arguments.of(Ladder.of(1, 2, TestLineStrategy.ALL_LINE_STRATEGY),
                        lf(List.of("p1", "p2"), List.of("r1", "r2")),
                        ResultOfGame.of(Map.of(p("p1"), r("r1"), p("p2"), r("r2"))))
        );
    }

    @ParameterizedTest(name = "result of ladder: {arguments}")
    @MethodSource("parseLadderResult")
    public void result(Ladder ladder, LadderFrame ladderFrame, ResultOfGame expected) {
        assertThat(ladder.result(ladderFrame)).isEqualTo(expected);
    }

    static Stream<Arguments> parseLadderDownToResult() {
        return Stream.of(
                Arguments.of(pc(2), h(1), TestLineStrategy.NO_LINE_STRATEGY,
                        List.of(0, 1)),
                Arguments.of(pc(2), h(1), TestLineStrategy.ALL_LINE_STRATEGY,
                        List.of(1, 0)),
                Arguments.of(pc(2), h(2), TestLineStrategy.ALL_LINE_STRATEGY,
                        List.of(0, 1))
        );
    }

    @ParameterizedTest(name = "downToResult: {arguments}")
    @MethodSource("parseLadderDownToResult")
    public void downToResult(PlayerCount pc, Height height, LineGenerateStrategy strategy, List<Integer> expected) {
        Ladder ladder = Ladder.of(pc, height, strategy);
        List<Integer> indexMap = IntStream.range(0, pc.toInt()).boxed().collect(Collectors.toList());
        assertThat(ladder.downToResult(indexMap, ladder.collect().listIterator())).hasSameElementsAs(expected);
    }
}
