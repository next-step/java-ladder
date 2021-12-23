package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.LadderFrameTest.lf;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.RailCountTest.rc;
import static nextstep.ladder.domain.ResultTest.r;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final RailCount railCount = rc(2);
        final Height height = h(5);
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;

        assertThat(Ladder.of(railCount, height, strategy)).isEqualTo(Ladder.of(railCount, height, strategy));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                 Arguments.of(null, h(5), NO_LINE_STRATEGY),
                Arguments.of(rc(2), null, NO_LINE_STRATEGY),
                Arguments.of(rc(2), h(5), null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseInvalidLadder")
    public void createFailed(RailCount railCount, Height height, LadderPointGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(railCount, height, strategy));
    }

    @Test
    public void stream() {
        final int railCount = 2;
        final int height = 5;
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;
        assertThat(Ladder.of(railCount, height, strategy).stream()).hasSize(height);
        assertThat(Ladder.of(railCount, height, strategy).stream()).hasOnlyElementsOfType(LadderLine.class);
    }

    static Stream<Arguments> parseLadderResult() {
        return Stream.of(
                Arguments.of(Ladder.of(2, 2, NO_LINE_STRATEGY),
                        lf(List.of("p1", "p2"), List.of("r1", "r2")),
                        ResultOfGame.of(Map.of(pn("p1"), r("r1"), pn("p2"), r("r2")))),
                Arguments.of(Ladder.of(2, 1, TestLadderPointStrategy.reverseLineStrategy()),
                        lf(List.of("p1", "p2"), List.of("r1", "r2")),
                        ResultOfGame.of(Map.of(pn("p1"), r("r2"), pn("p2"), r("r1")))),
                Arguments.of(Ladder.of(2, 3, TestLadderPointStrategy.reverseLineStrategy()),
                        lf(List.of("p1", "p2"), List.of("r1", "r2")),
                        ResultOfGame.of(Map.of(pn("p1"), r("r1"), pn("p2"), r("r2"))))
        );
    }

    @ParameterizedTest(name = "result of ladder: {arguments}")
    @MethodSource("parseLadderResult")
    public void result(Ladder ladder, LadderFrame ladderFrame, ResultOfGame expected) {
        assertThat(ladder.resultOfGame(ladderFrame)).isEqualTo(expected);
    }
}
