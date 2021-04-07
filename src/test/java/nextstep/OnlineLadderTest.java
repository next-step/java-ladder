package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("게임?")
    void game() {
        Ladder ladder = new OnlineLadder(2) {
            @Override
            public void move() {
                coordinates.get(0).move();
            }
        };
        ladder.add("bong");
        ladder.add("big");
        ladder.move();
        assertThat(ladder.heights()).contains(1);
    }
}
