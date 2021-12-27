package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    private static final String EXCEPTION_MESSAGE = "사다리 높이는 2이상 10이하로 설정 해주세요.";

    @Test
    void 사다리_높이가_10초과_시_예외() {
        int height = 11;
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }

    @Test
    void 사다리_높이가_2미만_시_예외() {
        int height = 1;
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }
}