package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    void size() {
        List<Player> players = List.of(new Player("apple", 0));

        assertThat(new Players(players).count()).isEqualTo(players.size());
    }

    @Test
    void move() {
        Players players = new Players(List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3),
                new Player("e", 4)));
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);

        Players expected = new Players(List.of(
                new Player("a", 1),
                new Player("b", 0),
                new Player("c", 2),
                new Player("d", 4),
                new Player("e", 3)));
        assertThat(players.move(line)).isEqualTo(expected);
    }
}
