package nextstep.ladder.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void createTest() {
        Player player = new Player("pobi");
        assertThat(player).isEqualTo(new Player("pobi"));
    }

    @Test
    void throwExceptionTest() {
        assertThatThrownBy(() -> new Player("pobi56")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid player name length");
    }
}
