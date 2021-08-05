package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    void checkName() {
        assertThat(
                new Player(
                        new Name("pp")
                ).checkName(new Name("pp"))
        ).isTrue();
    }
}