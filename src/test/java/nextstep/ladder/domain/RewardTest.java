package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RewardTest {

    @ParameterizedTest
    @CsvSource(value = {"test,6"}, delimiter = ',')
    @DisplayName("정상적인 상품의 생성 테스트")
    void normalRewardTest(String name) {
        Reward reward = Reward.newInstance(name,0);
        assertThat(reward).isEqualTo(Reward.newInstance(name,0));
    }

    @Test
    @DisplayName("경품 이름이 5초과시 에러 테스트")
    void overRewardNameLengthTest() {
        assertThatThrownBy(() -> {
            Reward.newInstance("CleanCode",0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
