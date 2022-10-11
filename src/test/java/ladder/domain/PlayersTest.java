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
        List<Player> players = List.of(new Player(new PlayerName("apple"), new Position(0)));

        assertThat(new Players(players).count()).isEqualTo(players.size());
    }

    @Test
    void move() {
        Players players = players();
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);

        Players expected = new Players(List.of(
                new Player(new PlayerName("a"), new Position(1)),
                new Player(new PlayerName("b"), new Position(0)),
                new Player(new PlayerName("c"), new Position(2)),
                new Player(new PlayerName("d"), new Position(4)),
                new Player(new PlayerName("e"), new Position(3))));
        assertThat(players.move(line)).isEqualTo(expected);
    }

    @Test
    void findByPlayerName() {
        Players players = players();
        Player player = players.findByPlayerName(new PlayerName("a"));

        assertThat(player).isEqualTo(new Player(new PlayerName("a"), new Position(0)));
    }

    @DisplayName("이름에 해당하는 플레이어가 존재하지 않으면 에러 발생")
    @Test
    void findByPlayerName_fail() {
        Players players = players();

        assertThatThrownBy(() -> players.findByPlayerName(new PlayerName("f")))
                .isInstanceOf(NoSuchElementException.class);
    }

    private Players players() {
        return new Players(List.of(
                new Player(new PlayerName("a"), new Position(0)),
                new Player(new PlayerName("b"), new Position(1)),
                new Player(new PlayerName("c"), new Position(2)),
                new Player(new PlayerName("d"), new Position(3)),
                new Player(new PlayerName("e"), new Position(4))));
    }
}
