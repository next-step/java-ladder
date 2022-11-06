package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

    @DisplayName("잘못된 생성 시도")
    @Test
    void invalid() {
        assertThatThrownBy(() -> new LadderHeight(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 사다리 높이입니다.");
    }
}
