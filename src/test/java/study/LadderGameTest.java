package study;

import org.junit.jupiter.api.Test;
import study.core.LadderGame;
import study.core.Line;
import study.core.PlayerName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void createLadder() {
        List<PlayerName> names = List.of(
                new PlayerName("pobi"),
                new PlayerName("honux"),
                new PlayerName("crong"),
                new PlayerName("jk"));
        LadderGame ladderGame = new LadderGame(names, 5);
        List<Line> ladder = ladderGame.createLadder();
        assertThat(ladder.size()).isEqualTo(5);
    }
}
