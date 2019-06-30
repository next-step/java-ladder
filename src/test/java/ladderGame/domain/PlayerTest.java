package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("게임 참가자 생성")
    public void create() {
        Player player = Player.of("nike");
        assertThat(player.getName()).isEqualTo("nike");
    }
}
