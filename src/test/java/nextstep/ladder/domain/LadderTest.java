package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("createLadder는 width 폭, height 높이의 사다리를 만든다.")
    @Test
    void createLadder() {
        Ladder ladder = Ladder.createLadder(4, 5);

        assertThat(ladder.getWidth()).isEqualTo(4);
        assertThat(ladder.getLines()).hasSize(5);
    }

    @DisplayName("사다리는 0보다 큰 width, height 를 가진다.")
    @Test
    void createLadder_Exception() {
        assertThatThrownBy(() -> Ladder.createLadder(0, 0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Ladder.createLadder(0, 2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Ladder.createLadder(2, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
