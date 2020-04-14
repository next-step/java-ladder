package ladder.prize.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("게임 결과의 개별 값인 Prize 를 생성할 수 있다")
    @Test
    public void newPrizeTest() {
        Prize prize = Prize.of("1등");
        Prize another = Prize.of("1등");

        Assertions.assertThat(prize).isEqualTo(another);
    }

}
