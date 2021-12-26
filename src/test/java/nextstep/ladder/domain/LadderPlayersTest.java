package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderPlayersTest {
    @Test
    public void create() {
        assertThat(LadderPlayers.of(List.of("name1", "name2"))).isEqualTo(LadderPlayers.of(List.of("name1", "name2")));
    }

    static Stream<Arguments> parseCreateFailed() {
        return Stream.of(
                Arguments.of(List.of("name10"))
        );
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullAndEmptySource
    @MethodSource("parseCreateFailed")
    public void createFailed(List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPlayers.of(names));
    }

    @Test
    public void stream() {
        final List<String> names = List.of("name1", "name2");
        assertThat(LadderPlayers.of(names).stream()).hasSameElementsAs(names.stream().map(PlayerName::of).collect(Collectors.toList()));
    }

    public static LadderPlayers ps(String ... names) {
        return LadderPlayers.of(Arrays.asList(names));
    }

    public static LadderPlayers ps(List<String> names) {
        return LadderPlayers.of(names);
    }
}
