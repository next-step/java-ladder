package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PlayerTest {

    @Test
    void testGetName() {
        String name = "test";
        Player player = Player.of(name);

        String playerName = player.getName();

        assertThat(playerName).isEqualTo(name);
    }
}