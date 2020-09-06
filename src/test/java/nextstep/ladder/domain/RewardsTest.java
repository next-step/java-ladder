package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {

    @ParameterizedTest
    @CsvSource(value = {"test1,test2,test3:3"}, delimiter = ':')
    @DisplayName("정상적인 상품목록의 생성 테스트")
    void normalRewardTest(String names,int size) {
        Rewards rewards = Rewards.create(names);
        assertThat(rewards.getRewards().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("2개 미만 상품생성시 에러 테스트")
    void normalRewardTest2() {
        assertThatThrownBy(() -> {
            Rewards.create("test1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
