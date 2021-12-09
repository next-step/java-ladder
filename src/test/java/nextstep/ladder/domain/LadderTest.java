package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static nextstep.ladder.domain.HeightTest.height;
import static nextstep.ladder.domain.PlayersTest.players;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    public void create() {
        final List<String> names = List.of("name1", "name2", "name3");
        final int height = 5;

        assertThat(Ladder.of(names, height)).isEqualTo(Ladder.of(names, height));
    }

    static Stream<Arguments> parseInvalidLadder() {
        return Stream.of(
                Arguments.of(null, height(5)),
                Arguments.of(players("name1", "name2", "name3"), null)
        );
    }

    @ParameterizedTest
    @MethodSource("parseInvalidLadder")
    public void createFailed(Players players, Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(players, height));
    }

    @ParameterizedTest
    @NullSource
    public void createFailed(List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(names, 5));
    }
}
