package ladder.domain.player;

import ladder.domain.common.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    void getMaxLength() {
        Player player1 = new Player(new Name("chan"), new Point(1, 1));
        Player player2 = new Player(new Name("c"), new Point(2, 1));
        Players players = new Players(Arrays.asList(player1, player2));

        assertThat(players.getMaxLength()).isEqualTo(4);
    }
}