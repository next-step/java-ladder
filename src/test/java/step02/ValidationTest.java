package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.utils.Validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    @DisplayName("이름 길이 체크")
    void checkNameLength() {
        assertThatThrownBy(() -> {
            Validation.checkNameLength("");
        }).isInstanceOf(IllegalAccessException.class)
                .hasMessage("이름은 1~5글자 이내로 입력해주세요");
    }

    @Test
    @DisplayName("높이가 0 입력 테스트")
    void checkZeroLine() {
        assertThatThrownBy(() -> {
            Validation.checkZeroLine(0);
        }).isInstanceOf(IllegalAccessException.class)
                .hasMessage("사다리는 높이 0이상으로 입력해주세요.");
    }
}
