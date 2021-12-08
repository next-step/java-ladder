package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final int numberOfPlayer = 4;
        final int height = 5;

        assertThat(Ladder.of(numberOfPlayer, height)).isEqualTo(Ladder.of(numberOfPlayer, height));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(2, -1),
                Arguments.of(1, 1),
                Arguments.of(0, 1),
                Arguments.of(-1, 1)
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @MethodSource("parseInvalidLadder")
    public void createFailed(final int numberOfPlayer, final int height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(numberOfPlayer, height));
    }


    @Test
    public void createFailed() {
        final int numberOfPlayer = 2;
        final Height height = null;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(numberOfPlayer, height));
    }
}
