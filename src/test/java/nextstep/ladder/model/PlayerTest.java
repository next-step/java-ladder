package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void create() {
        Player player = new Player("test", 0);
        assertThat(player).isEqualTo(new Player("test", 0));
    }

    @DisplayName("왼쪽 이동할 경우, Position을 -1 감소시킨다")
    @Test
    void moveToLeft() {
        Player player = new Player("test", 1);
        player.moveTo(Direction.LEFT);

        assertThat(player).isEqualTo(new Player("test", 0));
    }

    @DisplayName("오른쪽 이동할 경우, Position을 +1 증가시킨다")
    @Test
    void moveToRight() {
        Player player = new Player("test", 0);
        player.moveTo(Direction.RIGHT);

        assertThat(player).isEqualTo(new Player("test", 1));
    }
}
