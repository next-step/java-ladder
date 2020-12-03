package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void notNull() {
        Assertions.assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
