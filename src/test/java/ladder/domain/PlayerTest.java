package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void autoIncrementTest() {
        Player.autoIncrement = 0;
        Player player0 = new Player("a");
        Player player1 = new Player("b");
        Player playerWithoutNo = new Player("z", 2);
        Player player2 = new Player("c");
        assertThat(player0).isEqualTo(new Player("a", 0));
        assertThat(player1).isEqualTo(new Player("b", 1));
        assertThat(playerWithoutNo).isEqualTo(new Player("z", 2));
        assertThat(player2).isEqualTo(new Player("c", 2));
    }

    @Test
    void nameOver5GetsError() {
        assertThatThrownBy(() -> new Player("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}
