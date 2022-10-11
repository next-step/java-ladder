package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    void size() {
        List<Player> players = List.of(new Player("apple", new Position(0)));

        assertThat(new Players(players).count()).isEqualTo(players.size());
    }

    @Test
    void move() {
        Players players = players();
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);

        Players expected = new Players(List.of(
                new Player("a", new Position(1)),
                new Player("b", new Position(0)),
                new Player("c", new Position(2)),
                new Player("d", new Position(4)),
                new Player("e", new Position(3))));
        assertThat(players.move(line)).isEqualTo(expected);
    }

    @Test
    void findByName() {
        Players players = players();
        Player player = players.findByName("a");

        assertThat(player).isEqualTo(new Player("a", new Position(0)));
    }

    @DisplayName("이름에 해당하는 플레이어가 존재하지 않으면 에러 발생")
    @Test
    void findByName_fail() {
        Players players = players();

        assertThatThrownBy(() -> players.findByName("f"))
                .isInstanceOf(NoSuchElementException.class);
    }

    private Players players() {
        return new Players(List.of(
                new Player("a", new Position(0)),
                new Player("b", new Position(1)),
                new Player("c", new Position(2)),
                new Player("d", new Position(3)),
                new Player("e", new Position(4))));
    }
}
