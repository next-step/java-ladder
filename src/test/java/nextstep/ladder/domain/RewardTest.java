package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RewardTest {

    @ParameterizedTest
    @CsvSource(value = {"test"}, delimiter = ',')
    @DisplayName("정상적인 상품의 생성 테스트")
    void normalRewardTest(String name) {
        Reward reward = Reward.create(name);
        assertThat(reward).isEqualTo(Reward.create(name));
    }

    @Test
    @DisplayName("경품 이름이 5초과시 에러 테스트")
    void overRewardNameLengthTest() {
        assertThatThrownBy(() -> {
            Reward.create("CleanCode");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
