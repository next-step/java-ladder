package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    void createPlayer() {
        Player wang = new Player(new PlayerName("wang"));
        assertThat(wang).isEqualTo(new Player(new PlayerName("wang")));
    }
}
