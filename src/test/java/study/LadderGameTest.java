package study;

import org.junit.jupiter.api.Test;
import study.core.Edge;
import study.core.Ladder;
import study.core.LadderGame;
import study.core.Line;
import study.core.PlayerName;
import study.core.Point;
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
        Ladder ladder = ladderGame.createLadder();
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    void play() {
        LadderGame ladderGame = new LadderGame(List.of(new PlayerName("a"), new PlayerName("b")), 3);
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Point.right(0), Point.left(1))),
                new Line(List.of(Point.pass(0), Point.pass(1))),
                new Line(List.of(Point.right(0), Point.left(1)))
        ));
        List<Prize> prizes = List.of(new Prize("1등"), new Prize("꽝"));

        Result result = ladderGame.play(ladder, prizes);
        assertThat(result.getResults().get(new PlayerName("a")).getValue()).isEqualTo("1등");
        assertThat(result.getResults().get(new PlayerName("b")).getValue()).isEqualTo("꽝");
    }
}
