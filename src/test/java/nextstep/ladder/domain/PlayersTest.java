package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    @Test
    public void create() {
        assertThat(Players.of(List.of("name1", "name2"))).isEqualTo(Players.of(List.of("name1", "name2")));
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
                .isThrownBy(() -> Players.of(names));
    }

    @Test
    public void size() {
        final List<String> names = List.of("name1", "name2");
        assertThat(Players.of(names).size()).isEqualTo(names.size());
    }

    public static Players players(String ... names) {
        return Players.of(Arrays.asList(names));
    }
}
