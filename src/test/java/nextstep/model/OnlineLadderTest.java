package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    @DisplayName("기본동작")
    void init() {
        OnlineLadder onlineLadder = new OnlineLadder(2, 3, new String[]{"bong", "big", "il"});
        assertThat(onlineLadder.points(0).points()).contains(false, true);
    }

    @Test
    @DisplayName("당첨자")
    void winner() {
        OnlineLadder onlineLadder = new OnlineLadder(2, 3, new String[]{"bong", "big", "il"});
        assertThat(onlineLadder.winner(new Player("bong"))).isEqualTo("..............");
    }
}
