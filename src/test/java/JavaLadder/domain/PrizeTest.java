package JavaLadder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTest {
    @Test
    public void prizeTest() {
        Prize prize = new Prize("꽝");
        assertThat(prize.getPrize()).isEqualTo("꽝");
    }
}
