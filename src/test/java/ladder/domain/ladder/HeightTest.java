package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    void 사다리_높이가_10초과_시_예외() {
        int height = 11;
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상 10이하로 설정 해주세요.");
    }

    @Test
    void 사다리_높이가_1미만_시_예외() {
        int height = 0;
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상 10이하로 설정 해주세요.");
    }
}