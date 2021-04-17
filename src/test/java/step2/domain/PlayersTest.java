package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    
    @DisplayName("이름을 분리하는 메소드 테스트")
    @Test
    void playerSplitTest() {
        String names = "aa,bb,cc";
        String[] split = names.split(",");

        Players players = Players.of(names);

        assertAll(
                () -> assertTrue(players.getPlayers().contains(new Player(split[0]))),
                () -> assertTrue(players.getPlayers().contains(new Player(split[1]))),
                () -> assertTrue(players.getPlayers().contains(new Player(split[2])))
        );
    }

}