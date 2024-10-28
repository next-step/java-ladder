package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("플레이어 객체를 생성할 수 있다.")
    @Test
    void createPlayerTest() {
        String name = "joe";
        Player player = Player.of(name);

        assertThat(player.playerName()).isEqualTo(name);
    }

}