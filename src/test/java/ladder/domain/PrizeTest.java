package ladder.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    void 생성자() {
        Assertions.assertThat(new Prize("꽝,5000,꽝,3000")).isInstanceOf(Prize.class);
    }

    @Test
    void 상품가져오기() {
        Prize prize = new Prize("꽝,5000,꽝,3000");

        Assertions.assertThat(prize.getPrize(0)).isEqualTo("꽝");
        Assertions.assertThat(prize.getPrize(3)).isEqualTo("3000");
    }
}
