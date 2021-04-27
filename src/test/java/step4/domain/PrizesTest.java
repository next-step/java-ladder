package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.IllegalPlayerSizeException;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrizesTest {

    @DisplayName("상품갯수와 player들의 숫자가 맞지 않을경우")
    @Test
    void prizesSizeTest() {
        String gifts = "꽝,2000,꽝,3000";
        int playerSize = 3;

        assertThrows(IllegalPlayerSizeException.class, () -> Prizes.of(gifts, playerSize));
    }
    
    @DisplayName("상품 수여 테스트")
    @Test
    void awardTest() {

        Players players = Players.of("aa,bb,cc,dd");
        Player aa = players.getPlayersByName("aa").get(0);
        Player bb = players.getPlayersByName("bb").get(0);
        Player cc = players.getPlayersByName("cc").get(0);
        Player dd = players.getPlayersByName("dd").get(0);

        String gifts = "꽝,5000,꽝,10000";
        int playerSize = 4;
        Prizes prizes = Prizes.of(gifts, playerSize);

        Map<Player, String> awards = prizes.getAward(players.getPlayers());

        Assertions.assertAll(
                () -> assertEquals(awards.get(aa), "꽝"),
                () -> assertEquals(awards.get(bb), "5000"),
                () -> assertEquals(awards.get(cc), "꽝"),
                () -> assertEquals(awards.get(dd), "10000")
        );

    }
}
