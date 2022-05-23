package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void nameOver5GetsError() {
        assertThatThrownBy(() -> new Player("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseToPlayers() {
        assertThat(Player.parse("a,b")).isEqualTo(new Players(Arrays.asList(new Player("a"), new Player("b"))));
    }

    @Test
    void payloadWithSize6() {
        assertThat(new Player("test").payload()).hasSize(6);
    }
}
