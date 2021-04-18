package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AwardTest {

    @DisplayName("보상 수여 테스트")
    @Test
    void getAwardTest() {
        String names = "aa,bb,cc,dd";
        Players players = Players.of(names);
        Player aa = players.getPlayersByName("aa").get(0);
        Player bb = players.getPlayersByName("bb").get(0);
        Player cc = players.getPlayersByName("cc").get(0);
        Player dd = players.getPlayersByName("dd").get(0);

        String gifts = "꽝,1000,꽝,2000";
        Prizes prizes = Prizes.of(gifts, players.getSize());

        Award award = new Award(players.getPlayers(), prizes.getPrizes());
        Map<Player, String> awards = award.getAward();

        Assertions.assertAll(
                () -> assertEquals(awards.get(aa), "꽝"),
                () -> assertEquals(awards.get(bb), "1000"),
                () -> assertEquals(awards.get(cc), "꽝"),
                () -> assertEquals(awards.get(dd), "2000")
        );
    }

}