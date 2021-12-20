package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.PlayersTest.ps;
import static nextstep.ladder.domain.ResultsTest.rs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderFrameTest {
    @Test
    public void create() {
        assertThat(LadderFrame.of(ps("n1", "n2"), rs("r1", "r2")))
                .isEqualTo(LadderFrame.of(ps("n1", "n2"), rs("r1", "r2")));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(null, rs("r1", "r2"), "cannot be null"),
                Arguments.of(ps("p1", "p2"), null, "cannot be null"),
                Arguments.of(ps("p1", "p2"), rs("r1", "r2", "r3"), "count is not matched")
        );
    }

    @ParameterizedTest
    @MethodSource("parseCreateFailed")
    public void createFailed(Players players, Results results, String expectedMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderFrame.of(players, results))
                .withMessageContaining(expectedMessage);
    }

    @Test
    public void playersAndResults() {
        Players players = ps("n1", "n2");
        Results results = rs("r1", "r2");
        LadderFrame frame = LadderFrame.of(players, results);
        assertThat(frame.players()).isEqualTo(players);
        assertThat(frame.results()).isEqualTo(results);
    }
}
