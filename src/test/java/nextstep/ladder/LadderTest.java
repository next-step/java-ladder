package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    Player pobi = new Player("pobi");
    Player honux = new Player("honux");
    Player crong = new Player("crong");
    Player jk = new Player("jk");

    List<Player> playerList = List.of(pobi, honux, crong, jk);
    Players players = new Players(playerList);

    @Test
    void newLadder() {
        assertThat(new Ladder(new Players("pobi,honux,crong,jk"), 5, "꽝,5000,꽝,3000").getLines().size()).isEqualTo(5);
    }

    @Test
    void play_trueLadder() {
        String prizeString = "꽝,5000,꽝,3000";

        Ladder ladder = new Ladder(players, 5, prizeString, () -> true);

        GameResult result = ladder.play(players);

        assertAll(
                () -> assertThat(result.getAllResults().size()).isEqualTo(players.getCount()),
                () -> assertThat(result.getResult(pobi)).isEqualTo(new Prize("5000")),
                () -> assertThat(result.getResult(honux)).isEqualTo(new Prize("꽝")),
                () -> assertThat(result.getResult(crong)).isEqualTo(new Prize("3000")),
                () -> assertThat(result.getResult(jk)).isEqualTo(new Prize("꽝"))
        );
    }

    @Test
    void play_falseLadder() {
        String prizeString = "꽝,5000,꽝,3000";

        Ladder ladder = new Ladder(players, 5, prizeString, () -> false);

        GameResult result = ladder.play(players);

        assertAll(
                () -> assertThat(result.getAllResults().size()).isEqualTo(players.getCount()),
                () -> assertThat(result.getResult(pobi)).isEqualTo(new Prize("꽝")),
                () -> assertThat(result.getResult(honux)).isEqualTo(new Prize("5000")),
                () -> assertThat(result.getResult(crong)).isEqualTo(new Prize("꽝")),
                () -> assertThat(result.getResult(jk)).isEqualTo(new Prize("3000"))
        );
    }

}
