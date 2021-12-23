package nextstep.ladder.domain;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.PlayerTest.p;
import static nextstep.ladder.domain.PlayersTest.ps;
import static nextstep.ladder.domain.ResultTest.r;
import static nextstep.ladder.domain.ResultsTest.rs;
import static nextstep.ladder.domain.TestLadderPointStrategy.NO_LINE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NewLadderTest {
    @Test
    public void create() {
        final int railCount = 2;
        final Height height = h(5);
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;

        assertThat(NewLadder.of(railCount, height, strategy)).isEqualTo(NewLadder.of(railCount, height, strategy));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                // Arguments.of(null, h(5), NO_LINE_STRATEGY), todo railCount 생성 이후 되살리자
                Arguments.of(2, null, NO_LINE_STRATEGY),
                Arguments.of(2, h(5), null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseInvalidLadder")
    public void createFailed(int railCount, Height height, LadderPointGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NewLadder.of(railCount, height, strategy));
    }

    @Test
    public void stream() {
        final int railCount = 2;
        final Height height = h(5);
        final LadderPointGenerateStrategy strategy = NO_LINE_STRATEGY;
        assertThat(NewLadder.of(railCount, height, strategy).stream()).hasSize(height.toInt());
        assertThat(NewLadder.of(railCount, height, strategy).stream()).hasOnlyElementsOfType(LadderLine.class);
    }

    static Stream<Arguments> parseLadderResult() {
        return Stream.of(
                Arguments.of(NewLadder.of(2, 2, NO_LINE_STRATEGY),
                        ps("p1", "p2"), rs("r1", "r2"),
                        ResultOfGame.of(Map.of(p("p1"), r("r1"), p("p2"), r("r2")))),
                Arguments.of(NewLadder.of(2, 1, TestLadderPointStrategy.reverseLineStrategy()),
                        ps("p1", "p2"), rs("r1", "r2"),
                        ResultOfGame.of(Map.of(p("p1"), r("r2"), p("p2"), r("r1")))),
                Arguments.of(NewLadder.of(2, 3, TestLadderPointStrategy.reverseLineStrategy()),
                        ps("p1", "p2"), rs("r1", "r2"),
                        ResultOfGame.of(Map.of(p("p1"), r("r1"), p("p2"), r("r2"))))
        );
    }

    @ParameterizedTest(name = "result of ladder: {arguments}")
    @MethodSource("parseLadderResult")
    public void result(NewLadder ladder, Players players, Results results, ResultOfGame expected) {
        assertThat(ladder.result(LadderFrame.of(players, results))).isEqualTo(expected);
    }
}
