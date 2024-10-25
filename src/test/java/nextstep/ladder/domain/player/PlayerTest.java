package nextstep.ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void create() {
        assertThat(new Player("test")).isEqualTo(new Player("test", 0));
    }

    @Test
    void switchPosition() {
        Player player1 = new Player("1", 0);
        Player player2 = new Player("2", 1);

        player1.switchPosition(player2);

        assertThat(player1.getPosition()).isEqualTo(1);
        assertThat(player2.getPosition()).isEqualTo(0);
    }
}
