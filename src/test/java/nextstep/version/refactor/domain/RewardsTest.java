package nextstep.version.refactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {


    @DisplayName("상품 리스트를 만들 수 있다.")
    @Test
    void createPrize() {
        Rewards prize = new Rewards("꽝,우승");
        Assertions.assertThat(prize).isEqualTo(new Rewards("꽝,우승"));
    }
}
