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
import static nextstep.ladder.domain.LadderFrameTest.simpleLF;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.PlayersTest.ps;
import static nextstep.ladder.domain.PrizeTest.pz;
import static nextstep.ladder.domain.PrizesTest.rs;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final LadderFrame ladderFrame = lf(List.of("p1", "p2", "p3"), List.of("r1", "r2", "r3"));
        final Height height = h(5);
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;

        assertThat(Ladder.of(ladderFrame, height, strategy)).isEqualTo(Ladder.of(ladderFrame, height, strategy));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                 Arguments.of(null, h(5), NO_LINE_STRATEGY),
                Arguments.of(simpleLF, null, NO_LINE_STRATEGY),
                Arguments.of(simpleLF, h(5), null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseInvalidLadder")
    public void createFailed(LadderFrame ladderFrame, Height height, LadderPointGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(ladderFrame, height, strategy));
    }

    @Test
    public void stream() {
        final int height = 5;
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;
        assertThat(Ladder.of(simpleLF, height, strategy).stream()).hasSize(height);
        assertThat(Ladder.of(simpleLF, height, strategy).stream()).hasOnlyElementsOfType(LadderLine.class);
    }

    static Stream<Arguments> parseLadderResult() {
        return Stream.of(
                Arguments.of(simpleLF, 2, NO_LINE_STRATEGY,
                        ResultOfGame.of(Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2")))),
                Arguments.of(simpleLF, 1, TestLadderPointStrategy.reverseLineStrategy(),
                        ResultOfGame.of(Map.of(pn("p1"), pz("r2"), pn("p2"), pz("r1")))),
                Arguments.of(simpleLF, 3, TestLadderPointStrategy.reverseLineStrategy(),
                        ResultOfGame.of(Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"))))
        );
    }

    @Test
    public void playersAndResults() {
        List<String> players = List.of("n1", "n2");
        List<String> results = List.of("r1", "r2");
        LadderFrame frame = lf(players, results);
        assertThat(l(frame, 5, NO_LINE_STRATEGY).players()).isEqualTo(ps(players));
        assertThat(l(frame, 5, NO_LINE_STRATEGY).prizes()).isEqualTo(rs(results));
    }


    @ParameterizedTest(name = "result of ladder: {arguments}")
    @MethodSource("parseLadderResult")
    public void result(LadderFrame ladderFrame, int height, LadderPointGenerateStrategy strategy, ResultOfGame expected) {
        assertThat(l(ladderFrame, height, strategy).resultOfGame()).isEqualTo(expected);
    }

    public static Ladder l(LadderFrame ladderFrame, int height, LadderPointGenerateStrategy strategy) {
        return Ladder.of(ladderFrame, height, strategy);
    }
}
