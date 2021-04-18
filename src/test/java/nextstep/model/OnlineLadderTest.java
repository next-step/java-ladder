package nextstep.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlineLadderTest {
    @Test
    void winner() {
        OnlineLadder onlineLadder = new OnlineLadder(2, 3, new String[]{"bong", "big", "il"});
        assertThat(onlineLadder.points(0).points()).contains(false, true);
    }
}
