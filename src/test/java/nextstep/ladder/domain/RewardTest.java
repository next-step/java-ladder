package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardTest {

    @Test
    void 공백이거나_null일_수_없음() {
        assertThatThrownBy(() -> new Reward(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 비어있을 수 없습니다.");

        assertThatThrownBy(() -> new Reward(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("보상은 비어있을 수 없습니다.");
    }
}