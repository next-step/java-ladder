package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameInfoTest {
    @Test
    void create() {
        User userA = new User("userA");
        User userB = new User("userB");
        LadderReward ggang = new LadderReward("꽝");
        LadderReward lucky = new LadderReward("당첨");
        assertThat(new LadderGameInfo(Arrays.asList(userA, userB), Arrays.asList(ggang, lucky))).isNotNull();
    }

    @Test
    void exceptionByCreation() {
        User userA = new User("userA");
        User userB = new User("userB");
        LadderReward ggang = new LadderReward("꽝");
        LadderReward ggang2 = new LadderReward("꽝");
        LadderReward lucky = new LadderReward("당첨");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGameInfo(Arrays.asList(userA, userB), Arrays.asList(ggang, ggang2, lucky));
        }).withMessage("참여할 사람과 실행 결과의 수는 같아야 한다.");

    }
}
