package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @DisplayName("참가자를 생성한다.")
    @Test
    void create() {
        Player player = new Player("test");
        assertThat(player).isEqualTo(new Player("test"));
    }
}
