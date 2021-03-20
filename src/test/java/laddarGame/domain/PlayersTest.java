package laddarGame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("이름을 ,기준으로 분할한다.")
    @Test
    void parse() {
        Players players = new Players();
        String[] names = players.nameParser("LG,SKT");

        Assertions.assertEquals(names[1], "LG");
        Assertions.assertEquals(names[2], "SKT");
    }
}