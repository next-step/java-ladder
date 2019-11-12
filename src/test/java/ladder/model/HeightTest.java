package ladder.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    void 유효하지않은_길이_입력시_예외테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Height.of(1);
        }).withMessage("유효하지 않은 높이입니다.");
    }

    @Test
    void 유효한_길이_입력시_생성테스트() {
        assertThat(Height.of(2)).isEqualTo(Height.of(2));
    }
}