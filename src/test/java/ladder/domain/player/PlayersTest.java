package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PlayersTest {

    @Test
    @DisplayName("참가자 객체 생성")
    void createPlayers() {
        Players players = Players.of("aaa, bbb, ccc");

        assertThat(players.getCountOfPerson()).isEqualTo(3);
    }

    @Test
    @DisplayName("이름으로 참가자 찾기")
    void getPlayerFromName() {
        Players players = Players.of("aaa, bbb, ccc");

        Player player = players.get("aaa");

        assertThat(player.getName()).isEqualTo("aaa");
    }
}
