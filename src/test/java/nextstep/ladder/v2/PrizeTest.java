package nextstep.ladder.v2;

import nextstep.ladder.v2.model.Prize;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("prize class 생성 - 꽝")
    void createPrizeTest_ZeroWorth() {
        //given
        String worth = "꽝";

        //when
        Prize prize = new Prize(worth);

        //then
        Assertions.assertThat(prize).isEqualTo(new Prize(worth));
    }

    @Test
    @DisplayName("prize class 생성")
    void createPrizeTest_NotZeroWorth() {
        //given
        String worth = "5000";

        //when
        Prize prize = new Prize(worth);

        //then
        Assertions.assertThat(prize).isEqualTo(new Prize(worth));
    }

    @Test
    @DisplayName("prize class 생성 - 음수")
    void createPrizeTest_NegativeWorth() {
        //given
        String worth = "-5000";

        //when
        ThrowableAssert.ThrowingCallable callable = () -> new Prize(worth);

        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
