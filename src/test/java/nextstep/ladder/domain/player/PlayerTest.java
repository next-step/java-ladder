package nextstep.ladder.domain.player;

import nextstep.ladder.domain.direction.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void create() {
        assertThat(new Player("test")).isEqualTo(new Player("test", 0));
    }

    @Test
    void movePoint() {
        Player player = new Player("1", 0);

        player.movePoint(Direction.RIGHT_DOWN);
        player.movePoint(Direction.RIGHT_DOWN);
        player.movePoint(Direction.LEFT_DOWN);

        assertThat(player.getPosition()).isEqualTo(1);
    }
}
