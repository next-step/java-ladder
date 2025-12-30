package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class RewardsTest {

    @Test
    void 결과_정상_생성() {
        Rewards rewards = new Rewards("꽝,5000,꽝,3000");
        assertThat(rewards.getRewards()).hasSize(4);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름_공백_또는_null일경우_에러발생(String value){
            assertThatThrownBy(() -> new Rewards(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("결과 입력은 필수입니다.");
    }

}