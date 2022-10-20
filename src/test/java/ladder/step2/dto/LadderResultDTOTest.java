package ladder.step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultDTOTest {
    @Test
    @DisplayName("사다리 결과 이름이 7자를 초과할 시 예외")
    void ladder_result_length_exceeded_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderResultDTO("12345678"))
                .withMessage("사다리 결과 이름은 7자를 초과할 수 없습니다.");
    }
}