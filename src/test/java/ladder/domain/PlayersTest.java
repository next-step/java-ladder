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
    private final String name = "pobi";
    private final String names = name + ",honux,crong,jk";
    private final List<String> nameList = Arrays.stream(names.split(",")).collect(Collectors.toList());

    @DisplayName("여러 Player를 생성할 수 있다.")
    @Test
    void create_player() {
        Players players = new Players(nameList);
        assertThat(players.getPlayers().get(0)).isEqualTo(new Player(name));
    }

    @DisplayName("null 또는 0개의 이름이 입력되면 예외를 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void validate_names(final List<String> input) {
        assertThatExceptionOfType(PlayersNamesException.class)
                .isThrownBy(() -> new Players(input))
                .withMessage(PlayersNamesException.MESSAGE);
    }

    @DisplayName("참가자 이름으로 Players 중 몇 번째인지 순서를 찾을 수 있다.")
    @Test
    void getPlayerPosition() {
        Players players = new Players(nameList);
        int position = players.getPlayerPosition(name);
        assertThat(position).isEqualTo(0);
    }

    @DisplayName("존재하지 않는 이름 입력 시 예외를 반환한다.")
    @Test
    void player_name_mismatch() {
        String searchName = "테스트";
        Players players = new Players(nameList);

        assertThatExceptionOfType(PlayerNameMismatchException.class)
                .isThrownBy(() -> players.getPlayerPosition(searchName))
                .withMessage(PlayerNameMismatchException.MESSAGE);
    }
}
