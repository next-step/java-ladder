package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @Test
    void notNull() {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class Player {
        public Player(String name) {
            throw new IllegalArgumentException("이름이 반드시 제공되어야 한다");
        }
    }
}
