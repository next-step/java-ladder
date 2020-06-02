package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardTests {
    @DisplayName("상품명과 상품 당첨 Player를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new Reward("100",
                new Player("poppo", new HorizontalLocation(0, 3))))
                .isNotNull();
    }
}
