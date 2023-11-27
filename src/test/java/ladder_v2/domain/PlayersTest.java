package ladder_v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class PlayersTest {

    @Test
    @DisplayName("Player는 최소 2명 이상이어야 합니다.")
    void testPlayers() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(List.of(new Name("pobi")));
        });
    }

    @Test
    @DisplayName("Player의 목록을 반환할 수 있다.")
    void returnPlayersName() {
        Players players = new Players(List.of(new Name("pobi"), new Name("ryan")));
        Assertions.assertThat(players.names()).containsExactly(new Name("pobi"), new Name("ryan"));
    }

    @Test
    @DisplayName("Player의 이름을 반환할 수 있다.")
    void returnPlayerName() {
        Players players = new Players(List.of(new Name("pobi"), new Name("ryan")));
        Assertions.assertThat(players.get(0)).isEqualTo(new Name("pobi"));
    }
}
