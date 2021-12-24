package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ConcreteLadderFrameTest {
    @Test
    public void create() {
        assertThat(LadderFrame.of(List.of("n1", "n2"), List.of("r1", "r2")))
                .isEqualTo(LadderFrame.of(List.of("n1", "n2"), List.of("r1", "r2")));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(null, List.of("r1", "r2"), "cannot be null"),
                Arguments.of(List.of("p1", "p2"), null, "cannot be null"),
                Arguments.of(List.of("p1", "p2"), List.of("r1", "r2", "r3"), "count is not matched")
        );
    }

    @ParameterizedTest
    @MethodSource("parseCreateFailed")
    public void createFailed(List<String> players, List<String> results, String expectedMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderFrame.of(players, results))
                .withMessageContaining(expectedMessage);
    }

    @Test
    public void playersAndResults() {
        List<String> players = List.of("n1", "n2");
        List<String> results = List.of("r1", "r2");
        LadderFrame frame = lf(players, results);
        assertThat(frame.players()).isEqualTo(ps(players));
        assertThat(frame.prizes()).isEqualTo(LadderPrizesTest.pzs(results));
    }

    @Test void railCount() {
        assertThat(lf(List.of("n1", "n2"), List.of("r1", "r2")).railCount()).isEqualTo(RailCount.of(2));
    }

    public static LadderFrame lf(List<String> players, List<String> results) {
        return LadderFrame.of(players, results);
    }

    public static LadderFrame simpleLF = lf(List.of("p1", "p2"), List.of("r1", "r2"));
}
