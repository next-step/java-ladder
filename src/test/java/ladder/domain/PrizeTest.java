package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void 각_사다리의_상품을_입력받아_생성한다() {
        String testPrize = "꽝";
        Prize prize = Prize.from(testPrize);

        assertThat(prize.getPrize()).isEqualTo(testPrize);
    }
}
