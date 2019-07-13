package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrizeTest {
    @Test
    void create() {
        Prize prize = Prize.of("1000");
        assertThat(prize.getPrize()).isEqualTo("1000");
    }

    @Test
    void getResultPad() {
        Prize prize = Prize.of("1000");
        assertThat(prize.getPrizePad().length()).isEqualTo(6);
        assertThat(prize.getPrizePad()).isEqualTo("1000  ");
    }
}