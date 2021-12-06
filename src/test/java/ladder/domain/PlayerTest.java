package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("선수 생성")
    void create() {
        Player player = new Player(new PlayerName("kang"));
        assertThat(player).isEqualTo(new Player(new PlayerName("kang")));
    }

}
