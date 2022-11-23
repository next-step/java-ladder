package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveIntTest {

    @Test
    @DisplayName("음수 값을 할당하는 경우 PositiveInt 객체를 생성하는데 실패한다.")
    void create_with_negative_value() {
        assertThatThrownBy(() -> new PositiveInt(-2)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0 이상의 값만 입력 가능합니다.");
    }

    @Test
    @DisplayName("plus 메소드는 현재 value와 입력 받은 값을 더한 PositiveInt 객체를 반환한다.")
    void plus() {
        PositiveInt x = new PositiveInt(5);
        assertThat(x.plus(3)).isEqualTo(new PositiveInt(8));
    }
}