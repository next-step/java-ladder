package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    public void create() {
        String fiveCharName = "AAAAA";
        Player player = new Player(fiveCharName);
        assertThat(player.getName()).isEqualTo(fiveCharName);

        String sixCharName = "AAAAAA";
        assertThatThrownBy(() -> new Player(sixCharName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
