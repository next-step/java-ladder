package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @DisplayName("사다리를 연결할 수 있다.")
    @Test
    void 사다리_연결() {
        assertThat(new Ladder(4, 4).getLines()).hasSize(4);
    }

    @DisplayName("참여자가 2명 미만일때 에러")
    @Test
    void 사다리_에러() {
        assertThatThrownBy(() -> new Ladder(4, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 1미만일 때 에러")
    @Test
    void 높이_에러() {
        assertThatThrownBy(() -> new Ladder(0, 1))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
