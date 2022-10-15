package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LadderHeightTest {

    @DisplayName("사다리 높이가 1 보다 같거나 큰 값이 들어오면 예외가 발생하지 않아야 한다.")
    @Test
    void create() {
        assertThatNoException()
                .isThrownBy(() -> new LadderHeight(1));
    }

    @DisplayName("사다리 높이가 1 보다 작으면 예외가 발생해야 한다.")
    @Test
    void create_givenValueUnderMinValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeight(0));
    }

}
