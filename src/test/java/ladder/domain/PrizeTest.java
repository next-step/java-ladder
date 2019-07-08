package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PrizeTest {
    @Test
    void 각_사다리의_상품을_입력받아_생성한다() {
        String testPrize = "꽝";
        Prize prize = Prize.from(testPrize);

        assertThat(prize.getPrize()).isEqualTo(testPrize);
    }

    @Test
    void 상품이름이_공백이면_예외가_발생한다() {
        String emptyPrize = "";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Prize.from(emptyPrize);
                }).withMessage(Prize.ALERT_MISSING_PRIZE);
    }

    @Test
    void 상품이름이_다섯글자_이상이면_예외가_발생한다() {
        String lengthExceedPrizeName = "길이 제한을 초과하는 상품이름";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Prize.from(lengthExceedPrizeName);
                }).withMessage(Prize.ALERT_EXCEED_LENGTH_OF_PRIZE_NAME);
    }


}
