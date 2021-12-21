package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("test", Index.ONE);
    }

    @Test
    @DisplayName("Player가 Point의 Index가 같을 때")
    void rightDirectionTest() {
        Point point = new Point(Index.ONE, true);
        Direction direction = Direction.of(player, point);
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("Player가 Point보다 오른쪽에 있을 때")
    void leftDirectionTest() {
        Point point = new Point(Index.ZERO, true);
        Direction direction = Direction.of(player, point);
        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("Player가 Point와 인접하지 않았을 때")
    void passDirectionTest() {
        Point point = new Point(3, true);
        Direction direction = Direction.of(player, point);
        assertThat(direction).isEqualTo(Direction.PASS);
    }

    @Test
    @DisplayName("다리가 활성화되있지 않을 때")
    void passDirectionNotActive() {
        Point point = new Point(1, false);
        Direction direction = Direction.of(player, point);
        assertThat(direction).isEqualTo(Direction.PASS);
    }
}