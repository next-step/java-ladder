package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @DisplayName("플레이어 수가 결과 수 보다 많으면 예외가 발생한다.")
    @Test
    void gameException1() {
        Players players = Players.create("test1", "test2", "test3");
        String[] results = {"a", "b"};

        assertThatThrownBy(() -> Game.of(players, 3, results))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 수가 결과 수 보다 작으면 예외가 발생한다.")
    @Test
    void gameException2() {
        Players players = Players.create("test1", "test2");
        String[] results = {"a", "b", "d"};

        assertThatThrownBy(() -> Game.of(players, 3, results))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 1인 사다리의 경우 게임 결과가 정상적으로 나온다.")
    @Test
    void result1() {
        // |-----|     |
        List<Point> points = List.of(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, false));
        Line line = new Line(points);
        Players players = Players.create("test1", "test2", "test3");
        Ladder ladder = new Ladder(List.of(line));
        String[] results = {"a", "b", "c"};

        Game game = new Game(players, ladder, results);
        String result = game.resultTable().get(Player.of("test1"));

        assertThat(result).isEqualTo("b");
    }

    @DisplayName("높이가 2인 사다리의 경우 게임 결과가 정상적으로 나온다.")
    @Test
    void result2() {
        // |-----|     |
        // |     |-----|
        List<Point> pointsA = List.of(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, false));
        List<Point> pointsB = List.of(new Point(0, false, false),
                new Point(1, false, true),
                new Point(2, true, false));
        Line lineA = new Line(pointsA);
        Line lineB = new Line(pointsB);
        Players players = Players.create("test1", "test2", "test3");
        Ladder ladder = new Ladder(List.of(lineA, lineB));
        String[] results = {"a", "b", "c"};

        Game game = new Game(players, ladder, results);
        String result = game.resultTable().get(Player.of("test1"));

        assertThat(result).isEqualTo("c");
    }
}
