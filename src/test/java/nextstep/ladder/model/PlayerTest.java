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

    @DisplayName("왼쪽 이동할 경우, Position을 -1 감소시킨 Player 객체 반환한다")
    @Test
    void moveLeft() {
        Player player = new Player("test", 1);

        Player result = player.moveLeft();

        assertThat(result).isEqualTo(new Player("test", 0));
    }

    @DisplayName("오른쪽 이동할 경우, Position을 +1 증가시킨다 Player 객체 반환한다")
    @Test
    void moveRight() {
        Player player = new Player("test", 0);

        Player result = player.moveRight();

        assertThat(result).isEqualTo(new Player("test", 1));
    }
}
