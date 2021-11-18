package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WidthTest {

    @DisplayName("value 의 크기가 2 보다 작을 경우 illegal exception")
    @Test
    void lessThanOneTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Width.create(1));
    }

    @DisplayName("getEndLine 은 value 보다 -1 된 값을 반환한다.")
    @Test
    void getEndLineTest() {
        Width width = Width.create(5);
        assertThat(width.getEndLine()).isEqualTo(4);
    }
}
