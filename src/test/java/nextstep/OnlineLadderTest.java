package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("게임?")
    void game() {
        OnlineLadder ladder = new OnlineLadder(2);
        ladder.add("bong");
        ladder.add("big");
        ladder.add("cptbong");
        ladder.move();
        assertThat(ladder.heights()).contains(2);
    }
}
