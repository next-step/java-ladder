package ladder.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void nameOver5GetsError() {
        assertThatThrownBy(() -> new Player("123456")).isInstanceOf(IllegalArgumentException.class);
    }
}
