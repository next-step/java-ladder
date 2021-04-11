package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("게임?")
    void game() {
        Ladder ladder = new OnlineLadder(2);
        ladder.add("bong");
        ladder.add("big");
        ladder.move();
        assertThat(ladder.heights()).contains(1);
    }

    @Test
    @DisplayName("사다리그리기테스트")
    void ladderString() {
    }
}
