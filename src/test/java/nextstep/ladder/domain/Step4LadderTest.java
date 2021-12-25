package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.LadderHeightTest.h;
import static nextstep.ladder.domain.Step4LadderRailsTest.lf;
import static nextstep.ladder.domain.Step4LadderRailsTest.simpleLF;
import static nextstep.ladder.domain.PlayerNameTest.pn;
import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizeTest.pz;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Step4LadderTest {
    @Test
    public void create() {
        final Step4LadderRails step4LadderFrame = lf(List.of("p1", "p2", "p3"), List.of("r1", "r2", "r3"));
        final LadderHeight ladderHeight = h(5);
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;

        assertThat(Step4Ladder.of(step4LadderFrame, ladderHeight, strategy)).isEqualTo(Step4Ladder.of(step4LadderFrame, ladderHeight, strategy));
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
    public void createFailed(Step4LadderRails step4LadderFrame, LadderHeight ladderHeight, LadderPointGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Step4Ladder.of(step4LadderFrame, ladderHeight, strategy));
    }

    @Test
    public void stream() {
        final int height = 5;
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;
        assertThat(Step4Ladder.of(simpleLF, height, strategy).stream()).hasSize(height);
        assertThat(Step4Ladder.of(simpleLF, height, strategy).stream()).hasOnlyElementsOfType(LadderLine.class);
    }

    static Stream<Arguments> parseLadderResult() {
        return Stream.of(
                Arguments.of(simpleLF, 2, NO_LINE_STRATEGY,
                        LadderGameResult.of(Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2")))),
                Arguments.of(simpleLF, 1, TestLadderPointStrategy.reverseLineStrategy(),
                        LadderGameResult.of(Map.of(pn("p1"), pz("r2"), pn("p2"), pz("r1")))),
                Arguments.of(simpleLF, 3, TestLadderPointStrategy.reverseLineStrategy(),
                        LadderGameResult.of(Map.of(pn("p1"), pz("r1"), pn("p2"), pz("r2"))))
        );
    }

    @Test
    public void playersAndResults() {
        List<String> players = List.of("n1", "n2");
        List<String> results = List.of("r1", "r2");
        Step4LadderRails frame = lf(players, results);
        assertThat(l(frame, 5, NO_LINE_STRATEGY).players()).isEqualTo(ps(players));
        assertThat(l(frame, 5, NO_LINE_STRATEGY).prizes()).isEqualTo(pzs(results));
    }


    @ParameterizedTest(name = "result of ladder: {arguments}")
    @MethodSource("parseLadderResult")
    public void result(Step4LadderRails step4LadderFrame, int height, LadderPointGenerateStrategy strategy, LadderGameResult expected) {
        assertThat(l(step4LadderFrame, height, strategy).move(step4LadderFrame.prizes())).isEqualTo(expected);
    }

    public static Step4Ladder l(Step4LadderRails step4LadderFrame, int height, LadderPointGenerateStrategy strategy) {
        return Step4Ladder.of(step4LadderFrame, height, strategy);
    }
}
