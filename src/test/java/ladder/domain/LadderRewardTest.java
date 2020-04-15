package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderRewardTest {
    @DisplayName("보상 랩핑 클래스 생성 테스트")
    @Test
    void create() {
        assertThat(new LadderReward("꽝")).isEqualTo(new LadderReward("꽝"));
        assertThat(new LadderReward("꽝").toString()).isEqualTo("꽝");
    }
}
