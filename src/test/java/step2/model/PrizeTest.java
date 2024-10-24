package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 사다리보상의 길이는 5자를 초과하면 안된다.
*/
public class PrizeTest {

    @DisplayName("사다리보상의 길이는 5자를 초과하면 안된다.")
    @Test
    void createPrizeLengthOverFiveThrowException() {
        assertThatThrownBy(() -> Prize.createPrize("testtest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리보상은 5자를 초과하면 안됩니다.");
    }
}
