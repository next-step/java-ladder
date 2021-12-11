package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static nextstep.ladder.domain.HeightTest.h;
import static nextstep.ladder.domain.PlayerCountTest.pc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final PlayerCount playerCount = pc(5);
        final Height height = h(5);

        assertThat(Ladder.of(playerCount, height)).isEqualTo(Ladder.of(playerCount, height));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                Arguments.of(null, h(5)),
                Arguments.of(pc(5), null)
        );
    }

    @ParameterizedTest
    @MethodSource("parseInvalidLadder")
    public void createFailed(PlayerCount playerCount, Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(playerCount, height));
    }

    @ParameterizedTest
    @NullSource
    public void createFailed(List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(names, 5));
    }

    @Test
    public void ladder() {
        final int playerCount = 3;
        final int height = 5;
        assertThat(Ladder.of(playerCount, height).ladder())
                .hasSize(height);
    }
}
