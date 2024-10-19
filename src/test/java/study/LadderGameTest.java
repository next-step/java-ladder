package study;

import org.junit.jupiter.api.Test;
import study.core.LadderGame;
import study.core.Line;
import study.core.PlayerName;
import study.core.Prize;
import study.core.Result;

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

    @Test
    void play() {
        LadderGame ladderGame = new LadderGame(List.of(new PlayerName("a"), new PlayerName("b")), 3);
        List<Line> ladder = List.of(
                new Line(List.of(true)),
                new Line(List.of(false)),
                new Line(List.of(true))
        );
        List<Prize> prizes = List.of(new Prize("1등"), new Prize("꽝"));

        Result result = ladderGame.play(ladder, prizes);
        assertThat(result.getResults().get(new PlayerName("a")).getValue()).isEqualTo("1등");
        assertThat(result.getResults().get(new PlayerName("b")).getValue()).isEqualTo("꽝");
    }
}
