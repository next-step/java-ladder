package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.PlayersTest.ps;
import static nextstep.ladder.domain.ResultsTest.rs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderBuilderTest {
    @Test
    public void create() {
        final LadderFrame ladderFrame = LadderFrame.of(ps("name1", "name2"), rs("result1", "result2"));
        final Height height = h(5);
        assertThat(LadderBuilder.of(ladderFrame, height)).isEqualTo(LadderBuilder.of(ladderFrame, height));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(null, h(5)),
                Arguments.of(LadderFrame.of(ps("name1", "name2"), rs("result1", "result2")), null)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseCreateFailed")
    public void createFailed(LadderFrame ladderFrame, Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderBuilder.of(ladderFrame, height))
                .withMessageContaining("cannot be null");
    }

    @Test
    public void build() {
        final Players players = ps("name1", "name2");
        final Results results = rs("result1", "result2");
        final Height height = h(5);
        final LadderBuilder builder = LadderBuilder.of(players, results, height);
        assertThat(Ladder.of(players.count(), height, TestLineStrategy.NO_LINE_STRATEGY))
                .isEqualTo(builder.build(TestLineStrategy.NO_LINE_STRATEGY));
    }
}
