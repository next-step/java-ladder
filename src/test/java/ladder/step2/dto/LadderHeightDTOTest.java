package ladder.step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
class LadderHeightDTOTest {
    public static final LadderHeightDTO LADDER_HEIGHT_DTO = new LadderHeightDTO("1");
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    
    @Test
    @DisplayName("최대 사다리의 높이 입력 값을 반환한다.")
    void inputLadderHeight() {
        assertThat(LADDER_HEIGHT_DTO.getLadderHeight()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("최대 사다리 높이 입력 시, 숫자가 아닌 값 입력 시 예외 던지기")
    void inputLadderHeightNonNumberException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeightDTO("abc"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("최대 사다리 높이 입력 시, \"\" 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @EmptySource
    void inputLadderHeightNullOrEmptyException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeightDTO(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("최대 사다리 높이 입력 시, 그냥 0 또는 두 자릿수 이상에서 첫번째 자리에 0을 입력 시 예외 던지기")
    @ParameterizedTest(name = "{displayName} : {0}")
    @ValueSource(strings = {"0", "04", "011"})
    void inputLadderHeightZeroException(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeightDTO(input))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("최대 사다리 높이 입력 시, 음수를 입력 시 예외 던지기")
    void inputLadderHeightNegativeNumberException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeightDTO("-2"))
                .withMessage(INPUT_EXCEPTION_MESSAGE);
    }
}