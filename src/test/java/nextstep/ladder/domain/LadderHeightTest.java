package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @DisplayName("사다리 높이가 최소값을 초과하여 에러를 반환한다.")
    @Test
    void minheightException() {
        assertThatThrownBy(() -> {
            new LadderHeight(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}