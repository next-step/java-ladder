package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @DisplayName("사다리 라인을 그릴 수 있다.")
    @Test
    void 사다리_라인_그리기() {
        assertThat(Line.create(4).getPoints()).hasSize(3);
    }

    @DisplayName("참여자가 2명 미만일때 에러")
    @Test
    void 사다리_에러() {
        assertThatThrownBy(() -> Line.create(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
