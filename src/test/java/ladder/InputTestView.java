package ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void testName1() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateParticipants("");
        });
    }

    @Test
    @DisplayName("참가자 이름이 5글자 초과 시 예외 발생")
    void testName2() {
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateParticipants("abcdef");
        });
    }
}