package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WidthTest {

    @DisplayName("value 의 크기가 2 보다 작을 경우 illegal exception")
    @Test
    void lessThanOneTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Width.of(1));
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        assertThat(Width.of(2)).isEqualTo(Width.of(2));
    }

}
