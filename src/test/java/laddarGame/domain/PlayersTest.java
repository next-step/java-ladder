package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayersTest {

    @DisplayName("입력 받은 순서대로 ,로 구분하여 분할하여 플레이어를 만든다.")
    @Test
    void Player() {
        Players players = new Players("LG,SKT");

        assertEquals(players.toList().get(0), new Player("LG", 0));
        assertEquals(players.toList().get(1), new Player("SKT", 1));
    }
}