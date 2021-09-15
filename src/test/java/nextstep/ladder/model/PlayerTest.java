package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {
    @Test
    @DisplayName("움직임에 따라 currentWidth 변경")
    public void currentWidth() {
        Player player = new Player(1);

        player.goLeft();

        assertThat(player.getCurrentWidth()).isEqualTo(0);

        player.goRight();
        player.goRight();

        assertThat(player.getCurrentWidth()).isEqualTo(2);
    }
}