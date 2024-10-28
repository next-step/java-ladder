package nextstep.ladder.v1;

import nextstep.ladder.v1.model.Prize;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("Prize class 생성")
    void createPrizeTest() {
        //given
        String prizeValue = "꽝";

        //when
        Prize prize = new Prize(prizeValue);

        //then
        Assertions.assertThat(prize.getWorth()).isEqualTo(prizeValue);
    }

    @Test
    @DisplayName("Prize class empty string value 입력 예외")
    void createPrizeTest_WithEmptyStringValue() {
        //given
        String prizeValue = "";

        //when
        ThrowableAssert.ThrowingCallable callable = () -> new Prize(prizeValue);

        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
