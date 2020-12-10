package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderDtoHeightTest {

    @DisplayName("사다리 높이 유효성 검사 예외 발생 테스트")
    @Test
    public void ladderHeightInvalidTest() {
        assertThatThrownBy(() -> {
            LadderHeight ladderHeight = new LadderHeight(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
