package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("이름들을 받아 새로운 플레이어들을 생성한다.")
    void Players_PlayerNames() {
        final List<String> playerNames = List.of("kyle", "alex", "haley");
        final Players players = Players.from(playerNames);

        assertThat(players.names())
                .containsExactlyElementsOf(playerNames);
    }

    @Test
    @DisplayName("플레이어가 한 명도 없는 경우 예외를 던진다.")
    void Players_EmptyPlayerNames_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.from(List.of()));
    }

    @Test
    @DisplayName("플레이어가 중복되는 경우 예외를 던진다.")
    void Players_DuplicatedPlayerNames_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.from(List.of("kyle", "kyle", "alex")));
    }
}
