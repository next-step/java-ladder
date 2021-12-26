package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderPointGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.LadderHeightTest.h;
import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.Step4LadderFrameTest.lf;
import static nextstep.ladder.domain.Step4LadderFrameTest.simpleFrame;
import static nextstep.ladder.domain.Step4LadderRailsTest.simpleRails;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Step4LadderTest {
    @Test
    public void create() {
        final LadderFrame frame = lf(List.of("p1", "p2", "p3"), List.of("r1", "r2", "r3"), 5);
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;
        assertThat(Step4Ladder.of(frame, strategy)).isEqualTo(Step4Ladder.of(frame, strategy));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                 Arguments.of(null, NO_LINE_STRATEGY),
                Arguments.of(simpleFrame, null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseInvalidLadder")
    public void createFailed(LadderFrame ladderFrame, LadderPointGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Step4Ladder.of(ladderFrame, strategy));
    }

    @Test
    public void stream() {
        final int height = 5;
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;
        assertThat(Step4Ladder.of(simpleFrame, strategy).stream()).hasSize(height);
        assertThat(Step4Ladder.of(simpleFrame, strategy).stream()).hasOnlyElementsOfType(LadderLine.class);
    }

    static Stream<Arguments> parseLadderResult() {
        return Stream.of(
                Arguments.of(lf(simpleRails, 2), NO_LINE_STRATEGY,
                        LadderGameResult.of(Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2")))),
                Arguments.of(lf(simpleRails, 1), TestLadderPointStrategy.reverseLineStrategy(),
                        LadderGameResult.of(Map.of(pn("p1"), pz("r2"), pn("p2"), pz("r1")))),
                Arguments.of(lf(simpleRails, 3), TestLadderPointStrategy.reverseLineStrategy(),
                        LadderGameResult.of(Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"))))
        );
    }

    @Test
    public void asLadderRailsAndFrame() {
        final List<String> players = List.of("n1", "n2");
        final List<String> results = List.of("r1", "r2");
        final int height = 5;
        LadderFrame frame = lf(players, results, height);
        assertThat(l(frame, NO_LINE_STRATEGY).players()).isEqualTo(ps(players));
        assertThat(l(frame, NO_LINE_STRATEGY).prizes()).isEqualTo(pzs(results));
        assertThat(l(frame, NO_LINE_STRATEGY).railCount()).isEqualTo(LadderRailCount.of(players.size()));
        assertThat(l(frame, NO_LINE_STRATEGY).height()).isEqualTo(h(height));
    }

    @ParameterizedTest(name = "result of ladder: {arguments}")
    @MethodSource("parseLadderResult")
    public void result(LadderFrame ladderFrame, LadderPointGenerateStrategy strategy, LadderGameResult expected) {
        assertThat(l(ladderFrame, strategy).move(ladderFrame.prizes())).isEqualTo(expected);
    }

    public static Ladder l(LadderFrame ladderFrame, LadderPointGenerateStrategy strategy) {
        return Step4Ladder.of(ladderFrame, strategy);
    }
}
