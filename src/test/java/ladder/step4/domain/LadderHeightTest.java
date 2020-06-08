package ladder.step4.domain;

import ladder.step4.exception.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderHeightTest {

    @DisplayName("사다리 높이가 1 미만일 경우 LadderHeightMinimumSizeException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 최소값_검증_테스트(int height) {
        assertThatExceptionOfType(LadderHeightMinimumSizeException.class)
            .isThrownBy(() -> LadderHeight.valueOf(height));
    }

    @DisplayName("사다리 높이에 대한 입력값이 숫자가 아닐경우 LadderHeightNonNumberException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "!@#", "높이"})
    void 숫자_검증_테스트(String height) {
        assertThatExceptionOfType(LadderHeightNonNumberException.class)
            .isThrownBy(() -> LadderHeight.valueOf(height));
    }

    @DisplayName("사다리 높이에 대한 입력값이 문자열 형태의 숫자일 때 잘 생성 되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 형변환_테스트(String height) {
        assertEquals(Integer.parseInt(height), LadderHeight.valueOf(height).getValue());
    }

    @DisplayName("값 객체 재활용 여부 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 재활용_테스트(String height) {
        assertEquals(LadderHeight.valueOf(height), LadderHeight.valueOf(height));
    }
}
