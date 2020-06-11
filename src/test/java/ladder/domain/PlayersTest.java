package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Players 클래스 테스트")
class PlayersTest {

    @DisplayName(", 를 기준으로 여러 Player를 생성할 수 있다.")
    @Test
    void create_player() {
        String name = "pobi";
        String names = name + ",honux,crong,jk";
        Players players = new Players(names);

        assertThat(players.getPlayers().get(0)).isEqualTo(new Player(name));
    }
}
