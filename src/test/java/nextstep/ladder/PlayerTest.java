package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    void createPlayer() {
        Player wang = new Player(new UserName("wang"));
        assertThat(wang).isEqualTo(new Player(new UserName("wang")));
    }
}
