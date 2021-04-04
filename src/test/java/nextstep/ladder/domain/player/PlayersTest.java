package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("참가자 이름으로 검색한다.")
    void searchPlayerByName() {
        List<Player> playerList =
                Arrays.asList(
                        new Player("pobi"),
                        new Player("honux"),
                        new Player("crong"),
                        new Player("jk"));

        Players players = new Players(playerList);
        assertThat(players.searchBy(new Name("jk"))).hasValue(playerList.get(3));
    }

}
