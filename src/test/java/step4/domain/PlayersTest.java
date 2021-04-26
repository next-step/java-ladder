package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.IllegalPlayerName;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayersTest {

    @DisplayName("이름을 분리하는 메소드 테스트")
    @Test
    void playerSplitTest() {
        String names = "aa,bb,cc";
        String[] split = names.split(",");
        Players players = Players.of(names);

        assertAll(
                () -> assertTrue(players.getPlayers().contains(new Player(split[0], new Position(0)))),
                () -> assertTrue(players.getPlayers().contains(new Player(split[1], new Position(1)))),
                () -> assertTrue(players.getPlayers().contains(new Player(split[2], new Position(2))))
        );
    }

    @DisplayName("player이름이 잘못된 경우 테스트")
    @Test
    void getPlayerNameTest() {
        String names = "aa,bb,cc";
        Players players = Players.of(names);
        Assertions.assertThrows(IllegalPlayerName.class, () -> players.getPlayersByName("aaa"));
    }
}
