package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.common.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("플레이어")
class PlayerTest {

    public static Stream<Name> names() {
        return Stream.of(Name.of("pobi"), Name.of("honux"), Name.of("crong"), Name.of("jk"));
    }

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @MethodSource("names")
    public void create(final Name name) {
        // given

        // when
        final Player player = Player.of(name);

        // then
        assertThat(player.getName()).isEqualTo(name);
    }
}
