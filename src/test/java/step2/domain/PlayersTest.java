package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.IllegalPlayerName;
import step2.view.ResultView;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

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

    @DisplayName("사다리 결과 테스트")
    @Test
    void getWinnerTest() {
        String names = "aa,bb,cc";

        Players players = Players.of(names);
        CustomCondition condition = new CustomCondition();
        Lines lines = Lines.of(3, 3, condition);

        Players result = players.getResult(lines);

        Player aa = result.getPlayers().get(0);
        Player bb = result.getPlayers().get(1);
        Player cc = result.getPlayers().get(2);

        Assertions.assertAll(
                () -> assertEquals(aa, new Player("aa", new Position(1))),
                () -> assertEquals(bb, new Player("bb", new Position(0))),
                () -> assertEquals(cc, new Player("cc", new Position(2)))
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