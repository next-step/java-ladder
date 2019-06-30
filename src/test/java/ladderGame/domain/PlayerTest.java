package ladderGame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void create() {
        Player player = Player.of("nike", 0);
        assertThat(player.getName()).isEqualTo("nike");
        assertThat(player.getPosition()).isEqualTo(0);
    }
}
