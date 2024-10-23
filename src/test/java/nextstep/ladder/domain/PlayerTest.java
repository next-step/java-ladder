package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void switch_position() {
        Player player1 = new Player("1", 0);
        Player player2 = new Player("2", 1);

        player1.switchPosition(player2);

        assertThat(player1.getPosition()).isEqualTo(1);
        assertThat(player2.getPosition()).isEqualTo(0);
    }
}
