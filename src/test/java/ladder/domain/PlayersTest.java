package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlayersTest {
    @Test
    @DisplayName("중복된 Player를 제외한다.")
    void distinctPlayerTest() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Alice");
        Player player3 = new Player("Bob");

        Players players = new Players(List.of(player1, player2, player3));

        Assertions.assertEquals(players.countOfPlayer(), 2);
    }

}
