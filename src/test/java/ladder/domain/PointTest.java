package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("0 미만의 값을 할당하는 경우 Point 객체를 생성하는데 실패한다.")
    void create() {
        assertThatThrownBy(() -> new Point(0, -1)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0 이상의 값만 입력 가능합니다.");
    }
}