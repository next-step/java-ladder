package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    @DisplayName("실패 - value에 음수를 전달할 경우 예외가 발생한다.")
    void initTest() {
        assertThatThrownBy(() -> new Point(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("value는 0 미만일 수 없습니다.");
    }


}