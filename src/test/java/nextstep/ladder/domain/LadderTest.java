package nextstep.ladder.domain;

import java.util.stream.Stream;

import nextstep.ladder.domain.line.LineGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.PlayerCountTest.pc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final PlayerCount playerCount = pc(5);
        final Height height = h(5);
        final LineGenerateStrategy strategy = TestLineStrategy.NO_LINE_STRATEGY;

        assertThat(Ladder.of(playerCount, height, strategy)).isEqualTo(Ladder.of(playerCount, height, strategy));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                Arguments.of(null, h(5), TestLineStrategy.NO_LINE_STRATEGY),
                Arguments.of(pc(5), null, TestLineStrategy.NO_LINE_STRATEGY),
                Arguments.of(pc(5), h(5), null)
        );
    }

    @ParameterizedTest
    @MethodSource("parseInvalidLadder")
    public void createFailed(PlayerCount playerCount, Height height, LineGenerateStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(playerCount, height, strategy));
    }

    @Test
    public void stream() {
        final int playerCount = 3;
        final int height = 5;
        final LineGenerateStrategy strategy = TestLineStrategy.NO_LINE_STRATEGY;
        assertThat(Ladder.of(playerCount, height, strategy).stream()).hasSize(height);
        assertThat(Ladder.of(playerCount, height, strategy).stream()).hasOnlyElementsOfType(Line.class);
    }
}
