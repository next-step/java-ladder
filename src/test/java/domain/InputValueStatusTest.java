package domain;

import ladder.domain.InputValueStatus;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueStatusTest {

    private static InputValueStatus inputValueStatusTest;

    @Test
    void 이름_입력값_null_Test() {
        assertThatThrownBy(() ->
                inputValueStatusTest = new InputValueStatus(null, 5)
        ).isInstanceOf(NullPointerException.class)
                .withFailMessage(ErrorMessage.getCheckInputNames());
    }

    @Test
    void 이름_입력값_empty_Test() {
        assertThatThrownBy(() ->
                inputValueStatusTest = new InputValueStatus("", 5)
        ).isInstanceOf(NullPointerException.class)
                .withFailMessage(ErrorMessage.getCheckInputNames());
    }

    @Test
    void 사다리높이_입력값_0_테스트() {
        assertThatThrownBy(() ->
                inputValueStatusTest = new InputValueStatus("kim,jin,seok", 0)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputLadderHeight());
    }

    @Test
    void 사다리높이_입력값_음수_테스트() {
        assertThatThrownBy(() ->
                inputValueStatusTest = new InputValueStatus("kim,jin,seok", -30)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputLadderHeight());
    }
}
