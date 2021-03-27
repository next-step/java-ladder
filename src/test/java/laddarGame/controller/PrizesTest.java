package laddarGame.controller;

import laddarGame.domain.Player;
import laddarGame.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrizesTest {

    @DisplayName("플레이어를 사다리 결과와 매칭시킨다.")
    @Test
    void match() {
        Prizes prizes = new Prizes("A,B,C,D");
        Players players = createPlayers();

        Map<String, String> result = prizes.match(players);

        assertEquals(result.get("LG"), "A");
    }

    @DisplayName("플레이어와 사다리 실행결과 갯수는 같아야 한다.")
    @Test
    void match() {
        Prizes prizes = new Prizes("A,B,C,D,E");
        Players players = createPlayers();

        assertThrows(IllegalArgumentException.class, prizes.match(players));
    }

    Players createPlayers() {
        return new Players(
                List.of(new Player("LG", 0)
                        , new Player("SKT", 1)
                        , new Player("KT", 2)
                        , new Player("TS", 3)));
    }
}