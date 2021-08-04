package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationTest {
    @Test
    @DisplayName("이름 공백 예외처리")
    void inputStrValidationTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Validation.inputValidation(""));
        assertThat(exception.getMessage()).isEqualTo("이름을 공백으로 할 수 없습니다.");
    }
}