package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @DisplayName("사다리를 연결할 수 있다.")
    @Test
    void 사다리_연결() {
        assertThat(Ladder.create(4, 4).getLines()).hasSize(4);
    }

    @DisplayName("참여자가 2명 미만일때 에러")
    @Test
    void 사다리_에러() {
        assertThatThrownBy(() -> Ladder.create(4, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 1미만일 때 에러")
    @Test
    void 높이_에러() {
        assertThatThrownBy(() -> Ladder.create(0, 1))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
