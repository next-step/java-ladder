package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Players 클래스 테스트")
class PlayersTest {

    @DisplayName(", 를 기준으로 여러 Player를 생성할 수 있다.")
    @Test
    void create_player() {
        String name = "pobi";
        String names = name + ",honux,crong,jk";
        Players players = new Players(Arrays.stream(names.split(",")).collect(Collectors.toList()));

        assertThat(players.getPlayers().get(0)).isEqualTo(new Player(name));
    }

    @DisplayName("null 또는 0개의 이름이 입력되면 예외를 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void validate_names(final List<String> names) {
        assertThatExceptionOfType(PlayersNamesException.class)
                .isThrownBy(() -> new Players(names))
                .withMessage(PlayersNamesException.MESSAGE);
    }
}
