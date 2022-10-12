package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void create() {
        Line line = new Line(List.of(true, false, true));
        Ladder ladder = new Ladder(4, 2, playerCount -> line);

        assertThat(ladder).isEqualTo(new Ladder(List.of(line, line)));
    }

    @Test
    void goDown() {
        Players players = new Players(List.of(
                new Player(new PlayerName("a"), new Position(0)),
                new Player(new PlayerName("b"), new Position(1)),
                new Player(new PlayerName("c"), new Position(2)),
                new Player(new PlayerName("d"), new Position(3)),
                new Player(new PlayerName("e"), new Position(4))));
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);
        Ladder ladder = new Ladder(players.count(), 3, playerCount -> line);

        Players expected = new Players(List.of(
                new Player(new PlayerName("a"), new Position(1)),
                new Player(new PlayerName("b"), new Position(0)),
                new Player(new PlayerName("c"), new Position(2)),
                new Player(new PlayerName("d"), new Position(4)),
                new Player(new PlayerName("e"), new Position(3))));
        assertThat(ladder.goDown(players)).isEqualTo(expected);
    }
}
